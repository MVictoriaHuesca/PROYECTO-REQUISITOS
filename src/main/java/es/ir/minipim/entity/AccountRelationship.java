package es.ir.minipim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account_relationship")
public class AccountRelationship {
    @EmbeddedId
    private AccountRelationshipId id;

    @MapsId("accountIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id_fk", nullable = false)
    private Account accountIdFk;

    @MapsId("relationshipIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "relationship_id_fk", nullable = false)
    private es.ir.minipim.entity.Relationship relationshipIdFk;

}