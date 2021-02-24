package tech.jhipster.sample.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.CassTestMapstructEntity;
import tech.jhipster.sample.repository.CassTestMapstructEntityRepository;
import tech.jhipster.sample.service.CassTestMapstructEntityService;
import tech.jhipster.sample.service.dto.CassTestMapstructEntityDTO;
import tech.jhipster.sample.service.mapper.CassTestMapstructEntityMapper;

/**
 * Service Implementation for managing {@link CassTestMapstructEntity}.
 */
@Service
public class CassTestMapstructEntityServiceImpl implements CassTestMapstructEntityService {

    private final Logger log = LoggerFactory.getLogger(CassTestMapstructEntityServiceImpl.class);

    private final CassTestMapstructEntityRepository cassTestMapstructEntityRepository;

    private final CassTestMapstructEntityMapper cassTestMapstructEntityMapper;

    public CassTestMapstructEntityServiceImpl(
        CassTestMapstructEntityRepository cassTestMapstructEntityRepository,
        CassTestMapstructEntityMapper cassTestMapstructEntityMapper
    ) {
        this.cassTestMapstructEntityRepository = cassTestMapstructEntityRepository;
        this.cassTestMapstructEntityMapper = cassTestMapstructEntityMapper;
    }

    @Override
    public CassTestMapstructEntityDTO save(CassTestMapstructEntityDTO cassTestMapstructEntityDTO) {
        log.debug("Request to save CassTestMapstructEntity : {}", cassTestMapstructEntityDTO);
        CassTestMapstructEntity cassTestMapstructEntity = cassTestMapstructEntityMapper.toEntity(cassTestMapstructEntityDTO);
        cassTestMapstructEntity = cassTestMapstructEntityRepository.save(cassTestMapstructEntity);
        return cassTestMapstructEntityMapper.toDto(cassTestMapstructEntity);
    }

