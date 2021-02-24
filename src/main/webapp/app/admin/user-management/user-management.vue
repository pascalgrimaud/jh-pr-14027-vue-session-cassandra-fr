<template>
  <div>
    <h2>
      <span id="user-management-page-heading" v-text="$t('userManagement.home.title')" data-cy="userManagementPageHeading">Users</span>

      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isLoading">
          <font-awesome-icon icon="sync" :spin="isLoading"></font-awesome-icon>
          <span v-text="$t('userManagement.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link tag="button" class="btn btn-primary jh-create-entity" :to="{ name: 'UserCreate' }">
          <font-awesome-icon icon="plus"></font-awesome-icon> <span v-text="$t('userManagement.home.createLabel')">Create a new User</span>
        </router-link>
      </div>
    </h2>
    <div class="table-responsive" v-if="users">
      <table class="table table-striped" aria-describedby="Users">
        <thead>
          <tr>
            <th scope="col"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="col"><span v-text="$t('userManagement.login')">Login</span></th>
            <th scope="col"><span v-text="$t('userManagement.email')">Email</span></th>
            <th scope="col"></th>
            <th scope="col"><span v-text="$t('userManagement.langKey')">Lang Key</span></th>
            <th scope="col"><span v-text="$t('userManagement.profiles')">Profiles</span></th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody v-if="users">
          <tr v-for="user in users" :key="user.id" :id="user.login">
            <td>
              <router-link tag="a" :to="{ name: 'UserView', params: { userId: user.login } }">{{ user.id }}</router-link>
            </td>
            <td>{{ user.login }}</td>
            <td class="jhi-user-email">{{ user.email }}</td>
            <td>
              <button
                class="btn btn-danger btn-sm deactivated"
                v-on:click="setActive(user, true)"
                v-if="!user.activated"
                v-text="$t('userManagement.deactivated')"
              >
                Deactivated
              </button>
              <button
                class="btn btn-success btn-sm"
                v-on:click="setActive(user, false)"
                v-if="user.activated"
                :disabled="username === user.login"
                v-text="$t('userManagement.activated')"
              >
                Activated
              </button>
            </td>
            <td>{{ user.langKey }}</td>
            <td>
              <div v-for="authority of user.authorities" :key="authority">
                <span class="badge badge-info">{{ authority }}</span>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'UserView', params: { userId: user.login } }" tag="button" class="btn btn-info btn-sm details">
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
                <router-link :to="{ name: 'UserEdit', params: { userId: user.login } }" tag="button" class="btn btn-primary btn-sm edit">
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                </router-link>
                <b-button v-on:click="prepareRemove(user)" variant="danger" class="btn btn-sm delete" :disabled="username === user.login">
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
      <b-modal ref="removeUser" id="removeUser" v-bind:title="$t('entity.delete.title')" @ok="deleteUser()">
        <div class="modal-body">
          <p id="-delete-user-heading" v-text="$t('userManagement.delete.question', { login: removeId })">
            Are you sure you want to delete this user?
          </p>
        </div>
        <div slot="modal-footer">
          <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
          <button
            type="button"
            class="btn btn-primary"
            id="confirm-delete-user"
            v-text="$t('entity.action.delete')"
            v-on:click="deleteUser()"
          >
            Delete
          </button>
        </div>
      </b-modal>
    </div>
  </div>
</template>

<script lang="ts" src="./user-management.component.ts"></script>
