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
public class AccountRelationshipId implements java.io.Serializable {
    private static final long serialVersionUID = 4824320399622560921L;
    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;

    @Column(name = "relationship_id_fk", nullable = false)
    private Integer relationshipIdFk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountRelationshipId entity = (AccountRelationshipId) o;
        return Objects.equals(this.accountIdFk, entity.accountIdFk) &&
                Objects.equals(this.relationshipIdFk, entity.relationshipIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, relationshipIdFk);
    }

}