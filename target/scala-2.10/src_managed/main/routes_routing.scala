// @SOURCE:/Users/mustapha/vangav/git_backend/vangav/vos_geo_server/conf/routes
// @HASH:642bae0cbcb09be79a501e0ab1f514f3a73c109b
// @DATE:Fri Sep 23 18:58:55 CEST 2016


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:10
private[this] lazy val controllers_Assets_at0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:14
private[this] lazy val com_vangav_vos_geo_server_controllers_reverse_geo_code_ControllerReverseGeoCode_getReverseGeoCode1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reverse_geo_code"))))
        

// @LINE:15
private[this] lazy val com_vangav_vos_geo_server_controllers_top_continents_ControllerTopContinents_getTopContinents2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("top_continents"))))
        

// @LINE:16
private[this] lazy val com_vangav_vos_geo_server_controllers_top_countries_ControllerTopCountries_getTopCountries3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("top_countries"))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reverse_geo_code""","""com.vangav.vos_geo_server.controllers.reverse_geo_code.ControllerReverseGeoCode.getReverseGeoCode()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """top_continents""","""com.vangav.vos_geo_server.controllers.top_continents.ControllerTopContinents.getTopContinents()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """top_countries""","""com.vangav.vos_geo_server.controllers.top_countries.ControllerTopCountries.getTopCountries()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:10
case controllers_Assets_at0(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:14
case com_vangav_vos_geo_server_controllers_reverse_geo_code_ControllerReverseGeoCode_getReverseGeoCode1(params) => {
   call { 
        invokeHandler(com.vangav.vos_geo_server.controllers.reverse_geo_code.ControllerReverseGeoCode.getReverseGeoCode(), HandlerDef(this, "com.vangav.vos_geo_server.controllers.reverse_geo_code.ControllerReverseGeoCode", "getReverseGeoCode", Nil,"GET", """ Generated routes""", Routes.prefix + """reverse_geo_code"""))
   }
}
        

// @LINE:15
case com_vangav_vos_geo_server_controllers_top_continents_ControllerTopContinents_getTopContinents2(params) => {
   call { 
        invokeHandler(com.vangav.vos_geo_server.controllers.top_continents.ControllerTopContinents.getTopContinents(), HandlerDef(this, "com.vangav.vos_geo_server.controllers.top_continents.ControllerTopContinents", "getTopContinents", Nil,"GET", """""", Routes.prefix + """top_continents"""))
   }
}
        

// @LINE:16
case com_vangav_vos_geo_server_controllers_top_countries_ControllerTopCountries_getTopCountries3(params) => {
   call { 
        invokeHandler(com.vangav.vos_geo_server.controllers.top_countries.ControllerTopCountries.getTopCountries(), HandlerDef(this, "com.vangav.vos_geo_server.controllers.top_countries.ControllerTopCountries", "getTopCountries", Nil,"GET", """""", Routes.prefix + """top_countries"""))
   }
}
        
}

}
     