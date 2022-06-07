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
>sudo npm install -g jshint         --> install compiler for node glbally
>sudo npm install -g nodemon        --> install nodemon globally 
>sudo npm install -g express-generator   -->install express globally
>express --view=pug  server         -->create a templat called "server"
>https://www.freecodecamp.org/news/how-to-enable-es6-and-beyond-syntax-with-node-and-express-68d3e11fe1ab/-->Convert Express template to ES6 if requires

>cd server
>sudo npm install                    -->install package.json dependencies which include "express","cookie-parser","morgan","debug","http-errors","jade"
>sudo npm install express --save     -->install express locally(already installed in npm install)
>sudo npm install mongoose --save    -->install mongoose locally
>sudo npm install dotenv              -->install env var dependency locally 

//RUN SERVER  
>cd server
>sudo npx kill-port 3000 5000 -->kill the port if already in use for server, mongodb connection to server
>sudo npm start   -->run server at http://127.0.0.1:3000( server runs at 3000,client runs at 3000 so 1st run server and then run client so client ;because asks to run at other server and  runs at 3001)
                  -->connects mongodb to server at  http://127.0.0.1:5000
                    package.json
                    "scripts": {
                            "start": "node ./bin/www"    -->npm start = node ./bin/www 
                            "start": "nodemon ./bin/www" -->npm start = nodemon ./bin/www   (provides hot reload so rename node to nodemon)
                    },
                    bin/www
                    runs app.js file with all error checks

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
   
  
                               
*/
