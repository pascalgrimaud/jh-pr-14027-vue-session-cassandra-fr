import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';
export interface ICassTestEntity {
  id?: string;
  stringField?: string | null;
  stringRequiredField?: string;
  stringMinlengthField?: string | null;
  stringMaxlengthField?: string | null;
  stringPatternField?: string | null;
  integerField?: number | null;
  integerRequiredField?: number;
  integerMinField?: number | null;
  integerMaxField?: number | null;
  longField?: number | null;
  longRequiredField?: number;
  longMinField?: number | null;
  longMaxField?: number | null;
  floatField?: number | null;
  floatRequiredField?: number;
  floatMinField?: number | null;
  floatMaxField?: number | null;
  doubleRequiredField?: number;
  doubleMinField?: number | null;
  doubleMaxField?: number | null;
  bigDecimalRequiredField?: number;
  bigDecimalMinField?: number | null;
  bigDecimalMaxField?: number | null;
  localDateField?: Date | null;
  localDateRequiredField?: Date;
  instantDateField?: Date | null;
  instantRequiredField?: Date;
  zonedDateTimeField?: Date | null;
  zonedDateTimeRequiredField?: Date;
  durationDateField?: string | null;
  durationRequiredField?: string;
  booleanField?: boolean | null;
  booleanRequiredField?: boolean;
  enumTom?: EnumFieldClass | null;
  enumRequiredTom?: EnumRequiredFieldClass;
  pictureContentType?: string | null;
  picture?: string | null;
  operationsFileContentType?: string | null;
  operationsFile?: string | null;
}

export class CassTestEntity implements ICassTestEntity {
  constructor(
    public id?: string,
    public stringField?: string | null,
    public stringRequiredField?: string,
    public stringMinlengthField?: string | null,
    public stringMaxlengthField?: string | null,
    public stringPatternField?: string | null,
    public integerField?: number | null,
    public integerRequiredField?: number,
    public integerMinField?: number | null,
    public integerMaxField?: number | null,
    public longField?: number | null,
    public longRequiredField?: number,
    public longMinField?: number | null,
    public longMaxField?: number | null,
    public floatField?: number | null,
    public floatRequiredField?: number,
    public floatMinField?: number | null,
    public floatMaxField?: number | null,
    public doubleRequiredField?: number,
    public doubleMinField?: number | null,
    public doubleMaxField?: number | null,
    public bigDecimalRequiredField?: number,
    public bigDecimalMinField?: number | null,
    public bigDecimalMaxField?: number | null,
    public localDateField?: Date | null,
    public localDateRequiredField?: Date,
    public instantDateField?: Date | null,
    public instantRequiredField?: Date,
    public zonedDateTimeField?: Date | null,
    public zonedDateTimeRequiredField?: Date,
    public durationDateField?: string | null,
    public durationRequiredField?: string,
    public booleanField?: boolean | null,
    public booleanRequiredField?: boolean,
    public enumTom?: EnumFieldClass | null,
    public enumRequiredTom?: EnumRequiredFieldClass,
    public pictureContentType?: string | null,
    public picture?: string | null,
    public operationsFileContentType?: string | null,
    public operationsFile?: string | null
  ) {
    this.booleanField = this.booleanField ?? false;
    this.booleanRequiredField = this.booleanRequiredField ?? false;
  }
}
