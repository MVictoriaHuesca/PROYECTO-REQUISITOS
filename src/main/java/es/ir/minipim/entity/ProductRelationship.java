package es.ir.minipim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_relationship")
public class ProductRelationship {
    @EmbeddedId
    private ProductRelationshipId id;

    @MapsId("relationshipIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "relationship_id_fk", nullable = false)
    private es.ir.minipim.entity.Relationship relationshipIdFk;

    @MapsId("productIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id_fk", nullable = false)
    private Product productIdFk;

    @MapsId("accountIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id_fk", nullable = false)
    private Account accountIdFk;

}