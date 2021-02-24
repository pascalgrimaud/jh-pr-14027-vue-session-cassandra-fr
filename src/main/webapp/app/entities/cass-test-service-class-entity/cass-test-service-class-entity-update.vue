<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.cassTestServiceClassEntity.home.createOrEditLabel"
          data-cy="CassTestServiceClassEntityCreateUpdateHeading"
          v-text="$t('jhipsterApp.cassTestServiceClassEntity.home.createOrEditLabel')"
        >
          Create or edit a CassTestServiceClassEntity
        </h2>
        <div>
          <div class="form-group" v-if="cassTestServiceClassEntity.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="cassTestServiceClassEntity.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringField')"
              for="cass-test-service-class-entity-stringField"
              >String Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringField"
              id="cass-test-service-class-entity-stringField"
              data-cy="stringField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.stringField.$invalid,
                invalid: $v.cassTestServiceClassEntity.stringField.$invalid,
              }"
              v-model="$v.cassTestServiceClassEntity.stringField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringRequiredField')"
              for="cass-test-service-class-entity-stringRequiredField"
              >String Required Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringRequiredField"
              id="cass-test-service-class-entity-stringRequiredField"
              data-cy="stringRequiredField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.stringRequiredField.$invalid,
                invalid: $v.cassTestServiceClassEntity.stringRequiredField.$invalid,
              }"
              v-model="$v.cassTestServiceClassEntity.stringRequiredField.$model"
              required
            />
            <div
              v-if="
                $v.cassTestServiceClassEntity.stringRequiredField.$anyDirty && $v.cassTestServiceClassEntity.stringRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.stringRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringMinlengthField')"
              for="cass-test-service-class-entity-stringMinlengthField"
              >String Minlength Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMinlengthField"
              id="cass-test-service-class-entity-stringMinlengthField"
              data-cy="stringMinlengthField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.stringMinlengthField.$invalid,
                invalid: $v.cassTestServiceClassEntity.stringMinlengthField.$invalid,
              }"
              v-model="$v.cassTestServiceClassEntity.stringMinlengthField.$model"
            />
            <div
              v-if="
                $v.cassTestServiceClassEntity.stringMinlengthField.$anyDirty && $v.cassTestServiceClassEntity.stringMinlengthField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.stringMinlengthField.minLength"
                v-text="$t('entity.validation.minlength', { min: 0 })"
              >
                This field is required to be at least 0 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringMaxlengthField')"
              for="cass-test-service-class-entity-stringMaxlengthField"
              >String Maxlength Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMaxlengthField"
              id="cass-test-service-class-entity-stringMaxlengthField"
              data-cy="stringMaxlengthField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.stringMaxlengthField.$invalid,
                invalid: $v.cassTestServiceClassEntity.stringMaxlengthField.$invalid,
              }"
              v-model="$v.cassTestServiceClassEntity.stringMaxlengthField.$model"
            />
            <div
              v-if="
                $v.cassTestServiceClassEntity.stringMaxlengthField.$anyDirty && $v.cassTestServiceClassEntity.stringMaxlengthField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.stringMaxlengthField.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringPatternField')"
              for="cass-test-service-class-entity-stringPatternField"
              >String Pattern Field</label
            >
            <input
              type="text"
              class="form-control"
              name="stringPatternField"
              id="cass-test-service-class-entity-stringPatternField"
              data-cy="stringPatternField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.stringPatternField.$invalid,
                invalid: $v.cassTestServiceClassEntity.stringPatternField.$invalid,
              }"
              v-model="$v.cassTestServiceClassEntity.stringPatternField.$model"
            />
            <div
              v-if="$v.cassTestServiceClassEntity.stringPatternField.$anyDirty && $v.cassTestServiceClassEntity.stringPatternField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.stringPatternField.pattern"
                v-text="$t('entity.validation.pattern', { pattern: 'String Pattern Field' })"
              >
                This field should follow pattern for "String Pattern Field".
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerField')"
              for="cass-test-service-class-entity-integerField"
              >Integer Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerField"
              id="cass-test-service-class-entity-integerField"
              data-cy="integerField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.integerField.$invalid,
                invalid: $v.cassTestServiceClassEntity.integerField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.integerField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerRequiredField')"
              for="cass-test-service-class-entity-integerRequiredField"
              >Integer Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerRequiredField"
              id="cass-test-service-class-entity-integerRequiredField"
              data-cy="integerRequiredField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.integerRequiredField.$invalid,
                invalid: $v.cassTestServiceClassEntity.integerRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.integerRequiredField.$model"
              required
            />
            <div
              v-if="
                $v.cassTestServiceClassEntity.integerRequiredField.$anyDirty && $v.cassTestServiceClassEntity.integerRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.integerRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.integerRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerMinField')"
              for="cass-test-service-class-entity-integerMinField"
              >Integer Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMinField"
              id="cass-test-service-class-entity-integerMinField"
              data-cy="integerMinField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.integerMinField.$invalid,
                invalid: $v.cassTestServiceClassEntity.integerMinField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.integerMinField.$model"
            />
            <div v-if="$v.cassTestServiceClassEntity.integerMinField.$anyDirty && $v.cassTestServiceClassEntity.integerMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.integerMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.integerMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerMaxField')"
              for="cass-test-service-class-entity-integerMaxField"
              >Integer Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMaxField"
              id="cass-test-service-class-entity-integerMaxField"
              data-cy="integerMaxField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.integerMaxField.$invalid,
                invalid: $v.cassTestServiceClassEntity.integerMaxField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.integerMaxField.$model"
            />
            <div v-if="$v.cassTestServiceClassEntity.integerMaxField.$anyDirty && $v.cassTestServiceClassEntity.integerMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.integerMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.integerMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.longField')"
              for="cass-test-service-class-entity-longField"
              >Long Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longField"
              id="cass-test-service-class-entity-longField"
              data-cy="longField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.longField.$invalid,
                invalid: $v.cassTestServiceClassEntity.longField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.longField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.longRequiredField')"
              for="cass-test-service-class-entity-longRequiredField"
              >Long Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longRequiredField"
              id="cass-test-service-class-entity-longRequiredField"
              data-cy="longRequiredField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.longRequiredField.$invalid,
                invalid: $v.cassTestServiceClassEntity.longRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.longRequiredField.$model"
              required
            />
            <div
              v-if="$v.cassTestServiceClassEntity.longRequiredField.$anyDirty && $v.cassTestServiceClassEntity.longRequiredField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.longRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.longRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.longMinField')"
              for="cass-test-service-class-entity-longMinField"
              >Long Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longMinField"
              id="cass-test-service-class-entity-longMinField"
              data-cy="longMinField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.longMinField.$invalid,
                invalid: $v.cassTestServiceClassEntity.longMinField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.longMinField.$model"
            />
            <div v-if="$v.cassTestServiceClassEntity.longMinField.$anyDirty && $v.cassTestServiceClassEntity.longMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.longMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.longMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.longMaxField')"
              for="cass-test-service-class-entity-longMaxField"
              >Long Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="longMaxField"
              id="cass-test-service-class-entity-longMaxField"
              data-cy="longMaxField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.longMaxField.$invalid,
                invalid: $v.cassTestServiceClassEntity.longMaxField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.longMaxField.$model"
            />
            <div v-if="$v.cassTestServiceClassEntity.longMaxField.$anyDirty && $v.cassTestServiceClassEntity.longMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.longMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.longMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatField')"
              for="cass-test-service-class-entity-floatField"
              >Float Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatField"
              id="cass-test-service-class-entity-floatField"
              data-cy="floatField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.floatField.$invalid,
                invalid: $v.cassTestServiceClassEntity.floatField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.floatField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatRequiredField')"
              for="cass-test-service-class-entity-floatRequiredField"
              >Float Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatRequiredField"
              id="cass-test-service-class-entity-floatRequiredField"
              data-cy="floatRequiredField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.floatRequiredField.$invalid,
                invalid: $v.cassTestServiceClassEntity.floatRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.floatRequiredField.$model"
              required
            />
            <div
              v-if="$v.cassTestServiceClassEntity.floatRequiredField.$anyDirty && $v.cassTestServiceClassEntity.floatRequiredField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.floatRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.floatRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatMinField')"
              for="cass-test-service-class-entity-floatMinField"
              >Float Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMinField"
              id="cass-test-service-class-entity-floatMinField"
              data-cy="floatMinField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.floatMinField.$invalid,
                invalid: $v.cassTestServiceClassEntity.floatMinField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.floatMinField.$model"
            />
            <div v-if="$v.cassTestServiceClassEntity.floatMinField.$anyDirty && $v.cassTestServiceClassEntity.floatMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.floatMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.floatMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatMaxField')"
              for="cass-test-service-class-entity-floatMaxField"
              >Float Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMaxField"
              id="cass-test-service-class-entity-floatMaxField"
              data-cy="floatMaxField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.floatMaxField.$invalid,
                invalid: $v.cassTestServiceClassEntity.floatMaxField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.floatMaxField.$model"
            />
            <div v-if="$v.cassTestServiceClassEntity.floatMaxField.$anyDirty && $v.cassTestServiceClassEntity.floatMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.floatMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.floatMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.doubleRequiredField')"
              for="cass-test-service-class-entity-doubleRequiredField"
              >Double Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleRequiredField"
              id="cass-test-service-class-entity-doubleRequiredField"
              data-cy="doubleRequiredField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.doubleRequiredField.$invalid,
                invalid: $v.cassTestServiceClassEntity.doubleRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.doubleRequiredField.$model"
              required
            />
            <div
              v-if="
                $v.cassTestServiceClassEntity.doubleRequiredField.$anyDirty && $v.cassTestServiceClassEntity.doubleRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.doubleRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.doubleRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.doubleMinField')"
              for="cass-test-service-class-entity-doubleMinField"
              >Double Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMinField"
              id="cass-test-service-class-entity-doubleMinField"
              data-cy="doubleMinField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.doubleMinField.$invalid,
                invalid: $v.cassTestServiceClassEntity.doubleMinField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.doubleMinField.$model"
            />
            <div v-if="$v.cassTestServiceClassEntity.doubleMinField.$anyDirty && $v.cassTestServiceClassEntity.doubleMinField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.doubleMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.doubleMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.doubleMaxField')"
              for="cass-test-service-class-entity-doubleMaxField"
              >Double Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMaxField"
              id="cass-test-service-class-entity-doubleMaxField"
              data-cy="doubleMaxField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.doubleMaxField.$invalid,
                invalid: $v.cassTestServiceClassEntity.doubleMaxField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.doubleMaxField.$model"
            />
            <div v-if="$v.cassTestServiceClassEntity.doubleMaxField.$anyDirty && $v.cassTestServiceClassEntity.doubleMaxField.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.doubleMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.doubleMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.bigDecimalRequiredField')"
              for="cass-test-service-class-entity-bigDecimalRequiredField"
              >Big Decimal Required Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalRequiredField"
              id="cass-test-service-class-entity-bigDecimalRequiredField"
              data-cy="bigDecimalRequiredField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.bigDecimalRequiredField.$invalid,
                invalid: $v.cassTestServiceClassEntity.bigDecimalRequiredField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.bigDecimalRequiredField.$model"
              required
            />
            <div
              v-if="
                $v.cassTestServiceClassEntity.bigDecimalRequiredField.$anyDirty &&
                $v.cassTestServiceClassEntity.bigDecimalRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.bigDecimalRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.bigDecimalRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.bigDecimalMinField')"
              for="cass-test-service-class-entity-bigDecimalMinField"
              >Big Decimal Min Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMinField"
              id="cass-test-service-class-entity-bigDecimalMinField"
              data-cy="bigDecimalMinField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.bigDecimalMinField.$invalid,
                invalid: $v.cassTestServiceClassEntity.bigDecimalMinField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.bigDecimalMinField.$model"
            />
            <div
              v-if="$v.cassTestServiceClassEntity.bigDecimalMinField.$anyDirty && $v.cassTestServiceClassEntity.bigDecimalMinField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.bigDecimalMinField.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.bigDecimalMinField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.bigDecimalMaxField')"
              for="cass-test-service-class-entity-bigDecimalMaxField"
              >Big Decimal Max Field</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMaxField"
              id="cass-test-service-class-entity-bigDecimalMaxField"
              data-cy="bigDecimalMaxField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.bigDecimalMaxField.$invalid,
                invalid: $v.cassTestServiceClassEntity.bigDecimalMaxField.$invalid,
              }"
              v-model.number="$v.cassTestServiceClassEntity.bigDecimalMaxField.$model"
            />
            <div
              v-if="$v.cassTestServiceClassEntity.bigDecimalMaxField.$anyDirty && $v.cassTestServiceClassEntity.bigDecimalMaxField.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.bigDecimalMaxField.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.bigDecimalMaxField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.localDateField')"
              for="cass-test-service-class-entity-localDateField"
              >Local Date Field</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cass-test-service-class-entity-localDateField"
                  v-model="$v.cassTestServiceClassEntity.localDateField.$model"
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
                id="cass-test-service-class-entity-localDateField"
                data-cy="localDateField"
                type="text"
                class="form-control"
                name="localDateField"
                :class="{
                  valid: !$v.cassTestServiceClassEntity.localDateField.$invalid,
                  invalid: $v.cassTestServiceClassEntity.localDateField.$invalid,
                }"
                v-model="$v.cassTestServiceClassEntity.localDateField.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.localDateRequiredField')"
              for="cass-test-service-class-entity-localDateRequiredField"
              >Local Date Required Field</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="cass-test-service-class-entity-localDateRequiredField"
                  v-model="$v.cassTestServiceClassEntity.localDateRequiredField.$model"
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
                id="cass-test-service-class-entity-localDateRequiredField"
                data-cy="localDateRequiredField"
                type="text"
                class="form-control"
                name="localDateRequiredField"
                :class="{
                  valid: !$v.cassTestServiceClassEntity.localDateRequiredField.$invalid,
                  invalid: $v.cassTestServiceClassEntity.localDateRequiredField.$invalid,
                }"
                v-model="$v.cassTestServiceClassEntity.localDateRequiredField.$model"
                required
              />
            </b-input-group>
            <div
              v-if="
                $v.cassTestServiceClassEntity.localDateRequiredField.$anyDirty &&
                $v.cassTestServiceClassEntity.localDateRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.localDateRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.instantDateField')"
              for="cass-test-service-class-entity-instantDateField"
              >Instant Date Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-service-class-entity-instantDateField"
                data-cy="instantDateField"
                type="datetime-local"
                class="form-control"
                name="instantDateField"
                :class="{
                  valid: !$v.cassTestServiceClassEntity.instantDateField.$invalid,
                  invalid: $v.cassTestServiceClassEntity.instantDateField.$invalid,
                }"
                :value="convertDateTimeFromServer($v.cassTestServiceClassEntity.instantDateField.$model)"
                @change="updateInstantField('instantDateField', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.instantRequiredField')"
              for="cass-test-service-class-entity-instantRequiredField"
              >Instant Required Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-service-class-entity-instantRequiredField"
                data-cy="instantRequiredField"
                type="datetime-local"
                class="form-control"
                name="instantRequiredField"
                :class="{
                  valid: !$v.cassTestServiceClassEntity.instantRequiredField.$invalid,
                  invalid: $v.cassTestServiceClassEntity.instantRequiredField.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.cassTestServiceClassEntity.instantRequiredField.$model)"
                @change="updateInstantField('instantRequiredField', $event)"
              />
            </div>
            <div
              v-if="
                $v.cassTestServiceClassEntity.instantRequiredField.$anyDirty && $v.cassTestServiceClassEntity.instantRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.instantRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.instantRequiredField.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.zonedDateTimeField')"
              for="cass-test-service-class-entity-zonedDateTimeField"
              >Zoned Date Time Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-service-class-entity-zonedDateTimeField"
                data-cy="zonedDateTimeField"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeField"
                :class="{
                  valid: !$v.cassTestServiceClassEntity.zonedDateTimeField.$invalid,
                  invalid: $v.cassTestServiceClassEntity.zonedDateTimeField.$invalid,
                }"
                :value="convertDateTimeFromServer($v.cassTestServiceClassEntity.zonedDateTimeField.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeField', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.zonedDateTimeRequiredField')"
              for="cass-test-service-class-entity-zonedDateTimeRequiredField"
              >Zoned Date Time Required Field</label
            >
            <div class="d-flex">
              <input
                id="cass-test-service-class-entity-zonedDateTimeRequiredField"
                data-cy="zonedDateTimeRequiredField"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeRequiredField"
                :class="{
                  valid: !$v.cassTestServiceClassEntity.zonedDateTimeRequiredField.$invalid,
                  invalid: $v.cassTestServiceClassEntity.zonedDateTimeRequiredField.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.cassTestServiceClassEntity.zonedDateTimeRequiredField.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeRequiredField', $event)"
              />
            </div>
            <div
              v-if="
                $v.cassTestServiceClassEntity.zonedDateTimeRequiredField.$anyDirty &&
                $v.cassTestServiceClassEntity.zonedDateTimeRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.zonedDateTimeRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.zonedDateTimeRequiredField.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.durationDateField')"
              for="cass-test-service-class-entity-durationDateField"
              >Duration Date Field</label
            >
            <input
              type="text"
              class="form-control"
              name="durationDateField"
              id="cass-test-service-class-entity-durationDateField"
              data-cy="durationDateField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.durationDateField.$invalid,
                invalid: $v.cassTestServiceClassEntity.durationDateField.$invalid,
              }"
              v-model="$v.cassTestServiceClassEntity.durationDateField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.durationRequiredField')"
              for="cass-test-service-class-entity-durationRequiredField"
              >Duration Required Field</label
            >
            <input
              type="text"
              class="form-control"
              name="durationRequiredField"
              id="cass-test-service-class-entity-durationRequiredField"
              data-cy="durationRequiredField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.durationRequiredField.$invalid,
                invalid: $v.cassTestServiceClassEntity.durationRequiredField.$invalid,
              }"
              v-model="$v.cassTestServiceClassEntity.durationRequiredField.$model"
              required
            />
            <div
              v-if="
                $v.cassTestServiceClassEntity.durationRequiredField.$anyDirty &&
                $v.cassTestServiceClassEntity.durationRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.durationRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.durationRequiredField.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.booleanField')"
              for="cass-test-service-class-entity-booleanField"
              >Boolean Field</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanField"
              id="cass-test-service-class-entity-booleanField"
              data-cy="booleanField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.booleanField.$invalid,
                invalid: $v.cassTestServiceClassEntity.booleanField.$invalid,
              }"
              v-model="$v.cassTestServiceClassEntity.booleanField.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.booleanRequiredField')"
              for="cass-test-service-class-entity-booleanRequiredField"
              >Boolean Required Field</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanRequiredField"
              id="cass-test-service-class-entity-booleanRequiredField"
              data-cy="booleanRequiredField"
              :class="{
                valid: !$v.cassTestServiceClassEntity.booleanRequiredField.$invalid,
                invalid: $v.cassTestServiceClassEntity.booleanRequiredField.$invalid,
              }"
              v-model="$v.cassTestServiceClassEntity.booleanRequiredField.$model"
              required
            />
            <div
              v-if="
                $v.cassTestServiceClassEntity.booleanRequiredField.$anyDirty && $v.cassTestServiceClassEntity.booleanRequiredField.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.booleanRequiredField.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.enumTom')"
              for="cass-test-service-class-entity-enumTom"
              >Enum Tom</label
            >
            <select
              class="form-control"
              name="enumTom"
              :class="{ valid: !$v.cassTestServiceClassEntity.enumTom.$invalid, invalid: $v.cassTestServiceClassEntity.enumTom.$invalid }"
              v-model="$v.cassTestServiceClassEntity.enumTom.$model"
              id="cass-test-service-class-entity-enumTom"
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
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.enumRequiredTom')"
              for="cass-test-service-class-entity-enumRequiredTom"
              >Enum Required Tom</label
            >
            <select
              class="form-control"
              name="enumRequiredTom"
              :class="{
                valid: !$v.cassTestServiceClassEntity.enumRequiredTom.$invalid,
                invalid: $v.cassTestServiceClassEntity.enumRequiredTom.$invalid,
              }"
              v-model="$v.cassTestServiceClassEntity.enumRequiredTom.$model"
              id="cass-test-service-class-entity-enumRequiredTom"
              data-cy="enumRequiredTom"
              required
            >
              <option value="ENUM_VALUE_1" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_1')">ENUM_VALUE_1</option>
              <option value="ENUM_VALUE_2" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_2')">ENUM_VALUE_2</option>
              <option value="ENUM_VALUE_3" v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.ENUM_VALUE_3')">ENUM_VALUE_3</option>
            </select>
            <div v-if="$v.cassTestServiceClassEntity.enumRequiredTom.$anyDirty && $v.cassTestServiceClassEntity.enumRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.cassTestServiceClassEntity.enumRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.picture')"
              for="cass-test-service-class-entity-picture"
              >Picture</label
            >
            <div>
              <img
                v-bind:src="'data:' + cassTestServiceClassEntity.pictureContentType + ';base64,' + cassTestServiceClassEntity.picture"
                style="max-height: 100px"
                v-if="cassTestServiceClassEntity.picture"
                alt="cassTestServiceClassEntity image"
              />
              <div v-if="cassTestServiceClassEntity.picture" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ cassTestServiceClassEntity.pictureContentType }}, {{ byteSize(cassTestServiceClassEntity.picture) }}</span
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
                v-on:change="setFileData($event, cassTestServiceClassEntity, 'picture', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="picture"
              id="cass-test-service-class-entity-picture"
              data-cy="picture"
              :class="{ valid: !$v.cassTestServiceClassEntity.picture.$invalid, invalid: $v.cassTestServiceClassEntity.picture.$invalid }"
              v-model="$v.cassTestServiceClassEntity.picture.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="pictureContentType"
              id="cass-test-service-class-entity-pictureContentType"
              v-model="cassTestServiceClassEntity.pictureContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.cassTestServiceClassEntity.operationsFile')"
              for="cass-test-service-class-entity-operationsFile"
              >Operations File</label
            >
            <div>
              <div v-if="cassTestServiceClassEntity.operationsFile" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ cassTestServiceClassEntity.operationsFileContentType }},
                  {{ byteSize(cassTestServiceClassEntity.operationsFile) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    cassTestServiceClassEntity.operationsFile = null;
                    cassTestServiceClassEntity.operationsFileContentType = null;
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
                v-on:change="setFileData($event, cassTestServiceClassEntity, 'operationsFile', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="operationsFile"
              id="cass-test-service-class-entity-operationsFile"
              data-cy="operationsFile"
              :class="{
                valid: !$v.cassTestServiceClassEntity.operationsFile.$invalid,
                invalid: $v.cassTestServiceClassEntity.operationsFile.$invalid,
              }"
              v-model="$v.cassTestServiceClassEntity.operationsFile.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="operationsFileContentType"
              id="cass-test-service-class-entity-operationsFileContentType"
              v-model="cassTestServiceClassEntity.operationsFileContentType"
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
            :disabled="$v.cassTestServiceClassEntity.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./cass-test-service-class-entity-update.component.ts"></script>
