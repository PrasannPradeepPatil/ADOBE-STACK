let dunamisTestCSV = require('./dunamisTestCSV.js');

export let configGuid1 = '1';
export let iaasCSV1 = dunamisTestCSV.iaasCSV9;
export let inputJson1 = '{"doc":"9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160","SubCategory":"AdobePIPtestappsub-234_12","FeatureName":"toolwriteeventdata_12-34","FeatureTime":"2022-01-11T12:13:20Z"}';
export let outputJson1 = '{"event.workflow":"unknown-9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160","event.subcategory":"AdobePIPtestappsub-234_12","hb.params":{"FeatureTime":"2022-01-11T12:13:20Z","FeatureName":"toolwriteeventdata_12-34"}}';
//error_code()

export let configGuid2 = '2';
export let iaasCSV2 = dunamisTestCSV.iaasCSV10;
export let inputJson2 = '{"Category":"up] [(l)oa der","SubCategory":"AdobePIPtest","FeatureName":"tool","FeatureTime":"    2022-01-11T12:13:20Z   ","event.type":"success"}';
export let outputJson2 = '{"event.type":"success","event.workflow":"up* **l*oa der","event.subcategory":"adobepiptest-TOOL","event.subtype":"tool","event.dts":"2022-01-11T12:13:20Z"}';
//error_code()

export let configGuid3 = '3';
export let iaasCSV3 = dunamisTestCSV.iaasCSV8;
export let inputJson3 = '{"doc":{"hello":"9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160"},"seq":"40","Category":["AdobepipTestapp-_test","hello"],"SubCategory":{"abc":"AdobePIPtestappsub-234_12","def":"ghi"},"FeatureName":"toolwriteeventdata_12-34","FeatureTime":"2022-01-11T12:13:20Z"}';
export let outputJson3 = '{"FeatureTime":"2022-01-11T12:13:20Z","FeatureName":"toolwriteeventdata_12-34","event.dts":"2022-01-11T12:13:20Z","event.workflow":"[\\"AdobepipTestapp-_test\\",\\"hello\\"]","event.subcategory":"{\\"abc\\":\\"AdobePIPtestappsub-234_12\\",\\"def\\":\\"ghi\\"}","event.subcategory ":"{\\"abc\\":\\"AdobePIPtestappsub-234_12\\",\\"def\\":\\"ghi\\"}"}';
// error_code()


export let configGuid4 = '4';
export let iaasCSV4 = dunamisTestCSV.nullJson;
export let inputJson4 = '{"ABC":"success"}';
export let outputJson4= dunamisTestCSV.nullJson + "\n" + "ERROR: DUNAMIS_ERROR_IAAS_NO_RULE_MATCHED";
//make_error_code(DUNAMIS_ERROR_IAAS_NO_RULE_MATCHED)


export let configGuid5 = '5';
export let iaasCSV5= dunamisTestCSV.iaasCSV6;
export let inputJson5 = '{"doc":"9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160","seq":"40","Category":"AdobepipTestapp-_test","SubCategory":"AdobePIPtestappsub-234_12","FeatureName":"toolwriteeventdata_12-34","FeatureTime":"2022-01-11T12:13:20Z","hb.params":{"doc":"9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160","seq":"40","Category":"AdobepipTestapp-_test","SubCategory":"AdobePIPtestappsub-234_12","FeatureName":"toolwriteeventdata_12-34","FeatureTime":"2022-01-11T12:13:20Z"}}';
export let outputJson5= '{"event.subtype":"toolwriteeventdata_12-34","hb.params":{"doc":"9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160","seq":"40","Category":"AdobepipTestapp-_test","SubCategory":"AdobePIPtestappsub-234_12","FeatureName":"toolwriteeventdata_12-34","FeatureTime":"2022-01-11T12:13:20Z"},"event.dts":"2022-01-11T12:13:20Z","event.workflow":"AdobepipTestapp-_test","event.subcategory":"AdobePIPtestappsub-234_12"}';
// error_code()


