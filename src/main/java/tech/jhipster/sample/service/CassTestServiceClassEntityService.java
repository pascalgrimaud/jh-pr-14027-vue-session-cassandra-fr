package tech.jhipster.sample.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.CassTestServiceClassEntity;
import tech.jhipster.sample.repository.CassTestServiceClassEntityRepository;

/**
 * Service Implementation for managing {@link CassTestServiceClassEntity}.
 */
@Service
public class CassTestServiceClassEntityService {

    private final Logger log = LoggerFactory.getLogger(CassTestServiceClassEntityService.class);

    private final CassTestServiceClassEntityRepository cassTestServiceClassEntityRepository;

    public CassTestServiceClassEntityService(CassTestServiceClassEntityRepository cassTestServiceClassEntityRepository) {
        this.cassTestServiceClassEntityRepository = cassTestServiceClassEntityRepository;
    }

    /**
     * Save a cassTestServiceClassEntity.
     *
     * @param cassTestServiceClassEntity the entity to save.
     * @return the persisted entity.
     */
    public CassTestServiceClassEntity save(CassTestServiceClassEntity cassTestServiceClassEntity) {
        log.debug("Request to save CassTestServiceClassEntity : {}", cassTestServiceClassEntity);
        return cassTestServiceClassEntityRepository.save(cassTestServiceClassEntity);
    }

