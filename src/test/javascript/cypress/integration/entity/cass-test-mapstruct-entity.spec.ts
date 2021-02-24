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

describe('CassTestMapstructEntity e2e test', () => {
  let startingEntitiesCount = 0;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.clearCookie('SESSION');
    cy.clearCookies();
    cy.intercept('GET', '/api/cass-test-mapstruct-entities*').as('entitiesRequest');
    cy.visit('');
    cy.login('admin', 'admin');
    cy.clickOnEntityMenuItem('cass-test-mapstruct-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => (startingEntitiesCount = response.body.length));
    cy.visit('/');
  });

  it('should load CassTestMapstructEntities', () => {
    cy.intercept('GET', '/api/cass-test-mapstruct-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-mapstruct-entity');
    cy.wait('@entitiesRequest');
    cy.getEntityHeading('CassTestMapstructEntity').should('exist');
    if (startingEntitiesCount === 0) {
      cy.get(entityTableSelector).should('not.exist');
    } else {
      cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount);
    }
    cy.visit('/');
  });

  it('should load details CassTestMapstructEntity page', () => {
    cy.intercept('GET', '/api/cass-test-mapstruct-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-mapstruct-entity');
    cy.wait('@entitiesRequest');
    if (startingEntitiesCount > 0) {
      cy.get(entityDetailsButtonSelector).first().click({ force: true });
      cy.getEntityDetailsHeading('cassTestMapstructEntity');
      cy.get(entityDetailsBackButtonSelector).should('exist');
    }
    cy.visit('/');
  });

  it('should load create CassTestMapstructEntity page', () => {
    cy.intercept('GET', '/api/cass-test-mapstruct-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-mapstruct-entity');
    cy.wait('@entitiesRequest');
    cy.get(entityCreateButtonSelector).click({ force: true });
    cy.getEntityCreateUpdateHeading('CassTestMapstructEntity');
    cy.get(entityCreateSaveButtonSelector).should('exist');
    cy.visit('/');
  });

  it('should load edit CassTestMapstructEntity page', () => {
    cy.intercept('GET', '/api/cass-test-mapstruct-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-mapstruct-entity');
    cy.wait('@entitiesRequest');
    if (startingEntitiesCount > 0) {
      cy.get(entityEditButtonSelector).first().click({ force: true });
      cy.getEntityCreateUpdateHeading('CassTestMapstructEntity');
      cy.get(entityCreateSaveButtonSelector).should('exist');
    }
    cy.visit('/');
  });

  it('should create an instance of CassTestMapstructEntity', () => {
    cy.intercept('GET', '/api/cass-test-mapstruct-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-mapstruct-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => (startingEntitiesCount = response.body.length));
    cy.get(entityCreateButtonSelector).click({ force: true });
    cy.getEntityCreateUpdateHeading('CassTestMapstructEntity');

    cy.get(`[data-cy="stringField"]`).type('Chair Square', { force: true }).invoke('val').should('match', new RegExp('Chair Square'));

    cy.get(`[data-cy="stringRequiredField"]`)
      .type('Corporate Implemented', { force: true })
      .invoke('val')
      .should('match', new RegExp('Corporate Implemented'));

    cy.get(`[data-cy="stringMinlengthField"]`).type('Directives', { force: true }).invoke('val').should('match', new RegExp('Directives'));

    cy.get(`[data-cy="stringMaxlengthField"]`).type('Avon', { force: true }).invoke('val').should('match', new RegExp('Avon'));

    cy.get(`[data-cy="stringPatternField"]`).type('vAB', { force: true }).invoke('val').should('match', new RegExp('vAB'));

    cy.get(`[data-cy="integerField"]`).type('62601').should('have.value', '62601');

    cy.get(`[data-cy="integerRequiredField"]`).type('25397').should('have.value', '25397');

    cy.get(`[data-cy="integerMinField"]`).type('78832').should('have.value', '78832');

    cy.get(`[data-cy="integerMaxField"]`).type('17').should('have.value', '17');

    cy.get(`[data-cy="longField"]`).type('38294').should('have.value', '38294');

    cy.get(`[data-cy="longRequiredField"]`).type('78838').should('have.value', '78838');

    cy.get(`[data-cy="longMinField"]`).type('31652').should('have.value', '31652');

    cy.get(`[data-cy="longMaxField"]`).type('62').should('have.value', '62');

    cy.get(`[data-cy="floatField"]`).type('25449').should('have.value', '25449');

    cy.get(`[data-cy="floatRequiredField"]`).type('72940').should('have.value', '72940');

    cy.get(`[data-cy="floatMinField"]`).type('75554').should('have.value', '75554');

    cy.get(`[data-cy="floatMaxField"]`).type('65').should('have.value', '65');

    cy.get(`[data-cy="doubleRequiredField"]`).type('63173').should('have.value', '63173');

    cy.get(`[data-cy="doubleMinField"]`).type('2386').should('have.value', '2386');

    cy.get(`[data-cy="doubleMaxField"]`).type('74').should('have.value', '74');

    cy.get(`[data-cy="bigDecimalRequiredField"]`).type('96516').should('have.value', '96516');

    cy.get(`[data-cy="bigDecimalMinField"]`).type('88640').should('have.value', '88640');

    cy.get(`[data-cy="bigDecimalMaxField"]`).type('33').should('have.value', '33');

    cy.get(`[data-cy="localDateField"]`).type('2016-02-08').should('have.value', '2016-02-08');

    cy.get(`[data-cy="localDateRequiredField"]`).type('2016-02-07').should('have.value', '2016-02-07');

    cy.get(`[data-cy="instantDateField"]`).type('2016-02-07T20:34').invoke('val').should('equal', '2016-02-07T20:34');

    cy.get(`[data-cy="instantRequiredField"]`).type('2016-02-08T03:48').invoke('val').should('equal', '2016-02-08T03:48');

    cy.get(`[data-cy="zonedDateTimeField"]`).type('2016-02-08T09:42').invoke('val').should('equal', '2016-02-08T09:42');

    cy.get(`[data-cy="zonedDateTimeRequiredField"]`).type('2016-02-07T23:54').invoke('val').should('equal', '2016-02-07T23:54');

    cy.get(`[data-cy="durationDateField"]`).type('PT12S').should('have.value', 'PT12S');

    cy.get(`[data-cy="durationRequiredField"]`).type('PT12S').should('have.value', 'PT12S');

    cy.get(`[data-cy="booleanField"]`).should('not.be.checked');
    cy.get(`[data-cy="booleanField"]`).click().should('be.checked');

    cy.get(`[data-cy="booleanRequiredField"]`).should('not.be.checked');
    cy.get(`[data-cy="booleanRequiredField"]`).click().should('be.checked');

    cy.get(`[data-cy="enumTom"]`).select('ENUM_VALUE_3');

    cy.get(`[data-cy="enumRequiredTom"]`).select('ENUM_VALUE_2');

    cy.get(entityCreateSaveButtonSelector).click({ force: true });
    cy.scrollTo('top', { ensureScrollable: false });
    cy.get(entityCreateSaveButtonSelector).should('not.exist');
    cy.intercept('GET', '/api/cass-test-mapstruct-entities*').as('entitiesRequestAfterCreate');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-mapstruct-entity');
    cy.wait('@entitiesRequestAfterCreate');
    cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount + 1);
    cy.visit('/');
  });

  it('should delete last instance of CassTestMapstructEntity', () => {
    cy.intercept('GET', '/api/cass-test-mapstruct-entities*').as('entitiesRequest');
    cy.intercept('DELETE', '/api/cass-test-mapstruct-entities/*').as('deleteEntityRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-mapstruct-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => {
      startingEntitiesCount = response.body.length;
      if (startingEntitiesCount > 0) {
        cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount);
        cy.get(entityDeleteButtonSelector).last().click({ force: true });
        cy.getEntityDeleteDialogHeading('cassTestMapstructEntity').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest');
        cy.intercept('GET', '/api/cass-test-mapstruct-entities*').as('entitiesRequestAfterDelete');
        cy.visit('/');
        cy.clickOnEntityMenuItem('cass-test-mapstruct-entity');
        cy.wait('@entitiesRequestAfterDelete');
        cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount - 1);
      }
      cy.visit('/');
    });
  });
});
