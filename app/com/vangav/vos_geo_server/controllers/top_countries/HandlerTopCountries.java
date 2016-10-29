/**
 * "First, solve the problem. Then, write the code. -John Johnson"
 * "Or use Vangav M"
 * www.vangav.com
 * */

/**
 * MIT License
 *
 * Copyright (c) 2016 Vangav
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
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

package com.vangav.vos_geo_server.controllers.top_countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import com.datastax.driver.core.ResultSet;
import com.vangav.backend.data_structures_and_algorithms.tuple.Pair;
import com.vangav.backend.play_framework.request.Request;
import com.vangav.backend.play_framework.request.RequestJsonBody;
import com.vangav.backend.play_framework.request.response.ResponseBody;
import com.vangav.vos_geo_server.cassandra_keyspaces.gs_top.Countries;
import com.vangav.vos_geo_server.cassandra_keyspaces.gs_top.NameIndex;
import com.vangav.vos_geo_server.common.InitIndexInl;
import com.vangav.vos_geo_server.controllers.CommonPlayHandler;
import com.vangav.vos_geo_server.controllers.top_countries.response_json.ResponseTopCountry;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * HandlerTopCountries
 *   handles request-to-response processing
 *   also handles after response processing (if any)
 * */
public class HandlerTopCountries extends CommonPlayHandler {

  private static final String kName = "TopCountries";

  @Override
  protected String getName () {

    return kName;
  }

  @Override
  protected RequestJsonBody getRequestJson () {

    return new RequestTopCountries();
  }

  @Override
  protected ResponseBody getResponseBody () {

    return new ResponseTopCountries();
  }

  @Override
  protected void processRequest (final Request request) throws Exception {
    
    // select countries from gs_top.index
    ResultSet resultSet =
      NameIndex.i().executeSyncSelect(InitIndexInl.kCountriesIndexKey);
    
    // no countries queried before?
    if (resultSet.isExhausted() == true) {
      
      ((ResponseTopCountries)request.getResponseBody() ).set(
        new ResponseTopCountry[0] );
      
      return;
    }
    
    // extract countries index
    Set<String> countriesIndex =
      resultSet.one().getSet(
        NameIndex.kIndexValuesColumnName,
        String.class);
    
    // init top continents
    ArrayList<Pair<String, Long> > topCountries =
      new ArrayList<Pair<String, Long> >();
    
    // for each country
    for (String country : countriesIndex) {
      
      // select country's counter-value
      resultSet = Countries.i().executeSyncSelectCounterValue(country);
      
      // no data? skip
      if (resultSet.isExhausted() == true) {
        
        continue;
      }
      
      // store country name-counter pair
      topCountries.add(
        new Pair<String, Long>(
          country,
          resultSet.one().getLong(Countries.kCounterValueColumnName) ) );
    }
    
    // sort results ascending
    Collections.sort(topCountries, new Comparator<Pair<String, Long> > () {

      @Override
      public int compare (Pair<String, Long> x, Pair<String, Long> y) {

        return Long.compare(x.getSecond(), y.getSecond() );
      }
    } );
    
    // reverse sorted results to put them in a descending order
    Collections.reverse(topCountries);
    
    // fill response array
    
    ResponseTopCountry[] responseArray =
      new ResponseTopCountry[topCountries.size() ];
    
    for (int i = 0; i < topCountries.size(); i ++) {
      
      responseArray[i] =
        new ResponseTopCountry(
          topCountries.get(i).getFirst(),
          topCountries.get(i).getSecond() );
    }
    
    // set response
    ((ResponseTopCountries)request.getResponseBody() ).set(responseArray);
  }
}
