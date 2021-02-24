<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cassTestMapstructEntity">
        <h2 class="jh-entity-heading" data-cy="cassTestMapstructEntityDetailsHeading">
          <span v-text="$t('jhipsterApp.cassTestMapstructEntity.detail.title')">CassTestMapstructEntity</span>
          {{ cassTestMapstructEntity.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.stringField')">String Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.stringField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.stringRequiredField')">String Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.stringRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.stringMinlengthField')">String Minlength Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.stringMinlengthField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.stringMaxlengthField')">String Maxlength Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.stringMaxlengthField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.stringPatternField')">String Pattern Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.stringPatternField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.integerField')">Integer Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.integerField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.integerRequiredField')">Integer Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.integerRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.integerMinField')">Integer Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.integerMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.integerMaxField')">Integer Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.integerMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.longField')">Long Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.longField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.longRequiredField')">Long Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.longRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.longMinField')">Long Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.longMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.longMaxField')">Long Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.longMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.floatField')">Float Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.floatField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.floatRequiredField')">Float Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.floatRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.floatMinField')">Float Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.floatMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.floatMaxField')">Float Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.floatMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.doubleRequiredField')">Double Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.doubleRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.doubleMinField')">Double Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.doubleMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.doubleMaxField')">Double Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.doubleMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.bigDecimalRequiredField')">Big Decimal Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.bigDecimalRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.bigDecimalMinField')">Big Decimal Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.bigDecimalMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.bigDecimalMaxField')">Big Decimal Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.bigDecimalMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.localDateField')">Local Date Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.localDateField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.localDateRequiredField')">Local Date Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.localDateRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.instantDateField')">Instant Date Field</span>
          </dt>
          <dd>
            <span v-if="cassTestMapstructEntity.instantDateField">{{
              $d(Date.parse(cassTestMapstructEntity.instantDateField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.instantRequiredField')">Instant Required Field</span>
          </dt>
          <dd>
            <span v-if="cassTestMapstructEntity.instantRequiredField">{{
              $d(Date.parse(cassTestMapstructEntity.instantRequiredField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.zonedDateTimeField')">Zoned Date Time Field</span>
          </dt>
          <dd>
            <span v-if="cassTestMapstructEntity.zonedDateTimeField">{{
              $d(Date.parse(cassTestMapstructEntity.zonedDateTimeField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.zonedDateTimeRequiredField')">Zoned Date Time Required Field</span>
          </dt>
          <dd>
            <span v-if="cassTestMapstructEntity.zonedDateTimeRequiredField">{{
              $d(Date.parse(cassTestMapstructEntity.zonedDateTimeRequiredField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.durationDateField')">Duration Date Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.durationDateField | duration }} ({{ cassTestMapstructEntity.durationDateField }})</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.durationRequiredField')">Duration Required Field</span>
          </dt>
          <dd>
            <span
              >{{ cassTestMapstructEntity.durationRequiredField | duration }} ({{ cassTestMapstructEntity.durationRequiredField }})</span
            >
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.booleanField')">Boolean Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.booleanField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.booleanRequiredField')">Boolean Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.booleanRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.enumTom')">Enum Tom</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumFieldClass.' + cassTestMapstructEntity.enumTom)">{{ cassTestMapstructEntity.enumTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.enumRequiredTom')">Enum Required Tom</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + cassTestMapstructEntity.enumRequiredTom)">{{
              cassTestMapstructEntity.enumRequiredTom
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.picture')">Picture</span>
          </dt>
          <dd>
            <div v-if="cassTestMapstructEntity.picture">
              <a v-on:click="openFile(cassTestMapstructEntity.pictureContentType, cassTestMapstructEntity.picture)">
                <img
                  v-bind:src="'data:' + cassTestMapstructEntity.pictureContentType + ';base64,' + cassTestMapstructEntity.picture"
                  style="max-width: 100%"
                  alt="cassTestMapstructEntity image"
                />
              </a>
              {{ cassTestMapstructEntity.pictureContentType }}, {{ byteSize(cassTestMapstructEntity.picture) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestMapstructEntity.operationsFile')">Operations File</span>
          </dt>
          <dd>
            <span>{{ cassTestMapstructEntity.operationsFile }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="cassTestMapstructEntity.id"
          :to="{ name: 'CassTestMapstructEntityEdit', params: { cassTestMapstructEntityId: cassTestMapstructEntity.id } }"
          tag="button"
          class="btn btn-primary"
        >
          <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cass-test-mapstruct-entity-details.component.ts"></script>
