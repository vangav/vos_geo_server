/**
 * "First, solve the problem. Then, write the code. -John Johnson"
 * "Or use Vangav M"
 * www.vangav.com
 * */

/**
 * no license, I know you already got more than enough to worry about
 * keep going, never give up
 * */

/**
 * Community
 * Facebook Group: Vangav Open Source - Backend
 *   fb.com/groups/575834775932682/
 * Facebook Page: Vangav
 *   fb.com/vangav.f
 * 
 * Third party communities for Vangav Backend
 *   - play framework
 *   - cassandra
 *   - datastax
 *   
 * Tag your question online (e.g.: stack overflow, etc ...) with
 *   #vangav_backend
 *   to easier find questions/answers online
 * */

package com.vangav.vos_geo_server.controllers.top_continents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import com.datastax.driver.core.ResultSet;
import com.vangav.backend.data_structures_and_algorithms.tuple.Pair;
import com.vangav.backend.play_framework.request.Request;
import com.vangav.backend.play_framework.request.RequestJsonBody;
import com.vangav.backend.play_framework.request.response.ResponseBody;
import com.vangav.vos_geo_server.cassandra_keyspaces.gs_top.Continents;
import com.vangav.vos_geo_server.cassandra_keyspaces.gs_top.NameIndex;
import com.vangav.vos_geo_server.common.InitIndexInl;
import com.vangav.vos_geo_server.controllers.CommonPlayHandler;
import com.vangav.vos_geo_server.controllers.top_continents.response_json.ResponseTopContinent;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * HandlerTopContinents
 *   handles request-to-response processing
 *   also handles after response processing (if any)
 * */
public class HandlerTopContinents extends CommonPlayHandler {

  private static final String kName = "TopContinents";

  @Override
  protected String getName () {

    return kName;
  }

  @Override
  protected RequestJsonBody getRequestJson () {

    return new RequestTopContinents();
  }

  @Override
  protected ResponseBody getResponseBody () {

    return new ResponseTopContinents();
  }

  @Override
  protected void processRequest (final Request request) throws Exception {
    
    // select continents from gs_top.index
    ResultSet resultSet =
      NameIndex.i().executeSyncSelect(InitIndexInl.kContinentsIndexKey);
    
    // no continents queried before?
    if (resultSet.isExhausted() == true) {
      
      ((ResponseTopContinents)request.getResponseBody() ).set(
        new ResponseTopContinent[0] );
      
      return;
    }
    
    // extract continents index
    Set<String> continentsIndex =
      resultSet.one().getSet(
        NameIndex.kIndexValuesColumnName,
        String.class);
    
    // init top continents
    ArrayList<Pair<String, Long> > topContinents =
      new ArrayList<Pair<String, Long> >();
    
    // for each continent
    for (String continent : continentsIndex) {
      
      // select continent's counter-value
      resultSet = Continents.i().executeSyncSelectCounterValue(continent);
      
      // no data? skip
      if (resultSet.isExhausted() == true) {
        
        continue;
      }
      
      // store continent name-counter pair
      topContinents.add(
        new Pair<String, Long>(
          continent,
          resultSet.one().getLong(Continents.kCounterValueColumnName) ) );
    }
    
    // sort results ascending
    Collections.sort(topContinents, new Comparator<Pair<String, Long> > () {

      @Override
      public int compare (Pair<String, Long> x, Pair<String, Long> y) {

        return Long.compare(x.getSecond(), y.getSecond() );
      }
    } );
    
    // reverse sorted results to put them in a descending order
    Collections.reverse(topContinents);
    
    // fill response array
    
    ResponseTopContinent[] responseArray =
      new ResponseTopContinent[topContinents.size() ];
    
    for (int i = 0; i < topContinents.size(); i ++) {
      
      responseArray[i] =
        new ResponseTopContinent(
          topContinents.get(i).getFirst(),
          topContinents.get(i).getSecond() );
    }
    
    // set response
    ((ResponseTopContinents)request.getResponseBody() ).set(responseArray);
  }
}
