package es.ir.minipim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "relationship_product")
public class RelationshipProduct {
    @EmbeddedId
    private RelationshipProductId id;

    @MapsId("relationshipIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "relationship_id_fk", nullable = false)
    private Relationship relationshipIdFk;

    @MapsId("product1IdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product1_id_fk", nullable = false)
    private Product product1IdFk;

    @MapsId("product2IdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product2_id_fk", nullable = false)
    private Product product2IdFk;

}