    /**
     * Partially update a cassTestServiceClassEntity.
     *
     * @param cassTestServiceClassEntity the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<CassTestServiceClassEntity> partialUpdate(CassTestServiceClassEntity cassTestServiceClassEntity) {
        log.debug("Request to partially update CassTestServiceClassEntity : {}", cassTestServiceClassEntity);

        return cassTestServiceClassEntityRepository
            .findById(cassTestServiceClassEntity.getId())
            .map(
                existingCassTestServiceClassEntity -> {
                    if (cassTestServiceClassEntity.getStringField() != null) {
                        existingCassTestServiceClassEntity.setStringField(cassTestServiceClassEntity.getStringField());
                    }

                    if (cassTestServiceClassEntity.getStringRequiredField() != null) {
                        existingCassTestServiceClassEntity.setStringRequiredField(cassTestServiceClassEntity.getStringRequiredField());
                    }

                    if (cassTestServiceClassEntity.getStringMinlengthField() != null) {
                        existingCassTestServiceClassEntity.setStringMinlengthField(cassTestServiceClassEntity.getStringMinlengthField());
                    }

                    if (cassTestServiceClassEntity.getStringMaxlengthField() != null) {
                        existingCassTestServiceClassEntity.setStringMaxlengthField(cassTestServiceClassEntity.getStringMaxlengthField());
                    }

                    if (cassTestServiceClassEntity.getStringPatternField() != null) {
                        existingCassTestServiceClassEntity.setStringPatternField(cassTestServiceClassEntity.getStringPatternField());
                    }

                    if (cassTestServiceClassEntity.getIntegerField() != null) {
                        existingCassTestServiceClassEntity.setIntegerField(cassTestServiceClassEntity.getIntegerField());
                    }

                    if (cassTestServiceClassEntity.getIntegerRequiredField() != null) {
                        existingCassTestServiceClassEntity.setIntegerRequiredField(cassTestServiceClassEntity.getIntegerRequiredField());
                    }

                    if (cassTestServiceClassEntity.getIntegerMinField() != null) {
                        existingCassTestServiceClassEntity.setIntegerMinField(cassTestServiceClassEntity.getIntegerMinField());
                    }

                    if (cassTestServiceClassEntity.getIntegerMaxField() != null) {
                        existingCassTestServiceClassEntity.setIntegerMaxField(cassTestServiceClassEntity.getIntegerMaxField());
                    }

                    if (cassTestServiceClassEntity.getLongField() != null) {
                        existingCassTestServiceClassEntity.setLongField(cassTestServiceClassEntity.getLongField());
                    }

                    if (cassTestServiceClassEntity.getLongRequiredField() != null) {
                        existingCassTestServiceClassEntity.setLongRequiredField(cassTestServiceClassEntity.getLongRequiredField());
                    }

                    if (cassTestServiceClassEntity.getLongMinField() != null) {
                        existingCassTestServiceClassEntity.setLongMinField(cassTestServiceClassEntity.getLongMinField());
                    }

                    if (cassTestServiceClassEntity.getLongMaxField() != null) {
                        existingCassTestServiceClassEntity.setLongMaxField(cassTestServiceClassEntity.getLongMaxField());
                    }

                    if (cassTestServiceClassEntity.getFloatField() != null) {
                        existingCassTestServiceClassEntity.setFloatField(cassTestServiceClassEntity.getFloatField());
                    }

                    if (cassTestServiceClassEntity.getFloatRequiredField() != null) {
                        existingCassTestServiceClassEntity.setFloatRequiredField(cassTestServiceClassEntity.getFloatRequiredField());
                    }

                    if (cassTestServiceClassEntity.getFloatMinField() != null) {
                        existingCassTestServiceClassEntity.setFloatMinField(cassTestServiceClassEntity.getFloatMinField());
                    }

                    if (cassTestServiceClassEntity.getFloatMaxField() != null) {
                        existingCassTestServiceClassEntity.setFloatMaxField(cassTestServiceClassEntity.getFloatMaxField());
                    }

                    if (cassTestServiceClassEntity.getDoubleRequiredField() != null) {
                        existingCassTestServiceClassEntity.setDoubleRequiredField(cassTestServiceClassEntity.getDoubleRequiredField());
                    }

                    if (cassTestServiceClassEntity.getDoubleMinField() != null) {
                        existingCassTestServiceClassEntity.setDoubleMinField(cassTestServiceClassEntity.getDoubleMinField());
                    }

                    if (cassTestServiceClassEntity.getDoubleMaxField() != null) {
                        existingCassTestServiceClassEntity.setDoubleMaxField(cassTestServiceClassEntity.getDoubleMaxField());
                    }

                    if (cassTestServiceClassEntity.getBigDecimalRequiredField() != null) {
                        existingCassTestServiceClassEntity.setBigDecimalRequiredField(
                            cassTestServiceClassEntity.getBigDecimalRequiredField()
                        );
                    }

                    if (cassTestServiceClassEntity.getBigDecimalMinField() != null) {
                        existingCassTestServiceClassEntity.setBigDecimalMinField(cassTestServiceClassEntity.getBigDecimalMinField());
                    }

                    if (cassTestServiceClassEntity.getBigDecimalMaxField() != null) {
                        existingCassTestServiceClassEntity.setBigDecimalMaxField(cassTestServiceClassEntity.getBigDecimalMaxField());
                    }

                    if (cassTestServiceClassEntity.getLocalDateField() != null) {
                        existingCassTestServiceClassEntity.setLocalDateField(cassTestServiceClassEntity.getLocalDateField());
                    }

                    if (cassTestServiceClassEntity.getLocalDateRequiredField() != null) {
                        existingCassTestServiceClassEntity.setLocalDateRequiredField(
                            cassTestServiceClassEntity.getLocalDateRequiredField()
                        );
                    }

                    if (cassTestServiceClassEntity.getInstantDateField() != null) {
                        existingCassTestServiceClassEntity.setInstantDateField(cassTestServiceClassEntity.getInstantDateField());
                    }

                    if (cassTestServiceClassEntity.getInstantRequiredField() != null) {
                        existingCassTestServiceClassEntity.setInstantRequiredField(cassTestServiceClassEntity.getInstantRequiredField());
                    }

                    if (cassTestServiceClassEntity.getZonedDateTimeField() != null) {
                        existingCassTestServiceClassEntity.setZonedDateTimeField(cassTestServiceClassEntity.getZonedDateTimeField());
                    }

                    if (cassTestServiceClassEntity.getZonedDateTimeRequiredField() != null) {
                        existingCassTestServiceClassEntity.setZonedDateTimeRequiredField(
                            cassTestServiceClassEntity.getZonedDateTimeRequiredField()
                        );
                    }

                    if (cassTestServiceClassEntity.getDurationDateField() != null) {
                        existingCassTestServiceClassEntity.setDurationDateField(cassTestServiceClassEntity.getDurationDateField());
                    }

                    if (cassTestServiceClassEntity.getDurationRequiredField() != null) {
                        existingCassTestServiceClassEntity.setDurationRequiredField(cassTestServiceClassEntity.getDurationRequiredField());
                    }

                    if (cassTestServiceClassEntity.getBooleanField() != null) {
                        existingCassTestServiceClassEntity.setBooleanField(cassTestServiceClassEntity.getBooleanField());
                    }

                    if (cassTestServiceClassEntity.getBooleanRequiredField() != null) {
                        existingCassTestServiceClassEntity.setBooleanRequiredField(cassTestServiceClassEntity.getBooleanRequiredField());
                    }

                    if (cassTestServiceClassEntity.getEnumTom() != null) {
                        existingCassTestServiceClassEntity.setEnumTom(cassTestServiceClassEntity.getEnumTom());
                    }

                    if (cassTestServiceClassEntity.getEnumRequiredTom() != null) {
                        existingCassTestServiceClassEntity.setEnumRequiredTom(cassTestServiceClassEntity.getEnumRequiredTom());
                    }

                    if (cassTestServiceClassEntity.getPicture() != null) {
                        existingCassTestServiceClassEntity.setPicture(cassTestServiceClassEntity.getPicture());
                    }
                    if (cassTestServiceClassEntity.getPictureContentType() != null) {
                        existingCassTestServiceClassEntity.setPictureContentType(cassTestServiceClassEntity.getPictureContentType());
                    }

                    if (cassTestServiceClassEntity.getOperationsFile() != null) {
                        existingCassTestServiceClassEntity.setOperationsFile(cassTestServiceClassEntity.getOperationsFile());
                    }
                    if (cassTestServiceClassEntity.getOperationsFileContentType() != null) {
                        existingCassTestServiceClassEntity.setOperationsFileContentType(
                            cassTestServiceClassEntity.getOperationsFileContentType()
                        );
                    }

                    return existingCassTestServiceClassEntity;
                }
            )
            .map(cassTestServiceClassEntityRepository::save);
    }

    /**
     * Get all the cassTestServiceClassEntities.
     *
     * @return the list of entities.
     */
    public List<CassTestServiceClassEntity> findAll() {
        log.debug("Request to get all CassTestServiceClassEntities");
        return cassTestServiceClassEntityRepository.findAll();
    }

    /**
     * Get one cassTestServiceClassEntity by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<CassTestServiceClassEntity> findOne(UUID id) {
        log.debug("Request to get CassTestServiceClassEntity : {}", id);
        return cassTestServiceClassEntityRepository.findById(id);
    }

    /**
     * Delete the cassTestServiceClassEntity by id.
     *
     * @param id the id of the entity.
     */
    public void delete(UUID id) {
        log.debug("Request to delete CassTestServiceClassEntity : {}", id);
        cassTestServiceClassEntityRepository.deleteById(id);
    }
}
