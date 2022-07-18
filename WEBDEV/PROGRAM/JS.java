
//STRUCTURE 
/*
const var = require('')                  -->IMPORT , EXPORT(ES5) , IMPORT EXPORT(ES6)
exports.fnname = fnname(){} 


global{}                                 -->GLOBAL OBJECT,WRAPPER FN(ES5), WINDOW OBJECT(ES6)
function(exports,require...){//OUR CODE}     



function circle(radius,x,y){ }           -->NAMED FN,EXPRESSION FN,ANONYMOUS FN ,                                 
                                           SYNC FN ,ASYNC FN(CALLBACK),ASYNC FN(PROMISET USING THEN-CATCH),ASYNC FN (PROMISET USING ASYNC AWAIT),PROMISE
                                           PARAMETER,ARG
                                           **FACTORY FN, CONSTRUCTOR FNS
function circle(radius,x,y){ }           -->FN DETAILS


class classnama{}                       -->NAMED CLASS, ANONYMOUS CLASS
class classnama{}                       -->CLASS DETAILS      

OBJECT                                 --> NUMBER;BOOLEAN;NULL;NaN;SYMBOL ;STRING; OBJECT ; ARRAY

EXCEPTION                              -->EXCEPTION CLASS,EXCEPTION HANDLING 

CONDITIONAL                            -->IF; WHILE, DO WHILE;FOR,FOR –IN ,FOR-OF ,ARRAY METHODS ,BREAK CONTINUE



** JS VS TS**
TYPESCRIPT : ts  shows err at runtime ; but you need extra work to run ts
JAVASCRIPT : js does not show err at run time but you can see those byjshint filename.js
EXTRA FILE FOR TS 
|-tcsconfig.json -->run tcs –init and in the created tcsconfig.json overwrite the existing code with the code in audio-transcoder(typescript)
|-typings.t.ds --> create a file with name typings.t.ds 
Run code --> run tcs which will create a equivalent .js file in dist/src ; then run node dist/src/filename.js

DIFFERENT CODE OF TS 
1.import
const readXlsxFile = require('read-excel-file/node');
                  TO
 import * as readXlsxFile from 'read-excel-file/node'; and also create a file  typings.d.ts and add declare module 'read-excel-file/node';

2.statically typed lang : so you have to write datatype or write “any” if datatype is not known 



*/


//IMPORT EXPORT
/* #region Main */

//IMPORT , EXPORT (ES5 - NODE)
/*
package.json
"type":module                         add this to allow ES6 imports in Node

module1.js    
let varname1 = "";                                  OR  module.exports.varname1 = "abc";        //only for variable and arrow fn                    
async function fnName1(){}                              module.exports.fnName1 = async() =>{}    
let fnName2 = async function fnNameOpt() =>{}    
let fnName3 = async() =>{}                 
class className1{} 
class className2{}  

module.exports = {
    fnName1,
    fnName2,
    fnName3,
    className1,
    className2
}


module2.js
var module1 = require('externalmodulename' OR './modulename1' ) 
var val = module1.fnName1(args)            
var obj = new module1.className1()     
OR
var {fnName1,className1} = require('externalmodulename' OR './modulename1') 
var val = fnName1()
var obj = new className1()   


*/

//IMPORT , EXPORT (ES6 - REACT)
/*
module1.js     
let varname1 = "abc";                              OR     export let varname1 = "abc";                         
async function fnName1(){}                                export async function fnName1(){}       
let fnName2 = async function fnNameOpt() =>{}             export let fnName2 = async function fnNameOpt() =>{}      
let fnName3 = async() =>{}                                export let fnName3 = async() =>{}                
class className1{}                                        export class className1{} 
class className2{}                                        export class className2{}                                   

export {
    fnName1,
    fnName2,
    fnName3,
    className1,
    className2
}

module2.js
import * as module1 from 'externalmodulename' OR './modulename1.js'
var val = module1.fnName1(args)            
var obj = new module1.className1()     
OR
var {fnName1,className1} from 'externalmodulename' OR './modulename1.js'
var val = fnName1()
var obj = new className1()  



**default keyword
module1.js
export default function fnName(){}            --default can be exported and imported without {}
export function fnName2(){}
module2.js
import fnName1,{fnName2} from 'module1.js' 
                                             
                                             
                                        







*/
/* #endregion */


//GLOBAL OBJECT ,WINDOW OBJECT, WRAPPER FN 
/* #region Main */


//GLOBAL OBJECT(ES5 - NODE)
/*
global {                                         --> Global Object has properties and  functions  which can be called by 
                                                      global.member OR member(node will by default put global ahead of it)
       
    setTimeout(time in  ms); --> global object’s  fn which delay the fn by t ms;
    clearTimeout();-->global object’s  fn which  stop the elay
    setInterval() --> global object’s   fn which  call a fnrepetitively after delay
    clearInterval() --> global object’s   fn which  stop calling a fn repetitively after a delay
    console.log(“msg”)-> global object’s   fn which  logs the msg
    console.error(“msg”)--> global object’s   fn which  logs the msg as red
    console.warn(“msg”)--> global object’s   fn which  logs the message as warning 
}
*/

 //WINDOW OBJECT(ES6 - BROWSER)
 /*
 window { }                                        --> Windoe Object has properties and  functions  which can be called by 
                                                      window.member OR member( browser will by default put window ahead of it)
 */

//WRAPPER FN(ES5 - NODE)
/*
function((exports , require , module, filename , __filename, __dirname)){   --> Every File is a module  and everything defined inside a module is 
                                                                                wrapped inside a fn and is  private to that module
     
        PARAMETERS OF WRAPPER FN
        module--> object 
        {
        id: '.',
        path: 'C:\\Users\\DELL\\Desktop\\JavaScript\\NodeVsCode\\VSCode\\audio-transcoder\\mitron',
        exports: {},
        parent: null,
        filename: 'C:\\Users\\DELL\\Desktop\\JavaScript\\NodeVsCode\\VSCode\\audio-transcoder\\mitron\\ztest.js',
        loaded: false,
        children: [],
        paths: [    'C:\\Users\\DE………]
        }
        module.exports.key = value; --> "module"  is a object ; in "module" object we set the "exports"  oject
        exports.key = value ;       --> "exports" is a object which we set with key value pair
        require(‘filepath’)         --> "require"  s a fn() which retuens the "module object" ka "exportobject"
                                        OR "export" object itself depending on which obj you used to export
        __filename                  --> wrapper fns parameter "__filename"  is a string which returns the filename 
         __diename                  --> wrapper fns parameter "__diename"  is a string which returns the directory in which  the file is 

  
         ///OUR CODE  
        }       
         
 */     



/* #endregion */


//FUNCTION DECLARATION(FN ARE OBJECTS)
/* #region Main */

//NORMAL FN,EXPRESSION FN,AFRROW FN
/*

fnObj   :f fnName() OR f () if we do not have fnName 
objOfFn :fnName() {member1:valu1,member2:value2 only members declared with this}

//NORMAL FN(HOISTED TO TOP)
async function fnName(param){}                      -->Declare fn which returns a fnObj
fnName(arg)                                         -->call fnObj which returns value  


async function fnName(param){}                      -->Declare fn which returns a fnObj
let objOfFn = new fnName(arg)                       -->call fnObj + new which returns objOfFn     



//EXPRESSION FN(NOT HOISTED TO TOP)
let fnObj = async function fnNameOptional(param){} -->Declare fn which returns a fnObj
fnObj(arg)                                         -->Call fnObj which returns a value  

let fnObj = async function fnNameOptional(param){} -->Declare fn which returns a fnObj
let objOfFn = new fnObj(arg)                        -->Call fnObj + "new" which returns ObjOfFn  


//AFRROW FN(NOT HOISTED TO TOP)
let fnName = async(params) =>{}                     -->Declare fn which returns a fnObj 
fnName(arg)                                         -->Call the fnObj which returns value  

let fnName = async(params) =>{}                     -->XX cant use new for arrow fn for arrow fn 
let objOfFn = new fnObj(arg)                                 |
                                                             |
                                                             member , this :Look inFUNCTIONS/MEMBER:MEMBER,THIS
                                                                                                                
EG 1(NORMAL FN):
function sum(a,b){       -->Declare Fn which returns a fnObj(f sum())
    return a+ b;
}
const obj = {
name:"pras",
sum1 : sum(1,2),        -->Call fnObj which returns a value(3)
};
console.log(obj.sum1);

EG 2(EXPRESSION FN):
a,b,c, -->Same as arrow fn just replace arrow fn with expression fn

EG 3(ARROW FN):
a.
let  sum = (a,b) =>{return a+b;}    -->Declare fn which returns a fnObj(f sum())
const obj = {
name:"pras",
sum1 : sum(1,2),                  --> Call fnObj which returns value(3)
};
console.log(obj.sum1)

b.
const obj = {
name:"pras",
sum : (a,b) =>{return a+b;},        -->Declare fn which returns fnObj(f sum())
};
console.log(obj.sum(1,2));            -->Call fnObj which returns value(3)
                                        

c.
Look in ASYNCHRONOUS FN (CALLBACK),ASYNCHRONOUS FN (PROMISET USING THEN-CATCH),ASYNCHRONOUS FN (PROMISET USING ASYNC AWAIT),

*/

//SYNCHRONOUS FN
/* 
//SYNCHRNOUS FN
function synchronousFnname(arg){
     Synchronous task;
}

//USING SYNCHRONOUSFN
synchronousFnname(par)                                   -->Start and complete  syncFn then execute code after syncFn 
Console.log(“code after calling the synchronous fn ”)
*/

