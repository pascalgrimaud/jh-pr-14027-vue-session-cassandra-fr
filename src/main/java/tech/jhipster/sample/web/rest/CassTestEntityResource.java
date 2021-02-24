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
import tech.jhipster.sample.domain.CassTestEntity;
import tech.jhipster.sample.repository.CassTestEntityRepository;
import tech.jhipster.sample.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link tech.jhipster.sample.domain.CassTestEntity}.
 */
@RestController
@RequestMapping("/api")
public class CassTestEntityResource {

    private final Logger log = LoggerFactory.getLogger(CassTestEntityResource.class);

    private static final String ENTITY_NAME = "cassTestEntity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CassTestEntityRepository cassTestEntityRepository;

    public CassTestEntityResource(CassTestEntityRepository cassTestEntityRepository) {
        this.cassTestEntityRepository = cassTestEntityRepository;
    }

    /**
     * {@code POST  /cass-test-entities} : Create a new cassTestEntity.
     *
     * @param cassTestEntity the cassTestEntity to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cassTestEntity, or with status {@code 400 (Bad Request)} if the cassTestEntity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cass-test-entities")
    public ResponseEntity<CassTestEntity> createCassTestEntity(@Valid @RequestBody CassTestEntity cassTestEntity)
        throws URISyntaxException {
        log.debug("REST request to save CassTestEntity : {}", cassTestEntity);
        if (cassTestEntity.getId() != null) {
            throw new BadRequestAlertException("A new cassTestEntity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        cassTestEntity.setId(UUID.randomUUID());
        CassTestEntity result = cassTestEntityRepository.save(cassTestEntity);
        return ResponseEntity
            .created(new URI("/api/cass-test-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cass-test-entities} : Updates an existing cassTestEntity.
     *
     * @param cassTestEntity the cassTestEntity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cassTestEntity,
     * or with status {@code 400 (Bad Request)} if the cassTestEntity is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cassTestEntity couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cass-test-entities")
    public ResponseEntity<CassTestEntity> updateCassTestEntity(@Valid @RequestBody CassTestEntity cassTestEntity)
        throws URISyntaxException {
        log.debug("REST request to update CassTestEntity : {}", cassTestEntity);
        if (cassTestEntity.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CassTestEntity result = cassTestEntityRepository.save(cassTestEntity);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cassTestEntity.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /cass-test-entities} : Updates given fields of an existing cassTestEntity.
     *
     * @param cassTestEntity the cassTestEntity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cassTestEntity,
     * or with status {@code 400 (Bad Request)} if the cassTestEntity is not valid,
     * or with status {@code 404 (Not Found)} if the cassTestEntity is not found,
     * or with status {@code 500 (Internal Server Error)} if the cassTestEntity couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/cass-test-entities", consumes = "application/merge-patch+json")
    public ResponseEntity<CassTestEntity> partialUpdateCassTestEntity(@NotNull @RequestBody CassTestEntity cassTestEntity)
        throws URISyntaxException {
        log.debug("REST request to update CassTestEntity partially : {}", cassTestEntity);
        if (cassTestEntity.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Optional<CassTestEntity> result = cassTestEntityRepository
            .findById(cassTestEntity.getId())
            .map(
                existingCassTestEntity -> {
                    if (cassTestEntity.getStringField() != null) {
                        existingCassTestEntity.setStringField(cassTestEntity.getStringField());
                    }

                    if (cassTestEntity.getStringRequiredField() != null) {
                        existingCassTestEntity.setStringRequiredField(cassTestEntity.getStringRequiredField());
                    }

                    if (cassTestEntity.getStringMinlengthField() != null) {
                        existingCassTestEntity.setStringMinlengthField(cassTestEntity.getStringMinlengthField());
                    }

                    if (cassTestEntity.getStringMaxlengthField() != null) {
                        existingCassTestEntity.setStringMaxlengthField(cassTestEntity.getStringMaxlengthField());
                    }

                    if (cassTestEntity.getStringPatternField() != null) {
                        existingCassTestEntity.setStringPatternField(cassTestEntity.getStringPatternField());
                    }

                    if (cassTestEntity.getIntegerField() != null) {
                        existingCassTestEntity.setIntegerField(cassTestEntity.getIntegerField());
                    }

                    if (cassTestEntity.getIntegerRequiredField() != null) {
                        existingCassTestEntity.setIntegerRequiredField(cassTestEntity.getIntegerRequiredField());
                    }

                    if (cassTestEntity.getIntegerMinField() != null) {
                        existingCassTestEntity.setIntegerMinField(cassTestEntity.getIntegerMinField());
                    }

                    if (cassTestEntity.getIntegerMaxField() != null) {
                        existingCassTestEntity.setIntegerMaxField(cassTestEntity.getIntegerMaxField());
                    }

                    if (cassTestEntity.getLongField() != null) {
                        existingCassTestEntity.setLongField(cassTestEntity.getLongField());
                    }

                    if (cassTestEntity.getLongRequiredField() != null) {
                        existingCassTestEntity.setLongRequiredField(cassTestEntity.getLongRequiredField());
                    }

                    if (cassTestEntity.getLongMinField() != null) {
                        existingCassTestEntity.setLongMinField(cassTestEntity.getLongMinField());
                    }

                    if (cassTestEntity.getLongMaxField() != null) {
                        existingCassTestEntity.setLongMaxField(cassTestEntity.getLongMaxField());
                    }

                    if (cassTestEntity.getFloatField() != null) {
                        existingCassTestEntity.setFloatField(cassTestEntity.getFloatField());
                    }

                    if (cassTestEntity.getFloatRequiredField() != null) {
                        existingCassTestEntity.setFloatRequiredField(cassTestEntity.getFloatRequiredField());
                    }

                    if (cassTestEntity.getFloatMinField() != null) {
                        existingCassTestEntity.setFloatMinField(cassTestEntity.getFloatMinField());
                    }

                    if (cassTestEntity.getFloatMaxField() != null) {
                        existingCassTestEntity.setFloatMaxField(cassTestEntity.getFloatMaxField());
                    }

                    if (cassTestEntity.getDoubleRequiredField() != null) {
                        existingCassTestEntity.setDoubleRequiredField(cassTestEntity.getDoubleRequiredField());
                    }

                    if (cassTestEntity.getDoubleMinField() != null) {
                        existingCassTestEntity.setDoubleMinField(cassTestEntity.getDoubleMinField());
                    }

                    if (cassTestEntity.getDoubleMaxField() != null) {
                        existingCassTestEntity.setDoubleMaxField(cassTestEntity.getDoubleMaxField());
                    }

                    if (cassTestEntity.getBigDecimalRequiredField() != null) {
                        existingCassTestEntity.setBigDecimalRequiredField(cassTestEntity.getBigDecimalRequiredField());
                    }

                    if (cassTestEntity.getBigDecimalMinField() != null) {
                        existingCassTestEntity.setBigDecimalMinField(cassTestEntity.getBigDecimalMinField());
                    }

                    if (cassTestEntity.getBigDecimalMaxField() != null) {
                        existingCassTestEntity.setBigDecimalMaxField(cassTestEntity.getBigDecimalMaxField());
                    }

                    if (cassTestEntity.getLocalDateField() != null) {
                        existingCassTestEntity.setLocalDateField(cassTestEntity.getLocalDateField());
                    }

                    if (cassTestEntity.getLocalDateRequiredField() != null) {
                        existingCassTestEntity.setLocalDateRequiredField(cassTestEntity.getLocalDateRequiredField());
                    }

                    if (cassTestEntity.getInstantDateField() != null) {
                        existingCassTestEntity.setInstantDateField(cassTestEntity.getInstantDateField());
                    }

                    if (cassTestEntity.getInstantRequiredField() != null) {
                        existingCassTestEntity.setInstantRequiredField(cassTestEntity.getInstantRequiredField());
                    }

                    if (cassTestEntity.getZonedDateTimeField() != null) {
                        existingCassTestEntity.setZonedDateTimeField(cassTestEntity.getZonedDateTimeField());
                    }

                    if (cassTestEntity.getZonedDateTimeRequiredField() != null) {
                        existingCassTestEntity.setZonedDateTimeRequiredField(cassTestEntity.getZonedDateTimeRequiredField());
                    }

                    if (cassTestEntity.getDurationDateField() != null) {
                        existingCassTestEntity.setDurationDateField(cassTestEntity.getDurationDateField());
                    }

                    if (cassTestEntity.getDurationRequiredField() != null) {
                        existingCassTestEntity.setDurationRequiredField(cassTestEntity.getDurationRequiredField());
                    }

                    if (cassTestEntity.getBooleanField() != null) {
                        existingCassTestEntity.setBooleanField(cassTestEntity.getBooleanField());
                    }

                    if (cassTestEntity.getBooleanRequiredField() != null) {
                        existingCassTestEntity.setBooleanRequiredField(cassTestEntity.getBooleanRequiredField());
                    }

                    if (cassTestEntity.getEnumTom() != null) {
                        existingCassTestEntity.setEnumTom(cassTestEntity.getEnumTom());
                    }

                    if (cassTestEntity.getEnumRequiredTom() != null) {
                        existingCassTestEntity.setEnumRequiredTom(cassTestEntity.getEnumRequiredTom());
                    }

                    if (cassTestEntity.getPicture() != null) {
                        existingCassTestEntity.setPicture(cassTestEntity.getPicture());
                    }
                    if (cassTestEntity.getPictureContentType() != null) {
                        existingCassTestEntity.setPictureContentType(cassTestEntity.getPictureContentType());
                    }

                    if (cassTestEntity.getOperationsFile() != null) {
                        existingCassTestEntity.setOperationsFile(cassTestEntity.getOperationsFile());
                    }
                    if (cassTestEntity.getOperationsFileContentType() != null) {
                        existingCassTestEntity.setOperationsFileContentType(cassTestEntity.getOperationsFileContentType());
                    }

                    return existingCassTestEntity;
                }
            )
            .map(cassTestEntityRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, cassTestEntity.getId().toString())
        );
    }

    /**
     * {@code GET  /cass-test-entities} : get all the cassTestEntities.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cassTestEntities in body.
     */
    @GetMapping("/cass-test-entities")
    public List<CassTestEntity> getAllCassTestEntities() {
        log.debug("REST request to get all CassTestEntities");
        return cassTestEntityRepository.findAll();
    }

    /**
     * {@code GET  /cass-test-entities/:id} : get the "id" cassTestEntity.
     *
     * @param id the id of the cassTestEntity to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cassTestEntity, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cass-test-entities/{id}")
    public ResponseEntity<CassTestEntity> getCassTestEntity(@PathVariable UUID id) {
        log.debug("REST request to get CassTestEntity : {}", id);
        Optional<CassTestEntity> cassTestEntity = cassTestEntityRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(cassTestEntity);
    }

    /**
     * {@code DELETE  /cass-test-entities/:id} : delete the "id" cassTestEntity.
     *
     * @param id the id of the cassTestEntity to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cass-test-entities/{id}")
    public ResponseEntity<Void> deleteCassTestEntity(@PathVariable UUID id) {
        log.debug("REST request to delete CassTestEntity : {}", id);
        cassTestEntityRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
