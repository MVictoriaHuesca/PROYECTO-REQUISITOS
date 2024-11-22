package es.ir.minipim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Column(name = "GTIN", nullable = false)
    private Long gtin;

    @Column(name = "SKU", nullable = false, length = 12)
    private String sku;

    @Column(name = "label", nullable = false, length = 50)
    private String label;

    @ColumnDefault("(now())")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ManyToMany(mappedBy = "products")
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "productIdFk")
    private List<es.ir.minipim.entity.ProductAttribute> productAttributes = new ArrayList<>();

    @OneToMany(mappedBy = "productIdFk")
    private List<es.ir.minipim.entity.ProductCategory> productCategories = new ArrayList<>();

}