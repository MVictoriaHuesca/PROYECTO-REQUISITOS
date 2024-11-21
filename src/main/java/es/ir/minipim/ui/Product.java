package es.ir.minipim.ui;

import java.sql.Timestamp;

public class Product {
    private Integer id;
    private String label;
    private String SKU;
    private Long GTIN;
    private Timestamp creationDate;

    public Product() {
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

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