export let configGuid6 = '6';
export let iaasCSV6 = dunamisTestCSV.iaasCSV6;
export let inputJson6 = '{"doc":"Event1","seq":"41","Category":"AdobePIPTestAPP-unobfuscated_12-34","SubCategory":"AdobePIPTestSub-unobfuscated_12-34","FeatureName":"tool-WriteEventData-unobfuscated_12-34","FeatureTime":"2022-01-11T12:15:31Z","hb.params":{"doc":"Event1","seq":"41","Category":"AdobePIPTestAPP-unobfuscated_12-34","SubCategory":"AdobePIPTestSub-unobfuscated_12-34","FeatureName":"tool-WriteEventData-unobfuscated_12-34","FeatureTime":"2022-01-11T12:15:31Z"}}';
export let outputJson6= '{"event.subtype":"tool-WriteEventData-unobfuscated_12-34","hb.params":{"doc":"Event1","seq":"41","Category":"AdobePIPTestAPP-unobfuscated_12-34","SubCategory":"AdobePIPTestSub-unobfuscated_12-34","FeatureName":"tool-WriteEventData-unobfuscated_12-34","FeatureTime":"2022-01-11T12:15:31Z"},"event.dts":"2022-01-11T12:15:31Z","event.workflow":"AdobePIPTestAPP-unobfuscated_12-34","event.subcategory":"AdobePIPTestSub-unobfuscated_12-34"}';
// error_code()


export let configGuid7 = '7';
export let iaasCSV7 = dunamisTestCSV.iaasCSV6;
export let inputJson7 = '{"doc":"0","group":"1","ProductFamily":"app_family","ProductName":"app_name","ProductVersion":"app_version","ProductBuild":"app_build","ProductLanguage":"app_lang","IsPrerelease":"False","MachineID":"7ab88143-51a9-4985-851d-712cb247cd20","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"Session","hb.params":{"doc":"0","group":"1","ProductFamily":"app_family","ProductName":"app_name","ProductVersion":"app_version","ProductBuild":"app_build","ProductLanguage":"app_lang","IsPrerelease":"False","MachineID":"7ab88143-51a9-4985-851d-712cb247cd20","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"Session","Records":[{"Name":"ProductFamily","Value":"app_family","seq":"2","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProductName","Value":"app_name","seq":"3","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProductVersion","Value":"app_version","seq":"4","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProductBuild","Value":"app_build","seq":"5","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProductLanguage","Value":"app_lang","seq":"6","timestamp":"2022-01-11T12:13:20Z"},{"Name":"IsPrerelease","Value":"False","seq":"7","timestamp":"2022-01-11T12:13:20Z"},{"Name":"MachineID","Value":"7ab88143-51a9-4985-851d-712cb247cd20","seq":"8","timestamp":"2022-01-11T12:13:20Z"}]}}';
export let outputJson7= '{"source.version":"app_version.app_build","event.subtype":"Session","event.device_guid":"7ab88143-51a9-4985-851d-712cb247cd20","event.workflow":"Headlights","hb.params":{"doc":"0","group":"1","ProductFamily":"app_family","ProductName":"app_name","ProductVersion":"app_version","ProductBuild":"app_build","ProductLanguage":"app_lang","IsPrerelease":"False","MachineID":"7ab88143-51a9-4985-851d-712cb247cd20","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"Session","Records":[{"Name":"ProductFamily","Value":"app_family","seq":"2","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProductName","Value":"app_name","seq":"3","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProductVersion","Value":"app_version","seq":"4","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProductBuild","Value":"app_build","seq":"5","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProductLanguage","Value":"app_lang","seq":"6","timestamp":"2022-01-11T12:13:20Z"},{"Name":"IsPrerelease","Value":"False","seq":"7","timestamp":"2022-01-11T12:13:20Z"},{"Name":"MachineID","Value":"7ab88143-51a9-4985-851d-712cb247cd20","seq":"8","timestamp":"2022-01-11T12:13:20Z"}]},"event.subcategory":"NOVALUE","source.name":"app_name","event.language":"app_lang"}';
// error_code()

