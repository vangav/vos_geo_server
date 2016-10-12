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

package com.vangav.vos_geo_server.controllers.reverse_geo_code;

import java.util.Arrays;
import java.util.HashSet;

import com.vangav.backend.geo.reverse_geo_coding.ReverseGeoCode;
import com.vangav.backend.geo.reverse_geo_coding.ReverseGeoCoding;
import com.vangav.backend.geo.third_party.geo_hash.GeoHash;
import com.vangav.backend.play_framework.request.Request;
import com.vangav.backend.play_framework.request.RequestJsonBody;
import com.vangav.backend.play_framework.request.response.ResponseBody;
import com.vangav.vos_geo_server.cassandra_keyspaces.gs_top.Continents;
import com.vangav.vos_geo_server.cassandra_keyspaces.gs_top.Countries;
import com.vangav.vos_geo_server.cassandra_keyspaces.gs_top.NameIndex;
import com.vangav.vos_geo_server.common.InitIndexInl;
import com.vangav.vos_geo_server.controllers.CommonPlayHandler;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * HandlerReverseGeoCode
 *   handles request-to-response processing
 *   also handles after response processing (if any)
 * */
public class HandlerReverseGeoCode extends CommonPlayHandler {

  private static final String kName = "ReverseGeoCode";

  @Override
  protected String getName () {

    return kName;
  }

  @Override
  protected RequestJsonBody getRequestJson () {

    return new RequestReverseGeoCode();
  }

  @Override
  protected ResponseBody getResponseBody () {

    return new ResponseReverseGeoCode();
  }

  @Override
  protected void processRequest (final Request request) throws Exception {

    // use the following request Object to process the request and set
    //   the response to be returned
    RequestReverseGeoCode requestReverseGeoCode =
      (RequestReverseGeoCode)request.getRequestJsonBody();
    
    // get geo hash
    String geoHash =
      GeoHash.geoHashStringWithCharacterPrecision(
        requestReverseGeoCode.latitude,
        requestReverseGeoCode.longitude,
        12);
    
    // get reverse geo code
    ReverseGeoCode reverseGeoCode =
      ReverseGeoCoding.i().getReverseGeoCode(
        requestReverseGeoCode.latitude,
        requestReverseGeoCode.longitude);
    
    // set response
    ((ResponseReverseGeoCode)request.getResponseBody() ).set(
      requestReverseGeoCode.latitude,
      requestReverseGeoCode.longitude,
      geoHash,
      reverseGeoCode.getCity(),
      reverseGeoCode.getMajorCity(),
      reverseGeoCode.getCountryCode(),
      reverseGeoCode.getCountry(),
      reverseGeoCode.getContinentCode(),
      reverseGeoCode.getContinent() );
  }
  
  @Override
  protected void afterProcessing (
    final Request request) throws Exception {

    // get request Object
    RequestReverseGeoCode requestReverseGeoCode =
      (RequestReverseGeoCode)request.getRequestJsonBody();
    
    // get reverse geo code
    ReverseGeoCode reverseGeoCode =
      ReverseGeoCoding.i().getReverseGeoCode(
        requestReverseGeoCode.latitude,
        requestReverseGeoCode.longitude);
    
    // update continents index
    NameIndex.i().executeAsyncUpdate(
      new HashSet<String>(Arrays.asList(reverseGeoCode.getContinent() ) ),
      InitIndexInl.kContinentsIndexKey);
    
    // update countries index
    NameIndex.i().executeAsyncUpdate(
      new HashSet<String>(Arrays.asList(reverseGeoCode.getCountry() ) ),
      InitIndexInl.kCountriesIndexKey);
    
    // update continents counter's value
    Continents.i().executeAsyncUpdateCounterValue(
      reverseGeoCode.getContinent() );
    
    // update countries counter's value
    Countries.i().executeAsyncUpdateCounterValue(
      reverseGeoCode.getCountry() );
  }
}
