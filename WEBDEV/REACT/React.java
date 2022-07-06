//INSTALL NODE AND REACT(WINDOWS(WITHOUT SUDO) , LINUX(WITH SUDO))
/*
//INSTALL NODE(WINDOWS)
INSTALL     -- >Install using link -- https://nodejs.org/en/   
SET ENV VAR -- >C:\Program Files\nodejs\                         
                >node -version   
   
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

//CREATE AND RUN REACT(WINDOWS(WITHOUT SUDO) , LINUX(WITH SUDO))
/*
//CREATE REACT
>sudo npm -g uninstall create-react-app    -->uninstall global package  "create-react-app" as global package no longer supported  
>sudo npx create-react-app client          -->installs package "create-react-app version latest" and create a templat called "client"(Node >= 10.16 and npm >= 5.6 )
>sudo chmod -R 777 client                  -->allows all privelages to client folder(linux)
>cd client
>sudo npm install                          -->install package.json dependencies  locally 
>sudo npm install axios                    -->install react dependancies locally
>sudo npm install moment 
>sudo npm install react-file-base64 
>sudo npm install redux-thunk
>sudo npm install react-redux
>sudo npm install @material-ui/core
>sudo npm install @material-ui/icons
>sudo npm install dotenv                  -->install env var dependency locally 

**sudo npm install --force packageName     --> force install package in  if package installation is not working
**Look in packagejson.Java in server for more info

//RUN REACT
>cd client
>sudo npx kill-port 3001 -->kill the port if already in use for client
>sudo npm start   -->run client at http://127.0.0.1:3000(node runs at 3000 by default;react runs on 3000 by default(hence 1st run node then react so that react runs on 3001);mongodb runs on 5000 as written in code while connecting to mongoDB))                 
                    package.json
                      "scripts": {                               
                        "start": "react-scripts start",  -->npm start = "react-scripts start" 
                        "build": "react-scripts build",    and rerun terminal to reflect changes in package.json
                        "test": "react-scripts test",
                        "eject": "react-scripts eject"
                      },
                      {                                  
                      "name": "server",                       
                      "version": "0.0.0",                    
                      "private": true,                        
                      "proxy":"http://localhost//5000" -->proxy:'http://localhost:PortNoWhereMongoDbIsConnectedToSever
                                                           and rerun terminal to reflect changes in package.json


*/


//STRUCTURE(client-I Uses React-Redux,client-II Doest use React-Redux does everything in component)
/*
client 
  |-node_modules            -->external modules                 
  |-package.json            -->external module dependency(Look in packagejson.java in client1 folder )    
  |-package-lock.json       -->external module dependency  
  |-public                  -->public acessories of client 
    |-filename.png/.ico     -->images and icons of project
    |-manifest.json         -->tells browser about app and how it should be installed on mobile or desktop   
    |-index.html            
  |-src      
    |-api(custom made folder)       -->explaind below     
      |-posts.js
    |-actions(custom made folder)   -->explaind below    
      |-posts.js
    |-reducers(custom made folder)  -->explaind below    
      |-posts.js                         
      |-index.js                               
    |-component(custom made folder) -->explaind below  
       |-index.js                  -->Holds the componentName for different routes      
       |-FORM                        
          |-form.js,styles.js
       |-POSTS                      
         |-POST                         
           |-post.js,styles.js
         |-posts.js,styles.js                               
    |-app.js, styles.js,app.css                        
    |-index.js,index.css         
    |- .env                        -->environment variable file
    |- .git                        --> github file
    |- .gitignore                  --> github file

  index.js,index,css
  hold app.js(virtual dom) in index.js(actual dom)  
  and provide app.js wit redix store                                                                                                  
  App.js,styles.js,App.css(MAIN COMPONENT )    -------------------->actions,reducer           ------------------------------------->api
      |                                        <-------------------                           <------------------------------------       
 _____|______________________________                              ACTIONS:                                                       export const fnName= (UIKaData) => axios.post(BaseUrl, newPost);) send UIKaData on URL                                               
 |                                   |                             fnAction(UIKaData){                                                                                                               receive data on URL                                                                
 Posts.js,styles.js Form.js,styles.js                                const data = await api.fn(UIKaData)     :awaits api respones 
  (POSTS COMP)      (FORM COMPONENT)                                 dispatch({type:'acttype',payload:data}) :dispatches data with actionType  to reduxStore                                                                                                                                                                              
                                                                                                                                                                                                               
 useDispatch(fnAction(UIKaData)):calls action fn with  UIKaData    REDUCERS                                                                                                                                                 
 useSelector((state)=>{state.state1}):calls state in reduxStore    fnReducer(state,actionType){              :based on actionType   
                                                                      if(actionType.type = ''){newState =}    create a  newState
                                                                      elseif(actionType.type = ''){newState =}
                                                                      return newState       
                                                                  
                                                                   export const reducers = combineReducers({
                                                                     state1:newState1,                          :update the state in reduxStore to newState returned by action
                                                                     state2:newState2,                            |
                                                                   }                                              |
                                                                  );                                              |

                                                                                                        reduxStore stores all states as follows 
                                                                                                        {count:1,                        --count is a state
                                                                                                         search:[{source:"",dest:""},       searchBox is a state
                                                                                                                    {sorce:,dest:}]        which is an array of objects
                                                                                                          }                                 formed by search box

    

  



*/
                                                                                                               




