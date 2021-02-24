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

describe('CassBankAccount e2e test', () => {
  let startingEntitiesCount = 0;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.clearCookie('SESSION');
    cy.clearCookies();
    cy.intercept('GET', '/api/cass-bank-accounts*').as('entitiesRequest');
    cy.visit('');
    cy.login('admin', 'admin');
    cy.clickOnEntityMenuItem('cass-bank-account-my-suffix');
    cy.wait('@entitiesRequest').then(({ request, response }) => (startingEntitiesCount = response.body.length));
    cy.visit('/');
  });

  it('should load CassBankAccounts', () => {
    cy.intercept('GET', '/api/cass-bank-accounts*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-bank-account-my-suffix');
    cy.wait('@entitiesRequest');
    cy.getEntityHeading('CassBankAccount').should('exist');
    if (startingEntitiesCount === 0) {
      cy.get(entityTableSelector).should('not.exist');
    } else {
      cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount);
    }
    cy.visit('/');
  });

  it('should load details CassBankAccount page', () => {
    cy.intercept('GET', '/api/cass-bank-accounts*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-bank-account-my-suffix');
    cy.wait('@entitiesRequest');
    if (startingEntitiesCount > 0) {
      cy.get(entityDetailsButtonSelector).first().click({ force: true });
      cy.getEntityDetailsHeading('cassBankAccount');
      cy.get(entityDetailsBackButtonSelector).should('exist');
    }
    cy.visit('/');
  });

  it('should load create CassBankAccount page', () => {
    cy.intercept('GET', '/api/cass-bank-accounts*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-bank-account-my-suffix');
    cy.wait('@entitiesRequest');
    cy.get(entityCreateButtonSelector).click({ force: true });
    cy.getEntityCreateUpdateHeading('CassBankAccount');
    cy.get(entityCreateSaveButtonSelector).should('exist');
    cy.visit('/');
  });

  it('should load edit CassBankAccount page', () => {
    cy.intercept('GET', '/api/cass-bank-accounts*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-bank-account-my-suffix');
    cy.wait('@entitiesRequest');
    if (startingEntitiesCount > 0) {
      cy.get(entityEditButtonSelector).first().click({ force: true });
      cy.getEntityCreateUpdateHeading('CassBankAccount');
      cy.get(entityCreateSaveButtonSelector).should('exist');
    }
    cy.visit('/');
  });

  it('should create an instance of CassBankAccount', () => {
    cy.intercept('GET', '/api/cass-bank-accounts*').as('entitiesRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-bank-account-my-suffix');
    cy.wait('@entitiesRequest').then(({ request, response }) => (startingEntitiesCount = response.body.length));
    cy.get(entityCreateButtonSelector).click({ force: true });
    cy.getEntityCreateUpdateHeading('CassBankAccount');

    cy.get(`[data-cy="userId"]`)
      .type('806e1be0-4bdd-4c33-8e37-3a1b38c7f81d')
      .invoke('val')
      .should('match', new RegExp('806e1be0-4bdd-4c33-8e37-3a1b38c7f81d'));

    cy.get(`[data-cy="name"]`)
      .type('connect Diverse plug-and-play', { force: true })
      .invoke('val')
      .should('match', new RegExp('connect Diverse plug-and-play'));

    cy.get(`[data-cy="bankNumber"]`).type('26854').should('have.value', '26854');

    cy.get(`[data-cy="agencyNumber"]`).type('40951').should('have.value', '40951');

    cy.get(`[data-cy="lastOperationDuration"]`).type('86547').should('have.value', '86547');

    cy.get(`[data-cy="meanOperationDuration"]`).type('63158').should('have.value', '63158');

    cy.get(`[data-cy="balance"]`).type('78077').should('have.value', '78077');

    cy.get(`[data-cy="lastOperationDate"]`).type('2015-08-05T02:58').invoke('val').should('equal', '2015-08-05T02:58');

    cy.get(`[data-cy="active"]`).should('not.be.checked');
    cy.get(`[data-cy="active"]`).click().should('be.checked');

    cy.get(`[data-cy="accountType"]`).select('STANDARD');

    cy.get(entityCreateSaveButtonSelector).click({ force: true });
    cy.scrollTo('top', { ensureScrollable: false });
    cy.get(entityCreateSaveButtonSelector).should('not.exist');
    cy.intercept('GET', '/api/cass-bank-accounts*').as('entitiesRequestAfterCreate');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-bank-account-my-suffix');
    cy.wait('@entitiesRequestAfterCreate');
    cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount + 1);
    cy.visit('/');
  });

  it('should delete last instance of CassBankAccount', () => {
    cy.intercept('GET', '/api/cass-bank-accounts*').as('entitiesRequest');
    cy.intercept('DELETE', '/api/cass-bank-accounts/*').as('deleteEntityRequest');
    cy.visit('/');
    cy.clickOnEntityMenuItem('cass-bank-account-my-suffix');
    cy.wait('@entitiesRequest').then(({ request, response }) => {
      startingEntitiesCount = response.body.length;
      if (startingEntitiesCount > 0) {
        cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount);
        cy.get(entityDeleteButtonSelector).last().click({ force: true });
        cy.getEntityDeleteDialogHeading('cassBankAccount').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest');
        cy.intercept('GET', '/api/cass-bank-accounts*').as('entitiesRequestAfterDelete');
        cy.visit('/');
        cy.clickOnEntityMenuItem('cass-bank-account-my-suffix');
        cy.wait('@entitiesRequestAfterDelete');
        cy.get(entityTableSelector).should('have.lengthOf', startingEntitiesCount - 1);
      }
      cy.visit('/');
    });
  });
});
