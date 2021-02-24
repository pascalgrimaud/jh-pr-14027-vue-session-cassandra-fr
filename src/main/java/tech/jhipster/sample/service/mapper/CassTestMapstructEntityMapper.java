package tech.jhipster.sample.service.mapper;

import org.mapstruct.*;
import tech.jhipster.sample.domain.*;
import tech.jhipster.sample.service.dto.CassTestMapstructEntityDTO;

/**
 * Mapper for the entity {@link CassTestMapstructEntity} and its DTO {@link CassTestMapstructEntityDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CassTestMapstructEntityMapper extends EntityMapper<CassTestMapstructEntityDTO, CassTestMapstructEntity> {}
