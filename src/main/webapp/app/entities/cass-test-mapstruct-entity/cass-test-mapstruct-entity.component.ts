import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ICassTestMapstructEntity } from '@/shared/model/cass-test-mapstruct-entity.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import CassTestMapstructEntityService from './cass-test-mapstruct-entity.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class CassTestMapstructEntity extends mixins(JhiDataUtils) {
  @Inject('cassTestMapstructEntityService') private cassTestMapstructEntityService: () => CassTestMapstructEntityService;
  private removeId: string = null;

  public cassTestMapstructEntities: ICassTestMapstructEntity[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllCassTestMapstructEntitys();
  }

  public clear(): void {
    this.retrieveAllCassTestMapstructEntitys();
  }

  public retrieveAllCassTestMapstructEntitys(): void {
    this.isFetching = true;

    this.cassTestMapstructEntityService()
      .retrieve()
      .then(
        res => {
          this.cassTestMapstructEntities = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: ICassTestMapstructEntity): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeCassTestMapstructEntity(): void {
    this.cassTestMapstructEntityService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.cassTestMapstructEntity.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllCassTestMapstructEntitys();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
