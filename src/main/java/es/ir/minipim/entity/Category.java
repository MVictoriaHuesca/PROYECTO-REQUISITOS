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
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id_fk", nullable = false)
    private Account accountIdFk;

    @Column(name = "category_name", nullable = false, length = 50)
    private String categoryName;

    @ColumnDefault("(now())")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ManyToMany(mappedBy = "categories")
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "categoryIdFk")
    private List<ProductCategory> productCategories = new ArrayList<>();



}