<template>
  <div>
    <h2 id="page-heading" data-cy="CassTestServiceImplEntityHeading">
      <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.home.title')" id="cass-test-service-impl-entity-heading"
        >Cass Test Service Impl Entities</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link
          :to="{ name: 'CassTestServiceImplEntityCreate' }"
          tag="button"
          id="jh-create-entity"
          data-cy="entityCreateButton"
          class="btn btn-primary jh-create-entity create-cass-test-service-impl-entity"
        >
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.home.createLabel')"> Create a new Cass Test Service Impl Entity </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cassTestServiceImplEntities && cassTestServiceImplEntities.length === 0">
      <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.home.notFound')">No cassTestServiceImplEntities found</span>
    </div>
    <div class="table-responsive" v-if="cassTestServiceImplEntities && cassTestServiceImplEntities.length > 0">
      <table class="table table-striped" aria-describedby="cassTestServiceImplEntities">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringField')">String Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringRequiredField')">String Required Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringMinlengthField')">String Minlength Field</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringMaxlengthField')">String Maxlength Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringPatternField')">String Pattern Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerField')">Integer Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerRequiredField')">Integer Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerMinField')">Integer Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerMaxField')">Integer Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.longField')">Long Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.longRequiredField')">Long Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.longMinField')">Long Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.longMaxField')">Long Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatField')">Float Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatRequiredField')">Float Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatMinField')">Float Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatMaxField')">Float Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.doubleRequiredField')">Double Required Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.doubleMinField')">Double Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.doubleMaxField')">Double Max Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.bigDecimalRequiredField')">Big Decimal Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.bigDecimalMinField')">Big Decimal Min Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.bigDecimalMaxField')">Big Decimal Max Field</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.localDateField')">Local Date Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.localDateRequiredField')">Local Date Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.instantDateField')">Instant Date Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.instantRequiredField')">Instant Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.zonedDateTimeField')">Zoned Date Time Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.zonedDateTimeRequiredField')">Zoned Date Time Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.durationDateField')">Duration Date Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.durationRequiredField')">Duration Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.booleanField')">Boolean Field</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.booleanRequiredField')">Boolean Required Field</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.enumTom')">Enum Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.enumRequiredTom')">Enum Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.picture')">Picture</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.cassTestServiceImplEntity.operationsFile')">Operations File</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="cassTestServiceImplEntity in cassTestServiceImplEntities" :key="cassTestServiceImplEntity.id" data-cy="entityTable">
            <td>
              <router-link
                :to="{ name: 'CassTestServiceImplEntityView', params: { cassTestServiceImplEntityId: cassTestServiceImplEntity.id } }"
                >{{ cassTestServiceImplEntity.id }}</router-link
              >
            </td>
            <td>{{ cassTestServiceImplEntity.stringField }}</td>
            <td>{{ cassTestServiceImplEntity.stringRequiredField }}</td>
            <td>{{ cassTestServiceImplEntity.stringMinlengthField }}</td>
            <td>{{ cassTestServiceImplEntity.stringMaxlengthField }}</td>
            <td>{{ cassTestServiceImplEntity.stringPatternField }}</td>
            <td>{{ cassTestServiceImplEntity.integerField }}</td>
            <td>{{ cassTestServiceImplEntity.integerRequiredField }}</td>
            <td>{{ cassTestServiceImplEntity.integerMinField }}</td>
            <td>{{ cassTestServiceImplEntity.integerMaxField }}</td>
            <td>{{ cassTestServiceImplEntity.longField }}</td>
            <td>{{ cassTestServiceImplEntity.longRequiredField }}</td>
            <td>{{ cassTestServiceImplEntity.longMinField }}</td>
            <td>{{ cassTestServiceImplEntity.longMaxField }}</td>
            <td>{{ cassTestServiceImplEntity.floatField }}</td>
            <td>{{ cassTestServiceImplEntity.floatRequiredField }}</td>
            <td>{{ cassTestServiceImplEntity.floatMinField }}</td>
            <td>{{ cassTestServiceImplEntity.floatMaxField }}</td>
            <td>{{ cassTestServiceImplEntity.doubleRequiredField }}</td>
            <td>{{ cassTestServiceImplEntity.doubleMinField }}</td>
            <td>{{ cassTestServiceImplEntity.doubleMaxField }}</td>
            <td>{{ cassTestServiceImplEntity.bigDecimalRequiredField }}</td>
            <td>{{ cassTestServiceImplEntity.bigDecimalMinField }}</td>
            <td>{{ cassTestServiceImplEntity.bigDecimalMaxField }}</td>
            <td>{{ cassTestServiceImplEntity.localDateField }}</td>
            <td>{{ cassTestServiceImplEntity.localDateRequiredField }}</td>
            <td>
              {{ cassTestServiceImplEntity.instantDateField ? $d(Date.parse(cassTestServiceImplEntity.instantDateField), 'short') : '' }}
            </td>
            <td>
              {{
                cassTestServiceImplEntity.instantRequiredField
                  ? $d(Date.parse(cassTestServiceImplEntity.instantRequiredField), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                cassTestServiceImplEntity.zonedDateTimeField ? $d(Date.parse(cassTestServiceImplEntity.zonedDateTimeField), 'short') : ''
              }}
            </td>
            <td>
              {{
                cassTestServiceImplEntity.zonedDateTimeRequiredField
                  ? $d(Date.parse(cassTestServiceImplEntity.zonedDateTimeRequiredField), 'short')
                  : ''
              }}
            </td>
            <td>{{ cassTestServiceImplEntity.durationDateField | duration }}</td>
            <td>{{ cassTestServiceImplEntity.durationRequiredField | duration }}</td>
            <td>{{ cassTestServiceImplEntity.booleanField }}</td>
            <td>{{ cassTestServiceImplEntity.booleanRequiredField }}</td>
            <td v-text="$t('jhipsterApp.EnumFieldClass.' + cassTestServiceImplEntity.enumTom)">{{ cassTestServiceImplEntity.enumTom }}</td>
            <td v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + cassTestServiceImplEntity.enumRequiredTom)">
              {{ cassTestServiceImplEntity.enumRequiredTom }}
            </td>
            <td>
              <a
                v-if="cassTestServiceImplEntity.picture"
                v-on:click="openFile(cassTestServiceImplEntity.pictureContentType, cassTestServiceImplEntity.picture)"
              >
                <img
                  v-bind:src="'data:' + cassTestServiceImplEntity.pictureContentType + ';base64,' + cassTestServiceImplEntity.picture"
                  style="max-height: 30px"
                  alt="cassTestServiceImplEntity image"
                />
              </a>
              <span v-if="cassTestServiceImplEntity.picture"
                >{{ cassTestServiceImplEntity.pictureContentType }}, {{ byteSize(cassTestServiceImplEntity.picture) }}</span
              >
            </td>
            <td>{{ cassTestServiceImplEntity.operationsFile }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'CassTestServiceImplEntityView', params: { cassTestServiceImplEntityId: cassTestServiceImplEntity.id } }"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
                <router-link
                  :to="{ name: 'CassTestServiceImplEntityEdit', params: { cassTestServiceImplEntityId: cassTestServiceImplEntity.id } }"
                  tag="button"
                  class="btn btn-primary btn-sm edit"
                  data-cy="entityEditButton"
                >
                  <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(cassTestServiceImplEntity)"
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
          id="jhipsterApp.cassTestServiceImplEntity.delete.question"
          data-cy="cassTestServiceImplEntityDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-cassTestServiceImplEntity-heading"
          v-text="$t('jhipsterApp.cassTestServiceImplEntity.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Cass Test Service Impl Entity?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-cassTestServiceImplEntity"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCassTestServiceImplEntity()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./cass-test-service-impl-entity.component.ts"></script>
