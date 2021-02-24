<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.cassTestServiceImplEntity.home.createOrEditLabel"
          data-cy="CassTestServiceImplEntityCreateUpdateHeading"
          v-text="$t('jhipsterApp.cassTestServiceImplEntity.home.createOrEditLabel')"
        >
          Create or edit a CassTestServiceImplEntity
        </h2>
        <div>
          <div class="form-group" v-if="cassTestServiceImplEntity.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cassTestServiceImplEntity.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringField')"
              for="cass-test-service-impl-entity-stringField"
              >String Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringField"
              id="cass-test-service-impl-entity-stringField"
              data-cy="stringField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.stringField.$invalid,
                invalid: $v.cassTestServiceImplEntity.stringField.$invalid,
              }"
              v-model="$v.cassTestServiceImplEntity.stringField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringRequiredField')"
              for="cass-test-service-impl-entity-stringRequiredField"
              >String Required Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringRequiredField"
              id="cass-test-service-impl-entity-stringRequiredField"
              data-cy="stringRequiredField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.stringRequiredField.$invalid,
                invalid: $v.cassTestServiceImplEntity.stringRequiredField.$invalid,
              }"
              v-model="$v.cassTestServiceImplEntity.stringRequiredField.$model"
              required
            />
            <div
              v-if="$v.cassTestServiceImplEntity.stringRequiredField.$anyDirty && $v.cassTestServiceImplEntity.stringRequiredField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.stringRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringMinlengthField')"
              for="cass-test-service-impl-entity-stringMinlengthField"
              >String Minlength Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMinlengthField"
              id="cass-test-service-impl-entity-stringMinlengthField"
              data-cy="stringMinlengthField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.stringMinlengthField.$invalid,
                invalid: $v.cassTestServiceImplEntity.stringMinlengthField.$invalid,
              }"
              v-model="$v.cassTestServiceImplEntity.stringMinlengthField.$model"
            />
            <div
              v-if="
                $v.cassTestServiceImplEntity.stringMinlengthField.$anyDirty && $v.cassTestServiceImplEntity.stringMinlengthField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.stringMinlengthField.minLength"
                v-text="$t('entity.validation.minlength', { min: 0 })"
              >
                This field is required to be at least 0 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringMaxlengthField')"
              for="cass-test-service-impl-entity-stringMaxlengthField"
              >String Maxlength Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMaxlengthField"
              id="cass-test-service-impl-entity-stringMaxlengthField"
              data-cy="stringMaxlengthField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.stringMaxlengthField.$invalid,
                invalid: $v.cassTestServiceImplEntity.stringMaxlengthField.$invalid,
              }"
              v-model="$v.cassTestServiceImplEntity.stringMaxlengthField.$model"
            />
            <div
              v-if="
                $v.cassTestServiceImplEntity.stringMaxlengthField.$anyDirty && $v.cassTestServiceImplEntity.stringMaxlengthField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.stringMaxlengthField.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringPatternField')"
              for="cass-test-service-impl-entity-stringPatternField"
              >String Pattern Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringPatternField"
              id="cass-test-service-impl-entity-stringPatternField"
              data-cy="stringPatternField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.stringPatternField.$invalid,
                invalid: $v.cassTestServiceImplEntity.stringPatternField.$invalid,
              }"
              v-model="$v.cassTestServiceImplEntity.stringPatternField.$model"
            />
            <div
              v-if="$v.cassTestServiceImplEntity.stringPatternField.$anyDirty && $v.cassTestServiceImplEntity.stringPatternField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.stringPatternField.pattern"
                v-text="$t('entity.validation.pattern', { pattern: 'String Pattern Field' })"
              >
                This field should follow pattern for "String Pattern Field".
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerField')"
              for="cass-test-service-impl-entity-integerField"
              >Integer Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerField"
              id="cass-test-service-impl-entity-integerField"
              data-cy="integerField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.integerField.$invalid,
                invalid: $v.cassTestServiceImplEntity.integerField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.integerField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerRequiredField')"
              for="cass-test-service-impl-entity-integerRequiredField"
              >Integer Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerRequiredField"
              id="cass-test-service-impl-entity-integerRequiredField"
              data-cy="integerRequiredField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.integerRequiredField.$invalid,
                invalid: $v.cassTestServiceImplEntity.integerRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.integerRequiredField.$model"
              required
            />
            <div
              v-if="
                $v.cassTestServiceImplEntity.integerRequiredField.$anyDirty && $v.cassTestServiceImplEntity.integerRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.integerRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.integerRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerMinField')"
              for="cass-test-service-impl-entity-integerMinField"
              >Integer Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMinField"
              id="cass-test-service-impl-entity-integerMinField"
              data-cy="integerMinField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.integerMinField.$invalid,
                invalid: $v.cassTestServiceImplEntity.integerMinField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.integerMinField.$model"
            />
            <div v-if="$v.cassTestServiceImplEntity.integerMinField.$anyDirty && $v.cassTestServiceImplEntity.integerMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.integerMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.integerMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerMaxField')"
              for="cass-test-service-impl-entity-integerMaxField"
              >Integer Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMaxField"
              id="cass-test-service-impl-entity-integerMaxField"
              data-cy="integerMaxField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.integerMaxField.$invalid,
                invalid: $v.cassTestServiceImplEntity.integerMaxField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.integerMaxField.$model"
            />
            <div v-if="$v.cassTestServiceImplEntity.integerMaxField.$anyDirty && $v.cassTestServiceImplEntity.integerMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.integerMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.integerMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.longField')"
              for="cass-test-service-impl-entity-longField"
              >Long Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longField"
              id="cass-test-service-impl-entity-longField"
              data-cy="longField"
              :class="{ valid: !$v.cassTestServiceImplEntity.longField.$invalid, invalid: $v.cassTestServiceImplEntity.longField.$invalid }"
              v-model.number="$v.cassTestServiceImplEntity.longField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.longRequiredField')"
              for="cass-test-service-impl-entity-longRequiredField"
              >Long Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longRequiredField"
              id="cass-test-service-impl-entity-longRequiredField"
              data-cy="longRequiredField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.longRequiredField.$invalid,
                invalid: $v.cassTestServiceImplEntity.longRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.longRequiredField.$model"
              required
            />
            <div v-if="$v.cassTestServiceImplEntity.longRequiredField.$anyDirty && $v.cassTestServiceImplEntity.longRequiredField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.longRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.longRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.longMinField')"
              for="cass-test-service-impl-entity-longMinField"
              >Long Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longMinField"
              id="cass-test-service-impl-entity-longMinField"
              data-cy="longMinField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.longMinField.$invalid,
                invalid: $v.cassTestServiceImplEntity.longMinField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.longMinField.$model"
            />
            <div v-if="$v.cassTestServiceImplEntity.longMinField.$anyDirty && $v.cassTestServiceImplEntity.longMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.longMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.longMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.longMaxField')"
              for="cass-test-service-impl-entity-longMaxField"
              >Long Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longMaxField"
              id="cass-test-service-impl-entity-longMaxField"
              data-cy="longMaxField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.longMaxField.$invalid,
                invalid: $v.cassTestServiceImplEntity.longMaxField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.longMaxField.$model"
            />
            <div v-if="$v.cassTestServiceImplEntity.longMaxField.$anyDirty && $v.cassTestServiceImplEntity.longMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.longMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.longMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatField')"
              for="cass-test-service-impl-entity-floatField"
              >Float Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatField"
              id="cass-test-service-impl-entity-floatField"
              data-cy="floatField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.floatField.$invalid,
                invalid: $v.cassTestServiceImplEntity.floatField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.floatField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatRequiredField')"
              for="cass-test-service-impl-entity-floatRequiredField"
              >Float Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatRequiredField"
              id="cass-test-service-impl-entity-floatRequiredField"
              data-cy="floatRequiredField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.floatRequiredField.$invalid,
                invalid: $v.cassTestServiceImplEntity.floatRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.floatRequiredField.$model"
              required
            />
            <div
              v-if="$v.cassTestServiceImplEntity.floatRequiredField.$anyDirty && $v.cassTestServiceImplEntity.floatRequiredField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.floatRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.floatRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatMinField')"
              for="cass-test-service-impl-entity-floatMinField"
              >Float Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMinField"
              id="cass-test-service-impl-entity-floatMinField"
              data-cy="floatMinField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.floatMinField.$invalid,
                invalid: $v.cassTestServiceImplEntity.floatMinField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.floatMinField.$model"
            />
            <div v-if="$v.cassTestServiceImplEntity.floatMinField.$anyDirty && $v.cassTestServiceImplEntity.floatMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.floatMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.floatMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatMaxField')"
              for="cass-test-service-impl-entity-floatMaxField"
              >Float Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMaxField"
              id="cass-test-service-impl-entity-floatMaxField"
              data-cy="floatMaxField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.floatMaxField.$invalid,
                invalid: $v.cassTestServiceImplEntity.floatMaxField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.floatMaxField.$model"
            />
            <div v-if="$v.cassTestServiceImplEntity.floatMaxField.$anyDirty && $v.cassTestServiceImplEntity.floatMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.floatMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.floatMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.doubleRequiredField')"
              for="cass-test-service-impl-entity-doubleRequiredField"
              >Double Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleRequiredField"
              id="cass-test-service-impl-entity-doubleRequiredField"
              data-cy="doubleRequiredField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.doubleRequiredField.$invalid,
                invalid: $v.cassTestServiceImplEntity.doubleRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.doubleRequiredField.$model"
              required
            />
            <div
              v-if="$v.cassTestServiceImplEntity.doubleRequiredField.$anyDirty && $v.cassTestServiceImplEntity.doubleRequiredField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.doubleRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.doubleRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.doubleMinField')"
              for="cass-test-service-impl-entity-doubleMinField"
              >Double Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMinField"
              id="cass-test-service-impl-entity-doubleMinField"
              data-cy="doubleMinField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.doubleMinField.$invalid,
                invalid: $v.cassTestServiceImplEntity.doubleMinField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.doubleMinField.$model"
            />
            <div v-if="$v.cassTestServiceImplEntity.doubleMinField.$anyDirty && $v.cassTestServiceImplEntity.doubleMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.doubleMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.doubleMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.doubleMaxField')"
              for="cass-test-service-impl-entity-doubleMaxField"
              >Double Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMaxField"
              id="cass-test-service-impl-entity-doubleMaxField"
              data-cy="doubleMaxField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.doubleMaxField.$invalid,
                invalid: $v.cassTestServiceImplEntity.doubleMaxField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.doubleMaxField.$model"
            />
            <div v-if="$v.cassTestServiceImplEntity.doubleMaxField.$anyDirty && $v.cassTestServiceImplEntity.doubleMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.doubleMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.doubleMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.bigDecimalRequiredField')"
              for="cass-test-service-impl-entity-bigDecimalRequiredField"
              >Big Decimal Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalRequiredField"
              id="cass-test-service-impl-entity-bigDecimalRequiredField"
              data-cy="bigDecimalRequiredField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.bigDecimalRequiredField.$invalid,
                invalid: $v.cassTestServiceImplEntity.bigDecimalRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.bigDecimalRequiredField.$model"
              required
            />
            <div
              v-if="
                $v.cassTestServiceImplEntity.bigDecimalRequiredField.$anyDirty &&
                $v.cassTestServiceImplEntity.bigDecimalRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.bigDecimalRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.bigDecimalRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.bigDecimalMinField')"
              for="cass-test-service-impl-entity-bigDecimalMinField"
              >Big Decimal Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMinField"
              id="cass-test-service-impl-entity-bigDecimalMinField"
              data-cy="bigDecimalMinField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.bigDecimalMinField.$invalid,
                invalid: $v.cassTestServiceImplEntity.bigDecimalMinField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.bigDecimalMinField.$model"
            />
            <div
              v-if="$v.cassTestServiceImplEntity.bigDecimalMinField.$anyDirty && $v.cassTestServiceImplEntity.bigDecimalMinField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.bigDecimalMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.bigDecimalMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.bigDecimalMaxField')"
              for="cass-test-service-impl-entity-bigDecimalMaxField"
              >Big Decimal Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMaxField"
              id="cass-test-service-impl-entity-bigDecimalMaxField"
              data-cy="bigDecimalMaxField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.bigDecimalMaxField.$invalid,
                invalid: $v.cassTestServiceImplEntity.bigDecimalMaxField.$invalid,
              }"
              v-model.number="$v.cassTestServiceImplEntity.bigDecimalMaxField.$model"
            />
            <div
              v-if="$v.cassTestServiceImplEntity.bigDecimalMaxField.$anyDirty && $v.cassTestServiceImplEntity.bigDecimalMaxField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.bigDecimalMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.bigDecimalMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.localDateField')"
              for="cass-test-service-impl-entity-localDateField"
              >Local Date Field</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cass-test-service-impl-entity-localDateField"
                  v-model="$v.cassTestServiceImplEntity.localDateField.$model"
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
                id="cass-test-service-impl-entity-localDateField"
                data-cy="localDateField"
                type="text"
                class="form-control"
                name="localDateField"
                :class="{
                  valid: !$v.cassTestServiceImplEntity.localDateField.$invalid,
                  invalid: $v.cassTestServiceImplEntity.localDateField.$invalid,
                }"
                v-model="$v.cassTestServiceImplEntity.localDateField.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.localDateRequiredField')"
              for="cass-test-service-impl-entity-localDateRequiredField"
              >Local Date Required Field</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cass-test-service-impl-entity-localDateRequiredField"
                  v-model="$v.cassTestServiceImplEntity.localDateRequiredField.$model"
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
                id="cass-test-service-impl-entity-localDateRequiredField"
                data-cy="localDateRequiredField"
                type="text"
                class="form-control"
                name="localDateRequiredField"
                :class="{
                  valid: !$v.cassTestServiceImplEntity.localDateRequiredField.$invalid,
                  invalid: $v.cassTestServiceImplEntity.localDateRequiredField.$invalid,
                }"
                v-model="$v.cassTestServiceImplEntity.localDateRequiredField.$model"
                required
              />
            </b-input-group>
            <div
              v-if="
                $v.cassTestServiceImplEntity.localDateRequiredField.$anyDirty &&
                $v.cassTestServiceImplEntity.localDateRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.localDateRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.instantDateField')"
              for="cass-test-service-impl-entity-instantDateField"
              >Instant Date Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-service-impl-entity-instantDateField"
                data-cy="instantDateField"
                type="datetime-local"
                class="form-control"
                name="instantDateField"
                :class="{
                  valid: !$v.cassTestServiceImplEntity.instantDateField.$invalid,
                  invalid: $v.cassTestServiceImplEntity.instantDateField.$invalid,
                }"
                :value="convertDateTimeFromServer($v.cassTestServiceImplEntity.instantDateField.$model)"
                @change="updateInstantField('instantDateField', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.instantRequiredField')"
              for="cass-test-service-impl-entity-instantRequiredField"
              >Instant Required Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-service-impl-entity-instantRequiredField"
                data-cy="instantRequiredField"
                type="datetime-local"
                class="form-control"
                name="instantRequiredField"
                :class="{
                  valid: !$v.cassTestServiceImplEntity.instantRequiredField.$invalid,
                  invalid: $v.cassTestServiceImplEntity.instantRequiredField.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.cassTestServiceImplEntity.instantRequiredField.$model)"
                @change="updateInstantField('instantRequiredField', $event)"
              />
            </div>
            <div
              v-if="
                $v.cassTestServiceImplEntity.instantRequiredField.$anyDirty && $v.cassTestServiceImplEntity.instantRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.instantRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.instantRequiredField.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.zonedDateTimeField')"
              for="cass-test-service-impl-entity-zonedDateTimeField"
              >Zoned Date Time Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-service-impl-entity-zonedDateTimeField"
                data-cy="zonedDateTimeField"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeField"
                :class="{
                  valid: !$v.cassTestServiceImplEntity.zonedDateTimeField.$invalid,
                  invalid: $v.cassTestServiceImplEntity.zonedDateTimeField.$invalid,
                }"
                :value="convertDateTimeFromServer($v.cassTestServiceImplEntity.zonedDateTimeField.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeField', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.zonedDateTimeRequiredField')"
              for="cass-test-service-impl-entity-zonedDateTimeRequiredField"
              >Zoned Date Time Required Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-service-impl-entity-zonedDateTimeRequiredField"
                data-cy="zonedDateTimeRequiredField"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeRequiredField"
                :class="{
                  valid: !$v.cassTestServiceImplEntity.zonedDateTimeRequiredField.$invalid,
                  invalid: $v.cassTestServiceImplEntity.zonedDateTimeRequiredField.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.cassTestServiceImplEntity.zonedDateTimeRequiredField.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeRequiredField', $event)"
              />
            </div>
            <div
              v-if="
                $v.cassTestServiceImplEntity.zonedDateTimeRequiredField.$anyDirty &&
                $v.cassTestServiceImplEntity.zonedDateTimeRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.zonedDateTimeRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.zonedDateTimeRequiredField.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.durationDateField')"
              for="cass-test-service-impl-entity-durationDateField"
              >Duration Date Field</label
            >
            <input
              type="text"
              class="form-control"
              name="durationDateField"
              id="cass-test-service-impl-entity-durationDateField"
              data-cy="durationDateField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.durationDateField.$invalid,
                invalid: $v.cassTestServiceImplEntity.durationDateField.$invalid,
              }"
              v-model="$v.cassTestServiceImplEntity.durationDateField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.durationRequiredField')"
              for="cass-test-service-impl-entity-durationRequiredField"
              >Duration Required Field</label
            >
            <input
              type="text"
              class="form-control"
              name="durationRequiredField"
              id="cass-test-service-impl-entity-durationRequiredField"
              data-cy="durationRequiredField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.durationRequiredField.$invalid,
                invalid: $v.cassTestServiceImplEntity.durationRequiredField.$invalid,
              }"
              v-model="$v.cassTestServiceImplEntity.durationRequiredField.$model"
              required
            />
            <div
              v-if="
                $v.cassTestServiceImplEntity.durationRequiredField.$anyDirty && $v.cassTestServiceImplEntity.durationRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.durationRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.durationRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.booleanField')"
              for="cass-test-service-impl-entity-booleanField"
              >Boolean Field</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanField"
              id="cass-test-service-impl-entity-booleanField"
              data-cy="booleanField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.booleanField.$invalid,
                invalid: $v.cassTestServiceImplEntity.booleanField.$invalid,
              }"
              v-model="$v.cassTestServiceImplEntity.booleanField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.booleanRequiredField')"
              for="cass-test-service-impl-entity-booleanRequiredField"
              >Boolean Required Field</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanRequiredField"
              id="cass-test-service-impl-entity-booleanRequiredField"
              data-cy="booleanRequiredField"
              :class="{
                valid: !$v.cassTestServiceImplEntity.booleanRequiredField.$invalid,
                invalid: $v.cassTestServiceImplEntity.booleanRequiredField.$invalid,
              }"
              v-model="$v.cassTestServiceImplEntity.booleanRequiredField.$model"
              required
            />
            <div
              v-if="
                $v.cassTestServiceImplEntity.booleanRequiredField.$anyDirty && $v.cassTestServiceImplEntity.booleanRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.booleanRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.enumTom')"
              for="cass-test-service-impl-entity-enumTom"
              >Enum Tom</label
            >
            <select
              class="form-control"
              name="enumTom"
              :class="{ valid: !$v.cassTestServiceImplEntity.enumTom.$invalid, invalid: $v.cassTestServiceImplEntity.enumTom.$invalid }"
              v-model="$v.cassTestServiceImplEntity.enumTom.$model"
              id="cass-test-service-impl-entity-enumTom"
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
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.enumRequiredTom')"
              for="cass-test-service-impl-entity-enumRequiredTom"
              >Enum Required Tom</label
            >
            <select
              class="form-control"
              name="enumRequiredTom"
              :class="{
                valid: !$v.cassTestServiceImplEntity.enumRequiredTom.$invalid,
                invalid: $v.cassTestServiceImplEntity.enumRequiredTom.$invalid,
              }"
              v-model="$v.cassTestServiceImplEntity.enumRequiredTom.$model"
              id="cass-test-service-impl-entity-enumRequiredTom"
              data-cy="enumRequiredTom"
              required
            >
              <option value="ENUM_VALUE_1" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_1')">ENUM_VALUE_1</option>
              <option value="ENUM_VALUE_2" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_2')">ENUM_VALUE_2</option>
              <option value="ENUM_VALUE_3" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_3')">ENUM_VALUE_3</option>
            </select>
            <div v-if="$v.cassTestServiceImplEntity.enumRequiredTom.$anyDirty && $v.cassTestServiceImplEntity.enumRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceImplEntity.enumRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.picture')"
              for="cass-test-service-impl-entity-picture"
              >Picture</label
            >
            <div>
              <img
                v-bind:src="'data:' + cassTestServiceImplEntity.pictureContentType + ';base64,' + cassTestServiceImplEntity.picture"
                style="max-height: 100px"
                v-if="cassTestServiceImplEntity.picture"
                alt="cassTestServiceImplEntity image"
              />
              <div v-if="cassTestServiceImplEntity.picture" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ cassTestServiceImplEntity.pictureContentType }}, {{ byteSize(cassTestServiceImplEntity.picture) }}</span
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
                v-on:change="setFileData($event, cassTestServiceImplEntity, 'picture', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="picture"
              id="cass-test-service-impl-entity-picture"
              data-cy="picture"
              :class="{ valid: !$v.cassTestServiceImplEntity.picture.$invalid, invalid: $v.cassTestServiceImplEntity.picture.$invalid }"
              v-model="$v.cassTestServiceImplEntity.picture.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="pictureContentType"
              id="cass-test-service-impl-entity-pictureContentType"
              v-model="cassTestServiceImplEntity.pictureContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceImplEntity.operationsFile')"
              for="cass-test-service-impl-entity-operationsFile"
              >Operations File</label
            >
            <div>
              <div v-if="cassTestServiceImplEntity.operationsFile" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ cassTestServiceImplEntity.operationsFileContentType }}, {{ byteSize(cassTestServiceImplEntity.operationsFile) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    cassTestServiceImplEntity.operationsFile = null;
                    cassTestServiceImplEntity.operationsFileContentType = null;
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
                v-on:change="setFileData($event, cassTestServiceImplEntity, 'operationsFile', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="operationsFile"
              id="cass-test-service-impl-entity-operationsFile"
              data-cy="operationsFile"
              :class="{
                valid: !$v.cassTestServiceImplEntity.operationsFile.$invalid,
                invalid: $v.cassTestServiceImplEntity.operationsFile.$invalid,
              }"
              v-model="$v.cassTestServiceImplEntity.operationsFile.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="operationsFileContentType"
              id="cass-test-service-impl-entity-operationsFileContentType"
              v-model="cassTestServiceImplEntity.operationsFileContentType"
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
            :disabled="$v.cassTestServiceImplEntity.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cass-test-service-impl-entity-update.component.ts"></script>
