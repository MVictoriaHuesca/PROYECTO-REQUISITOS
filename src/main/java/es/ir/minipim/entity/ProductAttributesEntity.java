package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_attributes", schema = "grupo05DB", catalog = "")
@IdClass(ProductAttributesEntityPK.class)
public class ProductAttributesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "attribute_id_fk", nullable = false)
    private Integer attributeIdFk;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id_fk", nullable = false)
    private Integer productIdFk;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;
    @ManyToOne
    @JoinColumn(name = "attribute_id_fk", referencedColumnName = "attribute_id", nullable = false)
    private AttributesEntity attributesByAttributeIdFk;
    @ManyToOne
    @JoinColumn(name = "product_id_fk", referencedColumnName = "product_id", nullable = false)
    private ProductsEntity productsByProductIdFk;
    @ManyToOne
    @JoinColumn(name = "account_id_fk", referencedColumnName = "account_id", nullable = false)
    private AccountsEntity accountsByAccountIdFk;

    public Integer getAttributeIdFk() {
        return attributeIdFk;
    }

    public void setAttributeIdFk(Integer attributeIdFk) {
        this.attributeIdFk = attributeIdFk;
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
        ProductAttributesEntity that = (ProductAttributesEntity) o;
        return Objects.equals(attributeIdFk, that.attributeIdFk) && Objects.equals(productIdFk, that.productIdFk) && Objects.equals(accountIdFk, that.accountIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeIdFk, productIdFk, accountIdFk);
    }

    public AttributesEntity getAttributesByAttributeIdFk() {
        return attributesByAttributeIdFk;
    }

    public void setAttributesByAttributeIdFk(AttributesEntity attributesByAttributeIdFk) {
        this.attributesByAttributeIdFk = attributesByAttributeIdFk;
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
