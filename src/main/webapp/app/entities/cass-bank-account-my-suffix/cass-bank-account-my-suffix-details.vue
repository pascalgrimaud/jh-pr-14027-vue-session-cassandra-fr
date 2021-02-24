<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cassBankAccount">
        <h2 class="jh-entity-heading" data-cy="cassBankAccountDetailsHeading">
          <span v-text="$t('jhipsterApp.cassBankAccount.detail.title')">CassBankAccountMySuffix</span> {{ cassBankAccount.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.userId')">User Id</span>
          </dt>
          <dd>
            <span>{{ cassBankAccount.userId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.name')">Name</span>
          </dt>
          <dd>
            <span>{{ cassBankAccount.name }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.bankNumber')">Bank Number</span>
          </dt>
          <dd>
            <span>{{ cassBankAccount.bankNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.agencyNumber')">Agency Number</span>
          </dt>
          <dd>
            <span>{{ cassBankAccount.agencyNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.lastOperationDuration')">Last Operation Duration</span>
          </dt>
          <dd>
            <span>{{ cassBankAccount.lastOperationDuration }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.meanOperationDuration')">Mean Operation Duration</span>
          </dt>
          <dd>
            <span>{{ cassBankAccount.meanOperationDuration }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.balance')">Balance</span>
          </dt>
          <dd>
            <span>{{ cassBankAccount.balance }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.lastOperationDate')">Last Operation Date</span>
          </dt>
          <dd>
            <span v-if="cassBankAccount.lastOperationDate">{{ $d(Date.parse(cassBankAccount.lastOperationDate), 'long') }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.active')">Active</span>
          </dt>
          <dd>
            <span>{{ cassBankAccount.active }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.picture')">Picture</span>
          </dt>
          <dd>
            <div v-if="cassBankAccount.picture">
              <a v-on:click="openFile(cassBankAccount.pictureContentType, cassBankAccount.picture)">
                <img
                  v-bind:src="'data:' + cassBankAccount.pictureContentType + ';base64,' + cassBankAccount.picture"
                  style="max-width: 100%"
                  alt="cassBankAccount image"
                />
              </a>
              {{ cassBankAccount.pictureContentType }}, {{ byteSize(cassBankAccount.picture) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.operationsFile')">Operations File</span>
          </dt>
          <dd>
            <span>{{ cassBankAccount.operationsFile }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassBankAccount.accountType')">Account Type</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.AccountTypeEnum.' + cassBankAccount.accountType)">{{ cassBankAccount.accountType }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="cassBankAccount.id"
          :to="{ name: 'CassBankAccountMySuffixEdit', params: { cassBankAccountId: cassBankAccount.id } }"
          tag="button"
          class="btn btn-primary"
        >
          <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cass-bank-account-my-suffix-details.component.ts"></script>
