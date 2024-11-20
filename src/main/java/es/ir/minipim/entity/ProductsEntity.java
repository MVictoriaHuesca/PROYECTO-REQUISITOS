package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "grupo05DB", catalog = "")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id", nullable = false)
    private Integer productId;
    @Basic
    @Column(name = "GTIN", nullable = false)
    private Long gtin;
    @Basic
    @Column(name = "SKU", nullable = false, length = 12)
    private String sku;
    @Basic
    @Column(name = "label", nullable = false, length = 50)
    private String label;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @OneToMany(mappedBy = "productsByProductIdFk")
    private Collection<AccountProductsEntity> accountProductsByProductId;
    @OneToMany(mappedBy = "productsByProductIdFk")
    private Collection<ProductAttributesEntity> productAttributesByProductId;
    @OneToMany(mappedBy = "productsByProductIdFk")
    private Collection<ProductCategoriesEntity> productCategoriesByProductId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getGtin() {
        return gtin;
    }

    public void setGtin(Long gtin) {
        this.gtin = gtin;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
        ProductsEntity that = (ProductsEntity) o;
        return Objects.equals(productId, that.productId) && Objects.equals(gtin, that.gtin) && Objects.equals(sku, that.sku) && Objects.equals(label, that.label) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, gtin, sku, label, createdAt);
    }

    public Collection<AccountProductsEntity> getAccountProductsByProductId() {
        return accountProductsByProductId;
    }

    public void setAccountProductsByProductId(Collection<AccountProductsEntity> accountProductsByProductId) {
        this.accountProductsByProductId = accountProductsByProductId;
    }

    public Collection<ProductAttributesEntity> getProductAttributesByProductId() {
        return productAttributesByProductId;
    }

    public void setProductAttributesByProductId(Collection<ProductAttributesEntity> productAttributesByProductId) {
        this.productAttributesByProductId = productAttributesByProductId;
    }

    public Collection<ProductCategoriesEntity> getProductCategoriesByProductId() {
        return productCategoriesByProductId;
    }

    public void setProductCategoriesByProductId(Collection<ProductCategoriesEntity> productCategoriesByProductId) {
        this.productCategoriesByProductId = productCategoriesByProductId;
    }
}
