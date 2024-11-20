package es.ir.minipim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class AccountProductEntityPK implements Serializable {
    @Column(name = "account_id_fk", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountIdFk;
    @Column(name = "product_id_fk", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productIdFk;

    public Integer getAccountIdFk() {
        return accountIdFk;
    }

    public void setAccountIdFk(Integer accountIdFk) {
        this.accountIdFk = accountIdFk;
    }

    public Integer getProductIdFk() {
        return productIdFk;
    }

    public void setProductIdFk(Integer productIdFk) {
        this.productIdFk = productIdFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountProductEntityPK that = (AccountProductEntityPK) o;
        return Objects.equals(accountIdFk, that.accountIdFk) && Objects.equals(productIdFk, that.productIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, productIdFk);
    }
}
