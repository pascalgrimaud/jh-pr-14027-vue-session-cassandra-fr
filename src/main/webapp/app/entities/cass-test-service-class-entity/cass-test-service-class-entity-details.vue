<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cassTestServiceClassEntity">
        <h2 class="jh-entity-heading" data-cy="cassTestServiceClassEntityDetailsHeading">
          <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.detail.title')">CassTestServiceClassEntity</span>
          {{ cassTestServiceClassEntity.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringField')">String Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.stringField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringRequiredField')">String Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.stringRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringMinlengthField')">String Minlength Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.stringMinlengthField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringMaxlengthField')">String Maxlength Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.stringMaxlengthField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.stringPatternField')">String Pattern Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.stringPatternField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerField')">Integer Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.integerField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerRequiredField')">Integer Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.integerRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerMinField')">Integer Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.integerMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.integerMaxField')">Integer Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.integerMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.longField')">Long Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.longField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.longRequiredField')">Long Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.longRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.longMinField')">Long Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.longMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.longMaxField')">Long Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.longMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatField')">Float Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.floatField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatRequiredField')">Float Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.floatRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatMinField')">Float Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.floatMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.floatMaxField')">Float Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.floatMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.doubleRequiredField')">Double Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.doubleRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.doubleMinField')">Double Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.doubleMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.doubleMaxField')">Double Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.doubleMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.bigDecimalRequiredField')">Big Decimal Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.bigDecimalRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.bigDecimalMinField')">Big Decimal Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.bigDecimalMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.bigDecimalMaxField')">Big Decimal Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.bigDecimalMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.localDateField')">Local Date Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.localDateField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.localDateRequiredField')">Local Date Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.localDateRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.instantDateField')">Instant Date Field</span>
          </dt>
          <dd>
            <span v-if="cassTestServiceClassEntity.instantDateField">{{
              $d(Date.parse(cassTestServiceClassEntity.instantDateField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.instantRequiredField')">Instant Required Field</span>
          </dt>
          <dd>
            <span v-if="cassTestServiceClassEntity.instantRequiredField">{{
              $d(Date.parse(cassTestServiceClassEntity.instantRequiredField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.zonedDateTimeField')">Zoned Date Time Field</span>
          </dt>
          <dd>
            <span v-if="cassTestServiceClassEntity.zonedDateTimeField">{{
              $d(Date.parse(cassTestServiceClassEntity.zonedDateTimeField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.zonedDateTimeRequiredField')">Zoned Date Time Required Field</span>
          </dt>
          <dd>
            <span v-if="cassTestServiceClassEntity.zonedDateTimeRequiredField">{{
              $d(Date.parse(cassTestServiceClassEntity.zonedDateTimeRequiredField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.durationDateField')">Duration Date Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.durationDateField | duration }} ({{ cassTestServiceClassEntity.durationDateField }})</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.durationRequiredField')">Duration Required Field</span>
          </dt>
          <dd>
            <span
              >{{ cassTestServiceClassEntity.durationRequiredField | duration }} ({{
                cassTestServiceClassEntity.durationRequiredField
              }})</span
            >
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.booleanField')">Boolean Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.booleanField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.booleanRequiredField')">Boolean Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.booleanRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.enumTom')">Enum Tom</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumFieldClass.' + cassTestServiceClassEntity.enumTom)">{{
              cassTestServiceClassEntity.enumTom
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.enumRequiredTom')">Enum Required Tom</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + cassTestServiceClassEntity.enumRequiredTom)">{{
              cassTestServiceClassEntity.enumRequiredTom
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.picture')">Picture</span>
          </dt>
          <dd>
            <div v-if="cassTestServiceClassEntity.picture">
              <a v-on:click="openFile(cassTestServiceClassEntity.pictureContentType, cassTestServiceClassEntity.picture)">
                <img
                  v-bind:src="'data:' + cassTestServiceClassEntity.pictureContentType + ';base64,' + cassTestServiceClassEntity.picture"
                  style="max-width: 100%"
                  alt="cassTestServiceClassEntity image"
                />
              </a>
              {{ cassTestServiceClassEntity.pictureContentType }}, {{ byteSize(cassTestServiceClassEntity.picture) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestServiceClassEntity.operationsFile')">Operations File</span>
          </dt>
          <dd>
            <span>{{ cassTestServiceClassEntity.operationsFile }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="cassTestServiceClassEntity.id"
          :to="{ name: 'CassTestServiceClassEntityEdit', params: { cassTestServiceClassEntityId: cassTestServiceClassEntity.id } }"
          tag="button"
          class="btn btn-primary"
        >
          <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cass-test-service-class-entity-details.component.ts"></script>
