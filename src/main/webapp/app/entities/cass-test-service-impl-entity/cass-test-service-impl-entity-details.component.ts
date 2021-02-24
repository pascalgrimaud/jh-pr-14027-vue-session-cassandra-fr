import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ICassTestServiceImplEntity } from '@/shared/model/cass-test-service-impl-entity.model';
import CassTestServiceImplEntityService from './cass-test-service-impl-entity.service';

@Component
export default class CassTestServiceImplEntityDetails extends mixins(JhiDataUtils) {
  @Inject('cassTestServiceImplEntityService') private cassTestServiceImplEntityService: () => CassTestServiceImplEntityService;
  public cassTestServiceImplEntity: ICassTestServiceImplEntity = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cassTestServiceImplEntityId) {
        vm.retrieveCassTestServiceImplEntity(to.params.cassTestServiceImplEntityId);
      }
    });
  }

  public retrieveCassTestServiceImplEntity(cassTestServiceImplEntityId) {
    this.cassTestServiceImplEntityService()
      .find(cassTestServiceImplEntityId)
      .then(res => {
        this.cassTestServiceImplEntity = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
