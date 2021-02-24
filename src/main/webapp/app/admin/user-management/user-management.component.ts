import { Component, Inject, Vue } from 'vue-property-decorator';
import { mixins } from 'vue-class-component';
import Vue2Filters from 'vue2-filters';
import UserManagementService from './user-management.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class UserManagementComponent extends Vue {
  @Inject('userService') private userManagementService: () => UserManagementService;
  public error = '';
  public success = '';
  public users: any[] = [];
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;
  public isLoading = false;
  public removeId: string = null;

  public mounted(): void {
    this.loadAll();
  }

  public setActive(user, isActivated): void {
    user.activated = isActivated;
    this.userManagementService()
      .update(user)
      .then(() => {
        this.error = null;
        this.success = 'OK';
        this.loadAll();
      })
      .catch(() => {
        this.success = null;
        this.error = 'ERROR';
        user.activated = false;
      });
  }

  public loadAll(): void {
    this.isLoading = true;

    this.userManagementService()
      .retrieve()
      .then(res => {
        this.isLoading = false;
        this.users = res.data;
      })
      .catch(() => {
        this.isLoading = false;
      });
  }

  public handleSyncList(): void {
    this.loadAll();
  }

  public deleteUser(): void {
    this.userManagementService()
      .remove(this.removeId)
      .then(res => {
        const message = this.$t(res.headers['x-jhipsterapp-alert'], {
          param: decodeURIComponent(res.headers['x-jhipsterapp-params'].replace(/\+/g, ' ')),
        });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.loadAll();
        this.closeDialog();
      });
  }

  public prepareRemove(instance): void {
    this.removeId = instance.login;
    if (<any>this.$refs.removeUser) {
      (<any>this.$refs.removeUser).show();
    }
  }

  public closeDialog(): void {
    if (<any>this.$refs.removeUser) {
      (<any>this.$refs.removeUser).hide();
    }
  }

  public get username(): string {
    return this.$store.getters.account ? this.$store.getters.account.login : '';
  }
}
