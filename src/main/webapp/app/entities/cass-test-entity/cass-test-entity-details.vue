<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="cassTestEntity">
        <h2 class="jh-entity-heading" data-cy="cassTestEntityDetailsHeading">
          <span v-text="$t('jhipsterApp.cassTestEntity.detail.title')">CassTestEntity</span> {{ cassTestEntity.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.stringField')">String Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.stringField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.stringRequiredField')">String Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.stringRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.stringMinlengthField')">String Minlength Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.stringMinlengthField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.stringMaxlengthField')">String Maxlength Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.stringMaxlengthField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.stringPatternField')">String Pattern Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.stringPatternField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.integerField')">Integer Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.integerField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.integerRequiredField')">Integer Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.integerRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.integerMinField')">Integer Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.integerMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.integerMaxField')">Integer Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.integerMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.longField')">Long Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.longField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.longRequiredField')">Long Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.longRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.longMinField')">Long Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.longMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.longMaxField')">Long Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.longMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.floatField')">Float Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.floatField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.floatRequiredField')">Float Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.floatRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.floatMinField')">Float Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.floatMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.floatMaxField')">Float Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.floatMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.doubleRequiredField')">Double Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.doubleRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.doubleMinField')">Double Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.doubleMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.doubleMaxField')">Double Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.doubleMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.bigDecimalRequiredField')">Big Decimal Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.bigDecimalRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.bigDecimalMinField')">Big Decimal Min Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.bigDecimalMinField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.bigDecimalMaxField')">Big Decimal Max Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.bigDecimalMaxField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.localDateField')">Local Date Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.localDateField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.localDateRequiredField')">Local Date Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.localDateRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.instantDateField')">Instant Date Field</span>
          </dt>
          <dd>
            <span v-if="cassTestEntity.instantDateField">{{ $d(Date.parse(cassTestEntity.instantDateField), 'long') }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.instantRequiredField')">Instant Required Field</span>
          </dt>
          <dd>
            <span v-if="cassTestEntity.instantRequiredField">{{ $d(Date.parse(cassTestEntity.instantRequiredField), 'long') }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.zonedDateTimeField')">Zoned Date Time Field</span>
          </dt>
          <dd>
            <span v-if="cassTestEntity.zonedDateTimeField">{{ $d(Date.parse(cassTestEntity.zonedDateTimeField), 'long') }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.zonedDateTimeRequiredField')">Zoned Date Time Required Field</span>
          </dt>
          <dd>
            <span v-if="cassTestEntity.zonedDateTimeRequiredField">{{
              $d(Date.parse(cassTestEntity.zonedDateTimeRequiredField), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.durationDateField')">Duration Date Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.durationDateField | duration }} ({{ cassTestEntity.durationDateField }})</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.durationRequiredField')">Duration Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.durationRequiredField | duration }} ({{ cassTestEntity.durationRequiredField }})</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.booleanField')">Boolean Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.booleanField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.booleanRequiredField')">Boolean Required Field</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.booleanRequiredField }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.enumTom')">Enum Tom</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumFieldClass.' + cassTestEntity.enumTom)">{{ cassTestEntity.enumTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.enumRequiredTom')">Enum Required Tom</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + cassTestEntity.enumRequiredTom)">{{
              cassTestEntity.enumRequiredTom
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.picture')">Picture</span>
          </dt>
          <dd>
            <div v-if="cassTestEntity.picture">
              <a v-on:click="openFile(cassTestEntity.pictureContentType, cassTestEntity.picture)">
                <img
                  v-bind:src="'data:' + cassTestEntity.pictureContentType + ';base64,' + cassTestEntity.picture"
                  style="max-width: 100%"
                  alt="cassTestEntity image"
                />
              </a>
              {{ cassTestEntity.pictureContentType }}, {{ byteSize(cassTestEntity.picture) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.cassTestEntity.operationsFile')">Operations File</span>
          </dt>
          <dd>
            <span>{{ cassTestEntity.operationsFile }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="cassTestEntity.id"
          :to="{ name: 'CassTestEntityEdit', params: { cassTestEntityId: cassTestEntity.id } }"
          tag="button"
          class="btn btn-primary"
        >
          <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./cass-test-entity-details.component.ts"></script>