//ASYNCHRONOUS FN (CALLBACK)
/*
//DECLARING ASYNCHRONOUSFN
function asyncFnName (fnParam,callBackFn) {
    code for Fn
    callBackFn(arg) ;                                 -->2.Call fnObj stored as variable callBackFn and give arg to param
}

//CALLING ASYNCHRONOUSFN  
asyncFnName (fnArg , (param)=>{                        -->1.declare fn  which returns a fnObj which is passed to variable callbackFn
            console.log();                              SO
            });                                         start executing code of asyncFnName and start executing code after asyncFnName  
Console.log(“code after calling the asynchronous fn ”)  after executing code of asyncFnName  execute callback fn with  param = arg

                                                        
*/

//ASYNCHRONOUS FN (PROMISE USING THEN-CATCH)
/*
//DECLARING ASYNCHRONOUS FN THAT RETURNS PROMISE 
let promiseName = function asyncFn(fnParam) {    -->1.Declare fn that returns a fnObj as promise
    code of asyncFnName                                   
    return new Promise ((resolve,reject)=>{ 
            resolve(arg1 )                       -->4.Call fnObj stored in resolve and give arg1 to param1
            reject(arg2)                              Call fnObj stored in reject and give arg2 to param2
    }); 
      
}

//CALLING ASYNCHRONOUSFN  
promiseName(fnArg)                                  -->2.Call the fnObj ie promise(asyncFnName(fnArg));apply then,catch on the returned promise                               
        .then((param1)=>{console.log(param1)})      -->3.declare a fn inside then  which returns a fnObj which is passed to variable resolve 
        .catch((param2) => {console.log(param2)})        declare a fn inside catch which returns a fnObj which is passed to variable reject  
                                                            
                                                         SO
                                                         start executing code of asyncFnName and start executing code after asyncFnName
                                                         after executing code of asyncFnName  it returns a promise  
                                                         if promise sucessful execute then with param1 = arg1 of resolve
                                                         if promise  failded execute catch with param2 = arg2 or reject





                                                       
*/

//ASYNCHRONOUS FN (PROMISET USING ASYNC-AWAIT)
/*
//DECLARING ASYNCHRONOUS FN THAT RETURNS PROMISE 
function asyncFnName(fnParam) {                      -->1.Declare fn that  returns a fnObj as promise
    code of asyncFnName                                  
    return new Promise ((resolve,reject)=>{ 
            resolve(arg1)                            -->4.Call fnObj stored in resolve and give arg1 to param1              
            reject(arg2)                                Call fnObj stored in reject and give arg2 to param2
    });
      
}
//CALLING ASYNCHRONOUSFN  
async function fnName(){                                          
    try{
       const param1 = await asyncFnName(fnArg);   -->2.Apply try catch on fnObj ie promise                       
     }                                               3.Step 3 happens internally and params get arg directly
    catch(param2){                                 
        console.log(param2);                 
    }
}
let val = await fnName()                         -->4.fnName is itself async so if you just call fnName you will get Promise<Pending>
        .then((result) =>[return result]);            so await fn and resolve with then and return retValue inside then 

Console.log(“code after ”)                      SO
                                                start executing code of asyncFnName and "wait"
                                                after executing code of asyncFnName  it returns a promise  
                                                if promise sucessful execute then with param1 = arg1 of resolve
                                                if promise  failded execute catch with param1 = arg2 of eject
                                                await the sync fn inside which we call await
                                                Start executing code after 
                                                NOTE: await keyword can be used only if it is wrapped inside async fn 




                                                        
*/

//PROMISE
/*
//Promise promise = new Promise((resolve,reject))
let promiseName = function asyncFnName(fnParam) {    -->Declate Fn return fnObj as promise
    code for Fn 
    return new Promise ((resolve,reject)=>{ 
            resolve(arg1 )                               
            reject(arg2)                               
    });     
}
OR
Promise promiseName = new Promise((resolve,reject) =>{  -->return promise  directly
    resolve("foo");
    reject("bar");
});

promiseName(fnArg)                                    -->apply then,catch on foObj ie Promise                                              
        .then((param1)=>{console.log(param1)})              
        .catch((param2) => {console.log(param2)})     



//Promise.resolve()
let promiseName = function asyncFnName(fnParam) {    -->Declate Fn return fnObj as promise
    code for Fn                                    
    return  Promise.resolve(arg1);
}
OR
const promiseName =  Promise.resolve(arg1);         -->return promise  directly

promiseName(fnArg)                                  -->apply then,catch on the fnObj ie Promise                                                   
        .then((param1)=>{console.log(param1)})       (as we use Promise.resolve()) we can only use then)           
          
//Promise.reject()
let promiseName = function asyncFnName(fnParam) {   -->Declate Fn return fnObj as promise
    code for Fn                                    
    return  Promise.reject(arg1);
}
OR
const promiseName =  Promise.reject(arg1);         -->return promise  directly

promiseName(fnArg)                                ->apply then,catch on the fnObj ie Promise                                                    
        .carcg((param1)=>{console.log(param1)})     (as we use Promise.reject()) we can only use catch)               


//Promse.all()
Promise.all([P1,P2,P3]              Collect all promises in an array
             .then((results) => {})  If all promises resolve hence then is executed and results= [arg1,arg2,arg3] of resolve  
             .catch(results) =>{})   If even 1 promise rejects hence catch is executed and results= [arg1,arg2,arg3] of reject  

EG1:
const p1 = new Promise((resolve, reject) => {
    console.log('The first promise has resolved');
    resolve(1);
    reject(10);
});
const p2 = new Promise((resolve, reject) => {
    console.log('The second promise has resolved');
    resolve(2);
    reject(20);
});
const p3 = new Promise((resolve, reject) => {
    console.log('The third promise has resolved');
    resolve(3);
     reject(20);
});

Promise.all([p1, p2, p3])                      
.then((results) => {console.log(results);})   -->All promises resolve  hence then is executed and results= [1,2,3] 
.catch((results) => {console.log(results);});    OP
                                                The first promise has resolved
                                                The second promise has resolved
                                                The third promise has resolved
                                                Results: 10,20,30
                                                Total: 60

EG2:
const p1 = new Promise((resolve, reject) => {
    console.log('The first promise has resolved');
    resolve(1);
    reject(10);
});
const p2 = new Promise((resolve, reject) => {
    console.log('The second promise has rejected');
    reject(20);
});
const p3 = new Promise((resolve, reject) => {
    console.log('The third promise has resolved');
    resolve(3);
    reject(30);
});

Promise.all([p1, p2, p3])
.then((results) => {console.log(results);})
.catch((results) => {console.log(results);});-->1 promise rejects hence catch is executed and results = [20]


*/

//PARAMETER ; ARGUEMENT 
/*
//NORMAL PARAMETERS
fnname(parameter){                              -->PROVIDES VALUE TO PARAM ; IF PARAM > ARG REMAINING PARAM = UNDEFINED ; IF ARG > PARAM REMAINING ARG IGNORED 
                                                   (DEFAULT PARAM)            (REST PARAM)


//DEFAULT PARAMETER(EG 1)
fnname(parameter = value){                         -->PROVIDES DEFAULT VALUE TO PARAM AND  IF ARG PASSES VALUE OVERRIDE
     OR                                               DEFAULT  PARAM MUST BE LAST
     let parameter = parameter|| defaultvalue :       EG1


//REST PARAMETERS, SPREAD ARGUEMENTS
fnName(a,...arr){}                                  -->COLLECTS REMAINING ARG IN ARRAY  CALLED "ARRAYNAME" AND  REST PARAMETER MUST BE LAST PARAMETER
fnName(...arr)                                      -->SPREADS THE ELEMENTS OD ARR INTO INDIVIDUAL ELEMENTTS 
                                                       Note: ...arr as parameter is rest parameter ; ... arr as arguement is spread parameter
                                                       EG2
                
//ARGUEMENT KEYWORD
fnname(parameters){
       arguments                                    -->COLLECTS REMAINING ARG IN ITERATOR  CALLED "ARGUEMENT"  
                                                      EG3

                                                            

Eg1
functon sum(a,b,c = 3){
   let a = a||1;let b = b||2 ; }

sum()

EG2
function sum(a,...NUMS){   --> collects remaining args into arr called "num" [2,3,4,5,6]
    return  name.reduce((a,b) =>a + b );}
sum(1,2,3,4,5,6)

Math.min(...arr)    -->spreads the elements of arr/obj  into individual elements and  give those elements as arguements to min so it will be Math.min(1,2,3,4,5)


Eg3
function sum(){                       
let total = 0;
for(i of arguments){total = total + i;}
return total;
}
let total = sum(1,2,3,4,5,6,7);





*/


//**FACTORY FN AND CONSTRUCTOR FN**
/*
FACTORY FN                                      CONSTRUCTOR FN
function  circle(radius){ -->PASCAL CASE        function   Circlr(radius) {-->CAMEL CASE
    return {                                      
        radius ,                                     this.radius = radius
        draw(){                                      this.draw = function(){
            console.log(radius);                       console.log(radius)''
        }                                            }
    }                                             }

let var =fnName(arg)-->If fn returns obj(normal obj)     let varname = new FnName(arg)-->If fn returns an obj(ObjOfFn)   
                      without new keyword                                                with new keyword 
                      it is called factory fn                                            it is called constructor fn

*/



/* #endregion */


