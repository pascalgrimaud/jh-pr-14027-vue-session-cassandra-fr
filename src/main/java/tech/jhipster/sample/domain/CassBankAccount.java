package tech.jhipster.sample.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.UUID;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;
import tech.jhipster.sample.domain.enumeration.AccountTypeEnum;

/**
 * A CassBankAccount.
 */
@Table("cassBankAccount")
public class CassBankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
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

    @Column("picture_content_type")
    private String pictureContentType;

    private ByteBuffer operationsFile;

    @Column("operations_file_content_type")
    private String operationsFileContentType;

    private AccountTypeEnum accountType;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CassBankAccount id(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public CassBankAccount userId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public CassBankAccount name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBankNumber() {
        return this.bankNumber;
    }

    public CassBankAccount bankNumber(Integer bankNumber) {
        this.bankNumber = bankNumber;
        return this;
    }

    public void setBankNumber(Integer bankNumber) {
        this.bankNumber = bankNumber;
    }

    public Long getAgencyNumber() {
        return this.agencyNumber;
    }

    public CassBankAccount agencyNumber(Long agencyNumber) {
        this.agencyNumber = agencyNumber;
        return this;
    }

    public void setAgencyNumber(Long agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public Float getLastOperationDuration() {
        return this.lastOperationDuration;
    }

    public CassBankAccount lastOperationDuration(Float lastOperationDuration) {
        this.lastOperationDuration = lastOperationDuration;
        return this;
    }

    public void setLastOperationDuration(Float lastOperationDuration) {
        this.lastOperationDuration = lastOperationDuration;
    }

    public Double getMeanOperationDuration() {
        return this.meanOperationDuration;
    }

    public CassBankAccount meanOperationDuration(Double meanOperationDuration) {
        this.meanOperationDuration = meanOperationDuration;
        return this;
    }

    public void setMeanOperationDuration(Double meanOperationDuration) {
        this.meanOperationDuration = meanOperationDuration;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public CassBankAccount balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Instant getLastOperationDate() {
        return this.lastOperationDate;
    }

    public CassBankAccount lastOperationDate(Instant lastOperationDate) {
        this.lastOperationDate = lastOperationDate;
        return this;
    }

    public void setLastOperationDate(Instant lastOperationDate) {
        this.lastOperationDate = lastOperationDate;
    }

    public Boolean getActive() {
        return this.active;
    }

    public CassBankAccount active(Boolean active) {
        this.active = active;
        return this;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ByteBuffer getPicture() {
        return this.picture;
    }

    public CassBankAccount picture(ByteBuffer picture) {
        this.picture = picture;
        return this;
    }

    public void setPicture(ByteBuffer picture) {
        this.picture = picture;
    }

    public String getPictureContentType() {
        return this.pictureContentType;
    }

    public CassBankAccount pictureContentType(String pictureContentType) {
        this.pictureContentType = pictureContentType;
        return this;
    }

    public void setPictureContentType(String pictureContentType) {
        this.pictureContentType = pictureContentType;
    }

    public ByteBuffer getOperationsFile() {
        return this.operationsFile;
    }

    public CassBankAccount operationsFile(ByteBuffer operationsFile) {
        this.operationsFile = operationsFile;
        return this;
    }

    public void setOperationsFile(ByteBuffer operationsFile) {
        this.operationsFile = operationsFile;
    }

    public String getOperationsFileContentType() {
        return this.operationsFileContentType;
    }

    public CassBankAccount operationsFileContentType(String operationsFileContentType) {
        this.operationsFileContentType = operationsFileContentType;
        return this;
    }

    public void setOperationsFileContentType(String operationsFileContentType) {
        this.operationsFileContentType = operationsFileContentType;
    }

    public AccountTypeEnum getAccountType() {
        return this.accountType;
    }

    public CassBankAccount accountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
        return this;
    }

    public void setAccountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CassBankAccount)) {
            return false;
        }
        return id != null && id.equals(((CassBankAccount) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CassBankAccount{" +
            "id=" + getId() +
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
            ", pictureContentType='" + getPictureContentType() + "'" +
            ", operationsFile='" + getOperationsFile() + "'" +
            ", operationsFileContentType='" + getOperationsFileContentType() + "'" +
            ", accountType='" + getAccountType() + "'" +
            "}";
    }
}
