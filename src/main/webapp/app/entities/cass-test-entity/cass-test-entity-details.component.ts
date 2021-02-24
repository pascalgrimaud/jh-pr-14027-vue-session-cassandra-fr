import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ICassTestEntity } from '@/shared/model/cass-test-entity.model';
import CassTestEntityService from './cass-test-entity.service';

@Component
export default class CassTestEntityDetails extends mixins(JhiDataUtils) {
  @Inject('cassTestEntityService') private cassTestEntityService: () => CassTestEntityService;
  public cassTestEntity: ICassTestEntity = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cassTestEntityId) {
        vm.retrieveCassTestEntity(to.params.cassTestEntityId);
      }
    });
  }

  public retrieveCassTestEntity(cassTestEntityId) {
    this.cassTestEntityService()
      .find(cassTestEntityId)
      .then(res => {
        this.cassTestEntity = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
