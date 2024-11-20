package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@Table(name = "attribute", schema = "grupo05DB", catalog = "")
public class AttributeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "attribute_id", nullable = false)
    private Integer attributeId;
    @Basic
    @Column(name = "attribute_name", nullable = false, length = 50)
    private String attributeName;
    @Enumerated(EnumType.STRING)
    @Column(name = "attribute_type", nullable = false)
    private AttributeType attributeType;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @OneToMany(mappedBy = "attributeByAttributeIdFk")
    private Collection<AccountAttributeEntity> accountAttributesByAttributeId;
    @ManyToOne
    @JoinColumn(name = "account_id_fk", referencedColumnName = "account_id", nullable = false)
    private AccountEntity accountByAccountIdFk;
    @OneToMany(mappedBy = "attributeByAttributeIdFk")
    private Collection<ProductAttributeEntity> productAttributesByAttributeId;

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeEntity that = (AttributeEntity) o;
        return Objects.equals(attributeId, that.attributeId) && Objects.equals(attributeName, that.attributeName) && Objects.equals(attributeType, that.attributeType) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeId, attributeName, attributeType, createdAt);
    }

    public Collection<AccountAttributeEntity> getAccountAttributesByAttributeId() {
        return accountAttributesByAttributeId;
    }

    public void setAccountAttributesByAttributeId(Collection<AccountAttributeEntity> accountAttributesByAttributeId) {
        this.accountAttributesByAttributeId = accountAttributesByAttributeId;
    }

    public AccountEntity getAccountByAccountIdFk() {
        return accountByAccountIdFk;
    }

    public void setAccountByAccountIdFk(AccountEntity accountByAccountIdFk) {
        this.accountByAccountIdFk = accountByAccountIdFk;
    }

    public Collection<ProductAttributeEntity> getProductAttributesByAttributeId() {
        return productAttributesByAttributeId;
    }

    public void setProductAttributesByAttributeId(Collection<ProductAttributeEntity> productAttributesByAttributeId) {
        this.productAttributesByAttributeId = productAttributesByAttributeId;
    }
}
