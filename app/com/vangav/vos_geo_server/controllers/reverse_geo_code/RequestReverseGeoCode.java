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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vangav.backend.play_framework.param.ParamOptionality;
import com.vangav.backend.play_framework.param.ParamType;
import com.vangav.backend.play_framework.request.RequestJsonBodyGet;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * RequestReverseGeoCode represents the request's structure
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestReverseGeoCode extends RequestJsonBodyGet {

  @Override
  @JsonIgnore
  protected String getName () throws Exception {

    return "ReverseGeoCode";
  }

  @Override
  @JsonIgnore
  protected RequestReverseGeoCode getThis () throws Exception {

    return this;
  }

  @JsonIgnore
  public static final String kLatitudeName = "latitude";
  @JsonProperty
  public double latitude;

  @JsonIgnore
  public static final String kLongitudeName = "longitude";
  @JsonProperty
  public double longitude;

  @Override
  @JsonIgnore
  public RequestReverseGeoCode fromQueryString (
    Map<String, String[]> query) throws Exception {

    this.latitude = this.getDouble(kLatitudeName, query);
    this.longitude = this.getDouble(kLongitudeName, query);

    return this;
  }

  @Override
  @JsonIgnore
  public void validate () throws Exception {

    this.validate(
      kLatitudeName,
      this.latitude,
      ParamType.LATITUDE,
      ParamOptionality.MANDATORY);

    this.validate(
      kLongitudeName,
      this.longitude,
      ParamType.LONGITUDE,
      ParamOptionality.MANDATORY);

  }
}
