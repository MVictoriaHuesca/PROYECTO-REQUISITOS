package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "account_products", schema = "grupo05DB", catalog = "")
@IdClass(AccountProductsEntityPK.class)
public class AccountProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id_fk", nullable = false)
    private Integer productIdFk;
    @ManyToOne
    @JoinColumn(name = "account_id_fk", referencedColumnName = "account_id", nullable = false)
    private AccountsEntity accountsByAccountIdFk;
    @ManyToOne
    @JoinColumn(name = "product_id_fk", referencedColumnName = "product_id", nullable = false)
    private ProductsEntity productsByProductIdFk;

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
        AccountProductsEntity that = (AccountProductsEntity) o;
        return Objects.equals(accountIdFk, that.accountIdFk) && Objects.equals(productIdFk, that.productIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, productIdFk);
    }

    public AccountsEntity getAccountsByAccountIdFk() {
        return accountsByAccountIdFk;
    }

    public void setAccountsByAccountIdFk(AccountsEntity accountsByAccountIdFk) {
        this.accountsByAccountIdFk = accountsByAccountIdFk;
    }

    public ProductsEntity getProductsByProductIdFk() {
        return productsByProductIdFk;
    }

    public void setProductsByProductIdFk(ProductsEntity productsByProductIdFk) {
        this.productsByProductIdFk = productsByProductIdFk;
    }
}
