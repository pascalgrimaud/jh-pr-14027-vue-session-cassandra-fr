import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ICassTestServiceClassEntity } from '@/shared/model/cass-test-service-class-entity.model';
import CassTestServiceClassEntityService from './cass-test-service-class-entity.service';

@Component
export default class CassTestServiceClassEntityDetails extends mixins(JhiDataUtils) {
  @Inject('cassTestServiceClassEntityService') private cassTestServiceClassEntityService: () => CassTestServiceClassEntityService;
  public cassTestServiceClassEntity: ICassTestServiceClassEntity = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cassTestServiceClassEntityId) {
        vm.retrieveCassTestServiceClassEntity(to.params.cassTestServiceClassEntityId);
      }
    });
  }

  public retrieveCassTestServiceClassEntity(cassTestServiceClassEntityId) {
    this.cassTestServiceClassEntityService()
      .find(cassTestServiceClassEntityId)
      .then(res => {
        this.cassTestServiceClassEntity = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
