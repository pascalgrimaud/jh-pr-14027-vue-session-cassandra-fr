package tech.jhipster.sample.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import javax.validation.constraints.*;
import tech.jhipster.sample.domain.enumeration.AccountTypeEnum;

/**
 * A DTO for the {@link tech.jhipster.sample.domain.CassBankAccount} entity.
 */
public class CassBankAccountDTO implements Serializable {

    private UUID id;

    private UUID userId;

    @NotNull
    private String name;

    private Integer bankNumber;

    private Long agencyNumber;

    private Float lastOperationDuration;

    private Double meanOperationDuration;

    @NotNull
    private BigDecimal balance;

    private Instant lastOperationDate;

    private Boolean active;

    private ByteBuffer picture;

    private String pictureContentType;
    private ByteBuffer operationsFile;

    private String operationsFileContentType;
    private AccountTypeEnum accountType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(Integer bankNumber) {
        this.bankNumber = bankNumber;
    }

    public Long getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(Long agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public Float getLastOperationDuration() {
        return lastOperationDuration;
    }

    public void setLastOperationDuration(Float lastOperationDuration) {
        this.lastOperationDuration = lastOperationDuration;
    }

    public Double getMeanOperationDuration() {
        return meanOperationDuration;
    }

    public void setMeanOperationDuration(Double meanOperationDuration) {
        this.meanOperationDuration = meanOperationDuration;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Instant getLastOperationDate() {
        return lastOperationDate;
    }

    public void setLastOperationDate(Instant lastOperationDate) {
        this.lastOperationDate = lastOperationDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public AccountTypeEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CassBankAccountDTO)) {
            return false;
        }

        CassBankAccountDTO cassBankAccountDTO = (CassBankAccountDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cassBankAccountDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CassBankAccountDTO{" +
            "id='" + getId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", name='" + getName() + "'" +
            ", bankNumber=" + getBankNumber() +
            ", agencyNumber=" + getAgencyNumber() +
            ", lastOperationDuration=" + getLastOperationDuration() +
            ", meanOperationDuration=" + getMeanOperationDuration() +
            ", balance=" + getBalance() +
            ", lastOperationDate='" + getLastOperationDate() + "'" +
            ", active='" + getActive() + "'" +
            ", picture='" + getPicture() + "'" +
            ", operationsFile='" + getOperationsFile() + "'" +
            ", accountType='" + getAccountType() + "'" +
            "}";
    }
}
