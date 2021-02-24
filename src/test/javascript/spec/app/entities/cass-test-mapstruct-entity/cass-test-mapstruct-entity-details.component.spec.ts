/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import CassTestMapstructEntityDetailComponent from '@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity-details.vue';
import CassTestMapstructEntityClass from '@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity-details.component';
import CassTestMapstructEntityService from '@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('CassTestMapstructEntity Management Detail Component', () => {
    let wrapper: Wrapper<CassTestMapstructEntityClass>;
    let comp: CassTestMapstructEntityClass;
    let cassTestMapstructEntityServiceStub: SinonStubbedInstance<CassTestMapstructEntityService>;

    beforeEach(() => {
      cassTestMapstructEntityServiceStub = sinon.createStubInstance<CassTestMapstructEntityService>(CassTestMapstructEntityService);

      wrapper = shallowMount<CassTestMapstructEntityClass>(CassTestMapstructEntityDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { cassTestMapstructEntityService: () => cassTestMapstructEntityServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundCassTestMapstructEntity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        cassTestMapstructEntityServiceStub.find.resolves(foundCassTestMapstructEntity);

        // WHEN
        comp.retrieveCassTestMapstructEntity('9fec3727-3421-4967-b213-ba36557ca194');
        await comp.$nextTick();

        // THEN
        expect(comp.cassTestMapstructEntity).toBe(foundCassTestMapstructEntity);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundCassTestMapstructEntity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        cassTestMapstructEntityServiceStub.find.resolves(foundCassTestMapstructEntity);

        // WHEN
        comp.beforeRouteEnter({ params: { cassTestMapstructEntityId: '9fec3727-3421-4967-b213-ba36557ca194' } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.cassTestMapstructEntity).toBe(foundCassTestMapstructEntity);
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
