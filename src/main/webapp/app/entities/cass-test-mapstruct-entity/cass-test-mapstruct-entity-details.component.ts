import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ICassTestMapstructEntity } from '@/shared/model/cass-test-mapstruct-entity.model';
import CassTestMapstructEntityService from './cass-test-mapstruct-entity.service';

@Component
export default class CassTestMapstructEntityDetails extends mixins(JhiDataUtils) {
  @Inject('cassTestMapstructEntityService') private cassTestMapstructEntityService: () => CassTestMapstructEntityService;
  public cassTestMapstructEntity: ICassTestMapstructEntity = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cassTestMapstructEntityId) {
        vm.retrieveCassTestMapstructEntity(to.params.cassTestMapstructEntityId);
      }
    });
  }

  public retrieveCassTestMapstructEntity(cassTestMapstructEntityId) {
    this.cassTestMapstructEntityService()
      .find(cassTestMapstructEntityId)
      .then(res => {
        this.cassTestMapstructEntity = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
