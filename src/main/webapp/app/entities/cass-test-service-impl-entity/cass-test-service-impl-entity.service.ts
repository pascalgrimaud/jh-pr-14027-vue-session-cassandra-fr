import axios from 'axios';

import { ICassTestServiceImplEntity } from '@/shared/model/cass-test-service-impl-entity.model';

const baseApiUrl = 'api/cass-test-service-impl-entities';

export default class CassTestServiceImplEntityService {
  public find(id: string): Promise<ICassTestServiceImplEntity> {
    return new Promise<ICassTestServiceImplEntity>((resolve, reject) => {
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

  public create(entity: ICassTestServiceImplEntity): Promise<ICassTestServiceImplEntity> {
    return new Promise<ICassTestServiceImplEntity>((resolve, reject) => {
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

  public update(entity: ICassTestServiceImplEntity): Promise<ICassTestServiceImplEntity> {
    return new Promise<ICassTestServiceImplEntity>((resolve, reject) => {
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
