package tech.jhipster.sample.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import tech.jhipster.sample.domain.CassTestServiceImplEntity;

/**
 * Service Interface for managing {@link CassTestServiceImplEntity}.
 */
public interface CassTestServiceImplEntityService {
    /**
     * Save a cassTestServiceImplEntity.
     *
     * @param cassTestServiceImplEntity the entity to save.
     * @return the persisted entity.
     */
    CassTestServiceImplEntity save(CassTestServiceImplEntity cassTestServiceImplEntity);

    /**
     * Partially updates a cassTestServiceImplEntity.
     *
     * @param cassTestServiceImplEntity the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CassTestServiceImplEntity> partialUpdate(CassTestServiceImplEntity cassTestServiceImplEntity);

    /**
     * Get all the cassTestServiceImplEntities.
     *
     * @return the list of entities.
     */
    List<CassTestServiceImplEntity> findAll();

    /**
     * Get the "id" cassTestServiceImplEntity.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CassTestServiceImplEntity> findOne(UUID id);

    /**
     * Delete the "id" cassTestServiceImplEntity.
     *
     * @param id the id of the entity.
     */
    void delete(UUID id);
}
