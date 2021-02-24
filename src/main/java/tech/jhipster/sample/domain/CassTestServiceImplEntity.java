package tech.jhipster.sample.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;

/**
 * A CassTestServiceImplEntity.
 */
@Table("cassTestServiceImplEntity")
public class CassTestServiceImplEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;

    private String stringField;

    @NotNull
    private String stringRequiredField;

    @Size(min = 0)
    private String stringMinlengthField;

    @Size(max = 20)
    private String stringMaxlengthField;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String stringPatternField;

    private Integer integerField;

    @NotNull
    private Integer integerRequiredField;

    @Min(value = 0)
    private Integer integerMinField;

    @Max(value = 100)
    private Integer integerMaxField;

    private Long longField;

    @NotNull
    private Long longRequiredField;

    @Min(value = 0L)
    private Long longMinField;

    @Max(value = 100L)
    private Long longMaxField;

    private Float floatField;

    @NotNull
    private Float floatRequiredField;

    @DecimalMin(value = "0")
    private Float floatMinField;

    @DecimalMax(value = "100")
    private Float floatMaxField;

    @NotNull
    private Double doubleRequiredField;

    @DecimalMin(value = "0")
    private Double doubleMinField;

    @DecimalMax(value = "100")
    private Double doubleMaxField;

    @NotNull
    private BigDecimal bigDecimalRequiredField;

    @DecimalMin(value = "0")
    private BigDecimal bigDecimalMinField;

    @DecimalMax(value = "100")
    private BigDecimal bigDecimalMaxField;

    private LocalDate localDateField;

    @NotNull
    private LocalDate localDateRequiredField;

    private Instant instantDateField;

    @NotNull
    private Instant instantRequiredField;

    private ZonedDateTime zonedDateTimeField;

    @NotNull
    private ZonedDateTime zonedDateTimeRequiredField;

    private Duration durationDateField;

    @NotNull
    private Duration durationRequiredField;

    private Boolean booleanField;

    @NotNull
    private Boolean booleanRequiredField;

    private EnumFieldClass enumTom;

    @NotNull
    private EnumRequiredFieldClass enumRequiredTom;

    private ByteBuffer picture;

    @Column("picture_content_type")
    private String pictureContentType;

    private ByteBuffer operationsFile;

    @Column("operations_file_content_type")
    private String operationsFileContentType;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CassTestServiceImplEntity id(UUID id) {
        this.id = id;
        return this;
    }

    public String getStringField() {
        return this.stringField;
    }

    public CassTestServiceImplEntity stringField(String stringField) {
        this.stringField = stringField;
        return this;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public String getStringRequiredField() {
        return this.stringRequiredField;
    }

    public CassTestServiceImplEntity stringRequiredField(String stringRequiredField) {
        this.stringRequiredField = stringRequiredField;
        return this;
    }

    public void setStringRequiredField(String stringRequiredField) {
        this.stringRequiredField = stringRequiredField;
    }

    public String getStringMinlengthField() {
        return this.stringMinlengthField;
    }

    public CassTestServiceImplEntity stringMinlengthField(String stringMinlengthField) {
        this.stringMinlengthField = stringMinlengthField;
        return this;
    }

    public void setStringMinlengthField(String stringMinlengthField) {
        this.stringMinlengthField = stringMinlengthField;
    }

    public String getStringMaxlengthField() {
        return this.stringMaxlengthField;
    }

    public CassTestServiceImplEntity stringMaxlengthField(String stringMaxlengthField) {
        this.stringMaxlengthField = stringMaxlengthField;
        return this;
    }

    public void setStringMaxlengthField(String stringMaxlengthField) {
        this.stringMaxlengthField = stringMaxlengthField;
    }

    public String getStringPatternField() {
        return this.stringPatternField;
    }

    public CassTestServiceImplEntity stringPatternField(String stringPatternField) {
        this.stringPatternField = stringPatternField;
        return this;
    }

    public void setStringPatternField(String stringPatternField) {
        this.stringPatternField = stringPatternField;
    }

    public Integer getIntegerField() {
        return this.integerField;
    }

    public CassTestServiceImplEntity integerField(Integer integerField) {
        this.integerField = integerField;
        return this;
    }

    public void setIntegerField(Integer integerField) {
        this.integerField = integerField;
    }

    public Integer getIntegerRequiredField() {
        return this.integerRequiredField;
    }

    public CassTestServiceImplEntity integerRequiredField(Integer integerRequiredField) {
        this.integerRequiredField = integerRequiredField;
        return this;
    }

    public void setIntegerRequiredField(Integer integerRequiredField) {
        this.integerRequiredField = integerRequiredField;
    }

    public Integer getIntegerMinField() {
        return this.integerMinField;
    }

    public CassTestServiceImplEntity integerMinField(Integer integerMinField) {
        this.integerMinField = integerMinField;
        return this;
    }

    public void setIntegerMinField(Integer integerMinField) {
        this.integerMinField = integerMinField;
    }

    public Integer getIntegerMaxField() {
        return this.integerMaxField;
    }

    public CassTestServiceImplEntity integerMaxField(Integer integerMaxField) {
        this.integerMaxField = integerMaxField;
        return this;
    }

    public void setIntegerMaxField(Integer integerMaxField) {
        this.integerMaxField = integerMaxField;
    }

    public Long getLongField() {
        return this.longField;
    }

    public CassTestServiceImplEntity longField(Long longField) {
        this.longField = longField;
        return this;
    }

    public void setLongField(Long longField) {
        this.longField = longField;
    }

    public Long getLongRequiredField() {
        return this.longRequiredField;
    }

    public CassTestServiceImplEntity longRequiredField(Long longRequiredField) {
        this.longRequiredField = longRequiredField;
        return this;
    }

    public void setLongRequiredField(Long longRequiredField) {
        this.longRequiredField = longRequiredField;
    }

    public Long getLongMinField() {
        return this.longMinField;
    }

    public CassTestServiceImplEntity longMinField(Long longMinField) {
        this.longMinField = longMinField;
        return this;
    }

    public void setLongMinField(Long longMinField) {
        this.longMinField = longMinField;
    }

    public Long getLongMaxField() {
        return this.longMaxField;
    }

    public CassTestServiceImplEntity longMaxField(Long longMaxField) {
        this.longMaxField = longMaxField;
        return this;
    }

    public void setLongMaxField(Long longMaxField) {
        this.longMaxField = longMaxField;
    }

    public Float getFloatField() {
        return this.floatField;
    }

    public CassTestServiceImplEntity floatField(Float floatField) {
        this.floatField = floatField;
        return this;
    }

    public void setFloatField(Float floatField) {
        this.floatField = floatField;
    }

    public Float getFloatRequiredField() {
        return this.floatRequiredField;
    }

    public CassTestServiceImplEntity floatRequiredField(Float floatRequiredField) {
        this.floatRequiredField = floatRequiredField;
        return this;
    }

    public void setFloatRequiredField(Float floatRequiredField) {
        this.floatRequiredField = floatRequiredField;
    }

    public Float getFloatMinField() {
        return this.floatMinField;
    }

    public CassTestServiceImplEntity floatMinField(Float floatMinField) {
        this.floatMinField = floatMinField;
        return this;
    }

    public void setFloatMinField(Float floatMinField) {
        this.floatMinField = floatMinField;
    }

    public Float getFloatMaxField() {
        return this.floatMaxField;
    }

    public CassTestServiceImplEntity floatMaxField(Float floatMaxField) {
        this.floatMaxField = floatMaxField;
        return this;
    }

    public void setFloatMaxField(Float floatMaxField) {
        this.floatMaxField = floatMaxField;
    }

    public Double getDoubleRequiredField() {
        return this.doubleRequiredField;
    }

    public CassTestServiceImplEntity doubleRequiredField(Double doubleRequiredField) {
        this.doubleRequiredField = doubleRequiredField;
        return this;
    }

    public void setDoubleRequiredField(Double doubleRequiredField) {
        this.doubleRequiredField = doubleRequiredField;
    }

    public Double getDoubleMinField() {
        return this.doubleMinField;
    }

    public CassTestServiceImplEntity doubleMinField(Double doubleMinField) {
        this.doubleMinField = doubleMinField;
        return this;
    }

    public void setDoubleMinField(Double doubleMinField) {
        this.doubleMinField = doubleMinField;
    }

    public Double getDoubleMaxField() {
        return this.doubleMaxField;
    }

    public CassTestServiceImplEntity doubleMaxField(Double doubleMaxField) {
        this.doubleMaxField = doubleMaxField;
        return this;
    }

    public void setDoubleMaxField(Double doubleMaxField) {
        this.doubleMaxField = doubleMaxField;
    }

    public BigDecimal getBigDecimalRequiredField() {
        return this.bigDecimalRequiredField;
    }

    public CassTestServiceImplEntity bigDecimalRequiredField(BigDecimal bigDecimalRequiredField) {
        this.bigDecimalRequiredField = bigDecimalRequiredField;
        return this;
    }

    public void setBigDecimalRequiredField(BigDecimal bigDecimalRequiredField) {
        this.bigDecimalRequiredField = bigDecimalRequiredField;
    }

    public BigDecimal getBigDecimalMinField() {
        return this.bigDecimalMinField;
    }

    public CassTestServiceImplEntity bigDecimalMinField(BigDecimal bigDecimalMinField) {
        this.bigDecimalMinField = bigDecimalMinField;
        return this;
    }

    public void setBigDecimalMinField(BigDecimal bigDecimalMinField) {
        this.bigDecimalMinField = bigDecimalMinField;
    }

    public BigDecimal getBigDecimalMaxField() {
        return this.bigDecimalMaxField;
    }

    public CassTestServiceImplEntity bigDecimalMaxField(BigDecimal bigDecimalMaxField) {
        this.bigDecimalMaxField = bigDecimalMaxField;
        return this;
    }

    public void setBigDecimalMaxField(BigDecimal bigDecimalMaxField) {
        this.bigDecimalMaxField = bigDecimalMaxField;
    }

    public LocalDate getLocalDateField() {
        return this.localDateField;
    }

    public CassTestServiceImplEntity localDateField(LocalDate localDateField) {
        this.localDateField = localDateField;
        return this;
    }

    public void setLocalDateField(LocalDate localDateField) {
        this.localDateField = localDateField;
    }

    public LocalDate getLocalDateRequiredField() {
        return this.localDateRequiredField;
    }

    public CassTestServiceImplEntity localDateRequiredField(LocalDate localDateRequiredField) {
        this.localDateRequiredField = localDateRequiredField;
        return this;
    }

    public void setLocalDateRequiredField(LocalDate localDateRequiredField) {
        this.localDateRequiredField = localDateRequiredField;
    }

    public Instant getInstantDateField() {
        return this.instantDateField;
    }

    public CassTestServiceImplEntity instantDateField(Instant instantDateField) {
        this.instantDateField = instantDateField;
        return this;
    }

    public void setInstantDateField(Instant instantDateField) {
        this.instantDateField = instantDateField;
    }

    public Instant getInstantRequiredField() {
        return this.instantRequiredField;
    }

    public CassTestServiceImplEntity instantRequiredField(Instant instantRequiredField) {
        this.instantRequiredField = instantRequiredField;
        return this;
    }

    public void setInstantRequiredField(Instant instantRequiredField) {
        this.instantRequiredField = instantRequiredField;
    }

    public ZonedDateTime getZonedDateTimeField() {
        return this.zonedDateTimeField;
    }

    public CassTestServiceImplEntity zonedDateTimeField(ZonedDateTime zonedDateTimeField) {
        this.zonedDateTimeField = zonedDateTimeField;
        return this;
    }

    public void setZonedDateTimeField(ZonedDateTime zonedDateTimeField) {
        this.zonedDateTimeField = zonedDateTimeField;
    }

    public ZonedDateTime getZonedDateTimeRequiredField() {
        return this.zonedDateTimeRequiredField;
    }

    public CassTestServiceImplEntity zonedDateTimeRequiredField(ZonedDateTime zonedDateTimeRequiredField) {
        this.zonedDateTimeRequiredField = zonedDateTimeRequiredField;
        return this;
    }

    public void setZonedDateTimeRequiredField(ZonedDateTime zonedDateTimeRequiredField) {
        this.zonedDateTimeRequiredField = zonedDateTimeRequiredField;
    }

    public Duration getDurationDateField() {
        return this.durationDateField;
    }

    public CassTestServiceImplEntity durationDateField(Duration durationDateField) {
        this.durationDateField = durationDateField;
        return this;
    }

    public void setDurationDateField(Duration durationDateField) {
        this.durationDateField = durationDateField;
    }

    public Duration getDurationRequiredField() {
        return this.durationRequiredField;
    }

    public CassTestServiceImplEntity durationRequiredField(Duration durationRequiredField) {
        this.durationRequiredField = durationRequiredField;
        return this;
    }

    public void setDurationRequiredField(Duration durationRequiredField) {
        this.durationRequiredField = durationRequiredField;
    }

    public Boolean getBooleanField() {
        return this.booleanField;
    }

    public CassTestServiceImplEntity booleanField(Boolean booleanField) {
        this.booleanField = booleanField;
        return this;
    }

    public void setBooleanField(Boolean booleanField) {
        this.booleanField = booleanField;
    }

    public Boolean getBooleanRequiredField() {
        return this.booleanRequiredField;
    }

    public CassTestServiceImplEntity booleanRequiredField(Boolean booleanRequiredField) {
        this.booleanRequiredField = booleanRequiredField;
        return this;
    }

    public void setBooleanRequiredField(Boolean booleanRequiredField) {
        this.booleanRequiredField = booleanRequiredField;
    }

    public EnumFieldClass getEnumTom() {
        return this.enumTom;
    }

    public CassTestServiceImplEntity enumTom(EnumFieldClass enumTom) {
        this.enumTom = enumTom;
        return this;
    }

    public void setEnumTom(EnumFieldClass enumTom) {
        this.enumTom = enumTom;
    }

    public EnumRequiredFieldClass getEnumRequiredTom() {
        return this.enumRequiredTom;
    }

    public CassTestServiceImplEntity enumRequiredTom(EnumRequiredFieldClass enumRequiredTom) {
        this.enumRequiredTom = enumRequiredTom;
        return this;
    }

    public void setEnumRequiredTom(EnumRequiredFieldClass enumRequiredTom) {
        this.enumRequiredTom = enumRequiredTom;
    }

    public ByteBuffer getPicture() {
        return this.picture;
    }

    public CassTestServiceImplEntity picture(ByteBuffer picture) {
        this.picture = picture;
        return this;
    }

    public void setPicture(ByteBuffer picture) {
        this.picture = picture;
    }

    public String getPictureContentType() {
        return this.pictureContentType;
    }

    public CassTestServiceImplEntity pictureContentType(String pictureContentType) {
        this.pictureContentType = pictureContentType;
        return this;
    }

    public void setPictureContentType(String pictureContentType) {
        this.pictureContentType = pictureContentType;
    }

    public ByteBuffer getOperationsFile() {
        return this.operationsFile;
    }

    public CassTestServiceImplEntity operationsFile(ByteBuffer operationsFile) {
        this.operationsFile = operationsFile;
        return this;
    }

    public void setOperationsFile(ByteBuffer operationsFile) {
        this.operationsFile = operationsFile;
    }

    public String getOperationsFileContentType() {
        return this.operationsFileContentType;
    }

    public CassTestServiceImplEntity operationsFileContentType(String operationsFileContentType) {
        this.operationsFileContentType = operationsFileContentType;
        return this;
    }

    public void setOperationsFileContentType(String operationsFileContentType) {
        this.operationsFileContentType = operationsFileContentType;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CassTestServiceImplEntity)) {
            return false;
        }
        return id != null && id.equals(((CassTestServiceImplEntity) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CassTestServiceImplEntity{" +
            "id=" + getId() +
            ", stringField='" + getStringField() + "'" +
            ", stringRequiredField='" + getStringRequiredField() + "'" +
            ", stringMinlengthField='" + getStringMinlengthField() + "'" +
            ", stringMaxlengthField='" + getStringMaxlengthField() + "'" +
            ", stringPatternField='" + getStringPatternField() + "'" +
            ", integerField=" + getIntegerField() +
            ", integerRequiredField=" + getIntegerRequiredField() +
            ", integerMinField=" + getIntegerMinField() +
            ", integerMaxField=" + getIntegerMaxField() +
            ", longField=" + getLongField() +
            ", longRequiredField=" + getLongRequiredField() +
            ", longMinField=" + getLongMinField() +
            ", longMaxField=" + getLongMaxField() +
            ", floatField=" + getFloatField() +
            ", floatRequiredField=" + getFloatRequiredField() +
            ", floatMinField=" + getFloatMinField() +
            ", floatMaxField=" + getFloatMaxField() +
            ", doubleRequiredField=" + getDoubleRequiredField() +
            ", doubleMinField=" + getDoubleMinField() +
            ", doubleMaxField=" + getDoubleMaxField() +
            ", bigDecimalRequiredField=" + getBigDecimalRequiredField() +
            ", bigDecimalMinField=" + getBigDecimalMinField() +
            ", bigDecimalMaxField=" + getBigDecimalMaxField() +
            ", localDateField='" + getLocalDateField() + "'" +
            ", localDateRequiredField='" + getLocalDateRequiredField() + "'" +
            ", instantDateField='" + getInstantDateField() + "'" +
            ", instantRequiredField='" + getInstantRequiredField() + "'" +
            ", zonedDateTimeField='" + getZonedDateTimeField() + "'" +
            ", zonedDateTimeRequiredField='" + getZonedDateTimeRequiredField() + "'" +
            ", durationDateField='" + getDurationDateField() + "'" +
            ", durationRequiredField='" + getDurationRequiredField() + "'" +
            ", booleanField='" + getBooleanField() + "'" +
            ", booleanRequiredField='" + getBooleanRequiredField() + "'" +
            ", enumTom='" + getEnumTom() + "'" +
            ", enumRequiredTom='" + getEnumRequiredTom() + "'" +
            ", picture='" + getPicture() + "'" +
            ", pictureContentType='" + getPictureContentType() + "'" +
            ", operationsFile='" + getOperationsFile() + "'" +
            ", operationsFileContentType='" + getOperationsFileContentType() + "'" +
            "}";
    }
}
