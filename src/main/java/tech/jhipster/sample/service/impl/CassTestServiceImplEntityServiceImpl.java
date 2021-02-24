package tech.jhipster.sample.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.CassTestServiceImplEntity;
import tech.jhipster.sample.repository.CassTestServiceImplEntityRepository;
import tech.jhipster.sample.service.CassTestServiceImplEntityService;

/**
 * Service Implementation for managing {@link CassTestServiceImplEntity}.
 */
@Service
public class CassTestServiceImplEntityServiceImpl implements CassTestServiceImplEntityService {

    private final Logger log = LoggerFactory.getLogger(CassTestServiceImplEntityServiceImpl.class);

    private final CassTestServiceImplEntityRepository cassTestServiceImplEntityRepository;

    public CassTestServiceImplEntityServiceImpl(CassTestServiceImplEntityRepository cassTestServiceImplEntityRepository) {
        this.cassTestServiceImplEntityRepository = cassTestServiceImplEntityRepository;
    }

    @Override
    public CassTestServiceImplEntity save(CassTestServiceImplEntity cassTestServiceImplEntity) {
        log.debug("Request to save CassTestServiceImplEntity : {}", cassTestServiceImplEntity);
        return cassTestServiceImplEntityRepository.save(cassTestServiceImplEntity);
    }

