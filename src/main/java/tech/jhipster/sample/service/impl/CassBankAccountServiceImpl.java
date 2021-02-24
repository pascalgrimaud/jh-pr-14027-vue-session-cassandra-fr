package tech.jhipster.sample.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.CassBankAccount;
import tech.jhipster.sample.repository.CassBankAccountRepository;
import tech.jhipster.sample.service.CassBankAccountService;
import tech.jhipster.sample.service.dto.CassBankAccountDTO;
import tech.jhipster.sample.service.mapper.CassBankAccountMapper;

/**
 * Service Implementation for managing {@link CassBankAccount}.
 */
@Service
public class CassBankAccountServiceImpl implements CassBankAccountService {

    private final Logger log = LoggerFactory.getLogger(CassBankAccountServiceImpl.class);

    private final CassBankAccountRepository cassBankAccountRepository;

    private final CassBankAccountMapper cassBankAccountMapper;

    public CassBankAccountServiceImpl(CassBankAccountRepository cassBankAccountRepository, CassBankAccountMapper cassBankAccountMapper) {
        this.cassBankAccountRepository = cassBankAccountRepository;
        this.cassBankAccountMapper = cassBankAccountMapper;
    }

    @Override
    public CassBankAccountDTO save(CassBankAccountDTO cassBankAccountDTO) {
        log.debug("Request to save CassBankAccount : {}", cassBankAccountDTO);
        CassBankAccount cassBankAccount = cassBankAccountMapper.toEntity(cassBankAccountDTO);
        cassBankAccount = cassBankAccountRepository.save(cassBankAccount);
        return cassBankAccountMapper.toDto(cassBankAccount);
    }

    @Override
    public Optional<CassBankAccountDTO> partialUpdate(CassBankAccountDTO cassBankAccountDTO) {
        log.debug("Request to partially update CassBankAccount : {}", cassBankAccountDTO);

        return cassBankAccountRepository
            .findById(cassBankAccountDTO.getId())
            .map(
                existingCassBankAccount -> {
                    if (cassBankAccountDTO.getUserId() != null) {
                        existingCassBankAccount.setUserId(cassBankAccountDTO.getUserId());
                    }

                    if (cassBankAccountDTO.getName() != null) {
                        existingCassBankAccount.setName(cassBankAccountDTO.getName());
                    }

                    if (cassBankAccountDTO.getBankNumber() != null) {
                        existingCassBankAccount.setBankNumber(cassBankAccountDTO.getBankNumber());
                    }

                    if (cassBankAccountDTO.getAgencyNumber() != null) {
                        existingCassBankAccount.setAgencyNumber(cassBankAccountDTO.getAgencyNumber());
                    }

                    if (cassBankAccountDTO.getLastOperationDuration() != null) {
                        existingCassBankAccount.setLastOperationDuration(cassBankAccountDTO.getLastOperationDuration());
                    }

                    if (cassBankAccountDTO.getMeanOperationDuration() != null) {
                        existingCassBankAccount.setMeanOperationDuration(cassBankAccountDTO.getMeanOperationDuration());
                    }

                    if (cassBankAccountDTO.getBalance() != null) {
                        existingCassBankAccount.setBalance(cassBankAccountDTO.getBalance());
                    }

                    if (cassBankAccountDTO.getLastOperationDate() != null) {
                        existingCassBankAccount.setLastOperationDate(cassBankAccountDTO.getLastOperationDate());
                    }

                    if (cassBankAccountDTO.getActive() != null) {
                        existingCassBankAccount.setActive(cassBankAccountDTO.getActive());
                    }

                    if (cassBankAccountDTO.getPicture() != null) {
                        existingCassBankAccount.setPicture(cassBankAccountDTO.getPicture());
                    }
                    if (cassBankAccountDTO.getPictureContentType() != null) {
                        existingCassBankAccount.setPictureContentType(cassBankAccountDTO.getPictureContentType());
                    }

                    if (cassBankAccountDTO.getOperationsFile() != null) {
                        existingCassBankAccount.setOperationsFile(cassBankAccountDTO.getOperationsFile());
                    }
                    if (cassBankAccountDTO.getOperationsFileContentType() != null) {
                        existingCassBankAccount.setOperationsFileContentType(cassBankAccountDTO.getOperationsFileContentType());
                    }

                    if (cassBankAccountDTO.getAccountType() != null) {
                        existingCassBankAccount.setAccountType(cassBankAccountDTO.getAccountType());
                    }

                    return existingCassBankAccount;
                }
            )
            .map(cassBankAccountRepository::save)
            .map(cassBankAccountMapper::toDto);
    }

    @Override
    public List<CassBankAccountDTO> findAll() {
        log.debug("Request to get all CassBankAccounts");
        return cassBankAccountRepository
            .findAll()
            .stream()
            .map(cassBankAccountMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public Optional<CassBankAccountDTO> findOne(UUID id) {
        log.debug("Request to get CassBankAccount : {}", id);
        return cassBankAccountRepository.findById(id).map(cassBankAccountMapper::toDto);
    }

    @Override
    public void delete(UUID id) {
        log.debug("Request to delete CassBankAccount : {}", id);
        cassBankAccountRepository.deleteById(id);
    }
}
