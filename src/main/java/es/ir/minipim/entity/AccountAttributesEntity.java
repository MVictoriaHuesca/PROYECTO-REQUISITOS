package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "account_attributes", schema = "grupo05DB", catalog = "")
@IdClass(AccountAttributesEntityPK.class)
public class AccountAttributesEntity {
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
    private AccountsEntity accountsByAccountIdFk;
    @ManyToOne
    @JoinColumn(name = "attribute_id_fk", referencedColumnName = "attribute_id", nullable = false)
    private AttributesEntity attributesByAttributeIdFk;

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
        AccountAttributesEntity that = (AccountAttributesEntity) o;
        return Objects.equals(accountIdFk, that.accountIdFk) && Objects.equals(attributeIdFk, that.attributeIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, attributeIdFk);
    }

    public AccountsEntity getAccountsByAccountIdFk() {
        return accountsByAccountIdFk;
    }

    public void setAccountsByAccountIdFk(AccountsEntity accountsByAccountIdFk) {
        this.accountsByAccountIdFk = accountsByAccountIdFk;
    }

    public AttributesEntity getAttributesByAttributeIdFk() {
        return attributesByAttributeIdFk;
    }

    public void setAttributesByAttributeIdFk(AttributesEntity attributesByAttributeIdFk) {
        this.attributesByAttributeIdFk = attributesByAttributeIdFk;
    }
}
