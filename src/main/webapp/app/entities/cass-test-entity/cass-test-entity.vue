<template>
  <div>
    <h2 id="page-heading" data-cy="CassTestEntityHeading">
      <span v-text="$t('jhipsterApp.cassTestEntity.home.title')" id="cass-test-entity-heading">Cass Test Entities</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.cassTestEntity.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link
          :to="{ name: 'CassTestEntityCreate' }"
          tag="button"
          id="jh-create-entity"
          data-cy="entityCreateButton"
          class="btn btn-primary jh-create-entity create-cass-test-entity"
        >
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.cassTestEntity.home.createLabel')"> Create a new Cass Test Entity </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cassTestEntities && cassTestEntities.length === 0">
      <span v-text="$t('jhipsterApp.cassTestEntity.home.notFound')">No cassTestEntities found</span>
    </div>
    <div class="table-responsive" v-if="cassTestEntities && cassTestEntities.length > 0">
      <table class="table table-striped" aria-describedby="cassTestEntities">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.stringField')">String Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.stringRequiredField')">String Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.stringMinlengthField')">String Minlength Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.stringMaxlengthField')">String Maxlength Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.stringPatternField')">String Pattern Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.integerField')">Integer Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.integerRequiredField')">Integer Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.integerMinField')">Integer Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.integerMaxField')">Integer Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.longField')">Long Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.longRequiredField')">Long Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.longMinField')">Long Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.longMaxField')">Long Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.floatField')">Float Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.floatRequiredField')">Float Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.floatMinField')">Float Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.floatMaxField')">Float Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.doubleRequiredField')">Double Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.doubleMinField')">Double Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.doubleMaxField')">Double Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.bigDecimalRequiredField')">Big Decimal Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.bigDecimalMinField')">Big Decimal Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.bigDecimalMaxField')">Big Decimal Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.localDateField')">Local Date Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.localDateRequiredField')">Local Date Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.instantDateField')">Instant Date Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.instantRequiredField')">Instant Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.zonedDateTimeField')">Zoned Date Time Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestEntity.zonedDateTimeRequiredField')">Zoned Date Time Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.durationDateField')">Duration Date Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.durationRequiredField')">Duration Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.booleanField')">Boolean Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.booleanRequiredField')">Boolean Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.enumTom')">Enum Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.enumRequiredTom')">Enum Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.picture')">Picture</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestEntity.operationsFile')">Operations File</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cassTestEntity in cassTestEntities" :key="cassTestEntity.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CassTestEntityView', params: { cassTestEntityId: cassTestEntity.id } }">{{
                cassTestEntity.id
              }}</router-link>
            </td>
            <td>{{ cassTestEntity.stringField }}</td>
            <td>{{ cassTestEntity.stringRequiredField }}</td>
            <td>{{ cassTestEntity.stringMinlengthField }}</td>
            <td>{{ cassTestEntity.stringMaxlengthField }}</td>
            <td>{{ cassTestEntity.stringPatternField }}</td>
            <td>{{ cassTestEntity.integerField }}</td>
            <td>{{ cassTestEntity.integerRequiredField }}</td>
            <td>{{ cassTestEntity.integerMinField }}</td>
            <td>{{ cassTestEntity.integerMaxField }}</td>
            <td>{{ cassTestEntity.longField }}</td>
            <td>{{ cassTestEntity.longRequiredField }}</td>
            <td>{{ cassTestEntity.longMinField }}</td>
            <td>{{ cassTestEntity.longMaxField }}</td>
            <td>{{ cassTestEntity.floatField }}</td>
            <td>{{ cassTestEntity.floatRequiredField }}</td>
            <td>{{ cassTestEntity.floatMinField }}</td>
            <td>{{ cassTestEntity.floatMaxField }}</td>
            <td>{{ cassTestEntity.doubleRequiredField }}</td>
            <td>{{ cassTestEntity.doubleMinField }}</td>
            <td>{{ cassTestEntity.doubleMaxField }}</td>
            <td>{{ cassTestEntity.bigDecimalRequiredField }}</td>
            <td>{{ cassTestEntity.bigDecimalMinField }}</td>
            <td>{{ cassTestEntity.bigDecimalMaxField }}</td>
            <td>{{ cassTestEntity.localDateField }}</td>
            <td>{{ cassTestEntity.localDateRequiredField }}</td>
            <td>{{ cassTestEntity.instantDateField ? $d(Date.parse(cassTestEntity.instantDateField), 'short') : '' }}</td>
            <td>{{ cassTestEntity.instantRequiredField ? $d(Date.parse(cassTestEntity.instantRequiredField), 'short') : '' }}</td>
            <td>{{ cassTestEntity.zonedDateTimeField ? $d(Date.parse(cassTestEntity.zonedDateTimeField), 'short') : '' }}</td>
            <td>
              {{ cassTestEntity.zonedDateTimeRequiredField ? $d(Date.parse(cassTestEntity.zonedDateTimeRequiredField), 'short') : '' }}
            </td>
            <td>{{ cassTestEntity.durationDateField | duration }}</td>
            <td>{{ cassTestEntity.durationRequiredField | duration }}</td>
            <td>{{ cassTestEntity.booleanField }}</td>
            <td>{{ cassTestEntity.booleanRequiredField }}</td>
            <td v-text="$t('jhipsterApp.EnumFieldClass.' + cassTestEntity.enumTom)">{{ cassTestEntity.enumTom }}</td>
            <td v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + cassTestEntity.enumRequiredTom)">
              {{ cassTestEntity.enumRequiredTom }}
            </td>
            <td>
              <a v-if="cassTestEntity.picture" v-on:click="openFile(cassTestEntity.pictureContentType, cassTestEntity.picture)">
                <img
                  v-bind:src="'data:' + cassTestEntity.pictureContentType + ';base64,' + cassTestEntity.picture"
                  style="max-height: 30px"
                  alt="cassTestEntity image"
                />
              </a>
              <span v-if="cassTestEntity.picture">{{ cassTestEntity.pictureContentType }}, {{ byteSize(cassTestEntity.picture) }}</span>
            </td>
            <td>{{ cassTestEntity.operationsFile }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'CassTestEntityView', params: { cassTestEntityId: cassTestEntity.id } }"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
                <router-link
                  :to="{ name: 'CassTestEntityEdit', params: { cassTestEntityId: cassTestEntity.id } }"
                  tag="button"
                  class="btn btn-primary btn-sm edit"
                  data-cy="entityEditButton"
                >
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cassTestEntity)"
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
          id="jhipsterApp.cassTestEntity.delete.question"
          data-cy="cassTestEntityDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="-delete-cassTestEntity-heading" v-text="$t('jhipsterApp.cassTestEntity.delete.question', { id: removeId })">
          Are you sure you want to delete this Cass Test Entity?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-cassTestEntity"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCassTestEntity()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./cass-test-entity.component.ts"></script>
