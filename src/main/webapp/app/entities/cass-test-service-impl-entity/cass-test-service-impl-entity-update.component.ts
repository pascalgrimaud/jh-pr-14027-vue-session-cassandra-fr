import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { required, minLength, maxLength, numeric, minValue, maxValue, decimal } from 'vuelidate/lib/validators';
import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import { ICassTestServiceImplEntity, CassTestServiceImplEntity } from '@/shared/model/cass-test-service-impl-entity.model';
import CassTestServiceImplEntityService from './cass-test-service-impl-entity.service';

const validations: any = {
  cassTestServiceImplEntity: {
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
export default class CassTestServiceImplEntityUpdate extends mixins(JhiDataUtils) {
  @Inject('cassTestServiceImplEntityService') private cassTestServiceImplEntityService: () => CassTestServiceImplEntityService;
  public cassTestServiceImplEntity: ICassTestServiceImplEntity = new CassTestServiceImplEntity();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.cassTestServiceImplEntityId) {
        vm.retrieveCassTestServiceImplEntity(to.params.cassTestServiceImplEntityId);
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
    if (this.cassTestServiceImplEntity.id) {
      this.cassTestServiceImplEntityService()
        .update(this.cassTestServiceImplEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.cassTestServiceImplEntity.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.cassTestServiceImplEntityService()
        .create(this.cassTestServiceImplEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.cassTestServiceImplEntity.created', { param: param.id });
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
      this.cassTestServiceImplEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.cassTestServiceImplEntity[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.cassTestServiceImplEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.cassTestServiceImplEntity[field] = null;
    }
  }

  public retrieveCassTestServiceImplEntity(cassTestServiceImplEntityId): void {
    this.cassTestServiceImplEntityService()
      .find(cassTestServiceImplEntityId)
      .then(res => {
        res.instantDateField = new Date(res.instantDateField);
        res.instantRequiredField = new Date(res.instantRequiredField);
        res.zonedDateTimeField = new Date(res.zonedDateTimeField);
        res.zonedDateTimeRequiredField = new Date(res.zonedDateTimeRequiredField);
        this.cassTestServiceImplEntity = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.cassTestServiceImplEntity && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.cassTestServiceImplEntity, field)) {
        this.cassTestServiceImplEntity[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.cassTestServiceImplEntity, fieldContentType)) {
        this.cassTestServiceImplEntity[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
