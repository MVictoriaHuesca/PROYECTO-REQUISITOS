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
@Table(name = "attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id_fk", nullable = false)
    private Account accountIdFk;

    @Column(name = "attribute_name", nullable = false, length = 50)
    private String attributeName;

    @Lob
    @Column(name = "attribute_type", nullable = false)
    private String attributeType;

    @ColumnDefault("(now())")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ManyToMany(mappedBy = "attributes")
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "attributeIdFk")
    private List<es.ir.minipim.entity.ProductAttribute> productAttributes = new ArrayList<>();

}