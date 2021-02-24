package tech.jhipster.sample.repository;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import tech.jhipster.sample.domain.CassTestServiceClassEntity;

/**
 * Spring Data Cassandra repository for the CassTestServiceClassEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CassTestServiceClassEntityRepository extends CassandraRepository<CassTestServiceClassEntity, UUID> {}
