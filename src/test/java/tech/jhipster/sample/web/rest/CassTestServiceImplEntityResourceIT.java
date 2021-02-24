package tech.jhipster.sample.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static tech.jhipster.sample.web.rest.TestUtil.sameInstant;
import static tech.jhipster.sample.web.rest.TestUtil.sameNumber;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;
import tech.jhipster.sample.AbstractCassandraTest;
import tech.jhipster.sample.IntegrationTest;
import tech.jhipster.sample.domain.CassTestServiceImplEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.repository.CassTestServiceImplEntityRepository;

/**
 * Integration tests for the {@link CassTestServiceImplEntityResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CassTestServiceImplEntityResourceIT extends AbstractCassandraTest {

    private static final String DEFAULT_STRING_FIELD = "AAAAAAAAAA";
    private static final String UPDATED_STRING_FIELD = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_REQUIRED_FIELD = "AAAAAAAAAA";
    private static final String UPDATED_STRING_REQUIRED_FIELD = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_MINLENGTH_FIELD = "AAAAAAAAAA";
    private static final String UPDATED_STRING_MINLENGTH_FIELD = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_MAXLENGTH_FIELD = "AAAAAAAAAA";
    private static final String UPDATED_STRING_MAXLENGTH_FIELD = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_PATTERN_FIELD = "AAAAAAAAAA";
    private static final String UPDATED_STRING_PATTERN_FIELD = "BBBBBBBBBB";

    private static final Integer DEFAULT_INTEGER_FIELD = 1;
    private static final Integer UPDATED_INTEGER_FIELD = 2;

    private static final Integer DEFAULT_INTEGER_REQUIRED_FIELD = 1;
    private static final Integer UPDATED_INTEGER_REQUIRED_FIELD = 2;

    private static final Integer DEFAULT_INTEGER_MIN_FIELD = 0;
    private static final Integer UPDATED_INTEGER_MIN_FIELD = 1;

    private static final Integer DEFAULT_INTEGER_MAX_FIELD = 100;
    private static final Integer UPDATED_INTEGER_MAX_FIELD = 99;

    private static final Long DEFAULT_LONG_FIELD = 1L;
    private static final Long UPDATED_LONG_FIELD = 2L;

    private static final Long DEFAULT_LONG_REQUIRED_FIELD = 1L;
    private static final Long UPDATED_LONG_REQUIRED_FIELD = 2L;

    private static final Long DEFAULT_LONG_MIN_FIELD = 0L;
    private static final Long UPDATED_LONG_MIN_FIELD = 1L;

    private static final Long DEFAULT_LONG_MAX_FIELD = 100L;
    private static final Long UPDATED_LONG_MAX_FIELD = 99L;

    private static final Float DEFAULT_FLOAT_FIELD = 1F;
    private static final Float UPDATED_FLOAT_FIELD = 2F;

    private static final Float DEFAULT_FLOAT_REQUIRED_FIELD = 1F;
    private static final Float UPDATED_FLOAT_REQUIRED_FIELD = 2F;

    private static final Float DEFAULT_FLOAT_MIN_FIELD = 0F;
    private static final Float UPDATED_FLOAT_MIN_FIELD = 1F;

    private static final Float DEFAULT_FLOAT_MAX_FIELD = 100F;
    private static final Float UPDATED_FLOAT_MAX_FIELD = 99F;

    private static final Double DEFAULT_DOUBLE_REQUIRED_FIELD = 1D;
    private static final Double UPDATED_DOUBLE_REQUIRED_FIELD = 2D;

    private static final Double DEFAULT_DOUBLE_MIN_FIELD = 0D;
    private static final Double UPDATED_DOUBLE_MIN_FIELD = 1D;

    private static final Double DEFAULT_DOUBLE_MAX_FIELD = 100D;
    private static final Double UPDATED_DOUBLE_MAX_FIELD = 99D;

    private static final BigDecimal DEFAULT_BIG_DECIMAL_REQUIRED_FIELD = new BigDecimal(1);
    private static final BigDecimal UPDATED_BIG_DECIMAL_REQUIRED_FIELD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BIG_DECIMAL_MIN_FIELD = new BigDecimal(0);
    private static final BigDecimal UPDATED_BIG_DECIMAL_MIN_FIELD = new BigDecimal(1);

    private static final BigDecimal DEFAULT_BIG_DECIMAL_MAX_FIELD = new BigDecimal(100);
    private static final BigDecimal UPDATED_BIG_DECIMAL_MAX_FIELD = new BigDecimal(99);

    private static final LocalDate DEFAULT_LOCAL_DATE_FIELD = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOCAL_DATE_FIELD = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_LOCAL_DATE_REQUIRED_FIELD = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOCAL_DATE_REQUIRED_FIELD = LocalDate.now(ZoneId.systemDefault());

    private static final Instant DEFAULT_INSTANT_DATE_FIELD = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSTANT_DATE_FIELD = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_INSTANT_REQUIRED_FIELD = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSTANT_REQUIRED_FIELD = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final ZonedDateTime DEFAULT_ZONED_DATE_TIME_FIELD = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_ZONED_DATE_TIME_FIELD = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Duration DEFAULT_DURATION_DATE_FIELD = Duration.ofHours(6);
    private static final Duration UPDATED_DURATION_DATE_FIELD = Duration.ofHours(12);

    private static final Duration DEFAULT_DURATION_REQUIRED_FIELD = Duration.ofHours(6);
    private static final Duration UPDATED_DURATION_REQUIRED_FIELD = Duration.ofHours(12);

    private static final Boolean DEFAULT_BOOLEAN_FIELD = false;
    private static final Boolean UPDATED_BOOLEAN_FIELD = true;

    private static final Boolean DEFAULT_BOOLEAN_REQUIRED_FIELD = false;
    private static final Boolean UPDATED_BOOLEAN_REQUIRED_FIELD = true;

    private static final EnumFieldClass DEFAULT_ENUM_TOM = EnumFieldClass.ENUM_VALUE_1;
    private static final EnumFieldClass UPDATED_ENUM_TOM = EnumFieldClass.ENUM_VALUE_2;

    private static final EnumRequiredFieldClass DEFAULT_ENUM_REQUIRED_TOM = EnumRequiredFieldClass.ENUM_VALUE_1;
    private static final EnumRequiredFieldClass UPDATED_ENUM_REQUIRED_TOM = EnumRequiredFieldClass.ENUM_VALUE_2;

    private static final ByteBuffer DEFAULT_PICTURE = ByteBuffer.wrap(TestUtil.createByteArray(1, "0"));
    private static final ByteBuffer UPDATED_PICTURE = ByteBuffer.wrap(TestUtil.createByteArray(1, "1"));
    private static final String DEFAULT_PICTURE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_PICTURE_CONTENT_TYPE = "image/png";

    private static final ByteBuffer DEFAULT_OPERATIONS_FILE = ByteBuffer.wrap(TestUtil.createByteArray(1, "0"));
    private static final ByteBuffer UPDATED_OPERATIONS_FILE = ByteBuffer.wrap(TestUtil.createByteArray(1, "1"));
    private static final String DEFAULT_OPERATIONS_FILE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OPERATIONS_FILE_CONTENT_TYPE = "image/png";

    @Autowired
    private CassTestServiceImplEntityRepository cassTestServiceImplEntityRepository;

    @Autowired
    private MockMvc restCassTestServiceImplEntityMockMvc;

    private CassTestServiceImplEntity cassTestServiceImplEntity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CassTestServiceImplEntity createEntity() {
        CassTestServiceImplEntity cassTestServiceImplEntity = new CassTestServiceImplEntity()
            .stringField(DEFAULT_STRING_FIELD)
            .stringRequiredField(DEFAULT_STRING_REQUIRED_FIELD)
            .stringMinlengthField(DEFAULT_STRING_MINLENGTH_FIELD)
            .stringMaxlengthField(DEFAULT_STRING_MAXLENGTH_FIELD)
            .stringPatternField(DEFAULT_STRING_PATTERN_FIELD)
            .integerField(DEFAULT_INTEGER_FIELD)
            .integerRequiredField(DEFAULT_INTEGER_REQUIRED_FIELD)
            .integerMinField(DEFAULT_INTEGER_MIN_FIELD)
            .integerMaxField(DEFAULT_INTEGER_MAX_FIELD)
            .longField(DEFAULT_LONG_FIELD)
            .longRequiredField(DEFAULT_LONG_REQUIRED_FIELD)
            .longMinField(DEFAULT_LONG_MIN_FIELD)
            .longMaxField(DEFAULT_LONG_MAX_FIELD)
            .floatField(DEFAULT_FLOAT_FIELD)
            .floatRequiredField(DEFAULT_FLOAT_REQUIRED_FIELD)
            .floatMinField(DEFAULT_FLOAT_MIN_FIELD)
            .floatMaxField(DEFAULT_FLOAT_MAX_FIELD)
            .doubleRequiredField(DEFAULT_DOUBLE_REQUIRED_FIELD)
            .doubleMinField(DEFAULT_DOUBLE_MIN_FIELD)
            .doubleMaxField(DEFAULT_DOUBLE_MAX_FIELD)
            .bigDecimalRequiredField(DEFAULT_BIG_DECIMAL_REQUIRED_FIELD)
            .bigDecimalMinField(DEFAULT_BIG_DECIMAL_MIN_FIELD)
            .bigDecimalMaxField(DEFAULT_BIG_DECIMAL_MAX_FIELD)
            .localDateField(DEFAULT_LOCAL_DATE_FIELD)
            .localDateRequiredField(DEFAULT_LOCAL_DATE_REQUIRED_FIELD)
            .instantDateField(DEFAULT_INSTANT_DATE_FIELD)
            .instantRequiredField(DEFAULT_INSTANT_REQUIRED_FIELD)
            .zonedDateTimeField(DEFAULT_ZONED_DATE_TIME_FIELD)
            .zonedDateTimeRequiredField(DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD)
            .durationDateField(DEFAULT_DURATION_DATE_FIELD)
            .durationRequiredField(DEFAULT_DURATION_REQUIRED_FIELD)
            .booleanField(DEFAULT_BOOLEAN_FIELD)
            .booleanRequiredField(DEFAULT_BOOLEAN_REQUIRED_FIELD)
            .enumTom(DEFAULT_ENUM_TOM)
            .enumRequiredTom(DEFAULT_ENUM_REQUIRED_TOM)
            .picture(DEFAULT_PICTURE)
            .pictureContentType(DEFAULT_PICTURE_CONTENT_TYPE)
            .operationsFile(DEFAULT_OPERATIONS_FILE)
            .operationsFileContentType(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE);
        return cassTestServiceImplEntity;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CassTestServiceImplEntity createUpdatedEntity() {
        CassTestServiceImplEntity cassTestServiceImplEntity = new CassTestServiceImplEntity()
            .stringField(UPDATED_STRING_FIELD)
            .stringRequiredField(UPDATED_STRING_REQUIRED_FIELD)
            .stringMinlengthField(UPDATED_STRING_MINLENGTH_FIELD)
            .stringMaxlengthField(UPDATED_STRING_MAXLENGTH_FIELD)
            .stringPatternField(UPDATED_STRING_PATTERN_FIELD)
            .integerField(UPDATED_INTEGER_FIELD)
            .integerRequiredField(UPDATED_INTEGER_REQUIRED_FIELD)
            .integerMinField(UPDATED_INTEGER_MIN_FIELD)
            .integerMaxField(UPDATED_INTEGER_MAX_FIELD)
            .longField(UPDATED_LONG_FIELD)
            .longRequiredField(UPDATED_LONG_REQUIRED_FIELD)
            .longMinField(UPDATED_LONG_MIN_FIELD)
            .longMaxField(UPDATED_LONG_MAX_FIELD)
            .floatField(UPDATED_FLOAT_FIELD)
            .floatRequiredField(UPDATED_FLOAT_REQUIRED_FIELD)
            .floatMinField(UPDATED_FLOAT_MIN_FIELD)
            .floatMaxField(UPDATED_FLOAT_MAX_FIELD)
            .doubleRequiredField(UPDATED_DOUBLE_REQUIRED_FIELD)
            .doubleMinField(UPDATED_DOUBLE_MIN_FIELD)
            .doubleMaxField(UPDATED_DOUBLE_MAX_FIELD)
            .bigDecimalRequiredField(UPDATED_BIG_DECIMAL_REQUIRED_FIELD)
            .bigDecimalMinField(UPDATED_BIG_DECIMAL_MIN_FIELD)
            .bigDecimalMaxField(UPDATED_BIG_DECIMAL_MAX_FIELD)
            .localDateField(UPDATED_LOCAL_DATE_FIELD)
            .localDateRequiredField(UPDATED_LOCAL_DATE_REQUIRED_FIELD)
            .instantDateField(UPDATED_INSTANT_DATE_FIELD)
            .instantRequiredField(UPDATED_INSTANT_REQUIRED_FIELD)
            .zonedDateTimeField(UPDATED_ZONED_DATE_TIME_FIELD)
            .zonedDateTimeRequiredField(UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD)
            .durationDateField(UPDATED_DURATION_DATE_FIELD)
            .durationRequiredField(UPDATED_DURATION_REQUIRED_FIELD)
            .booleanField(UPDATED_BOOLEAN_FIELD)
            .booleanRequiredField(UPDATED_BOOLEAN_REQUIRED_FIELD)
            .enumTom(UPDATED_ENUM_TOM)
            .enumRequiredTom(UPDATED_ENUM_REQUIRED_TOM)
            .picture(UPDATED_PICTURE)
            .pictureContentType(UPDATED_PICTURE_CONTENT_TYPE)
            .operationsFile(UPDATED_OPERATIONS_FILE)
            .operationsFileContentType(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
        return cassTestServiceImplEntity;
    }

    @BeforeEach
    public void initTest() {
        cassTestServiceImplEntityRepository.deleteAll();
        cassTestServiceImplEntity = createEntity();
    }

    @Test
    void createCassTestServiceImplEntity() throws Exception {
        int databaseSizeBeforeCreate = cassTestServiceImplEntityRepository.findAll().size();
        // Create the CassTestServiceImplEntity
        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isCreated());

        // Validate the CassTestServiceImplEntity in the database
        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeCreate + 1);
        CassTestServiceImplEntity testCassTestServiceImplEntity = cassTestServiceImplEntityList.get(
            cassTestServiceImplEntityList.size() - 1
        );
        assertThat(testCassTestServiceImplEntity.getStringField()).isEqualTo(DEFAULT_STRING_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringRequiredField()).isEqualTo(DEFAULT_STRING_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringMinlengthField()).isEqualTo(DEFAULT_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringMaxlengthField()).isEqualTo(DEFAULT_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringPatternField()).isEqualTo(DEFAULT_STRING_PATTERN_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerField()).isEqualTo(DEFAULT_INTEGER_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerRequiredField()).isEqualTo(DEFAULT_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerMinField()).isEqualTo(DEFAULT_INTEGER_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerMaxField()).isEqualTo(DEFAULT_INTEGER_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongField()).isEqualTo(DEFAULT_LONG_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongRequiredField()).isEqualTo(DEFAULT_LONG_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongMinField()).isEqualTo(DEFAULT_LONG_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongMaxField()).isEqualTo(DEFAULT_LONG_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatField()).isEqualTo(DEFAULT_FLOAT_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatRequiredField()).isEqualTo(DEFAULT_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatMinField()).isEqualTo(DEFAULT_FLOAT_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatMaxField()).isEqualTo(DEFAULT_FLOAT_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleRequiredField()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleMinField()).isEqualTo(DEFAULT_DOUBLE_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleMaxField()).isEqualTo(DEFAULT_DOUBLE_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalRequiredField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalMinField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalMaxField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getLocalDateField()).isEqualTo(DEFAULT_LOCAL_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getLocalDateRequiredField()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getInstantDateField()).isEqualTo(DEFAULT_INSTANT_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getInstantRequiredField()).isEqualTo(DEFAULT_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getZonedDateTimeField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestServiceImplEntity.getZonedDateTimeRequiredField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getDurationDateField()).isEqualTo(DEFAULT_DURATION_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getDurationRequiredField()).isEqualTo(DEFAULT_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getBooleanField()).isEqualTo(DEFAULT_BOOLEAN_FIELD);
        assertThat(testCassTestServiceImplEntity.getBooleanRequiredField()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getEnumTom()).isEqualTo(DEFAULT_ENUM_TOM);
        assertThat(testCassTestServiceImplEntity.getEnumRequiredTom()).isEqualTo(DEFAULT_ENUM_REQUIRED_TOM);
        assertThat(testCassTestServiceImplEntity.getPicture()).isEqualTo(DEFAULT_PICTURE);
        assertThat(testCassTestServiceImplEntity.getPictureContentType()).isEqualTo(DEFAULT_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestServiceImplEntity.getOperationsFile()).isEqualTo(DEFAULT_OPERATIONS_FILE);
        assertThat(testCassTestServiceImplEntity.getOperationsFileContentType()).isEqualTo(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void createCassTestServiceImplEntityWithExistingId() throws Exception {
        // Create the CassTestServiceImplEntity with an existing ID
        cassTestServiceImplEntity.setId(UUID.randomUUID());

        int databaseSizeBeforeCreate = cassTestServiceImplEntityRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        // Validate the CassTestServiceImplEntity in the database
        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkStringRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setStringRequiredField(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkIntegerRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setIntegerRequiredField(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLongRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setLongRequiredField(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkFloatRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setFloatRequiredField(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDoubleRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setDoubleRequiredField(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBigDecimalRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setBigDecimalRequiredField(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLocalDateRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setLocalDateRequiredField(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkInstantRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setInstantRequiredField(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkZonedDateTimeRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setZonedDateTimeRequiredField(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDurationRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setDurationRequiredField(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBooleanRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setBooleanRequiredField(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkEnumRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceImplEntityRepository.findAll().size();
        // set the field null
        cassTestServiceImplEntity.setEnumRequiredTom(null);

        // Create the CassTestServiceImplEntity, which fails.

        restCassTestServiceImplEntityMockMvc
            .perform(
                post("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllCassTestServiceImplEntities() throws Exception {
        // Initialize the database
        cassTestServiceImplEntity.setId(UUID.randomUUID());
        cassTestServiceImplEntityRepository.save(cassTestServiceImplEntity);

        // Get all the cassTestServiceImplEntityList
        restCassTestServiceImplEntityMockMvc
            .perform(get("/api/cass-test-service-impl-entities"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cassTestServiceImplEntity.getId().toString())))
            .andExpect(jsonPath("$.[*].stringField").value(hasItem(DEFAULT_STRING_FIELD)))
            .andExpect(jsonPath("$.[*].stringRequiredField").value(hasItem(DEFAULT_STRING_REQUIRED_FIELD)))
            .andExpect(jsonPath("$.[*].stringMinlengthField").value(hasItem(DEFAULT_STRING_MINLENGTH_FIELD)))
            .andExpect(jsonPath("$.[*].stringMaxlengthField").value(hasItem(DEFAULT_STRING_MAXLENGTH_FIELD)))
            .andExpect(jsonPath("$.[*].stringPatternField").value(hasItem(DEFAULT_STRING_PATTERN_FIELD)))
            .andExpect(jsonPath("$.[*].integerField").value(hasItem(DEFAULT_INTEGER_FIELD)))
            .andExpect(jsonPath("$.[*].integerRequiredField").value(hasItem(DEFAULT_INTEGER_REQUIRED_FIELD)))
            .andExpect(jsonPath("$.[*].integerMinField").value(hasItem(DEFAULT_INTEGER_MIN_FIELD)))
            .andExpect(jsonPath("$.[*].integerMaxField").value(hasItem(DEFAULT_INTEGER_MAX_FIELD)))
            .andExpect(jsonPath("$.[*].longField").value(hasItem(DEFAULT_LONG_FIELD.intValue())))
            .andExpect(jsonPath("$.[*].longRequiredField").value(hasItem(DEFAULT_LONG_REQUIRED_FIELD.intValue())))
            .andExpect(jsonPath("$.[*].longMinField").value(hasItem(DEFAULT_LONG_MIN_FIELD.intValue())))
            .andExpect(jsonPath("$.[*].longMaxField").value(hasItem(DEFAULT_LONG_MAX_FIELD.intValue())))
            .andExpect(jsonPath("$.[*].floatField").value(hasItem(DEFAULT_FLOAT_FIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].floatRequiredField").value(hasItem(DEFAULT_FLOAT_REQUIRED_FIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].floatMinField").value(hasItem(DEFAULT_FLOAT_MIN_FIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].floatMaxField").value(hasItem(DEFAULT_FLOAT_MAX_FIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].doubleRequiredField").value(hasItem(DEFAULT_DOUBLE_REQUIRED_FIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].doubleMinField").value(hasItem(DEFAULT_DOUBLE_MIN_FIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].doubleMaxField").value(hasItem(DEFAULT_DOUBLE_MAX_FIELD.doubleValue())))
            .andExpect(jsonPath("$.[*].bigDecimalRequiredField").value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_REQUIRED_FIELD))))
            .andExpect(jsonPath("$.[*].bigDecimalMinField").value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_MIN_FIELD))))
            .andExpect(jsonPath("$.[*].bigDecimalMaxField").value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_MAX_FIELD))))
            .andExpect(jsonPath("$.[*].localDateField").value(hasItem(DEFAULT_LOCAL_DATE_FIELD.toString())))
            .andExpect(jsonPath("$.[*].localDateRequiredField").value(hasItem(DEFAULT_LOCAL_DATE_REQUIRED_FIELD.toString())))
            .andExpect(jsonPath("$.[*].instantDateField").value(hasItem(DEFAULT_INSTANT_DATE_FIELD.toString())))
            .andExpect(jsonPath("$.[*].instantRequiredField").value(hasItem(DEFAULT_INSTANT_REQUIRED_FIELD.toString())))
            .andExpect(jsonPath("$.[*].zonedDateTimeField").value(hasItem(sameInstant(DEFAULT_ZONED_DATE_TIME_FIELD))))
            .andExpect(jsonPath("$.[*].zonedDateTimeRequiredField").value(hasItem(sameInstant(DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD))))
            .andExpect(jsonPath("$.[*].durationDateField").value(hasItem(DEFAULT_DURATION_DATE_FIELD.toString())))
            .andExpect(jsonPath("$.[*].durationRequiredField").value(hasItem(DEFAULT_DURATION_REQUIRED_FIELD.toString())))
            .andExpect(jsonPath("$.[*].booleanField").value(hasItem(DEFAULT_BOOLEAN_FIELD.booleanValue())))
            .andExpect(jsonPath("$.[*].booleanRequiredField").value(hasItem(DEFAULT_BOOLEAN_REQUIRED_FIELD.booleanValue())))
            .andExpect(jsonPath("$.[*].enumTom").value(hasItem(DEFAULT_ENUM_TOM.toString())))
            .andExpect(jsonPath("$.[*].enumRequiredTom").value(hasItem(DEFAULT_ENUM_REQUIRED_TOM.toString())))
            .andExpect(jsonPath("$.[*].pictureContentType").value(hasItem(DEFAULT_PICTURE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].picture").value(hasItem(Base64Utils.encodeToString(DEFAULT_PICTURE.array()))))
            .andExpect(jsonPath("$.[*].operationsFileContentType").value(hasItem(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].operationsFile").value(hasItem(Base64Utils.encodeToString(DEFAULT_OPERATIONS_FILE.array()))));
    }

    @Test
    void getCassTestServiceImplEntity() throws Exception {
        // Initialize the database
        cassTestServiceImplEntity.setId(UUID.randomUUID());
        cassTestServiceImplEntityRepository.save(cassTestServiceImplEntity);

        // Get the cassTestServiceImplEntity
        restCassTestServiceImplEntityMockMvc
            .perform(get("/api/cass-test-service-impl-entities/{id}", cassTestServiceImplEntity.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(cassTestServiceImplEntity.getId().toString()))
            .andExpect(jsonPath("$.stringField").value(DEFAULT_STRING_FIELD))
            .andExpect(jsonPath("$.stringRequiredField").value(DEFAULT_STRING_REQUIRED_FIELD))
            .andExpect(jsonPath("$.stringMinlengthField").value(DEFAULT_STRING_MINLENGTH_FIELD))
            .andExpect(jsonPath("$.stringMaxlengthField").value(DEFAULT_STRING_MAXLENGTH_FIELD))
            .andExpect(jsonPath("$.stringPatternField").value(DEFAULT_STRING_PATTERN_FIELD))
            .andExpect(jsonPath("$.integerField").value(DEFAULT_INTEGER_FIELD))
            .andExpect(jsonPath("$.integerRequiredField").value(DEFAULT_INTEGER_REQUIRED_FIELD))
            .andExpect(jsonPath("$.integerMinField").value(DEFAULT_INTEGER_MIN_FIELD))
            .andExpect(jsonPath("$.integerMaxField").value(DEFAULT_INTEGER_MAX_FIELD))
            .andExpect(jsonPath("$.longField").value(DEFAULT_LONG_FIELD.intValue()))
            .andExpect(jsonPath("$.longRequiredField").value(DEFAULT_LONG_REQUIRED_FIELD.intValue()))
            .andExpect(jsonPath("$.longMinField").value(DEFAULT_LONG_MIN_FIELD.intValue()))
            .andExpect(jsonPath("$.longMaxField").value(DEFAULT_LONG_MAX_FIELD.intValue()))
            .andExpect(jsonPath("$.floatField").value(DEFAULT_FLOAT_FIELD.doubleValue()))
            .andExpect(jsonPath("$.floatRequiredField").value(DEFAULT_FLOAT_REQUIRED_FIELD.doubleValue()))
            .andExpect(jsonPath("$.floatMinField").value(DEFAULT_FLOAT_MIN_FIELD.doubleValue()))
            .andExpect(jsonPath("$.floatMaxField").value(DEFAULT_FLOAT_MAX_FIELD.doubleValue()))
            .andExpect(jsonPath("$.doubleRequiredField").value(DEFAULT_DOUBLE_REQUIRED_FIELD.doubleValue()))
            .andExpect(jsonPath("$.doubleMinField").value(DEFAULT_DOUBLE_MIN_FIELD.doubleValue()))
            .andExpect(jsonPath("$.doubleMaxField").value(DEFAULT_DOUBLE_MAX_FIELD.doubleValue()))
            .andExpect(jsonPath("$.bigDecimalRequiredField").value(sameNumber(DEFAULT_BIG_DECIMAL_REQUIRED_FIELD)))
            .andExpect(jsonPath("$.bigDecimalMinField").value(sameNumber(DEFAULT_BIG_DECIMAL_MIN_FIELD)))
            .andExpect(jsonPath("$.bigDecimalMaxField").value(sameNumber(DEFAULT_BIG_DECIMAL_MAX_FIELD)))
            .andExpect(jsonPath("$.localDateField").value(DEFAULT_LOCAL_DATE_FIELD.toString()))
            .andExpect(jsonPath("$.localDateRequiredField").value(DEFAULT_LOCAL_DATE_REQUIRED_FIELD.toString()))
            .andExpect(jsonPath("$.instantDateField").value(DEFAULT_INSTANT_DATE_FIELD.toString()))
            .andExpect(jsonPath("$.instantRequiredField").value(DEFAULT_INSTANT_REQUIRED_FIELD.toString()))
            .andExpect(jsonPath("$.zonedDateTimeField").value(sameInstant(DEFAULT_ZONED_DATE_TIME_FIELD)))
            .andExpect(jsonPath("$.zonedDateTimeRequiredField").value(sameInstant(DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD)))
            .andExpect(jsonPath("$.durationDateField").value(DEFAULT_DURATION_DATE_FIELD.toString()))
            .andExpect(jsonPath("$.durationRequiredField").value(DEFAULT_DURATION_REQUIRED_FIELD.toString()))
            .andExpect(jsonPath("$.booleanField").value(DEFAULT_BOOLEAN_FIELD.booleanValue()))
            .andExpect(jsonPath("$.booleanRequiredField").value(DEFAULT_BOOLEAN_REQUIRED_FIELD.booleanValue()))
            .andExpect(jsonPath("$.enumTom").value(DEFAULT_ENUM_TOM.toString()))
            .andExpect(jsonPath("$.enumRequiredTom").value(DEFAULT_ENUM_REQUIRED_TOM.toString()))
            .andExpect(jsonPath("$.pictureContentType").value(DEFAULT_PICTURE_CONTENT_TYPE))
            .andExpect(jsonPath("$.picture").value(Base64Utils.encodeToString(DEFAULT_PICTURE.array())))
            .andExpect(jsonPath("$.operationsFileContentType").value(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE))
            .andExpect(jsonPath("$.operationsFile").value(Base64Utils.encodeToString(DEFAULT_OPERATIONS_FILE.array())));
    }

    @Test
    void getNonExistingCassTestServiceImplEntity() throws Exception {
        // Get the cassTestServiceImplEntity
        restCassTestServiceImplEntityMockMvc
            .perform(get("/api/cass-test-service-impl-entities/{id}", UUID.randomUUID().toString()))
            .andExpect(status().isNotFound());
    }

    @Test
    void updateCassTestServiceImplEntity() throws Exception {
        // Initialize the database
        cassTestServiceImplEntity.setId(UUID.randomUUID());
        cassTestServiceImplEntityRepository.save(cassTestServiceImplEntity);

        int databaseSizeBeforeUpdate = cassTestServiceImplEntityRepository.findAll().size();

        // Update the cassTestServiceImplEntity
        CassTestServiceImplEntity updatedCassTestServiceImplEntity = cassTestServiceImplEntityRepository
            .findById(cassTestServiceImplEntity.getId())
            .get();
        updatedCassTestServiceImplEntity
            .stringField(UPDATED_STRING_FIELD)
            .stringRequiredField(UPDATED_STRING_REQUIRED_FIELD)
            .stringMinlengthField(UPDATED_STRING_MINLENGTH_FIELD)
            .stringMaxlengthField(UPDATED_STRING_MAXLENGTH_FIELD)
            .stringPatternField(UPDATED_STRING_PATTERN_FIELD)
            .integerField(UPDATED_INTEGER_FIELD)
            .integerRequiredField(UPDATED_INTEGER_REQUIRED_FIELD)
            .integerMinField(UPDATED_INTEGER_MIN_FIELD)
            .integerMaxField(UPDATED_INTEGER_MAX_FIELD)
            .longField(UPDATED_LONG_FIELD)
            .longRequiredField(UPDATED_LONG_REQUIRED_FIELD)
            .longMinField(UPDATED_LONG_MIN_FIELD)
            .longMaxField(UPDATED_LONG_MAX_FIELD)
            .floatField(UPDATED_FLOAT_FIELD)
            .floatRequiredField(UPDATED_FLOAT_REQUIRED_FIELD)
            .floatMinField(UPDATED_FLOAT_MIN_FIELD)
            .floatMaxField(UPDATED_FLOAT_MAX_FIELD)
            .doubleRequiredField(UPDATED_DOUBLE_REQUIRED_FIELD)
            .doubleMinField(UPDATED_DOUBLE_MIN_FIELD)
            .doubleMaxField(UPDATED_DOUBLE_MAX_FIELD)
            .bigDecimalRequiredField(UPDATED_BIG_DECIMAL_REQUIRED_FIELD)
            .bigDecimalMinField(UPDATED_BIG_DECIMAL_MIN_FIELD)
            .bigDecimalMaxField(UPDATED_BIG_DECIMAL_MAX_FIELD)
            .localDateField(UPDATED_LOCAL_DATE_FIELD)
            .localDateRequiredField(UPDATED_LOCAL_DATE_REQUIRED_FIELD)
            .instantDateField(UPDATED_INSTANT_DATE_FIELD)
            .instantRequiredField(UPDATED_INSTANT_REQUIRED_FIELD)
            .zonedDateTimeField(UPDATED_ZONED_DATE_TIME_FIELD)
            .zonedDateTimeRequiredField(UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD)
            .durationDateField(UPDATED_DURATION_DATE_FIELD)
            .durationRequiredField(UPDATED_DURATION_REQUIRED_FIELD)
            .booleanField(UPDATED_BOOLEAN_FIELD)
            .booleanRequiredField(UPDATED_BOOLEAN_REQUIRED_FIELD)
            .enumTom(UPDATED_ENUM_TOM)
            .enumRequiredTom(UPDATED_ENUM_REQUIRED_TOM)
            .picture(UPDATED_PICTURE)
            .pictureContentType(UPDATED_PICTURE_CONTENT_TYPE)
            .operationsFile(UPDATED_OPERATIONS_FILE)
            .operationsFileContentType(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);

        restCassTestServiceImplEntityMockMvc
            .perform(
                put("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedCassTestServiceImplEntity))
            )
            .andExpect(status().isOk());

        // Validate the CassTestServiceImplEntity in the database
        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestServiceImplEntity testCassTestServiceImplEntity = cassTestServiceImplEntityList.get(
            cassTestServiceImplEntityList.size() - 1
        );
        assertThat(testCassTestServiceImplEntity.getStringField()).isEqualTo(UPDATED_STRING_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringRequiredField()).isEqualTo(UPDATED_STRING_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringMinlengthField()).isEqualTo(UPDATED_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringMaxlengthField()).isEqualTo(UPDATED_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringPatternField()).isEqualTo(UPDATED_STRING_PATTERN_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerRequiredField()).isEqualTo(UPDATED_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerMinField()).isEqualTo(UPDATED_INTEGER_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerMaxField()).isEqualTo(UPDATED_INTEGER_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongField()).isEqualTo(UPDATED_LONG_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongRequiredField()).isEqualTo(UPDATED_LONG_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongMinField()).isEqualTo(UPDATED_LONG_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatField()).isEqualTo(UPDATED_FLOAT_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatRequiredField()).isEqualTo(UPDATED_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatMinField()).isEqualTo(UPDATED_FLOAT_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatMaxField()).isEqualTo(UPDATED_FLOAT_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleRequiredField()).isEqualTo(UPDATED_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleMinField()).isEqualTo(UPDATED_DOUBLE_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleMaxField()).isEqualTo(UPDATED_DOUBLE_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalRequiredField()).isEqualTo(UPDATED_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalMinField()).isEqualTo(UPDATED_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalMaxField()).isEqualTo(UPDATED_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getLocalDateField()).isEqualTo(UPDATED_LOCAL_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getLocalDateRequiredField()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getInstantDateField()).isEqualTo(UPDATED_INSTANT_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getInstantRequiredField()).isEqualTo(UPDATED_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getZonedDateTimeField()).isEqualTo(UPDATED_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestServiceImplEntity.getZonedDateTimeRequiredField()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getDurationDateField()).isEqualTo(UPDATED_DURATION_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getDurationRequiredField()).isEqualTo(UPDATED_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getBooleanField()).isEqualTo(UPDATED_BOOLEAN_FIELD);
        assertThat(testCassTestServiceImplEntity.getBooleanRequiredField()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testCassTestServiceImplEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testCassTestServiceImplEntity.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassTestServiceImplEntity.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestServiceImplEntity.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassTestServiceImplEntity.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void updateNonExistingCassTestServiceImplEntity() throws Exception {
        int databaseSizeBeforeUpdate = cassTestServiceImplEntityRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCassTestServiceImplEntityMockMvc
            .perform(
                put("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());

        // Validate the CassTestServiceImplEntity in the database
        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateCassTestServiceImplEntityWithPatch() throws Exception {
        // Initialize the database
        cassTestServiceImplEntity.setId(UUID.randomUUID());
        cassTestServiceImplEntityRepository.save(cassTestServiceImplEntity);

        int databaseSizeBeforeUpdate = cassTestServiceImplEntityRepository.findAll().size();

        // Update the cassTestServiceImplEntity using partial update
        CassTestServiceImplEntity partialUpdatedCassTestServiceImplEntity = new CassTestServiceImplEntity();
        partialUpdatedCassTestServiceImplEntity.setId(cassTestServiceImplEntity.getId());

        partialUpdatedCassTestServiceImplEntity
            .stringMinlengthField(UPDATED_STRING_MINLENGTH_FIELD)
            .stringPatternField(UPDATED_STRING_PATTERN_FIELD)
            .integerField(UPDATED_INTEGER_FIELD)
            .integerMinField(UPDATED_INTEGER_MIN_FIELD)
            .longField(UPDATED_LONG_FIELD)
            .longMinField(UPDATED_LONG_MIN_FIELD)
            .longMaxField(UPDATED_LONG_MAX_FIELD)
            .floatRequiredField(UPDATED_FLOAT_REQUIRED_FIELD)
            .floatMinField(UPDATED_FLOAT_MIN_FIELD)
            .floatMaxField(UPDATED_FLOAT_MAX_FIELD)
            .doubleRequiredField(UPDATED_DOUBLE_REQUIRED_FIELD)
            .doubleMinField(UPDATED_DOUBLE_MIN_FIELD)
            .doubleMaxField(UPDATED_DOUBLE_MAX_FIELD)
            .bigDecimalRequiredField(UPDATED_BIG_DECIMAL_REQUIRED_FIELD)
            .bigDecimalMaxField(UPDATED_BIG_DECIMAL_MAX_FIELD)
            .localDateRequiredField(UPDATED_LOCAL_DATE_REQUIRED_FIELD)
            .instantDateField(UPDATED_INSTANT_DATE_FIELD)
            .booleanField(UPDATED_BOOLEAN_FIELD);

        restCassTestServiceImplEntityMockMvc
            .perform(
                patch("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestServiceImplEntity))
            )
            .andExpect(status().isOk());

        // Validate the CassTestServiceImplEntity in the database
        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestServiceImplEntity testCassTestServiceImplEntity = cassTestServiceImplEntityList.get(
            cassTestServiceImplEntityList.size() - 1
        );
        assertThat(testCassTestServiceImplEntity.getStringField()).isEqualTo(DEFAULT_STRING_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringRequiredField()).isEqualTo(DEFAULT_STRING_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringMinlengthField()).isEqualTo(UPDATED_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringMaxlengthField()).isEqualTo(DEFAULT_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringPatternField()).isEqualTo(UPDATED_STRING_PATTERN_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerRequiredField()).isEqualTo(DEFAULT_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerMinField()).isEqualTo(UPDATED_INTEGER_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerMaxField()).isEqualTo(DEFAULT_INTEGER_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongField()).isEqualTo(UPDATED_LONG_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongRequiredField()).isEqualTo(DEFAULT_LONG_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongMinField()).isEqualTo(UPDATED_LONG_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatField()).isEqualTo(DEFAULT_FLOAT_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatRequiredField()).isEqualTo(UPDATED_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatMinField()).isEqualTo(UPDATED_FLOAT_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatMaxField()).isEqualTo(UPDATED_FLOAT_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleRequiredField()).isEqualTo(UPDATED_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleMinField()).isEqualTo(UPDATED_DOUBLE_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleMaxField()).isEqualTo(UPDATED_DOUBLE_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalRequiredField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalMinField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalMaxField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getLocalDateField()).isEqualTo(DEFAULT_LOCAL_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getLocalDateRequiredField()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getInstantDateField()).isEqualTo(UPDATED_INSTANT_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getInstantRequiredField()).isEqualTo(DEFAULT_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getZonedDateTimeField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestServiceImplEntity.getZonedDateTimeRequiredField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getDurationDateField()).isEqualTo(DEFAULT_DURATION_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getDurationRequiredField()).isEqualTo(DEFAULT_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getBooleanField()).isEqualTo(UPDATED_BOOLEAN_FIELD);
        assertThat(testCassTestServiceImplEntity.getBooleanRequiredField()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getEnumTom()).isEqualTo(DEFAULT_ENUM_TOM);
        assertThat(testCassTestServiceImplEntity.getEnumRequiredTom()).isEqualTo(DEFAULT_ENUM_REQUIRED_TOM);
        assertThat(testCassTestServiceImplEntity.getPicture()).isEqualTo(DEFAULT_PICTURE);
        assertThat(testCassTestServiceImplEntity.getPictureContentType()).isEqualTo(DEFAULT_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestServiceImplEntity.getOperationsFile()).isEqualTo(DEFAULT_OPERATIONS_FILE);
        assertThat(testCassTestServiceImplEntity.getOperationsFileContentType()).isEqualTo(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void fullUpdateCassTestServiceImplEntityWithPatch() throws Exception {
        // Initialize the database
        cassTestServiceImplEntity.setId(UUID.randomUUID());
        cassTestServiceImplEntityRepository.save(cassTestServiceImplEntity);

        int databaseSizeBeforeUpdate = cassTestServiceImplEntityRepository.findAll().size();

        // Update the cassTestServiceImplEntity using partial update
        CassTestServiceImplEntity partialUpdatedCassTestServiceImplEntity = new CassTestServiceImplEntity();
        partialUpdatedCassTestServiceImplEntity.setId(cassTestServiceImplEntity.getId());

        partialUpdatedCassTestServiceImplEntity
            .stringField(UPDATED_STRING_FIELD)
            .stringRequiredField(UPDATED_STRING_REQUIRED_FIELD)
            .stringMinlengthField(UPDATED_STRING_MINLENGTH_FIELD)
            .stringMaxlengthField(UPDATED_STRING_MAXLENGTH_FIELD)
            .stringPatternField(UPDATED_STRING_PATTERN_FIELD)
            .integerField(UPDATED_INTEGER_FIELD)
            .integerRequiredField(UPDATED_INTEGER_REQUIRED_FIELD)
            .integerMinField(UPDATED_INTEGER_MIN_FIELD)
            .integerMaxField(UPDATED_INTEGER_MAX_FIELD)
            .longField(UPDATED_LONG_FIELD)
            .longRequiredField(UPDATED_LONG_REQUIRED_FIELD)
            .longMinField(UPDATED_LONG_MIN_FIELD)
            .longMaxField(UPDATED_LONG_MAX_FIELD)
            .floatField(UPDATED_FLOAT_FIELD)
            .floatRequiredField(UPDATED_FLOAT_REQUIRED_FIELD)
            .floatMinField(UPDATED_FLOAT_MIN_FIELD)
            .floatMaxField(UPDATED_FLOAT_MAX_FIELD)
            .doubleRequiredField(UPDATED_DOUBLE_REQUIRED_FIELD)
            .doubleMinField(UPDATED_DOUBLE_MIN_FIELD)
            .doubleMaxField(UPDATED_DOUBLE_MAX_FIELD)
            .bigDecimalRequiredField(UPDATED_BIG_DECIMAL_REQUIRED_FIELD)
            .bigDecimalMinField(UPDATED_BIG_DECIMAL_MIN_FIELD)
            .bigDecimalMaxField(UPDATED_BIG_DECIMAL_MAX_FIELD)
            .localDateField(UPDATED_LOCAL_DATE_FIELD)
            .localDateRequiredField(UPDATED_LOCAL_DATE_REQUIRED_FIELD)
            .instantDateField(UPDATED_INSTANT_DATE_FIELD)
            .instantRequiredField(UPDATED_INSTANT_REQUIRED_FIELD)
            .zonedDateTimeField(UPDATED_ZONED_DATE_TIME_FIELD)
            .zonedDateTimeRequiredField(UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD)
            .durationDateField(UPDATED_DURATION_DATE_FIELD)
            .durationRequiredField(UPDATED_DURATION_REQUIRED_FIELD)
            .booleanField(UPDATED_BOOLEAN_FIELD)
            .booleanRequiredField(UPDATED_BOOLEAN_REQUIRED_FIELD)
            .enumTom(UPDATED_ENUM_TOM)
            .enumRequiredTom(UPDATED_ENUM_REQUIRED_TOM)
            .picture(UPDATED_PICTURE)
            .pictureContentType(UPDATED_PICTURE_CONTENT_TYPE)
            .operationsFile(UPDATED_OPERATIONS_FILE)
            .operationsFileContentType(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);

        restCassTestServiceImplEntityMockMvc
            .perform(
                patch("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestServiceImplEntity))
            )
            .andExpect(status().isOk());

        // Validate the CassTestServiceImplEntity in the database
        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestServiceImplEntity testCassTestServiceImplEntity = cassTestServiceImplEntityList.get(
            cassTestServiceImplEntityList.size() - 1
        );
        assertThat(testCassTestServiceImplEntity.getStringField()).isEqualTo(UPDATED_STRING_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringRequiredField()).isEqualTo(UPDATED_STRING_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringMinlengthField()).isEqualTo(UPDATED_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringMaxlengthField()).isEqualTo(UPDATED_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestServiceImplEntity.getStringPatternField()).isEqualTo(UPDATED_STRING_PATTERN_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerRequiredField()).isEqualTo(UPDATED_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerMinField()).isEqualTo(UPDATED_INTEGER_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getIntegerMaxField()).isEqualTo(UPDATED_INTEGER_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongField()).isEqualTo(UPDATED_LONG_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongRequiredField()).isEqualTo(UPDATED_LONG_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongMinField()).isEqualTo(UPDATED_LONG_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatField()).isEqualTo(UPDATED_FLOAT_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatRequiredField()).isEqualTo(UPDATED_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatMinField()).isEqualTo(UPDATED_FLOAT_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getFloatMaxField()).isEqualTo(UPDATED_FLOAT_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleRequiredField()).isEqualTo(UPDATED_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleMinField()).isEqualTo(UPDATED_DOUBLE_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getDoubleMaxField()).isEqualTo(UPDATED_DOUBLE_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalRequiredField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalMinField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestServiceImplEntity.getBigDecimalMaxField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestServiceImplEntity.getLocalDateField()).isEqualTo(UPDATED_LOCAL_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getLocalDateRequiredField()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getInstantDateField()).isEqualTo(UPDATED_INSTANT_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getInstantRequiredField()).isEqualTo(UPDATED_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getZonedDateTimeField()).isEqualTo(UPDATED_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestServiceImplEntity.getZonedDateTimeRequiredField()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getDurationDateField()).isEqualTo(UPDATED_DURATION_DATE_FIELD);
        assertThat(testCassTestServiceImplEntity.getDurationRequiredField()).isEqualTo(UPDATED_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getBooleanField()).isEqualTo(UPDATED_BOOLEAN_FIELD);
        assertThat(testCassTestServiceImplEntity.getBooleanRequiredField()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestServiceImplEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testCassTestServiceImplEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testCassTestServiceImplEntity.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassTestServiceImplEntity.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestServiceImplEntity.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassTestServiceImplEntity.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void partialUpdateCassTestServiceImplEntityShouldThrown() throws Exception {
        // Update the cassTestServiceImplEntity without id should throw
        CassTestServiceImplEntity partialUpdatedCassTestServiceImplEntity = new CassTestServiceImplEntity();

        restCassTestServiceImplEntityMockMvc
            .perform(
                patch("/api/cass-test-service-impl-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestServiceImplEntity))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    void deleteCassTestServiceImplEntity() throws Exception {
        // Initialize the database
        cassTestServiceImplEntity.setId(UUID.randomUUID());
        cassTestServiceImplEntityRepository.save(cassTestServiceImplEntity);

        int databaseSizeBeforeDelete = cassTestServiceImplEntityRepository.findAll().size();

        // Delete the cassTestServiceImplEntity
        restCassTestServiceImplEntityMockMvc
            .perform(
                delete("/api/cass-test-service-impl-entities/{id}", cassTestServiceImplEntity.getId())
                    .with(csrf())
                    .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CassTestServiceImplEntity> cassTestServiceImplEntityList = cassTestServiceImplEntityRepository.findAll();
        assertThat(cassTestServiceImplEntityList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
