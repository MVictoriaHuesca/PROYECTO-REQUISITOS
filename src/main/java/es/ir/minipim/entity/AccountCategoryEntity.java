package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "account_category", schema = "grupo05DB", catalog = "")
@IdClass(AccountCategoryEntityPK.class)
public class AccountCategoryEntity {
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id_fk", nullable = false)
    private Integer categoryIdFk;

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
        AccountCategoryEntity that = (AccountCategoryEntity) o;
        return Objects.equals(accountIdFk, that.accountIdFk) && Objects.equals(categoryIdFk, that.categoryIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, categoryIdFk);
    }
}
