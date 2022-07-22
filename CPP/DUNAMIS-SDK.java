//dunamis-sdk
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


MORE TEST CASES
dunamis-sdk-test me eventtransformer_test.cpp
TransformParams{IaaCSV,IPJSON,OPJSON)

*/


//dunamis-iaas
/*
database.js
function insertIntoTable(connection, databaseName, tableName, values) {
  let value = values[1].replaceAll("\\", "\\\\"); //TODO:ADDED
  let insertIntoTable = `
}

stitchedRegex.js
match(patternString,value){
    //TODO:NOTADDED 
    //regex_constants::syntax_option_type flags{};
    //flags |= matchNoCase_ ? regex_constants::icase : regex_constants::syntax_option_type{};
    //regex pattern{patternString, flags};     
    
    let flags = (this.matchNoCase)?"i":"";
    let regex = new RegExp(patternString,flags);

    let match = [];
    if(typeof value === 'object'){        //TODO:ADDED  convert value of any datatatype to string 
        value = JSON.stringify(value);    
    } 
}

hasMissingReferences(formatString){
    let hasMissingRefs = false;
    let numberReferences = formatString.match(DUNAMIS_REGEX_PATTERN_SUB_EXPR_REFS);
    if(numberReferences != null && numberReferences.length != 0){
        let present = true;  //TODO:ADDED took present outside and added present && inside 
        for(let numberReference of numberReferences){
            let numberReferenceProperties = this.formatStringForNumberedReference(numberReference); //TODO:ADDED
            ..
        }
    }
    if(DUNAMIS_REGEX_SUPPORT_NAMED_SUB_EXPR){
      if(hasMissingRefs)
          return hasMissingRefs;

      let namedReferences = formatString.match(DUNAMIS_REGEX_PATTERN_NAMED_SUB_EXPR_REFS);
      if(namedReferences != null && namedReferences.length != 0){   
          let present = true;  //TODO:ADDED took present outside and added present && inside 
          for(let namedReference of namedReferences){
}

format(){
  let numberReferences = formatString.match(DUNAMIS_REGEX_PATTERN_SUB_EXPR_REFS);
  if(numberReferences  !== null && numberReferences.length != 0){
      for(let numberReference of numberReferences){
          let numberReferenceProperties = this.formatStringForNumberedReference(numberReference); //TODO:ADDED
          numberReference = numberReferenceProperties["formatString"]; 
      }
  }

  formatString = formatString = formatString.replaceAll("$$","$");   //TODO:ADDED  
  formatString = this.formatStringForEscapeCharacters(formatString); //TODO:ADDED 
  return formatString;
}

transformFindReplaceHelper.js
function addNamedCaptures(inputJsonObj,rule){
    for(let inputJsonObjKey in inputJsonObj){
        if(isValidName(inputJsonObjKey)){ //TODO:ADDED
            rule.find.push([inputJsonObjKey,"(?<" + inputJsonObjKey + ">.*)"]); 
        }
        
    }
}

function  addReplacement(inputJsonObj,rule,srmatch){
    for(let kv of rule.replace){
        if(!srmatch.hasMissingReferences(kv[1])){
            let sKey = kv[0];
            let formattedValue = srmatch.format(kv[1]);
            let sValue = formattedValue;

            if(sKey in inputJsonObj){     //TODO:ADDED  To add duplicate keys in object 
                sKey = sKey + " ";
            }
            inputJsonObj[sKey] = sValue;
        }
    }
}

*/





