import * as dunamisTestConstants from "../../../constants/dunamisTestConstants"
const performTasks = (configGuid,inputJSON,iaaCSV) =>{
  //VISIT BASE URL
  cy.visit('http://localhost:3001')

  //ENTER VALUES
  cy.get('[data-testid ="configGuid"]').type("configGuid",{
    parseSpecialCharSequences: false,
  });
  cy.get('[data-testid ="InputJson"]').type("inputJSON",{
    parseSpecialCharSequences: false,
  });

  cy.get('[data-testid ="IaaCSV"]').type("iaaCSV",{
    parseSpecialCharSequences: false,
  });

  //ENTER BUTTONS
  cy.get('[data-testid ="dunamis_setIaasMapping"]').click(); 
  cy.get('[data-testid ="dunamis_getIaasMapping"]').click();
  cy.get('[data-testid ="Modal"]')  
    .should('be.visible')
    .find('.modal-header')
    .get('[data-testid="ModalClose"]')
    .should('contain', 'x')               
    //.click()
  cy.get('[data-testid ="dunamis_transformIaasToIngestSDM"]').click();









}

describe('Visit Landing Page', () => {
  it('Visit Landing Page', () => {
    cy.visit('http://localhost:3001')
  })
})

describe('Test Eend to End ',()=>{
  it('Test1', () => {
    let configGuid = dunamisTestConstants.configGuid1;
    let inputJSON = dunamisTestConstants.inputJson1;
    let iaaCSV = dunamisTestConstants.iaasCSV1;
    

    performTasks(configGuid,inputJSON,iaaCSV);
  })
})