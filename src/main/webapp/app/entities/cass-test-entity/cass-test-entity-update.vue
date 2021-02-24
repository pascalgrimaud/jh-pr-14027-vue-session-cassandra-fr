<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.cassTestEntity.home.createOrEditLabel"
          data-cy="CassTestEntityCreateUpdateHeading"
          v-text="$t('jhipsterApp.cassTestEntity.home.createOrEditLabel')"
        >
          Create or edit a CassTestEntity
        </h2>
        <div>
          <div class="form-group" v-if="cassTestEntity.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cassTestEntity.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.stringField')" for="cass-test-entity-stringField"
              >String Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringField"
              id="cass-test-entity-stringField"
              data-cy="stringField"
              :class="{ valid: !$v.cassTestEntity.stringField.$invalid, invalid: $v.cassTestEntity.stringField.$invalid }"
              v-model="$v.cassTestEntity.stringField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.stringRequiredField')"
              for="cass-test-entity-stringRequiredField"
              >String Required Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringRequiredField"
              id="cass-test-entity-stringRequiredField"
              data-cy="stringRequiredField"
              :class="{ valid: !$v.cassTestEntity.stringRequiredField.$invalid, invalid: $v.cassTestEntity.stringRequiredField.$invalid }"
              v-model="$v.cassTestEntity.stringRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestEntity.stringRequiredField.$anyDirty && $v.cassTestEntity.stringRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.stringRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.stringMinlengthField')"
              for="cass-test-entity-stringMinlengthField"
              >String Minlength Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMinlengthField"
              id="cass-test-entity-stringMinlengthField"
              data-cy="stringMinlengthField"
              :class="{ valid: !$v.cassTestEntity.stringMinlengthField.$invalid, invalid: $v.cassTestEntity.stringMinlengthField.$invalid }"
              v-model="$v.cassTestEntity.stringMinlengthField.$model"
            />
            <div v-if="$v.cassTestEntity.stringMinlengthField.$anyDirty && $v.cassTestEntity.stringMinlengthField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.stringMinlengthField.minLength"
                v-text="$t('entity.validation.minlength', { min: 0 })"
              >
                This field is required to be at least 0 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.stringMaxlengthField')"
              for="cass-test-entity-stringMaxlengthField"
              >String Maxlength Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMaxlengthField"
              id="cass-test-entity-stringMaxlengthField"
              data-cy="stringMaxlengthField"
              :class="{ valid: !$v.cassTestEntity.stringMaxlengthField.$invalid, invalid: $v.cassTestEntity.stringMaxlengthField.$invalid }"
              v-model="$v.cassTestEntity.stringMaxlengthField.$model"
            />
            <div v-if="$v.cassTestEntity.stringMaxlengthField.$anyDirty && $v.cassTestEntity.stringMaxlengthField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.stringMaxlengthField.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.stringPatternField')"
              for="cass-test-entity-stringPatternField"
              >String Pattern Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringPatternField"
              id="cass-test-entity-stringPatternField"
              data-cy="stringPatternField"
              :class="{ valid: !$v.cassTestEntity.stringPatternField.$invalid, invalid: $v.cassTestEntity.stringPatternField.$invalid }"
              v-model="$v.cassTestEntity.stringPatternField.$model"
            />
            <div v-if="$v.cassTestEntity.stringPatternField.$anyDirty && $v.cassTestEntity.stringPatternField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.stringPatternField.pattern"
                v-text="$t('entity.validation.pattern', { pattern: 'String Pattern Field' })"
              >
                This field should follow pattern for "String Pattern Field".
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.integerField')" for="cass-test-entity-integerField"
              >Integer Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerField"
              id="cass-test-entity-integerField"
              data-cy="integerField"
              :class="{ valid: !$v.cassTestEntity.integerField.$invalid, invalid: $v.cassTestEntity.integerField.$invalid }"
              v-model.number="$v.cassTestEntity.integerField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.integerRequiredField')"
              for="cass-test-entity-integerRequiredField"
              >Integer Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerRequiredField"
              id="cass-test-entity-integerRequiredField"
              data-cy="integerRequiredField"
              :class="{ valid: !$v.cassTestEntity.integerRequiredField.$invalid, invalid: $v.cassTestEntity.integerRequiredField.$invalid }"
              v-model.number="$v.cassTestEntity.integerRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestEntity.integerRequiredField.$anyDirty && $v.cassTestEntity.integerRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.integerRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.integerRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.integerMinField')"
              for="cass-test-entity-integerMinField"
              >Integer Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMinField"
              id="cass-test-entity-integerMinField"
              data-cy="integerMinField"
              :class="{ valid: !$v.cassTestEntity.integerMinField.$invalid, invalid: $v.cassTestEntity.integerMinField.$invalid }"
              v-model.number="$v.cassTestEntity.integerMinField.$model"
            />
            <div v-if="$v.cassTestEntity.integerMinField.$anyDirty && $v.cassTestEntity.integerMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.integerMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.integerMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.integerMaxField')"
              for="cass-test-entity-integerMaxField"
              >Integer Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMaxField"
              id="cass-test-entity-integerMaxField"
              data-cy="integerMaxField"
              :class="{ valid: !$v.cassTestEntity.integerMaxField.$invalid, invalid: $v.cassTestEntity.integerMaxField.$invalid }"
              v-model.number="$v.cassTestEntity.integerMaxField.$model"
            />
            <div v-if="$v.cassTestEntity.integerMaxField.$anyDirty && $v.cassTestEntity.integerMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.integerMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.integerMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.longField')" for="cass-test-entity-longField"
              >Long Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longField"
              id="cass-test-entity-longField"
              data-cy="longField"
              :class="{ valid: !$v.cassTestEntity.longField.$invalid, invalid: $v.cassTestEntity.longField.$invalid }"
              v-model.number="$v.cassTestEntity.longField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.longRequiredField')"
              for="cass-test-entity-longRequiredField"
              >Long Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longRequiredField"
              id="cass-test-entity-longRequiredField"
              data-cy="longRequiredField"
              :class="{ valid: !$v.cassTestEntity.longRequiredField.$invalid, invalid: $v.cassTestEntity.longRequiredField.$invalid }"
              v-model.number="$v.cassTestEntity.longRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestEntity.longRequiredField.$anyDirty && $v.cassTestEntity.longRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.longRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.longRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.longMinField')" for="cass-test-entity-longMinField"
              >Long Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longMinField"
              id="cass-test-entity-longMinField"
              data-cy="longMinField"
              :class="{ valid: !$v.cassTestEntity.longMinField.$invalid, invalid: $v.cassTestEntity.longMinField.$invalid }"
              v-model.number="$v.cassTestEntity.longMinField.$model"
            />
            <div v-if="$v.cassTestEntity.longMinField.$anyDirty && $v.cassTestEntity.longMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.longMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small class="form-text text-danger" v-if="!$v.cassTestEntity.longMinField.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.longMaxField')" for="cass-test-entity-longMaxField"
              >Long Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longMaxField"
              id="cass-test-entity-longMaxField"
              data-cy="longMaxField"
              :class="{ valid: !$v.cassTestEntity.longMaxField.$invalid, invalid: $v.cassTestEntity.longMaxField.$invalid }"
              v-model.number="$v.cassTestEntity.longMaxField.$model"
            />
            <div v-if="$v.cassTestEntity.longMaxField.$anyDirty && $v.cassTestEntity.longMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.longMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small class="form-text text-danger" v-if="!$v.cassTestEntity.longMaxField.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.floatField')" for="cass-test-entity-floatField"
              >Float Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatField"
              id="cass-test-entity-floatField"
              data-cy="floatField"
              :class="{ valid: !$v.cassTestEntity.floatField.$invalid, invalid: $v.cassTestEntity.floatField.$invalid }"
              v-model.number="$v.cassTestEntity.floatField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.floatRequiredField')"
              for="cass-test-entity-floatRequiredField"
              >Float Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatRequiredField"
              id="cass-test-entity-floatRequiredField"
              data-cy="floatRequiredField"
              :class="{ valid: !$v.cassTestEntity.floatRequiredField.$invalid, invalid: $v.cassTestEntity.floatRequiredField.$invalid }"
              v-model.number="$v.cassTestEntity.floatRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestEntity.floatRequiredField.$anyDirty && $v.cassTestEntity.floatRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.floatRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.floatRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.floatMinField')" for="cass-test-entity-floatMinField"
              >Float Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMinField"
              id="cass-test-entity-floatMinField"
              data-cy="floatMinField"
              :class="{ valid: !$v.cassTestEntity.floatMinField.$invalid, invalid: $v.cassTestEntity.floatMinField.$invalid }"
              v-model.number="$v.cassTestEntity.floatMinField.$model"
            />
            <div v-if="$v.cassTestEntity.floatMinField.$anyDirty && $v.cassTestEntity.floatMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.floatMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small class="form-text text-danger" v-if="!$v.cassTestEntity.floatMinField.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.floatMaxField')" for="cass-test-entity-floatMaxField"
              >Float Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMaxField"
              id="cass-test-entity-floatMaxField"
              data-cy="floatMaxField"
              :class="{ valid: !$v.cassTestEntity.floatMaxField.$invalid, invalid: $v.cassTestEntity.floatMaxField.$invalid }"
              v-model.number="$v.cassTestEntity.floatMaxField.$model"
            />
            <div v-if="$v.cassTestEntity.floatMaxField.$anyDirty && $v.cassTestEntity.floatMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.floatMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small class="form-text text-danger" v-if="!$v.cassTestEntity.floatMaxField.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.doubleRequiredField')"
              for="cass-test-entity-doubleRequiredField"
              >Double Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleRequiredField"
              id="cass-test-entity-doubleRequiredField"
              data-cy="doubleRequiredField"
              :class="{ valid: !$v.cassTestEntity.doubleRequiredField.$invalid, invalid: $v.cassTestEntity.doubleRequiredField.$invalid }"
              v-model.number="$v.cassTestEntity.doubleRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestEntity.doubleRequiredField.$anyDirty && $v.cassTestEntity.doubleRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.doubleRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.doubleRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.doubleMinField')" for="cass-test-entity-doubleMinField"
              >Double Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMinField"
              id="cass-test-entity-doubleMinField"
              data-cy="doubleMinField"
              :class="{ valid: !$v.cassTestEntity.doubleMinField.$invalid, invalid: $v.cassTestEntity.doubleMinField.$invalid }"
              v-model.number="$v.cassTestEntity.doubleMinField.$model"
            />
            <div v-if="$v.cassTestEntity.doubleMinField.$anyDirty && $v.cassTestEntity.doubleMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.doubleMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small class="form-text text-danger" v-if="!$v.cassTestEntity.doubleMinField.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.doubleMaxField')" for="cass-test-entity-doubleMaxField"
              >Double Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMaxField"
              id="cass-test-entity-doubleMaxField"
              data-cy="doubleMaxField"
              :class="{ valid: !$v.cassTestEntity.doubleMaxField.$invalid, invalid: $v.cassTestEntity.doubleMaxField.$invalid }"
              v-model.number="$v.cassTestEntity.doubleMaxField.$model"
            />
            <div v-if="$v.cassTestEntity.doubleMaxField.$anyDirty && $v.cassTestEntity.doubleMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.doubleMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small class="form-text text-danger" v-if="!$v.cassTestEntity.doubleMaxField.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.bigDecimalRequiredField')"
              for="cass-test-entity-bigDecimalRequiredField"
              >Big Decimal Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalRequiredField"
              id="cass-test-entity-bigDecimalRequiredField"
              data-cy="bigDecimalRequiredField"
              :class="{
                valid: !$v.cassTestEntity.bigDecimalRequiredField.$invalid,
                invalid: $v.cassTestEntity.bigDecimalRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestEntity.bigDecimalRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestEntity.bigDecimalRequiredField.$anyDirty && $v.cassTestEntity.bigDecimalRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.bigDecimalRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.bigDecimalRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.bigDecimalMinField')"
              for="cass-test-entity-bigDecimalMinField"
              >Big Decimal Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMinField"
              id="cass-test-entity-bigDecimalMinField"
              data-cy="bigDecimalMinField"
              :class="{ valid: !$v.cassTestEntity.bigDecimalMinField.$invalid, invalid: $v.cassTestEntity.bigDecimalMinField.$invalid }"
              v-model.number="$v.cassTestEntity.bigDecimalMinField.$model"
            />
            <div v-if="$v.cassTestEntity.bigDecimalMinField.$anyDirty && $v.cassTestEntity.bigDecimalMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.bigDecimalMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.bigDecimalMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.bigDecimalMaxField')"
              for="cass-test-entity-bigDecimalMaxField"
              >Big Decimal Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMaxField"
              id="cass-test-entity-bigDecimalMaxField"
              data-cy="bigDecimalMaxField"
              :class="{ valid: !$v.cassTestEntity.bigDecimalMaxField.$invalid, invalid: $v.cassTestEntity.bigDecimalMaxField.$invalid }"
              v-model.number="$v.cassTestEntity.bigDecimalMaxField.$model"
            />
            <div v-if="$v.cassTestEntity.bigDecimalMaxField.$anyDirty && $v.cassTestEntity.bigDecimalMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.bigDecimalMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.bigDecimalMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.localDateField')" for="cass-test-entity-localDateField"
              >Local Date Field</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cass-test-entity-localDateField"
                  v-model="$v.cassTestEntity.localDateField.$model"
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
                id="cass-test-entity-localDateField"
                data-cy="localDateField"
                type="text"
                class="form-control"
                name="localDateField"
                :class="{ valid: !$v.cassTestEntity.localDateField.$invalid, invalid: $v.cassTestEntity.localDateField.$invalid }"
                v-model="$v.cassTestEntity.localDateField.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.localDateRequiredField')"
              for="cass-test-entity-localDateRequiredField"
              >Local Date Required Field</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cass-test-entity-localDateRequiredField"
                  v-model="$v.cassTestEntity.localDateRequiredField.$model"
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
                id="cass-test-entity-localDateRequiredField"
                data-cy="localDateRequiredField"
                type="text"
                class="form-control"
                name="localDateRequiredField"
                :class="{
                  valid: !$v.cassTestEntity.localDateRequiredField.$invalid,
                  invalid: $v.cassTestEntity.localDateRequiredField.$invalid,
                }"
                v-model="$v.cassTestEntity.localDateRequiredField.$model"
                required
              />
            </b-input-group>
            <div v-if="$v.cassTestEntity.localDateRequiredField.$anyDirty && $v.cassTestEntity.localDateRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.localDateRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.instantDateField')"
              for="cass-test-entity-instantDateField"
              >Instant Date Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-entity-instantDateField"
                data-cy="instantDateField"
                type="datetime-local"
                class="form-control"
                name="instantDateField"
                :class="{ valid: !$v.cassTestEntity.instantDateField.$invalid, invalid: $v.cassTestEntity.instantDateField.$invalid }"
                :value="convertDateTimeFromServer($v.cassTestEntity.instantDateField.$model)"
                @change="updateInstantField('instantDateField', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.instantRequiredField')"
              for="cass-test-entity-instantRequiredField"
              >Instant Required Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-entity-instantRequiredField"
                data-cy="instantRequiredField"
                type="datetime-local"
                class="form-control"
                name="instantRequiredField"
                :class="{
                  valid: !$v.cassTestEntity.instantRequiredField.$invalid,
                  invalid: $v.cassTestEntity.instantRequiredField.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.cassTestEntity.instantRequiredField.$model)"
                @change="updateInstantField('instantRequiredField', $event)"
              />
            </div>
            <div v-if="$v.cassTestEntity.instantRequiredField.$anyDirty && $v.cassTestEntity.instantRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.instantRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.instantRequiredField.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.zonedDateTimeField')"
              for="cass-test-entity-zonedDateTimeField"
              >Zoned Date Time Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-entity-zonedDateTimeField"
                data-cy="zonedDateTimeField"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeField"
                :class="{ valid: !$v.cassTestEntity.zonedDateTimeField.$invalid, invalid: $v.cassTestEntity.zonedDateTimeField.$invalid }"
                :value="convertDateTimeFromServer($v.cassTestEntity.zonedDateTimeField.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeField', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.zonedDateTimeRequiredField')"
              for="cass-test-entity-zonedDateTimeRequiredField"
              >Zoned Date Time Required Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-entity-zonedDateTimeRequiredField"
                data-cy="zonedDateTimeRequiredField"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeRequiredField"
                :class="{
                  valid: !$v.cassTestEntity.zonedDateTimeRequiredField.$invalid,
                  invalid: $v.cassTestEntity.zonedDateTimeRequiredField.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.cassTestEntity.zonedDateTimeRequiredField.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeRequiredField', $event)"
              />
            </div>
            <div v-if="$v.cassTestEntity.zonedDateTimeRequiredField.$anyDirty && $v.cassTestEntity.zonedDateTimeRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.zonedDateTimeRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.zonedDateTimeRequiredField.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.durationDateField')"
              for="cass-test-entity-durationDateField"
              >Duration Date Field</label
            >
            <input
              type="text"
              class="form-control"
              name="durationDateField"
              id="cass-test-entity-durationDateField"
              data-cy="durationDateField"
              :class="{ valid: !$v.cassTestEntity.durationDateField.$invalid, invalid: $v.cassTestEntity.durationDateField.$invalid }"
              v-model="$v.cassTestEntity.durationDateField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.durationRequiredField')"
              for="cass-test-entity-durationRequiredField"
              >Duration Required Field</label
            >
            <input
              type="text"
              class="form-control"
              name="durationRequiredField"
              id="cass-test-entity-durationRequiredField"
              data-cy="durationRequiredField"
              :class="{
                valid: !$v.cassTestEntity.durationRequiredField.$invalid,
                invalid: $v.cassTestEntity.durationRequiredField.$invalid,
              }"
              v-model="$v.cassTestEntity.durationRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestEntity.durationRequiredField.$anyDirty && $v.cassTestEntity.durationRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.durationRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.durationRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.booleanField')" for="cass-test-entity-booleanField"
              >Boolean Field</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanField"
              id="cass-test-entity-booleanField"
              data-cy="booleanField"
              :class="{ valid: !$v.cassTestEntity.booleanField.$invalid, invalid: $v.cassTestEntity.booleanField.$invalid }"
              v-model="$v.cassTestEntity.booleanField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestEntity.booleanRequiredField')"
              for="cass-test-entity-booleanRequiredField"
              >Boolean Required Field</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanRequiredField"
              id="cass-test-entity-booleanRequiredField"
              data-cy="booleanRequiredField"
              :class="{ valid: !$v.cassTestEntity.booleanRequiredField.$invalid, invalid: $v.cassTestEntity.booleanRequiredField.$invalid }"
              v-model="$v.cassTestEntity.booleanRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestEntity.booleanRequiredField.$anyDirty && $v.cassTestEntity.booleanRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.booleanRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.enumTom')" for="cass-test-entity-enumTom"
              >Enum Tom</label
            >
            <select
              class="form-control"
              name="enumTom"
              :class="{ valid: !$v.cassTestEntity.enumTom.$invalid, invalid: $v.cassTestEntity.enumTom.$invalid }"
              v-model="$v.cassTestEntity.enumTom.$model"
              id="cass-test-entity-enumTom"
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
              v-text="$t('jhipsterApp.cassTestEntity.enumRequiredTom')"
              for="cass-test-entity-enumRequiredTom"
              >Enum Required Tom</label
            >
            <select
              class="form-control"
              name="enumRequiredTom"
              :class="{ valid: !$v.cassTestEntity.enumRequiredTom.$invalid, invalid: $v.cassTestEntity.enumRequiredTom.$invalid }"
              v-model="$v.cassTestEntity.enumRequiredTom.$model"
              id="cass-test-entity-enumRequiredTom"
              data-cy="enumRequiredTom"
              required
            >
              <option value="ENUM_VALUE_1" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_1')">ENUM_VALUE_1</option>
              <option value="ENUM_VALUE_2" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_2')">ENUM_VALUE_2</option>
              <option value="ENUM_VALUE_3" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_3')">ENUM_VALUE_3</option>
            </select>
            <div v-if="$v.cassTestEntity.enumRequiredTom.$anyDirty && $v.cassTestEntity.enumRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestEntity.enumRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.picture')" for="cass-test-entity-picture"
              >Picture</label
            >
            <div>
              <img
                v-bind:src="'data:' + cassTestEntity.pictureContentType + ';base64,' + cassTestEntity.picture"
                style="max-height: 100px"
                v-if="cassTestEntity.picture"
                alt="cassTestEntity image"
              />
              <div v-if="cassTestEntity.picture" class="form-text text-danger clearfix">
                <span class="pull-left">{{ cassTestEntity.pictureContentType }}, {{ byteSize(cassTestEntity.picture) }}</span>
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
                v-on:change="setFileData($event, cassTestEntity, 'picture', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="picture"
              id="cass-test-entity-picture"
              data-cy="picture"
              :class="{ valid: !$v.cassTestEntity.picture.$invalid, invalid: $v.cassTestEntity.picture.$invalid }"
              v-model="$v.cassTestEntity.picture.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="pictureContentType"
              id="cass-test-entity-pictureContentType"
              v-model="cassTestEntity.pictureContentType"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.cassTestEntity.operationsFile')" for="cass-test-entity-operationsFile"
              >Operations File</label
            >
            <div>
              <div v-if="cassTestEntity.operationsFile" class="form-text text-danger clearfix">
                <span class="pull-left">{{ cassTestEntity.operationsFileContentType }}, {{ byteSize(cassTestEntity.operationsFile) }}</span>
                <button
                  type="button"
                  v-on:click="
                    cassTestEntity.operationsFile = null;
                    cassTestEntity.operationsFileContentType = null;
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
                v-on:change="setFileData($event, cassTestEntity, 'operationsFile', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="operationsFile"
              id="cass-test-entity-operationsFile"
              data-cy="operationsFile"
              :class="{ valid: !$v.cassTestEntity.operationsFile.$invalid, invalid: $v.cassTestEntity.operationsFile.$invalid }"
              v-model="$v.cassTestEntity.operationsFile.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="operationsFileContentType"
              id="cass-test-entity-operationsFileContentType"
              v-model="cassTestEntity.operationsFileContentType"
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
            :disabled="$v.cassTestEntity.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cass-test-entity-update.component.ts"></script>
