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
import tech.jhipster.sample.service.CassTestMapstructEntityService;
import tech.jhipster.sample.service.dto.CassTestMapstructEntityDTO;
import tech.jhipster.sample.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link tech.jhipster.sample.domain.CassTestMapstructEntity}.
 */
@RestController
@RequestMapping("/api")
public class CassTestMapstructEntityResource {

    private final Logger log = LoggerFactory.getLogger(CassTestMapstructEntityResource.class);

    private static final String ENTITY_NAME = "cassTestMapstructEntity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CassTestMapstructEntityService cassTestMapstructEntityService;

    public CassTestMapstructEntityResource(CassTestMapstructEntityService cassTestMapstructEntityService) {
        this.cassTestMapstructEntityService = cassTestMapstructEntityService;
    }

    /**
     * {@code POST  /cass-test-mapstruct-entities} : Create a new cassTestMapstructEntity.
     *
     * @param cassTestMapstructEntityDTO the cassTestMapstructEntityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cassTestMapstructEntityDTO, or with status {@code 400 (Bad Request)} if the cassTestMapstructEntity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cass-test-mapstruct-entities")
    public ResponseEntity<CassTestMapstructEntityDTO> createCassTestMapstructEntity(
        @Valid @RequestBody CassTestMapstructEntityDTO cassTestMapstructEntityDTO
    ) throws URISyntaxException {
        log.debug("REST request to save CassTestMapstructEntity : {}", cassTestMapstructEntityDTO);
        if (cassTestMapstructEntityDTO.getId() != null) {
            throw new BadRequestAlertException("A new cassTestMapstructEntity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        cassTestMapstructEntityDTO.setId(UUID.randomUUID());
        CassTestMapstructEntityDTO result = cassTestMapstructEntityService.save(cassTestMapstructEntityDTO);
        return ResponseEntity
            .created(new URI("/api/cass-test-mapstruct-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cass-test-mapstruct-entities} : Updates an existing cassTestMapstructEntity.
     *
     * @param cassTestMapstructEntityDTO the cassTestMapstructEntityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cassTestMapstructEntityDTO,
     * or with status {@code 400 (Bad Request)} if the cassTestMapstructEntityDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cassTestMapstructEntityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cass-test-mapstruct-entities")
    public ResponseEntity<CassTestMapstructEntityDTO> updateCassTestMapstructEntity(
        @Valid @RequestBody CassTestMapstructEntityDTO cassTestMapstructEntityDTO
    ) throws URISyntaxException {
        log.debug("REST request to update CassTestMapstructEntity : {}", cassTestMapstructEntityDTO);
        if (cassTestMapstructEntityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CassTestMapstructEntityDTO result = cassTestMapstructEntityService.save(cassTestMapstructEntityDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cassTestMapstructEntityDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cass-test-mapstruct-entities} : Updates given fields of an existing cassTestMapstructEntity.
     *
     * @param cassTestMapstructEntityDTO the cassTestMapstructEntityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cassTestMapstructEntityDTO,
     * or with status {@code 400 (Bad Request)} if the cassTestMapstructEntityDTO is not valid,
     * or with status {@code 404 (Not Found)} if the cassTestMapstructEntityDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the cassTestMapstructEntityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cass-test-mapstruct-entities", consumes = "application/merge-patch+json")
    public ResponseEntity<CassTestMapstructEntityDTO> partialUpdateCassTestMapstructEntity(
        @NotNull @RequestBody CassTestMapstructEntityDTO cassTestMapstructEntityDTO
    ) throws URISyntaxException {
        log.debug("REST request to update CassTestMapstructEntity partially : {}", cassTestMapstructEntityDTO);
        if (cassTestMapstructEntityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Optional<CassTestMapstructEntityDTO> result = cassTestMapstructEntityService.partialUpdate(cassTestMapstructEntityDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cassTestMapstructEntityDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /cass-test-mapstruct-entities} : get all the cassTestMapstructEntities.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cassTestMapstructEntities in body.
     */
    @GetMapping("/cass-test-mapstruct-entities")
    public List<CassTestMapstructEntityDTO> getAllCassTestMapstructEntities() {
        log.debug("REST request to get all CassTestMapstructEntities");
        return cassTestMapstructEntityService.findAll();
    }

    /**
     * {@code GET  /cass-test-mapstruct-entities/:id} : get the "id" cassTestMapstructEntity.
     *
     * @param id the id of the cassTestMapstructEntityDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cassTestMapstructEntityDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cass-test-mapstruct-entities/{id}")
    public ResponseEntity<CassTestMapstructEntityDTO> getCassTestMapstructEntity(@PathVariable UUID id) {
        log.debug("REST request to get CassTestMapstructEntity : {}", id);
        Optional<CassTestMapstructEntityDTO> cassTestMapstructEntityDTO = cassTestMapstructEntityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cassTestMapstructEntityDTO);
    }

    /**
     * {@code DELETE  /cass-test-mapstruct-entities/:id} : delete the "id" cassTestMapstructEntity.
     *
     * @param id the id of the cassTestMapstructEntityDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cass-test-mapstruct-entities/{id}")
    public ResponseEntity<Void> deleteCassTestMapstructEntity(@PathVariable UUID id) {
        log.debug("REST request to delete CassTestMapstructEntity : {}", id);
        cassTestMapstructEntityService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
