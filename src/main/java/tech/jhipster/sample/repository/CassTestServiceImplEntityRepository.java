package tech.jhipster.sample.repository;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import tech.jhipster.sample.domain.CassTestServiceImplEntity;

/**
 * Spring Data Cassandra repository for the CassTestServiceImplEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CassTestServiceImplEntityRepository extends CassandraRepository<CassTestServiceImplEntity, UUID> {}
