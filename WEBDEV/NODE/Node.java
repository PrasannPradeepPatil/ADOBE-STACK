//REMAINING
/*
 //MONGODB SHELL:Shell view of DB:-https://gist.github.com/bradtraversy/f407d642bdc3b31681bc7e56d95485b6
//CONNECT
>mongod -->start mongodb server at 127.0.0.1:27107 -->CONNECT TO DATABASE
>mongo  --> enter mongo shell

//CREATE  
                                                    ___filename.json--> [{_id:1234,name:'pras'},{_id:1235,name:'patil'}]
                                                     /
>mongoimport --db dbName -collection collName  --filename filename.json --json jsonArray  -->create a database ; create a collection ; add documents from filename.json   documents are stored in array in filename.json
>use dbName                                                                               -->create database "database" or use preexisting "database" (db = databaseName)
>db.createCollection('collectionName')                                                    -->create in database "db" , collection "createCollection"

//READ
>use db
>db.collectionName.methodsUsedInProgramming()
     +
    >show database  --> shows all databases
    >use dbName      -->shows collection in db
    >show collection 

//UPDATE
>use db
>db.collectionName.methodsUsedInProgramming()


//DELETE
>use db
>db.collectionName.methodsUsedInProgramming()
        + 
        >use db                       --> drop database db
        >db.dropDatabase()  
        >db.collectionName.remove({}) -->remove document from collection

 */

//INSTALL NODE(WINDOWS(WITHOUT SUDO) , LINUX(WITH SUDO))
/*
//INSTALL NODE(WINDOWS)
INSTALL     -- >Install using link -- https://nodejs.org/en/   
SET ENV VAR -- >C:\Program Files\nodejs\                         
                >node --version   
   
//INSTALL NODE(LINUX) 
INSTALL      -->sudo apt update              -->update installation
               >sudo apt install nodejs      -->install nodejs
               >sudo apt install npm         -->install npm
               >node --version               -->gives npde version
               >whereis node                  --> gives node: /usr/bin/node /usr/share/man/man1/node.1.gz
               >curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.37.2/install.sh | bash -->update node
               >nvm install v14.17.0
SET ENV VAR -->No Need
*/

//CREATE AND RUN NODE(WINDOWS(WITHOUT SUDO) , LINUX(WITH SUDO))
/*
//CREATE SERVER
>sudo npm install -g jshint              --> install compiler for node glbally
>sudo npm install -g nodemon             --> install nodemon globally 
>sudo npm install -g express-generator   -->install express globally
>express --view=pug  server              -->create a templat called "server"
>https://www.freecodecamp.org/news/how-to-enable-es6-and-beyond-syntax-with-node-and-express-68d3e11fe1ab/-->Convert Express template to ES6 if requires

>cd server
>sudo npm install                    -->install package.json dependencies which include "express","cookie-parser","morgan","debug","http-errors","jade"
>sudo npm install express --save     -->install express locally and add to package.json
>sudo npm install mongoose --save    -->install mongooselocally and add to package.json
>sudo npm install cors --save         -->install cors locally and add to package.json
>sudo npm install dotenv --save       -->install dotenv var dependency locally and add to package.json
>sudo npm install --force packageName --> force install package in  if package installation is not working

**Look in packagejson.Java in server for more info


//RUN SERVER  
>cd server
>sudo npx kill-port 3000  -->kill the port if already in use for server, mongodb connection to server
>sudo npm start           -->run server at http://127.0.0.1:3000(node runs at 3000 by default;react runs on 3000 by default(hence 1st run node then react so that react runs on 3001);mongodb runs on 5000 as written in code while connecting to mongoDB))                 
                            package.json
                            "scripts": {
                                    "start": "node ./bin/www"    -->npm start = node ./bin/www      (runs app.js file)
                                    "start": "nodemon ./bin/www" -->npm start = nodemon ./bin/www   (runs app.js file with hot reload)
                            },                                      and rerun terminal to reflect changes in package.json


*/

//STRUCTURE(server)
/*
server                            
  |-node_modules                     -->external modules                            
  |-package.json                     -->external module dependency(Look in packagejson.java in server folder )    
  |-package-lock.json                --> external module dependency 
  |-public                           -->public acessories of server 
    |-images
    |-javascript
    |-stylesheet
  |-views                            -->views of server
    |-error.jade
    |-index.jade
    |-layout.jade
 |-bin                             -->run on npm start as package.json has this file on start script ; and this file runs app.js with error checks
    |-www                             
  |-routes(custom made folder)     -->explaind below     
    |-post.js              
  |-models(custom made folder)    -->explaind below     
    |-post.JS              
  |-controllers(custom made folder) -->explaind below            
    |-post.JS              
  |-app.js     
  |- .env                        -->environment variable file
  |- .git                        --> github file
  |- .gitignore                  --> github file
  |- Profile                     -->Heroku file                      
     
app.js                  -------------------------------------------------routes  ---------------------------------->controller<--------------------------------------------models
app.use(cors());app.use(fn(req, res, next){app.use('/posts',postsRouter) router.post('/', createPost)             exports.createPost =async (req, res) =>{}              models for DB 
for baseURL/endpt perform fn,custom fn,send to routes                    for baseURL/endpt call fn in controller  for for baseURL/endpt receive req                                                                     
                                                                                                                  perform operation on DB and and send response  
mongoose.connect(MONGODB_CONNECTION_URL,
connect node to mongodb server(ATLAS server wjoch will host DB)


  
                               
*/
