import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ICassBankAccountMySuffix } from '@/shared/model/cass-bank-account-my-suffix.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import CassBankAccountMySuffixService from './cass-bank-account-my-suffix.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class CassBankAccountMySuffix extends mixins(JhiDataUtils) {
  @Inject('cassBankAccountService') private cassBankAccountService: () => CassBankAccountMySuffixService;
  private removeId: string = null;

  public cassBankAccounts: ICassBankAccountMySuffix[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllCassBankAccountMySuffixs();
  }

  public clear(): void {
    this.retrieveAllCassBankAccountMySuffixs();
  }

  public retrieveAllCassBankAccountMySuffixs(): void {
    this.isFetching = true;

    this.cassBankAccountService()
      .retrieve()
      .then(
        res => {
          this.cassBankAccounts = res.data;
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

  public prepareRemove(instance: ICassBankAccountMySuffix): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeCassBankAccountMySuffix(): void {
    this.cassBankAccountService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.cassBankAccount.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllCassBankAccountMySuffixs();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
