package tech.jhipster.sample.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import tech.jhipster.sample.service.dto.CassTestMapstructEntityDTO;

/**
 * Service Interface for managing {@link tech.jhipster.sample.domain.CassTestMapstructEntity}.
 */
public interface CassTestMapstructEntityService {
    /**
     * Save a cassTestMapstructEntity.
     *
     * @param cassTestMapstructEntityDTO the entity to save.
     * @return the persisted entity.
     */
    CassTestMapstructEntityDTO save(CassTestMapstructEntityDTO cassTestMapstructEntityDTO);

    /**
     * Partially updates a cassTestMapstructEntity.
     *
     * @param cassTestMapstructEntityDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CassTestMapstructEntityDTO> partialUpdate(CassTestMapstructEntityDTO cassTestMapstructEntityDTO);

    /**
     * Get all the cassTestMapstructEntities.
     *
     * @return the list of entities.
     */
    List<CassTestMapstructEntityDTO> findAll();

    /**
     * Get the "id" cassTestMapstructEntity.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CassTestMapstructEntityDTO> findOne(UUID id);

    /**
     * Delete the "id" cassTestMapstructEntity.
     *
     * @param id the id of the entity.
     */
    void delete(UUID id);
}
