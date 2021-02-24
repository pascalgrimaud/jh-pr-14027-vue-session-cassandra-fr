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
import tech.jhipster.sample.domain.CassTestMapstructEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.repository.CassTestMapstructEntityRepository;
import tech.jhipster.sample.service.dto.CassTestMapstructEntityDTO;
import tech.jhipster.sample.service.mapper.CassTestMapstructEntityMapper;

/**
 * Integration tests for the {@link CassTestMapstructEntityResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CassTestMapstructEntityResourceIT extends AbstractCassandraTest {

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
    private CassTestMapstructEntityRepository cassTestMapstructEntityRepository;

    @Autowired
    private CassTestMapstructEntityMapper cassTestMapstructEntityMapper;

    @Autowired
    private MockMvc restCassTestMapstructEntityMockMvc;

    private CassTestMapstructEntity cassTestMapstructEntity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CassTestMapstructEntity createEntity() {
        CassTestMapstructEntity cassTestMapstructEntity = new CassTestMapstructEntity()
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
        return cassTestMapstructEntity;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CassTestMapstructEntity createUpdatedEntity() {
        CassTestMapstructEntity cassTestMapstructEntity = new CassTestMapstructEntity()
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
        return cassTestMapstructEntity;
    }

    @BeforeEach
    public void initTest() {
        cassTestMapstructEntityRepository.deleteAll();
        cassTestMapstructEntity = createEntity();
    }

    @Test
    void createCassTestMapstructEntity() throws Exception {
        int databaseSizeBeforeCreate = cassTestMapstructEntityRepository.findAll().size();
        // Create the CassTestMapstructEntity
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);
        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isCreated());

        // Validate the CassTestMapstructEntity in the database
        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeCreate + 1);
        CassTestMapstructEntity testCassTestMapstructEntity = cassTestMapstructEntityList.get(cassTestMapstructEntityList.size() - 1);
        assertThat(testCassTestMapstructEntity.getStringField()).isEqualTo(DEFAULT_STRING_FIELD);
        assertThat(testCassTestMapstructEntity.getStringRequiredField()).isEqualTo(DEFAULT_STRING_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getStringMinlengthField()).isEqualTo(DEFAULT_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestMapstructEntity.getStringMaxlengthField()).isEqualTo(DEFAULT_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestMapstructEntity.getStringPatternField()).isEqualTo(DEFAULT_STRING_PATTERN_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerField()).isEqualTo(DEFAULT_INTEGER_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerRequiredField()).isEqualTo(DEFAULT_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerMinField()).isEqualTo(DEFAULT_INTEGER_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerMaxField()).isEqualTo(DEFAULT_INTEGER_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getLongField()).isEqualTo(DEFAULT_LONG_FIELD);
        assertThat(testCassTestMapstructEntity.getLongRequiredField()).isEqualTo(DEFAULT_LONG_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getLongMinField()).isEqualTo(DEFAULT_LONG_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getLongMaxField()).isEqualTo(DEFAULT_LONG_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatField()).isEqualTo(DEFAULT_FLOAT_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatRequiredField()).isEqualTo(DEFAULT_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatMinField()).isEqualTo(DEFAULT_FLOAT_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatMaxField()).isEqualTo(DEFAULT_FLOAT_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleRequiredField()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleMinField()).isEqualTo(DEFAULT_DOUBLE_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleMaxField()).isEqualTo(DEFAULT_DOUBLE_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalRequiredField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalMinField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalMaxField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getLocalDateField()).isEqualTo(DEFAULT_LOCAL_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getLocalDateRequiredField()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getInstantDateField()).isEqualTo(DEFAULT_INSTANT_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getInstantRequiredField()).isEqualTo(DEFAULT_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getZonedDateTimeField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestMapstructEntity.getZonedDateTimeRequiredField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getDurationDateField()).isEqualTo(DEFAULT_DURATION_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getDurationRequiredField()).isEqualTo(DEFAULT_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getBooleanField()).isEqualTo(DEFAULT_BOOLEAN_FIELD);
        assertThat(testCassTestMapstructEntity.getBooleanRequiredField()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getEnumTom()).isEqualTo(DEFAULT_ENUM_TOM);
        assertThat(testCassTestMapstructEntity.getEnumRequiredTom()).isEqualTo(DEFAULT_ENUM_REQUIRED_TOM);
        assertThat(testCassTestMapstructEntity.getPicture()).isEqualTo(DEFAULT_PICTURE);
        assertThat(testCassTestMapstructEntity.getPictureContentType()).isEqualTo(DEFAULT_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestMapstructEntity.getOperationsFile()).isEqualTo(DEFAULT_OPERATIONS_FILE);
        assertThat(testCassTestMapstructEntity.getOperationsFileContentType()).isEqualTo(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void createCassTestMapstructEntityWithExistingId() throws Exception {
        // Create the CassTestMapstructEntity with an existing ID
        cassTestMapstructEntity.setId(UUID.randomUUID());
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        int databaseSizeBeforeCreate = cassTestMapstructEntityRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CassTestMapstructEntity in the database
        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkStringRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setStringRequiredField(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkIntegerRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setIntegerRequiredField(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLongRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setLongRequiredField(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkFloatRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setFloatRequiredField(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDoubleRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setDoubleRequiredField(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBigDecimalRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setBigDecimalRequiredField(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLocalDateRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setLocalDateRequiredField(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkInstantRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setInstantRequiredField(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkZonedDateTimeRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setZonedDateTimeRequiredField(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDurationRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setDurationRequiredField(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBooleanRequiredFieldIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setBooleanRequiredField(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkEnumRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassTestMapstructEntityRepository.findAll().size();
        // set the field null
        cassTestMapstructEntity.setEnumRequiredTom(null);

        // Create the CassTestMapstructEntity, which fails.
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                post("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllCassTestMapstructEntities() throws Exception {
        // Initialize the database
        cassTestMapstructEntity.setId(UUID.randomUUID());
        cassTestMapstructEntityRepository.save(cassTestMapstructEntity);

        // Get all the cassTestMapstructEntityList
        restCassTestMapstructEntityMockMvc
            .perform(get("/api/cass-test-mapstruct-entities"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cassTestMapstructEntity.getId().toString())))
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
    void getCassTestMapstructEntity() throws Exception {
        // Initialize the database
        cassTestMapstructEntity.setId(UUID.randomUUID());
        cassTestMapstructEntityRepository.save(cassTestMapstructEntity);

        // Get the cassTestMapstructEntity
        restCassTestMapstructEntityMockMvc
            .perform(get("/api/cass-test-mapstruct-entities/{id}", cassTestMapstructEntity.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(cassTestMapstructEntity.getId().toString()))
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
    void getNonExistingCassTestMapstructEntity() throws Exception {
        // Get the cassTestMapstructEntity
        restCassTestMapstructEntityMockMvc
            .perform(get("/api/cass-test-mapstruct-entities/{id}", UUID.randomUUID().toString()))
            .andExpect(status().isNotFound());
    }

    @Test
    void updateCassTestMapstructEntity() throws Exception {
        // Initialize the database
        cassTestMapstructEntity.setId(UUID.randomUUID());
        cassTestMapstructEntityRepository.save(cassTestMapstructEntity);

        int databaseSizeBeforeUpdate = cassTestMapstructEntityRepository.findAll().size();

        // Update the cassTestMapstructEntity
        CassTestMapstructEntity updatedCassTestMapstructEntity = cassTestMapstructEntityRepository
            .findById(cassTestMapstructEntity.getId())
            .get();
        updatedCassTestMapstructEntity
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
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(updatedCassTestMapstructEntity);

        restCassTestMapstructEntityMockMvc
            .perform(
                put("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isOk());

        // Validate the CassTestMapstructEntity in the database
        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestMapstructEntity testCassTestMapstructEntity = cassTestMapstructEntityList.get(cassTestMapstructEntityList.size() - 1);
        assertThat(testCassTestMapstructEntity.getStringField()).isEqualTo(UPDATED_STRING_FIELD);
        assertThat(testCassTestMapstructEntity.getStringRequiredField()).isEqualTo(UPDATED_STRING_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getStringMinlengthField()).isEqualTo(UPDATED_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestMapstructEntity.getStringMaxlengthField()).isEqualTo(UPDATED_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestMapstructEntity.getStringPatternField()).isEqualTo(UPDATED_STRING_PATTERN_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerRequiredField()).isEqualTo(UPDATED_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerMinField()).isEqualTo(UPDATED_INTEGER_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerMaxField()).isEqualTo(UPDATED_INTEGER_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getLongField()).isEqualTo(UPDATED_LONG_FIELD);
        assertThat(testCassTestMapstructEntity.getLongRequiredField()).isEqualTo(UPDATED_LONG_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getLongMinField()).isEqualTo(UPDATED_LONG_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatField()).isEqualTo(UPDATED_FLOAT_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatRequiredField()).isEqualTo(UPDATED_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatMinField()).isEqualTo(UPDATED_FLOAT_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatMaxField()).isEqualTo(UPDATED_FLOAT_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleRequiredField()).isEqualTo(UPDATED_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleMinField()).isEqualTo(UPDATED_DOUBLE_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleMaxField()).isEqualTo(UPDATED_DOUBLE_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalRequiredField()).isEqualTo(UPDATED_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalMinField()).isEqualTo(UPDATED_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalMaxField()).isEqualTo(UPDATED_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getLocalDateField()).isEqualTo(UPDATED_LOCAL_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getLocalDateRequiredField()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getInstantDateField()).isEqualTo(UPDATED_INSTANT_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getInstantRequiredField()).isEqualTo(UPDATED_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getZonedDateTimeField()).isEqualTo(UPDATED_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestMapstructEntity.getZonedDateTimeRequiredField()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getDurationDateField()).isEqualTo(UPDATED_DURATION_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getDurationRequiredField()).isEqualTo(UPDATED_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getBooleanField()).isEqualTo(UPDATED_BOOLEAN_FIELD);
        assertThat(testCassTestMapstructEntity.getBooleanRequiredField()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testCassTestMapstructEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testCassTestMapstructEntity.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassTestMapstructEntity.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestMapstructEntity.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassTestMapstructEntity.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void updateNonExistingCassTestMapstructEntity() throws Exception {
        int databaseSizeBeforeUpdate = cassTestMapstructEntityRepository.findAll().size();

        // Create the CassTestMapstructEntity
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCassTestMapstructEntityMockMvc
            .perform(
                put("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassTestMapstructEntityDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CassTestMapstructEntity in the database
        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateCassTestMapstructEntityWithPatch() throws Exception {
        // Initialize the database
        cassTestMapstructEntity.setId(UUID.randomUUID());
        cassTestMapstructEntityRepository.save(cassTestMapstructEntity);

        int databaseSizeBeforeUpdate = cassTestMapstructEntityRepository.findAll().size();

        // Update the cassTestMapstructEntity using partial update
        CassTestMapstructEntity partialUpdatedCassTestMapstructEntity = new CassTestMapstructEntity();
        partialUpdatedCassTestMapstructEntity.setId(cassTestMapstructEntity.getId());

        partialUpdatedCassTestMapstructEntity
            .stringRequiredField(UPDATED_STRING_REQUIRED_FIELD)
            .stringPatternField(UPDATED_STRING_PATTERN_FIELD)
            .integerField(UPDATED_INTEGER_FIELD)
            .integerRequiredField(UPDATED_INTEGER_REQUIRED_FIELD)
            .integerMaxField(UPDATED_INTEGER_MAX_FIELD)
            .longField(UPDATED_LONG_FIELD)
            .longRequiredField(UPDATED_LONG_REQUIRED_FIELD)
            .longMaxField(UPDATED_LONG_MAX_FIELD)
            .doubleRequiredField(UPDATED_DOUBLE_REQUIRED_FIELD)
            .zonedDateTimeField(UPDATED_ZONED_DATE_TIME_FIELD)
            .durationDateField(UPDATED_DURATION_DATE_FIELD)
            .enumRequiredTom(UPDATED_ENUM_REQUIRED_TOM)
            .picture(UPDATED_PICTURE)
            .pictureContentType(UPDATED_PICTURE_CONTENT_TYPE);

        restCassTestMapstructEntityMockMvc
            .perform(
                patch("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestMapstructEntity))
            )
            .andExpect(status().isOk());

        // Validate the CassTestMapstructEntity in the database
        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestMapstructEntity testCassTestMapstructEntity = cassTestMapstructEntityList.get(cassTestMapstructEntityList.size() - 1);
        assertThat(testCassTestMapstructEntity.getStringField()).isEqualTo(DEFAULT_STRING_FIELD);
        assertThat(testCassTestMapstructEntity.getStringRequiredField()).isEqualTo(UPDATED_STRING_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getStringMinlengthField()).isEqualTo(DEFAULT_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestMapstructEntity.getStringMaxlengthField()).isEqualTo(DEFAULT_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestMapstructEntity.getStringPatternField()).isEqualTo(UPDATED_STRING_PATTERN_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerRequiredField()).isEqualTo(UPDATED_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerMinField()).isEqualTo(DEFAULT_INTEGER_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerMaxField()).isEqualTo(UPDATED_INTEGER_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getLongField()).isEqualTo(UPDATED_LONG_FIELD);
        assertThat(testCassTestMapstructEntity.getLongRequiredField()).isEqualTo(UPDATED_LONG_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getLongMinField()).isEqualTo(DEFAULT_LONG_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatField()).isEqualTo(DEFAULT_FLOAT_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatRequiredField()).isEqualTo(DEFAULT_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatMinField()).isEqualTo(DEFAULT_FLOAT_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatMaxField()).isEqualTo(DEFAULT_FLOAT_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleRequiredField()).isEqualTo(UPDATED_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleMinField()).isEqualTo(DEFAULT_DOUBLE_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleMaxField()).isEqualTo(DEFAULT_DOUBLE_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalRequiredField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalMinField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalMaxField()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getLocalDateField()).isEqualTo(DEFAULT_LOCAL_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getLocalDateRequiredField()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getInstantDateField()).isEqualTo(DEFAULT_INSTANT_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getInstantRequiredField()).isEqualTo(DEFAULT_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getZonedDateTimeField()).isEqualTo(UPDATED_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestMapstructEntity.getZonedDateTimeRequiredField()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getDurationDateField()).isEqualTo(UPDATED_DURATION_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getDurationRequiredField()).isEqualTo(DEFAULT_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getBooleanField()).isEqualTo(DEFAULT_BOOLEAN_FIELD);
        assertThat(testCassTestMapstructEntity.getBooleanRequiredField()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getEnumTom()).isEqualTo(DEFAULT_ENUM_TOM);
        assertThat(testCassTestMapstructEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testCassTestMapstructEntity.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassTestMapstructEntity.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestMapstructEntity.getOperationsFile()).isEqualTo(DEFAULT_OPERATIONS_FILE);
        assertThat(testCassTestMapstructEntity.getOperationsFileContentType()).isEqualTo(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void fullUpdateCassTestMapstructEntityWithPatch() throws Exception {
        // Initialize the database
        cassTestMapstructEntity.setId(UUID.randomUUID());
        cassTestMapstructEntityRepository.save(cassTestMapstructEntity);

        int databaseSizeBeforeUpdate = cassTestMapstructEntityRepository.findAll().size();

        // Update the cassTestMapstructEntity using partial update
        CassTestMapstructEntity partialUpdatedCassTestMapstructEntity = new CassTestMapstructEntity();
        partialUpdatedCassTestMapstructEntity.setId(cassTestMapstructEntity.getId());

        partialUpdatedCassTestMapstructEntity
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

        restCassTestMapstructEntityMockMvc
            .perform(
                patch("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestMapstructEntity))
            )
            .andExpect(status().isOk());

        // Validate the CassTestMapstructEntity in the database
        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeUpdate);
        CassTestMapstructEntity testCassTestMapstructEntity = cassTestMapstructEntityList.get(cassTestMapstructEntityList.size() - 1);
        assertThat(testCassTestMapstructEntity.getStringField()).isEqualTo(UPDATED_STRING_FIELD);
        assertThat(testCassTestMapstructEntity.getStringRequiredField()).isEqualTo(UPDATED_STRING_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getStringMinlengthField()).isEqualTo(UPDATED_STRING_MINLENGTH_FIELD);
        assertThat(testCassTestMapstructEntity.getStringMaxlengthField()).isEqualTo(UPDATED_STRING_MAXLENGTH_FIELD);
        assertThat(testCassTestMapstructEntity.getStringPatternField()).isEqualTo(UPDATED_STRING_PATTERN_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerField()).isEqualTo(UPDATED_INTEGER_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerRequiredField()).isEqualTo(UPDATED_INTEGER_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerMinField()).isEqualTo(UPDATED_INTEGER_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getIntegerMaxField()).isEqualTo(UPDATED_INTEGER_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getLongField()).isEqualTo(UPDATED_LONG_FIELD);
        assertThat(testCassTestMapstructEntity.getLongRequiredField()).isEqualTo(UPDATED_LONG_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getLongMinField()).isEqualTo(UPDATED_LONG_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getLongMaxField()).isEqualTo(UPDATED_LONG_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatField()).isEqualTo(UPDATED_FLOAT_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatRequiredField()).isEqualTo(UPDATED_FLOAT_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatMinField()).isEqualTo(UPDATED_FLOAT_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getFloatMaxField()).isEqualTo(UPDATED_FLOAT_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleRequiredField()).isEqualTo(UPDATED_DOUBLE_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleMinField()).isEqualTo(UPDATED_DOUBLE_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getDoubleMaxField()).isEqualTo(UPDATED_DOUBLE_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalRequiredField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalMinField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MIN_FIELD);
        assertThat(testCassTestMapstructEntity.getBigDecimalMaxField()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_FIELD);
        assertThat(testCassTestMapstructEntity.getLocalDateField()).isEqualTo(UPDATED_LOCAL_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getLocalDateRequiredField()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getInstantDateField()).isEqualTo(UPDATED_INSTANT_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getInstantRequiredField()).isEqualTo(UPDATED_INSTANT_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getZonedDateTimeField()).isEqualTo(UPDATED_ZONED_DATE_TIME_FIELD);
        assertThat(testCassTestMapstructEntity.getZonedDateTimeRequiredField()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getDurationDateField()).isEqualTo(UPDATED_DURATION_DATE_FIELD);
        assertThat(testCassTestMapstructEntity.getDurationRequiredField()).isEqualTo(UPDATED_DURATION_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getBooleanField()).isEqualTo(UPDATED_BOOLEAN_FIELD);
        assertThat(testCassTestMapstructEntity.getBooleanRequiredField()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_FIELD);
        assertThat(testCassTestMapstructEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testCassTestMapstructEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testCassTestMapstructEntity.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassTestMapstructEntity.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassTestMapstructEntity.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassTestMapstructEntity.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
    }

    @Test
    void partialUpdateCassTestMapstructEntityShouldThrown() throws Exception {
        // Update the cassTestMapstructEntity without id should throw
        CassTestMapstructEntity partialUpdatedCassTestMapstructEntity = new CassTestMapstructEntity();

        restCassTestMapstructEntityMockMvc
            .perform(
                patch("/api/cass-test-mapstruct-entities")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassTestMapstructEntity))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    void deleteCassTestMapstructEntity() throws Exception {
        // Initialize the database
        cassTestMapstructEntity.setId(UUID.randomUUID());
        cassTestMapstructEntityRepository.save(cassTestMapstructEntity);

        int databaseSizeBeforeDelete = cassTestMapstructEntityRepository.findAll().size();

        // Delete the cassTestMapstructEntity
        restCassTestMapstructEntityMockMvc
            .perform(
                delete("/api/cass-test-mapstruct-entities/{id}", cassTestMapstructEntity.getId())
                    .with(csrf())
                    .accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CassTestMapstructEntity> cassTestMapstructEntityList = cassTestMapstructEntityRepository.findAll();
        assertThat(cassTestMapstructEntityList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
