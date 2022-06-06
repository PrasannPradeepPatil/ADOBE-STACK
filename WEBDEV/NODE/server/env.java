/*
//SET ENV VAR
>export/set VAR_NAME=value  //linux/windows  
OR
.env ;.env.example -->gitignore .env because to some variables must be kept private like mongodb url  ;dont gitignore  .env.exampe because it will show user the variables to include             
VARNAME = value    -->make sure varname does not clash with other varname because if they clash app crashes
                     PORT = 3000                     -->bin/www.js uses process.env.PORT ||3000   which is port for server
                     MONGODB_CONNECTION_PORT = 5000  -->app.js  uses process.env.MONGODB_CONNECTION_PORT||5000  which is port for mongodb connection to server
                                                       so using different variable prevent clashing of ports
      
      


//USE ENV VAR
var dotenv = require('dotenv');              //sudo npm install (while project creation)
dotenv.config();
process.env.VAR_NAME                        


*/