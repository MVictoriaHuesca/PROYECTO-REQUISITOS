package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "attributes", schema = "grupo05DB", catalog = "")
public class AttributesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "attribute_id", nullable = false)
    private Integer attributeId;
    @Basic
    @Column(name = "attribute_name", nullable = false, length = 50)
    private String attributeName;
    @Basic
    @Column(name = "attribute_type", nullable = false, length = 50)
    private String attributeType;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @OneToMany(mappedBy = "attributesByAttributeIdFk")
    private Collection<AccountAttributesEntity> accountAttributesByAttributeId;
    @ManyToOne
    @JoinColumn(name = "account_id_fk", referencedColumnName = "account_id", nullable = false)
    private AccountsEntity accountsByAccountIdFk;
    @OneToMany(mappedBy = "attributesByAttributeIdFk")
    private Collection<ProductAttributesEntity> productAttributesByAttributeId;

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

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
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
        AttributesEntity that = (AttributesEntity) o;
        return Objects.equals(attributeId, that.attributeId) && Objects.equals(attributeName, that.attributeName) && Objects.equals(attributeType, that.attributeType) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeId, attributeName, attributeType, createdAt);
    }

    public Collection<AccountAttributesEntity> getAccountAttributesByAttributeId() {
        return accountAttributesByAttributeId;
    }

    public void setAccountAttributesByAttributeId(Collection<AccountAttributesEntity> accountAttributesByAttributeId) {
        this.accountAttributesByAttributeId = accountAttributesByAttributeId;
    }

    public AccountsEntity getAccountsByAccountIdFk() {
        return accountsByAccountIdFk;
    }

    public void setAccountsByAccountIdFk(AccountsEntity accountsByAccountIdFk) {
        this.accountsByAccountIdFk = accountsByAccountIdFk;
    }

    public Collection<ProductAttributesEntity> getProductAttributesByAttributeId() {
        return productAttributesByAttributeId;
    }

    public void setProductAttributesByAttributeId(Collection<ProductAttributesEntity> productAttributesByAttributeId) {
        this.productAttributesByAttributeId = productAttributesByAttributeId;
    }
}
