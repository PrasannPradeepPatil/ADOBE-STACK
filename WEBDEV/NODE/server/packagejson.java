/*
package.json                             INITIALISE JSON FILE
{                                         npm init                          

                                         PROPERTIES:When you create server these properties are set 
  "name": "server",                      name of dir     
  "version": "0.0.0",                    version of dir 
  "private": true,                       privacy of dir  
  "type":module                          add this to allow ES6 imports in Node 
                                  
  "scripts": {                          SCRIPTS: 
    "start":"node/nodemon ./bin/www"    sudo npm start = node/nodemon ./bin/www (node ./bin/www  runs app.js ; nodemon ./bin/www  runs app.js file with hot reload)
    "test": "jest --watchAll"           sudo npm test =  jest --watchAll (jest test runs .test.js file ;jest --watchAll will run all test cases with hot reload)
  },

  "dependencies": {                     DEPENDENCIES
    "cookie-parser": "~1.4.4",          sudo npm install packageName  packages get added in dependencies
  }                                     sudo npm install packageName --save-dev  package gets added in dev-dependencies and are not deployed
  "dev-dependencies": {                                              
  },
                                         BABEL(Write in package.json OR create a file .babelrc at src level and do module.exports = {"presets":[],"plugins":[]})
  "babel": {                             Used to convert ES6 to JS code for web
    "presets": []                        presets:  added to all files 
    "plugins":[]                         plugins:added to all files;=
  },
                                         JEST(Write in package.json OR create a file jest.test.js at src level and do module.exports = {"moduleNameMapper":{}}
  "jest":{                               Used for configure the test cases for jest
      "moduleNameMapper": {}             moduleWrapper: Elements to ignore while running jest;used for  igore CSS files  
  }
                                                                      

                                    //INSTALL PACKAGES
                                    >npm install                                             -->install the packages already mentioned in package.json 
                                    >npm install package@version                             -->install packages in node modules and add to dependencies{} in package.json
                                    >npm install package@version --save/save-prod(default)   -->install packages in node modules and add to dependencies{} in package.json
                                    >npm install package@version --save-dev                  -->install packages in node modules and add to dev-dependencies{} in package.json which are not deployed 
                                    >npm istall --force package@version                       -->force install package  if it is not getting install 


                                    //UNINSTALL PACKAGES                                        
                                    >npm uninstall packagename           -->In node_modules remove package
                                                                            remove package from package.json ka dependencies{}    

                                    //UPDATE PACKAGE
                                    >npm outdated                       --> show the package with outdated versions ; with current wanted and latest version
                                    >npm  update                        --> update the package to latest ver only if the majorversion is same ; else to wanted ver
                                                                            and updates package.json
                                    >npm-check-updates                  -->install check updates package
                                                                        and updates package.json
                                    >npm-check-updates and  ncu –u      --> update the outdated package to latest version in package.json
                                                                        and updates package.json
                                    >npm install                        --> update the outdated package to latest version 
                                                                            and updates package.json
                                                                            
                                                                                                
                                    //VIEW PACKAGES             
                                    > npm list                          --> view  all the  packages  and their sub dependencies;
                                                                            or view package.json
                                    > npm list  --depth=0               --> view all the  packages 
                                                                            or view package.json
                                    >npm view packagename               --> view all the metadata of a packages
                                                                            or view package.json  
                                    >npm view packagename dependencies  --> you can view all the dependencies of package 
                                                                            or view package.json
                                    >npm view packagename  version      --> you can view current   version of package
                                                                            or view package.json
                                    >npm view modulename versions       --> you can view current version of package
                                                                            or view package.json
                                    >npm outdated                      --> show the package with outdated versions ; with current wanted and latest version
                                                                            or view package.json

   
                                    //-G FLAG(COMANDS WITH -G FLAG ARE TO BE WRITTEN WITH SUDO IN LINUX)
                                    -g flag -->Without -g the package will be installed in node_modules of current directory
                                               With -g flag the package will be installed in node_modules globally where node is oinstalled so all applications can acess it
                                               Eg npm install – g packagename@version -- install package globally so available for all packages
                                                  npm uninstall –g packagename          --uninstall global package
                                                  npm list –g ; npm list –g –depth=0 ; npm view –g packagename and so on 

                                    //DEPENDENCY STRUCTIRE
                                    “packageName: ^/~ majorVersion.minorVersion.patchVersion”
                                    patchversion = bug fix ;
                                    minorVersion = changes without disturbing API;
                                    majorVersion = change API itself 
                                    ^ --> supose you have a “module: ^4.1.13” and someone   forks your   repo and performs      
                                        npm –i modulename which my have diff version later in time   ; then
                                        ^ tells install modue as long as its major version = 4  so ^4.1.8 can be written as ^4.x
                                    ~ --> tells install module as long as major version = 4 ; minor version = 1 so ~4.1.8 can be        
                                            written as ~4.1.x
                                    no % or ~ --> install the exact version so this is the best 

*/