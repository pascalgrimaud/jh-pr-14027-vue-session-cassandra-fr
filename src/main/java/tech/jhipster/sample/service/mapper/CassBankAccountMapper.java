package tech.jhipster.sample.service.mapper;

import org.mapstruct.*;
import tech.jhipster.sample.domain.*;
import tech.jhipster.sample.service.dto.CassBankAccountDTO;

/**
 * Mapper for the entity {@link CassBankAccount} and its DTO {@link CassBankAccountDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CassBankAccountMapper extends EntityMapper<CassBankAccountDTO, CassBankAccount> {}
