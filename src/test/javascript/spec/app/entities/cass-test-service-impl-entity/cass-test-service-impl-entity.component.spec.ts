/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import CassTestServiceImplEntityComponent from '@/entities/cass-test-service-impl-entity/cass-test-service-impl-entity.vue';
import CassTestServiceImplEntityClass from '@/entities/cass-test-service-impl-entity/cass-test-service-impl-entity.component';
import CassTestServiceImplEntityService from '@/entities/cass-test-service-impl-entity/cass-test-service-impl-entity.service';

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
  describe('CassTestServiceImplEntity Management Component', () => {
    let wrapper: Wrapper<CassTestServiceImplEntityClass>;
    let comp: CassTestServiceImplEntityClass;
    let cassTestServiceImplEntityServiceStub: SinonStubbedInstance<CassTestServiceImplEntityService>;

    beforeEach(() => {
      cassTestServiceImplEntityServiceStub = sinon.createStubInstance<CassTestServiceImplEntityService>(CassTestServiceImplEntityService);
      cassTestServiceImplEntityServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<CassTestServiceImplEntityClass>(CassTestServiceImplEntityComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          cassTestServiceImplEntityService: () => cassTestServiceImplEntityServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      cassTestServiceImplEntityServiceStub.retrieve.resolves({ headers: {}, data: [{ id: '9fec3727-3421-4967-b213-ba36557ca194' }] });

      // WHEN
      comp.retrieveAllCassTestServiceImplEntitys();
      await comp.$nextTick();

      // THEN
      expect(cassTestServiceImplEntityServiceStub.retrieve.called).toBeTruthy();
      expect(comp.cassTestServiceImplEntities[0]).toEqual(jasmine.objectContaining({ id: '9fec3727-3421-4967-b213-ba36557ca194' }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      cassTestServiceImplEntityServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: '9fec3727-3421-4967-b213-ba36557ca194' });
      comp.removeCassTestServiceImplEntity();
      await comp.$nextTick();

      // THEN
      expect(cassTestServiceImplEntityServiceStub.delete.called).toBeTruthy();
      expect(cassTestServiceImplEntityServiceStub.retrieve.callCount).toEqual(1);
    });
  });
});
