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
public class AccountAttributeId implements java.io.Serializable {
    private static final long serialVersionUID = -1590292597415271861L;
    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;

    @Column(name = "attribute_id_fk", nullable = false)
    private Integer attributeIdFk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountAttributeId entity = (AccountAttributeId) o;
        return Objects.equals(this.accountIdFk, entity.accountIdFk) &&
                Objects.equals(this.attributeIdFk, entity.attributeIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, attributeIdFk);
    }

}