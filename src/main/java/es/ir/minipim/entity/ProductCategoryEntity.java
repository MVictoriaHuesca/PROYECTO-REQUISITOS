package es.ir.minipim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "product_category", schema = "grupo05DB", catalog = "")
@jakarta.persistence.IdClass(es.ir.minipim.entity.ProductCategoryEntityPK.class)
public class ProductCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "category_id_fk", nullable = false)
    private Integer categoryIdFk;

    public Integer getCategoryIdFk() {
        return categoryIdFk;
    }

    public void setCategoryIdFk(Integer categoryIdFk) {
        this.categoryIdFk = categoryIdFk;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "product_id_fk", nullable = false)
    private Integer productIdFk;

    public Integer getProductIdFk() {
        return productIdFk;
    }

    public void setProductIdFk(Integer productIdFk) {
        this.productIdFk = productIdFk;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoryEntity that = (ProductCategoryEntity) o;
        return Objects.equals(categoryIdFk, that.categoryIdFk) && Objects.equals(productIdFk, that.productIdFk) && Objects.equals(accountIdFk, that.accountIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryIdFk, productIdFk, accountIdFk);
    }
}
