package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "grupo05DB", catalog = "")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "GTIN", nullable = false)
    private Long gtin;

    public Long getGtin() {
        return gtin;
    }

    public void setGtin(Long gtin) {
        this.gtin = gtin;
    }

    @Basic
    @Column(name = "SKU", nullable = false, length = 12)
    private String sku;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Basic
    @Column(name = "label", nullable = false, length = 50)
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

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
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(productId, that.productId) && Objects.equals(gtin, that.gtin) && Objects.equals(sku, that.sku) && Objects.equals(label, that.label) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, gtin, sku, label, createdAt);
    }
}