    @Override
    public Optional<CassTestMapstructEntityDTO> partialUpdate(CassTestMapstructEntityDTO cassTestMapstructEntityDTO) {
        log.debug("Request to partially update CassTestMapstructEntity : {}", cassTestMapstructEntityDTO);

        return cassTestMapstructEntityRepository
            .findById(cassTestMapstructEntityDTO.getId())
            .map(
                existingCassTestMapstructEntity -> {
                    if (cassTestMapstructEntityDTO.getStringField() != null) {
                        existingCassTestMapstructEntity.setStringField(cassTestMapstructEntityDTO.getStringField());
                    }

                    if (cassTestMapstructEntityDTO.getStringRequiredField() != null) {
                        existingCassTestMapstructEntity.setStringRequiredField(cassTestMapstructEntityDTO.getStringRequiredField());
                    }

                    if (cassTestMapstructEntityDTO.getStringMinlengthField() != null) {
                        existingCassTestMapstructEntity.setStringMinlengthField(cassTestMapstructEntityDTO.getStringMinlengthField());
                    }

                    if (cassTestMapstructEntityDTO.getStringMaxlengthField() != null) {
                        existingCassTestMapstructEntity.setStringMaxlengthField(cassTestMapstructEntityDTO.getStringMaxlengthField());
                    }

                    if (cassTestMapstructEntityDTO.getStringPatternField() != null) {
                        existingCassTestMapstructEntity.setStringPatternField(cassTestMapstructEntityDTO.getStringPatternField());
                    }

                    if (cassTestMapstructEntityDTO.getIntegerField() != null) {
                        existingCassTestMapstructEntity.setIntegerField(cassTestMapstructEntityDTO.getIntegerField());
                    }

                    if (cassTestMapstructEntityDTO.getIntegerRequiredField() != null) {
                        existingCassTestMapstructEntity.setIntegerRequiredField(cassTestMapstructEntityDTO.getIntegerRequiredField());
                    }

                    if (cassTestMapstructEntityDTO.getIntegerMinField() != null) {
                        existingCassTestMapstructEntity.setIntegerMinField(cassTestMapstructEntityDTO.getIntegerMinField());
                    }

                    if (cassTestMapstructEntityDTO.getIntegerMaxField() != null) {
                        existingCassTestMapstructEntity.setIntegerMaxField(cassTestMapstructEntityDTO.getIntegerMaxField());
                    }

                    if (cassTestMapstructEntityDTO.getLongField() != null) {
                        existingCassTestMapstructEntity.setLongField(cassTestMapstructEntityDTO.getLongField());
                    }

                    if (cassTestMapstructEntityDTO.getLongRequiredField() != null) {
                        existingCassTestMapstructEntity.setLongRequiredField(cassTestMapstructEntityDTO.getLongRequiredField());
                    }

                    if (cassTestMapstructEntityDTO.getLongMinField() != null) {
                        existingCassTestMapstructEntity.setLongMinField(cassTestMapstructEntityDTO.getLongMinField());
                    }

                    if (cassTestMapstructEntityDTO.getLongMaxField() != null) {
                        existingCassTestMapstructEntity.setLongMaxField(cassTestMapstructEntityDTO.getLongMaxField());
                    }

                    if (cassTestMapstructEntityDTO.getFloatField() != null) {
                        existingCassTestMapstructEntity.setFloatField(cassTestMapstructEntityDTO.getFloatField());
                    }

                    if (cassTestMapstructEntityDTO.getFloatRequiredField() != null) {
                        existingCassTestMapstructEntity.setFloatRequiredField(cassTestMapstructEntityDTO.getFloatRequiredField());
                    }

                    if (cassTestMapstructEntityDTO.getFloatMinField() != null) {
                        existingCassTestMapstructEntity.setFloatMinField(cassTestMapstructEntityDTO.getFloatMinField());
                    }

                    if (cassTestMapstructEntityDTO.getFloatMaxField() != null) {
                        existingCassTestMapstructEntity.setFloatMaxField(cassTestMapstructEntityDTO.getFloatMaxField());
                    }

                    if (cassTestMapstructEntityDTO.getDoubleRequiredField() != null) {
                        existingCassTestMapstructEntity.setDoubleRequiredField(cassTestMapstructEntityDTO.getDoubleRequiredField());
                    }

                    if (cassTestMapstructEntityDTO.getDoubleMinField() != null) {
                        existingCassTestMapstructEntity.setDoubleMinField(cassTestMapstructEntityDTO.getDoubleMinField());
                    }

                    if (cassTestMapstructEntityDTO.getDoubleMaxField() != null) {
                        existingCassTestMapstructEntity.setDoubleMaxField(cassTestMapstructEntityDTO.getDoubleMaxField());
                    }

                    if (cassTestMapstructEntityDTO.getBigDecimalRequiredField() != null) {
                        existingCassTestMapstructEntity.setBigDecimalRequiredField(cassTestMapstructEntityDTO.getBigDecimalRequiredField());
                    }

                    if (cassTestMapstructEntityDTO.getBigDecimalMinField() != null) {
                        existingCassTestMapstructEntity.setBigDecimalMinField(cassTestMapstructEntityDTO.getBigDecimalMinField());
                    }

                    if (cassTestMapstructEntityDTO.getBigDecimalMaxField() != null) {
                        existingCassTestMapstructEntity.setBigDecimalMaxField(cassTestMapstructEntityDTO.getBigDecimalMaxField());
                    }

                    if (cassTestMapstructEntityDTO.getLocalDateField() != null) {
                        existingCassTestMapstructEntity.setLocalDateField(cassTestMapstructEntityDTO.getLocalDateField());
                    }

                    if (cassTestMapstructEntityDTO.getLocalDateRequiredField() != null) {
                        existingCassTestMapstructEntity.setLocalDateRequiredField(cassTestMapstructEntityDTO.getLocalDateRequiredField());
                    }

                    if (cassTestMapstructEntityDTO.getInstantDateField() != null) {
                        existingCassTestMapstructEntity.setInstantDateField(cassTestMapstructEntityDTO.getInstantDateField());
                    }

                    if (cassTestMapstructEntityDTO.getInstantRequiredField() != null) {
                        existingCassTestMapstructEntity.setInstantRequiredField(cassTestMapstructEntityDTO.getInstantRequiredField());
                    }

                    if (cassTestMapstructEntityDTO.getZonedDateTimeField() != null) {
                        existingCassTestMapstructEntity.setZonedDateTimeField(cassTestMapstructEntityDTO.getZonedDateTimeField());
                    }

                    if (cassTestMapstructEntityDTO.getZonedDateTimeRequiredField() != null) {
                        existingCassTestMapstructEntity.setZonedDateTimeRequiredField(
                            cassTestMapstructEntityDTO.getZonedDateTimeRequiredField()
                        );
                    }

                    if (cassTestMapstructEntityDTO.getDurationDateField() != null) {
                        existingCassTestMapstructEntity.setDurationDateField(cassTestMapstructEntityDTO.getDurationDateField());
                    }

                    if (cassTestMapstructEntityDTO.getDurationRequiredField() != null) {
                        existingCassTestMapstructEntity.setDurationRequiredField(cassTestMapstructEntityDTO.getDurationRequiredField());
                    }

                    if (cassTestMapstructEntityDTO.getBooleanField() != null) {
                        existingCassTestMapstructEntity.setBooleanField(cassTestMapstructEntityDTO.getBooleanField());
                    }

                    if (cassTestMapstructEntityDTO.getBooleanRequiredField() != null) {
                        existingCassTestMapstructEntity.setBooleanRequiredField(cassTestMapstructEntityDTO.getBooleanRequiredField());
                    }

                    if (cassTestMapstructEntityDTO.getEnumTom() != null) {
                        existingCassTestMapstructEntity.setEnumTom(cassTestMapstructEntityDTO.getEnumTom());
                    }

                    if (cassTestMapstructEntityDTO.getEnumRequiredTom() != null) {
                        existingCassTestMapstructEntity.setEnumRequiredTom(cassTestMapstructEntityDTO.getEnumRequiredTom());
                    }

                    if (cassTestMapstructEntityDTO.getPicture() != null) {
                        existingCassTestMapstructEntity.setPicture(cassTestMapstructEntityDTO.getPicture());
                    }
                    if (cassTestMapstructEntityDTO.getPictureContentType() != null) {
                        existingCassTestMapstructEntity.setPictureContentType(cassTestMapstructEntityDTO.getPictureContentType());
                    }

                    if (cassTestMapstructEntityDTO.getOperationsFile() != null) {
                        existingCassTestMapstructEntity.setOperationsFile(cassTestMapstructEntityDTO.getOperationsFile());
                    }
                    if (cassTestMapstructEntityDTO.getOperationsFileContentType() != null) {
                        existingCassTestMapstructEntity.setOperationsFileContentType(
                            cassTestMapstructEntityDTO.getOperationsFileContentType()
                        );
                    }

                    return existingCassTestMapstructEntity;
                }
            )
            .map(cassTestMapstructEntityRepository::save)
            .map(cassTestMapstructEntityMapper::toDto);
    }

    @Override
    public List<CassTestMapstructEntityDTO> findAll() {
        log.debug("Request to get all CassTestMapstructEntities");
        return cassTestMapstructEntityRepository
            .findAll()
            .stream()
            .map(cassTestMapstructEntityMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public Optional<CassTestMapstructEntityDTO> findOne(UUID id) {
        log.debug("Request to get CassTestMapstructEntity : {}", id);
        return cassTestMapstructEntityRepository.findById(id).map(cassTestMapstructEntityMapper::toDto);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Request to delete CassTestMapstructEntity : {}", id);
        cassTestMapstructEntityRepository.deleteById(id);
    }
}
