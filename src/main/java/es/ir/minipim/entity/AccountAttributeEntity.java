package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "account_attribute", schema = "grupo05DB", catalog = "")
@IdClass(AccountAttributeEntityPK.class)
public class AccountAttributeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "attribute_id_fk", nullable = false)
    private Integer attributeIdFk;
    @ManyToOne
    @JoinColumn(name = "account_id_fk", referencedColumnName = "account_id", nullable = false)
    private AccountEntity accountByAccountIdFk;
    @ManyToOne
    @JoinColumn(name = "attribute_id_fk", referencedColumnName = "attribute_id", nullable = false)
    private AttributeEntity attributeByAttributeIdFk;

    public Integer getAccountIdFk() {
        return accountIdFk;
    }

    public void setAccountIdFk(Integer accountIdFk) {
        this.accountIdFk = accountIdFk;
    }

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

    public AccountEntity getAccountByAccountIdFk() {
        return accountByAccountIdFk;
    }

    public void setAccountByAccountIdFk(AccountEntity accountByAccountIdFk) {
        this.accountByAccountIdFk = accountByAccountIdFk;
    }

    public AttributeEntity getAttributeByAttributeIdFk() {
        return attributeByAttributeIdFk;
    }

    public void setAttributeByAttributeIdFk(AttributeEntity attributeByAttributeIdFk) {
        this.attributeByAttributeIdFk = attributeByAttributeIdFk;
    }
}
