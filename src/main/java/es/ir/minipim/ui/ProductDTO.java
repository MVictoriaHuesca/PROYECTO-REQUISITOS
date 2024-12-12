package es.ir.minipim.ui;

import es.ir.minipim.entity.AccountAttribute;
import es.ir.minipim.entity.ProductAttribute;
import es.ir.minipim.entity.ProductCategory;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class ProductDTO {
    private Integer id;
    private String label;
    private String SKU;
    private Long GTIN;
    private Instant creationDate;
    private List<Integer> categories;
    private List<Integer> attributeIds;
    private List<String> attributeValues;
    private List<Integer> relationships;


    public List<String> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<String> attributeValues) {
        this.attributeValues = attributeValues;
    }

    public List<Integer> getAttributeIds() {
        return attributeIds;
    }

    public void setAttributeIds(List<Integer> attributeIds) {
        this.attributeIds = attributeIds;
    }


    public ProductDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public Long getGTIN() {
        return GTIN;
    }

    public void setGTIN(Long GTIN) {
        this.GTIN = GTIN;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public List<Integer> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Integer> relationships) {
        this.relationships = relationships;
    }
}
