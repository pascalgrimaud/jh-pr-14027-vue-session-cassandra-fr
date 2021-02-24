import axios from 'axios';

import { ICassBankAccountMySuffix } from '@/shared/model/cass-bank-account-my-suffix.model';

const baseApiUrl = 'api/cass-bank-accounts';

export default class CassBankAccountMySuffixService {
  public find(id: string): Promise<ICassBankAccountMySuffix> {
    return new Promise<ICassBankAccountMySuffix>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public delete(id: string): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .delete(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public create(entity: ICassBankAccountMySuffix): Promise<ICassBankAccountMySuffix> {
    return new Promise<ICassBankAccountMySuffix>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public update(entity: ICassBankAccountMySuffix): Promise<ICassBankAccountMySuffix> {
    return new Promise<ICassBankAccountMySuffix>((resolve, reject) => {
      axios
        .put(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
