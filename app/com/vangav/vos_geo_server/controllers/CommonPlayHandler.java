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

package com.vangav.vos_geo_server.controllers;

import com.vangav.backend.play_framework.ParentPlayHandler;
import com.vangav.backend.play_framework.request.Request;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * CommonPlayHandler represents the parent handler for all controllers
 * */
public abstract class CommonPlayHandler extends ParentPlayHandler {

  @Override
  final protected void checkSource (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  @Override
  final protected void throttle (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  @Override
  final protected void authenticateRequest (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  @Override
  protected void afterProcessing (
    final Request request) throws Exception {

    // implement here or override per-controller
  }

  @Override
  final protected void dispatchDefaultOperations (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  @Override
  final protected void dispatchPushNotifications (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  @Override
  final protected void dispatchAnalysis (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  @Override
  final protected void dispatchDefaultAnalysis (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  @Override
  final protected void dispatchLogging (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  @Override
  final protected void dispatchDefaultLogging (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  // IMPORTANT: this method must be implemented within a try and catch block
  //             because any exceptions thrown by this method will terminate
  //             the service instance and disables it from handling other
  //             requests
  @Override
  protected void absorbUnhandledExceptions (
    final Exception exception) {

    // TODO: implement here or override per-controller
  }

}
