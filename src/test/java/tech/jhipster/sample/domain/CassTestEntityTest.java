package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class CassTestEntityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CassTestEntity.class);
        CassTestEntity cassTestEntity1 = new CassTestEntity();
        cassTestEntity1.setId(UUID.randomUUID());
        CassTestEntity cassTestEntity2 = new CassTestEntity();
        cassTestEntity2.setId(cassTestEntity1.getId());
        assertThat(cassTestEntity1).isEqualTo(cassTestEntity2);
        cassTestEntity2.setId(UUID.randomUUID());
        assertThat(cassTestEntity1).isNotEqualTo(cassTestEntity2);
        cassTestEntity1.setId(null);
        assertThat(cassTestEntity1).isNotEqualTo(cassTestEntity2);
    }
}
