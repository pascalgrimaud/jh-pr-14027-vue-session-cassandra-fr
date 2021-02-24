import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { required, minLength, maxLength, numeric, minValue, maxValue, decimal } from 'vuelidate/lib/validators';
import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import { ICassTestMapstructEntity, CassTestMapstructEntity } from '@/shared/model/cass-test-mapstruct-entity.model';
import CassTestMapstructEntityService from './cass-test-mapstruct-entity.service';

const validations: any = {
  cassTestMapstructEntity: {
    stringField: {},
    stringRequiredField: {
      required,
    },
    stringMinlengthField: {
      minLength: minLength(0),
    },
    stringMaxlengthField: {
      maxLength: maxLength(20),
    },
    stringPatternField: {},
    integerField: {},
    integerRequiredField: {
      required,
      numeric,
    },
    integerMinField: {
      numeric,
      min: minValue(0),
    },
    integerMaxField: {
      numeric,
      max: maxValue(100),
    },
    longField: {},
    longRequiredField: {
      required,
      numeric,
    },
    longMinField: {
      numeric,
      min: minValue(0),
    },
    longMaxField: {
      numeric,
      max: maxValue(100),
    },
    floatField: {},
    floatRequiredField: {
      required,
      decimal,
    },
    floatMinField: {
      decimal,
      min: minValue(0),
    },
    floatMaxField: {
      decimal,
      max: maxValue(100),
    },
    doubleRequiredField: {
      required,
      decimal,
    },
    doubleMinField: {
      decimal,
      min: minValue(0),
    },
    doubleMaxField: {
      decimal,
      max: maxValue(100),
    },
    bigDecimalRequiredField: {
      required,
      decimal,
    },
    bigDecimalMinField: {
      decimal,
      min: minValue(0),
    },
    bigDecimalMaxField: {
      decimal,
      max: maxValue(100),
    },
    localDateField: {},
    localDateRequiredField: {
      required,
    },
    instantDateField: {},
    instantRequiredField: {
      required,
    },
    zonedDateTimeField: {},
    zonedDateTimeRequiredField: {
      required,
    },
    durationDateField: {},
    durationRequiredField: {
      required,
    },
    booleanField: {},
    booleanRequiredField: {
      required,
    },
    enumTom: {},
    enumRequiredTom: {
      required,
    },
    picture: {},
    operationsFile: {},
  },
};

@Component({
  validations,
})
export default class CassTestMapstructEntityUpdate extends mixins(JhiDataUtils) {
  @Inject('cassTestMapstructEntityService') private cassTestMapstructEntityService: () => CassTestMapstructEntityService;
  public cassTestMapstructEntity: ICassTestMapstructEntity = new CassTestMapstructEntity();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cassTestMapstructEntityId) {
        vm.retrieveCassTestMapstructEntity(to.params.cassTestMapstructEntityId);
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
    if (this.cassTestMapstructEntity.id) {
      this.cassTestMapstructEntityService()
        .update(this.cassTestMapstructEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.cassTestMapstructEntity.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.cassTestMapstructEntityService()
        .create(this.cassTestMapstructEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.cassTestMapstructEntity.created', { param: param.id });
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
      this.cassTestMapstructEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.cassTestMapstructEntity[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.cassTestMapstructEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.cassTestMapstructEntity[field] = null;
    }
  }

  public retrieveCassTestMapstructEntity(cassTestMapstructEntityId): void {
    this.cassTestMapstructEntityService()
      .find(cassTestMapstructEntityId)
      .then(res => {
        res.instantDateField = new Date(res.instantDateField);
        res.instantRequiredField = new Date(res.instantRequiredField);
        res.zonedDateTimeField = new Date(res.zonedDateTimeField);
        res.zonedDateTimeRequiredField = new Date(res.zonedDateTimeRequiredField);
        this.cassTestMapstructEntity = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.cassTestMapstructEntity && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.cassTestMapstructEntity, field)) {
        this.cassTestMapstructEntity[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.cassTestMapstructEntity, fieldContentType)) {
        this.cassTestMapstructEntity[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
