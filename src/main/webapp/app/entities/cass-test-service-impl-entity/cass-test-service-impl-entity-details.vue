<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cassTestServiceImplEntity">
        <h2 class="jh-entity-heading" data-cy="cassTestServiceImplEntityDetailsHeading">
          <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.detail.title')">CassTestServiceImplEntity</span>
          {{ cassTestServiceImplEntity.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringField')">String Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.stringField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringRequiredField')">String Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.stringRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringMinlengthField')">String Minlength Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.stringMinlengthField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringMaxlengthField')">String Maxlength Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.stringMaxlengthField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.stringPatternField')">String Pattern Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.stringPatternField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerField')">Integer Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.integerField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerRequiredField')">Integer Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.integerRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerMinField')">Integer Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.integerMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.integerMaxField')">Integer Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.integerMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.longField')">Long Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.longField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.longRequiredField')">Long Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.longRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.longMinField')">Long Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.longMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.longMaxField')">Long Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.longMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatField')">Float Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.floatField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatRequiredField')">Float Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.floatRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatMinField')">Float Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.floatMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.floatMaxField')">Float Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.floatMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.doubleRequiredField')">Double Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.doubleRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.doubleMinField')">Double Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.doubleMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.doubleMaxField')">Double Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.doubleMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.bigDecimalRequiredField')">Big Decimal Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.bigDecimalRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.bigDecimalMinField')">Big Decimal Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.bigDecimalMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.bigDecimalMaxField')">Big Decimal Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.bigDecimalMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.localDateField')">Local Date Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.localDateField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.localDateRequiredField')">Local Date Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.localDateRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.instantDateField')">Instant Date Field</span>
          </dt>
          <dd>
            <span v-if="cassTestServiceImplEntity.instantDateField">{{
              $d(Date.parse(cassTestServiceImplEntity.instantDateField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.instantRequiredField')">Instant Required Field</span>
          </dt>
          <dd>
            <span v-if="cassTestServiceImplEntity.instantRequiredField">{{
              $d(Date.parse(cassTestServiceImplEntity.instantRequiredField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.zonedDateTimeField')">Zoned Date Time Field</span>
          </dt>
          <dd>
            <span v-if="cassTestServiceImplEntity.zonedDateTimeField">{{
              $d(Date.parse(cassTestServiceImplEntity.zonedDateTimeField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.zonedDateTimeRequiredField')">Zoned Date Time Required Field</span>
          </dt>
          <dd>
            <span v-if="cassTestServiceImplEntity.zonedDateTimeRequiredField">{{
              $d(Date.parse(cassTestServiceImplEntity.zonedDateTimeRequiredField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.durationDateField')">Duration Date Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.durationDateField | duration }} ({{ cassTestServiceImplEntity.durationDateField }})</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.durationRequiredField')">Duration Required Field</span>
          </dt>
          <dd>
            <span
              >{{ cassTestServiceImplEntity.durationRequiredField | duration }} ({{
                cassTestServiceImplEntity.durationRequiredField
              }})</span
            >
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.booleanField')">Boolean Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.booleanField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.booleanRequiredField')">Boolean Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.booleanRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.enumTom')">Enum Tom</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumFieldClass.' + cassTestServiceImplEntity.enumTom)">{{
              cassTestServiceImplEntity.enumTom
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.enumRequiredTom')">Enum Required Tom</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + cassTestServiceImplEntity.enumRequiredTom)">{{
              cassTestServiceImplEntity.enumRequiredTom
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.picture')">Picture</span>
          </dt>
          <dd>
            <div v-if="cassTestServiceImplEntity.picture">
              <a v-on:click="openFile(cassTestServiceImplEntity.pictureContentType, cassTestServiceImplEntity.picture)">
                <img
                  v-bind:src="'data:' + cassTestServiceImplEntity.pictureContentType + ';base64,' + cassTestServiceImplEntity.picture"
                  style="max-width: 100%"
                  alt="cassTestServiceImplEntity image"
                />
              </a>
              {{ cassTestServiceImplEntity.pictureContentType }}, {{ byteSize(cassTestServiceImplEntity.picture) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceImplEntity.operationsFile')">Operations File</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceImplEntity.operationsFile }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="cassTestServiceImplEntity.id"
          :to="{ name: 'CassTestServiceImplEntityEdit', params: { cassTestServiceImplEntityId: cassTestServiceImplEntity.id } }"
          tag="button"
          class="btn btn-primary"
        >
          <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cass-test-service-impl-entity-details.component.ts"></script>
