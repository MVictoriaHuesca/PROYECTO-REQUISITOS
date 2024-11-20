package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_attribute", schema = "grupo05DB", catalog = "")
@IdClass(ProductAttributeEntityPK.class)
public class ProductAttributeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "attribute_id_fk", nullable = false)
    private Integer attributeIdFk;

    public Integer getAttributeIdFk() {
        return attributeIdFk;
    }

    public void setAttributeIdFk(Integer attributeIdFk) {
        this.attributeIdFk = attributeIdFk;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id_fk", nullable = false)
    private Integer productIdFk;

    public Integer getProductIdFk() {
        return productIdFk;
    }

    public void setProductIdFk(Integer productIdFk) {
        this.productIdFk = productIdFk;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;

    public Integer getAccountIdFk() {
        return accountIdFk;
    }

    public void setAccountIdFk(Integer accountIdFk) {
        this.accountIdFk = accountIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAttributeEntity that = (ProductAttributeEntity) o;
        return Objects.equals(attributeIdFk, that.attributeIdFk) && Objects.equals(productIdFk, that.productIdFk) && Objects.equals(accountIdFk, that.accountIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeIdFk, productIdFk, accountIdFk);
    }
}
