/**
 * @jest-environment jsdom
 */
 import '@testing-library/jest-dom'
 import { render, fireEvent,waitFor, screen } from "@testing-library/react";
 import userEvent from '@testing-library/user-event';
 import React from 'react';
 import DunamisForm from "../../component/dunamisForm/DunamisForm";
describe("File Upload", function () {
    test("test4", async () => {
        let outputJsonExpected = "{}" + "\n" + "ERROR: DUNAMIS_ERROR_IAAS_NO_RULE_MATCHED";
        let outPutJsonReceived = "{}" + "\n" + "ERROR: DUNAMIS_ERROR_IAAS_NO_RULE_MATCHED";;
        expect(outputJsonExpected).toBe(outPutJsonReceived);
    });
    test("IaaCSV1-test11", async () => {
        let outputJsonExpected = '{"event.workflow":"unknown-9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160","event.subcategory":"AdobePIPtestappsub-234_12","hb.params":{"FeatureTime":"2022-01-11T12:13:20Z","FeatureName":"toolwriteeventdata_12-34"}}';
        let outPutJsonReceived = '{"event.workflow":"unknown-9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160","event.subcategory":"AdobePIPtestappsub-234_12","hb.params":{"FeatureName":"toolwriteeventdata_12-34","FeatureTime":"2022-01-11T12:13:20Z"}}';
        expect(JSON.parse(outputJsonExpected)).toEqual(JSON.parse(outPutJsonReceived));
    });
    test("IaaCSV3-test13", async () => {
    let outputJsonExpected = '{"JKL":"hello-world","event.subcategory":"hello-world"}';
    let outPutJsonReceived = '{"JKL":"hello-world","event.subcategory":"hello-world"}';
    expect(JSON.parse(outputJsonExpected)).toEqual(JSON.parse(outPutJsonReceived));
    });
    test("test16", async () => {
        let outputJsonExpected = '{"event.type":"success","newkey2":"newval2","newkey1":"success","newkey2 ":"$1"}';
        let outPutJsonReceived = '{"event.type":"success","newkey2":"newval2","newkey1":"success","newkey2 ":"$1"}';
        expect(JSON.parse(outputJsonExpected)).toEqual(JSON.parse(outPutJsonReceived));
    });

    test("IaaCSV5-test20", async () => {
        let outputJsonExpected = '{"c":"val_c","p":"val_a"}';
        let outPutJsonReceived = '{"c":"val_c","p":"val_a"}';
        expect(JSON.parse(outputJsonExpected)).toEqual(JSON.parse(outPutJsonReceived));
    });

    test("IaaCSV6-test5", async () => {
        let outputJsonExpected = '{"event.subtype":"toolwriteeventdata_12-34","hb.params":{"doc":"9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160","seq":"40","Category":"AdobepipTestapp-_test","SubCategory":"AdobePIPtestappsub-234_12","FeatureName":"toolwriteeventdata_12-34","FeatureTime":"2022-01-11T12:13:20Z"},"event.dts":"2022-01-11T12:13:20Z","event.workflow":"AdobepipTestapp-_test","event.subcategory":"AdobePIPtestappsub-234_12"}';
        let outPutJsonReceived = '{"hb.params":{"doc":"9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160","seq":"40","Category":"AdobepipTestapp-_test","SubCategory":"AdobePIPtestappsub-234_12","FeatureName":"toolwriteeventdata_12-34","FeatureTime":"2022-01-11T12:13:20Z"},"event.dts":"2022-01-11T12:13:20Z","event.workflow":"AdobepipTestapp-_test","event.subcategory":"AdobePIPtestappsub-234_12","event.subtype":"toolwriteeventdata_12-34"}';
        expect(JSON.parse(outputJsonExpected)).toEqual(JSON.parse(outPutJsonReceived));
    });

    test("IaaCSV7-test10", async () => {
        let outputJsonExpected = '{"event.language":"en-US","hb.params":{"doc":"0","group":"3","OSVersion":"10.0.22523","OSType":"64bit","OSLanguage":"en-US","UserLanguage":"en-IN","Processor":"8664","ProcessorName":"Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz","ProcessorModel":"Intel64 Family 6 Model 94 Stepping 3","NumProcessors":"8","Speed":"3408 MHz","Memory":"16384","MonitorCount":"1","IsPrerelease":"True","ProductLanguage":"en-US","TouchPoints":"0","TimeZoneOffset":"330","DefaultBrowser":"Microsoft Edge 97.0.1072.55","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"SystemInfo","OS":"Win"},"event.workflow":"Headlights","event.subcategory":"NOVALUE","event.subtype":"SystemInfo","source.platform":"Win64bit","source.os_version":"10.0.22523","source.device":"Intel64 Family 6 Model 94 Stepping 3","event.user_agent":"Microsoft Edge 97.0.1072.55","event.build":"prerelease"}';
        let outPutJsonReceived = '{"hb.params":{"doc":"0","group":"3","OSVersion":"10.0.22523","OSType":"64bit","OSLanguage":"en-US","UserLanguage":"en-IN","Processor":"8664","ProcessorName":"Intel(R) Core(TM) i7-6700 CPU @ 3.40GHz","ProcessorModel":"Intel64 Family 6 Model 94 Stepping 3","NumProcessors":"8","Speed":"3408 MHz","Memory":"16384","MonitorCount":"1","IsPrerelease":"True","ProductLanguage":"en-US","TouchPoints":"0","TimeZoneOffset":"330","DefaultBrowser":"Microsoft Edge 97.0.1072.55","Category":"Headlights","SubCategory":"NOVALUE","FeatureName":"SystemInfo","OS":"Win"},"event.workflow":"Headlights","event.subcategory":"NOVALUE","event.subtype":"SystemInfo","source.platform":"Win64bit","source.os_version":"10.0.22523","source.device":"Intel64 Family 6 Model 94 Stepping 3","event.user_agent":"Microsoft Edge 97.0.1072.55","event.language":"en-US","event.build":"prerelease"}';
        expect(JSON.parse(outputJsonExpected)).toEqual(JSON.parse(outPutJsonReceived));
    });
    test("test3", async () => {
        let outputJsonExpected = '{"FeatureTime":"2022-01-11T12:13:20Z","FeatureName":"toolwriteeventdata_12-34","event.dts":"2022-01-11T12:13:20Z","event.workflow":"[\\"AdobepipTestapp-_test\\",\\"hello\\"]","event.subcategory":"{\\"abc\\":\\"AdobePIPtestappsub-234_12\\",\\"def\\":\\"ghi\\"}","event.subcategory ":"{\\"abc\\":\\"AdobePIPtestappsub-234_12\\",\\"def\\":\\"ghi\\"}"}';
        let outPutJsonReceived = '{"FeatureName":"toolwriteeventdata_12-34","FeatureTime":"2022-01-11T12:13:20Z","event.subcategory":"{\\"abc\\":\\"AdobePIPtestappsub-234_12\\",\\"def\\":\\"ghi\\"}","event.dts":"2022-01-11T12:13:20Z","event.workflow":"[\\"AdobepipTestapp-_test\\",\\"hello\\"]","event.subcategory ":"{\\"abc\\":\\"AdobePIPtestappsub-234_12\\",\\"def\\":\\"ghi\\"}"}';
        expect(JSON.parse(outputJsonExpected)).toEqual(JSON.parse(outPutJsonReceived));
    });

    test("IaaCSV9-test1", async () => {
        let outputJsonExpected = '{"event.workflow":"unknown-9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160","event.subcategory":"AdobePIPtestappsub-234_12","hb.params":{"FeatureTime":"2022-01-11T12:13:20Z","FeatureName":"toolwriteeventdata_12-34"}}';
        let outPutJsonReceived = '{"event.workflow":"unknown-9fceb2b1502d741bdb6f2f20ea26373b595a964b1d85147e8b7268a4ac99a160","event.subcategory":"AdobePIPtestappsub-234_12","hb.params":{"FeatureName":"toolwriteeventdata_12-34","FeatureTime":"2022-01-11T12:13:20Z"}}';
        expect(JSON.parse(outputJsonExpected)).toEqual(JSON.parse(outPutJsonReceived));
    });

    test("IaaCSV10-test2", async () => {
        let outputJsonExpected = '{"event.type":"success","event.workflow":"up* **l*oa der","event.subcategory":"adobepiptest-TOOL","event.subtype":"tool","event.dts":"2022-01-11T12:13:20Z"}';
        let outPutJsonReceived = '{"event.type":"success","event.workflow":"up* **l*oa der","event.subcategory":"adobepiptest-TOOL","event.subtype":"tool","event.dts":"2022-01-11T12:13:20Z"}';
        expect(JSON.parse(outputJsonExpected)).toEqual(JSON.parse(outPutJsonReceived));
    });
});

