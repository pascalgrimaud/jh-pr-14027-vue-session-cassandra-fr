import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ICassTestEntity } from '@/shared/model/cass-test-entity.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import CassTestEntityService from './cass-test-entity.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class CassTestEntity extends mixins(JhiDataUtils) {
  @Inject('cassTestEntityService') private cassTestEntityService: () => CassTestEntityService;
  private removeId: string = null;

  public cassTestEntities: ICassTestEntity[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllCassTestEntitys();
  }

  public clear(): void {
    this.retrieveAllCassTestEntitys();
  }

  public retrieveAllCassTestEntitys(): void {
    this.isFetching = true;

    this.cassTestEntityService()
      .retrieve()
      .then(
        res => {
          this.cassTestEntities = res.data;
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

  public prepareRemove(instance: ICassTestEntity): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeCassTestEntity(): void {
    this.cassTestEntityService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.cassTestEntity.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllCassTestEntitys();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
