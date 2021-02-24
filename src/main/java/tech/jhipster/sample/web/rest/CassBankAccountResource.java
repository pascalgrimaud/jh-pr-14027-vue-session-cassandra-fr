package tech.jhipster.sample.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.sample.service.CassBankAccountService;
import tech.jhipster.sample.service.dto.CassBankAccountDTO;
import tech.jhipster.sample.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link tech.jhipster.sample.domain.CassBankAccount}.
 */
@RestController
@RequestMapping("/api")
public class CassBankAccountResource {

    private final Logger log = LoggerFactory.getLogger(CassBankAccountResource.class);

    private static final String ENTITY_NAME = "cassBankAccount";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CassBankAccountService cassBankAccountService;

    public CassBankAccountResource(CassBankAccountService cassBankAccountService) {
        this.cassBankAccountService = cassBankAccountService;
    }

    /**
     * {@code POST  /cass-bank-accounts} : Create a new cassBankAccount.
     *
     * @param cassBankAccountDTO the cassBankAccountDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cassBankAccountDTO, or with status {@code 400 (Bad Request)} if the cassBankAccount has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cass-bank-accounts")
    public ResponseEntity<CassBankAccountDTO> createCassBankAccount(@Valid @RequestBody CassBankAccountDTO cassBankAccountDTO)
        throws URISyntaxException {
        log.debug("REST request to save CassBankAccount : {}", cassBankAccountDTO);
        if (cassBankAccountDTO.getId() != null) {
            throw new BadRequestAlertException("A new cassBankAccount cannot already have an ID", ENTITY_NAME, "idexists");
        }
        cassBankAccountDTO.setId(UUID.randomUUID());
        CassBankAccountDTO result = cassBankAccountService.save(cassBankAccountDTO);
        return ResponseEntity
            .created(new URI("/api/cass-bank-accounts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cass-bank-accounts} : Updates an existing cassBankAccount.
     *
     * @param cassBankAccountDTO the cassBankAccountDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cassBankAccountDTO,
     * or with status {@code 400 (Bad Request)} if the cassBankAccountDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cassBankAccountDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cass-bank-accounts")
    public ResponseEntity<CassBankAccountDTO> updateCassBankAccount(@Valid @RequestBody CassBankAccountDTO cassBankAccountDTO)
        throws URISyntaxException {
        log.debug("REST request to update CassBankAccount : {}", cassBankAccountDTO);
        if (cassBankAccountDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CassBankAccountDTO result = cassBankAccountService.save(cassBankAccountDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cassBankAccountDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cass-bank-accounts} : Updates given fields of an existing cassBankAccount.
     *
     * @param cassBankAccountDTO the cassBankAccountDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cassBankAccountDTO,
     * or with status {@code 400 (Bad Request)} if the cassBankAccountDTO is not valid,
     * or with status {@code 404 (Not Found)} if the cassBankAccountDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the cassBankAccountDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cass-bank-accounts", consumes = "application/merge-patch+json")
    public ResponseEntity<CassBankAccountDTO> partialUpdateCassBankAccount(@NotNull @RequestBody CassBankAccountDTO cassBankAccountDTO)
        throws URISyntaxException {
        log.debug("REST request to update CassBankAccount partially : {}", cassBankAccountDTO);
        if (cassBankAccountDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Optional<CassBankAccountDTO> result = cassBankAccountService.partialUpdate(cassBankAccountDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cassBankAccountDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /cass-bank-accounts} : get all the cassBankAccounts.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cassBankAccounts in body.
     */
    @GetMapping("/cass-bank-accounts")
    public List<CassBankAccountDTO> getAllCassBankAccounts() {
        log.debug("REST request to get all CassBankAccounts");
        return cassBankAccountService.findAll();
    }

    /**
     * {@code GET  /cass-bank-accounts/:id} : get the "id" cassBankAccount.
     *
     * @param id the id of the cassBankAccountDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cassBankAccountDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cass-bank-accounts/{id}")
    public ResponseEntity<CassBankAccountDTO> getCassBankAccount(@PathVariable UUID id) {
        log.debug("REST request to get CassBankAccount : {}", id);
        Optional<CassBankAccountDTO> cassBankAccountDTO = cassBankAccountService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cassBankAccountDTO);
    }

    /**
     * {@code DELETE  /cass-bank-accounts/:id} : delete the "id" cassBankAccount.
     *
     * @param id the id of the cassBankAccountDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cass-bank-accounts/{id}")
    public ResponseEntity<Void> deleteCassBankAccount(@PathVariable UUID id) {
        log.debug("REST request to delete CassBankAccount : {}", id);
        cassBankAccountService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
