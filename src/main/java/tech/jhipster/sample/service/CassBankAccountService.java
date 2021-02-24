package tech.jhipster.sample.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import tech.jhipster.sample.service.dto.CassBankAccountDTO;

/**
 * Service Interface for managing {@link tech.jhipster.sample.domain.CassBankAccount}.
 */
public interface CassBankAccountService {
    /**
     * Save a cassBankAccount.
     *
     * @param cassBankAccountDTO the entity to save.
     * @return the persisted entity.
     */
    CassBankAccountDTO save(CassBankAccountDTO cassBankAccountDTO);

    /**
     * Partially updates a cassBankAccount.
     *
     * @param cassBankAccountDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CassBankAccountDTO> partialUpdate(CassBankAccountDTO cassBankAccountDTO);

    /**
     * Get all the cassBankAccounts.
     *
     * @return the list of entities.
     */
    List<CassBankAccountDTO> findAll();

    /**
     * Get the "id" cassBankAccount.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CassBankAccountDTO> findOne(UUID id);

    /**
     * Delete the "id" cassBankAccount.
     *
     * @param id the id of the entity.
     */
    void delete(UUID id);
}
