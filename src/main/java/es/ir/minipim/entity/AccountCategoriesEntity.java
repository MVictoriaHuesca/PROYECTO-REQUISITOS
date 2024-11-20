package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "account_categories", schema = "grupo05DB", catalog = "")
@IdClass(AccountCategoriesEntityPK.class)
public class AccountCategoriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id_fk", nullable = false)
    private Integer categoryIdFk;
    @ManyToOne
    @JoinColumn(name = "account_id_fk", referencedColumnName = "account_id", nullable = false)
    private AccountsEntity accountsByAccountIdFk;
    @ManyToOne
    @JoinColumn(name = "category_id_fk", referencedColumnName = "category_id", nullable = false)
    private CategoriesEntity categoriesByCategoryIdFk;

    public Integer getAccountIdFk() {
        return accountIdFk;
    }

    public void setAccountIdFk(Integer accountIdFk) {
        this.accountIdFk = accountIdFk;
    }

    public Integer getCategoryIdFk() {
        return categoryIdFk;
    }

    public void setCategoryIdFk(Integer categoryIdFk) {
        this.categoryIdFk = categoryIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCategoriesEntity that = (AccountCategoriesEntity) o;
        return Objects.equals(accountIdFk, that.accountIdFk) && Objects.equals(categoryIdFk, that.categoryIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, categoryIdFk);
    }

    public AccountsEntity getAccountsByAccountIdFk() {
        return accountsByAccountIdFk;
    }

    public void setAccountsByAccountIdFk(AccountsEntity accountsByAccountIdFk) {
        this.accountsByAccountIdFk = accountsByAccountIdFk;
    }

    public CategoriesEntity getCategoriesByCategoryIdFk() {
        return categoriesByCategoryIdFk;
    }

    public void setCategoriesByCategoryIdFk(CategoriesEntity categoriesByCategoryIdFk) {
        this.categoriesByCategoryIdFk = categoriesByCategoryIdFk;
    }
}
