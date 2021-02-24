package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class CassTestServiceClassEntityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CassTestServiceClassEntity.class);
        CassTestServiceClassEntity cassTestServiceClassEntity1 = new CassTestServiceClassEntity();
        cassTestServiceClassEntity1.setId(UUID.randomUUID());
        CassTestServiceClassEntity cassTestServiceClassEntity2 = new CassTestServiceClassEntity();
        cassTestServiceClassEntity2.setId(cassTestServiceClassEntity1.getId());
        assertThat(cassTestServiceClassEntity1).isEqualTo(cassTestServiceClassEntity2);
        cassTestServiceClassEntity2.setId(UUID.randomUUID());
        assertThat(cassTestServiceClassEntity1).isNotEqualTo(cassTestServiceClassEntity2);
        cassTestServiceClassEntity1.setId(null);
        assertThat(cassTestServiceClassEntity1).isNotEqualTo(cassTestServiceClassEntity2);
    }
}