export let configGuid8 = '8';
export let iaasCSV8 = dunamisTestCSV.iaasCSV6;
export let inputJson8 = '{"doc":"0","group":"2","LogType":"NOVALUE","IdleTimeThreshold":"1200","IdleTimeActiveBias":"5","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"SessionInfo","hb.params":{"doc":"0","group":"2","LogType":"NOVALUE","IdleTimeThreshold":"1200","IdleTimeActiveBias":"5","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"SessionInfo","Records":[{"Name":"LogType","Value":"NOVALUE","seq":"10","timestamp":"2022-01-11T12:13:20Z"},{"Name":"IdleTimeThreshold","Value":"1200","seq":"11","timestamp":"2022-01-11T12:13:20Z"},{"Name":"IdleTimeActiveBias","Value":"5","seq":"12","timestamp":"2022-01-11T12:13:20Z"}]}}';
export let outputJson8= '{"hb.params":{"doc":"0","group":"2","LogType":"NOVALUE","IdleTimeThreshold":"1200","IdleTimeActiveBias":"5","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"SessionInfo","Records":[{"Name":"LogType","Value":"NOVALUE","seq":"10","timestamp":"2022-01-11T12:13:20Z"},{"Name":"IdleTimeThreshold","Value":"1200","seq":"11","timestamp":"2022-01-11T12:13:20Z"},{"Name":"IdleTimeActiveBias","Value":"5","seq":"12","timestamp":"2022-01-11T12:13:20Z"}]},"event.workflow":"Headlights","event.subtype":"SessionInfo","event.subcategory":"NOVALUE"}';
// error_code()

export let configGuid9 = '9';
export let iaasCSV9 = dunamisTestCSV.iaasCSV6;
export let inputJson9 = '{"doc":"0","group":"3","OSVersion":"10.0.22523","OSType":"64bit","OSLanguage":"en-US","UserLanguage":"en-IN","Processor":"8664","ProcessorName":"Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz","ProcessorModel":"Intel64 Family 6 Model 94 Stepping 3","NumProcessors":"8","Speed":"3408 MHz","Memory":"16384","MonitorCount":"1","TouchPoints":"0","TimeZoneOffset":"330","DefaultBrowser":"Microsoft Edge 97.0.1072.55","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"SystemInfo","hb.params":{"doc":"0","group":"3","OSVersion":"10.0.22523","OSType":"64bit","OSLanguage":"en-US","UserLanguage":"en-IN","Processor":"8664","ProcessorName":"Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz","ProcessorModel":"Intel64 Family 6 Model 94 Stepping 3","NumProcessors":"8","Speed":"3408 MHz","Memory":"16384","MonitorCount":"1","TouchPoints":"0","TimeZoneOffset":"330","DefaultBrowser":"Microsoft Edge 97.0.1072.55","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"SystemInfo","Records":[{"Name":"OSVersion","Value":"10.0.22523","seq":"14","timestamp":"2022-01-11T12:13:20Z"},{"Name":"OSType","Value":"64bit","seq":"15","timestamp":"2022-01-11T12:13:20Z"},{"Name":"OSLanguage","Value":"en-US","seq":"16","timestamp":"2022-01-11T12:13:20Z"},{"Name":"UserLanguage","Value":"en-IN","seq":"17","timestamp":"2022-01-11T12:13:20Z"},{"Name":"Processor","Value":"8664","seq":"18","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProcessorName","Value":"Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz","seq":"19","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProcessorModel","Value":"Intel64 Family 6 Model 94 Stepping 3","seq":"20","timestamp":"2022-01-11T12:13:20Z"},{"Name":"NumProcessors","Value":"8","seq":"21","timestamp":"2022-01-11T12:13:20Z"},{"Name":"Speed","Value":"3408 MHz","seq":"22","timestamp":"2022-01-11T12:13:20Z"},{"Name":"Memory","Value":"16384","seq":"23","timestamp":"2022-01-11T12:13:20Z"},{"Name":"MonitorCount","Value":"1","seq":"24","timestamp":"2022-01-11T12:13:20Z"},{"Name":"TouchPoints","Value":"0","seq":"25","timestamp":"2022-01-11T12:13:20Z"},{"Name":"TimeZoneOffset","Value":"330","seq":"26","timestamp":"2022-01-11T12:13:20Z"},{"Name":"DefaultBrowser","Value":"Microsoft Edge 97.0.1072.55","seq":"27","timestamp":"2022-01-11T12:13:20Z"}]}}';
export let outputJson9= '{"event.user_agent":"Microsoft Edge 97.0.1072.55","source.device":"Intel64 Family 6 Model 94 Stepping 3","event.subcategory":"NOVALUE","event.subtype":"SystemInfo","source.os_version":"10.0.22523","event.workflow":"Headlights","hb.params":{"doc":"0","group":"3","OSVersion":"10.0.22523","OSType":"64bit","OSLanguage":"en-US","UserLanguage":"en-IN","Processor":"8664","ProcessorName":"Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz","ProcessorModel":"Intel64 Family 6 Model 94 Stepping 3","NumProcessors":"8","Speed":"3408 MHz","Memory":"16384","MonitorCount":"1","TouchPoints":"0","TimeZoneOffset":"330","DefaultBrowser":"Microsoft Edge 97.0.1072.55","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"SystemInfo","Records":[{"Name":"OSVersion","Value":"10.0.22523","seq":"14","timestamp":"2022-01-11T12:13:20Z"},{"Name":"OSType","Value":"64bit","seq":"15","timestamp":"2022-01-11T12:13:20Z"},{"Name":"OSLanguage","Value":"en-US","seq":"16","timestamp":"2022-01-11T12:13:20Z"},{"Name":"UserLanguage","Value":"en-IN","seq":"17","timestamp":"2022-01-11T12:13:20Z"},{"Name":"Processor","Value":"8664","seq":"18","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProcessorName","Value":"Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz","seq":"19","timestamp":"2022-01-11T12:13:20Z"},{"Name":"ProcessorModel","Value":"Intel64 Family 6 Model 94 Stepping 3","seq":"20","timestamp":"2022-01-11T12:13:20Z"},{"Name":"NumProcessors","Value":"8","seq":"21","timestamp":"2022-01-11T12:13:20Z"},{"Name":"Speed","Value":"3408 MHz","seq":"22","timestamp":"2022-01-11T12:13:20Z"},{"Name":"Memory","Value":"16384","seq":"23","timestamp":"2022-01-11T12:13:20Z"},{"Name":"MonitorCount","Value":"1","seq":"24","timestamp":"2022-01-11T12:13:20Z"},{"Name":"TouchPoints","Value":"0","seq":"25","timestamp":"2022-01-11T12:13:20Z"},{"Name":"TimeZoneOffset","Value":"330","seq":"26","timestamp":"2022-01-11T12:13:20Z"},{"Name":"DefaultBrowser","Value":"Microsoft Edge 97.0.1072.55","seq":"27","timestamp":"2022-01-11T12:13:20Z"}]}}';
// error_code()

