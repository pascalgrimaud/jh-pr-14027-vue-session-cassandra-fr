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
import tech.jhipster.sample.domain.CassTestServiceClassEntity;
import tech.jhipster.sample.service.CassTestServiceClassEntityService;
import tech.jhipster.sample.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link tech.jhipster.sample.domain.CassTestServiceClassEntity}.
 */
@RestController
@RequestMapping("/api")
public class CassTestServiceClassEntityResource {

    private final Logger log = LoggerFactory.getLogger(CassTestServiceClassEntityResource.class);

    private static final String ENTITY_NAME = "cassTestServiceClassEntity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CassTestServiceClassEntityService cassTestServiceClassEntityService;

    public CassTestServiceClassEntityResource(CassTestServiceClassEntityService cassTestServiceClassEntityService) {
        this.cassTestServiceClassEntityService = cassTestServiceClassEntityService;
    }

    /**
     * {@code POST  /cass-test-service-class-entities} : Create a new cassTestServiceClassEntity.
     *
     * @param cassTestServiceClassEntity the cassTestServiceClassEntity to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cassTestServiceClassEntity, or with status {@code 400 (Bad Request)} if the cassTestServiceClassEntity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cass-test-service-class-entities")
    public ResponseEntity<CassTestServiceClassEntity> createCassTestServiceClassEntity(
        @Valid @RequestBody CassTestServiceClassEntity cassTestServiceClassEntity
    ) throws URISyntaxException {
        log.debug("REST request to save CassTestServiceClassEntity : {}", cassTestServiceClassEntity);
        if (cassTestServiceClassEntity.getId() != null) {
            throw new BadRequestAlertException("A new cassTestServiceClassEntity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        cassTestServiceClassEntity.setId(UUID.randomUUID());
        CassTestServiceClassEntity result = cassTestServiceClassEntityService.save(cassTestServiceClassEntity);
        return ResponseEntity
            .created(new URI("/api/cass-test-service-class-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cass-test-service-class-entities} : Updates an existing cassTestServiceClassEntity.
     *
     * @param cassTestServiceClassEntity the cassTestServiceClassEntity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cassTestServiceClassEntity,
     * or with status {@code 400 (Bad Request)} if the cassTestServiceClassEntity is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cassTestServiceClassEntity couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cass-test-service-class-entities")
    public ResponseEntity<CassTestServiceClassEntity> updateCassTestServiceClassEntity(
        @Valid @RequestBody CassTestServiceClassEntity cassTestServiceClassEntity
    ) throws URISyntaxException {
        log.debug("REST request to update CassTestServiceClassEntity : {}", cassTestServiceClassEntity);
        if (cassTestServiceClassEntity.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CassTestServiceClassEntity result = cassTestServiceClassEntityService.save(cassTestServiceClassEntity);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cassTestServiceClassEntity.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cass-test-service-class-entities} : Updates given fields of an existing cassTestServiceClassEntity.
     *
     * @param cassTestServiceClassEntity the cassTestServiceClassEntity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cassTestServiceClassEntity,
     * or with status {@code 400 (Bad Request)} if the cassTestServiceClassEntity is not valid,
     * or with status {@code 404 (Not Found)} if the cassTestServiceClassEntity is not found,
     * or with status {@code 500 (Internal Server Error)} if the cassTestServiceClassEntity couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cass-test-service-class-entities", consumes = "application/merge-patch+json")
    public ResponseEntity<CassTestServiceClassEntity> partialUpdateCassTestServiceClassEntity(
        @NotNull @RequestBody CassTestServiceClassEntity cassTestServiceClassEntity
    ) throws URISyntaxException {
        log.debug("REST request to update CassTestServiceClassEntity partially : {}", cassTestServiceClassEntity);
        if (cassTestServiceClassEntity.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Optional<CassTestServiceClassEntity> result = cassTestServiceClassEntityService.partialUpdate(cassTestServiceClassEntity);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cassTestServiceClassEntity.getId().toString())
        );
    }

    /**
     * {@code GET  /cass-test-service-class-entities} : get all the cassTestServiceClassEntities.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cassTestServiceClassEntities in body.
     */
    @GetMapping("/cass-test-service-class-entities")
    public List<CassTestServiceClassEntity> getAllCassTestServiceClassEntities() {
        log.debug("REST request to get all CassTestServiceClassEntities");
        return cassTestServiceClassEntityService.findAll();
    }

    /**
     * {@code GET  /cass-test-service-class-entities/:id} : get the "id" cassTestServiceClassEntity.
     *
     * @param id the id of the cassTestServiceClassEntity to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cassTestServiceClassEntity, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cass-test-service-class-entities/{id}")
    public ResponseEntity<CassTestServiceClassEntity> getCassTestServiceClassEntity(@PathVariable UUID id) {
        log.debug("REST request to get CassTestServiceClassEntity : {}", id);
        Optional<CassTestServiceClassEntity> cassTestServiceClassEntity = cassTestServiceClassEntityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cassTestServiceClassEntity);
    }

    /**
     * {@code DELETE  /cass-test-service-class-entities/:id} : delete the "id" cassTestServiceClassEntity.
     *
     * @param id the id of the cassTestServiceClassEntity to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cass-test-service-class-entities/{id}")
    public ResponseEntity<Void> deleteCassTestServiceClassEntity(@PathVariable UUID id) {
        log.debug("REST request to delete CassTestServiceClassEntity : {}", id);
        cassTestServiceClassEntityService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
