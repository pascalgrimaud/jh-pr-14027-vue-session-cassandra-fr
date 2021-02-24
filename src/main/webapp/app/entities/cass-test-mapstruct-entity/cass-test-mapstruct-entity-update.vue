<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.cassTestMapstructEntity.home.createOrEditLabel"
          data-cy="CassTestMapstructEntityCreateUpdateHeading"
          v-text="$t('jhipsterApp.cassTestMapstructEntity.home.createOrEditLabel')"
        >
          Create or edit a CassTestMapstructEntity
        </h2>
        <div>
          <div class="form-group" v-if="cassTestMapstructEntity.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cassTestMapstructEntity.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.stringField')"
              for="cass-test-mapstruct-entity-stringField"
              >String Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringField"
              id="cass-test-mapstruct-entity-stringField"
              data-cy="stringField"
              :class="{ valid: !$v.cassTestMapstructEntity.stringField.$invalid, invalid: $v.cassTestMapstructEntity.stringField.$invalid }"
              v-model="$v.cassTestMapstructEntity.stringField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.stringRequiredField')"
              for="cass-test-mapstruct-entity-stringRequiredField"
              >String Required Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringRequiredField"
              id="cass-test-mapstruct-entity-stringRequiredField"
              data-cy="stringRequiredField"
              :class="{
                valid: !$v.cassTestMapstructEntity.stringRequiredField.$invalid,
                invalid: $v.cassTestMapstructEntity.stringRequiredField.$invalid,
              }"
              v-model="$v.cassTestMapstructEntity.stringRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestMapstructEntity.stringRequiredField.$anyDirty && $v.cassTestMapstructEntity.stringRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.stringRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.stringMinlengthField')"
              for="cass-test-mapstruct-entity-stringMinlengthField"
              >String Minlength Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMinlengthField"
              id="cass-test-mapstruct-entity-stringMinlengthField"
              data-cy="stringMinlengthField"
              :class="{
                valid: !$v.cassTestMapstructEntity.stringMinlengthField.$invalid,
                invalid: $v.cassTestMapstructEntity.stringMinlengthField.$invalid,
              }"
              v-model="$v.cassTestMapstructEntity.stringMinlengthField.$model"
            />
            <div
              v-if="$v.cassTestMapstructEntity.stringMinlengthField.$anyDirty && $v.cassTestMapstructEntity.stringMinlengthField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.stringMinlengthField.minLength"
                v-text="$t('entity.validation.minlength', { min: 0 })"
              >
                This field is required to be at least 0 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.stringMaxlengthField')"
              for="cass-test-mapstruct-entity-stringMaxlengthField"
              >String Maxlength Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMaxlengthField"
              id="cass-test-mapstruct-entity-stringMaxlengthField"
              data-cy="stringMaxlengthField"
              :class="{
                valid: !$v.cassTestMapstructEntity.stringMaxlengthField.$invalid,
                invalid: $v.cassTestMapstructEntity.stringMaxlengthField.$invalid,
              }"
              v-model="$v.cassTestMapstructEntity.stringMaxlengthField.$model"
            />
            <div
              v-if="$v.cassTestMapstructEntity.stringMaxlengthField.$anyDirty && $v.cassTestMapstructEntity.stringMaxlengthField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.stringMaxlengthField.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.stringPatternField')"
              for="cass-test-mapstruct-entity-stringPatternField"
              >String Pattern Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringPatternField"
              id="cass-test-mapstruct-entity-stringPatternField"
              data-cy="stringPatternField"
              :class="{
                valid: !$v.cassTestMapstructEntity.stringPatternField.$invalid,
                invalid: $v.cassTestMapstructEntity.stringPatternField.$invalid,
              }"
              v-model="$v.cassTestMapstructEntity.stringPatternField.$model"
            />
            <div v-if="$v.cassTestMapstructEntity.stringPatternField.$anyDirty && $v.cassTestMapstructEntity.stringPatternField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.stringPatternField.pattern"
                v-text="$t('entity.validation.pattern', { pattern: 'String Pattern Field' })"
              >
                This field should follow pattern for "String Pattern Field".
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.integerField')"
              for="cass-test-mapstruct-entity-integerField"
              >Integer Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerField"
              id="cass-test-mapstruct-entity-integerField"
              data-cy="integerField"
              :class="{
                valid: !$v.cassTestMapstructEntity.integerField.$invalid,
                invalid: $v.cassTestMapstructEntity.integerField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.integerField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.integerRequiredField')"
              for="cass-test-mapstruct-entity-integerRequiredField"
              >Integer Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerRequiredField"
              id="cass-test-mapstruct-entity-integerRequiredField"
              data-cy="integerRequiredField"
              :class="{
                valid: !$v.cassTestMapstructEntity.integerRequiredField.$invalid,
                invalid: $v.cassTestMapstructEntity.integerRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.integerRequiredField.$model"
              required
            />
            <div
              v-if="$v.cassTestMapstructEntity.integerRequiredField.$anyDirty && $v.cassTestMapstructEntity.integerRequiredField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.integerRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.integerRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.integerMinField')"
              for="cass-test-mapstruct-entity-integerMinField"
              >Integer Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMinField"
              id="cass-test-mapstruct-entity-integerMinField"
              data-cy="integerMinField"
              :class="{
                valid: !$v.cassTestMapstructEntity.integerMinField.$invalid,
                invalid: $v.cassTestMapstructEntity.integerMinField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.integerMinField.$model"
            />
            <div v-if="$v.cassTestMapstructEntity.integerMinField.$anyDirty && $v.cassTestMapstructEntity.integerMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.integerMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.integerMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.integerMaxField')"
              for="cass-test-mapstruct-entity-integerMaxField"
              >Integer Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMaxField"
              id="cass-test-mapstruct-entity-integerMaxField"
              data-cy="integerMaxField"
              :class="{
                valid: !$v.cassTestMapstructEntity.integerMaxField.$invalid,
                invalid: $v.cassTestMapstructEntity.integerMaxField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.integerMaxField.$model"
            />
            <div v-if="$v.cassTestMapstructEntity.integerMaxField.$anyDirty && $v.cassTestMapstructEntity.integerMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.integerMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.integerMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.longField')"
              for="cass-test-mapstruct-entity-longField"
              >Long Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longField"
              id="cass-test-mapstruct-entity-longField"
              data-cy="longField"
              :class="{ valid: !$v.cassTestMapstructEntity.longField.$invalid, invalid: $v.cassTestMapstructEntity.longField.$invalid }"
              v-model.number="$v.cassTestMapstructEntity.longField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.longRequiredField')"
              for="cass-test-mapstruct-entity-longRequiredField"
              >Long Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longRequiredField"
              id="cass-test-mapstruct-entity-longRequiredField"
              data-cy="longRequiredField"
              :class="{
                valid: !$v.cassTestMapstructEntity.longRequiredField.$invalid,
                invalid: $v.cassTestMapstructEntity.longRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.longRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestMapstructEntity.longRequiredField.$anyDirty && $v.cassTestMapstructEntity.longRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.longRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.longRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.longMinField')"
              for="cass-test-mapstruct-entity-longMinField"
              >Long Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longMinField"
              id="cass-test-mapstruct-entity-longMinField"
              data-cy="longMinField"
              :class="{
                valid: !$v.cassTestMapstructEntity.longMinField.$invalid,
                invalid: $v.cassTestMapstructEntity.longMinField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.longMinField.$model"
            />
            <div v-if="$v.cassTestMapstructEntity.longMinField.$anyDirty && $v.cassTestMapstructEntity.longMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.longMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.longMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.longMaxField')"
              for="cass-test-mapstruct-entity-longMaxField"
              >Long Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longMaxField"
              id="cass-test-mapstruct-entity-longMaxField"
              data-cy="longMaxField"
              :class="{
                valid: !$v.cassTestMapstructEntity.longMaxField.$invalid,
                invalid: $v.cassTestMapstructEntity.longMaxField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.longMaxField.$model"
            />
            <div v-if="$v.cassTestMapstructEntity.longMaxField.$anyDirty && $v.cassTestMapstructEntity.longMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.longMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.longMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.floatField')"
              for="cass-test-mapstruct-entity-floatField"
              >Float Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatField"
              id="cass-test-mapstruct-entity-floatField"
              data-cy="floatField"
              :class="{ valid: !$v.cassTestMapstructEntity.floatField.$invalid, invalid: $v.cassTestMapstructEntity.floatField.$invalid }"
              v-model.number="$v.cassTestMapstructEntity.floatField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.floatRequiredField')"
              for="cass-test-mapstruct-entity-floatRequiredField"
              >Float Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatRequiredField"
              id="cass-test-mapstruct-entity-floatRequiredField"
              data-cy="floatRequiredField"
              :class="{
                valid: !$v.cassTestMapstructEntity.floatRequiredField.$invalid,
                invalid: $v.cassTestMapstructEntity.floatRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.floatRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestMapstructEntity.floatRequiredField.$anyDirty && $v.cassTestMapstructEntity.floatRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.floatRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.floatRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.floatMinField')"
              for="cass-test-mapstruct-entity-floatMinField"
              >Float Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMinField"
              id="cass-test-mapstruct-entity-floatMinField"
              data-cy="floatMinField"
              :class="{
                valid: !$v.cassTestMapstructEntity.floatMinField.$invalid,
                invalid: $v.cassTestMapstructEntity.floatMinField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.floatMinField.$model"
            />
            <div v-if="$v.cassTestMapstructEntity.floatMinField.$anyDirty && $v.cassTestMapstructEntity.floatMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.floatMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.floatMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.floatMaxField')"
              for="cass-test-mapstruct-entity-floatMaxField"
              >Float Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMaxField"
              id="cass-test-mapstruct-entity-floatMaxField"
              data-cy="floatMaxField"
              :class="{
                valid: !$v.cassTestMapstructEntity.floatMaxField.$invalid,
                invalid: $v.cassTestMapstructEntity.floatMaxField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.floatMaxField.$model"
            />
            <div v-if="$v.cassTestMapstructEntity.floatMaxField.$anyDirty && $v.cassTestMapstructEntity.floatMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.floatMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.floatMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.doubleRequiredField')"
              for="cass-test-mapstruct-entity-doubleRequiredField"
              >Double Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleRequiredField"
              id="cass-test-mapstruct-entity-doubleRequiredField"
              data-cy="doubleRequiredField"
              :class="{
                valid: !$v.cassTestMapstructEntity.doubleRequiredField.$invalid,
                invalid: $v.cassTestMapstructEntity.doubleRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.doubleRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestMapstructEntity.doubleRequiredField.$anyDirty && $v.cassTestMapstructEntity.doubleRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.doubleRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.doubleRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.doubleMinField')"
              for="cass-test-mapstruct-entity-doubleMinField"
              >Double Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMinField"
              id="cass-test-mapstruct-entity-doubleMinField"
              data-cy="doubleMinField"
              :class="{
                valid: !$v.cassTestMapstructEntity.doubleMinField.$invalid,
                invalid: $v.cassTestMapstructEntity.doubleMinField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.doubleMinField.$model"
            />
            <div v-if="$v.cassTestMapstructEntity.doubleMinField.$anyDirty && $v.cassTestMapstructEntity.doubleMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.doubleMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.doubleMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.doubleMaxField')"
              for="cass-test-mapstruct-entity-doubleMaxField"
              >Double Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMaxField"
              id="cass-test-mapstruct-entity-doubleMaxField"
              data-cy="doubleMaxField"
              :class="{
                valid: !$v.cassTestMapstructEntity.doubleMaxField.$invalid,
                invalid: $v.cassTestMapstructEntity.doubleMaxField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.doubleMaxField.$model"
            />
            <div v-if="$v.cassTestMapstructEntity.doubleMaxField.$anyDirty && $v.cassTestMapstructEntity.doubleMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.doubleMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.doubleMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.bigDecimalRequiredField')"
              for="cass-test-mapstruct-entity-bigDecimalRequiredField"
              >Big Decimal Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalRequiredField"
              id="cass-test-mapstruct-entity-bigDecimalRequiredField"
              data-cy="bigDecimalRequiredField"
              :class="{
                valid: !$v.cassTestMapstructEntity.bigDecimalRequiredField.$invalid,
                invalid: $v.cassTestMapstructEntity.bigDecimalRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.bigDecimalRequiredField.$model"
              required
            />
            <div
              v-if="
                $v.cassTestMapstructEntity.bigDecimalRequiredField.$anyDirty && $v.cassTestMapstructEntity.bigDecimalRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.bigDecimalRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.bigDecimalRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.bigDecimalMinField')"
              for="cass-test-mapstruct-entity-bigDecimalMinField"
              >Big Decimal Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMinField"
              id="cass-test-mapstruct-entity-bigDecimalMinField"
              data-cy="bigDecimalMinField"
              :class="{
                valid: !$v.cassTestMapstructEntity.bigDecimalMinField.$invalid,
                invalid: $v.cassTestMapstructEntity.bigDecimalMinField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.bigDecimalMinField.$model"
            />
            <div v-if="$v.cassTestMapstructEntity.bigDecimalMinField.$anyDirty && $v.cassTestMapstructEntity.bigDecimalMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.bigDecimalMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.bigDecimalMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.bigDecimalMaxField')"
              for="cass-test-mapstruct-entity-bigDecimalMaxField"
              >Big Decimal Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMaxField"
              id="cass-test-mapstruct-entity-bigDecimalMaxField"
              data-cy="bigDecimalMaxField"
              :class="{
                valid: !$v.cassTestMapstructEntity.bigDecimalMaxField.$invalid,
                invalid: $v.cassTestMapstructEntity.bigDecimalMaxField.$invalid,
              }"
              v-model.number="$v.cassTestMapstructEntity.bigDecimalMaxField.$model"
            />
            <div v-if="$v.cassTestMapstructEntity.bigDecimalMaxField.$anyDirty && $v.cassTestMapstructEntity.bigDecimalMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.bigDecimalMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.bigDecimalMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.localDateField')"
              for="cass-test-mapstruct-entity-localDateField"
              >Local Date Field</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cass-test-mapstruct-entity-localDateField"
                  v-model="$v.cassTestMapstructEntity.localDateField.$model"
                  name="localDateField"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="cass-test-mapstruct-entity-localDateField"
                data-cy="localDateField"
                type="text"
                class="form-control"
                name="localDateField"
                :class="{
                  valid: !$v.cassTestMapstructEntity.localDateField.$invalid,
                  invalid: $v.cassTestMapstructEntity.localDateField.$invalid,
                }"
                v-model="$v.cassTestMapstructEntity.localDateField.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.localDateRequiredField')"
              for="cass-test-mapstruct-entity-localDateRequiredField"
              >Local Date Required Field</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cass-test-mapstruct-entity-localDateRequiredField"
                  v-model="$v.cassTestMapstructEntity.localDateRequiredField.$model"
                  name="localDateRequiredField"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="cass-test-mapstruct-entity-localDateRequiredField"
                data-cy="localDateRequiredField"
                type="text"
                class="form-control"
                name="localDateRequiredField"
                :class="{
                  valid: !$v.cassTestMapstructEntity.localDateRequiredField.$invalid,
                  invalid: $v.cassTestMapstructEntity.localDateRequiredField.$invalid,
                }"
                v-model="$v.cassTestMapstructEntity.localDateRequiredField.$model"
                required
              />
            </b-input-group>
            <div
              v-if="
                $v.cassTestMapstructEntity.localDateRequiredField.$anyDirty && $v.cassTestMapstructEntity.localDateRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.localDateRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.instantDateField')"
              for="cass-test-mapstruct-entity-instantDateField"
              >Instant Date Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-mapstruct-entity-instantDateField"
                data-cy="instantDateField"
                type="datetime-local"
                class="form-control"
                name="instantDateField"
                :class="{
                  valid: !$v.cassTestMapstructEntity.instantDateField.$invalid,
                  invalid: $v.cassTestMapstructEntity.instantDateField.$invalid,
                }"
                :value="convertDateTimeFromServer($v.cassTestMapstructEntity.instantDateField.$model)"
                @change="updateInstantField('instantDateField', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.instantRequiredField')"
              for="cass-test-mapstruct-entity-instantRequiredField"
              >Instant Required Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-mapstruct-entity-instantRequiredField"
                data-cy="instantRequiredField"
                type="datetime-local"
                class="form-control"
                name="instantRequiredField"
                :class="{
                  valid: !$v.cassTestMapstructEntity.instantRequiredField.$invalid,
                  invalid: $v.cassTestMapstructEntity.instantRequiredField.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.cassTestMapstructEntity.instantRequiredField.$model)"
                @change="updateInstantField('instantRequiredField', $event)"
              />
            </div>
            <div
              v-if="$v.cassTestMapstructEntity.instantRequiredField.$anyDirty && $v.cassTestMapstructEntity.instantRequiredField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.instantRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.instantRequiredField.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.zonedDateTimeField')"
              for="cass-test-mapstruct-entity-zonedDateTimeField"
              >Zoned Date Time Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-mapstruct-entity-zonedDateTimeField"
                data-cy="zonedDateTimeField"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeField"
                :class="{
                  valid: !$v.cassTestMapstructEntity.zonedDateTimeField.$invalid,
                  invalid: $v.cassTestMapstructEntity.zonedDateTimeField.$invalid,
                }"
                :value="convertDateTimeFromServer($v.cassTestMapstructEntity.zonedDateTimeField.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeField', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.zonedDateTimeRequiredField')"
              for="cass-test-mapstruct-entity-zonedDateTimeRequiredField"
              >Zoned Date Time Required Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-mapstruct-entity-zonedDateTimeRequiredField"
                data-cy="zonedDateTimeRequiredField"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeRequiredField"
                :class="{
                  valid: !$v.cassTestMapstructEntity.zonedDateTimeRequiredField.$invalid,
                  invalid: $v.cassTestMapstructEntity.zonedDateTimeRequiredField.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.cassTestMapstructEntity.zonedDateTimeRequiredField.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeRequiredField', $event)"
              />
            </div>
            <div
              v-if="
                $v.cassTestMapstructEntity.zonedDateTimeRequiredField.$anyDirty &&
                $v.cassTestMapstructEntity.zonedDateTimeRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.zonedDateTimeRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.zonedDateTimeRequiredField.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.durationDateField')"
              for="cass-test-mapstruct-entity-durationDateField"
              >Duration Date Field</label
            >
            <input
              type="text"
              class="form-control"
              name="durationDateField"
              id="cass-test-mapstruct-entity-durationDateField"
              data-cy="durationDateField"
              :class="{
                valid: !$v.cassTestMapstructEntity.durationDateField.$invalid,
                invalid: $v.cassTestMapstructEntity.durationDateField.$invalid,
              }"
              v-model="$v.cassTestMapstructEntity.durationDateField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.durationRequiredField')"
              for="cass-test-mapstruct-entity-durationRequiredField"
              >Duration Required Field</label
            >
            <input
              type="text"
              class="form-control"
              name="durationRequiredField"
              id="cass-test-mapstruct-entity-durationRequiredField"
              data-cy="durationRequiredField"
              :class="{
                valid: !$v.cassTestMapstructEntity.durationRequiredField.$invalid,
                invalid: $v.cassTestMapstructEntity.durationRequiredField.$invalid,
              }"
              v-model="$v.cassTestMapstructEntity.durationRequiredField.$model"
              required
            />
            <div
              v-if="$v.cassTestMapstructEntity.durationRequiredField.$anyDirty && $v.cassTestMapstructEntity.durationRequiredField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.durationRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.durationRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.booleanField')"
              for="cass-test-mapstruct-entity-booleanField"
              >Boolean Field</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanField"
              id="cass-test-mapstruct-entity-booleanField"
              data-cy="booleanField"
              :class="{
                valid: !$v.cassTestMapstructEntity.booleanField.$invalid,
                invalid: $v.cassTestMapstructEntity.booleanField.$invalid,
              }"
              v-model="$v.cassTestMapstructEntity.booleanField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.booleanRequiredField')"
              for="cass-test-mapstruct-entity-booleanRequiredField"
              >Boolean Required Field</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanRequiredField"
              id="cass-test-mapstruct-entity-booleanRequiredField"
              data-cy="booleanRequiredField"
              :class="{
                valid: !$v.cassTestMapstructEntity.booleanRequiredField.$invalid,
                invalid: $v.cassTestMapstructEntity.booleanRequiredField.$invalid,
              }"
              v-model="$v.cassTestMapstructEntity.booleanRequiredField.$model"
              required
            />
            <div
              v-if="$v.cassTestMapstructEntity.booleanRequiredField.$anyDirty && $v.cassTestMapstructEntity.booleanRequiredField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.booleanRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.enumTom')"
              for="cass-test-mapstruct-entity-enumTom"
              >Enum Tom</label
            >
            <select
              class="form-control"
              name="enumTom"
              :class="{ valid: !$v.cassTestMapstructEntity.enumTom.$invalid, invalid: $v.cassTestMapstructEntity.enumTom.$invalid }"
              v-model="$v.cassTestMapstructEntity.enumTom.$model"
              id="cass-test-mapstruct-entity-enumTom"
              data-cy="enumTom"
            >
              <option value="ENUM_VALUE_1" v-bind:label="$t('jhipsterApp.EnumFieldClass.ENUM_VALUE_1')">ENUM_VALUE_1</option>
              <option value="ENUM_VALUE_2" v-bind:label="$t('jhipsterApp.EnumFieldClass.ENUM_VALUE_2')">ENUM_VALUE_2</option>
              <option value="ENUM_VALUE_3" v-bind:label="$t('jhipsterApp.EnumFieldClass.ENUM_VALUE_3')">ENUM_VALUE_3</option>
            </select>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.enumRequiredTom')"
              for="cass-test-mapstruct-entity-enumRequiredTom"
              >Enum Required Tom</label
            >
            <select
              class="form-control"
              name="enumRequiredTom"
              :class="{
                valid: !$v.cassTestMapstructEntity.enumRequiredTom.$invalid,
                invalid: $v.cassTestMapstructEntity.enumRequiredTom.$invalid,
              }"
              v-model="$v.cassTestMapstructEntity.enumRequiredTom.$model"
              id="cass-test-mapstruct-entity-enumRequiredTom"
              data-cy="enumRequiredTom"
              required
            >
              <option value="ENUM_VALUE_1" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_1')">ENUM_VALUE_1</option>
              <option value="ENUM_VALUE_2" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_2')">ENUM_VALUE_2</option>
              <option value="ENUM_VALUE_3" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_3')">ENUM_VALUE_3</option>
            </select>
            <div v-if="$v.cassTestMapstructEntity.enumRequiredTom.$anyDirty && $v.cassTestMapstructEntity.enumRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestMapstructEntity.enumRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.picture')"
              for="cass-test-mapstruct-entity-picture"
              >Picture</label
            >
            <div>
              <img
                v-bind:src="'data:' + cassTestMapstructEntity.pictureContentType + ';base64,' + cassTestMapstructEntity.picture"
                style="max-height: 100px"
                v-if="cassTestMapstructEntity.picture"
                alt="cassTestMapstructEntity image"
              />
              <div v-if="cassTestMapstructEntity.picture" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ cassTestMapstructEntity.pictureContentType }}, {{ byteSize(cassTestMapstructEntity.picture) }}</span
                >
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
                v-on:change="setFileData($event, cassTestMapstructEntity, 'picture', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="picture"
              id="cass-test-mapstruct-entity-picture"
              data-cy="picture"
              :class="{ valid: !$v.cassTestMapstructEntity.picture.$invalid, invalid: $v.cassTestMapstructEntity.picture.$invalid }"
              v-model="$v.cassTestMapstructEntity.picture.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="pictureContentType"
              id="cass-test-mapstruct-entity-pictureContentType"
              v-model="cassTestMapstructEntity.pictureContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestMapstructEntity.operationsFile')"
              for="cass-test-mapstruct-entity-operationsFile"
              >Operations File</label
            >
            <div>
              <div v-if="cassTestMapstructEntity.operationsFile" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ cassTestMapstructEntity.operationsFileContentType }}, {{ byteSize(cassTestMapstructEntity.operationsFile) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    cassTestMapstructEntity.operationsFile = null;
                    cassTestMapstructEntity.operationsFileContentType = null;
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
                v-on:change="setFileData($event, cassTestMapstructEntity, 'operationsFile', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="operationsFile"
              id="cass-test-mapstruct-entity-operationsFile"
              data-cy="operationsFile"
              :class="{
                valid: !$v.cassTestMapstructEntity.operationsFile.$invalid,
                invalid: $v.cassTestMapstructEntity.operationsFile.$invalid,
              }"
              v-model="$v.cassTestMapstructEntity.operationsFile.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="operationsFileContentType"
              id="cass-test-mapstruct-entity-operationsFileContentType"
              v-model="cassTestMapstructEntity.operationsFileContentType"
            />
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
            :disabled="$v.cassTestMapstructEntity.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cass-test-mapstruct-entity-update.component.ts"></script>
