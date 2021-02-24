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
import tech.jhipster.sample.domain.CassTestServiceImplEntity;
import tech.jhipster.sample.service.CassTestServiceImplEntityService;
import tech.jhipster.sample.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link tech.jhipster.sample.domain.CassTestServiceImplEntity}.
 */
@RestController
@RequestMapping("/api")
public class CassTestServiceImplEntityResource {

    private final Logger log = LoggerFactory.getLogger(CassTestServiceImplEntityResource.class);

    private static final String ENTITY_NAME = "cassTestServiceImplEntity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CassTestServiceImplEntityService cassTestServiceImplEntityService;

    public CassTestServiceImplEntityResource(CassTestServiceImplEntityService cassTestServiceImplEntityService) {
        this.cassTestServiceImplEntityService = cassTestServiceImplEntityService;
    }

    /**
     * {@code POST  /cass-test-service-impl-entities} : Create a new cassTestServiceImplEntity.
     *
     * @param cassTestServiceImplEntity the cassTestServiceImplEntity to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cassTestServiceImplEntity, or with status {@code 400 (Bad Request)} if the cassTestServiceImplEntity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cass-test-service-impl-entities")
    public ResponseEntity<CassTestServiceImplEntity> createCassTestServiceImplEntity(
        @Valid @RequestBody CassTestServiceImplEntity cassTestServiceImplEntity
    ) throws URISyntaxException {
        log.debug("REST request to save CassTestServiceImplEntity : {}", cassTestServiceImplEntity);
        if (cassTestServiceImplEntity.getId() != null) {
            throw new BadRequestAlertException("A new cassTestServiceImplEntity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        cassTestServiceImplEntity.setId(UUID.randomUUID());
        CassTestServiceImplEntity result = cassTestServiceImplEntityService.save(cassTestServiceImplEntity);
        return ResponseEntity
            .created(new URI("/api/cass-test-service-impl-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cass-test-service-impl-entities} : Updates an existing cassTestServiceImplEntity.
     *
     * @param cassTestServiceImplEntity the cassTestServiceImplEntity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cassTestServiceImplEntity,
     * or with status {@code 400 (Bad Request)} if the cassTestServiceImplEntity is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cassTestServiceImplEntity couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cass-test-service-impl-entities")
    public ResponseEntity<CassTestServiceImplEntity> updateCassTestServiceImplEntity(
        @Valid @RequestBody CassTestServiceImplEntity cassTestServiceImplEntity
    ) throws URISyntaxException {
        log.debug("REST request to update CassTestServiceImplEntity : {}", cassTestServiceImplEntity);
        if (cassTestServiceImplEntity.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CassTestServiceImplEntity result = cassTestServiceImplEntityService.save(cassTestServiceImplEntity);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cassTestServiceImplEntity.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cass-test-service-impl-entities} : Updates given fields of an existing cassTestServiceImplEntity.
     *
     * @param cassTestServiceImplEntity the cassTestServiceImplEntity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cassTestServiceImplEntity,
     * or with status {@code 400 (Bad Request)} if the cassTestServiceImplEntity is not valid,
     * or with status {@code 404 (Not Found)} if the cassTestServiceImplEntity is not found,
     * or with status {@code 500 (Internal Server Error)} if the cassTestServiceImplEntity couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cass-test-service-impl-entities", consumes = "application/merge-patch+json")
    public ResponseEntity<CassTestServiceImplEntity> partialUpdateCassTestServiceImplEntity(
        @NotNull @RequestBody CassTestServiceImplEntity cassTestServiceImplEntity
    ) throws URISyntaxException {
        log.debug("REST request to update CassTestServiceImplEntity partially : {}", cassTestServiceImplEntity);
        if (cassTestServiceImplEntity.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Optional<CassTestServiceImplEntity> result = cassTestServiceImplEntityService.partialUpdate(cassTestServiceImplEntity);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cassTestServiceImplEntity.getId().toString())
        );
    }

    /**
     * {@code GET  /cass-test-service-impl-entities} : get all the cassTestServiceImplEntities.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cassTestServiceImplEntities in body.
     */
    @GetMapping("/cass-test-service-impl-entities")
    public List<CassTestServiceImplEntity> getAllCassTestServiceImplEntities() {
        log.debug("REST request to get all CassTestServiceImplEntities");
        return cassTestServiceImplEntityService.findAll();
    }

    /**
     * {@code GET  /cass-test-service-impl-entities/:id} : get the "id" cassTestServiceImplEntity.
     *
     * @param id the id of the cassTestServiceImplEntity to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cassTestServiceImplEntity, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cass-test-service-impl-entities/{id}")
    public ResponseEntity<CassTestServiceImplEntity> getCassTestServiceImplEntity(@PathVariable UUID id) {
        log.debug("REST request to get CassTestServiceImplEntity : {}", id);
        Optional<CassTestServiceImplEntity> cassTestServiceImplEntity = cassTestServiceImplEntityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cassTestServiceImplEntity);
    }

    /**
     * {@code DELETE  /cass-test-service-impl-entities/:id} : delete the "id" cassTestServiceImplEntity.
     *
     * @param id the id of the cassTestServiceImplEntity to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cass-test-service-impl-entities/{id}")
    public ResponseEntity<Void> deleteCassTestServiceImplEntity(@PathVariable UUID id) {
        log.debug("REST request to delete CassTestServiceImplEntity : {}", id);
        cassTestServiceImplEntityService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
