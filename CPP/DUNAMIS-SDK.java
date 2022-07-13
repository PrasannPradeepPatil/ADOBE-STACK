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


MORE TEST CASES
dunamis-sdk-test me eventtransformer_test.cpp
TransformParams{IaaCSV,IPJSON,OPJSON)









 */


//MAPPINGS
//csvData1
/*
{
  "originalFile": [],
  "header": ['CONFIG','IN_doc',...],
  "content":[
    {
        "header": ['CONFIG','IN_doc',...],
        "values":['  missing-key-value=unknown','(?<doc>.*)',..]
    }
    {
        "header": ['CONFIG','IN_doc',...],
        "values":['  non-standard-keys=exclude','','',...]
    }
  ]



*/
//mapping1
/*
1.config
{
  rules: [
        { 
        "config":   {
                       'missing-key-value': 'unknown' 
                   },
        "find":    [
                        [ 'doc', '(?<doc>.*)' ],
                        [ 'seq', '(.*)' ],
                        [ 'Category', '(.*)' ],
                        [ 'SubCategory', '(.*)' ],
                    ]
        "replace"  :[
                        [ 'event.workflow', '$3-$+{doc}' ],
                        [ 'event.subcategory', '$4' ],
                    ]
        "findcount":=4
        },

        { 
        "config":   {
                        'non-standard-keys': 'include'
                    },
        "find":     [
                    ]
        "replace"  :[
                        [ 'hb.params', '$0' ]
                    ]  
        "findcount":0
        },
        
        { 
        "config":   {
                        'non-standard-keys': 'exclude'
                    },
        "find":    [
                    ]
        "replace"  :[
                    ]  
        "findcount":0
        },





    ]
  sourceKeys: [
    'doc',
    'seq',
    'Category',
    'SubCategory',
    'FeatureName',
    'FeatureTime'
  ],
  targetKeys: [
    'event.workflow',
    'event.subcategory',
    'event.subtype',
    'event.dts',
    'hb.params'
  ]
}


 */
//ipJson1
/*

{
'doc': '9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160',
'SubCategory': 'AdobePIPtestappsub-234_12',
'FeatureName': 'toolwriteeventdata_12-34',
'FeatureTime': '2022-01-11T12:13:20Z'
}


*/

//mapping2
/*
{
  rules: [
        {
            config: { 'search-replace-substrings': 'true' },
            find: [
                    [ 'Category', '/[\\\\[\\\\]\\\\(\\\\)]/* /g' ],
                    [ 'FeatureTime', '/\\\\s*(\\\\S(.*\\\\S)?)\\\\s* /$1/' ]
                ],
            replace: [],
            findCount: 2
        }
        { "
            config: {}, 
            find: [], 
            replace: [
                [ 'event.workflow', '"$+{Category}"' ],
                [ 'event.subcategory', '\\L$+{SubCategory}-\\U$+{FeatureName}' ],
                [ 'event.subtype', '$+{FeatureName}' ]
            ], 
            findCount: 0 
        },
        { 
            config: { 'non-standard-keys': 'exclude' },
            find: [], 
            replace: [ 
                [ 'event.dts', '$+{FeatureTime}' ] ],
            findCount: 0 
        },
        { 
            config: {'non-standard-keys': 'exclude'}, 
            find: [], 
            replace: [], 
            findCount: 0 
        }
  ],
  sourceKeys: [ 'Category', 'SubCategory', 'FeatureTime' ],
  targetKeys: [
    'event.workflow',
    'event.subcategory',
    'event.subtype',
    'event.dts'
  ]
}
*/
