/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import CassBankAccountMySuffixService from '@/entities/cass-bank-account-my-suffix/cass-bank-account-my-suffix.service';
import { CassBankAccountMySuffix } from '@/shared/model/cass-bank-account-my-suffix.model';
import { AccountTypeEnum } from '@/shared/model/enumerations/account-type-enum.model';

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
  describe('CassBankAccountMySuffix Service', () => {
    let service: CassBankAccountMySuffixService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new CassBankAccountMySuffixService();
      currentDate = new Date();
      elemDefault = new CassBankAccountMySuffix(
        'ID',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        0,
        0,
        0,
        currentDate,
        false,
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        AccountTypeEnum.STANDARD
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            lastOperationDate: dayjs(currentDate).format(DATE_TIME_FORMAT),
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

      it('should create a CassBankAccountMySuffix', async () => {
        const returnedFromService = Object.assign(
          {
            id: 'ID',
            lastOperationDate: dayjs(currentDate).format(DATE_TIME_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            lastOperationDate: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a CassBankAccountMySuffix', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a CassBankAccountMySuffix', async () => {
        const returnedFromService = Object.assign(
          {
            userId: 'BBBBBB',
            name: 'BBBBBB',
            bankNumber: 1,
            agencyNumber: 1,
            lastOperationDuration: 1,
            meanOperationDuration: 1,
            balance: 1,
            lastOperationDate: dayjs(currentDate).format(DATE_TIME_FORMAT),
            active: true,
            picture: 'BBBBBB',
            operationsFile: 'BBBBBB',
            accountType: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            lastOperationDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a CassBankAccountMySuffix', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of CassBankAccountMySuffix', async () => {
        const returnedFromService = Object.assign(
          {
            userId: 'BBBBBB',
            name: 'BBBBBB',
            bankNumber: 1,
            agencyNumber: 1,
            lastOperationDuration: 1,
            meanOperationDuration: 1,
            balance: 1,
            lastOperationDate: dayjs(currentDate).format(DATE_TIME_FORMAT),
            active: true,
            picture: 'BBBBBB',
            operationsFile: 'BBBBBB',
            accountType: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            lastOperationDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of CassBankAccountMySuffix', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a CassBankAccountMySuffix', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete('9fec3727-3421-4967-b213-ba36557ca194').then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a CassBankAccountMySuffix', async () => {
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
