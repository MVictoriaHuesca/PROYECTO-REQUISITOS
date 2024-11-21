package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_attribute", schema = "grupo05DB", catalog = "")
@IdClass(ProductAttributeEntityPK.class)
public class ProductAttributeEntity {
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
    private AttributeEntity attributeByAttributeIdFk;
    @ManyToOne
    @JoinColumn(name = "product_id_fk", referencedColumnName = "product_id", nullable = false)
    private ProductEntity productByProductIdFk;
    @ManyToOne
    @JoinColumn(name = "account_id_fk", referencedColumnName = "account_id", nullable = false)
    private AccountEntity accountByAccountIdFk;
    @Basic
    @Column(name = "value", nullable = true, length = 50)
    private String value;

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
        ProductAttributeEntity that = (ProductAttributeEntity) o;
        return Objects.equals(attributeIdFk, that.attributeIdFk) && Objects.equals(productIdFk, that.productIdFk) && Objects.equals(accountIdFk, that.accountIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeIdFk, productIdFk, accountIdFk);
    }

    public AttributeEntity getAttributeByAttributeIdFk() {
        return attributeByAttributeIdFk;
    }

    public void setAttributeByAttributeIdFk(AttributeEntity attributeByAttributeIdFk) {
        this.attributeByAttributeIdFk = attributeByAttributeIdFk;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
