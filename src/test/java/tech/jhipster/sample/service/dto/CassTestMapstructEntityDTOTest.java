package tech.jhipster.sample.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class CassTestMapstructEntityDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CassTestMapstructEntityDTO.class);
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO1 = new CassTestMapstructEntityDTO();
        cassTestMapstructEntityDTO1.setId(UUID.randomUUID());
        CassTestMapstructEntityDTO cassTestMapstructEntityDTO2 = new CassTestMapstructEntityDTO();
        assertThat(cassTestMapstructEntityDTO1).isNotEqualTo(cassTestMapstructEntityDTO2);
        cassTestMapstructEntityDTO2.setId(cassTestMapstructEntityDTO1.getId());
        assertThat(cassTestMapstructEntityDTO1).isEqualTo(cassTestMapstructEntityDTO2);
        cassTestMapstructEntityDTO2.setId(UUID.randomUUID());
        assertThat(cassTestMapstructEntityDTO1).isNotEqualTo(cassTestMapstructEntityDTO2);
        cassTestMapstructEntityDTO1.setId(null);
        assertThat(cassTestMapstructEntityDTO1).isNotEqualTo(cassTestMapstructEntityDTO2);
    }
}
