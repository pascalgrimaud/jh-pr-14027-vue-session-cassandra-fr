<template>
  <div>
    <h2 id="page-heading" data-cy="CassTestMapstructEntityHeading">
      <span v-text="$t('jhipsterApp.cassTestMapstructEntity.home.title')" id="cass-test-mapstruct-entity-heading"
        >Cass Test Mapstruct Entities</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.cassTestMapstructEntity.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link
          :to="{ name: 'CassTestMapstructEntityCreate' }"
          tag="button"
          id="jh-create-entity"
          data-cy="entityCreateButton"
          class="btn btn-primary jh-create-entity create-cass-test-mapstruct-entity"
        >
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.cassTestMapstructEntity.home.createLabel')"> Create a new Cass Test Mapstruct Entity </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cassTestMapstructEntities && cassTestMapstructEntities.length === 0">
      <span v-text="$t('jhipsterApp.cassTestMapstructEntity.home.notFound')">No cassTestMapstructEntities found</span>
    </div>
    <div class="table-responsive" v-if="cassTestMapstructEntities && cassTestMapstructEntities.length > 0">
      <table class="table table-striped" aria-describedby="cassTestMapstructEntities">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.stringField')">String Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.stringRequiredField')">String Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.stringMinlengthField')">String Minlength Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.stringMaxlengthField')">String Maxlength Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.stringPatternField')">String Pattern Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.integerField')">Integer Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.integerRequiredField')">Integer Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.integerMinField')">Integer Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.integerMaxField')">Integer Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.longField')">Long Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.longRequiredField')">Long Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.longMinField')">Long Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.longMaxField')">Long Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.floatField')">Float Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.floatRequiredField')">Float Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.floatMinField')">Float Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.floatMaxField')">Float Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.doubleRequiredField')">Double Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.doubleMinField')">Double Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.doubleMaxField')">Double Max Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestMapstructEntity.bigDecimalRequiredField')">Big Decimal Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.bigDecimalMinField')">Big Decimal Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.bigDecimalMaxField')">Big Decimal Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.localDateField')">Local Date Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestMapstructEntity.localDateRequiredField')">Local Date Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.instantDateField')">Instant Date Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.instantRequiredField')">Instant Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.zonedDateTimeField')">Zoned Date Time Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestMapstructEntity.zonedDateTimeRequiredField')">Zoned Date Time Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.durationDateField')">Duration Date Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestMapstructEntity.durationRequiredField')">Duration Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.booleanField')">Boolean Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.booleanRequiredField')">Boolean Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.enumTom')">Enum Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.enumRequiredTom')">Enum Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.picture')">Picture</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestMapstructEntity.operationsFile')">Operations File</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cassTestMapstructEntity in cassTestMapstructEntities" :key="cassTestMapstructEntity.id" data-cy="entityTable">
            <td>
              <router-link
                :to="{ name: 'CassTestMapstructEntityView', params: { cassTestMapstructEntityId: cassTestMapstructEntity.id } }"
                >{{ cassTestMapstructEntity.id }}</router-link
              >
            </td>
            <td>{{ cassTestMapstructEntity.stringField }}</td>
            <td>{{ cassTestMapstructEntity.stringRequiredField }}</td>
            <td>{{ cassTestMapstructEntity.stringMinlengthField }}</td>
            <td>{{ cassTestMapstructEntity.stringMaxlengthField }}</td>
            <td>{{ cassTestMapstructEntity.stringPatternField }}</td>
            <td>{{ cassTestMapstructEntity.integerField }}</td>
            <td>{{ cassTestMapstructEntity.integerRequiredField }}</td>
            <td>{{ cassTestMapstructEntity.integerMinField }}</td>
            <td>{{ cassTestMapstructEntity.integerMaxField }}</td>
            <td>{{ cassTestMapstructEntity.longField }}</td>
            <td>{{ cassTestMapstructEntity.longRequiredField }}</td>
            <td>{{ cassTestMapstructEntity.longMinField }}</td>
            <td>{{ cassTestMapstructEntity.longMaxField }}</td>
            <td>{{ cassTestMapstructEntity.floatField }}</td>
            <td>{{ cassTestMapstructEntity.floatRequiredField }}</td>
            <td>{{ cassTestMapstructEntity.floatMinField }}</td>
            <td>{{ cassTestMapstructEntity.floatMaxField }}</td>
            <td>{{ cassTestMapstructEntity.doubleRequiredField }}</td>
            <td>{{ cassTestMapstructEntity.doubleMinField }}</td>
            <td>{{ cassTestMapstructEntity.doubleMaxField }}</td>
            <td>{{ cassTestMapstructEntity.bigDecimalRequiredField }}</td>
            <td>{{ cassTestMapstructEntity.bigDecimalMinField }}</td>
            <td>{{ cassTestMapstructEntity.bigDecimalMaxField }}</td>
            <td>{{ cassTestMapstructEntity.localDateField }}</td>
            <td>{{ cassTestMapstructEntity.localDateRequiredField }}</td>
            <td>{{ cassTestMapstructEntity.instantDateField ? $d(Date.parse(cassTestMapstructEntity.instantDateField), 'short') : '' }}</td>
            <td>
              {{
                cassTestMapstructEntity.instantRequiredField ? $d(Date.parse(cassTestMapstructEntity.instantRequiredField), 'short') : ''
              }}
            </td>
            <td>
              {{ cassTestMapstructEntity.zonedDateTimeField ? $d(Date.parse(cassTestMapstructEntity.zonedDateTimeField), 'short') : '' }}
            </td>
            <td>
              {{
                cassTestMapstructEntity.zonedDateTimeRequiredField
                  ? $d(Date.parse(cassTestMapstructEntity.zonedDateTimeRequiredField), 'short')
                  : ''
              }}
            </td>
            <td>{{ cassTestMapstructEntity.durationDateField | duration }}</td>
            <td>{{ cassTestMapstructEntity.durationRequiredField | duration }}</td>
            <td>{{ cassTestMapstructEntity.booleanField }}</td>
            <td>{{ cassTestMapstructEntity.booleanRequiredField }}</td>
            <td v-text="$t('jhipsterApp.EnumFieldClass.' + cassTestMapstructEntity.enumTom)">{{ cassTestMapstructEntity.enumTom }}</td>
            <td v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + cassTestMapstructEntity.enumRequiredTom)">
              {{ cassTestMapstructEntity.enumRequiredTom }}
            </td>
            <td>
              <a
                v-if="cassTestMapstructEntity.picture"
                v-on:click="openFile(cassTestMapstructEntity.pictureContentType, cassTestMapstructEntity.picture)"
              >
                <img
                  v-bind:src="'data:' + cassTestMapstructEntity.pictureContentType + ';base64,' + cassTestMapstructEntity.picture"
                  style="max-height: 30px"
                  alt="cassTestMapstructEntity image"
                />
              </a>
              <span v-if="cassTestMapstructEntity.picture"
                >{{ cassTestMapstructEntity.pictureContentType }}, {{ byteSize(cassTestMapstructEntity.picture) }}</span
              >
            </td>
            <td>{{ cassTestMapstructEntity.operationsFile }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'CassTestMapstructEntityView', params: { cassTestMapstructEntityId: cassTestMapstructEntity.id } }"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
                <router-link
                  :to="{ name: 'CassTestMapstructEntityEdit', params: { cassTestMapstructEntityId: cassTestMapstructEntity.id } }"
                  tag="button"
                  class="btn btn-primary btn-sm edit"
                  data-cy="entityEditButton"
                >
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cassTestMapstructEntity)"
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
          id="jhipsterApp.cassTestMapstructEntity.delete.question"
          data-cy="cassTestMapstructEntityDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-cassTestMapstructEntity-heading"
          v-text="$t('jhipsterApp.cassTestMapstructEntity.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Cass Test Mapstruct Entity?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-cassTestMapstructEntity"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCassTestMapstructEntity()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./cass-test-mapstruct-entity.component.ts"></script>
