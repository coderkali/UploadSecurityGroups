package com.gm.asm.response.userid;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Properties{
    @JsonProperty("SchemaClassName")
    public SchemaClassName schemaClassName;
    @JsonProperty("Description") 
    public Description description;
    @JsonProperty("Domain") 
    public Domain domain;
    @JsonProperty("Account") 
    public Account account;
    @JsonProperty("DN") 
    public DN dN;
    @JsonProperty("Mail") 
    public Mail mail;
    @JsonProperty("SpecialType") 
    public SpecialType specialType;
    @JsonProperty("ComplianceValidated") 
    public ComplianceValidated complianceValidated;
    @JsonProperty("DirectoryAlias") 
    public DirectoryAlias directoryAlias;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Properties)) return false;
        Properties that = (Properties) o;
        return getSchemaClassName().equals(that.getSchemaClassName()) && getDescription().equals(that.getDescription()) && getDomain().equals(that.getDomain()) && getAccount().equals(that.getAccount()) && getdN().equals(that.getdN()) && getMail().equals(that.getMail()) && getSpecialType().equals(that.getSpecialType()) && getComplianceValidated().equals(that.getComplianceValidated()) && getDirectoryAlias().equals(that.getDirectoryAlias());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSchemaClassName(), getDescription(), getDomain(), getAccount(), getdN(), getMail(), getSpecialType(), getComplianceValidated(), getDirectoryAlias());
    }

    public SchemaClassName getSchemaClassName() {
        return schemaClassName;
    }

    public void setSchemaClassName(SchemaClassName schemaClassName) {
        this.schemaClassName = schemaClassName;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public DN getdN() {
        return dN;
    }

    public void setdN(DN dN) {
        this.dN = dN;
    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

    public SpecialType getSpecialType() {
        return specialType;
    }

    public void setSpecialType(SpecialType specialType) {
        this.specialType = specialType;
    }

    public ComplianceValidated getComplianceValidated() {
        return complianceValidated;
    }

    public void setComplianceValidated(ComplianceValidated complianceValidated) {
        this.complianceValidated = complianceValidated;
    }

    public DirectoryAlias getDirectoryAlias() {
        return directoryAlias;
    }

    public void setDirectoryAlias(DirectoryAlias directoryAlias) {
        this.directoryAlias = directoryAlias;
    }
}