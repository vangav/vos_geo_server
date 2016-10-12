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

package com.vangav.vos_geo_server.controllers.top_countries;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vangav.backend.play_framework.request.RequestJsonBodyGet;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * RequestTopCountries represents the request's structure
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestTopCountries extends RequestJsonBodyGet {

  @Override
  @JsonIgnore
  protected String getName () throws Exception {

    return "TopCountries";
  }

  @Override
  @JsonIgnore
  protected RequestTopCountries getThis () throws Exception {

    return this;
  }

  @Override
  @JsonIgnore
  public RequestTopCountries fromQueryString (
    Map<String, String[]> query) throws Exception {


    return this;
  }

  @Override
  @JsonIgnore
  public void validate () throws Exception {

  }
}
