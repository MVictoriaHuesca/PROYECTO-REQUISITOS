package es.ir.minipim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_category")
public class ProductCategory {
    @EmbeddedId
    private ProductCategoryId id;

    @MapsId("categoryIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id_fk", nullable = false)
    private Category categoryIdFk;

    @MapsId("productIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id_fk", nullable = false)
    private Product productIdFk;

    @MapsId("accountIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id_fk", nullable = false)
    private Account accountIdFk;

}