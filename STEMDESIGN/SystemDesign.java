//REMAINING
/*
Load balancing and consistent hashing
*/


//CLIENT SERVER ARCHITECTURE
/*                                                   
LOOK IN WEBDEV-ARCH.java
                             
*/



//HIGH LEVEL SYSTEM DESIGN(ARCHITECTURE)
/*
1. Horizontal and vertical scaling
2. Microservices architecture
3. Load balancer
4. Backup server 
5. Preprocessing data
6. Decoupling(Seperating concerns for each service ie service1 will only do task a service 2 will only do task 2)
*/

//HORIZONTAL AND VERTICAL SCALING
/*
Horizontal scaling(More server)        Vertical Scaling(Bigger server)
            _
 _         |_|                           _               _
|_|                                     |_|             | |
            _                                           |_|
           |_|                                           
            
            _
           |_|

client     server                      client           server                
 

1. Load balancing required           1.Load balancing not req
between client and server              between client and server 

2.Remote procedure calls(RPC)         2.Procedure calls(PC)
  between servers so slow               within server so fast

3.If one server fails                3.If server fails system
  other can take over                  fails

4.Data is shared between             4. Data is stored on 
  server so there is                    1 server so there is 
  data inconsistency                    data consistency
  
5. No hardware limit                 5. Hardware limit


Hybrid solution
Each server in horizontal scaling is vertically scaled


*/

//MICROSERVICE ARCHITECTURE AND MONOLITH ARCHITECTURE
/*
Microservice(Divide logic into service)  Monolith(Logic is not divided into service logic) 
            _
 _         |_|                           _               _
|_|                                     |_|             | |  -->Microservice and monolith are not horizontal and vertical scaling we can horizontally or vertically scale a monolith arch , its just division of logic
            _                                           |_|
           |_|                                           
            
            _
           |_|

client     server                                 
1. Scaling                                      1.Scaling
   because developers can develop,deploy,test   because developers can develop,deploy,test
   each service independently with              entire application withouttion 
   connection complication bw services          complication bw services


2.Speed                                        2.Speed
  Remote Procedure calls(RPC)                   Procedure calls(PC)
  bw services so slow                           bw entire service so fast





  






*/ 


//LOAD BALANCER(Synchronous distribution)
/*
        __     _
 _     /      |_|                       
|_|-- LB                                  
       \ _     _                            
              |_|                                           
client     server  
Load balancer assigns  task T1 to server S1 and task T2 to server2
*/

//MESSAGE QUEUING(Asynchronous distribution)
/*

        __     _
 _     /      |_|                       
|_|-- MQ                                  
       \ _     _                            
              |_|                                           
client     server                 


If we assign task T1 to server S1 and task T2 to server2; but if S1 goes down then we have lost the data
Message queue holds tasks in a queue assigns tasks to servrs and once it gets response from server it removes the task


*/