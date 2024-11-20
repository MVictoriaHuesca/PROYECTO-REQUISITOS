package es.ir.minipim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class AccountCategoryEntityPK implements Serializable {
    @Column(name = "account_id_fk", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountIdFk;
    @Column(name = "category_id_fk", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryIdFk;

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
        AccountCategoryEntityPK that = (AccountCategoryEntityPK) o;
        return Objects.equals(accountIdFk, that.accountIdFk) && Objects.equals(categoryIdFk, that.categoryIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, categoryIdFk);
    }
}
