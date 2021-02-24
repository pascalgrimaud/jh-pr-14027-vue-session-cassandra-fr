package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class CassTestMapstructEntityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CassTestMapstructEntity.class);
        CassTestMapstructEntity cassTestMapstructEntity1 = new CassTestMapstructEntity();
        cassTestMapstructEntity1.setId(UUID.randomUUID());
        CassTestMapstructEntity cassTestMapstructEntity2 = new CassTestMapstructEntity();
        cassTestMapstructEntity2.setId(cassTestMapstructEntity1.getId());
        assertThat(cassTestMapstructEntity1).isEqualTo(cassTestMapstructEntity2);
        cassTestMapstructEntity2.setId(UUID.randomUUID());
        assertThat(cassTestMapstructEntity1).isNotEqualTo(cassTestMapstructEntity2);
        cassTestMapstructEntity1.setId(null);
        assertThat(cassTestMapstructEntity1).isNotEqualTo(cassTestMapstructEntity2);
    }
}
