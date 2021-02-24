import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ICassTestServiceClassEntity } from '@/shared/model/cass-test-service-class-entity.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import CassTestServiceClassEntityService from './cass-test-service-class-entity.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class CassTestServiceClassEntity extends mixins(JhiDataUtils) {
  @Inject('cassTestServiceClassEntityService') private cassTestServiceClassEntityService: () => CassTestServiceClassEntityService;
  private removeId: string = null;

  public cassTestServiceClassEntities: ICassTestServiceClassEntity[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllCassTestServiceClassEntitys();
  }

  public clear(): void {
    this.retrieveAllCassTestServiceClassEntitys();
  }

  public retrieveAllCassTestServiceClassEntitys(): void {
    this.isFetching = true;

    this.cassTestServiceClassEntityService()
      .retrieve()
      .then(
        res => {
          this.cassTestServiceClassEntities = res.data;
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

  public prepareRemove(instance: ICassTestServiceClassEntity): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeCassTestServiceClassEntity(): void {
    this.cassTestServiceClassEntityService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.cassTestServiceClassEntity.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllCassTestServiceClassEntitys();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
