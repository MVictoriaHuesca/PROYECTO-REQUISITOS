package es.ir.minipim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_attribute")
public class ProductAttribute {
    @EmbeddedId
    private ProductAttributeId id;

    @MapsId("attributeIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "attribute_id_fk", nullable = false)
    private Attribute attributeIdFk;

    @MapsId("productIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id_fk", nullable = false)
    private Product productIdFk;

    @MapsId("accountIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id_fk", nullable = false)
    private Account accountIdFk;

    @Column(name = "value", length = 50)
    private String value;

}