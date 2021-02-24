/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import CassBankAccountMySuffixDetailComponent from '@/entities/cass-bank-account-my-suffix/cass-bank-account-my-suffix-details.vue';
import CassBankAccountMySuffixClass from '@/entities/cass-bank-account-my-suffix/cass-bank-account-my-suffix-details.component';
import CassBankAccountMySuffixService from '@/entities/cass-bank-account-my-suffix/cass-bank-account-my-suffix.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('CassBankAccountMySuffix Management Detail Component', () => {
    let wrapper: Wrapper<CassBankAccountMySuffixClass>;
    let comp: CassBankAccountMySuffixClass;
    let cassBankAccountServiceStub: SinonStubbedInstance<CassBankAccountMySuffixService>;

    beforeEach(() => {
      cassBankAccountServiceStub = sinon.createStubInstance<CassBankAccountMySuffixService>(CassBankAccountMySuffixService);

      wrapper = shallowMount<CassBankAccountMySuffixClass>(CassBankAccountMySuffixDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { cassBankAccountService: () => cassBankAccountServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundCassBankAccountMySuffix = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        cassBankAccountServiceStub.find.resolves(foundCassBankAccountMySuffix);

        // WHEN
        comp.retrieveCassBankAccountMySuffix('9fec3727-3421-4967-b213-ba36557ca194');
        await comp.$nextTick();

        // THEN
        expect(comp.cassBankAccount).toBe(foundCassBankAccountMySuffix);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundCassBankAccountMySuffix = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        cassBankAccountServiceStub.find.resolves(foundCassBankAccountMySuffix);

        // WHEN
        comp.beforeRouteEnter({ params: { cassBankAccountId: '9fec3727-3421-4967-b213-ba36557ca194' } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.cassBankAccount).toBe(foundCassBankAccountMySuffix);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
