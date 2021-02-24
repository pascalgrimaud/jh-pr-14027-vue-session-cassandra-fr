import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { ICassBankAccountMySuffix } from '@/shared/model/cass-bank-account-my-suffix.model';
import CassBankAccountMySuffixService from './cass-bank-account-my-suffix.service';

@Component
export default class CassBankAccountMySuffixDetails extends mixins(JhiDataUtils) {
  @Inject('cassBankAccountService') private cassBankAccountService: () => CassBankAccountMySuffixService;
  public cassBankAccount: ICassBankAccountMySuffix = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cassBankAccountId) {
        vm.retrieveCassBankAccountMySuffix(to.params.cassBankAccountId);
      }
    });
  }

  public retrieveCassBankAccountMySuffix(cassBankAccountId) {
    this.cassBankAccountService()
      .find(cassBankAccountId)
      .then(res => {
        this.cassBankAccount = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