    @Override
    public Optional<CassTestServiceImplEntity> partialUpdate(CassTestServiceImplEntity cassTestServiceImplEntity) {
        log.debug("Request to partially update CassTestServiceImplEntity : {}", cassTestServiceImplEntity);

        return cassTestServiceImplEntityRepository
            .findById(cassTestServiceImplEntity.getId())
            .map(
                existingCassTestServiceImplEntity -> {
                    if (cassTestServiceImplEntity.getStringField() != null) {
                        existingCassTestServiceImplEntity.setStringField(cassTestServiceImplEntity.getStringField());
                    }

                    if (cassTestServiceImplEntity.getStringRequiredField() != null) {
                        existingCassTestServiceImplEntity.setStringRequiredField(cassTestServiceImplEntity.getStringRequiredField());
                    }

                    if (cassTestServiceImplEntity.getStringMinlengthField() != null) {
                        existingCassTestServiceImplEntity.setStringMinlengthField(cassTestServiceImplEntity.getStringMinlengthField());
                    }

                    if (cassTestServiceImplEntity.getStringMaxlengthField() != null) {
                        existingCassTestServiceImplEntity.setStringMaxlengthField(cassTestServiceImplEntity.getStringMaxlengthField());
                    }

                    if (cassTestServiceImplEntity.getStringPatternField() != null) {
                        existingCassTestServiceImplEntity.setStringPatternField(cassTestServiceImplEntity.getStringPatternField());
                    }

                    if (cassTestServiceImplEntity.getIntegerField() != null) {
                        existingCassTestServiceImplEntity.setIntegerField(cassTestServiceImplEntity.getIntegerField());
                    }

                    if (cassTestServiceImplEntity.getIntegerRequiredField() != null) {
                        existingCassTestServiceImplEntity.setIntegerRequiredField(cassTestServiceImplEntity.getIntegerRequiredField());
                    }

                    if (cassTestServiceImplEntity.getIntegerMinField() != null) {
                        existingCassTestServiceImplEntity.setIntegerMinField(cassTestServiceImplEntity.getIntegerMinField());
                    }

                    if (cassTestServiceImplEntity.getIntegerMaxField() != null) {
                        existingCassTestServiceImplEntity.setIntegerMaxField(cassTestServiceImplEntity.getIntegerMaxField());
                    }

                    if (cassTestServiceImplEntity.getLongField() != null) {
                        existingCassTestServiceImplEntity.setLongField(cassTestServiceImplEntity.getLongField());
                    }

                    if (cassTestServiceImplEntity.getLongRequiredField() != null) {
                        existingCassTestServiceImplEntity.setLongRequiredField(cassTestServiceImplEntity.getLongRequiredField());
                    }

                    if (cassTestServiceImplEntity.getLongMinField() != null) {
                        existingCassTestServiceImplEntity.setLongMinField(cassTestServiceImplEntity.getLongMinField());
                    }

                    if (cassTestServiceImplEntity.getLongMaxField() != null) {
                        existingCassTestServiceImplEntity.setLongMaxField(cassTestServiceImplEntity.getLongMaxField());
                    }

                    if (cassTestServiceImplEntity.getFloatField() != null) {
                        existingCassTestServiceImplEntity.setFloatField(cassTestServiceImplEntity.getFloatField());
                    }

                    if (cassTestServiceImplEntity.getFloatRequiredField() != null) {
                        existingCassTestServiceImplEntity.setFloatRequiredField(cassTestServiceImplEntity.getFloatRequiredField());
                    }

                    if (cassTestServiceImplEntity.getFloatMinField() != null) {
                        existingCassTestServiceImplEntity.setFloatMinField(cassTestServiceImplEntity.getFloatMinField());
                    }

                    if (cassTestServiceImplEntity.getFloatMaxField() != null) {
                        existingCassTestServiceImplEntity.setFloatMaxField(cassTestServiceImplEntity.getFloatMaxField());
                    }

                    if (cassTestServiceImplEntity.getDoubleRequiredField() != null) {
                        existingCassTestServiceImplEntity.setDoubleRequiredField(cassTestServiceImplEntity.getDoubleRequiredField());
                    }

                    if (cassTestServiceImplEntity.getDoubleMinField() != null) {
                        existingCassTestServiceImplEntity.setDoubleMinField(cassTestServiceImplEntity.getDoubleMinField());
                    }

                    if (cassTestServiceImplEntity.getDoubleMaxField() != null) {
                        existingCassTestServiceImplEntity.setDoubleMaxField(cassTestServiceImplEntity.getDoubleMaxField());
                    }

                    if (cassTestServiceImplEntity.getBigDecimalRequiredField() != null) {
                        existingCassTestServiceImplEntity.setBigDecimalRequiredField(
                            cassTestServiceImplEntity.getBigDecimalRequiredField()
                        );
                    }

                    if (cassTestServiceImplEntity.getBigDecimalMinField() != null) {
                        existingCassTestServiceImplEntity.setBigDecimalMinField(cassTestServiceImplEntity.getBigDecimalMinField());
                    }

                    if (cassTestServiceImplEntity.getBigDecimalMaxField() != null) {
                        existingCassTestServiceImplEntity.setBigDecimalMaxField(cassTestServiceImplEntity.getBigDecimalMaxField());
                    }

                    if (cassTestServiceImplEntity.getLocalDateField() != null) {
                        existingCassTestServiceImplEntity.setLocalDateField(cassTestServiceImplEntity.getLocalDateField());
                    }

                    if (cassTestServiceImplEntity.getLocalDateRequiredField() != null) {
                        existingCassTestServiceImplEntity.setLocalDateRequiredField(cassTestServiceImplEntity.getLocalDateRequiredField());
                    }

                    if (cassTestServiceImplEntity.getInstantDateField() != null) {
                        existingCassTestServiceImplEntity.setInstantDateField(cassTestServiceImplEntity.getInstantDateField());
                    }

                    if (cassTestServiceImplEntity.getInstantRequiredField() != null) {
                        existingCassTestServiceImplEntity.setInstantRequiredField(cassTestServiceImplEntity.getInstantRequiredField());
                    }

                    if (cassTestServiceImplEntity.getZonedDateTimeField() != null) {
                        existingCassTestServiceImplEntity.setZonedDateTimeField(cassTestServiceImplEntity.getZonedDateTimeField());
                    }

                    if (cassTestServiceImplEntity.getZonedDateTimeRequiredField() != null) {
                        existingCassTestServiceImplEntity.setZonedDateTimeRequiredField(
                            cassTestServiceImplEntity.getZonedDateTimeRequiredField()
                        );
                    }

                    if (cassTestServiceImplEntity.getDurationDateField() != null) {
                        existingCassTestServiceImplEntity.setDurationDateField(cassTestServiceImplEntity.getDurationDateField());
                    }

                    if (cassTestServiceImplEntity.getDurationRequiredField() != null) {
                        existingCassTestServiceImplEntity.setDurationRequiredField(cassTestServiceImplEntity.getDurationRequiredField());
                    }

                    if (cassTestServiceImplEntity.getBooleanField() != null) {
                        existingCassTestServiceImplEntity.setBooleanField(cassTestServiceImplEntity.getBooleanField());
                    }

                    if (cassTestServiceImplEntity.getBooleanRequiredField() != null) {
                        existingCassTestServiceImplEntity.setBooleanRequiredField(cassTestServiceImplEntity.getBooleanRequiredField());
                    }

                    if (cassTestServiceImplEntity.getEnumTom() != null) {
                        existingCassTestServiceImplEntity.setEnumTom(cassTestServiceImplEntity.getEnumTom());
                    }

                    if (cassTestServiceImplEntity.getEnumRequiredTom() != null) {
                        existingCassTestServiceImplEntity.setEnumRequiredTom(cassTestServiceImplEntity.getEnumRequiredTom());
                    }

                    if (cassTestServiceImplEntity.getPicture() != null) {
                        existingCassTestServiceImplEntity.setPicture(cassTestServiceImplEntity.getPicture());
                    }
                    if (cassTestServiceImplEntity.getPictureContentType() != null) {
                        existingCassTestServiceImplEntity.setPictureContentType(cassTestServiceImplEntity.getPictureContentType());
                    }

                    if (cassTestServiceImplEntity.getOperationsFile() != null) {
                        existingCassTestServiceImplEntity.setOperationsFile(cassTestServiceImplEntity.getOperationsFile());
                    }
                    if (cassTestServiceImplEntity.getOperationsFileContentType() != null) {
                        existingCassTestServiceImplEntity.setOperationsFileContentType(
                            cassTestServiceImplEntity.getOperationsFileContentType()
                        );
                    }

                    return existingCassTestServiceImplEntity;
                }
            )
            .map(cassTestServiceImplEntityRepository::save);
    }

    @Override
    public List<CassTestServiceImplEntity> findAll() {
        log.debug("Request to get all CassTestServiceImplEntities");
        return cassTestServiceImplEntityRepository.findAll();
    }

    @Override
    public Optional<CassTestServiceImplEntity> findOne(UUID id) {
        log.debug("Request to get CassTestServiceImplEntity : {}", id);
        return cassTestServiceImplEntityRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Request to delete CassTestServiceImplEntity : {}", id);
        cassTestServiceImplEntityRepository.deleteById(id);
    }
}
