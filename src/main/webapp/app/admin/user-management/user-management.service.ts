import axios from 'axios';
import buildPaginationQueryOpts from '@/shared/sort/sorts';
import { Authority } from '@/shared/security/authority';

export default class UserManagementService {
  public get(userId: string): Promise<any> {
    return axios.get(`api/admin/users/${userId}`);
  }

  public create(user): Promise<any> {
    return axios.post('api/admin/users', user);
  }

  public update(user): Promise<any> {
    return axios.put('api/admin/users', user);
  }

  public remove(userId: string): Promise<any> {
    return axios.delete(`api/admin/users/${userId}`);
  }

  public retrieve(): Promise<any> {
    return axios.get(`api/admin/users`);
  }

  public retrieveAuthorities(): Promise<any> {
    return Promise.resolve([Authority.USER, Authority.ADMIN]);
  }
}
