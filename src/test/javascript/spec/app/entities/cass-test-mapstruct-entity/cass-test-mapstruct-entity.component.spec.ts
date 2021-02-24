/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import CassTestMapstructEntityComponent from '@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity.vue';
import CassTestMapstructEntityClass from '@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity.component';
import CassTestMapstructEntityService from '@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity.service';

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
  describe('CassTestMapstructEntity Management Component', () => {
    let wrapper: Wrapper<CassTestMapstructEntityClass>;
    let comp: CassTestMapstructEntityClass;
    let cassTestMapstructEntityServiceStub: SinonStubbedInstance<CassTestMapstructEntityService>;

    beforeEach(() => {
      cassTestMapstructEntityServiceStub = sinon.createStubInstance<CassTestMapstructEntityService>(CassTestMapstructEntityService);
      cassTestMapstructEntityServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<CassTestMapstructEntityClass>(CassTestMapstructEntityComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          cassTestMapstructEntityService: () => cassTestMapstructEntityServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      cassTestMapstructEntityServiceStub.retrieve.resolves({ headers: {}, data: [{ id: '9fec3727-3421-4967-b213-ba36557ca194' }] });

      // WHEN
      comp.retrieveAllCassTestMapstructEntitys();
      await comp.$nextTick();

      // THEN
      expect(cassTestMapstructEntityServiceStub.retrieve.called).toBeTruthy();
      expect(comp.cassTestMapstructEntities[0]).toEqual(jasmine.objectContaining({ id: '9fec3727-3421-4967-b213-ba36557ca194' }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      cassTestMapstructEntityServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: '9fec3727-3421-4967-b213-ba36557ca194' });
      comp.removeCassTestMapstructEntity();
      await comp.$nextTick();

      // THEN
      expect(cassTestMapstructEntityServiceStub.delete.called).toBeTruthy();
      expect(cassTestMapstructEntityServiceStub.retrieve.callCount).toEqual(1);
    });
  });
});
