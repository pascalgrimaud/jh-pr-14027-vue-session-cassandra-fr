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
import tech.jhipster.sample.domain.CassTestEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.repository.CassTestEntityRepository;

/**
 * Integration tests for the {@link CassTestEntityResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CassTestEntityResourceIT extends AbstractCassandraTest {

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
    private CassTestEntityRepository cassTestEntityRepository;

    @Autowired
    private MockMvc restCassTestEntityMockMvc;

    private CassTestEntity cassTestEntity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CassTestEntity createEntity() {
        CassTestEntity cassTestEntity = new CassTestEntity()
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
        return cassTestEntity;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CassTestEntity createUpdatedEntity() {
        CassTestEntity cassTestEntity = new CassTestEntity()
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
        return cassTestEntity;
    }

    @BeforeEach
    public void initTest() {
        cassTestEntityRepository.deleteAll();
        cassTestEntity = createEntity();
    }

    @Test
    void createCassTestEntity() throws Exception {
        int databaseSizeBeforeCreate = cassTestEntityRepository.findAll().size();
        // Create the CassTestEntity
        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isCreated());

        // Validate the CassTestEntity in the database
        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeCreate + 1);
        CassTestEntity testCassTestEntity = cassTestEntityList.get(cassTestEntityList.size() - 1);
        assertThat(testCassTestEntity.getStringField()).isEqualTo(DEFAULT_STRING_FIELD);
        assertThat(testCassTestEntity.getStringRequiredField()).isEqualTo(DEFAULT_STRING_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getStringMinlengthField()).isEqualTo(DEFAULT_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestEntity.getStringMaxlengthField()).isEqualTo(DEFAULT_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestEntity.getStringPatternField()).isEqualTo(DEFAULT_STRING_PATTERN_FIELD);
        assertThat(testCassTestEntity.getIntegerField()).isEqualTo(DEFAULT_INTEGER_FIELD);
        assertThat(testCassTestEntity.getIntegerRequiredField()).isEqualTo(DEFAULT_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getIntegerMinField()).isEqualTo(DEFAULT_INTEGER_MIN_FIELD);
        assertThat(testCassTestEntity.getIntegerMaxField()).isEqualTo(DEFAULT_INTEGER_MAX_FIELD);
        assertThat(testCassTestEntity.getLongField()).isEqualTo(DEFAULT_LONG_FIELD);
        assertThat(testCassTestEntity.getLongRequiredField()).isEqualTo(DEFAULT_LONG_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getLongMinField()).isEqualTo(DEFAULT_LONG_MIN_FIELD);
        assertThat(testCassTestEntity.getLongMaxField()).isEqualTo(DEFAULT_LONG_MAX_FIELD);
        assertThat(testCassTestEntity.getFloatField()).isEqualTo(DEFAULT_FLOAT_FIELD);
        assertThat(testCassTestEntity.getFloatRequiredField()).isEqualTo(DEFAULT_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getFloatMinField()).isEqualTo(DEFAULT_FLOAT_MIN_FIELD);
        assertThat(testCassTestEntity.getFloatMaxField()).isEqualTo(DEFAULT_FLOAT_MAX_FIELD);
        assertThat(testCassTestEntity.getDoubleRequiredField()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getDoubleMinField()).isEqualTo(DEFAULT_DOUBLE_MIN_FIELD);
        assertThat(testCassTestEntity.getDoubleMaxField()).isEqualTo(DEFAULT_DOUBLE_MAX_FIELD);
        assertThat(testCassTestEntity.getBigDecimalRequiredField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getBigDecimalMinField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestEntity.getBigDecimalMaxField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestEntity.getLocalDateField()).isEqualTo(DEFAULT_LOCAL_DATE_FIELD);
        assertThat(testCassTestEntity.getLocalDateRequiredField()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getInstantDateField()).isEqualTo(DEFAULT_INSTANT_DATE_FIELD);
        assertThat(testCassTestEntity.getInstantRequiredField()).isEqualTo(DEFAULT_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getZonedDateTimeField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestEntity.getZonedDateTimeRequiredField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getDurationDateField()).isEqualTo(DEFAULT_DURATION_DATE_FIELD);
        assertThat(testCassTestEntity.getDurationRequiredField()).isEqualTo(DEFAULT_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getBooleanField()).isEqualTo(DEFAULT_BOOLEAN_FIELD);
        assertThat(testCassTestEntity.getBooleanRequiredField()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getEnumTom()).isEqualTo(DEFAULT_ENUM_TOM);
        assertThat(testCassTestEntity.getEnumRequiredTom()).isEqualTo(DEFAULT_ENUM_REQUIRED_TOM);
        assertThat(testCassTestEntity.getPicture()).isEqualTo(DEFAULT_PICTURE);
        assertThat(testCassTestEntity.getPictureContentType()).isEqualTo(DEFAULT_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestEntity.getOperationsFile()).isEqualTo(DEFAULT_OPERATIONS_FILE);
        assertThat(testCassTestEntity.getOperationsFileContentType()).isEqualTo(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void createCassTestEntityWithExistingId() throws Exception {
        // Create the CassTestEntity with an existing ID
        cassTestEntity.setId(UUID.randomUUID());

        int databaseSizeBeforeCreate = cassTestEntityRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        // Validate the CassTestEntity in the database
        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkStringRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setStringRequiredField(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkIntegerRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setIntegerRequiredField(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLongRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setLongRequiredField(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkFloatRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setFloatRequiredField(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDoubleRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setDoubleRequiredField(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBigDecimalRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setBigDecimalRequiredField(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLocalDateRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setLocalDateRequiredField(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkInstantRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setInstantRequiredField(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkZonedDateTimeRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setZonedDateTimeRequiredField(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDurationRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setDurationRequiredField(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBooleanRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setBooleanRequiredField(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkEnumRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestEntityRepository.findAll().size();
        // set the field null
        cassTestEntity.setEnumRequiredTom(null);

        // Create the CassTestEntity, which fails.

        restCassTestEntityMockMvc
            .perform(
                post("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllCassTestEntities() throws Exception {
        // Initialize the database
        cassTestEntity.setId(UUID.randomUUID());
        cassTestEntityRepository.save(cassTestEntity);

        // Get all the cassTestEntityList
        restCassTestEntityMockMvc
            .perform(get("/api/cass-test-entities"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cassTestEntity.getId().toString())))
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
    void getCassTestEntity() throws Exception {
        // Initialize the database
        cassTestEntity.setId(UUID.randomUUID());
        cassTestEntityRepository.save(cassTestEntity);

        // Get the cassTestEntity
        restCassTestEntityMockMvc
            .perform(get("/api/cass-test-entities/{id}", cassTestEntity.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(cassTestEntity.getId().toString()))
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
    void getNonExistingCassTestEntity() throws Exception {
        // Get the cassTestEntity
        restCassTestEntityMockMvc
            .perform(get("/api/cass-test-entities/{id}", UUID.randomUUID().toString()))
            .andExpect(status().isNotFound());
    }

    @Test
    void updateCassTestEntity() throws Exception {
        // Initialize the database
        cassTestEntity.setId(UUID.randomUUID());
        cassTestEntityRepository.save(cassTestEntity);

        int databaseSizeBeforeUpdate = cassTestEntityRepository.findAll().size();

        // Update the cassTestEntity
        CassTestEntity updatedCassTestEntity = cassTestEntityRepository.findById(cassTestEntity.getId()).get();
        updatedCassTestEntity
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

        restCassTestEntityMockMvc
            .perform(
                put("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedCassTestEntity))
            )
            .andExpect(status().isOk());

        // Validate the CassTestEntity in the database
        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestEntity testCassTestEntity = cassTestEntityList.get(cassTestEntityList.size() - 1);
        assertThat(testCassTestEntity.getStringField()).isEqualTo(UPDATED_STRING_FIELD);
        assertThat(testCassTestEntity.getStringRequiredField()).isEqualTo(UPDATED_STRING_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getStringMinlengthField()).isEqualTo(UPDATED_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestEntity.getStringMaxlengthField()).isEqualTo(UPDATED_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestEntity.getStringPatternField()).isEqualTo(UPDATED_STRING_PATTERN_FIELD);
        assertThat(testCassTestEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestEntity.getIntegerRequiredField()).isEqualTo(UPDATED_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getIntegerMinField()).isEqualTo(UPDATED_INTEGER_MIN_FIELD);
        assertThat(testCassTestEntity.getIntegerMaxField()).isEqualTo(UPDATED_INTEGER_MAX_FIELD);
        assertThat(testCassTestEntity.getLongField()).isEqualTo(UPDATED_LONG_FIELD);
        assertThat(testCassTestEntity.getLongRequiredField()).isEqualTo(UPDATED_LONG_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getLongMinField()).isEqualTo(UPDATED_LONG_MIN_FIELD);
        assertThat(testCassTestEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestEntity.getFloatField()).isEqualTo(UPDATED_FLOAT_FIELD);
        assertThat(testCassTestEntity.getFloatRequiredField()).isEqualTo(UPDATED_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getFloatMinField()).isEqualTo(UPDATED_FLOAT_MIN_FIELD);
        assertThat(testCassTestEntity.getFloatMaxField()).isEqualTo(UPDATED_FLOAT_MAX_FIELD);
        assertThat(testCassTestEntity.getDoubleRequiredField()).isEqualTo(UPDATED_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getDoubleMinField()).isEqualTo(UPDATED_DOUBLE_MIN_FIELD);
        assertThat(testCassTestEntity.getDoubleMaxField()).isEqualTo(UPDATED_DOUBLE_MAX_FIELD);
        assertThat(testCassTestEntity.getBigDecimalRequiredField()).isEqualTo(UPDATED_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getBigDecimalMinField()).isEqualTo(UPDATED_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestEntity.getBigDecimalMaxField()).isEqualTo(UPDATED_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestEntity.getLocalDateField()).isEqualTo(UPDATED_LOCAL_DATE_FIELD);
        assertThat(testCassTestEntity.getLocalDateRequiredField()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getInstantDateField()).isEqualTo(UPDATED_INSTANT_DATE_FIELD);
        assertThat(testCassTestEntity.getInstantRequiredField()).isEqualTo(UPDATED_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getZonedDateTimeField()).isEqualTo(UPDATED_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestEntity.getZonedDateTimeRequiredField()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getDurationDateField()).isEqualTo(UPDATED_DURATION_DATE_FIELD);
        assertThat(testCassTestEntity.getDurationRequiredField()).isEqualTo(UPDATED_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getBooleanField()).isEqualTo(UPDATED_BOOLEAN_FIELD);
        assertThat(testCassTestEntity.getBooleanRequiredField()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testCassTestEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testCassTestEntity.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassTestEntity.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestEntity.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassTestEntity.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void updateNonExistingCassTestEntity() throws Exception {
        int databaseSizeBeforeUpdate = cassTestEntityRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCassTestEntityMockMvc
            .perform(
                put("/api/cass-test-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestEntity))
            )
            .andExpect(status().isBadRequest());

        // Validate the CassTestEntity in the database
        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateCassTestEntityWithPatch() throws Exception {
        // Initialize the database
        cassTestEntity.setId(UUID.randomUUID());
        cassTestEntityRepository.save(cassTestEntity);

        int databaseSizeBeforeUpdate = cassTestEntityRepository.findAll().size();

        // Update the cassTestEntity using partial update
        CassTestEntity partialUpdatedCassTestEntity = new CassTestEntity();
        partialUpdatedCassTestEntity.setId(cassTestEntity.getId());

        partialUpdatedCassTestEntity
            .stringField(UPDATED_STRING_FIELD)
            .stringMinlengthField(UPDATED_STRING_MINLENGTH_FIELD)
            .integerField(UPDATED_INTEGER_FIELD)
            .integerRequiredField(UPDATED_INTEGER_REQUIRED_FIELD)
            .integerMinField(UPDATED_INTEGER_MIN_FIELD)
            .integerMaxField(UPDATED_INTEGER_MAX_FIELD)
            .longRequiredField(UPDATED_LONG_REQUIRED_FIELD)
            .longMinField(UPDATED_LONG_MIN_FIELD)
            .longMaxField(UPDATED_LONG_MAX_FIELD)
            .floatField(UPDATED_FLOAT_FIELD)
            .floatRequiredField(UPDATED_FLOAT_REQUIRED_FIELD)
            .doubleMinField(UPDATED_DOUBLE_MIN_FIELD)
            .bigDecimalRequiredField(UPDATED_BIG_DECIMAL_REQUIRED_FIELD)
            .bigDecimalMaxField(UPDATED_BIG_DECIMAL_MAX_FIELD)
            .localDateField(UPDATED_LOCAL_DATE_FIELD)
            .localDateRequiredField(UPDATED_LOCAL_DATE_REQUIRED_FIELD)
            .durationDateField(UPDATED_DURATION_DATE_FIELD)
            .enumTom(UPDATED_ENUM_TOM);

        restCassTestEntityMockMvc
            .perform(
                patch("/api/cass-test-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestEntity))
            )
            .andExpect(status().isOk());

        // Validate the CassTestEntity in the database
        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestEntity testCassTestEntity = cassTestEntityList.get(cassTestEntityList.size() - 1);
        assertThat(testCassTestEntity.getStringField()).isEqualTo(UPDATED_STRING_FIELD);
        assertThat(testCassTestEntity.getStringRequiredField()).isEqualTo(DEFAULT_STRING_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getStringMinlengthField()).isEqualTo(UPDATED_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestEntity.getStringMaxlengthField()).isEqualTo(DEFAULT_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestEntity.getStringPatternField()).isEqualTo(DEFAULT_STRING_PATTERN_FIELD);
        assertThat(testCassTestEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestEntity.getIntegerRequiredField()).isEqualTo(UPDATED_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getIntegerMinField()).isEqualTo(UPDATED_INTEGER_MIN_FIELD);
        assertThat(testCassTestEntity.getIntegerMaxField()).isEqualTo(UPDATED_INTEGER_MAX_FIELD);
        assertThat(testCassTestEntity.getLongField()).isEqualTo(DEFAULT_LONG_FIELD);
        assertThat(testCassTestEntity.getLongRequiredField()).isEqualTo(UPDATED_LONG_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getLongMinField()).isEqualTo(UPDATED_LONG_MIN_FIELD);
        assertThat(testCassTestEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestEntity.getFloatField()).isEqualTo(UPDATED_FLOAT_FIELD);
        assertThat(testCassTestEntity.getFloatRequiredField()).isEqualTo(UPDATED_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getFloatMinField()).isEqualTo(DEFAULT_FLOAT_MIN_FIELD);
        assertThat(testCassTestEntity.getFloatMaxField()).isEqualTo(DEFAULT_FLOAT_MAX_FIELD);
        assertThat(testCassTestEntity.getDoubleRequiredField()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getDoubleMinField()).isEqualTo(UPDATED_DOUBLE_MIN_FIELD);
        assertThat(testCassTestEntity.getDoubleMaxField()).isEqualTo(DEFAULT_DOUBLE_MAX_FIELD);
        assertThat(testCassTestEntity.getBigDecimalRequiredField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getBigDecimalMinField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestEntity.getBigDecimalMaxField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestEntity.getLocalDateField()).isEqualTo(UPDATED_LOCAL_DATE_FIELD);
        assertThat(testCassTestEntity.getLocalDateRequiredField()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getInstantDateField()).isEqualTo(DEFAULT_INSTANT_DATE_FIELD);
        assertThat(testCassTestEntity.getInstantRequiredField()).isEqualTo(DEFAULT_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getZonedDateTimeField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestEntity.getZonedDateTimeRequiredField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getDurationDateField()).isEqualTo(UPDATED_DURATION_DATE_FIELD);
        assertThat(testCassTestEntity.getDurationRequiredField()).isEqualTo(DEFAULT_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getBooleanField()).isEqualTo(DEFAULT_BOOLEAN_FIELD);
        assertThat(testCassTestEntity.getBooleanRequiredField()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testCassTestEntity.getEnumRequiredTom()).isEqualTo(DEFAULT_ENUM_REQUIRED_TOM);
        assertThat(testCassTestEntity.getPicture()).isEqualTo(DEFAULT_PICTURE);
        assertThat(testCassTestEntity.getPictureContentType()).isEqualTo(DEFAULT_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestEntity.getOperationsFile()).isEqualTo(DEFAULT_OPERATIONS_FILE);
        assertThat(testCassTestEntity.getOperationsFileContentType()).isEqualTo(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void fullUpdateCassTestEntityWithPatch() throws Exception {
        // Initialize the database
        cassTestEntity.setId(UUID.randomUUID());
        cassTestEntityRepository.save(cassTestEntity);

        int databaseSizeBeforeUpdate = cassTestEntityRepository.findAll().size();

        // Update the cassTestEntity using partial update
        CassTestEntity partialUpdatedCassTestEntity = new CassTestEntity();
        partialUpdatedCassTestEntity.setId(cassTestEntity.getId());

        partialUpdatedCassTestEntity
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

        restCassTestEntityMockMvc
            .perform(
                patch("/api/cass-test-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestEntity))
            )
            .andExpect(status().isOk());

        // Validate the CassTestEntity in the database
        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestEntity testCassTestEntity = cassTestEntityList.get(cassTestEntityList.size() - 1);
        assertThat(testCassTestEntity.getStringField()).isEqualTo(UPDATED_STRING_FIELD);
        assertThat(testCassTestEntity.getStringRequiredField()).isEqualTo(UPDATED_STRING_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getStringMinlengthField()).isEqualTo(UPDATED_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestEntity.getStringMaxlengthField()).isEqualTo(UPDATED_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestEntity.getStringPatternField()).isEqualTo(UPDATED_STRING_PATTERN_FIELD);
        assertThat(testCassTestEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestEntity.getIntegerRequiredField()).isEqualTo(UPDATED_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getIntegerMinField()).isEqualTo(UPDATED_INTEGER_MIN_FIELD);
        assertThat(testCassTestEntity.getIntegerMaxField()).isEqualTo(UPDATED_INTEGER_MAX_FIELD);
        assertThat(testCassTestEntity.getLongField()).isEqualTo(UPDATED_LONG_FIELD);
        assertThat(testCassTestEntity.getLongRequiredField()).isEqualTo(UPDATED_LONG_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getLongMinField()).isEqualTo(UPDATED_LONG_MIN_FIELD);
        assertThat(testCassTestEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestEntity.getFloatField()).isEqualTo(UPDATED_FLOAT_FIELD);
        assertThat(testCassTestEntity.getFloatRequiredField()).isEqualTo(UPDATED_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getFloatMinField()).isEqualTo(UPDATED_FLOAT_MIN_FIELD);
        assertThat(testCassTestEntity.getFloatMaxField()).isEqualTo(UPDATED_FLOAT_MAX_FIELD);
        assertThat(testCassTestEntity.getDoubleRequiredField()).isEqualTo(UPDATED_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getDoubleMinField()).isEqualTo(UPDATED_DOUBLE_MIN_FIELD);
        assertThat(testCassTestEntity.getDoubleMaxField()).isEqualTo(UPDATED_DOUBLE_MAX_FIELD);
        assertThat(testCassTestEntity.getBigDecimalRequiredField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getBigDecimalMinField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestEntity.getBigDecimalMaxField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestEntity.getLocalDateField()).isEqualTo(UPDATED_LOCAL_DATE_FIELD);
        assertThat(testCassTestEntity.getLocalDateRequiredField()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getInstantDateField()).isEqualTo(UPDATED_INSTANT_DATE_FIELD);
        assertThat(testCassTestEntity.getInstantRequiredField()).isEqualTo(UPDATED_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getZonedDateTimeField()).isEqualTo(UPDATED_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestEntity.getZonedDateTimeRequiredField()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getDurationDateField()).isEqualTo(UPDATED_DURATION_DATE_FIELD);
        assertThat(testCassTestEntity.getDurationRequiredField()).isEqualTo(UPDATED_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getBooleanField()).isEqualTo(UPDATED_BOOLEAN_FIELD);
        assertThat(testCassTestEntity.getBooleanRequiredField()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testCassTestEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testCassTestEntity.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassTestEntity.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestEntity.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassTestEntity.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void partialUpdateCassTestEntityShouldThrown() throws Exception {
        // Update the cassTestEntity without id should throw
        CassTestEntity partialUpdatedCassTestEntity = new CassTestEntity();

        restCassTestEntityMockMvc
            .perform(
                patch("/api/cass-test-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestEntity))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    void deleteCassTestEntity() throws Exception {
        // Initialize the database
        cassTestEntity.setId(UUID.randomUUID());
        cassTestEntityRepository.save(cassTestEntity);

        int databaseSizeBeforeDelete = cassTestEntityRepository.findAll().size();

        // Delete the cassTestEntity
        restCassTestEntityMockMvc
            .perform(delete("/api/cass-test-entities/{id}", cassTestEntity.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CassTestEntity> cassTestEntityList = cassTestEntityRepository.findAll();
        assertThat(cassTestEntityList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
