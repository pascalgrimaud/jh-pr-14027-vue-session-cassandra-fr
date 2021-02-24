package tech.jhipster.sample.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.validation.constraints.*;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;

/**
 * A DTO for the {@link tech.jhipster.sample.domain.CassTestMapstructEntity} entity.
 */
public class CassTestMapstructEntityDTO implements Serializable {

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

    private String pictureContentType;
    private ByteBuffer operationsFile;

    private String operationsFileContentType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public String getStringRequiredField() {
        return stringRequiredField;
    }

    public void setStringRequiredField(String stringRequiredField) {
        this.stringRequiredField = stringRequiredField;
    }

    public String getStringMinlengthField() {
        return stringMinlengthField;
    }

    public void setStringMinlengthField(String stringMinlengthField) {
        this.stringMinlengthField = stringMinlengthField;
    }

    public String getStringMaxlengthField() {
        return stringMaxlengthField;
    }

    public void setStringMaxlengthField(String stringMaxlengthField) {
        this.stringMaxlengthField = stringMaxlengthField;
    }

    public String getStringPatternField() {
        return stringPatternField;
    }

    public void setStringPatternField(String stringPatternField) {
        this.stringPatternField = stringPatternField;
    }

    public Integer getIntegerField() {
        return integerField;
    }

    public void setIntegerField(Integer integerField) {
        this.integerField = integerField;
    }

    public Integer getIntegerRequiredField() {
        return integerRequiredField;
    }

    public void setIntegerRequiredField(Integer integerRequiredField) {
        this.integerRequiredField = integerRequiredField;
    }

    public Integer getIntegerMinField() {
        return integerMinField;
    }

    public void setIntegerMinField(Integer integerMinField) {
        this.integerMinField = integerMinField;
    }

    public Integer getIntegerMaxField() {
        return integerMaxField;
    }

    public void setIntegerMaxField(Integer integerMaxField) {
        this.integerMaxField = integerMaxField;
    }

    public Long getLongField() {
        return longField;
    }

    public void setLongField(Long longField) {
        this.longField = longField;
    }

    public Long getLongRequiredField() {
        return longRequiredField;
    }

    public void setLongRequiredField(Long longRequiredField) {
        this.longRequiredField = longRequiredField;
    }

    public Long getLongMinField() {
        return longMinField;
    }

    public void setLongMinField(Long longMinField) {
        this.longMinField = longMinField;
    }

    public Long getLongMaxField() {
        return longMaxField;
    }

    public void setLongMaxField(Long longMaxField) {
        this.longMaxField = longMaxField;
    }

    public Float getFloatField() {
        return floatField;
    }

    public void setFloatField(Float floatField) {
        this.floatField = floatField;
    }

    public Float getFloatRequiredField() {
        return floatRequiredField;
    }

    public void setFloatRequiredField(Float floatRequiredField) {
        this.floatRequiredField = floatRequiredField;
    }

    public Float getFloatMinField() {
        return floatMinField;
    }

    public void setFloatMinField(Float floatMinField) {
        this.floatMinField = floatMinField;
    }

    public Float getFloatMaxField() {
        return floatMaxField;
    }

    public void setFloatMaxField(Float floatMaxField) {
        this.floatMaxField = floatMaxField;
    }

    public Double getDoubleRequiredField() {
        return doubleRequiredField;
    }

    public void setDoubleRequiredField(Double doubleRequiredField) {
        this.doubleRequiredField = doubleRequiredField;
    }

    public Double getDoubleMinField() {
        return doubleMinField;
    }

    public void setDoubleMinField(Double doubleMinField) {
        this.doubleMinField = doubleMinField;
    }

    public Double getDoubleMaxField() {
        return doubleMaxField;
    }

    public void setDoubleMaxField(Double doubleMaxField) {
        this.doubleMaxField = doubleMaxField;
    }

    public BigDecimal getBigDecimalRequiredField() {
        return bigDecimalRequiredField;
    }

    public void setBigDecimalRequiredField(BigDecimal bigDecimalRequiredField) {
        this.bigDecimalRequiredField = bigDecimalRequiredField;
    }

