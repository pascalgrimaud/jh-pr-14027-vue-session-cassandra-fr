import {
  entityTableSelector,
  entityDetailsButtonSelector,
  entityDetailsBackButtonSelector,
  entityCreateButtonSelector,
  entityCreateSaveButtonSelector,
  entityEditButtonSelector,
  entityDeleteButtonSelector,
  entityConfirmDeleteButtonSelector,
} from '../../support/entity';

describe('CassTestServiceImplEntity e2e test', () => {
  let startingEntitiesCount = 0;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.clearCookie('SESSION');
    cy.clearCookies();
    cy.intercept('GET', '/api/cass-test-service-impl-entities*').as('entitiesRequest');
    cy.visit('');
    cy.login('admin', 'admin');
    cy.clickOnEntityMenuItem('cass-test-service-impl-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => (startingEntitiesCount = response.body.length));
    cy.visit('/');
  });

  it('should load CassTestServiceImplEntities', () => {
    cy.intercept('GET', '/api/cass-test-service-impl-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-impl-entity');
    cy.wait('@entitiesRequest');
    cy.getEntityHeading('CassTestServiceImplEntity').should('exist');
    if (startingEntitiesCount === 0) {
      cy.get(entityTableSelector).should('not.exist');
    } else {
      cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount);
    }
    cy.visit('/');
  });

  it('should load details CassTestServiceImplEntity page', () => {
    cy.intercept('GET', '/api/cass-test-service-impl-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-impl-entity');
    cy.wait('@entitiesRequest');
    if (startingEntitiesCount > 0) {
      cy.get(entityDetailsButtonSelector).first().click({ force: true });
      cy.getEntityDetailsHeading('cassTestServiceImplEntity');
      cy.get(entityDetailsBackButtonSelector).should('exist');
    }
    cy.visit('/');
  });

  it('should load create CassTestServiceImplEntity page', () => {
    cy.intercept('GET', '/api/cass-test-service-impl-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-impl-entity');
    cy.wait('@entitiesRequest');
    cy.get(entityCreateButtonSelector).click({ force: true });
    cy.getEntityCreateUpdateHeading('CassTestServiceImplEntity');
    cy.get(entityCreateSaveButtonSelector).should('exist');
    cy.visit('/');
  });

  it('should load edit CassTestServiceImplEntity page', () => {
    cy.intercept('GET', '/api/cass-test-service-impl-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-impl-entity');
    cy.wait('@entitiesRequest');
    if (startingEntitiesCount > 0) {
      cy.get(entityEditButtonSelector).first().click({ force: true });
      cy.getEntityCreateUpdateHeading('CassTestServiceImplEntity');
      cy.get(entityCreateSaveButtonSelector).should('exist');
    }
    cy.visit('/');
  });

  it('should create an instance of CassTestServiceImplEntity', () => {
    cy.intercept('GET', '/api/cass-test-service-impl-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-impl-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => (startingEntitiesCount = response.body.length));
    cy.get(entityCreateButtonSelector).click({ force: true });
    cy.getEntityCreateUpdateHeading('CassTestServiceImplEntity');

    cy.get(`[data-cy="stringField"]`).type('Inlet Manor', { force: true }).invoke('val').should('match', new RegExp('Inlet Manor'));

    cy.get(`[data-cy="stringRequiredField"]`)
      .type('syndicate Designer', { force: true })
      .invoke('val')
      .should('match', new RegExp('syndicate Designer'));

    cy.get(`[data-cy="stringMinlengthField"]`)
      .type('Customer Avon Consultant', { force: true })
      .invoke('val')
      .should('match', new RegExp('Customer Avon Consultant'));

    cy.get(`[data-cy="stringMaxlengthField"]`)
      .type('Loan programming', { force: true })
      .invoke('val')
      .should('match', new RegExp('Loan programming'));

    cy.get(`[data-cy="stringPatternField"]`).type('bg', { force: true }).invoke('val').should('match', new RegExp('bg'));

    cy.get(`[data-cy="integerField"]`).type('27613').should('have.value', '27613');

    cy.get(`[data-cy="integerRequiredField"]`).type('66882').should('have.value', '66882');

    cy.get(`[data-cy="integerMinField"]`).type('97454').should('have.value', '97454');

    cy.get(`[data-cy="integerMaxField"]`).type('88').should('have.value', '88');

    cy.get(`[data-cy="longField"]`).type('5621').should('have.value', '5621');

    cy.get(`[data-cy="longRequiredField"]`).type('34437').should('have.value', '34437');

    cy.get(`[data-cy="longMinField"]`).type('56952').should('have.value', '56952');

    cy.get(`[data-cy="longMaxField"]`).type('32').should('have.value', '32');

    cy.get(`[data-cy="floatField"]`).type('14780').should('have.value', '14780');

    cy.get(`[data-cy="floatRequiredField"]`).type('77724').should('have.value', '77724');

    cy.get(`[data-cy="floatMinField"]`).type('50136').should('have.value', '50136');

    cy.get(`[data-cy="floatMaxField"]`).type('31').should('have.value', '31');

    cy.get(`[data-cy="doubleRequiredField"]`).type('34960').should('have.value', '34960');

    cy.get(`[data-cy="doubleMinField"]`).type('51819').should('have.value', '51819');

    cy.get(`[data-cy="doubleMaxField"]`).type('66').should('have.value', '66');

    cy.get(`[data-cy="bigDecimalRequiredField"]`).type('24572').should('have.value', '24572');

    cy.get(`[data-cy="bigDecimalMinField"]`).type('37235').should('have.value', '37235');

    cy.get(`[data-cy="bigDecimalMaxField"]`).type('33').should('have.value', '33');

    cy.get(`[data-cy="localDateField"]`).type('2016-02-08').should('have.value', '2016-02-08');

    cy.get(`[data-cy="localDateRequiredField"]`).type('2016-02-08').should('have.value', '2016-02-08');

    cy.get(`[data-cy="instantDateField"]`).type('2016-02-08T02:20').invoke('val').should('equal', '2016-02-08T02:20');

    cy.get(`[data-cy="instantRequiredField"]`).type('2016-02-08T02:55').invoke('val').should('equal', '2016-02-08T02:55');

    cy.get(`[data-cy="zonedDateTimeField"]`).type('2016-02-08T18:26').invoke('val').should('equal', '2016-02-08T18:26');

    cy.get(`[data-cy="zonedDateTimeRequiredField"]`).type('2016-02-08T07:21').invoke('val').should('equal', '2016-02-08T07:21');

    cy.get(`[data-cy="durationDateField"]`).type('PT12S').should('have.value', 'PT12S');

    cy.get(`[data-cy="durationRequiredField"]`).type('PT12S').should('have.value', 'PT12S');

    cy.get(`[data-cy="booleanField"]`).should('not.be.checked');
    cy.get(`[data-cy="booleanField"]`).click().should('be.checked');

    cy.get(`[data-cy="booleanRequiredField"]`).should('not.be.checked');
    cy.get(`[data-cy="booleanRequiredField"]`).click().should('be.checked');

    cy.get(`[data-cy="enumTom"]`).select('ENUM_VALUE_1');

    cy.get(`[data-cy="enumRequiredTom"]`).select('ENUM_VALUE_2');

    cy.get(entityCreateSaveButtonSelector).click({ force: true });
    cy.scrollTo('top', { ensureScrollable: false });
    cy.get(entityCreateSaveButtonSelector).should('not.exist');
    cy.intercept('GET', '/api/cass-test-service-impl-entities*').as('entitiesRequestAfterCreate');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-impl-entity');
    cy.wait('@entitiesRequestAfterCreate');
    cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount + 1);
    cy.visit('/');
  });

  it('should delete last instance of CassTestServiceImplEntity', () => {
    cy.intercept('GET', '/api/cass-test-service-impl-entities*').as('entitiesRequest');
    cy.intercept('DELETE', '/api/cass-test-service-impl-entities/*').as('deleteEntityRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-impl-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => {
      startingEntitiesCount = response.body.length;
      if (startingEntitiesCount > 0) {
        cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount);
        cy.get(entityDeleteButtonSelector).last().click({ force: true });
        cy.getEntityDeleteDialogHeading('cassTestServiceImplEntity').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest');
        cy.intercept('GET', '/api/cass-test-service-impl-entities*').as('entitiesRequestAfterDelete');
        cy.visit('/');
        cy.clickOnEntityMenuItem('cass-test-service-impl-entity');
        cy.wait('@entitiesRequestAfterDelete');
        cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount - 1);
      }
      cy.visit('/');
    });
  });
});
