package tech.jhipster.sample.repository;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import tech.jhipster.sample.domain.CassBankAccount;

/**
 * Spring Data Cassandra repository for the CassBankAccount entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CassBankAccountRepository extends CassandraRepository<CassBankAccount, UUID> {}