//FUNCTION(FN ARE OBJECTS)
/* #region Main */

//function fnName { -->CAMEL CASE
        //MEMBERS:MEMBER,THIS 
        /*
        member=members are acessed by objOfFn having values of "this"
              EG1-EG6
        this  =objOfFn 
              =parent objOfFn/obj(EG 6) if fn doesnt have obOfFn(default parent is window obj/global obj OR undefinded('use strict' sets value of this to undefined to prevent updation of window obj) )
               EG1- EG6
              =changinhg this
                fnObj(arg1,arg2)                      --this = whatever it is
                fnObj.call(obj,arg1,arg2)             --For fnObj sets the value of this = obj  and hence only for that particular call (args are taken normally)
                fnObj.apply(obj,[arg1,arg2])          --For fnObj  sets the value of this = obj and hence only for that particular call (args are taken in array)
                fnObj2 = fnObj.bind(obj)              --For new fnObj sets the value of this = obj and hence for all future calls      (arg taken on fnObj2)
                fnObj2(arg1,arg2)                      **fnObj cant be arrow fn 
                                                        EG-7,8,9            
            
        EG1:
        function calculate(){           -->declare fn which returns fnObj(f calculate())
            console.log(this)              //this = parent objOfFn as fn doesnt have objOfFn  = Window {}/global {} OR undefined
            let val = 111;
            let sum  = function(a,b){
                console.log(this);         //this =  parent objOfFn as fn doesnt have objOfFn   = Window {}/global {} OR undefined
                return a+b;
            }
        }
        let calculate1 = calculate(); -->call fnObj which returns val(3)
                                         members cant be acessed as objOfFn is not present


        EG2:
        function calculate(){           -->declare fn which returns fnObj(f calculate())
            console.log(this)              //this = parent objOfFn as fn doesnt have objOfFn  = Window {}/global {} OR undefined 
            this.val = 111;
            this.sum  = function(a,b){
                console.log(this);         //this = parent objOfFn as fn doesnt have objOfFn = Window {}/global {} OR undefined 
                return a+b;
            }
        }

        calculate();                 -->call fnObj which returns val(3) 
                                         //members cant be acessed as objOfFn is not present   


        EG3:
        function calculate(){           -->declare fn which returns fnObj(f calculate())
            console.log(this)             //this = objOfFn  = calculate1 = calculate {} 
            let val = 111;
            let sum  = function(a,b){
                console.log(this);        //this = parent objOfFn as fn doesnt have objOfFn    = calculate1 = calculate {} 
                return a+b;
            }
        }

        let calculate1 = new calculate(); -->call fnObj + new which returns objOfFn(calculate1 = {} )
                                             //members cant be acessed as objOfFn is  present but doesnt have values
        
        EG4:
        function calculate(){                   -->declare fn which returns fnObj(f calculate())
            console.log(this)                     //this =  objOfFn  = calculate1 = {val:111, sum:f ()}  
            this.val = 111;
            this.sum  = function(a,b){
                console.log(this);                //this = parent objOfFn as fn doesnt have objOfFn  = calculate1 = calculate {val:111, sum:f ()}  
                return a+b;
                }
            }
        }
        let calculate1 = new calculate();    -->call fnObj + new which returns objOfFn  (calculate {val:111, sum:f ()} )  
        calculate1.val;                        //members can be acessed as objOfFn with this values present
        calculate1.sum(1,2); 
            
        
        EG5:
        function calculate(){                -->declare fn which returns fnObj(f calculate())
            console.log(this)                      //this =  objOfFn  = calculate1 = calculate {val:111, sum:f ()}  
            this.val = 111;
            this.sum  = function(a,b){
                console.log(this);                //this = objOfFn  = sum1 = sum {}
                return a+b;
                }
        }
        
        let calculate1 = new calculate();     -->call fnObj + new which returns objOfFn(calculate {val:111, sum:f ()})   
        let sum1 = new calculate1.sum();        sum1 = {sum: f()}
        calculate1.val;                         members can be acessed as objOfFn with this values present
        calculate1.sum(1,2); 
 
       

        EG6
        function sum(){                    -->declare fn which returns fnObj(f sum())
            console.log(this);
            let video = {
                tittle:"pras",
                play:function(){
                    console.log(this);      //this = parent obj as fn doesnt have objFn= video{title:"pras",play:f ()}}
                }
            }

            return video;
        }

        let sum1 = sum();               -->call fnObj which returns value(video{title:"pras",play:f ()})
        sum1.play();

        EG 7:
        function sum(a, b) {console.log(this);}          //this =  parent objOfFn as fn doesnt have objOfFn   = Window {}/global {} OR undefined
        OR function sum = (a,b) =>{ console.log(this);}          
        sum(1,2);              


        function sum(a, b) {console.log(this);}         //this = obj for 1st call ; this = window for 2nd call
        var obj = {firstname: 'Prasann',lastname: 'Patil'};
        sum.call(obj,1,2);                               (fn cant be arrow fn)
        sum(1,2)            

        function sum(a, b) {console.log(this);}         //this = obj for 1st call ; this = window for 2nd call
        var obj = {firstname: 'Prasann',lastname: 'Patil'};
        sum.apply(obj,[1,2]);                             (fn cant be arrow fn)
        sum(1,2)               

        function sum(a, b) {console.log(this);}         //this = obj for 1st call ; this = obj for 2nd call
        var obj = {firstname: 'Prasann',lastname: 'Patil'};
        let summ = sum.bind(obj)                          (fn cant be arrow fn)
        summ(1,2);          
        summ(1,2);          


        EG 8
        let video = {
            tittle:'a',
            tags:['a','b','c'],
            play:function(){
            console.log(this);                  //this = parentObjFn as Fn doesnt have objOfFn =  video {}
            this.tags.forEach(function (tag){    
                console.log(this );               //this = parentObjFn as Fn doesnt have objOfFn =  Window {}                                                                       
                } ); 
            }
        }
        video.play(); 


        let obj = {name:"pras"};
        let video = {
            tittle:'a',
            tags:['a','b','c'],
            play:function(){
            console.log(this);                  //this = parentObjFn as Fn doesnt have objOfFn =  video {}
                this.tags.forEach(function (tag){    
                console.log(this );               //this = obj{}                                                                       
                }.bind(obj) );                     (fn cant be arrow fn)
            }
        }
        video.play();

        EG 9
        arr  = [1,2,3];

        arr.forEach((ele) => {
        console.log(this);  //this = parentObjFn as Fn doesnt have objOfFn =  window {}
        });   

        let obj = {name:"prasann"};
        arr.forEach(function(ele){
        console.log(this);  //this = obj{}
        }.bind(obj));         (fn cant be arrow fn)
        OR
        arr.forEach(function(ele) {
        console.log(this);  //this = parentObjFn as Fn doesnt have objOfFn =  window {}
        },obj);              (fn cant be arrow fn)
                                **array takees this value as an arguement also (Look in OBJECTS/ARRAY) 


        */

      
        ////INSTANCE MEMBERS////  --->Members of Fn
        //INITIALISE
        /*
         let   angle = 20;     --> private scope : cannot be acessed outside fn
         this.radius = radius; -->public scope : can be acessed outside fn using fnObj
                                (Explained above in MEMBERS:MEMBER,THIS )
         */                     
        
        //GETTER , SETTER 
        /*
         this.getAngle = function(){        -->public scope : can be acessed outside fn using fnObj       
            return angle;}

         this.setAngle = function(value){               
            angle = value;}
         OR
         Object.defineProperty(this,"angle",{
            get:function(){
                    return angle; },
            set:function(value){
                    angle = value;

            }
        })

         */
  
        //METHODS
        /*
        let area= function(){             --> private scope : cannot be acessed outside f
                return radius*radius; }       

        this.calculate = function(){     -->public scope : can be acessed outside fn using fnObj
                let ar = area();            
                let ch = chord();            
                return ar;
        }    
        */    
    

        ///PROTOTYPE,INHERITED MEMBERS//// -->Prototype Members:Members of ParentFn ka PrototypeFn  ;Inherited members:Instance members of ParentFn 
        /*
        INHERITANCE CHART
                ------------ ParentFn.prototype
                |                   |
        ChildFn.prototype           |
                |                   |
        ChildFn                 ParentFn Fn 
        
        function ParentFn(height){
            this.height = height;
            this.bark = function(){ console.log("oo");}
        }

        function ChildFn(height , size)                          
            ParentFnN.call(this, height);                         //syntax to inherit                      
            this.size = size;
        }                                    
                                                                  //INHERIT
        ChildFn.prototype = Object.create(ParentFn.prototypte)    childFn inherits prototype members  of parentFn.prototype 
        ChildFn.prototype.constructor = ChildFn                   childFn inherits prototype members  of childFn.prototype  
        OR
        ChildFn.prototype = new ParemtFn()                        childFn inherits prototype members of parentFn.prototype and instance members members ParentFn
        ChildFn.prototype.constructor = ChildFn                    
    
                                                                    //ADD      
        ParentFn.prototype.bark = function(){ console.log("gg"); }  add prototype members to ParentFn.prototpye
        ChildFn.prototype.bark = function(){ console.log("gg"); }   add prototype members to ChildFn.prototpye  

                                                                    //OVERRIDE
        ChildFn.prototype.bark = function(){ console.log("gg"); }    override prototype members of ParentFn.prototpye 
        ParentFnFn.prototype.bark = function(){console.log("gg"); }  override prototype members of ChildFn.prototpye 

                                                                     //EXTEND
        ParentFn.prototype.bark = function(){                         extend prototype members of Parent.prototpye 
                Parent.prototype.bark.call(this);   
                Console.log(“gg”);
        }
        ChildFn.prototype.bark = function(){                         extend prototype members of ChildFn.prototpye 
                Parent.prototype.bark.call(this);   
                Console.log(“gg”);
        }

        //
        */



