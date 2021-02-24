import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const CassBankAccountMySuffix = () => import('@/entities/cass-bank-account-my-suffix/cass-bank-account-my-suffix.vue');
// prettier-ignore
const CassBankAccountMySuffixUpdate = () => import('@/entities/cass-bank-account-my-suffix/cass-bank-account-my-suffix-update.vue');
// prettier-ignore
const CassBankAccountMySuffixDetails = () => import('@/entities/cass-bank-account-my-suffix/cass-bank-account-my-suffix-details.vue');
// prettier-ignore
const CassTestEntity = () => import('@/entities/cass-test-entity/cass-test-entity.vue');
// prettier-ignore
const CassTestEntityUpdate = () => import('@/entities/cass-test-entity/cass-test-entity-update.vue');
// prettier-ignore
const CassTestEntityDetails = () => import('@/entities/cass-test-entity/cass-test-entity-details.vue');
// prettier-ignore
const CassTestMapstructEntity = () => import('@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity.vue');
// prettier-ignore
const CassTestMapstructEntityUpdate = () => import('@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity-update.vue');
// prettier-ignore
const CassTestMapstructEntityDetails = () => import('@/entities/cass-test-mapstruct-entity/cass-test-mapstruct-entity-details.vue');
// prettier-ignore
const CassTestServiceClassEntity = () => import('@/entities/cass-test-service-class-entity/cass-test-service-class-entity.vue');
// prettier-ignore
const CassTestServiceClassEntityUpdate = () => import('@/entities/cass-test-service-class-entity/cass-test-service-class-entity-update.vue');
// prettier-ignore
const CassTestServiceClassEntityDetails = () => import('@/entities/cass-test-service-class-entity/cass-test-service-class-entity-details.vue');
// prettier-ignore
const CassTestServiceImplEntity = () => import('@/entities/cass-test-service-impl-entity/cass-test-service-impl-entity.vue');
// prettier-ignore
const CassTestServiceImplEntityUpdate = () => import('@/entities/cass-test-service-impl-entity/cass-test-service-impl-entity-update.vue');
// prettier-ignore
const CassTestServiceImplEntityDetails = () => import('@/entities/cass-test-service-impl-entity/cass-test-service-impl-entity-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/cass-bank-account-my-suffix',
    name: 'CassBankAccountMySuffix',
    component: CassBankAccountMySuffix,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-bank-account-my-suffix/new',
    name: 'CassBankAccountMySuffixCreate',
    component: CassBankAccountMySuffixUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-bank-account-my-suffix/:cassBankAccountId/edit',
    name: 'CassBankAccountMySuffixEdit',
    component: CassBankAccountMySuffixUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-bank-account-my-suffix/:cassBankAccountId/view',
    name: 'CassBankAccountMySuffixView',
    component: CassBankAccountMySuffixDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-entity',
    name: 'CassTestEntity',
    component: CassTestEntity,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-entity/new',
    name: 'CassTestEntityCreate',
    component: CassTestEntityUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-entity/:cassTestEntityId/edit',
    name: 'CassTestEntityEdit',
    component: CassTestEntityUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-entity/:cassTestEntityId/view',
    name: 'CassTestEntityView',
    component: CassTestEntityDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-mapstruct-entity',
    name: 'CassTestMapstructEntity',
    component: CassTestMapstructEntity,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-mapstruct-entity/new',
    name: 'CassTestMapstructEntityCreate',
    component: CassTestMapstructEntityUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-mapstruct-entity/:cassTestMapstructEntityId/edit',
    name: 'CassTestMapstructEntityEdit',
    component: CassTestMapstructEntityUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-mapstruct-entity/:cassTestMapstructEntityId/view',
    name: 'CassTestMapstructEntityView',
    component: CassTestMapstructEntityDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-service-class-entity',
    name: 'CassTestServiceClassEntity',
    component: CassTestServiceClassEntity,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-service-class-entity/new',
    name: 'CassTestServiceClassEntityCreate',
    component: CassTestServiceClassEntityUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-service-class-entity/:cassTestServiceClassEntityId/edit',
    name: 'CassTestServiceClassEntityEdit',
    component: CassTestServiceClassEntityUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-service-class-entity/:cassTestServiceClassEntityId/view',
    name: 'CassTestServiceClassEntityView',
    component: CassTestServiceClassEntityDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-service-impl-entity',
    name: 'CassTestServiceImplEntity',
    component: CassTestServiceImplEntity,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-service-impl-entity/new',
    name: 'CassTestServiceImplEntityCreate',
    component: CassTestServiceImplEntityUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-service-impl-entity/:cassTestServiceImplEntityId/edit',
    name: 'CassTestServiceImplEntityEdit',
    component: CassTestServiceImplEntityUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/cass-test-service-impl-entity/:cassTestServiceImplEntityId/view',
    name: 'CassTestServiceImplEntityView',
    component: CassTestServiceImplEntityDetails,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
