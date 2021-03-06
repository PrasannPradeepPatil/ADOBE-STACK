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
/* #region Main */

//CREATE AND RUN REACT
/*
1.CREATE FOLDER STRUCTURE
>sudo npm -g uninstall create-react-app    -->uninstall global package  "create-react-app" as global package no longer supported  
>sudo npx create-react-app client          -->installs package "create-react-app version latest" and create a templat called "client"(Node >= 10.16 and npm >= 5.6 )
>sudo chmod -R 777 client                  -->allows all privelages to client folder(linux)

2.INSTALL
>cd client
>sudo npm install                          -->install package.json dependencies  locally 
>sudo npm install axios                    -->install react dependancies locally
>sudo npm install moment 
>sudo npm install react-file-base64 
>sudo npm install redux-thunk
>sudo npm install react-redux
>sudo npm install @material-ui/core
>sudo npm install @material-ui/icons
>sudo npm install identity-obj-proxy
>sudo npm install dotenv                    
**sudo npm install --force packageName     --> force install package in  if package installation is not working


3.CHANGE PACKAGE.JSON
{
  "name": "server",                                           
  "proxy":"http://localhost//5000"    -->proxy:'http://localhost:PortNoWhereMongoDbIsConnectedToSever
  "scripts": {                               
    "start": "react-scripts start",  -->npm start = npx react-scripts start 
    "build": "react-scripts build",     nmp build  = npx react-scripts build
    "eject": "react-scripts eject"   
  },    
  Rerun terminal to reflect changes in package.json


4.RUN REACT APP 
>cd client
>sudo npx kill-port 3001 -->kill the port if already in use for client
>sudo npm start   -->run client at http://127.0.0.1:3000(node runs at 3000 by default;react runs on 3000 by default(hence 1st run node then react so that react runs on 3001);mongodb runs on 5000 as written in code while connecting to mongoDB))                 
>sudo npm test   -->run all files with extension .test.js at level of src  
*/
                    
                                                           
//CREATE AND RUN TESTS(JEST) 
/* 
1.CREATE FOLDER STRUCTURE 
Create  __test__/jest/filename.test.js under src

2.INSTALL
>sudo npm install @testing-library/react react-test-render 
>sudo npm install @babel/core
>sudo npm install @babel/preset-env
>sudo npm install @babel/preset-react
>sudo npm install jest-environment-jsdom 


3.ADD TO PACKAGE.JSON
"name": "server",                                           
"scripts": {                               
  "test": "jest --watchAll"         -->npm test =  npx jest --watchAll (jest test runs .test.js file ;jest --watchAll will run all test cases with hot reload)
},    
"babel": {                           -->Used to convert ES6 to JS code for web(Write in package.json OR create a file .babelrc at src level and do module.exports = {"presets":[],"plugins":[]})
  "presets": [                          presets:  added to all files  for running jest test cases
      "@babel/preset-env",              plugins:added to all files; for running jest test cases
      "@babel/preset-react"
  ],
  "plugins": [["@babel/plugin-proposal-class-properties"],
              ["@babel/plugin-proposal-decorators", 
              {"legacy": true}]
              ]
},
"jest":{                             -->Used for configure the test cases for jest(Write in package.json OR create a file .babelrc at src level and do module.exports = {"presets":[],"plugins":[]})
    "moduleNameMapper": {               moduleWrapper: used for igore CSS files  
        "\\.(css|less)$": "<rootDir>/src/__test__/jest/__mockData__/styleMock.js" 
    }
}
Create file __mockData__/styleMock.js inside __test__/jest where you will be writing your jest 
and keep the file styleMock.js empty


4.WRITE TEST
filename.test.js
/**                        
 * @jest-environment jsdom               -->Add This command at top of FileName.test.js 
 * / (move backslash 1 space beind) 
describe(())                             -->write your code here

cypress.config.js
module.exports = defineConfig({
  e2e: {
    ....
  },
  "retries": {                               
    "runMode": 1, //default:0   -->number of retries to be done when a test case fails(for npx cypress run)
    "openMode": 3 //default:0   -->number of retries to be done when a test case fails(for npx cypress open)
  }
});


5.RUN TESTS
>cd client
>sudo npm test OR sudo npx jest --watchAll   -->run all files with extension .test.js inside clients folder
*/

//CREATE AND RUN TESTS(CYPRESS)
/* 
1.CREATE FOLDER STRUCTURE
Create folder __test__/cypress usnder src

>cd __test__/cypress
>sudo npm install cypress
>sudo npm test OR npx cypress open  -->Opens a cypress UI 
                                   Choose e2e testing type, Continue,Choose browser , Create a empty new spec filename.cy.js
                                   A folder structure will be created for you 
                                   cypress/cypress/e2e,fixtures,support.
                                   cypress/cypress.json

2.INSTALL
>sudo npm install cypress

3.ADD TO PACKAGE.JSON
package.json
"name": "server",                                           
"scripts": {                               
  "test": "cypress open"         -->npm test =  npx cypress open
},  

Create a file named .eslintrc.json at same level as cypressjson and add the following
{
    "extends": [
      "plugin:cypress/recommended"
    ]
  }

 Rerun terminal to reflect changes in package.json
 
4.WEITE TESTS 
cypress/cypress/e2e/filename.cy.js
describe(())                             -->write your code here


                                                      
4.RUN TESTS
>cd client/src/__test__/cypress ie on cypress.json levek
>npm test OR npx cypress open 
>In cypress UI upen the filename.cy.js to run cypress

*/

/* #endregion */

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
    |-test                   -->Test cases    
      |-client.test.js                            
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
                                                                                                               



