package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_categories", schema = "grupo05DB", catalog = "")
@IdClass(ProductCategoriesEntityPK.class)
public class ProductCategoriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id_fk", nullable = false)
    private Integer categoryIdFk;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id_fk", nullable = false)
    private Integer productIdFk;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;
    @ManyToOne
    @JoinColumn(name = "category_id_fk", referencedColumnName = "category_id", nullable = false)
    private CategoriesEntity categoriesByCategoryIdFk;
    @ManyToOne
    @JoinColumn(name = "product_id_fk", referencedColumnName = "product_id", nullable = false)
    private ProductsEntity productsByProductIdFk;
    @ManyToOne
    @JoinColumn(name = "account_id_fk", referencedColumnName = "account_id", nullable = false)
    private AccountsEntity accountsByAccountIdFk;

    public Integer getCategoryIdFk() {
        return categoryIdFk;
    }

    public void setCategoryIdFk(Integer categoryIdFk) {
        this.categoryIdFk = categoryIdFk;
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
        ProductCategoriesEntity that = (ProductCategoriesEntity) o;
        return Objects.equals(categoryIdFk, that.categoryIdFk) && Objects.equals(productIdFk, that.productIdFk) && Objects.equals(accountIdFk, that.accountIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryIdFk, productIdFk, accountIdFk);
    }

    public CategoriesEntity getCategoriesByCategoryIdFk() {
        return categoriesByCategoryIdFk;
    }

    public void setCategoriesByCategoryIdFk(CategoriesEntity categoriesByCategoryIdFk) {
        this.categoriesByCategoryIdFk = categoriesByCategoryIdFk;
    }

    public ProductsEntity getProductsByProductIdFk() {
        return productsByProductIdFk;
    }

    public void setProductsByProductIdFk(ProductsEntity productsByProductIdFk) {
        this.productsByProductIdFk = productsByProductIdFk;
    }

    public AccountsEntity getAccountsByAccountIdFk() {
        return accountsByAccountIdFk;
    }

    public void setAccountsByAccountIdFk(AccountsEntity accountsByAccountIdFk) {
        this.accountsByAccountIdFk = accountsByAccountIdFk;
    }
}