export let configGuid10 = '10';
export let iaasCSV10 = dunamisTestCSV.iaasCSV7;
export let inputJson10 = '{"doc":"0","group":"3","OSVersion":"10.0.22523","OSType":"64bit","OSLanguage":"en-US","UserLanguage":"en-IN","Processor":"8664","ProcessorName":"Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz","ProcessorModel":"Intel64 Family 6 Model 94 Stepping 3","NumProcessors":"8","Speed":"3408 MHz","Memory":"16384","MonitorCount":"1","IsPrerelease":"True","ProductLanguage":"en-US","TouchPoints":"0","TimeZoneOffset":"330","DefaultBrowser":"Microsoft Edge 97.0.1072.55","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"SystemInfo","OS":"Win"}';
export let outputJson10 = '{"event.language":"en-US","hb.params":{"doc":"0","group":"3","OSVersion":"10.0.22523","OSType":"64bit","OSLanguage":"en-US","UserLanguage":"en-IN","Processor":"8664","ProcessorName":"Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz","ProcessorModel":"Intel64 Family 6 Model 94 Stepping 3","NumProcessors":"8","Speed":"3408 MHz","Memory":"16384","MonitorCount":"1","IsPrerelease":"True","ProductLanguage":"en-US","TouchPoints":"0","TimeZoneOffset":"330","DefaultBrowser":"Microsoft Edge 97.0.1072.55","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"SystemInfo","OS":"Win"},"event.workflow":"Headlights","event.subcategory":"NOVALUE","event.subtype":"SystemInfo","source.platform":"Win64bit","source.os_version":"10.0.22523","source.device":"Intel64 Family 6 Model 94 Stepping 3","event.user_agent":"Microsoft Edge 97.0.1072.55","event.build":"prerelease"}';
// error_code()


export let configGuid11 = '11';
export let iaasCSV11 = dunamisTestCSV.iaasCSV1;
export let inputJson11 = '{';
export let outputJson11= dunamisTestCSV.nullJson + "\n" + "ERROR: DUNAMIS_ERROR_INVALID_JSON";
// make_error_code(DUNAMIS_ERROR_INVALID_JSON)