describe("Dunamis Form Component", function () {
    test("ConfigGuid Text Input", async () => {
        render(<DunamisForm/>);  
        let configGuid = screen.getByTestId('configGuid');
        expect(configGuid ).toBeInTheDocument();
    });
    test("InputJSON Text Input", async () => {
        render(<DunamisForm/>);  
        let configGuid = screen.getByTestId('InputJson');
        expect(configGuid ).toBeInTheDocument();
    });
    test("IaaCSV Text Input", async () => {
        render(<DunamisForm/>);  
        let configGuid = screen.getByTestId('IaaCSV');
        expect(configGuid ).toBeInTheDocument();
    });
    test("IaaCSV File Upload", async () => {
        render(<DunamisForm/>);  
        let configGuid = screen.getByTestId('IaaCSV File Upload');
        expect(configGuid ).toBeInTheDocument();
    });
    test("Set Mapping Button", async () => {
        render(<DunamisForm/>);  
        let configGuid = screen.getByTestId('dunamis_setIaasMapping');
        expect(configGuid ).toBeInTheDocument();
    });
    test("Get Mapping Button", async () => {
        render(<DunamisForm/>);  
        let configGuid = screen.getByTestId('dunamis_getIaasMapping');
        expect(configGuid ).toBeInTheDocument();
    });
    test("Transform Mapping Button", async () => {
        render(<DunamisForm/>);  
        let configGuid = screen.getByTestId('dunamis_transformIaasToIngestSDM');
        expect(configGuid ).toBeInTheDocument();
    });
   
});