/* #endregion */


//CLASS  DECLARATION(CLASSES ARE OBJECT;CLASSES ARE SYNTATICAL SUGARCOAT OVER  FUNCTION)
/* #region Main */

//NORMAL, EXPRESSION CLASS 
/*
fnObj    :f className() OR f () if we do not have className(class is sugarcoat over fn ) 
objOfFn  :className() {member1:valu1,member2:value2 only members declared with this}

//NORMAL CLASS(HOISTED TO TOP)
class className{}                              -->Declare class which returns a classObj
let objName = new className(arg)               -->call classObj + new which returns objOfClass


//EXPRESSION FN(NOT HOISTED TO TOP)
let fnObj = class fnNameOptional{}                -->Declare class which returns a classObj(class is sugarcoat over fn )
let objOfFn = new fnObj(arg)                      -->Call classObj + "new" which returns objOfClass                                       
*/


/* #endregion */
   

//CLASSES(CLASSES ARE OBJECT;CLASSES ARE SYNTATICAL SUGARCOAT OVER  FUNCTION)
/* #region Main */

//class classNae extends parentClassName{ -->CAMEL CASE
        //MEMBERS:MEMBER,THIS
        /*
        Same as Fn
        */

        ////INSTANCE MEMBERS////  --->Members that belong to the object
        //CONSTRUCTOR INITIALISE
        /*
        constructor(radius1,radius2){
            super()                                        -->super() must be calld to inherit superclas constructor must be called in constructor  
            this.radius = radius;                          -->public scope: they ae available outside class
            this.draw = function(){}                          (Explained above in MEMBERS:MEMBER,THIS )
        }                                             

         */                     
        
        
        //GETTER , SETTER 
        /*
         this.getAngle = function(){        -->public scope : can be acessed outside fn using classObj       
            return angle;}

         this.setAngle = function(value){               
            angle = value;}

         */
  
        //METHODS
        /*
        this.calculate = function(){     -->public scope : can be acessed outside fn using classObj
                let ar = area();            
                let ch = chord();            
                return ar;
        }    
        */    
    

        ///PROTOTYPE,INHERITED MEMBERS//// -->Prototype Members:Members of ParentFn ka PrototypeFn  ;Inherited members:Instance members of ParentFn 
        /*
        INHERITANCE CHART
                ------------ ParentClass.prototype
                |                   |
        ChildClass.prototype        |
                |                   |
        ChildClass                 ParentClass
        
        function ParentClass(height){
            this.height = height;
            this.bark = function(){ console.log("oo");}
        }

        class ChildClass extends ParentClass(height , size)  -->syntax to inherit        

                                                //INHERIT
                                                childClass inherit prototype members of parentClass.prototype  and ParentClass ke instance members
                                                childClass inherit prototype members of childClass.prototype

                                                //ADD      
        fnName(){ console.log("gg"); }          add prototype members to ChildClass.prototpye 
                                                (Fn declarations without this  are added as prototypoe members to childClass)
        
                                                //OVERRIDE
        fnName(){ console.log("gg"); }          add prototype members to ChildClass.prototpye 
                                                (Fn declarations without this  are added as prototypoe members to childClass)

                                                //EXTEND
         fnName(){                               extend prototype members of ChildClass.prototpye 
            super.fnName();                      (Fn declarations without this  are added as prototypoe members to childClass)
            consol.log(“mve2”)}
         }                                                       

        
    


        //
        */

/* #endregion */


//OBJECTS
/* #region Main */

//(  

    //DECARATION
    /*
    VAR DECLARATION
    var varname = object--> can be declared without being initialized , value can be changed and reassigned
                            global scope or functional scope(available within entire fn), attaches value to window obj

    LET DECLARATIPN
    let varname = object--> can be declared without being initialized , value can be changed and reassigned
                            block scoped available inside only code block , doesn’t attach value to window object(top level obj in JS)  
    CONST DECLARATION
    const varnam = object--> cannot  be declared without being initialized , value cannot  be changed, block scoped
                            block scoped available inside only code block) , doesn’t attach value to window object(top level obj in JS)  
                            hoisted on top
                            EG
                            #let declaration
                            for(let i = 0 ; i<=5;i++) {}-->(i is code bloc scoped and  is not acessible outside

                            let a = 2-->;   window.a doesn’t exist

                            let a = [1,2,3,4]
                            a[1] = 22 --> we can change value 
                            a = [5,6,7,8,] --> we can reassign


                            #const  declaration
                            for(const  i = 0 ; i<=5;i++) {}-->i is code bloc scoped and  is not acessible outside

                            constt a = 2-->;   window.a doesn’t exist

                            const  a = [1,2,3,4]
                            a[1] = 22 --> we can change value 
                            a = [5,6,7,8,]  X we cant reassign


                            #var declaration
                            for(var j = I ; j <=5 ; j++){} -->i is code bloc scoped and  is not acessible outside

                            var b = 2;   --> window.b returns 2 which is bad

                            var  a = [1,2,3,4]
                            a[1] = 22 --> we can change value 
                            a = [5,6,7,8,] --> we can reassign


    SPREAD OPERATOR;REST PARAMETERS, SPREAD ARGUEMENTS
    ...arr/obj  -->spreads the elements into individual elements
                    #COPY
                    obj2 = {...obj}  -->returns new copy arr/obj (spreads the elements of arr/obj  into individual elements and  put those elements into new arr/obj and return new arr/obj
                    arr2 = [...arr] 

                    #CONCATENATION
                    obj = {...obj1,..obj2}  -->returns new concatenated arr/obj (spreads the elements of arr1/obj1 , arr2/obj2  into individual elements and  put those elements into new arr/obj and return new arr/obj
                    arr = [...arr1,..arr2]


    fnName(a,...arr){}-->collects remaining argumenets passed into array called "arr" and rest parameters must be last 
    fnName(...arr)    -->spreads the elements of arr/obj  into individual elements and  put those elements into new arr/obj and return new arr/obj
                        Note: ...arr as parameter is rest parameter ; ... arr as arguement is spread parameter
                        EG
                        function sum(a,...NUMS){   --> collects remaining args into arr called "num" [2,3,4,5,6]
                            return  name.reduce((a,b) =>a + b );}
                        sum(1,2,3,4,5,6)

                        Math.min(...arr)    -->spreads the elements of arr/obj  into individual elements and  give those elements as arguements to min so it will be Math.min(1,2,3,4,5)


    OBJECT DESTRUCTURE
    [a,b,...rest] = arr  -->Destructure the object by pattern matching on left and right 
    {a,b,...rest} = obj     arr:match the variables with elements                     ; variables must be equal to obj.length as we match values
                            obj: match the variables with the key and give them value ; variables can be less that obj.length as we match keys
                            EG
                            let employee = {id:12 ,name:'pras',surname:'patil'}
                            let list = [1,2,3,4,5,6,7]

                            let {name} = employee  -->name = 'pras'
                            let [a,...b] = list   -->a = 1 ; b = [2,3,4,5,6]

                                                                                                            



    









    */
    //CONVERSION(CONVERSION OP)
    /*
            i.toSTring()                        s.split(RE)
    number --------------------> string ------------------------------> arr
          <--------------------          <---------------------------
            parseInt(i)                     arr.join(seperetor)



    */
    //COMPARISION(COMPARISION OP, LOGICAL OP , INCLUSION OP)
    /*
    COMPARISION OPERATOR
    PRIMITIVE :== ,<=,>= ,!=/=== !== ;   -->Compare values/values + datatype                         ** = is assignment operator           
    REFERENCE : equals()             ;== -->compare values + datatype;compare reference
                |                            EG
                |                           i1 == ,<=,>= ,!=/=== !== i2  -- return boolean by comparing  values/values + datatype  of integers 
          You need to write this fn         s1 == ,<=,>= ,!=/=== !== s2   --return boolean by comparing  values/values + datatype  of string 
          function equals(a,b){                                             Eg:int i1 = 3;String s1 ='3'
              return d1.a == d2.a && d1.b == d2.b                            i1 == s1 -- true  ; i1 === s1 -- false
}
                                            arr1.equals(arr2)            -- returns boolean by comparing value/value + datatype of arr1,arr2
                                            arr1== arr2                  -- returns boolean by comparing  reference  of arr1,arr2


                                            obj1.equals(obj2)            -- returns boolean by comparing value/value + datatype of obj1,obj2
                                            obj1== obj2                  -- returns boolean by comparing  reference  of obj1,obj2


                                            Dog d1 = new Dog(1,2,3);
                                            Dog d2 = new Dog(1,2,3);
                                            Dog d3 = new Dog(4,5,6);
                                            d1.equals(d2) -->True as bth object have same value
                                            d1.equals(d3)--> false as both object hve different value
                                            d3 = d2
                                            d1 == d2 --> False as  both reference different objects
                                            d2 == d3 -->True as both referennce same objects

                                        


    LOGICAL OPERATOR    
    &&                               -->go on till values are true and return false if value is false   ** & | ^ are bitwise operators
    ||                               -->goes till value is true returns if value is true)    
    !                                -->not            
                                        FALSY VALUE-->return false  
                                        0, “” , false ; null, unefined ; Nan              
                                        TRUTHY VALUE -->return true along with value    
                                        all except falsy)          
                                        EG                                                                                                                
                                        true && “” && true-->return  “ ”                                                                        
                                        1||2||false --> return 1                                                                                    
                                        1 && 2 && “ ” && 3 --> return “”  
          
        
    //INCLUSION OPERATOR
      in                           -->returns true if obj1 is in obj 2                        
                                      Eg let obj ={ x:”hello”,y:2 }  “hello” in obj --> returns true     

    */
    //DATATYES(DATATYPE OP)
    /*
    DATATYPE OPERATOR
    typeof(operand)            -->returns  datatype of operand
    obj instanceOf constructor --> returns true if obj is instance of class
    EG
    const auto = new Car('Honda', 'Accord', 1998); -- returns true if auto is instance of Car
    if(auto instanceof Car)
    */
    //IP OP
    /*
    Ip – don’t know


    Console.log(“string”)  --> takes string only
    */

