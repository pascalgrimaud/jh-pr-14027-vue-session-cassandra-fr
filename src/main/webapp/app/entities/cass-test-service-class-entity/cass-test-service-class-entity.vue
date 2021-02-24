<template>
  <div>
    <h2 id="page-heading" data-cy="CassTestServiceClassEntityHeading">
      <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.home.title')" id="cass-test-service-class-entity-heading"
        >Cass Test Service Class Entities</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link
          :to="{ name: 'CassTestServiceClassEntityCreate' }"
          tag="button"
          id="jh-create-entity"
          data-cy="entityCreateButton"
          class="btn btn-primary jh-create-entity create-cass-test-service-class-entity"
        >
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.home.createLabel')"> Create a new Cass Test Service Class Entity </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cassTestServiceClassEntities && cassTestServiceClassEntities.length === 0">
      <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.home.notFound')">No cassTestServiceClassEntities found</span>
    </div>
    <div class="table-responsive" v-if="cassTestServiceClassEntities && cassTestServiceClassEntities.length > 0">
      <table class="table table-striped" aria-describedby="cassTestServiceClassEntities">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringField')">String Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringRequiredField')">String Required Field</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringMinlengthField')">String Minlength Field</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringMaxlengthField')">String Maxlength Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringPatternField')">String Pattern Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerField')">Integer Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerRequiredField')">Integer Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerMinField')">Integer Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerMaxField')">Integer Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.longField')">Long Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.longRequiredField')">Long Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.longMinField')">Long Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.longMaxField')">Long Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatField')">Float Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatRequiredField')">Float Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatMinField')">Float Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatMaxField')">Float Max Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.doubleRequiredField')">Double Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.doubleMinField')">Double Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.doubleMaxField')">Double Max Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.bigDecimalRequiredField')">Big Decimal Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.bigDecimalMinField')">Big Decimal Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.bigDecimalMaxField')">Big Decimal Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.localDateField')">Local Date Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.localDateRequiredField')">Local Date Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.instantDateField')">Instant Date Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.instantRequiredField')">Instant Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.zonedDateTimeField')">Zoned Date Time Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.zonedDateTimeRequiredField')">Zoned Date Time Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.durationDateField')">Duration Date Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.durationRequiredField')">Duration Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.booleanField')">Boolean Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.booleanRequiredField')">Boolean Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.enumTom')">Enum Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.enumRequiredTom')">Enum Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.picture')">Picture</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceClassEntity.operationsFile')">Operations File</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cassTestServiceClassEntity in cassTestServiceClassEntities" :key="cassTestServiceClassEntity.id" data-cy="entityTable">
            <td>
              <router-link
                :to="{ name: 'CassTestServiceClassEntityView', params: { cassTestServiceClassEntityId: cassTestServiceClassEntity.id } }"
                >{{ cassTestServiceClassEntity.id }}</router-link
              >
            </td>
            <td>{{ cassTestServiceClassEntity.stringField }}</td>
            <td>{{ cassTestServiceClassEntity.stringRequiredField }}</td>
            <td>{{ cassTestServiceClassEntity.stringMinlengthField }}</td>
            <td>{{ cassTestServiceClassEntity.stringMaxlengthField }}</td>
            <td>{{ cassTestServiceClassEntity.stringPatternField }}</td>
            <td>{{ cassTestServiceClassEntity.integerField }}</td>
            <td>{{ cassTestServiceClassEntity.integerRequiredField }}</td>
            <td>{{ cassTestServiceClassEntity.integerMinField }}</td>
            <td>{{ cassTestServiceClassEntity.integerMaxField }}</td>
            <td>{{ cassTestServiceClassEntity.longField }}</td>
            <td>{{ cassTestServiceClassEntity.longRequiredField }}</td>
            <td>{{ cassTestServiceClassEntity.longMinField }}</td>
            <td>{{ cassTestServiceClassEntity.longMaxField }}</td>
            <td>{{ cassTestServiceClassEntity.floatField }}</td>
            <td>{{ cassTestServiceClassEntity.floatRequiredField }}</td>
            <td>{{ cassTestServiceClassEntity.floatMinField }}</td>
            <td>{{ cassTestServiceClassEntity.floatMaxField }}</td>
            <td>{{ cassTestServiceClassEntity.doubleRequiredField }}</td>
            <td>{{ cassTestServiceClassEntity.doubleMinField }}</td>
            <td>{{ cassTestServiceClassEntity.doubleMaxField }}</td>
            <td>{{ cassTestServiceClassEntity.bigDecimalRequiredField }}</td>
            <td>{{ cassTestServiceClassEntity.bigDecimalMinField }}</td>
            <td>{{ cassTestServiceClassEntity.bigDecimalMaxField }}</td>
            <td>{{ cassTestServiceClassEntity.localDateField }}</td>
            <td>{{ cassTestServiceClassEntity.localDateRequiredField }}</td>
            <td>
              {{ cassTestServiceClassEntity.instantDateField ? $d(Date.parse(cassTestServiceClassEntity.instantDateField), 'short') : '' }}
            </td>
            <td>
              {{
                cassTestServiceClassEntity.instantRequiredField
                  ? $d(Date.parse(cassTestServiceClassEntity.instantRequiredField), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                cassTestServiceClassEntity.zonedDateTimeField ? $d(Date.parse(cassTestServiceClassEntity.zonedDateTimeField), 'short') : ''
              }}
            </td>
            <td>
              {{
                cassTestServiceClassEntity.zonedDateTimeRequiredField
                  ? $d(Date.parse(cassTestServiceClassEntity.zonedDateTimeRequiredField), 'short')
                  : ''
              }}
            </td>
            <td>{{ cassTestServiceClassEntity.durationDateField | duration }}</td>
            <td>{{ cassTestServiceClassEntity.durationRequiredField | duration }}</td>
            <td>{{ cassTestServiceClassEntity.booleanField }}</td>
            <td>{{ cassTestServiceClassEntity.booleanRequiredField }}</td>
            <td v-text="$t('jhipsterApp.EnumFieldClass.' + cassTestServiceClassEntity.enumTom)">
              {{ cassTestServiceClassEntity.enumTom }}
            </td>
            <td v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + cassTestServiceClassEntity.enumRequiredTom)">
              {{ cassTestServiceClassEntity.enumRequiredTom }}
            </td>
            <td>
              <a
                v-if="cassTestServiceClassEntity.picture"
                v-on:click="openFile(cassTestServiceClassEntity.pictureContentType, cassTestServiceClassEntity.picture)"
              >
                <img
                  v-bind:src="'data:' + cassTestServiceClassEntity.pictureContentType + ';base64,' + cassTestServiceClassEntity.picture"
                  style="max-height: 30px"
                  alt="cassTestServiceClassEntity image"
                />
              </a>
              <span v-if="cassTestServiceClassEntity.picture"
                >{{ cassTestServiceClassEntity.pictureContentType }}, {{ byteSize(cassTestServiceClassEntity.picture) }}</span
              >
            </td>
            <td>{{ cassTestServiceClassEntity.operationsFile }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'CassTestServiceClassEntityView', params: { cassTestServiceClassEntityId: cassTestServiceClassEntity.id } }"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
                <router-link
                  :to="{ name: 'CassTestServiceClassEntityEdit', params: { cassTestServiceClassEntityId: cassTestServiceClassEntity.id } }"
                  tag="button"
                  class="btn btn-primary btn-sm edit"
                  data-cy="entityEditButton"
                >
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cassTestServiceClassEntity)"
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
          id="jhipsterApp.cassTestServiceClassEntity.delete.question"
          data-cy="cassTestServiceClassEntityDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-cassTestServiceClassEntity-heading"
          v-text="$t('jhipsterApp.cassTestServiceClassEntity.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Cass Test Service Class Entity?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-cassTestServiceClassEntity"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCassTestServiceClassEntity()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./cass-test-service-class-entity.component.ts"></script>
