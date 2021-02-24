package tech.jhipster.sample.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class CassBankAccountDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CassBankAccountDTO.class);
        CassBankAccountDTO cassBankAccountDTO1 = new CassBankAccountDTO();
        cassBankAccountDTO1.setId(UUID.randomUUID());
        CassBankAccountDTO cassBankAccountDTO2 = new CassBankAccountDTO();
        assertThat(cassBankAccountDTO1).isNotEqualTo(cassBankAccountDTO2);
        cassBankAccountDTO2.setId(cassBankAccountDTO1.getId());
        assertThat(cassBankAccountDTO1).isEqualTo(cassBankAccountDTO2);
        cassBankAccountDTO2.setId(UUID.randomUUID());
        assertThat(cassBankAccountDTO1).isNotEqualTo(cassBankAccountDTO2);
        cassBankAccountDTO1.setId(null);
        assertThat(cassBankAccountDTO1).isNotEqualTo(cassBankAccountDTO2);
    }
}
