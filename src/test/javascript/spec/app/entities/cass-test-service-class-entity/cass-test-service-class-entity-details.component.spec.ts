/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import CassTestServiceClassEntityDetailComponent from '@/entities/cass-test-service-class-entity/cass-test-service-class-entity-details.vue';
import CassTestServiceClassEntityClass from '@/entities/cass-test-service-class-entity/cass-test-service-class-entity-details.component';
import CassTestServiceClassEntityService from '@/entities/cass-test-service-class-entity/cass-test-service-class-entity.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('CassTestServiceClassEntity Management Detail Component', () => {
    let wrapper: Wrapper<CassTestServiceClassEntityClass>;
    let comp: CassTestServiceClassEntityClass;
    let cassTestServiceClassEntityServiceStub: SinonStubbedInstance<CassTestServiceClassEntityService>;

    beforeEach(() => {
      cassTestServiceClassEntityServiceStub = sinon.createStubInstance<CassTestServiceClassEntityService>(
        CassTestServiceClassEntityService
      );

      wrapper = shallowMount<CassTestServiceClassEntityClass>(CassTestServiceClassEntityDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { cassTestServiceClassEntityService: () => cassTestServiceClassEntityServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundCassTestServiceClassEntity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        cassTestServiceClassEntityServiceStub.find.resolves(foundCassTestServiceClassEntity);

        // WHEN
        comp.retrieveCassTestServiceClassEntity('9fec3727-3421-4967-b213-ba36557ca194');
        await comp.$nextTick();

        // THEN
        expect(comp.cassTestServiceClassEntity).toBe(foundCassTestServiceClassEntity);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundCassTestServiceClassEntity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        cassTestServiceClassEntityServiceStub.find.resolves(foundCassTestServiceClassEntity);

        // WHEN
        comp.beforeRouteEnter({ params: { cassTestServiceClassEntityId: '9fec3727-3421-4967-b213-ba36557ca194' } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.cassTestServiceClassEntity).toBe(foundCassTestServiceClassEntity);
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
