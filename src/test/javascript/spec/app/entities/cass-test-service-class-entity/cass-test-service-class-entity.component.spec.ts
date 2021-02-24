/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import CassTestServiceClassEntityComponent from '@/entities/cass-test-service-class-entity/cass-test-service-class-entity.vue';
import CassTestServiceClassEntityClass from '@/entities/cass-test-service-class-entity/cass-test-service-class-entity.component';
import CassTestServiceClassEntityService from '@/entities/cass-test-service-class-entity/cass-test-service-class-entity.service';

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
  describe('CassTestServiceClassEntity Management Component', () => {
    let wrapper: Wrapper<CassTestServiceClassEntityClass>;
    let comp: CassTestServiceClassEntityClass;
    let cassTestServiceClassEntityServiceStub: SinonStubbedInstance<CassTestServiceClassEntityService>;

    beforeEach(() => {
      cassTestServiceClassEntityServiceStub = sinon.createStubInstance<CassTestServiceClassEntityService>(
        CassTestServiceClassEntityService
      );
      cassTestServiceClassEntityServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<CassTestServiceClassEntityClass>(CassTestServiceClassEntityComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          cassTestServiceClassEntityService: () => cassTestServiceClassEntityServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      cassTestServiceClassEntityServiceStub.retrieve.resolves({ headers: {}, data: [{ id: '9fec3727-3421-4967-b213-ba36557ca194' }] });

      // WHEN
      comp.retrieveAllCassTestServiceClassEntitys();
      await comp.$nextTick();

      // THEN
      expect(cassTestServiceClassEntityServiceStub.retrieve.called).toBeTruthy();
      expect(comp.cassTestServiceClassEntities[0]).toEqual(jasmine.objectContaining({ id: '9fec3727-3421-4967-b213-ba36557ca194' }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      cassTestServiceClassEntityServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: '9fec3727-3421-4967-b213-ba36557ca194' });
      comp.removeCassTestServiceClassEntity();
      await comp.$nextTick();

      // THEN
      expect(cassTestServiceClassEntityServiceStub.delete.called).toBeTruthy();
      expect(cassTestServiceClassEntityServiceStub.retrieve.callCount).toEqual(1);
    });
  });
});