    public BigDecimal getBigDecimalMinField() {
        return bigDecimalMinField;
    }

    public void setBigDecimalMinField(BigDecimal bigDecimalMinField) {
        this.bigDecimalMinField = bigDecimalMinField;
    }

    public BigDecimal getBigDecimalMaxField() {
        return bigDecimalMaxField;
    }

    public void setBigDecimalMaxField(BigDecimal bigDecimalMaxField) {
        this.bigDecimalMaxField = bigDecimalMaxField;
    }

    public LocalDate getLocalDateField() {
        return localDateField;
    }

    public void setLocalDateField(LocalDate localDateField) {
        this.localDateField = localDateField;
    }

    public LocalDate getLocalDateRequiredField() {
        return localDateRequiredField;
    }

    public void setLocalDateRequiredField(LocalDate localDateRequiredField) {
        this.localDateRequiredField = localDateRequiredField;
    }

    public Instant getInstantDateField() {
        return instantDateField;
    }

    public void setInstantDateField(Instant instantDateField) {
        this.instantDateField = instantDateField;
    }

    public Instant getInstantRequiredField() {
        return instantRequiredField;
    }

    public void setInstantRequiredField(Instant instantRequiredField) {
        this.instantRequiredField = instantRequiredField;
    }

    public ZonedDateTime getZonedDateTimeField() {
        return zonedDateTimeField;
    }

    public void setZonedDateTimeField(ZonedDateTime zonedDateTimeField) {
        this.zonedDateTimeField = zonedDateTimeField;
    }

    public ZonedDateTime getZonedDateTimeRequiredField() {
        return zonedDateTimeRequiredField;
    }

    public void setZonedDateTimeRequiredField(ZonedDateTime zonedDateTimeRequiredField) {
        this.zonedDateTimeRequiredField = zonedDateTimeRequiredField;
    }

    public Duration getDurationDateField() {
        return durationDateField;
    }

    public void setDurationDateField(Duration durationDateField) {
        this.durationDateField = durationDateField;
    }

    public Duration getDurationRequiredField() {
        return durationRequiredField;
    }

    public void setDurationRequiredField(Duration durationRequiredField) {
        this.durationRequiredField = durationRequiredField;
    }

    public Boolean getBooleanField() {
        return booleanField;
    }

    public void setBooleanField(Boolean booleanField) {
        this.booleanField = booleanField;
    }

    public Boolean getBooleanRequiredField() {
        return booleanRequiredField;
    }

    public void setBooleanRequiredField(Boolean booleanRequiredField) {
        this.booleanRequiredField = booleanRequiredField;
    }

    public EnumFieldClass getEnumTom() {
        return enumTom;
    }

    public void setEnumTom(EnumFieldClass enumTom) {
        this.enumTom = enumTom;
    }

    public EnumRequiredFieldClass getEnumRequiredTom() {
        return enumRequiredTom;
    }

    public void setEnumRequiredTom(EnumRequiredFieldClass enumRequiredTom) {
        this.enumRequiredTom = enumRequiredTom;
    }

    public ByteBuffer getPicture() {
        return picture;
    }

    public void setPicture(ByteBuffer picture) {
        this.picture = picture;
    }

    public String getPictureContentType() {
        return pictureContentType;
    }

    public void setPictureContentType(String pictureContentType) {
        this.pictureContentType = pictureContentType;
    }

    public ByteBuffer getOperationsFile() {
        return operationsFile;
    }

    public void setOperationsFile(ByteBuffer operationsFile) {
        this.operationsFile = operationsFile;
    }

    public String getOperationsFileContentType() {
        return operationsFileContentType;
    }

    public void setOperationsFileContentType(String operationsFileContentType) {
        this.operationsFileContentType = operationsFileContentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CassTestMapstructEntityDTO)) {
            return false;
        }

        CassTestMapstructEntityDTO cassTestMapstructEntityDTO = (CassTestMapstructEntityDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cassTestMapstructEntityDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CassTestMapstructEntityDTO{" +
            "id='" + getId() + "'" +
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
            ", operationsFile='" + getOperationsFile() + "'" +
            "}";
    }
}
