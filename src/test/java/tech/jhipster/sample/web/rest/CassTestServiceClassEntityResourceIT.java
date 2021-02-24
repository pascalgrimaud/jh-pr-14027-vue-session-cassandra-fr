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
import tech.jhipster.sample.domain.CassTestServiceClassEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.repository.CassTestServiceClassEntityRepository;

/**
 * Integration tests for the {@link CassTestServiceClassEntityResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CassTestServiceClassEntityResourceIT extends AbstractCassandraTest {

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
    private CassTestServiceClassEntityRepository cassTestServiceClassEntityRepository;

    @Autowired
    private MockMvc restCassTestServiceClassEntityMockMvc;

    private CassTestServiceClassEntity cassTestServiceClassEntity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CassTestServiceClassEntity createEntity() {
        CassTestServiceClassEntity cassTestServiceClassEntity = new CassTestServiceClassEntity()
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
        return cassTestServiceClassEntity;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CassTestServiceClassEntity createUpdatedEntity() {
        CassTestServiceClassEntity cassTestServiceClassEntity = new CassTestServiceClassEntity()
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
        return cassTestServiceClassEntity;
    }

    @BeforeEach
    public void initTest() {
        cassTestServiceClassEntityRepository.deleteAll();
        cassTestServiceClassEntity = createEntity();
    }

    @Test
    void createCassTestServiceClassEntity() throws Exception {
        int databaseSizeBeforeCreate = cassTestServiceClassEntityRepository.findAll().size();
        // Create the CassTestServiceClassEntity
        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isCreated());

        // Validate the CassTestServiceClassEntity in the database
        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeCreate + 1);
        CassTestServiceClassEntity testCassTestServiceClassEntity = cassTestServiceClassEntityList.get(
            cassTestServiceClassEntityList.size() - 1
        );
        assertThat(testCassTestServiceClassEntity.getStringField()).isEqualTo(DEFAULT_STRING_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringRequiredField()).isEqualTo(DEFAULT_STRING_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringMinlengthField()).isEqualTo(DEFAULT_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringMaxlengthField()).isEqualTo(DEFAULT_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringPatternField()).isEqualTo(DEFAULT_STRING_PATTERN_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerField()).isEqualTo(DEFAULT_INTEGER_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerRequiredField()).isEqualTo(DEFAULT_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerMinField()).isEqualTo(DEFAULT_INTEGER_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerMaxField()).isEqualTo(DEFAULT_INTEGER_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongField()).isEqualTo(DEFAULT_LONG_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongRequiredField()).isEqualTo(DEFAULT_LONG_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongMinField()).isEqualTo(DEFAULT_LONG_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongMaxField()).isEqualTo(DEFAULT_LONG_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatField()).isEqualTo(DEFAULT_FLOAT_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatRequiredField()).isEqualTo(DEFAULT_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatMinField()).isEqualTo(DEFAULT_FLOAT_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatMaxField()).isEqualTo(DEFAULT_FLOAT_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleRequiredField()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleMinField()).isEqualTo(DEFAULT_DOUBLE_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleMaxField()).isEqualTo(DEFAULT_DOUBLE_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalRequiredField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalMinField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalMaxField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getLocalDateField()).isEqualTo(DEFAULT_LOCAL_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getLocalDateRequiredField()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getInstantDateField()).isEqualTo(DEFAULT_INSTANT_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getInstantRequiredField()).isEqualTo(DEFAULT_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getZonedDateTimeField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestServiceClassEntity.getZonedDateTimeRequiredField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getDurationDateField()).isEqualTo(DEFAULT_DURATION_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getDurationRequiredField()).isEqualTo(DEFAULT_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getBooleanField()).isEqualTo(DEFAULT_BOOLEAN_FIELD);
        assertThat(testCassTestServiceClassEntity.getBooleanRequiredField()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getEnumTom()).isEqualTo(DEFAULT_ENUM_TOM);
        assertThat(testCassTestServiceClassEntity.getEnumRequiredTom()).isEqualTo(DEFAULT_ENUM_REQUIRED_TOM);
        assertThat(testCassTestServiceClassEntity.getPicture()).isEqualTo(DEFAULT_PICTURE);
        assertThat(testCassTestServiceClassEntity.getPictureContentType()).isEqualTo(DEFAULT_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestServiceClassEntity.getOperationsFile()).isEqualTo(DEFAULT_OPERATIONS_FILE);
        assertThat(testCassTestServiceClassEntity.getOperationsFileContentType()).isEqualTo(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void createCassTestServiceClassEntityWithExistingId() throws Exception {
        // Create the CassTestServiceClassEntity with an existing ID
        cassTestServiceClassEntity.setId(UUID.randomUUID());

        int databaseSizeBeforeCreate = cassTestServiceClassEntityRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        // Validate the CassTestServiceClassEntity in the database
        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkStringRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setStringRequiredField(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkIntegerRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setIntegerRequiredField(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLongRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setLongRequiredField(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkFloatRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setFloatRequiredField(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDoubleRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setDoubleRequiredField(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBigDecimalRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setBigDecimalRequiredField(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLocalDateRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setLocalDateRequiredField(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkInstantRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setInstantRequiredField(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkZonedDateTimeRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setZonedDateTimeRequiredField(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDurationRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setDurationRequiredField(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBooleanRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setBooleanRequiredField(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkEnumRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestServiceClassEntityRepository.findAll().size();
        // set the field null
        cassTestServiceClassEntity.setEnumRequiredTom(null);

        // Create the CassTestServiceClassEntity, which fails.

        restCassTestServiceClassEntityMockMvc
            .perform(
                post("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllCassTestServiceClassEntities() throws Exception {
        // Initialize the database
        cassTestServiceClassEntity.setId(UUID.randomUUID());
        cassTestServiceClassEntityRepository.save(cassTestServiceClassEntity);

        // Get all the cassTestServiceClassEntityList
        restCassTestServiceClassEntityMockMvc
            .perform(get("/api/cass-test-service-class-entities"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cassTestServiceClassEntity.getId().toString())))
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
    void getCassTestServiceClassEntity() throws Exception {
        // Initialize the database
        cassTestServiceClassEntity.setId(UUID.randomUUID());
        cassTestServiceClassEntityRepository.save(cassTestServiceClassEntity);

        // Get the cassTestServiceClassEntity
        restCassTestServiceClassEntityMockMvc
            .perform(get("/api/cass-test-service-class-entities/{id}", cassTestServiceClassEntity.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(cassTestServiceClassEntity.getId().toString()))
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
    void getNonExistingCassTestServiceClassEntity() throws Exception {
        // Get the cassTestServiceClassEntity
        restCassTestServiceClassEntityMockMvc
            .perform(get("/api/cass-test-service-class-entities/{id}", UUID.randomUUID().toString()))
            .andExpect(status().isNotFound());
    }

    @Test
    void updateCassTestServiceClassEntity() throws Exception {
        // Initialize the database
        cassTestServiceClassEntity.setId(UUID.randomUUID());
        cassTestServiceClassEntityRepository.save(cassTestServiceClassEntity);

        int databaseSizeBeforeUpdate = cassTestServiceClassEntityRepository.findAll().size();

        // Update the cassTestServiceClassEntity
        CassTestServiceClassEntity updatedCassTestServiceClassEntity = cassTestServiceClassEntityRepository
            .findById(cassTestServiceClassEntity.getId())
            .get();
        updatedCassTestServiceClassEntity
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

        restCassTestServiceClassEntityMockMvc
            .perform(
                put("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedCassTestServiceClassEntity))
            )
            .andExpect(status().isOk());

        // Validate the CassTestServiceClassEntity in the database
        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestServiceClassEntity testCassTestServiceClassEntity = cassTestServiceClassEntityList.get(
            cassTestServiceClassEntityList.size() - 1
        );
        assertThat(testCassTestServiceClassEntity.getStringField()).isEqualTo(UPDATED_STRING_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringRequiredField()).isEqualTo(UPDATED_STRING_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringMinlengthField()).isEqualTo(UPDATED_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringMaxlengthField()).isEqualTo(UPDATED_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringPatternField()).isEqualTo(UPDATED_STRING_PATTERN_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerRequiredField()).isEqualTo(UPDATED_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerMinField()).isEqualTo(UPDATED_INTEGER_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerMaxField()).isEqualTo(UPDATED_INTEGER_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongField()).isEqualTo(UPDATED_LONG_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongRequiredField()).isEqualTo(UPDATED_LONG_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongMinField()).isEqualTo(UPDATED_LONG_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatField()).isEqualTo(UPDATED_FLOAT_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatRequiredField()).isEqualTo(UPDATED_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatMinField()).isEqualTo(UPDATED_FLOAT_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatMaxField()).isEqualTo(UPDATED_FLOAT_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleRequiredField()).isEqualTo(UPDATED_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleMinField()).isEqualTo(UPDATED_DOUBLE_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleMaxField()).isEqualTo(UPDATED_DOUBLE_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalRequiredField()).isEqualTo(UPDATED_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalMinField()).isEqualTo(UPDATED_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalMaxField()).isEqualTo(UPDATED_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getLocalDateField()).isEqualTo(UPDATED_LOCAL_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getLocalDateRequiredField()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getInstantDateField()).isEqualTo(UPDATED_INSTANT_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getInstantRequiredField()).isEqualTo(UPDATED_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getZonedDateTimeField()).isEqualTo(UPDATED_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestServiceClassEntity.getZonedDateTimeRequiredField()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getDurationDateField()).isEqualTo(UPDATED_DURATION_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getDurationRequiredField()).isEqualTo(UPDATED_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getBooleanField()).isEqualTo(UPDATED_BOOLEAN_FIELD);
        assertThat(testCassTestServiceClassEntity.getBooleanRequiredField()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testCassTestServiceClassEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testCassTestServiceClassEntity.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassTestServiceClassEntity.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestServiceClassEntity.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassTestServiceClassEntity.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void updateNonExistingCassTestServiceClassEntity() throws Exception {
        int databaseSizeBeforeUpdate = cassTestServiceClassEntityRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCassTestServiceClassEntityMockMvc
            .perform(
                put("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());

        // Validate the CassTestServiceClassEntity in the database
        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateCassTestServiceClassEntityWithPatch() throws Exception {
        // Initialize the database
        cassTestServiceClassEntity.setId(UUID.randomUUID());
        cassTestServiceClassEntityRepository.save(cassTestServiceClassEntity);

        int databaseSizeBeforeUpdate = cassTestServiceClassEntityRepository.findAll().size();

        // Update the cassTestServiceClassEntity using partial update
        CassTestServiceClassEntity partialUpdatedCassTestServiceClassEntity = new CassTestServiceClassEntity();
        partialUpdatedCassTestServiceClassEntity.setId(cassTestServiceClassEntity.getId());

        partialUpdatedCassTestServiceClassEntity
            .stringRequiredField(UPDATED_STRING_REQUIRED_FIELD)
            .stringMinlengthField(UPDATED_STRING_MINLENGTH_FIELD)
            .stringPatternField(UPDATED_STRING_PATTERN_FIELD)
            .integerField(UPDATED_INTEGER_FIELD)
            .integerMinField(UPDATED_INTEGER_MIN_FIELD)
            .longMaxField(UPDATED_LONG_MAX_FIELD)
            .floatRequiredField(UPDATED_FLOAT_REQUIRED_FIELD)
            .floatMinField(UPDATED_FLOAT_MIN_FIELD)
            .doubleRequiredField(UPDATED_DOUBLE_REQUIRED_FIELD)
            .bigDecimalMinField(UPDATED_BIG_DECIMAL_MIN_FIELD)
            .bigDecimalMaxField(UPDATED_BIG_DECIMAL_MAX_FIELD)
            .localDateRequiredField(UPDATED_LOCAL_DATE_REQUIRED_FIELD)
            .instantDateField(UPDATED_INSTANT_DATE_FIELD)
            .instantRequiredField(UPDATED_INSTANT_REQUIRED_FIELD)
            .zonedDateTimeField(UPDATED_ZONED_DATE_TIME_FIELD)
            .durationDateField(UPDATED_DURATION_DATE_FIELD)
            .booleanRequiredField(UPDATED_BOOLEAN_REQUIRED_FIELD)
            .picture(UPDATED_PICTURE)
            .pictureContentType(UPDATED_PICTURE_CONTENT_TYPE)
            .operationsFile(UPDATED_OPERATIONS_FILE)
            .operationsFileContentType(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);

        restCassTestServiceClassEntityMockMvc
            .perform(
                patch("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestServiceClassEntity))
            )
            .andExpect(status().isOk());

        // Validate the CassTestServiceClassEntity in the database
        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestServiceClassEntity testCassTestServiceClassEntity = cassTestServiceClassEntityList.get(
            cassTestServiceClassEntityList.size() - 1
        );
        assertThat(testCassTestServiceClassEntity.getStringField()).isEqualTo(DEFAULT_STRING_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringRequiredField()).isEqualTo(UPDATED_STRING_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringMinlengthField()).isEqualTo(UPDATED_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringMaxlengthField()).isEqualTo(DEFAULT_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringPatternField()).isEqualTo(UPDATED_STRING_PATTERN_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerRequiredField()).isEqualTo(DEFAULT_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerMinField()).isEqualTo(UPDATED_INTEGER_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerMaxField()).isEqualTo(DEFAULT_INTEGER_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongField()).isEqualTo(DEFAULT_LONG_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongRequiredField()).isEqualTo(DEFAULT_LONG_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongMinField()).isEqualTo(DEFAULT_LONG_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatField()).isEqualTo(DEFAULT_FLOAT_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatRequiredField()).isEqualTo(UPDATED_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatMinField()).isEqualTo(UPDATED_FLOAT_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatMaxField()).isEqualTo(DEFAULT_FLOAT_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleRequiredField()).isEqualTo(UPDATED_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleMinField()).isEqualTo(DEFAULT_DOUBLE_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleMaxField()).isEqualTo(DEFAULT_DOUBLE_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalRequiredField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalMinField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalMaxField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getLocalDateField()).isEqualTo(DEFAULT_LOCAL_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getLocalDateRequiredField()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getInstantDateField()).isEqualTo(UPDATED_INSTANT_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getInstantRequiredField()).isEqualTo(UPDATED_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getZonedDateTimeField()).isEqualTo(UPDATED_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestServiceClassEntity.getZonedDateTimeRequiredField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getDurationDateField()).isEqualTo(UPDATED_DURATION_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getDurationRequiredField()).isEqualTo(DEFAULT_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getBooleanField()).isEqualTo(DEFAULT_BOOLEAN_FIELD);
        assertThat(testCassTestServiceClassEntity.getBooleanRequiredField()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getEnumTom()).isEqualTo(DEFAULT_ENUM_TOM);
        assertThat(testCassTestServiceClassEntity.getEnumRequiredTom()).isEqualTo(DEFAULT_ENUM_REQUIRED_TOM);
        assertThat(testCassTestServiceClassEntity.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassTestServiceClassEntity.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestServiceClassEntity.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassTestServiceClassEntity.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void fullUpdateCassTestServiceClassEntityWithPatch() throws Exception {
        // Initialize the database
        cassTestServiceClassEntity.setId(UUID.randomUUID());
        cassTestServiceClassEntityRepository.save(cassTestServiceClassEntity);

        int databaseSizeBeforeUpdate = cassTestServiceClassEntityRepository.findAll().size();

        // Update the cassTestServiceClassEntity using partial update
        CassTestServiceClassEntity partialUpdatedCassTestServiceClassEntity = new CassTestServiceClassEntity();
        partialUpdatedCassTestServiceClassEntity.setId(cassTestServiceClassEntity.getId());

        partialUpdatedCassTestServiceClassEntity
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

        restCassTestServiceClassEntityMockMvc
            .perform(
                patch("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestServiceClassEntity))
            )
            .andExpect(status().isOk());

        // Validate the CassTestServiceClassEntity in the database
        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestServiceClassEntity testCassTestServiceClassEntity = cassTestServiceClassEntityList.get(
            cassTestServiceClassEntityList.size() - 1
        );
        assertThat(testCassTestServiceClassEntity.getStringField()).isEqualTo(UPDATED_STRING_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringRequiredField()).isEqualTo(UPDATED_STRING_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringMinlengthField()).isEqualTo(UPDATED_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringMaxlengthField()).isEqualTo(UPDATED_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestServiceClassEntity.getStringPatternField()).isEqualTo(UPDATED_STRING_PATTERN_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerRequiredField()).isEqualTo(UPDATED_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerMinField()).isEqualTo(UPDATED_INTEGER_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getIntegerMaxField()).isEqualTo(UPDATED_INTEGER_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongField()).isEqualTo(UPDATED_LONG_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongRequiredField()).isEqualTo(UPDATED_LONG_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongMinField()).isEqualTo(UPDATED_LONG_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatField()).isEqualTo(UPDATED_FLOAT_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatRequiredField()).isEqualTo(UPDATED_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatMinField()).isEqualTo(UPDATED_FLOAT_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getFloatMaxField()).isEqualTo(UPDATED_FLOAT_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleRequiredField()).isEqualTo(UPDATED_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleMinField()).isEqualTo(UPDATED_DOUBLE_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getDoubleMaxField()).isEqualTo(UPDATED_DOUBLE_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalRequiredField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalMinField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestServiceClassEntity.getBigDecimalMaxField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestServiceClassEntity.getLocalDateField()).isEqualTo(UPDATED_LOCAL_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getLocalDateRequiredField()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getInstantDateField()).isEqualTo(UPDATED_INSTANT_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getInstantRequiredField()).isEqualTo(UPDATED_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getZonedDateTimeField()).isEqualTo(UPDATED_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestServiceClassEntity.getZonedDateTimeRequiredField()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getDurationDateField()).isEqualTo(UPDATED_DURATION_DATE_FIELD);
        assertThat(testCassTestServiceClassEntity.getDurationRequiredField()).isEqualTo(UPDATED_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getBooleanField()).isEqualTo(UPDATED_BOOLEAN_FIELD);
        assertThat(testCassTestServiceClassEntity.getBooleanRequiredField()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestServiceClassEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testCassTestServiceClassEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testCassTestServiceClassEntity.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassTestServiceClassEntity.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestServiceClassEntity.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassTestServiceClassEntity.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void partialUpdateCassTestServiceClassEntityShouldThrown() throws Exception {
        // Update the cassTestServiceClassEntity without id should throw
        CassTestServiceClassEntity partialUpdatedCassTestServiceClassEntity = new CassTestServiceClassEntity();

        restCassTestServiceClassEntityMockMvc
            .perform(
                patch("/api/cass-test-service-class-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestServiceClassEntity))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    void deleteCassTestServiceClassEntity() throws Exception {
        // Initialize the database
        cassTestServiceClassEntity.setId(UUID.randomUUID());
        cassTestServiceClassEntityRepository.save(cassTestServiceClassEntity);

        int databaseSizeBeforeDelete = cassTestServiceClassEntityRepository.findAll().size();

        // Delete the cassTestServiceClassEntity
        restCassTestServiceClassEntityMockMvc
            .perform(
                delete("/api/cass-test-service-class-entities/{id}", cassTestServiceClassEntity.getId())
                    .with(csrf())
                    .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CassTestServiceClassEntity> cassTestServiceClassEntityList = cassTestServiceClassEntityRepository.findAll();
        assertThat(cassTestServiceClassEntityList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
