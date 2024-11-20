package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "grupo05DB", catalog = "")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;
    @Basic
    @Column(name = "category_name", nullable = false, length = 50)
    private String categoryName;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @OneToMany(mappedBy = "categoryByCategoryIdFk")
    private Collection<AccountCategoryEntity> accountCategoriesByCategoryId;
    @ManyToOne
    @JoinColumn(name = "account_id_fk", referencedColumnName = "account_id", nullable = false)
    private AccountEntity accountByAccountIdFk;
    @OneToMany(mappedBy = "categoryByCategoryIdFk")
    private Collection<ProductCategoryEntity> productCategoriesByCategoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(categoryId, that.categoryId) && Objects.equals(categoryName, that.categoryName) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, createdAt);
    }

    public Collection<AccountCategoryEntity> getAccountCategoriesByCategoryId() {
        return accountCategoriesByCategoryId;
    }

    public void setAccountCategoriesByCategoryId(Collection<AccountCategoryEntity> accountCategoriesByCategoryId) {
        this.accountCategoriesByCategoryId = accountCategoriesByCategoryId;
    }

    public AccountEntity getAccountByAccountIdFk() {
        return accountByAccountIdFk;
    }

    public void setAccountByAccountIdFk(AccountEntity accountByAccountIdFk) {
        this.accountByAccountIdFk = accountByAccountIdFk;
    }

    public Collection<ProductCategoryEntity> getProductCategoriesByCategoryId() {
        return productCategoriesByCategoryId;
    }

    public void setProductCategoriesByCategoryId(Collection<ProductCategoryEntity> productCategoriesByCategoryId) {
        this.productCategoriesByCategoryId = productCategoriesByCategoryId;
    }
}
