/* 
       JSON                  JSON
UI/UX------------>FE-API---------------->BE-API------------>DATABSE
     <-----------        <---------------      <-----------
      JSON                  JSON
                            |
                            |

            FE-API sends some json over the URL ; BE-AP receives the JSON from the URL 
            BE-API sends some JSON over the URL ;FE-API receives the JSON from URL
            
            RESTFUL API 
            API with get,put,delete(EG: EXPRESS FOR BUILDING RESTFUL API)

            HTTP URL
            METHOD http://www.ncb.nlm.nig.gov:3000/restful/courses/maths/value1/value2/?param1=value1&param2=value2    {  }     error
              |      |          |                  |             |            |            |                            |         |
            Methods Protocol  DomainName       api(opt)       endpoints   paramValues     query                        Body       errors      
                                                                          (String)       (String)
                                           
                                                                    
            PROTOCOL         :Protocol of transfer http is unsecured ad https is secured
            DOMAINNAME       :Client hosting service name
            API              :Client server api name
            ENDPOINTS        :Server endpoints and different end point are handled by different modules
            PARAMETER VALUES :Client passes paramValues , server catches those in params
            QUERY            :Client passes params and paramsValues , server catches those in params
            BODY             :Client passes body and server catches body 
                              RAW:
                                |-TEXT:abcdefgh
                                |-JSON:{"key1":"value1"}
                                |-XML  <head> </head>
                                |-HTML <head> </head>
                             URLENCODED:key1:value1&&key2:value2
            METHOD           :GET    --> client requests paramValues; server gets object with paramValues and sends back object 
                              PUT    --> client requests paramvalues and  body ;server gets  object with paramvalues and updates it with body 
                              POST   --> client sends body ;server adds  object with own paramvalues amd body  
                              DELETE  --> client requests paramValues; server deletes  object with paramValues and sends back object 
            ERRORS           https://www.restapitutorial.com/httpstatuscodes.html
                             200 --OK           client request sent and server response received 
                             201 --created      client request sent and server creates a resource and sends response  
                             400 --Bad Request  client request sent and server doesnt send response due to client side error   
                             404 --Not Found    client request sent and server doesnt send response due to webpage not found
                             409 --conflict     client request sent and server doesnt send response due to conflict in client request
                             500 --Int Serv Err client request sent and server doesnt send response due to generic erver error
                             
                             



 */

