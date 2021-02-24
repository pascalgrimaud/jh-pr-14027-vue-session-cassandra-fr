package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class CassBankAccountTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CassBankAccount.class);
        CassBankAccount cassBankAccount1 = new CassBankAccount();
        cassBankAccount1.setId(UUID.randomUUID());
        CassBankAccount cassBankAccount2 = new CassBankAccount();
        cassBankAccount2.setId(cassBankAccount1.getId());
        assertThat(cassBankAccount1).isEqualTo(cassBankAccount2);
        cassBankAccount2.setId(UUID.randomUUID());
        assertThat(cassBankAccount1).isNotEqualTo(cassBankAccount2);
        cassBankAccount1.setId(null);
        assertThat(cassBankAccount1).isNotEqualTo(cassBankAccount2);
    }
}
