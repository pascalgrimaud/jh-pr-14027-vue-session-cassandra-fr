package tech.jhipster.sample.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static tech.jhipster.sample.web.rest.TestUtil.sameNumber;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.time.Instant;
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
import tech.jhipster.sample.domain.CassBankAccount;
import tech.jhipster.sample.domain.enumeration.AccountTypeEnum;
import tech.jhipster.sample.repository.CassBankAccountRepository;
import tech.jhipster.sample.service.dto.CassBankAccountDTO;
import tech.jhipster.sample.service.mapper.CassBankAccountMapper;

/**
 * Integration tests for the {@link CassBankAccountResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CassBankAccountResourceIT extends AbstractCassandraTest {

    private static final UUID DEFAULT_USER_ID = UUID.randomUUID();
    private static final UUID UPDATED_USER_ID = UUID.randomUUID();

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_BANK_NUMBER = 1;
    private static final Integer UPDATED_BANK_NUMBER = 2;

    private static final Long DEFAULT_AGENCY_NUMBER = 1L;
    private static final Long UPDATED_AGENCY_NUMBER = 2L;

    private static final Float DEFAULT_LAST_OPERATION_DURATION = 1F;
    private static final Float UPDATED_LAST_OPERATION_DURATION = 2F;

    private static final Double DEFAULT_MEAN_OPERATION_DURATION = 1D;
    private static final Double UPDATED_MEAN_OPERATION_DURATION = 2D;

    private static final BigDecimal DEFAULT_BALANCE = new BigDecimal(1);
    private static final BigDecimal UPDATED_BALANCE = new BigDecimal(2);

    private static final Instant DEFAULT_LAST_OPERATION_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAST_OPERATION_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_ACTIVE = false;
    private static final Boolean UPDATED_ACTIVE = true;

    private static final ByteBuffer DEFAULT_PICTURE = ByteBuffer.wrap(TestUtil.createByteArray(1, "0"));
    private static final ByteBuffer UPDATED_PICTURE = ByteBuffer.wrap(TestUtil.createByteArray(1, "1"));
    private static final String DEFAULT_PICTURE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_PICTURE_CONTENT_TYPE = "image/png";

    private static final ByteBuffer DEFAULT_OPERATIONS_FILE = ByteBuffer.wrap(TestUtil.createByteArray(1, "0"));
    private static final ByteBuffer UPDATED_OPERATIONS_FILE = ByteBuffer.wrap(TestUtil.createByteArray(1, "1"));
    private static final String DEFAULT_OPERATIONS_FILE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OPERATIONS_FILE_CONTENT_TYPE = "image/png";

    private static final AccountTypeEnum DEFAULT_ACCOUNT_TYPE = AccountTypeEnum.STANDARD;
    private static final AccountTypeEnum UPDATED_ACCOUNT_TYPE = AccountTypeEnum.PREMIUM;

    @Autowired
    private CassBankAccountRepository cassBankAccountRepository;

    @Autowired
    private CassBankAccountMapper cassBankAccountMapper;

    @Autowired
    private MockMvc restCassBankAccountMockMvc;

    private CassBankAccount cassBankAccount;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CassBankAccount createEntity() {
        CassBankAccount cassBankAccount = new CassBankAccount()
            .userId(DEFAULT_USER_ID)
            .name(DEFAULT_NAME)
            .bankNumber(DEFAULT_BANK_NUMBER)
            .agencyNumber(DEFAULT_AGENCY_NUMBER)
            .lastOperationDuration(DEFAULT_LAST_OPERATION_DURATION)
            .meanOperationDuration(DEFAULT_MEAN_OPERATION_DURATION)
            .balance(DEFAULT_BALANCE)
            .lastOperationDate(DEFAULT_LAST_OPERATION_DATE)
            .active(DEFAULT_ACTIVE)
            .picture(DEFAULT_PICTURE)
            .pictureContentType(DEFAULT_PICTURE_CONTENT_TYPE)
            .operationsFile(DEFAULT_OPERATIONS_FILE)
            .operationsFileContentType(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE)
            .accountType(DEFAULT_ACCOUNT_TYPE);
        return cassBankAccount;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CassBankAccount createUpdatedEntity() {
        CassBankAccount cassBankAccount = new CassBankAccount()
            .userId(UPDATED_USER_ID)
            .name(UPDATED_NAME)
            .bankNumber(UPDATED_BANK_NUMBER)
            .agencyNumber(UPDATED_AGENCY_NUMBER)
            .lastOperationDuration(UPDATED_LAST_OPERATION_DURATION)
            .meanOperationDuration(UPDATED_MEAN_OPERATION_DURATION)
            .balance(UPDATED_BALANCE)
            .lastOperationDate(UPDATED_LAST_OPERATION_DATE)
            .active(UPDATED_ACTIVE)
            .picture(UPDATED_PICTURE)
            .pictureContentType(UPDATED_PICTURE_CONTENT_TYPE)
            .operationsFile(UPDATED_OPERATIONS_FILE)
            .operationsFileContentType(UPDATED_OPERATIONS_FILE_CONTENT_TYPE)
            .accountType(UPDATED_ACCOUNT_TYPE);
        return cassBankAccount;
    }

    @BeforeEach
    public void initTest() {
        cassBankAccountRepository.deleteAll();
        cassBankAccount = createEntity();
    }

    @Test
    void createCassBankAccount() throws Exception {
        int databaseSizeBeforeCreate = cassBankAccountRepository.findAll().size();
        // Create the CassBankAccount
        CassBankAccountDTO cassBankAccountDTO = cassBankAccountMapper.toDto(cassBankAccount);
        restCassBankAccountMockMvc
            .perform(
                post("/api/cass-bank-accounts")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassBankAccountDTO))
            )
            .andExpect(status().isCreated());

        // Validate the CassBankAccount in the database
        List<CassBankAccount> cassBankAccountList = cassBankAccountRepository.findAll();
        assertThat(cassBankAccountList).hasSize(databaseSizeBeforeCreate + 1);
        CassBankAccount testCassBankAccount = cassBankAccountList.get(cassBankAccountList.size() - 1);
        assertThat(testCassBankAccount.getUserId()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testCassBankAccount.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testCassBankAccount.getBankNumber()).isEqualTo(DEFAULT_BANK_NUMBER);
        assertThat(testCassBankAccount.getAgencyNumber()).isEqualTo(DEFAULT_AGENCY_NUMBER);
        assertThat(testCassBankAccount.getLastOperationDuration()).isEqualTo(DEFAULT_LAST_OPERATION_DURATION);
        assertThat(testCassBankAccount.getMeanOperationDuration()).isEqualTo(DEFAULT_MEAN_OPERATION_DURATION);
        assertThat(testCassBankAccount.getBalance()).isEqualByComparingTo(DEFAULT_BALANCE);
        assertThat(testCassBankAccount.getLastOperationDate()).isEqualTo(DEFAULT_LAST_OPERATION_DATE);
        assertThat(testCassBankAccount.getActive()).isEqualTo(DEFAULT_ACTIVE);
        assertThat(testCassBankAccount.getPicture()).isEqualTo(DEFAULT_PICTURE);
        assertThat(testCassBankAccount.getPictureContentType()).isEqualTo(DEFAULT_PICTURE_CONTENT_TYPE);
        assertThat(testCassBankAccount.getOperationsFile()).isEqualTo(DEFAULT_OPERATIONS_FILE);
        assertThat(testCassBankAccount.getOperationsFileContentType()).isEqualTo(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE);
        assertThat(testCassBankAccount.getAccountType()).isEqualTo(DEFAULT_ACCOUNT_TYPE);
    }

    @Test
    void createCassBankAccountWithExistingId() throws Exception {
        // Create the CassBankAccount with an existing ID
        cassBankAccount.setId(UUID.randomUUID());
        CassBankAccountDTO cassBankAccountDTO = cassBankAccountMapper.toDto(cassBankAccount);

        int databaseSizeBeforeCreate = cassBankAccountRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCassBankAccountMockMvc
            .perform(
                post("/api/cass-bank-accounts")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassBankAccountDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CassBankAccount in the database
        List<CassBankAccount> cassBankAccountList = cassBankAccountRepository.findAll();
        assertThat(cassBankAccountList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassBankAccountRepository.findAll().size();
        // set the field null
        cassBankAccount.setName(null);

        // Create the CassBankAccount, which fails.
        CassBankAccountDTO cassBankAccountDTO = cassBankAccountMapper.toDto(cassBankAccount);

        restCassBankAccountMockMvc
            .perform(
                post("/api/cass-bank-accounts")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassBankAccountDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassBankAccount> cassBankAccountList = cassBankAccountRepository.findAll();
        assertThat(cassBankAccountList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBalanceIsRequired() throws Exception {
        int databaseSizeBeforeTest = cassBankAccountRepository.findAll().size();
        // set the field null
        cassBankAccount.setBalance(null);

        // Create the CassBankAccount, which fails.
        CassBankAccountDTO cassBankAccountDTO = cassBankAccountMapper.toDto(cassBankAccount);

        restCassBankAccountMockMvc
            .perform(
                post("/api/cass-bank-accounts")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassBankAccountDTO))
            )
            .andExpect(status().isBadRequest());

        List<CassBankAccount> cassBankAccountList = cassBankAccountRepository.findAll();
        assertThat(cassBankAccountList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllCassBankAccounts() throws Exception {
        // Initialize the database
        cassBankAccount.setId(UUID.randomUUID());
        cassBankAccountRepository.save(cassBankAccount);

        // Get all the cassBankAccountList
        restCassBankAccountMockMvc
            .perform(get("/api/cass-bank-accounts"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cassBankAccount.getId().toString())))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].bankNumber").value(hasItem(DEFAULT_BANK_NUMBER)))
            .andExpect(jsonPath("$.[*].agencyNumber").value(hasItem(DEFAULT_AGENCY_NUMBER.intValue())))
            .andExpect(jsonPath("$.[*].lastOperationDuration").value(hasItem(DEFAULT_LAST_OPERATION_DURATION.doubleValue())))
            .andExpect(jsonPath("$.[*].meanOperationDuration").value(hasItem(DEFAULT_MEAN_OPERATION_DURATION.doubleValue())))
            .andExpect(jsonPath("$.[*].balance").value(hasItem(sameNumber(DEFAULT_BALANCE))))
            .andExpect(jsonPath("$.[*].lastOperationDate").value(hasItem(DEFAULT_LAST_OPERATION_DATE.toString())))
            .andExpect(jsonPath("$.[*].active").value(hasItem(DEFAULT_ACTIVE.booleanValue())))
            .andExpect(jsonPath("$.[*].pictureContentType").value(hasItem(DEFAULT_PICTURE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].picture").value(hasItem(Base64Utils.encodeToString(DEFAULT_PICTURE.array()))))
            .andExpect(jsonPath("$.[*].operationsFileContentType").value(hasItem(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].operationsFile").value(hasItem(Base64Utils.encodeToString(DEFAULT_OPERATIONS_FILE.array()))))
            .andExpect(jsonPath("$.[*].accountType").value(hasItem(DEFAULT_ACCOUNT_TYPE.toString())));
    }

    @Test
    void getCassBankAccount() throws Exception {
        // Initialize the database
        cassBankAccount.setId(UUID.randomUUID());
        cassBankAccountRepository.save(cassBankAccount);

        // Get the cassBankAccount
        restCassBankAccountMockMvc
            .perform(get("/api/cass-bank-accounts/{id}", cassBankAccount.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(cassBankAccount.getId().toString()))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID.toString()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.bankNumber").value(DEFAULT_BANK_NUMBER))
            .andExpect(jsonPath("$.agencyNumber").value(DEFAULT_AGENCY_NUMBER.intValue()))
            .andExpect(jsonPath("$.lastOperationDuration").value(DEFAULT_LAST_OPERATION_DURATION.doubleValue()))
            .andExpect(jsonPath("$.meanOperationDuration").value(DEFAULT_MEAN_OPERATION_DURATION.doubleValue()))
            .andExpect(jsonPath("$.balance").value(sameNumber(DEFAULT_BALANCE)))
            .andExpect(jsonPath("$.lastOperationDate").value(DEFAULT_LAST_OPERATION_DATE.toString()))
            .andExpect(jsonPath("$.active").value(DEFAULT_ACTIVE.booleanValue()))
            .andExpect(jsonPath("$.pictureContentType").value(DEFAULT_PICTURE_CONTENT_TYPE))
            .andExpect(jsonPath("$.picture").value(Base64Utils.encodeToString(DEFAULT_PICTURE.array())))
            .andExpect(jsonPath("$.operationsFileContentType").value(DEFAULT_OPERATIONS_FILE_CONTENT_TYPE))
            .andExpect(jsonPath("$.operationsFile").value(Base64Utils.encodeToString(DEFAULT_OPERATIONS_FILE.array())))
            .andExpect(jsonPath("$.accountType").value(DEFAULT_ACCOUNT_TYPE.toString()));
    }

    @Test
    void getNonExistingCassBankAccount() throws Exception {
        // Get the cassBankAccount
        restCassBankAccountMockMvc
            .perform(get("/api/cass-bank-accounts/{id}", UUID.randomUUID().toString()))
            .andExpect(status().isNotFound());
    }

    @Test
    void updateCassBankAccount() throws Exception {
        // Initialize the database
        cassBankAccount.setId(UUID.randomUUID());
        cassBankAccountRepository.save(cassBankAccount);

        int databaseSizeBeforeUpdate = cassBankAccountRepository.findAll().size();

        // Update the cassBankAccount
        CassBankAccount updatedCassBankAccount = cassBankAccountRepository.findById(cassBankAccount.getId()).get();
        updatedCassBankAccount
            .userId(UPDATED_USER_ID)
            .name(UPDATED_NAME)
            .bankNumber(UPDATED_BANK_NUMBER)
            .agencyNumber(UPDATED_AGENCY_NUMBER)
            .lastOperationDuration(UPDATED_LAST_OPERATION_DURATION)
            .meanOperationDuration(UPDATED_MEAN_OPERATION_DURATION)
            .balance(UPDATED_BALANCE)
            .lastOperationDate(UPDATED_LAST_OPERATION_DATE)
            .active(UPDATED_ACTIVE)
            .picture(UPDATED_PICTURE)
            .pictureContentType(UPDATED_PICTURE_CONTENT_TYPE)
            .operationsFile(UPDATED_OPERATIONS_FILE)
            .operationsFileContentType(UPDATED_OPERATIONS_FILE_CONTENT_TYPE)
            .accountType(UPDATED_ACCOUNT_TYPE);
        CassBankAccountDTO cassBankAccountDTO = cassBankAccountMapper.toDto(updatedCassBankAccount);

        restCassBankAccountMockMvc
            .perform(
                put("/api/cass-bank-accounts")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassBankAccountDTO))
            )
            .andExpect(status().isOk());

        // Validate the CassBankAccount in the database
        List<CassBankAccount> cassBankAccountList = cassBankAccountRepository.findAll();
        assertThat(cassBankAccountList).hasSize(databaseSizeBeforeUpdate);
        CassBankAccount testCassBankAccount = cassBankAccountList.get(cassBankAccountList.size() - 1);
        assertThat(testCassBankAccount.getUserId()).isEqualTo(UPDATED_USER_ID);
        assertThat(testCassBankAccount.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testCassBankAccount.getBankNumber()).isEqualTo(UPDATED_BANK_NUMBER);
        assertThat(testCassBankAccount.getAgencyNumber()).isEqualTo(UPDATED_AGENCY_NUMBER);
        assertThat(testCassBankAccount.getLastOperationDuration()).isEqualTo(UPDATED_LAST_OPERATION_DURATION);
        assertThat(testCassBankAccount.getMeanOperationDuration()).isEqualTo(UPDATED_MEAN_OPERATION_DURATION);
        assertThat(testCassBankAccount.getBalance()).isEqualTo(UPDATED_BALANCE);
        assertThat(testCassBankAccount.getLastOperationDate()).isEqualTo(UPDATED_LAST_OPERATION_DATE);
        assertThat(testCassBankAccount.getActive()).isEqualTo(UPDATED_ACTIVE);
        assertThat(testCassBankAccount.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassBankAccount.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassBankAccount.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassBankAccount.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
        assertThat(testCassBankAccount.getAccountType()).isEqualTo(UPDATED_ACCOUNT_TYPE);
    }

    @Test
    void updateNonExistingCassBankAccount() throws Exception {
        int databaseSizeBeforeUpdate = cassBankAccountRepository.findAll().size();

        // Create the CassBankAccount
        CassBankAccountDTO cassBankAccountDTO = cassBankAccountMapper.toDto(cassBankAccount);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCassBankAccountMockMvc
            .perform(
                put("/api/cass-bank-accounts")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(cassBankAccountDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the CassBankAccount in the database
        List<CassBankAccount> cassBankAccountList = cassBankAccountRepository.findAll();
        assertThat(cassBankAccountList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateCassBankAccountWithPatch() throws Exception {
        // Initialize the database
        cassBankAccount.setId(UUID.randomUUID());
        cassBankAccountRepository.save(cassBankAccount);

        int databaseSizeBeforeUpdate = cassBankAccountRepository.findAll().size();

        // Update the cassBankAccount using partial update
        CassBankAccount partialUpdatedCassBankAccount = new CassBankAccount();
        partialUpdatedCassBankAccount.setId(cassBankAccount.getId());

        partialUpdatedCassBankAccount
            .bankNumber(UPDATED_BANK_NUMBER)
            .agencyNumber(UPDATED_AGENCY_NUMBER)
            .lastOperationDuration(UPDATED_LAST_OPERATION_DURATION)
            .balance(UPDATED_BALANCE)
            .active(UPDATED_ACTIVE)
            .picture(UPDATED_PICTURE)
            .pictureContentType(UPDATED_PICTURE_CONTENT_TYPE)
            .operationsFile(UPDATED_OPERATIONS_FILE)
            .operationsFileContentType(UPDATED_OPERATIONS_FILE_CONTENT_TYPE)
            .accountType(UPDATED_ACCOUNT_TYPE);

        restCassBankAccountMockMvc
            .perform(
                patch("/api/cass-bank-accounts")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassBankAccount))
            )
            .andExpect(status().isOk());

        // Validate the CassBankAccount in the database
        List<CassBankAccount> cassBankAccountList = cassBankAccountRepository.findAll();
        assertThat(cassBankAccountList).hasSize(databaseSizeBeforeUpdate);
        CassBankAccount testCassBankAccount = cassBankAccountList.get(cassBankAccountList.size() - 1);
        assertThat(testCassBankAccount.getUserId()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testCassBankAccount.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testCassBankAccount.getBankNumber()).isEqualTo(UPDATED_BANK_NUMBER);
        assertThat(testCassBankAccount.getAgencyNumber()).isEqualTo(UPDATED_AGENCY_NUMBER);
        assertThat(testCassBankAccount.getLastOperationDuration()).isEqualTo(UPDATED_LAST_OPERATION_DURATION);
        assertThat(testCassBankAccount.getMeanOperationDuration()).isEqualTo(DEFAULT_MEAN_OPERATION_DURATION);
        assertThat(testCassBankAccount.getBalance()).isEqualByComparingTo(UPDATED_BALANCE);
        assertThat(testCassBankAccount.getLastOperationDate()).isEqualTo(DEFAULT_LAST_OPERATION_DATE);
        assertThat(testCassBankAccount.getActive()).isEqualTo(UPDATED_ACTIVE);
        assertThat(testCassBankAccount.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassBankAccount.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassBankAccount.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassBankAccount.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
        assertThat(testCassBankAccount.getAccountType()).isEqualTo(UPDATED_ACCOUNT_TYPE);
    }

    @Test
    void fullUpdateCassBankAccountWithPatch() throws Exception {
        // Initialize the database
        cassBankAccount.setId(UUID.randomUUID());
        cassBankAccountRepository.save(cassBankAccount);

        int databaseSizeBeforeUpdate = cassBankAccountRepository.findAll().size();

        // Update the cassBankAccount using partial update
        CassBankAccount partialUpdatedCassBankAccount = new CassBankAccount();
        partialUpdatedCassBankAccount.setId(cassBankAccount.getId());

        partialUpdatedCassBankAccount
            .userId(UPDATED_USER_ID)
            .name(UPDATED_NAME)
            .bankNumber(UPDATED_BANK_NUMBER)
            .agencyNumber(UPDATED_AGENCY_NUMBER)
            .lastOperationDuration(UPDATED_LAST_OPERATION_DURATION)
            .meanOperationDuration(UPDATED_MEAN_OPERATION_DURATION)
            .balance(UPDATED_BALANCE)
            .lastOperationDate(UPDATED_LAST_OPERATION_DATE)
            .active(UPDATED_ACTIVE)
            .picture(UPDATED_PICTURE)
            .pictureContentType(UPDATED_PICTURE_CONTENT_TYPE)
            .operationsFile(UPDATED_OPERATIONS_FILE)
            .operationsFileContentType(UPDATED_OPERATIONS_FILE_CONTENT_TYPE)
            .accountType(UPDATED_ACCOUNT_TYPE);

        restCassBankAccountMockMvc
            .perform(
                patch("/api/cass-bank-accounts")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassBankAccount))
            )
            .andExpect(status().isOk());

        // Validate the CassBankAccount in the database
        List<CassBankAccount> cassBankAccountList = cassBankAccountRepository.findAll();
        assertThat(cassBankAccountList).hasSize(databaseSizeBeforeUpdate);
        CassBankAccount testCassBankAccount = cassBankAccountList.get(cassBankAccountList.size() - 1);
        assertThat(testCassBankAccount.getUserId()).isEqualTo(UPDATED_USER_ID);
        assertThat(testCassBankAccount.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testCassBankAccount.getBankNumber()).isEqualTo(UPDATED_BANK_NUMBER);
        assertThat(testCassBankAccount.getAgencyNumber()).isEqualTo(UPDATED_AGENCY_NUMBER);
        assertThat(testCassBankAccount.getLastOperationDuration()).isEqualTo(UPDATED_LAST_OPERATION_DURATION);
        assertThat(testCassBankAccount.getMeanOperationDuration()).isEqualTo(UPDATED_MEAN_OPERATION_DURATION);
        assertThat(testCassBankAccount.getBalance()).isEqualByComparingTo(UPDATED_BALANCE);
        assertThat(testCassBankAccount.getLastOperationDate()).isEqualTo(UPDATED_LAST_OPERATION_DATE);
        assertThat(testCassBankAccount.getActive()).isEqualTo(UPDATED_ACTIVE);
        assertThat(testCassBankAccount.getPicture()).isEqualTo(UPDATED_PICTURE);
        assertThat(testCassBankAccount.getPictureContentType()).isEqualTo(UPDATED_PICTURE_CONTENT_TYPE);
        assertThat(testCassBankAccount.getOperationsFile()).isEqualTo(UPDATED_OPERATIONS_FILE);
        assertThat(testCassBankAccount.getOperationsFileContentType()).isEqualTo(UPDATED_OPERATIONS_FILE_CONTENT_TYPE);
        assertThat(testCassBankAccount.getAccountType()).isEqualTo(UPDATED_ACCOUNT_TYPE);
    }

    @Test
    void partialUpdateCassBankAccountShouldThrown() throws Exception {
        // Update the cassBankAccount without id should throw
        CassBankAccount partialUpdatedCassBankAccount = new CassBankAccount();

        restCassBankAccountMockMvc
            .perform(
                patch("/api/cass-bank-accounts")
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCassBankAccount))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    void deleteCassBankAccount() throws Exception {
        // Initialize the database
        cassBankAccount.setId(UUID.randomUUID());
        cassBankAccountRepository.save(cassBankAccount);

        int databaseSizeBeforeDelete = cassBankAccountRepository.findAll().size();

        // Delete the cassBankAccount
        restCassBankAccountMockMvc
            .perform(delete("/api/cass-bank-accounts/{id}", cassBankAccount.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CassBankAccount> cassBankAccountList = cassBankAccountRepository.findAll();
        assertThat(cassBankAccountList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
