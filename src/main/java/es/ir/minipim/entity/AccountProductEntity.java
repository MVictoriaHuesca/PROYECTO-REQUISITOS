package es.ir.minipim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "account_product", schema = "grupo05DB", catalog = "")
@jakarta.persistence.IdClass(es.ir.minipim.entity.AccountProductEntityPK.class)
public class AccountProductEntity {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountProductEntity that = (AccountProductEntity) o;
        return Objects.equals(accountIdFk, that.accountIdFk) && Objects.equals(productIdFk, that.productIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, productIdFk);
    }
}
