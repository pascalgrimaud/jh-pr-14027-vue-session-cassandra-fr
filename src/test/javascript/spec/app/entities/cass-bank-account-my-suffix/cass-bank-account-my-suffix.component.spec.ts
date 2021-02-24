/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import CassBankAccountMySuffixComponent from '@/entities/cass-bank-account-my-suffix/cass-bank-account-my-suffix.vue';
import CassBankAccountMySuffixClass from '@/entities/cass-bank-account-my-suffix/cass-bank-account-my-suffix.component';
import CassBankAccountMySuffixService from '@/entities/cass-bank-account-my-suffix/cass-bank-account-my-suffix.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('CassBankAccountMySuffix Management Component', () => {
    let wrapper: Wrapper<CassBankAccountMySuffixClass>;
    let comp: CassBankAccountMySuffixClass;
    let cassBankAccountServiceStub: SinonStubbedInstance<CassBankAccountMySuffixService>;

    beforeEach(() => {
      cassBankAccountServiceStub = sinon.createStubInstance<CassBankAccountMySuffixService>(CassBankAccountMySuffixService);
      cassBankAccountServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<CassBankAccountMySuffixClass>(CassBankAccountMySuffixComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          cassBankAccountService: () => cassBankAccountServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      cassBankAccountServiceStub.retrieve.resolves({ headers: {}, data: [{ id: '9fec3727-3421-4967-b213-ba36557ca194' }] });

      // WHEN
      comp.retrieveAllCassBankAccountMySuffixs();
      await comp.$nextTick();

      // THEN
      expect(cassBankAccountServiceStub.retrieve.called).toBeTruthy();
      expect(comp.cassBankAccounts[0]).toEqual(jasmine.objectContaining({ id: '9fec3727-3421-4967-b213-ba36557ca194' }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      cassBankAccountServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: '9fec3727-3421-4967-b213-ba36557ca194' });
      comp.removeCassBankAccountMySuffix();
      await comp.$nextTick();

      // THEN
      expect(cassBankAccountServiceStub.delete.called).toBeTruthy();
      expect(cassBankAccountServiceStub.retrieve.callCount).toEqual(1);
    });
  });
});
