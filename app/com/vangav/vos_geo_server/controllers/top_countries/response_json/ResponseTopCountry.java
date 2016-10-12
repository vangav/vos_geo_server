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

package com.vangav.vos_geo_server.controllers.top_countries.response_json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mustapha
 * fb.com/mustapha.abdallah
 */
/**
 * ResponseTopCountry represents the response's top-country
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseTopCountry {
  
  /**
   * Constructor ResponseTopCountry
   * @param countryName
   * @param countryCount
   * @return new ResponseTopContinent Object
   * @throws Exception
   */
  @JsonIgnore
  public ResponseTopCountry (
    String countryName,
    long countryCount) throws Exception {
    
    this.country_name = countryName;
    this.country_count = countryCount;
  }

  @JsonProperty
  public String country_name;
  @JsonProperty
  public long country_count;
}
