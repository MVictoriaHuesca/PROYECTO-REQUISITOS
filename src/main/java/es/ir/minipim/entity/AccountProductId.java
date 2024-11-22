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
public class AccountProductId implements java.io.Serializable {
    private static final long serialVersionUID = 8713635135653359238L;
    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;

    @Column(name = "product_id_fk", nullable = false)
    private Integer productIdFk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountProductId entity = (AccountProductId) o;
        return Objects.equals(this.accountIdFk, entity.accountIdFk) &&
                Objects.equals(this.productIdFk, entity.productIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, productIdFk);
    }

}