//IMPORT EXTERNAL MODULES
var express = require('express');            //sudo npm install express  --save(while project creation)
var mongoose = require('mongoose')           //sudo npm install mongoose --save(while creating project) 
var cors = require('cors');                  //sudo npm install cors     --save(while creating project)  
var cookieParser = require('cookie-parser'); //sudo npm install (while project creation)
var logger = require('morgan');              //sudo npm install (while project creation)
var debug = require('debug');                //sudo npm install (while project creation)
var createError = require('http-errors');    //sudo npm install (while project creation)
var jade = require('jade');                  //sudo npm install (while project creation)
var path = require('path');                  //sudo npm install (while project creation)
var dotenv = require('dotenv');              //sudo npm install (while project creation)
//IMPORTS MODULES
var postsRouter = require('./routes/posts');

var app = express();
dotenv.config();

//GLOBAL VARIABLE(APPLIED TO ALL ENDPOINTS)
/* #region Main */
/*
//SET GLOBAL VAR
app.set('varName',value);   

//USE GLOBAL VAR
app.get('varName');         
  
*/
/* #endregion */
app.set('views', path.join(__dirname, 'views'));  
app.set('view engine', 'jade');


//INBUILT MIDDLEWARE FNS(APPLIED ON  ALL ENDPOINTS)
/* #region Main */
/*
var express = require('express');           //sudo npm install express --save 
var path = require('path'); 
var logger = require('morgan');

app.use(logger('dev'));                                     -->For baseURL/everyEndpoint,apply logger() fn
app.use(express.json({limit:"30mb",extended:true}));         //express.json()     fn parses req body(raw body) into json populates req.body with json ;returns a middleware fn  ; limit sets the limit of req body ;extended allows to choose between parsing req body with the querystring library (when false) or the qs library (when true). 
app.use(express.urlencoded({limit:"30mb",extended: true }));//express.urlencoded()fn parses req body(encoded)  into json populates req.body with json ;returns a middleware fn  ; limit sets the limit of req body ;extended allows to choose between parsing req body with the querystring library (when false) or the qs library (when true). 
app.use(express.static(path.join(__dirname, 'public')));   //express.static()     fn serves static file in public folder
app.use(cookieParser());                                   //cookieParser()      fn parse cookie header populate req.cookies with an object keyed by the cookie names.
app.use(logger('dev'));
app.use(cors());

*/
/* #endregion */
app.use(express.json({limit:"30mb",extended:true}));         
app.use(express.urlencoded({limit:"30mb",extended: true }));
app.use(express.static(path.join(__dirname, 'public')));  
app.use(cookieParser());                                
app.use(logger('dev'));
app.use(cors());            //ADD THIS


//ROUTES MIDDLEWARE FNS(APPLIED ON GIVEN END POINTS)
/* #region Main */
/*
var postsRouter = require('./routes/posts');     -->For baseURL/posts call routes/posts.js
app.use('/posts', postsRouter);                    
*/
/* #endregion */                              
app.use('/posts',postsRouter)        


//CUSTOM MIDDLEWARE FNS(APPLIED ON  ALL ENDPOINTS) 
/* #region Main */
/*
app.use(function(req, res, next) {   -->For baseURL/endpoints apply the function
  next(createError(404));});          req -->Data receivd on URL
                                      res -->Data to be send on URL  
                                      next()--> send response to next middleware 

                                      req.query                            -->returns {param1:value1,param2:Value2}  where params , values sent by URL query}
                                      req.body                             -->returns {body} where body is sent by url                    
                                                    
                                      res.send("Message")                  -->send object to client
                                      res.json(obj)                        -->send json equivalent of obj to client                                                                                                                                                       
                                      res.status(errcode).send("Message")  -->send status error code:message to client
                                      res.status(errcode).json(obj)        -->send status error code:json equivalent of obj to client
                                                  |--LOOK IN WEB ARCH 
                                                      
                                     

*/
/* #endregion */
app.use(function(req, res, next) {       // catch 404 and forward to error handler
  next(createError(404));
});
app.use(function(err, req, res, next) {  // error handler
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});




//CONNECT NODE TO MONGODB SERVER(ATLAS SERVER WHICH WILL HOST OUR DATABASE):https://www.youtube.com/watch?v=ngc9gnGgUdA&t=522s  :10:30 TO 13:00
/*
Create Cluster/Database: Got to Atlas-->Create New Cluster/Database-->Select shared clustere-->Select the region you are in and select create
Create User    : Go to Database Acess,create user with username and password
Create Network : Go to Network Acess, creaate network with current IP adress
Connect cluster to node server : Go to Cluster/Database and connect cluster and select Cnnect to Application
                                 copy the URL and replace <usernamae> <password> with your username and password by removing <>  
                                 node runs at 3000 by default;react runs on 3000 by default(hence 1st run node then react so that react runs on 3001;mongodb runs on 5000 as written in code while connecting to mongoDB)
View Database: Go to Cluster/Database and view collections


var mongoose = require('mongoose')
const CONNECTION_URL =  process.env.MONGODB_CONNECTION_URL||'Atlas URL'; (Look above)
const PORT = process.env.MONGODB_CONNECTION_PORT||5000;                  (Look above)
mongoose.connect(CONNECTION_URL)            
  .then(() => app.listen(PORT, () => console.log(`Server Running on Port: http://localhost:${PORT}`)))
  .catch((error) => console.log(`${error} did not connect`));




*/





const MONGODB_CONNECTION_PORT = process.env.MONGODB_CONNECTION_PORT|| 5000;  
const MONGODB_CONNECTION_URL = process.env.MONGODB_CONNECTION_URL || 'mongodb+srv://prasannpradp:Wxyz12345@cluster0.t3xqogu.mongodb.net/?retryWrites=true&w=majority';
mongoose.connect(MONGODB_CONNECTION_URL)
  .then(() => app.listen(MONGODB_CONNECTION_PORT, () => console.log(`MongoDB Server Running on Port: http://localhost:${MONGODB_CONNECTION_PORT}`)))
  .catch((error) => console.log(`${error} did not connect`));



//EXPORT
module.exports = app;    




