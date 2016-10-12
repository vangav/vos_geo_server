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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vangav.backend.play_framework.request.response.ResponseBodyJson;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * ResponseReverseGeoCode represents the response's structure
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseReverseGeoCode extends ResponseBodyJson {

  @Override
  @JsonIgnore
  protected String getName () throws Exception {

    return "ReverseGeoCode";
  }

  @Override
  @JsonIgnore
  protected ResponseReverseGeoCode getThis () throws Exception {

    return this;
  }

  @JsonProperty
  public double latitude;
  @JsonProperty
  public double longitude;
  @JsonProperty
  public String geo_hash;
  @JsonProperty
  public String city;
  @JsonProperty
  public String major_city;
  @JsonProperty
  public String country_code;
  @JsonProperty
  public String country;
  @JsonProperty
  public String continent_code;
  @JsonProperty
  public String continent;

  @JsonIgnore
  public void set (
    double latitude,
    double longitude,
    String geo_hash,
    String city,
    String major_city,
    String country_code,
    String country,
    String continent_code,
    String continent) {

    this.latitude = latitude;
    this.longitude = longitude;
    this.geo_hash = geo_hash;
    this.city = city;
    this.major_city = major_city;
    this.country_code = country_code;
    this.country = country;
    this.continent_code = continent_code;
    this.continent = continent;
  }
}
