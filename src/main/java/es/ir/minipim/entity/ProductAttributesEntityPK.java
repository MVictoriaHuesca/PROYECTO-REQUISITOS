package es.ir.minipim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class ProductAttributesEntityPK implements Serializable {
    @Column(name = "attribute_id_fk", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attributeIdFk;
    @Column(name = "product_id_fk", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productIdFk;
    @Column(name = "account_id_fk", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountIdFk;

    public Integer getAttributeIdFk() {
        return attributeIdFk;
    }

    public void setAttributeIdFk(Integer attributeIdFk) {
        this.attributeIdFk = attributeIdFk;
    }

    public Integer getProductIdFk() {
        return productIdFk;
    }

    public void setProductIdFk(Integer productIdFk) {
        this.productIdFk = productIdFk;
    }

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
        ProductAttributesEntityPK that = (ProductAttributesEntityPK) o;
        return Objects.equals(attributeIdFk, that.attributeIdFk) && Objects.equals(productIdFk, that.productIdFk) && Objects.equals(accountIdFk, that.accountIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeIdFk, productIdFk, accountIdFk);
    }
}
