package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "attribute", schema = "grupo05DB", catalog = "")
public class AttributeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "attribute_id", nullable = false)
    private Integer attributeId;

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    @Basic
    @Column(name = "attribute_name", nullable = false, length = 50)
    private String attributeName;

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @Basic
    @Column(name = "attribute_type", nullable = false, precision = 0)
    private Object attributeType;

    public Object getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(Object attributeType) {
        this.attributeType = attributeType;
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
        AttributeEntity that = (AttributeEntity) o;
        return Objects.equals(attributeId, that.attributeId) && Objects.equals(attributeName, that.attributeName) && Objects.equals(attributeType, that.attributeType) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeId, attributeName, attributeType, createdAt);
    }
}
