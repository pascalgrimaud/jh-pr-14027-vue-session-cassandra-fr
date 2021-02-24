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

describe('CassTestServiceClassEntity e2e test', () => {
  let startingEntitiesCount = 0;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.clearCookie('SESSION');
    cy.clearCookies();
    cy.intercept('GET', '/api/cass-test-service-class-entities*').as('entitiesRequest');
    cy.visit('');
    cy.login('admin', 'admin');
    cy.clickOnEntityMenuItem('cass-test-service-class-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => (startingEntitiesCount = response.body.length));
    cy.visit('/');
  });

  it('should load CassTestServiceClassEntities', () => {
    cy.intercept('GET', '/api/cass-test-service-class-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-class-entity');
    cy.wait('@entitiesRequest');
    cy.getEntityHeading('CassTestServiceClassEntity').should('exist');
    if (startingEntitiesCount === 0) {
      cy.get(entityTableSelector).should('not.exist');
    } else {
      cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount);
    }
    cy.visit('/');
  });

  it('should load details CassTestServiceClassEntity page', () => {
    cy.intercept('GET', '/api/cass-test-service-class-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-class-entity');
    cy.wait('@entitiesRequest');
    if (startingEntitiesCount > 0) {
      cy.get(entityDetailsButtonSelector).first().click({ force: true });
      cy.getEntityDetailsHeading('cassTestServiceClassEntity');
      cy.get(entityDetailsBackButtonSelector).should('exist');
    }
    cy.visit('/');
  });

  it('should load create CassTestServiceClassEntity page', () => {
    cy.intercept('GET', '/api/cass-test-service-class-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-class-entity');
    cy.wait('@entitiesRequest');
    cy.get(entityCreateButtonSelector).click({ force: true });
    cy.getEntityCreateUpdateHeading('CassTestServiceClassEntity');
    cy.get(entityCreateSaveButtonSelector).should('exist');
    cy.visit('/');
  });

  it('should load edit CassTestServiceClassEntity page', () => {
    cy.intercept('GET', '/api/cass-test-service-class-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-class-entity');
    cy.wait('@entitiesRequest');
    if (startingEntitiesCount > 0) {
      cy.get(entityEditButtonSelector).first().click({ force: true });
      cy.getEntityCreateUpdateHeading('CassTestServiceClassEntity');
      cy.get(entityCreateSaveButtonSelector).should('exist');
    }
    cy.visit('/');
  });

  it('should create an instance of CassTestServiceClassEntity', () => {
    cy.intercept('GET', '/api/cass-test-service-class-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-class-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => (startingEntitiesCount = response.body.length));
    cy.get(entityCreateButtonSelector).click({ force: true });
    cy.getEntityCreateUpdateHeading('CassTestServiceClassEntity');

    cy.get(`[data-cy="stringField"]`)
      .type('Berkshire Taiwan', { force: true })
      .invoke('val')
      .should('match', new RegExp('Berkshire Taiwan'));

    cy.get(`[data-cy="stringRequiredField"]`)
      .type('Shirt interactive Upgradable', { force: true })
      .invoke('val')
      .should('match', new RegExp('Shirt interactive Upgradable'));

    cy.get(`[data-cy="stringMinlengthField"]`).type('Steel', { force: true }).invoke('val').should('match', new RegExp('Steel'));

    cy.get(`[data-cy="stringMaxlengthField"]`)
      .type('Chicken Industrial', { force: true })
      .invoke('val')
      .should('match', new RegExp('Chicken Industrial'));

    cy.get(`[data-cy="stringPatternField"]`).type('G', { force: true }).invoke('val').should('match', new RegExp('G'));

    cy.get(`[data-cy="integerField"]`).type('98287').should('have.value', '98287');

    cy.get(`[data-cy="integerRequiredField"]`).type('91235').should('have.value', '91235');

    cy.get(`[data-cy="integerMinField"]`).type('93603').should('have.value', '93603');

    cy.get(`[data-cy="integerMaxField"]`).type('63').should('have.value', '63');

    cy.get(`[data-cy="longField"]`).type('29538').should('have.value', '29538');

    cy.get(`[data-cy="longRequiredField"]`).type('55624').should('have.value', '55624');

    cy.get(`[data-cy="longMinField"]`).type('92782').should('have.value', '92782');

    cy.get(`[data-cy="longMaxField"]`).type('97').should('have.value', '97');

    cy.get(`[data-cy="floatField"]`).type('44393').should('have.value', '44393');

    cy.get(`[data-cy="floatRequiredField"]`).type('90488').should('have.value', '90488');

    cy.get(`[data-cy="floatMinField"]`).type('77172').should('have.value', '77172');

    cy.get(`[data-cy="floatMaxField"]`).type('0').should('have.value', '0');

    cy.get(`[data-cy="doubleRequiredField"]`).type('6094').should('have.value', '6094');

    cy.get(`[data-cy="doubleMinField"]`).type('35699').should('have.value', '35699');

    cy.get(`[data-cy="doubleMaxField"]`).type('52').should('have.value', '52');

    cy.get(`[data-cy="bigDecimalRequiredField"]`).type('46717').should('have.value', '46717');

    cy.get(`[data-cy="bigDecimalMinField"]`).type('45764').should('have.value', '45764');

    cy.get(`[data-cy="bigDecimalMaxField"]`).type('86').should('have.value', '86');

    cy.get(`[data-cy="localDateField"]`).type('2016-02-07').should('have.value', '2016-02-07');

    cy.get(`[data-cy="localDateRequiredField"]`).type('2016-02-07').should('have.value', '2016-02-07');

    cy.get(`[data-cy="instantDateField"]`).type('2016-02-07T22:19').invoke('val').should('equal', '2016-02-07T22:19');

    cy.get(`[data-cy="instantRequiredField"]`).type('2016-02-08T02:06').invoke('val').should('equal', '2016-02-08T02:06');

    cy.get(`[data-cy="zonedDateTimeField"]`).type('2016-02-08T02:00').invoke('val').should('equal', '2016-02-08T02:00');

    cy.get(`[data-cy="zonedDateTimeRequiredField"]`).type('2016-02-08T00:21').invoke('val').should('equal', '2016-02-08T00:21');

    cy.get(`[data-cy="durationDateField"]`).type('PT12S').should('have.value', 'PT12S');

    cy.get(`[data-cy="durationRequiredField"]`).type('PT12S').should('have.value', 'PT12S');

    cy.get(`[data-cy="booleanField"]`).should('not.be.checked');
    cy.get(`[data-cy="booleanField"]`).click().should('be.checked');

    cy.get(`[data-cy="booleanRequiredField"]`).should('not.be.checked');
    cy.get(`[data-cy="booleanRequiredField"]`).click().should('be.checked');

    cy.get(`[data-cy="enumTom"]`).select('ENUM_VALUE_2');

    cy.get(`[data-cy="enumRequiredTom"]`).select('ENUM_VALUE_2');

    cy.get(entityCreateSaveButtonSelector).click({ force: true });
    cy.scrollTo('top', { ensureScrollable: false });
    cy.get(entityCreateSaveButtonSelector).should('not.exist');
    cy.intercept('GET', '/api/cass-test-service-class-entities*').as('entitiesRequestAfterCreate');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-class-entity');
    cy.wait('@entitiesRequestAfterCreate');
    cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount + 1);
    cy.visit('/');
  });

  it('should delete last instance of CassTestServiceClassEntity', () => {
    cy.intercept('GET', '/api/cass-test-service-class-entities*').as('entitiesRequest');
    cy.intercept('DELETE', '/api/cass-test-service-class-entities/*').as('deleteEntityRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-service-class-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => {
      startingEntitiesCount = response.body.length;
      if (startingEntitiesCount > 0) {
        cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount);
        cy.get(entityDeleteButtonSelector).last().click({ force: true });
        cy.getEntityDeleteDialogHeading('cassTestServiceClassEntity').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest');
        cy.intercept('GET', '/api/cass-test-service-class-entities*').as('entitiesRequestAfterDelete');
        cy.visit('/');
        cy.clickOnEntityMenuItem('cass-test-service-class-entity');
        cy.wait('@entitiesRequestAfterDelete');
        cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount - 1);
      }
      cy.visit('/');
    });
  });
});
