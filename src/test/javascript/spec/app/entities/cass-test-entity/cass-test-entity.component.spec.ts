/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import CassTestEntityComponent from '@/entities/cass-test-entity/cass-test-entity.vue';
import CassTestEntityClass from '@/entities/cass-test-entity/cass-test-entity.component';
import CassTestEntityService from '@/entities/cass-test-entity/cass-test-entity.service';

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
  describe('CassTestEntity Management Component', () => {
    let wrapper: Wrapper<CassTestEntityClass>;
    let comp: CassTestEntityClass;
    let cassTestEntityServiceStub: SinonStubbedInstance<CassTestEntityService>;

    beforeEach(() => {
      cassTestEntityServiceStub = sinon.createStubInstance<CassTestEntityService>(CassTestEntityService);
      cassTestEntityServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<CassTestEntityClass>(CassTestEntityComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          cassTestEntityService: () => cassTestEntityServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      cassTestEntityServiceStub.retrieve.resolves({ headers: {}, data: [{ id: '9fec3727-3421-4967-b213-ba36557ca194' }] });

      // WHEN
      comp.retrieveAllCassTestEntitys();
      await comp.$nextTick();

      // THEN
      expect(cassTestEntityServiceStub.retrieve.called).toBeTruthy();
      expect(comp.cassTestEntities[0]).toEqual(jasmine.objectContaining({ id: '9fec3727-3421-4967-b213-ba36557ca194' }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      cassTestEntityServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: '9fec3727-3421-4967-b213-ba36557ca194' });
      comp.removeCassTestEntity();
      await comp.$nextTick();

      // THEN
      expect(cassTestEntityServiceStub.delete.called).toBeTruthy();
      expect(cassTestEntityServiceStub.retrieve.callCount).toEqual(1);
    });
  });
});
