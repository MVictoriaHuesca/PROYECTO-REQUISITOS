package es.ir.minipim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "relationship")
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relationship_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product1_id_fk", nullable = false)
    private Product product1IdFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product2_id_fk", nullable = false)
    private Product product2IdFk;

    @ManyToMany(mappedBy = "relationships")
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "relationshipIdFk")
    private List<ProductRelationship> productRelationships = new ArrayList<>();

}