// @SOURCE:/Users/mustapha/vangav/git_backend/vangav/vos_geo_server/conf/routes
// @HASH:642bae0cbcb09be79a501e0ab1f514f3a73c109b
// @DATE:Fri Sep 23 18:58:55 CEST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:16
package com.vangav.vos_geo_server.controllers.top_countries {

// @LINE:16
class ReverseControllerTopCountries {
    

// @LINE:16
def getTopCountries(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "top_countries")
}
                                                
    
}
                          
}
                  

// @LINE:10
package controllers {

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  

// @LINE:14
package com.vangav.vos_geo_server.controllers.reverse_geo_code {

// @LINE:14
class ReverseControllerReverseGeoCode {
    

// @LINE:14
def getReverseGeoCode(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reverse_geo_code")
}
                                                
    
}
                          
}
                  

// @LINE:15
package com.vangav.vos_geo_server.controllers.top_continents {

// @LINE:15
class ReverseControllerTopContinents {
    

// @LINE:15
def getTopContinents(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "top_continents")
}
                                                
    
}
                          
}
                  


// @LINE:16
package com.vangav.vos_geo_server.controllers.top_countries.javascript {

// @LINE:16
class ReverseControllerTopCountries {
    

// @LINE:16
def getTopCountries : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.vangav.vos_geo_server.controllers.top_countries.ControllerTopCountries.getTopCountries",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "top_countries"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:10
package controllers.javascript {

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        

// @LINE:14
package com.vangav.vos_geo_server.controllers.reverse_geo_code.javascript {

// @LINE:14
class ReverseControllerReverseGeoCode {
    

// @LINE:14
def getReverseGeoCode : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.vangav.vos_geo_server.controllers.reverse_geo_code.ControllerReverseGeoCode.getReverseGeoCode",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reverse_geo_code"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:15
package com.vangav.vos_geo_server.controllers.top_continents.javascript {

// @LINE:15
class ReverseControllerTopContinents {
    

// @LINE:15
def getTopContinents : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.vangav.vos_geo_server.controllers.top_continents.ControllerTopContinents.getTopContinents",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "top_continents"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:16
package com.vangav.vos_geo_server.controllers.top_countries.ref {


// @LINE:16
class ReverseControllerTopCountries {
    

// @LINE:16
def getTopCountries(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.vangav.vos_geo_server.controllers.top_countries.ControllerTopCountries.getTopCountries(), HandlerDef(this, "com.vangav.vos_geo_server.controllers.top_countries.ControllerTopCountries", "getTopCountries", Seq(), "GET", """""", _prefix + """top_countries""")
)
                      
    
}
                          
}
        

// @LINE:10
package controllers.ref {


// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
        

// @LINE:14
package com.vangav.vos_geo_server.controllers.reverse_geo_code.ref {


// @LINE:14
class ReverseControllerReverseGeoCode {
    

// @LINE:14
def getReverseGeoCode(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.vangav.vos_geo_server.controllers.reverse_geo_code.ControllerReverseGeoCode.getReverseGeoCode(), HandlerDef(this, "com.vangav.vos_geo_server.controllers.reverse_geo_code.ControllerReverseGeoCode", "getReverseGeoCode", Seq(), "GET", """ Generated routes""", _prefix + """reverse_geo_code""")
)
                      
    
}
                          
}
        

// @LINE:15
package com.vangav.vos_geo_server.controllers.top_continents.ref {


// @LINE:15
class ReverseControllerTopContinents {
    

// @LINE:15
def getTopContinents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.vangav.vos_geo_server.controllers.top_continents.ControllerTopContinents.getTopContinents(), HandlerDef(this, "com.vangav.vos_geo_server.controllers.top_continents.ControllerTopContinents", "getTopContinents", Seq(), "GET", """""", _prefix + """top_continents""")
)
                      
    
}
                          
}
        
    