export let configGuid12 = '12';
export let iaasCSV12 = dunamisTestCSV.iaasCSV1;
export let inputJson12 = '{"ABC":"success"}';
export let outputJson12= '{"event.type":"success"}'
// error_code()


export let configGuid13 = '13';
export let iaasCSV13 = dunamisTestCSV.iaasCSV3;
export let inputJson13 = '{"GHI":"hello-world","JKL":"hello-world"}';
export let outputJson13= '{"JKL":"hello-world","event.subcategory":"hello-world"}'
// error_code()

export let configGuid14 = '14';
export let iaasCSV14  = dunamisTestCSV.iaasCSV3;
export let inputJson14 = '{"ABC":"success","DEF":"failure"}';
export let outputJson14= '{}'
// error_code()

export let configGuid15 = '15';
export let iaasCSV15 = dunamisTestCSV.iaasCSV3;
export let inputJson15 = '{"ABC":"success","DEF":"failure","GHI":"unknown"}';
export let outputJson15= '{"GHI":"unknown"}'
// error_code()


export let configGuid16 = '16';
export let iaasCSV16 = dunamisTestCSV.iaasCSV4;
export let inputJson16 = '{"activityname":"click","type":"oldval2","monitor":"oldval3","oldkey1":"hello","oldkey2":"oldval2"}';
export let outputJson16= '{"event.type":"success","newkey2":"newval2","newkey1":"success","newkey2 ":"$1"}'
// error_code()

export let configGuid17 = '17';
export let iaasCSV17 = dunamisTestCSV.iaasCSV4;
export let inputJson17 = '{"activityname":"click","type":"oldval2","oldkey1":"value"}';
export let outputJson17= dunamisTestCSV.nullJson + "\n" + "ERROR: DUNAMIS_ERROR_IAAS_NO_RULE_MATCHED";
//make_error_code(DUNAMIS_ERROR_IAAS_NO_RULE_MATCHED)


export let configGuid18 = '18';
export let iaasCSV18 = dunamisTestCSV.iaasCSV4;
export let inputJson18 = '{"activityname":"sample","type":"some+type","oldkey1":"value","oldkey2":"oldval2"}';
export let outputJson18= '{"activityname":"sample","newkey1":"some+type","newkey2":"some+type$value"}'
// error_code()


export let configGuid19 = '19';
export let iaasCSV19 = dunamisTestCSV.iaasCSV4;
export let inputJson19 = '{"ABC":"success"}';
export let outputJson19= dunamisTestCSV.nullJson + "\n" + "ERROR: DUNAMIS_ERROR_IAAS_NO_RULE_MATCHED";
//  make_error_code(DUNAMIS_ERROR_IAAS_NO_RULE_MATCHED)

export let configGuid20 = '20';
export let iaasCSV20 = dunamisTestCSV.iaasCSV5;
export let inputJson20 = '{"a":"val_a","c":"val_c"}';
export let outputJson20= '{"c":"val_c","p":"val_a"}';
// error_code()


export let configGuid21 = '21';
export let iaasCSV21 = dunamisTestCSV.iaasCSV5;
export let inputJson21 = '{"a":"val_a","b":"val_b","c":"val_c"}';
export let outputJson21= '{"c":"val_c","q":"val_a-val_b"}';
// error_code()

export let configGuid22 = '22';
export let iaasCSV22 = dunamisTestCSV.iaasCSV5;
export let inputJson22 = '{"a":"pqrabcxyz","b":"val_b"}';
export let outputJson22= '{"b":"val_b","p":"pqr","q":"abc","r":"xyz"}';
// error_code()

export let configGuid23 = '23';
export let iaasCSV23 = dunamisTestCSV.iaasCSV5;
export let inputJson23 = '{"a":"pqrabcxyz","c":"val_y","d":"def"}';
export let outputJson23= '{"t":"def","r":"val_y","s":"def","p":"pqr","q":"abc","r ":"xyz"}'
// error_code()

export let configGuid24 = '24';
export let iaasCSV24 = dunamisTestCSV.iaasCSV5;
export let inputJson24 = '{"a":"val_a","b":"val_b","c":"val_c","d":"val_d","e":"val_e"}';
export let outputJson24= '{"p":"val_p","q":"val_q","r":"val_r","s":"val_s","t":"val_t"}';
// error_code()

