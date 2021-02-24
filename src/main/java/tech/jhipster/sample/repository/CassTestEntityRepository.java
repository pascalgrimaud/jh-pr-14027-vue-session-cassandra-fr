package tech.jhipster.sample.repository;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import tech.jhipster.sample.domain.CassTestEntity;

/**
 * Spring Data Cassandra repository for the CassTestEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CassTestEntityRepository extends CassandraRepository<CassTestEntity, UUID> {}
