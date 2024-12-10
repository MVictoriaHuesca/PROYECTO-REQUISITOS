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
public class ProductRelationshipId implements java.io.Serializable {
    private static final long serialVersionUID = -6716414943999348234L;
    @Column(name = "relationship_id_fk", nullable = false)
    private Integer relationshipIdFk;

    @Column(name = "product_id_fk", nullable = false)
    private Integer productIdFk;

    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductRelationshipId entity = (ProductRelationshipId) o;
        return Objects.equals(this.accountIdFk, entity.accountIdFk) &&
                Objects.equals(this.relationshipIdFk, entity.relationshipIdFk) &&
                Objects.equals(this.productIdFk, entity.productIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, relationshipIdFk, productIdFk);
    }

}