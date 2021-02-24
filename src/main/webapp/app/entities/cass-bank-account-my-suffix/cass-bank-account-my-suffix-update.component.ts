import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { required, decimal } from 'vuelidate/lib/validators';
import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import { ICassBankAccountMySuffix, CassBankAccountMySuffix } from '@/shared/model/cass-bank-account-my-suffix.model';
import CassBankAccountMySuffixService from './cass-bank-account-my-suffix.service';

const validations: any = {
  cassBankAccount: {
    userId: {},
    name: {
      required,
    },
    bankNumber: {},
    agencyNumber: {},
    lastOperationDuration: {},
    meanOperationDuration: {},
    balance: {
      required,
      decimal,
    },
    lastOperationDate: {},
    active: {},
    picture: {},
    operationsFile: {},
    accountType: {},
  },
};

@Component({
  validations,
})
export default class CassBankAccountMySuffixUpdate extends mixins(JhiDataUtils) {
  @Inject('cassBankAccountService') private cassBankAccountService: () => CassBankAccountMySuffixService;
  public cassBankAccount: ICassBankAccountMySuffix = new CassBankAccountMySuffix();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cassBankAccountId) {
        vm.retrieveCassBankAccountMySuffix(to.params.cassBankAccountId);
      }
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.cassBankAccount.id) {
      this.cassBankAccountService()
        .update(this.cassBankAccount)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.cassBankAccount.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.cassBankAccountService()
        .create(this.cassBankAccount)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.cassBankAccount.created', { param: param.id });
          this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    }
  }

  public convertDateTimeFromServer(date: Date): string {
    if (date && dayjs(date).isValid()) {
      return dayjs(date).format(DATE_TIME_LONG_FORMAT);
    }
    return null;
  }

  public updateInstantField(field, event) {
    if (event.target.value) {
      this.cassBankAccount[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.cassBankAccount[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.cassBankAccount[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.cassBankAccount[field] = null;
    }
  }

  public retrieveCassBankAccountMySuffix(cassBankAccountId): void {
    this.cassBankAccountService()
      .find(cassBankAccountId)
      .then(res => {
        res.lastOperationDate = new Date(res.lastOperationDate);
        this.cassBankAccount = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.cassBankAccount && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.cassBankAccount, field)) {
        this.cassBankAccount[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.cassBankAccount, fieldContentType)) {
        this.cassBankAccount[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
