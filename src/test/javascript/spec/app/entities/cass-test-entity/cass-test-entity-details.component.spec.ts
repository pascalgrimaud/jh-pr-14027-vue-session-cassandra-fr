/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import CassTestEntityDetailComponent from '@/entities/cass-test-entity/cass-test-entity-details.vue';
import CassTestEntityClass from '@/entities/cass-test-entity/cass-test-entity-details.component';
import CassTestEntityService from '@/entities/cass-test-entity/cass-test-entity.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('CassTestEntity Management Detail Component', () => {
    let wrapper: Wrapper<CassTestEntityClass>;
    let comp: CassTestEntityClass;
    let cassTestEntityServiceStub: SinonStubbedInstance<CassTestEntityService>;

    beforeEach(() => {
      cassTestEntityServiceStub = sinon.createStubInstance<CassTestEntityService>(CassTestEntityService);

      wrapper = shallowMount<CassTestEntityClass>(CassTestEntityDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { cassTestEntityService: () => cassTestEntityServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundCassTestEntity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        cassTestEntityServiceStub.find.resolves(foundCassTestEntity);

        // WHEN
        comp.retrieveCassTestEntity('9fec3727-3421-4967-b213-ba36557ca194');
        await comp.$nextTick();

        // THEN
        expect(comp.cassTestEntity).toBe(foundCassTestEntity);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundCassTestEntity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        cassTestEntityServiceStub.find.resolves(foundCassTestEntity);

        // WHEN
        comp.beforeRouteEnter({ params: { cassTestEntityId: '9fec3727-3421-4967-b213-ba36557ca194' } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.cassTestEntity).toBe(foundCassTestEntity);
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
