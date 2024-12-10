package es.ir.minipim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RelationshipProductId implements java.io.Serializable {
    private static final long serialVersionUID = -6153404674375476351L;
    @Column(name = "relationship_id_fk", nullable = false)
    private Integer relationshipIdFk;

    @Column(name = "product1_id_fk", nullable = false)
    private Integer product1IdFk;

    @Column(name = "product2_id_fk", nullable = false)
    private Integer product2IdFk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RelationshipProductId entity = (RelationshipProductId) o;
        return Objects.equals(this.product2IdFk, entity.product2IdFk) &&
                Objects.equals(this.relationshipIdFk, entity.relationshipIdFk) &&
                Objects.equals(this.product1IdFk, entity.product1IdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product2IdFk, relationshipIdFk, product1IdFk);
    }

}