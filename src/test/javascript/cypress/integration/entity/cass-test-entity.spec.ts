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

describe('CassTestEntity e2e test', () => {
  let startingEntitiesCount = 0;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.clearCookie('SESSION');
    cy.clearCookies();
    cy.intercept('GET', '/api/cass-test-entities*').as('entitiesRequest');
    cy.visit('');
    cy.login('admin', 'admin');
    cy.clickOnEntityMenuItem('cass-test-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => (startingEntitiesCount = response.body.length));
    cy.visit('/');
  });

  it('should load CassTestEntities', () => {
    cy.intercept('GET', '/api/cass-test-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-entity');
    cy.wait('@entitiesRequest');
    cy.getEntityHeading('CassTestEntity').should('exist');
    if (startingEntitiesCount === 0) {
      cy.get(entityTableSelector).should('not.exist');
    } else {
      cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount);
    }
    cy.visit('/');
  });

  it('should load details CassTestEntity page', () => {
    cy.intercept('GET', '/api/cass-test-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-entity');
    cy.wait('@entitiesRequest');
    if (startingEntitiesCount > 0) {
      cy.get(entityDetailsButtonSelector).first().click({ force: true });
      cy.getEntityDetailsHeading('cassTestEntity');
      cy.get(entityDetailsBackButtonSelector).should('exist');
    }
    cy.visit('/');
  });

  it('should load create CassTestEntity page', () => {
    cy.intercept('GET', '/api/cass-test-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-entity');
    cy.wait('@entitiesRequest');
    cy.get(entityCreateButtonSelector).click({ force: true });
    cy.getEntityCreateUpdateHeading('CassTestEntity');
    cy.get(entityCreateSaveButtonSelector).should('exist');
    cy.visit('/');
  });

  it('should load edit CassTestEntity page', () => {
    cy.intercept('GET', '/api/cass-test-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-entity');
    cy.wait('@entitiesRequest');
    if (startingEntitiesCount > 0) {
      cy.get(entityEditButtonSelector).first().click({ force: true });
      cy.getEntityCreateUpdateHeading('CassTestEntity');
      cy.get(entityCreateSaveButtonSelector).should('exist');
    }
    cy.visit('/');
  });

  it('should create an instance of CassTestEntity', () => {
    cy.intercept('GET', '/api/cass-test-entities*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => (startingEntitiesCount = response.body.length));
    cy.get(entityCreateButtonSelector).click({ force: true });
    cy.getEntityCreateUpdateHeading('CassTestEntity');

    cy.get(`[data-cy="stringField"]`).type('Forward', { force: true }).invoke('val').should('match', new RegExp('Forward'));

    cy.get(`[data-cy="stringRequiredField"]`).type('Fresh', { force: true }).invoke('val').should('match', new RegExp('Fresh'));

    cy.get(`[data-cy="stringMinlengthField"]`)
      .type('bus Assurance Mexico', { force: true })
      .invoke('val')
      .should('match', new RegExp('bus Assurance Mexico'));

    cy.get(`[data-cy="stringMaxlengthField"]`)
      .type('Forward client-serve', { force: true })
      .invoke('val')
      .should('match', new RegExp('Forward client-serve'));

    cy.get(`[data-cy="stringPatternField"]`).type('p', { force: true }).invoke('val').should('match', new RegExp('p'));

    cy.get(`[data-cy="integerField"]`).type('91368').should('have.value', '91368');

    cy.get(`[data-cy="integerRequiredField"]`).type('28053').should('have.value', '28053');

    cy.get(`[data-cy="integerMinField"]`).type('10469').should('have.value', '10469');

    cy.get(`[data-cy="integerMaxField"]`).type('12').should('have.value', '12');

    cy.get(`[data-cy="longField"]`).type('37999').should('have.value', '37999');

    cy.get(`[data-cy="longRequiredField"]`).type('64849').should('have.value', '64849');

    cy.get(`[data-cy="longMinField"]`).type('21533').should('have.value', '21533');

    cy.get(`[data-cy="longMaxField"]`).type('69').should('have.value', '69');

    cy.get(`[data-cy="floatField"]`).type('18617').should('have.value', '18617');

    cy.get(`[data-cy="floatRequiredField"]`).type('15227').should('have.value', '15227');

    cy.get(`[data-cy="floatMinField"]`).type('55809').should('have.value', '55809');

    cy.get(`[data-cy="floatMaxField"]`).type('91').should('have.value', '91');

    cy.get(`[data-cy="doubleRequiredField"]`).type('50076').should('have.value', '50076');

    cy.get(`[data-cy="doubleMinField"]`).type('60087').should('have.value', '60087');

    cy.get(`[data-cy="doubleMaxField"]`).type('2').should('have.value', '2');

    cy.get(`[data-cy="bigDecimalRequiredField"]`).type('31849').should('have.value', '31849');

    cy.get(`[data-cy="bigDecimalMinField"]`).type('1288').should('have.value', '1288');

    cy.get(`[data-cy="bigDecimalMaxField"]`).type('47').should('have.value', '47');

    cy.get(`[data-cy="localDateField"]`).type('2016-02-08').should('have.value', '2016-02-08');

    cy.get(`[data-cy="localDateRequiredField"]`).type('2016-02-07').should('have.value', '2016-02-07');

    cy.get(`[data-cy="instantDateField"]`).type('2016-02-08T17:10').invoke('val').should('equal', '2016-02-08T17:10');

    cy.get(`[data-cy="instantRequiredField"]`).type('2016-02-08T10:49').invoke('val').should('equal', '2016-02-08T10:49');

    cy.get(`[data-cy="zonedDateTimeField"]`).type('2016-02-08T06:08').invoke('val').should('equal', '2016-02-08T06:08');

    cy.get(`[data-cy="zonedDateTimeRequiredField"]`).type('2016-02-08T00:59').invoke('val').should('equal', '2016-02-08T00:59');

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
    cy.intercept('GET', '/api/cass-test-entities*').as('entitiesRequestAfterCreate');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-entity');
    cy.wait('@entitiesRequestAfterCreate');
    cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount + 1);
    cy.visit('/');
  });

  it('should delete last instance of CassTestEntity', () => {
    cy.intercept('GET', '/api/cass-test-entities*').as('entitiesRequest');
    cy.intercept('DELETE', '/api/cass-test-entities/*').as('deleteEntityRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-test-entity');
    cy.wait('@entitiesRequest').then(({ request, response }) => {
      startingEntitiesCount = response.body.length;
      if (startingEntitiesCount > 0) {
        cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount);
        cy.get(entityDeleteButtonSelector).last().click({ force: true });
        cy.getEntityDeleteDialogHeading('cassTestEntity').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest');
        cy.intercept('GET', '/api/cass-test-entities*').as('entitiesRequestAfterDelete');
        cy.visit('/');
        cy.clickOnEntityMenuItem('cass-test-entity');
        cy.wait('@entitiesRequestAfterDelete');
        cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount - 1);
      }
      cy.visit('/');
    });
  });
});
