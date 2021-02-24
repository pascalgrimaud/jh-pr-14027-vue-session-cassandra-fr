/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT, DATE_TIME_FORMAT } from '@/shared/date/filters';
import CassTestEntityService from '@/entities/cass-test-entity/cass-test-entity.service';
import { CassTestEntity } from '@/shared/model/cass-test-entity.model';
import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('CassTestEntity Service', () => {
    let service: CassTestEntityService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new CassTestEntityService();
      currentDate = new Date();
      elemDefault = new CassTestEntity(
        'ID',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        currentDate,
        currentDate,
        currentDate,
        currentDate,
        currentDate,
        currentDate,
        'PT1S',
        'PT1S',
        false,
        false,
        EnumFieldClass.ENUM_VALUE_1,
        EnumRequiredFieldClass.ENUM_VALUE_1,
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            localDateField: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredField: dayjs(currentDate).format(DATE_FORMAT),
            instantDateField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instantRequiredField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredField: dayjs(currentDate).format(DATE_TIME_FORMAT),
          },
          elemDefault
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find('9fec3727-3421-4967-b213-ba36557ca194').then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find('9fec3727-3421-4967-b213-ba36557ca194')
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should create a CassTestEntity', async () => {
        const returnedFromService = Object.assign(
          {
            id: 'ID',
            localDateField: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredField: dayjs(currentDate).format(DATE_FORMAT),
            instantDateField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instantRequiredField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredField: dayjs(currentDate).format(DATE_TIME_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateField: currentDate,
            localDateRequiredField: currentDate,
            instantDateField: currentDate,
            instantRequiredField: currentDate,
            zonedDateTimeField: currentDate,
            zonedDateTimeRequiredField: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a CassTestEntity', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a CassTestEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringField: 'BBBBBB',
            stringRequiredField: 'BBBBBB',
            stringMinlengthField: 'BBBBBB',
            stringMaxlengthField: 'BBBBBB',
            stringPatternField: 'BBBBBB',
            integerField: 1,
            integerRequiredField: 1,
            integerMinField: 1,
            integerMaxField: 1,
            longField: 1,
            longRequiredField: 1,
            longMinField: 1,
            longMaxField: 1,
            floatField: 1,
            floatRequiredField: 1,
            floatMinField: 1,
            floatMaxField: 1,
            doubleRequiredField: 1,
            doubleMinField: 1,
            doubleMaxField: 1,
            bigDecimalRequiredField: 1,
            bigDecimalMinField: 1,
            bigDecimalMaxField: 1,
            localDateField: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredField: dayjs(currentDate).format(DATE_FORMAT),
            instantDateField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instantRequiredField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationDateField: 'PT2S',
            durationRequiredField: 'PT2S',
            booleanField: true,
            booleanRequiredField: true,
            enumTom: 'BBBBBB',
            enumRequiredTom: 'BBBBBB',
            picture: 'BBBBBB',
            operationsFile: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            localDateField: currentDate,
            localDateRequiredField: currentDate,
            instantDateField: currentDate,
            instantRequiredField: currentDate,
            zonedDateTimeField: currentDate,
            zonedDateTimeRequiredField: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a CassTestEntity', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of CassTestEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringField: 'BBBBBB',
            stringRequiredField: 'BBBBBB',
            stringMinlengthField: 'BBBBBB',
            stringMaxlengthField: 'BBBBBB',
            stringPatternField: 'BBBBBB',
            integerField: 1,
            integerRequiredField: 1,
            integerMinField: 1,
            integerMaxField: 1,
            longField: 1,
            longRequiredField: 1,
            longMinField: 1,
            longMaxField: 1,
            floatField: 1,
            floatRequiredField: 1,
            floatMinField: 1,
            floatMaxField: 1,
            doubleRequiredField: 1,
            doubleMinField: 1,
            doubleMaxField: 1,
            bigDecimalRequiredField: 1,
            bigDecimalMinField: 1,
            bigDecimalMaxField: 1,
            localDateField: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredField: dayjs(currentDate).format(DATE_FORMAT),
            instantDateField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instantRequiredField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredField: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationDateField: 'PT2S',
            durationRequiredField: 'PT2S',
            booleanField: true,
            booleanRequiredField: true,
            enumTom: 'BBBBBB',
            enumRequiredTom: 'BBBBBB',
            picture: 'BBBBBB',
            operationsFile: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateField: currentDate,
            localDateRequiredField: currentDate,
            instantDateField: currentDate,
            instantRequiredField: currentDate,
            zonedDateTimeField: currentDate,
            zonedDateTimeRequiredField: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of CassTestEntity', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a CassTestEntity', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete('9fec3727-3421-4967-b213-ba36557ca194').then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a CassTestEntity', async () => {
        axiosStub.delete.rejects(error);

        return service
          .delete('9fec3727-3421-4967-b213-ba36557ca194')
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
