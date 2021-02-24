package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class CassTestServiceImplEntityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CassTestServiceImplEntity.class);
        CassTestServiceImplEntity cassTestServiceImplEntity1 = new CassTestServiceImplEntity();
        cassTestServiceImplEntity1.setId(UUID.randomUUID());
        CassTestServiceImplEntity cassTestServiceImplEntity2 = new CassTestServiceImplEntity();
        cassTestServiceImplEntity2.setId(cassTestServiceImplEntity1.getId());
        assertThat(cassTestServiceImplEntity1).isEqualTo(cassTestServiceImplEntity2);
        cassTestServiceImplEntity2.setId(UUID.randomUUID());
        assertThat(cassTestServiceImplEntity1).isNotEqualTo(cassTestServiceImplEntity2);
        cassTestServiceImplEntity1.setId(null);
        assertThat(cassTestServiceImplEntity1).isNotEqualTo(cassTestServiceImplEntity2);
    }
}
