<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.cassBankAccount.home.createOrEditLabel"
          data-cy="CassBankAccountCreateUpdateHeading"
          v-text="$t('jhipsterApp.cassBankAccount.home.createOrEditLabel')"
        >
          Create or edit a CassBankAccountMySuffix
        </h2>
        <div>
          <div class="form-group" v-if="cassBankAccount.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cassBankAccount.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassBankAccount.userId')" for="cass-bank-account-my-suffix-userId"
              >User Id</label
            >
            <input
              type="text"
              class="form-control"
              name="userId"
              id="cass-bank-account-my-suffix-userId"
              data-cy="userId"
              :class="{ valid: !$v.cassBankAccount.userId.$invalid, invalid: $v.cassBankAccount.userId.$invalid }"
              v-model="$v.cassBankAccount.userId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassBankAccount.name')" for="cass-bank-account-my-suffix-name"
              >Name</label
            >
            <input
              type="text"
              class="form-control"
              name="name"
              id="cass-bank-account-my-suffix-name"
              data-cy="name"
              :class="{ valid: !$v.cassBankAccount.name.$invalid, invalid: $v.cassBankAccount.name.$invalid }"
              v-model="$v.cassBankAccount.name.$model"
              required
            />
            <div v-if="$v.cassBankAccount.name.$anyDirty && $v.cassBankAccount.name.$invalid">
              <small class="form-text text-danger" v-if="!$v.cassBankAccount.name.required" v-text="$t('entity.validation.required')">
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassBankAccount.bankNumber')"
              for="cass-bank-account-my-suffix-bankNumber"
              >Bank Number</label
            >
            <input
              type="number"
              class="form-control"
              name="bankNumber"
              id="cass-bank-account-my-suffix-bankNumber"
              data-cy="bankNumber"
              :class="{ valid: !$v.cassBankAccount.bankNumber.$invalid, invalid: $v.cassBankAccount.bankNumber.$invalid }"
              v-model.number="$v.cassBankAccount.bankNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassBankAccount.agencyNumber')"
              for="cass-bank-account-my-suffix-agencyNumber"
              >Agency Number</label
            >
            <input
              type="number"
              class="form-control"
              name="agencyNumber"
              id="cass-bank-account-my-suffix-agencyNumber"
              data-cy="agencyNumber"
              :class="{ valid: !$v.cassBankAccount.agencyNumber.$invalid, invalid: $v.cassBankAccount.agencyNumber.$invalid }"
              v-model.number="$v.cassBankAccount.agencyNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassBankAccount.lastOperationDuration')"
              for="cass-bank-account-my-suffix-lastOperationDuration"
              >Last Operation Duration</label
            >
            <input
              type="number"
              class="form-control"
              name="lastOperationDuration"
              id="cass-bank-account-my-suffix-lastOperationDuration"
              data-cy="lastOperationDuration"
              :class="{
                valid: !$v.cassBankAccount.lastOperationDuration.$invalid,
                invalid: $v.cassBankAccount.lastOperationDuration.$invalid,
              }"
              v-model.number="$v.cassBankAccount.lastOperationDuration.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassBankAccount.meanOperationDuration')"
              for="cass-bank-account-my-suffix-meanOperationDuration"
              >Mean Operation Duration</label
            >
            <input
              type="number"
              class="form-control"
              name="meanOperationDuration"
              id="cass-bank-account-my-suffix-meanOperationDuration"
              data-cy="meanOperationDuration"
              :class="{
                valid: !$v.cassBankAccount.meanOperationDuration.$invalid,
                invalid: $v.cassBankAccount.meanOperationDuration.$invalid,
              }"
              v-model.number="$v.cassBankAccount.meanOperationDuration.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassBankAccount.balance')" for="cass-bank-account-my-suffix-balance"
              >Balance</label
            >
            <input
              type="number"
              class="form-control"
              name="balance"
              id="cass-bank-account-my-suffix-balance"
              data-cy="balance"
              :class="{ valid: !$v.cassBankAccount.balance.$invalid, invalid: $v.cassBankAccount.balance.$invalid }"
              v-model.number="$v.cassBankAccount.balance.$model"
              required
            />
            <div v-if="$v.cassBankAccount.balance.$anyDirty && $v.cassBankAccount.balance.$invalid">
              <small class="form-text text-danger" v-if="!$v.cassBankAccount.balance.required" v-text="$t('entity.validation.required')">
                This field is required.
              </small>
              <small class="form-text text-danger" v-if="!$v.cassBankAccount.balance.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassBankAccount.lastOperationDate')"
              for="cass-bank-account-my-suffix-lastOperationDate"
              >Last Operation Date</label
            >
            <div class="d-flex">
              <input
                id="cass-bank-account-my-suffix-lastOperationDate"
                data-cy="lastOperationDate"
                type="datetime-local"
                class="form-control"
                name="lastOperationDate"
                :class="{ valid: !$v.cassBankAccount.lastOperationDate.$invalid, invalid: $v.cassBankAccount.lastOperationDate.$invalid }"
                :value="convertDateTimeFromServer($v.cassBankAccount.lastOperationDate.$model)"
                @change="updateInstantField('lastOperationDate', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassBankAccount.active')" for="cass-bank-account-my-suffix-active"
              >Active</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="active"
              id="cass-bank-account-my-suffix-active"
              data-cy="active"
              :class="{ valid: !$v.cassBankAccount.active.$invalid, invalid: $v.cassBankAccount.active.$invalid }"
              v-model="$v.cassBankAccount.active.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassBankAccount.picture')" for="cass-bank-account-my-suffix-picture"
              >Picture</label
            >
            <div>
              <img
                v-bind:src="'data:' + cassBankAccount.pictureContentType + ';base64,' + cassBankAccount.picture"
                style="max-height: 100px"
                v-if="cassBankAccount.picture"
                alt="cassBankAccount image"
              />
              <div v-if="cassBankAccount.picture" class="form-text text-danger clearfix">
                <span class="pull-left">{{ cassBankAccount.pictureContentType }}, {{ byteSize(cassBankAccount.picture) }}</span>
                <button
                  type="button"
                  v-on:click="clearInputImage('picture', 'pictureContentType', 'file_picture')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_picture"
                id="file_picture"
                data-cy="picture"
                v-on:change="setFileData($event, cassBankAccount, 'picture', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="picture"
              id="cass-bank-account-my-suffix-picture"
              data-cy="picture"
              :class="{ valid: !$v.cassBankAccount.picture.$invalid, invalid: $v.cassBankAccount.picture.$invalid }"
              v-model="$v.cassBankAccount.picture.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="pictureContentType"
              id="cass-bank-account-my-suffix-pictureContentType"
              v-model="cassBankAccount.pictureContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassBankAccount.operationsFile')"
              for="cass-bank-account-my-suffix-operationsFile"
              >Operations File</label
            >
            <div>
              <div v-if="cassBankAccount.operationsFile" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ cassBankAccount.operationsFileContentType }}, {{ byteSize(cassBankAccount.operationsFile) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    cassBankAccount.operationsFile = null;
                    cassBankAccount.operationsFileContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_operationsFile"
                id="file_operationsFile"
                data-cy="operationsFile"
                v-on:change="setFileData($event, cassBankAccount, 'operationsFile', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="operationsFile"
              id="cass-bank-account-my-suffix-operationsFile"
              data-cy="operationsFile"
              :class="{ valid: !$v.cassBankAccount.operationsFile.$invalid, invalid: $v.cassBankAccount.operationsFile.$invalid }"
              v-model="$v.cassBankAccount.operationsFile.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="operationsFileContentType"
              id="cass-bank-account-my-suffix-operationsFileContentType"
              v-model="cassBankAccount.operationsFileContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassBankAccount.accountType')"
              for="cass-bank-account-my-suffix-accountType"
              >Account Type</label
            >
            <select
              class="form-control"
              name="accountType"
              :class="{ valid: !$v.cassBankAccount.accountType.$invalid, invalid: $v.cassBankAccount.accountType.$invalid }"
              v-model="$v.cassBankAccount.accountType.$model"
              id="cass-bank-account-my-suffix-accountType"
              data-cy="accountType"
            >
              <option value="STANDARD" v-bind:label="$t('jhipsterApp.AccountTypeEnum.STANDARD')">STANDARD</option>
              <option value="PREMIUM" v-bind:label="$t('jhipsterApp.AccountTypeEnum.PREMIUM')">PREMIUM</option>
            </select>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.cassBankAccount.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cass-bank-account-my-suffix-update.component.ts"></script>
