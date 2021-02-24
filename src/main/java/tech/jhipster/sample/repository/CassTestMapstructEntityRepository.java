package tech.jhipster.sample.repository;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import tech.jhipster.sample.domain.CassTestMapstructEntity;

/**
 * Spring Data Cassandra repository for the CassTestMapstructEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CassTestMapstructEntityRepository extends CassandraRepository<CassTestMapstructEntity, UUID> {}