//)


            /*
            PRIMITIVE TYPE                                REFERENCE TYPE
            var a= object  -->holds object                reftype a = object-->holds reference to object           
                            __________                                        ____________          
                            |  var  a |  ---->Obj                             |  Ref class |   --->  Object
                            |_________|                                       |____________|           
                                


                                    | 
                                    |              **Arrays.eqauals(arr1,arr2)   specific to arrays                                                                                                             
            1.REF TYPE :shared by  ref( var.met() ;  ref-->var1==var2 value-->var1 .equals(var2))              PRIMIRIVE TYPE: shared by  value(var.meth() ; == )
            2.MUTABLE  :change in place (2 applications in eg2)                                                IMMUTABLE :change by forming copy (2 app eg2)
            3.ITERABLE :We can iterate over the object                                                         INITERABLE: convert OR use fns return iterable


            EG1(REF , PRIMITIVE)
            PRIMITIVE TYPE                           (int is primitove so shared by value)
            Int a = 22                  a -----22    
            Int b = 33                  b ------33
            c = b                       c -------33

            REF TYPE                                (Book  is reference  so shared by reference )
            Book b = new Book()    b ------Book()                      
            Book c = new Book()    c ------Book()   reference = 2(b,c)          -> active ref = 2 ;null ref = 0
                                                    Object = 2 (Book() Book())  -> reachable obj = 2 ; abandoned obj = 0

            Book b = new Book()  b ------ Book()                      
            Book c = new Book()  c ------ Book()    reference = 3(b,c,d)        -> active ref = 3 ;null ref = 0
            d = c                d------/           Object = 2 (Book() Book())  -> reachable obj = 2 ; abandoned obj = 0
            (d ref to c)

            Book b = new Book()  b ------- Book()   reference = 2(b,c)           -> active ref = 2 ;null ref = 0
            Book c = new Book()   c  -----/ Book()  Object = 2 (Book() Book())   -> reachable obj = 1 ; abandoned obj = 1
            c = b                                                  
            (c ref to book2 is broken)

            Book b = new Book()    b ------- Book()   reference = 2(b,c)          -> active ref = 1 ;null ref = 1
            Book c = new Book()    c           Book() Object = 2 (Book() Book())  -> reachable obj = 1 ; abandoned obj = 1
            c = b                                |--------null                  
            (c ref to book2 is broken)
            c= null
            (c ref to book1 broken)                  
                        

                        
            Book b = new Book()  b ------ --Book()                      
            Book c = new Book()  c ------/  Book()  reference = 3(b,c,d)          -> active ref = 3 ;null ref = 0
            d = c                d---- /            Object = 2 (Book() Book())    ->reachable obj = 1 ; abandoned obj = 1
            (d ref to c)
            c = b
            (c ref to book 2 is broken)           

            EG2(MUTABLE IMMUTABLE)
            IMMUTABLE
            String  x = “pras”    x ----->pras
            String y = x + “pat”  x----->”pras”         (String is immutable ;  changes by forming copy)
                                Y --->”praspat”


            String x = “pras”     x------>”pras”  
            String y = x          y------/

            y = “pat”                x ------->”pras”  (string  is immutable so change  by  forming copy)
                                    y --------->”pat”
                                                                
            MUTABLE
            int[] arr1 = {1,2,3,4}   arr1  ----->{1,2,3,4}  
            arr1[1] = 5              arr1  ----->{1,5,3,4}  (array  is mutable ;  so  changes in place)



            int[] arr1 = {1,2,3,4}    arr1 ---->{1,2,3,4}   
            int[] arr2 = arr1         arr2 -------/

            arr2[1]  = 5             arr1 -------------{1,2,5,4}   (array   is mutable so change  in place)
                                    arr2 -------------/
            
            EG3(Iterable , initerable)
            for(i in arr)              -->array is iterable hence we can iterate
            for(i in str.toCharArray()) --> string is initerable hence convert to array
            for(keys in maps.keys())      --> maps is initerable so use maps,keys() which retuen array of keys                                                                                                                    

            */
//          |          
//          |
//NUMBER -->PRIMITIVE ; IMMUTABLE ; INITERABLE
/*
let num = 1; 1.0022;( new Number()  is default constructor fn that returns the number literal  22 )

** Calculation with fractional nos are not guaranteed to be precise

1. lookup , insert , length
--

2. Slicing
--
3.Fns
(Math is an object)
Math.max(a,b) -> takes int a  b finds max and returns int     
Math.min(a,b) -> takes int a b finds minand returns int
Math.round(a) ->takes float  rounds it and  returns    int
Math.ceil(a) -> takes double and  ceils  it and  returns    float
Math.floor(a) -> takesdouble  floors  it and  returns    int
Math.sqrt(a) -> takesdouble  squareroots it  and  returns    int
Math.randdom() -> gives random double value bw 0(incl) ,1(excl)
*/

//BOOLEAN -->PRIMITIVE ; IMMUTABLE ; INITERABLE
/*
let bool= true/false

1. lookup , insert , length
--

2.slicing
--
3.fns
--
*/


//SYMBOL-->PRIMITIVE ; IMMUTABLE ; INITERABLE
/*
let varname = Symbol() --> Symbol returns a unique value for every call so let s1 = Symbol() ; let s2 = Symbol() s1 !== s2

1. lookup , insert , length
--

2.slicing
--
3.fns
--
*/

//NULL, UNDEFINED,NaN,
/*
let varname = null      -->var is  declared and initialised null (null is a obj)  typeOf(null) ->returns object
let varname = NaN       --> var is  declared and initialised NaN (NaN is a obj; usually an err cond instead of valid no eg converting”p” to no)
letvarname = undefined --> var is declared but not initialised (undefined is itself a type)
                        **typeOf(null/NaN/undefined) -->return Object /Object/Undefined
                        **null*2 ; undefined*2 --> return NaN
                        **2+3 +”5” -->return 55
1. lookup , insert , length
--

2.slicing
--
3.fns
--
*/

//STRING  -->PRIMITIVE ; MUTABLE;IMITERABLE
/*
let s = “prasann”  (new String()  is default constructor fn that returns the string literal “” )
      = 'prasann'
      = `prasann ${varname}`



1. lookup , insert , length
#lookup
charat(index)/s[index]      --> returns the character at given index
indexOf(“as”)               -->returns first index of character
contains(“as”)              --> returns presence of character      


#insert
s.add()   X     s = s+ “stringorCharactertoAdd”                 -- returns a new string by adding character
s.remove()x     s.replace(“char 1”,”char2” OR ‘RE1’ , ’RE2’ )   -- returns new string replacing 1st occurenc of char1 by char2
            

#size
s.length                             -> returns length of string



2.slicing
#slicing
s[index] --> returns character  at index
s.trim(); - returns a new string by removing  whitespace before and after string
s.trimleft()--> returns a new string by trimming all white space before string
s.trimright()--> returns a new string by trimming all white space after string
s.split(‘RE’) – returns a new string by splitting  string at RE not including RE and returns list ofsplitted elements

#concatenate
s = s+ “stringorCharactertoAdd” --> returns a new string by adding character
s = s.concat(s1,s2,…)           -->return a new string by concatenating s1ms2

EG
s = "X-DSPAM-Confidence:    0.8475"
s1 = s.rstrip().split() #s2 is a list seperated by space  not including space([''X-DSPAM-Confidence','0.8475']
s = "i'mSPAMaSPAMlumberjack"
s1  = s.rstrip().split("SPAM")  # string seperated by SPAM not including spam["i'm", 'a', 'lumberjack']


3.fns
--
*/


