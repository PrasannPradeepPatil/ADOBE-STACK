//https://github.com/visionmedia/supertest

//IMPORT
const request = require('supertest');
const assert = require('assert');
const express = require('express');

describe('Test Group 1', function() {
    test("test1", async()=>{
        //let res = fnFromServerFolderYouWantToTest() 
        let res = 2*2;
        expect(res).toBe(4);

    });
    test("test2", ()=>{
    }) ;
});


