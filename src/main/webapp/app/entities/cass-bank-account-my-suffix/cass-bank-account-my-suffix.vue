<template>
  <div>
    <h2 id="page-heading" data-cy="CassBankAccountHeading">
      <span v-text="$t('jhipsterApp.cassBankAccount.home.title')" id="cass-bank-account-my-suffix-heading">Cass Bank Accounts</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.cassBankAccount.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link
          :to="{ name: 'CassBankAccountMySuffixCreate' }"
          tag="button"
          id="jh-create-entity"
          data-cy="entityCreateButton"
          class="btn btn-primary jh-create-entity create-cass-bank-account-my-suffix"
        >
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.cassBankAccount.home.createLabel')"> Create a new Cass Bank Account </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cassBankAccounts && cassBankAccounts.length === 0">
      <span v-text="$t('jhipsterApp.cassBankAccount.home.notFound')">No cassBankAccounts found</span>
    </div>
    <div class="table-responsive" v-if="cassBankAccounts && cassBankAccounts.length > 0">
      <table class="table table-striped" aria-describedby="cassBankAccounts">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.userId')">User Id</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.name')">Name</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.bankNumber')">Bank Number</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.agencyNumber')">Agency Number</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.lastOperationDuration')">Last Operation Duration</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.meanOperationDuration')">Mean Operation Duration</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.balance')">Balance</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.lastOperationDate')">Last Operation Date</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.active')">Active</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.picture')">Picture</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.operationsFile')">Operations File</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassBankAccount.accountType')">Account Type</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cassBankAccount in cassBankAccounts" :key="cassBankAccount.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CassBankAccountMySuffixView', params: { cassBankAccountId: cassBankAccount.id } }">{{
                cassBankAccount.id
              }}</router-link>
            </td>
            <td>{{ cassBankAccount.userId }}</td>
            <td>{{ cassBankAccount.name }}</td>
            <td>{{ cassBankAccount.bankNumber }}</td>
            <td>{{ cassBankAccount.agencyNumber }}</td>
            <td>{{ cassBankAccount.lastOperationDuration }}</td>
            <td>{{ cassBankAccount.meanOperationDuration }}</td>
            <td>{{ cassBankAccount.balance }}</td>
            <td>{{ cassBankAccount.lastOperationDate ? $d(Date.parse(cassBankAccount.lastOperationDate), 'short') : '' }}</td>
            <td>{{ cassBankAccount.active }}</td>
            <td>
              <a v-if="cassBankAccount.picture" v-on:click="openFile(cassBankAccount.pictureContentType, cassBankAccount.picture)">
                <img
                  v-bind:src="'data:' + cassBankAccount.pictureContentType + ';base64,' + cassBankAccount.picture"
                  style="max-height: 30px"
                  alt="cassBankAccount image"
                />
              </a>
              <span v-if="cassBankAccount.picture">{{ cassBankAccount.pictureContentType }}, {{ byteSize(cassBankAccount.picture) }}</span>
            </td>
            <td>{{ cassBankAccount.operationsFile }}</td>
            <td v-text="$t('jhipsterApp.AccountTypeEnum.' + cassBankAccount.accountType)">{{ cassBankAccount.accountType }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'CassBankAccountMySuffixView', params: { cassBankAccountId: cassBankAccount.id } }"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
                <router-link
                  :to="{ name: 'CassBankAccountMySuffixEdit', params: { cassBankAccountId: cassBankAccount.id } }"
                  tag="button"
                  class="btn btn-primary btn-sm edit"
                  data-cy="entityEditButton"
                >
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cassBankAccount)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="jhipsterApp.cassBankAccount.delete.question"
          data-cy="cassBankAccountDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="-delete-cassBankAccount-heading" v-text="$t('jhipsterApp.cassBankAccount.delete.question', { id: removeId })">
          Are you sure you want to delete this Cass Bank Account?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-cassBankAccount"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCassBankAccountMySuffix()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./cass-bank-account-my-suffix.component.ts"></script>