//OBJECTS -->REFERENCE ; MUTABLE ; ITERABLE  FOR MEMBERS WHOSE ENUMERATE = TRUE)
/*
let  obj = {key: value ; key : value}; (new bject({key:value}) is default  constructor which returns object literal {})
                         |
                    members   :properties and methods are members
                    properties:keys with value = any primitivre, reference
                               EG : radius :20 OR radius;  (if radius:radius  ie key value same) 
                    methods   :keys with value = fn
                               EG : area:function(){} OR  function(){}

1. lookup , insert , length
#lookup
obj.staticKey/obj["staticKey"] OR object[dynamicKey]     --> return the value at dynamickey(key not known) , statickKey(key known)
Object.keys(obj)                      --> return  array of keys of instance members whose enumerate = True 
Object.entries(obj)                   --> return arrays of  arrays of key value pair of  instance members whose enumerate = True 
                                           



#insert
obj.staticKey/obj["staticKey"] OR object[dynamicKey]  =val -->add key value
obj.staticKey/obj["staticKey"] OR object[dynamicKey]  =val  -->set key value
delete obj.staticKey/obj["staticKey"] OR object[dynamicKey]                     --> delete object members
            

#size
--


2. slicing
#sluce
object[dynamicKey]                         --> return the value at dynamickey(key not known) 

#COPY
obj2 = {…obj1}                            -->returns new copy object (spreads the elements of object  into individual elements and  put those elements into new object and return new obj

#concatenate 
obj = {...obj1,..obj2}                         -->returns new concatenated obj(spreads the elements of obj1,obj2 into individual elements and  put those elements into new object and return a new obj
obj = Object.assign(target obj,source objects)  -->returns new concatenated object  by copying  all source objects into target object
                                                 EG let circle2 = Object.assign({r:22}, circle)






3.fns
for(let i in obj ){}             --> i = key1 , key2...
for(let i of Object.keys(obj)){ } --> i = key1 , key2...
for(let i of Obj.entries(obj) ){  }-->i = ["key1","value1" ], ["key2","value2"]

*/


//ARRAY -->REFERENCE ; MUTABLE ; ITERABLE  FOR MEMBERS WHOSE ENUMERATE = TRUE) (OBJECTS WHOSE KEY = IND; VALUE = VALUE)
/*
let   arr = [value1,value2] (new Array() is a default constructor which returns Array Literal [] )
                        |
                        |
                        PIMITIVES ELEMENTS: You can use all methods mentioned below
                        REFERENCE ELEMENTS : For reference elements you can use only array methods in pt 5 






1. lookup , insert , length
#lookup
arr[index]                                                      --> returns element at index
arr.indexof(element, fromindex)/lastindexOf(element,fromindex)-> returns the firstOccurence/lastOccuremce  of the element and searh starts from startindex; if not fond returns -1
arr.includes(element.fromposition )                           --> returns true if array includes element search starting from startindex if indexof(element)! = -1 


#insert
arr.push(elements), arr.unshift(elements)   --> push the elements to front(last) of array, rear(firt) of array
arr.pop() ; arr.shift()                     --> pop and return  the elements to front(last) of array; rear(front) of array





#length
arr.length--> return the length of array



2. slice
#SLICE
arr[index];    --> return the value at index
arr.splice(startind, n , elements) -->return new arr by  slicing after start index delete “n” number of items of array(pass 0 if you want to add elements)  and 
                                      after sartindex add elements (don’t pass any argument of you want to remove elements)
arr.slice(startpos,end pos)       --> returns a new array by slicing  array starting from start pos (default = 0)  to end pos excluded (default = last 
                                      index) .primitive elements  values are copid to new array ; reference elements  references are copied to new 
                                      array not the element itsef
#COPY
arr2 = […arr1]                            -->returns new copy arr (spreads the elements of arr  into individual elements and  put those elements into new arr and return new arr

#CONCATENATE
arr = [...arr1,...arr2]                  -->returns new concatenated arr (spreads the elements of arr1,arr2 into individual elements and  put those elements into new arr and return new arr
arr = arr1.concat(arr2)                  ->returns new concatenated arr
arr = arr.join(seperator)                ->return a strrng join the elements of array seperated by seperator 
                                                                                    




3.fns --> callbackfns passed as arguments can be written in 2 ways  :.function(arg) {body}  OR  (arg)  => {body}
FN TYPES
Consumer function: Takes  argument returns nothing
Supplier function: Takes no arg and returns no  value
Predicate function: Takes arg and returns Boolean
Function function  : Takes argument and returns value	       
      |-UnaryOperatoor:Extends Functuio
      |-Binary Operator: Extends BiFunction

for(let i  in  arr , obj ){}                                                --> i =  index of array ,key(iterate over  both instance ; prototype member whose enumerate = true) of obj

for(let i of arr , obj.keys(obj)  ,obj.entries(obj) ){ }                    --> i = value of array , key of object ,[“key” , value] of object 

array.forEach(FunctionFn(element, index, arr){},thisValue / .bind(thisValue) ) 
                                                                            --> for each iterationin array ;                  
                                                                                element =  element at that iteration ,
                                                                                index(optional) = index of element at that iteration
                                                                                arr(optional) = array itself , 
                                                                                thisValue = value  given to  this inside the function ,  
                                                                                            Look in FUNCTION/MEMBERS:MEMBER,THIS ka EG 9
                                                                                Eg
                                                                                let arr = [1,2,3,4,5,6,-1,2,3];
                                                                                arr.forEach((ele)=>{return ele*2;})

array.every(Predicate fn(element , index ,arr) {},thisValue / .bind(thisValue))  --> for every element in array ,   
                                                                                element to index ,arr , this (same as forEach)
                                                                                as soon the boolean condiion is false  every method returns false 
                                                                                and stops  ; if boolean cond does not retuen false till end the end 
                                                                                then every  method will  return true
                                                                                ele,index,arr,thisValue -- same as above
                                                                                Eg
                                                                                let arr = [1,2,3,4,5,6,-1,2,3];
                                                                                let allPositive = arr.every(function(element ) {  --> return false at                            
                                                                                    return element >=0                                – 1 ad exit
                                                                                });  

array.some(Predicate fn  (element , index ,arr) { } , thisvalue )           --> for every element in array ,   
                                                                                element to index ,arr , this (same as forEach)
                                                                                as soon the boolean condiion is true  then some  method returns 
                                                                                true  and stops  ; if boolean cond does not retuen true till end the 
                                                                                end   then some method will  return false
                                                                                ele,index,arr,thisValue -- same as above
                                                                                Eg
                                                                                let arr = [1,2,3,4,5,6,-1,2,3];
                                                                                let atLeastOnePositive = arr.every(function(element ) {  --> return 
                                                                                    return element >=0                                       true at 1 
                                                                                });  


array.filter(Predicate fn  (element , index ,arr) { } , thisvalue )          --> for every element in array ,   
                                                                                element to index ,arr , this (same as forEach)
                                                                                if the boolean returns true  filter adds the  element in new array 
                                                                                and at he end filter method returnsthe  new  array
                                                                                ele,index,arr,thisValue -- same as above
                                                                                Eg
                                                                                let arr = [1,2,3,4,5,6,-1,2,3];
                                                                                let positivearr = arr.filter(function(element ) {  --> return  
                                                                                    return element >=0                                 [1,2,3,4,5,6,2,3]                     
                                                                                });  




array.reduce(Function fn(accumulator, element) {retrn value} , initialvalue )   --> for every element in array ,   
                                                                                accumulator =  initial value (initial value not given acc = arr[0] by 
                                                                                and  element starts from arr[1] not arr[0])
                                                                                accumulator = return value   
                                                                                at the end the reduce fn returns a value 
                                                                                ele,index,arr,thisValue -- same as above
                                                                                Eg
                                                                                let arr = [1,2,3,4,5,6];
                                                                                let positivearr = arr.reduce(function(a,ib ) {  --> return  20
                                                                                    return a + b                                          
                                                                                }  , 0);  

                                                                                function occurenceCount(arr, searchElement){
                                                                                    return arr.reduce(function(accumulator , element){
                                                                                        if(element === searchElement)
                                                                                        return accumulator + 1;
                                                                                        else
                                                                                        return accumulator;
                                                                                    },0);
                                                                                }






arr.sort()                                                                  --> if compareFunction is not supplied, all non-undefined array 
                                                                                elements are sorted by converting them to strings and comparing 
                                                                                strings in UTF-16 code units order. For example, "banana" comes before 
                                                                                "cherry". In a numeric sort, 9 comes before 80, but because numbers 
                                                                                are converted to strings, "80" comes before "9" in the Unicode order.
                                                                                 All undefined elements are sorted to the end of the 


array.sort(Predicate fn(a,b){ }))                                         --> Sort the array according to compare fn  
                                                                                give 1st element to a , second to b sort them acc to boolean 
                                                                               consition and sort  array in place  and return void
                                                                                EG
                                                                                let arr = [4,3,2,1]
                                                                                arr.sort(function(a,b){       OR    arr.sort((a,b) => a-b)--> ascending
                                                                                    if(a < b) return -1;                                      can be done if a b are numbers    
                                                                                    if(a   >b) return 1;
                                                                                    If(a === b) return 0;
                                                                                }
                                                                                .reverse() --> descending
                                                                                EG
                                                                                let arr = [{id:1 , name :”prasann”} , {id:2 , name: “patil”}] 
                                                                                arr.sort(function(a,b){  
                                                                                    if(a name.toUppercase() < b.name.toUppercase()) return -1;
                                                                                    if(a name.toUppercase()  >b.name.toUppercase()) return 1;
                                                                                    If(a. name.toUppercase() === b. name.toUppercase()) return 0;
                                                                                    }
                                                                                .reverse() --> descending
   



arr.find(functin(element) {                                                 --> for every element in array ,      [use for  reference  elements]
              return booleancondition;                                          give elements to element and as soon as boolean cond returns tue 
                  } );                                                          find method returns  the element at that pos ; if boolean returns 
                                                                                nothing till ed find method returns undefined
                                                                                EG
                                                                                let arr = [{a:1,b:2}, {c:3,d:4}];
                                                                                let obj = arr.find(function(element){
                                                                                    return element.a === 1;
                                                                                });
                                                                                console.log(obj);->{a:1,b:2}




EXAMPLE
//All movies in 2018 with rating > 4; sort them by rating in desc order ;pick their title--   
const movies = [                                    >op 'b' 'a'
    {title:'a',year:2018,rating:4.5},
    {title:'b',year:2018,rating:4.7},
    {title:'c',year:2018,rating:3},
    {title:'d',year:2017,rating:4.5},
]

let a = movies
        .filter((element) => {return element.year === 2018 && element.rating >4})
        .sort((a,b)=>{return a.rating - b.rating})
        .reverse()
        .map((element) => {return element.title});

*/


