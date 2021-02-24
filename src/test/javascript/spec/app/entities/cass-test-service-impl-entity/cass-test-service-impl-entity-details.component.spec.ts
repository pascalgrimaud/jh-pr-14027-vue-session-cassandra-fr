/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import CassTestServiceImplEntityDetailComponent from '@/entities/cass-test-service-impl-entity/cass-test-service-impl-entity-details.vue';
import CassTestServiceImplEntityClass from '@/entities/cass-test-service-impl-entity/cass-test-service-impl-entity-details.component';
import CassTestServiceImplEntityService from '@/entities/cass-test-service-impl-entity/cass-test-service-impl-entity.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('CassTestServiceImplEntity Management Detail Component', () => {
    let wrapper: Wrapper<CassTestServiceImplEntityClass>;
    let comp: CassTestServiceImplEntityClass;
    let cassTestServiceImplEntityServiceStub: SinonStubbedInstance<CassTestServiceImplEntityService>;

    beforeEach(() => {
      cassTestServiceImplEntityServiceStub = sinon.createStubInstance<CassTestServiceImplEntityService>(CassTestServiceImplEntityService);

      wrapper = shallowMount<CassTestServiceImplEntityClass>(CassTestServiceImplEntityDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { cassTestServiceImplEntityService: () => cassTestServiceImplEntityServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundCassTestServiceImplEntity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        cassTestServiceImplEntityServiceStub.find.resolves(foundCassTestServiceImplEntity);

        // WHEN
        comp.retrieveCassTestServiceImplEntity('9fec3727-3421-4967-b213-ba36557ca194');
        await comp.$nextTick();

        // THEN
        expect(comp.cassTestServiceImplEntity).toBe(foundCassTestServiceImplEntity);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundCassTestServiceImplEntity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        cassTestServiceImplEntityServiceStub.find.resolves(foundCassTestServiceImplEntity);

        // WHEN
        comp.beforeRouteEnter({ params: { cassTestServiceImplEntityId: '9fec3727-3421-4967-b213-ba36557ca194' } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.cassTestServiceImplEntity).toBe(foundCassTestServiceImplEntity);
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
