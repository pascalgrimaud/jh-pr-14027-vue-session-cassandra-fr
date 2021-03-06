/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import * as config from '@/shared/config/config';
import CassTestMapstructEntityUpdateComponent from '@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity-update.vue';
import CassTestMapstructEntityClass from '@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity-update.component';
import CassTestMapstructEntityService from '@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});
localVue.component('b-input-group', {});
localVue.component('b-input-group-prepend', {});
localVue.component('b-form-datepicker', {});
localVue.component('b-form-input', {});

describe('Component Tests', () => {
  describe('CassTestMapstructEntity Management Update Component', () => {
    let wrapper: Wrapper<CassTestMapstructEntityClass>;
    let comp: CassTestMapstructEntityClass;
    let cassTestMapstructEntityServiceStub: SinonStubbedInstance<CassTestMapstructEntityService>;

    beforeEach(() => {
      cassTestMapstructEntityServiceStub = sinon.createStubInstance<CassTestMapstructEntityService>(CassTestMapstructEntityService);

      wrapper = shallowMount<CassTestMapstructEntityClass>(CassTestMapstructEntityUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          cassTestMapstructEntityService: () => cassTestMapstructEntityServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    describe('load', () => {
      it('Should convert date from string', () => {
        // GIVEN
        const date = new Date('2019-10-15T11:42:02Z');

        // WHEN
        const convertedDate = comp.convertDateTimeFromServer(date);

        // THEN
        expect(convertedDate).toEqual(dayjs(date).format(DATE_TIME_LONG_FORMAT));
      });

      it('Should not convert date if date is not present', () => {
        expect(comp.convertDateTimeFromServer(null)).toBeNull();
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        comp.cassTestMapstructEntity = entity;
        cassTestMapstructEntityServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(cassTestMapstructEntityServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.cassTestMapstructEntity = entity;
        cassTestMapstructEntityServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(cassTestMapstructEntityServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundCassTestMapstructEntity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        cassTestMapstructEntityServiceStub.find.resolves(foundCassTestMapstructEntity);
        cassTestMapstructEntityServiceStub.retrieve.resolves([foundCassTestMapstructEntity]);

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