/* #endregion */


//EXCEPTION
/* #region Main */

//(
    /*
    EXCEPTOPN --> Method  throws exception; exception  goes down stack to find exception handler  . 
                  So when exception handler not found till   end then JS gives the stack trace in  err window (method on top ofstack wghich throws err wrtten 1st , method below it 2nd) 
    Eg
    function Animal{
        this.barker = function()[
            bark(null)}
        this.bark = function(String name){
            cinsole.log(name.toUppercase();)
        }
    }

    let animal = new Animal
    Animal.barker()
    */
//)


//EXCEPTION CLASS
/* 
a.INBUILD EXCEPTIONS CONSTRUCTOR FUNCTIONS
Load time errors: Errors which come up when loading a web page like improper syntax errors are known as Load-time errors and it 
                generates the errors dynamically.
Run time errors: Errors that come due to misuse of the command inside the HTML language.
Logical Errors: These are the errors that occur due to the bad logic  performed on a function which is having a different operation.

b.USER DEFINED EXCEPTION CLASS
 */    

//EXCEPTIN HANDLING:
/*
1.Function throws exception automatically
functionnamename(){
    let  f = new FileReader()  }  -->wrap in try catch finally block    so the exception will be handled there  itself and will not travel down the 
                                    stack   to find  exception handler
                                    functionnamename (){
                                    try{
                                        FileReader f = new FileReader()}   --> throws new CheckedException()
                                        
                                    Catch(e){                               --> e = new Objecttype()    
                                        e.method()}                                                      
               
2.Function throws  exc because you throw new exception()-->DON’T WANT  AUTOMATIC  EXC                                                                                       
functionname(){                                                        
            throw new Error();}     --> Exception  is not  handed here so it will   travel down the 
                                       stack and wrap the method call in try catch finally block
                                       fnname1()
                                            throw new Exception () }} --> throws new Exception()
                                        fnname2()
                                            try{
                                                fnname1()}                     --> throws new Exception()
                                            catch(e){                          --> catch e =  new Exception()                    
                                               }
*/

/* #endregion */


//CONDITIONAL
/* #region Main */

//IF
/*
(True = condition satisfied / non zero or non empty)
If(condition){                                                  
}                                                                                                                   
elseif(condition){           	                                                  |
}          |	                                                                  |                                                                                                                                     
else{      |                                                                   GLOBAL , LOCAL
           |                                                                   Variables inside loops are local to that loop
}          |                                                                                                              
           |	                                                               MOST GENEROC LOOP ON TOP
        |	                                                                   if (a%5 ==0 && a%3 == 0) -> must be on top if on 
                                                                               elseIf (a%3 ==0)            bottom  it will never be
                                                                               else(a%5 ==0)               encountered     
true , false -> return true , false                                                                                             
object -> retuen true if element of obj Is true  [non zero/ non empty]                                       
obj1 operator  obj2 -> return true, false acc to operator
               |                                                                                                                                                    
               |
        COMPARISION OP, LOGICAL OP , INCLUSION OP ,DATATYPE OP : LOOK IN OBJECTS
        ARITHMETIC OPERATOR : +(overloaded for int , string) ,- , * , / , % , ^  
        INCREMENT/DECREMENT : x = x +1 ; x += x ; x++ ; ++x
                                                                    


SIMPLIFYING IF
1.TERNARY(we can do only assignment in ternary and not execution like printing etc)
String a;                           -->  int  b; String a =   (b < 30 ) ? “less” : “more”
if (b < 30){ a =  “less”}
else{s = “more”}

2.SWITCH(you can take only = condition and not other conditions like <, > ……. )
String a ;                       -->  String a
if (a = “prasann” )                   switch (a)
{                                     {
      Sout(“name ”)                    case “prasann”:
}                                        sout(“name”);
                                         break ;
else if (a = “pradeep”)                case  “pradeep”:
{                                         sout(“father’);
   Sout(“father”)                          break ;
}                                                 
else{                                  defaultL sout(“xyz”)
  sout(“xyz”)
}

*/

 
//WHILE(Usually used as outerLoop with break, continue)
/*
While(condition)
{               |
}               |
                 |
        SAME AS IF
*/

//DO WHILE(Usually used as outerLoop with break, continue)
/*
do
{
}while(condition)
              |
              |
              |
        SAME AS IF
*/

//FOR
/*
FOR
for(let i = 0 ; i <= 2; i++){ }

FOR –IN
for(let i  in  arr , obj ){}  --> i =  index of array ,key(iterate over  both instance ; prototype member whose enumerate = true) of obj


FOR-OF
for(let i of arr , Object.keys(obj)  ,Object.entries(obj) ){ }--> i = value of array , key of object ,[“key” , value] of object 



FOR-EACH
array.forEach(function(element, index, arr){ operations } ,thisValue / .bind(value) ) --> for each iterationin array ;                  
                                                                                         element =  element at that iteration ,
                                                                                         index(optional) = index of element at that iteration
                                                                                         arr(optional) = array itself , 
                                                                                         thisValue = value  given to  this inside the function ,  
*/


//BREAK, CONTINUE
/*
break --> stop at certsin iteration and jump out of loop block
continue --> skip certain cond and jump  to start of loop 
*/

/* #endregion */


//MISCALLENOUS
/* #region Main */

//1.INSTANCE MEMBERS,PROTOTYPE MEMBERS 
//FUNCTION(ObjectBase Prototype --> FunctionBase Prototype -->  Function)
/*
function Circle(radius){
    this.radius = radius;
    this.draw = function(){
    }
}

let circle = new Circle(1);
console.log(circle);--> //INSTANCE MEMBERS
                        radius:1                                    -->Function
                        draw: f()
                        //PROTOTYPE MEMBERS
                        __proto__:Object                           -->FunctionBase Prototype
                            constructor:f Circle(radius)   
                            __proto__:Object                      -->ObjectBase Prototype
                                constructor: ƒ Object()  as Object ; 
                                hasOwnProperty: ƒ hasOwnProperty()
*/
//CLASS(ObjectBasePrototype -->ClassBase Prototype -->Class)
/*
Class Circle{
    Constructor(radius){
    this.radius = radius;
    this.draw = function(){
    }
}

let circle = new Circle(1);
console.log(circle);--> //INSTANCE MEMBERS
                        radius:1                                    -->Class
                        draw: f()
                        //PROTOTYPE MEMBERS
                        __proto__:Object                            -->ClassBase Prototype
                            constructor:f Circle(radius)   
                            __proto__:Object                        -->ObjectBase Prototype
                                constructor: ƒ Object()  as Object ; 
                                hasOwnProperty: ƒ hasOwnProperty()
*/
//ARRAY(ObjectBase Prototype --> ArrayBase Prototype -->  Array)
/*
let x = [1,2]
console.log(x)--> //INSTANCE MEMBERS
            1:1                                      -->Array
            2:2
            //PROTOTYE  MEMBERS
            __proto__: Array(2)                      -->ArrayBase Prototype        
                        concat: ƒ concat()           
                        constructor: ƒ Array()    
                        find: ƒ find()                     
                        __proto__: Object              -->Object Base Prototype
                                constructor: ƒ Object()  as Object ; 
                                hasOwnProperty: ƒ hasOwnProperty()
*/
//OBJECT(ObjectBase Prototype -->Object)
/*
let obj = {x:1;y:2};
Console.log(obj)--> //INSTANCE MEMBERS 
                        x:1                           -->Object    
                        y:2.
                    //PROTOTYE  MEMBERS
                    __proto__:Object                 -->ObjectBase  Prototype
                    constructor: ƒ Object()  as Object ; 
                    hasOwnProperty: ƒ hasOwnProperty()
*/


