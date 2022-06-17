//RUN
/*
1.SETUP
DUNAMIS SDK
>cd dunamis-sdk
>call .venv/scripts/activate
>set ARTIFACTORY_API_KEY=AKCp8mZ8QX71vFuLXxWcgwuCVasMLo8DpZXt1YMmXdXiohPuW7GkHLD3nB6HU4cacSvzit6ms       FOR WINDOWS
 export ARTIFACTORY_API_KEY=AKCp8mZ8QX71vFuLXxWcgwuCVasMLo8DpZXt1YMmXdXiohPuW7GkHLD3nB6HU4cacSvzit6ms    FOR LINUX
>metabuild prepare -p win32 
 Create a dist folder

DUNSMIS SDK SAMPLES
>Indide of dunamis-sdk-sample write the file META.users.yaml
>cd dunamis-sdk
>call .venv/scripts/activate
>cd ../dunamis-sdk-sampleapps
>set ARTIFACTORY_API_KEY=AKCp8mZ8QX71vFuLXxWcgwuCVasMLo8DpZXt1YMmXdXiohPuW7GkHLD3nB6HU4cacSvzit6ms       FOR WINDOWS
 export ARTIFACTORY_API_KEY=AKCp8mZ8QX71vFuLXxWcgwuCVasMLo8DpZXt1YMmXdXiohPuW7GkHLD3nB6HU4cacSvzit6ms     FOR LINUX
>metabuild prepare -p win32 -t //:console-app
  Creates dunamis-sdk-sample.sln C:\Users\prasannpradp\Desktop\DUNAMIS\dunamis-sdk-sampleapps\dist\msvs_win32\project\dunamis-sdk-sample.sln
  Open dunamis-sdk-sample.sln in Visual studio
  Click View --> Click Solution Explorer which brings soln explorer on right -->-->In soln expl under dunamis-sdk-sample see console-app , right click and set as startup project


2.TEST
dunamis-sdk-sample/main.cpp/main() method -->Calls API directly
Put break point at rc = dunamis_setIaasMapping ;rc = dunamis_iaasToIngestSDM; after cout << ouptutjson
Press the run button 
dunamis_setIaasMapping()  ip: configGuid,iaasCSViaasCSV
                          op: store filename = configGuid , fileContent = iaasCSV at C:\Users\prasannpradp\AppData\Roaming\com.adobe.dunamis\configGuid
                              return error
dunamis_iaasToIngestSDM() ip:configGuid,ipJson,opJSON
                          op:based on configGuid find the file and acc to rules of file transform ipJson to opJson
                            return opJson 


MORE TEST CASES
2 API's ke andar ke methods -- dunamis-sdk-test/eventtransformer_test.cpp 
iaasCSV -- - dunamis-sdk-test/testconstants.cpp









 */


//META , DIST FOLDER
/*
META,dist-->dependency package manager on which we run command(metabuild prepare -p macos etc) and it throws a dist folder with all dependencies
dist -->store all dependencies

dist/git/adobe/meta-archives --> all dependencies are stored in this folder
META/dunamis-common.meta.py --.main meta files
META/dunamis-core.meta.py
META/dunamis-ingest.meta.py
META/dunamis-service.meta


*/


//DUNAMIS INGEST -->MAIN FOLDER
/*
dunamis-ingest/source --> includes all cpp internal header files
dunmis-ingest/include --> includes all cpp public header files
dunamis-ingest/include/dunamis.h --> API calls from client(each client will have an ingest instance)
                                     https://wiki.corp.adobe.com/display/dunamis/Dunamis+SDK#84604fac-c79c-458f-a3f5-91f0d52295db-2264152385

dunamis-ingest/include/dunamis.h -- ingest specific API
 */

//DUNAMIS INTERNAL
/*
dunamis-internal/dunamis-common
dunamis-internal/dunamis-core   -utils for common
dunamis-internal/dunamis-service
 */

 //WORKFLOW
 /*
 client -- dunamis.h
           (IAAS method
           are of importance) 

  */

  //STEPS
  /*
   1.Create a req response cycle on node
   2.Implement IAAS Functionality
   
   */

   //TO DOS
   /*
    *optional	
dunamis_setIaasMapping(configGUID, in csv string)

global	anytime	offline	-	Attaches CSV to configGUID, returns success or error
optional	dunamis_iaasToIngestSDM(configGUID, in JSON string, out JSON string)
    */