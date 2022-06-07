//RUN
/*
DUNAMIS SDK
>cd dunamis-sdk
>call .venv/scripts/activate
>set ARTIFACTORY_API_KEY=AKCp8mZ8QX71vFuLXxWcgwuCVasMLo8DpZXt1YMmXdXiohPuW7GkHLD3nB6HU4cacSvzit6ms       FOR WINDOWS
 export ARTIFACTORY_API_KEY=AKCp8mZ8QX71vFuLXxWcgwuCVasMLo8DpZXt1YMmXdXiohPuW7GkHLD3nB6HU4cacSvzit6ms    FOR LINUX
>metabuild prepare -p win32


DUNSMIS SDK SAMPLES
>cd dunamis-sdk
>call .venv/scripts/activate
>cd  dunamis-sdk-sample
>call .venv/scripts/activate
>set ARTIFACTORY_API_KEY=AKCp8mZ8QX71vFuLXxWcgwuCVasMLo8DpZXt1YMmXdXiohPuW7GkHLD3nB6HU4cacSvzit6ms       FOR WINDOWS
 export ARTIFACTORY_API_KEY=AKCp8mZ8QX71vFuLXxWcgwuCVasMLo8DpZXt1YMmXdXiohPuW7GkHLD3nB6HU4cacSvzit6ms     FOR LINUX
>metabuild prepare -p win32

BUILD DUNAMIS SDK SAMPLES
1.Build dunamis-sdk-sample.sln(C:\Users\prasannpradp\Desktop\DUNAMIS\dunamis-sdk-sampleapps\dist\msvs_win32\project\dunamis-sdk-sample.sln)
In visual studio select open a project or soln and open the dunamis-sdk-sample.sln file
On menu bar click build > build soln

2.Run the build file(C:\Users\prasannpradp\Desktop\DUNAMIS\dunamis-sdk-sampleapps\dist\msvs_win32\Debug\x64\build)
After building the   file you can find the .app file



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