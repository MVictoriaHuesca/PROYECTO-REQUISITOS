package es.ir.minipim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "account_attribute", schema = "grupo05DB", catalog = "")
@jakarta.persistence.IdClass(es.ir.minipim.entity.AccountAttributeEntityPK.class)
public class AccountAttributeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;

    public Integer getAccountIdFk() {
        return accountIdFk;
    }

    public void setAccountIdFk(Integer accountIdFk) {
        this.accountIdFk = accountIdFk;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "attribute_id_fk", nullable = false)
    private Integer attributeIdFk;

    public Integer getAttributeIdFk() {
        return attributeIdFk;
    }

    public void setAttributeIdFk(Integer attributeIdFk) {
        this.attributeIdFk = attributeIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountAttributeEntity that = (AccountAttributeEntity) o;
        return Objects.equals(accountIdFk, that.accountIdFk) && Objects.equals(attributeIdFk, that.attributeIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, attributeIdFk);
    }
}