//2.INSTANCE MEMBERS , PPROTOTYPE MEMBERS CHANGES
//OBJECT.GETPROTOTYPEOF(MYOBJ)
/*
Object.getPrototypeof(myobj)/                    -->returns the prototypeobject   of the object passed    
myObj.__proto__ /                                     Eg let arr = [1,2,3,4]  new Array() under the hood constructor fn
Constructorfn.prototype(deprecated)                       arr.__proto__/ Object.getprototype(arr)/ Array.prototype      
                                                      Eg function Circle(radius){ }
                                                         let c1 = new Circle();
                                                         C1.__proto__/ Object.getprototype(c1)/ Circle.prototype      
*/
//OBJECT.GETOWNPROPERTYDESCIPTOR(MYOBJ ,”MEMBER” )
/*                                                                                                                                                 
Object.getOwnPropertyDesciptor(myobj ,”member” ) -->returns attributes attached to   the member of the object passd  
                                                    value: gives the value of the member
                                                    configurable: if true we can delete the  member
                                                    enumarable: if true means while iterating we will see that member 
`                                                   writable:if true means we can overrite the value  of the member 

                                                    EG
                                                    let person ={x:1};
                                                    let attributes = Object.getOwnPropertyDescriptor(person,'x');
                                                    console.log(attributes);--> value: 1  --> value of member  x is 1                  
                                                                                configurable: true  --> we can delete member x
                                                                                enumerable: true    -->for(i in person) we can see member  x
                                                                                writable: true   --> we can overwrite value of member  x  
                                                                                __proto__: Object

                                                    EG
                                                    let person ={x:1};
                                                    let objectBase = person.__proto__/Object.getPrototypeOf(person);
                                                    let attr = Object.getOwnPropertyDescriptor(objectBase,'toString');
                                                    console.log(attr);--> value: ƒ toString()-->value of member  toString  is toString()
                                                                        configurable: true  --> we can delete member toString
                                                                        enumerable: false --> for(i in person) we cant see member toString 
                                                                        writable: true --> we can overwrite value of member  toString
                                                                        __proto__: Object
*/
//OBJECT.GETOWNPROPERTYDESCIPTOR(MYOBJ ,”MEMBER” )
/*
Object.defineProperty(object ,”property ” { attribute:value}) --> we can change the ttributes atached to a property of object passed
                                                        value = anyvalue: gives the value of the member
                                                        configurable : t/f: if true we can delete the  member
                                                        enumarable : t/f: if true means while iterating we will see that member
                                                        writable =:t/f:if true means we can overrite the value  of the member
                                                        get:function(){return prop} :we can do obj. member no need of obj.get()
                                                        set:function(vall){prop = val} :we can do obj. member = val no need of obj.set(val) 

                                                       	EG
                                                        function Circle(radius,x,y){ 
                                                            Object.defineProperty(this,"angle",{
                                                                    Configurable: false         -->you cant delete angle member 
                                                                    writble:false               --> tou cant overwrite angle member value
                                                                    get:function(){             -->let c1 = new Circle(1,2,3) ; you can directly do   c1.angle 
                                                                            return angle},          no  need of c1.getAngle()   
                                                                    set:function(value){        --> let c1 = new Circle(1,2,3) ; you can dir do   c1.angle =22
                                                                                angle = value;}     no  need of c1.setAngle(22)   
                                                            })
*/
//OBJECT.HASOWNPROPERTY(‘MEMBER’)
/*                                                                                                                                                                                            
Object.hasOwnProperty(‘member’)                         --> returns true if the member is an instance member and false if the member is a prototye member
                                                            EG
                                                            function Circle(radius){
                                                            //Instance member
                                                            this.radius = radius;}

                                                            //prototype member
                                                            Circle.prototype.draw= function(){     
                                                                    console.log(“”circle with” + this.radius)  }

                                                            Object.hasOwnProperty(‘radius’) --> true         
                                                            Object.hasOwnProperty(‘draw’) --> false
*/
//OBJECT.KEYS(MYOBJ)
/*
Objects.keys(myObj)                                      -->returns an array of instance members of the object  whose enumerate = true
                                                            If you want both instance;prototype members  whose enumerate = true use FOR-IN
                                                            EG
                                                            function Circle(radius){
                                                            //Instance member
                                                            this.radius = radius;}

                                                            //prototype member
                                                            Circle.prototype.draw= function(){     
                                                                console.log(“”circle with” + this.radius)  }

                                                            let c1 = new Circle(1)


                                                            Object.keys(c1) -->[“radius”]
                                                            for(key n c1){        -->”radius” , “draw”
                                                                console.log(key)}
*/                                                                                              


//3.FUNCTIONS ARE OBJECTS
/*
function Circle(){}
Circle.name             --> returns name of fn  ie circle
Circle.length           --> returns number of arg of fn ie 3
Circle.constructor      --> returns constructor fn object used to build fn object   ie  ƒ Function() { [native code] }
Circle.call({} , 1,2,3) --> returns new Circle(1,2,3)  and {} referennces to this
Circle.apply({} , [1,2,3])--> return new Circle(1,2,3); and {} references to this 

*/


//4.CLASSES ARE OBJECTS
/*
class Circle(){}
Circle.name --> returns name of fn  ie circle
Circle.length--> returns number of arg of fn ie 3
Circle.constructor --> returns constructor fn object used to build fn object   ie  ƒ Function() { [native code] }
Circle.call({} , 1,2,3) --> returns new Circle(1,2,3)  and {} referennces to this
Circle.apply({} , [1,2,3])--> return new Circle(1,2,3); and {} references to this 

*/


//5.INBUILT CONSTRUCTOR
/*
Every obj literal  is converted to constructor fn which returns an object    under the hood                     
let  num = 22 new Number(22)  which returns Number object
let bool = true new Boolean(true) which returns Boolean objetc
let str = “pras” new String(“pras”) which returns String object 
let arr  =[1,2,3,4,5]  new Array([1,2,3,4,5]))  whhic h returns Array object
let obj = {a:1;b:2} new Object{{a:1,b:2}}  which returns object
let fn =function(param){content}  new Function(param , `content of fn`)    which  return function object   
let fact_obj = factoryFunction(); new Function() which returns object
let const_obj = new ConstructorFn() this is itself an constructor fn which returns object
                     
We  can find constructor function  which returned the object(All on the right sides are constructor fns)
console.log(`
${num.constructor}            -->function Number() { [native code] } 
${bool.constructor}           -->function Boolean() { [native code] } 
${str.constructor}            -->function String() { [native code] } 
${arr.constructor}            -->function Array() { [native code] } 
${obj.constructor}            -->function Object() { [native code] } 
${fn.constructor}             -->function Function() { [native code] }
${fact_obj.constructor}       -->function Function() { [native code] }
${factoryFunction.constructor}-->function Function() { [native code] }
${const_obj.constructor}      -->function constructorFunction(a){our code} as the const fn we wite is itself an const fn
 
 `);

*/

/* #endregion */


//JS NODE MODULES
/* #region Main */

//PATH--https://nodejs.org/docs/latest-v8.x/api/path.html
/*
const  path = require('path'); -->returns  path objOfFn

path.parse(“filepath to  .js file”) --> returns object containing important feature of path
*/

//OS -- https://nodejs.org/docs/latest-v8.x/api/os.html
/*
const os = require(‘os’);    -->returns  os objOfFn

os.totoalmem(); -->returns string  of total memory in OS
os.fremem();    -->returns string of available mem in OS
*/

//FILE SYSTEM-- https://nodejs.org/docs/latest-v8.x/api/fs.html
/*
const fs  = require(‘fs’);  --> returns fs objOfFn

fs.writefilesync(“filepath”, data)           --> synchronously write data to filepath
s.writefile(‘filepath’,data, (params) =>{})  --> asynchronously write data to filepath 
fs.copyfilesync(“filepath1” , “filepath2”)   -->synchronously copy data from filepath2 to filepath1
fs.copyfile(“filepath1” , “filepath2”,(params)=>{} ) -->asynchronously copy data from filepath2 to filepath1
*/

//EVENT -- https://nodejs.org/docs/latest-v8.x/api/events.html
/*
const EventEmitter =  require(“emitter”);   --> retruns EventEmitter fnObj
const emitter = new EventEmmiter();        -->  returns EventEmmiter ObjOfFn

emmiter.emit(“eventname” , {id:1,name:pras}})         -->emit  event  
                                                           
                                                              
emitter.on(“eventname” , (eventArgs) => {            -->listens  event 
             cconsole.log(eventArg.id) })               
                                                        //EMIT , LISTEN SAME FILE-->EMIT AFTER  REGISTERING  LISTENER
                                                        (Emit after  registering listen 
                                                        because emit calls all listeners sybnchronously
                                                        so you must have listeners available before raise)
                                                        EG
                                                        filr.js
                                                        emitter.on(“eventname” , (eventArgs) => {           -->listens  events         
                                                                    console.log(eventArg.id) })   

                                                        emmiter.emit(“eventname” , {id:1,name:pras}})         -->emits event 
                                                        
                                                        
                                                        
                                                        //EMIT ANS LISTEN IN DIFFERENT FILE--> EMIT LISTEN ON DAME OBJECT
                                                        (Emit,Listen must be on same object 
                                                        So emit on a class , listen on object of that class)
                                                        EG
                                                        file1.js                                    file2.js           
                                                        const EventEmitter =  require(“emitter”);   const EventEmitter =  require(“emitter”); 
                                                        const emitter = new EventEmmiter();         const emitter = new EventEmmiter();  
                                                                                                    const foo = require(./file1)  
                                                        function foo(){
                                                            emitter.emit("event1")}                emitter.on("event1") () => {} } -->RAISING ,LISTENENG ON DIFFERENT emmiter object

                                                        module.exports = log


                                                        file1.js                                    file2.js    
                                                        const EventEmitter = require('events');     const Emmiter  = require(./file1)
                                                        class Emitter  extends EventEmitter {       const emmiter = new Emmiter()
                                                            foo() {
                                                                this.emit('event1');}               emmiter.on("event1",()=>{})-->RAISING ,LISTENENG ON SAME emmiter object
                                                        }

                                                        module.exports = Emitter

                                                        


                                                        
*/

//HTTP -- https://nodejs.org/docs/latest-v8.x/api/http.html  -- INSTEAD YOU CAN USE EXPRESS
/*
const http  = require('http');

const server = http.createServer((req,res)=>{    -->emit an http request at server side

    if(req.url === "/"){                    
        res.write("Hello World");
        res.end();
    }

    if(req.url === "/myPersonalApi"){           
        res.write("Hello world2");
        res.end();
    }
});

server.listen(3000);                               -->listen to http request at client side at port 3000
                                                     at http://127.0.0.1:3000 you will get hwllo worls and at 
                                                     at http://127.0.0.1:3000 /myPersonalApi ypu will get Hello World2
*/


/* #endregion */






