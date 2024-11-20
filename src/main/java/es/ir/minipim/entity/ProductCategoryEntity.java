package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_category", schema = "grupo05DB", catalog = "")
@IdClass(ProductCategoryEntityPK.class)
public class ProductCategoryEntity {
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
    private CategoryEntity categoryByCategoryIdFk;
    @ManyToOne
    @JoinColumn(name = "product_id_fk", referencedColumnName = "product_id", nullable = false)
    private ProductEntity productByProductIdFk;
    @ManyToOne
    @JoinColumn(name = "account_id_fk", referencedColumnName = "account_id", nullable = false)
    private AccountEntity accountByAccountIdFk;

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
        ProductCategoryEntity that = (ProductCategoryEntity) o;
        return Objects.equals(categoryIdFk, that.categoryIdFk) && Objects.equals(productIdFk, that.productIdFk) && Objects.equals(accountIdFk, that.accountIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryIdFk, productIdFk, accountIdFk);
    }

    public CategoryEntity getCategoryByCategoryIdFk() {
        return categoryByCategoryIdFk;
    }

    public void setCategoryByCategoryIdFk(CategoryEntity categoryByCategoryIdFk) {
        this.categoryByCategoryIdFk = categoryByCategoryIdFk;
    }

    public ProductEntity getProductByProductIdFk() {
        return productByProductIdFk;
    }

    public void setProductByProductIdFk(ProductEntity productByProductIdFk) {
        this.productByProductIdFk = productByProductIdFk;
    }

    public AccountEntity getAccountByAccountIdFk() {
        return accountByAccountIdFk;
    }

    public void setAccountByAccountIdFk(AccountEntity accountByAccountIdFk) {
        this.accountByAccountIdFk = accountByAccountIdFk;
    }
}
