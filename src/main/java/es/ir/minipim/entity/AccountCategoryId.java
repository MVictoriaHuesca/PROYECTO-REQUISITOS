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
public class AccountCategoryId implements java.io.Serializable {
    private static final long serialVersionUID = -1859815393350969159L;
    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;

    @Column(name = "category_id_fk", nullable = false)
    private Integer categoryIdFk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountCategoryId entity = (AccountCategoryId) o;
        return Objects.equals(this.accountIdFk, entity.accountIdFk) &&
                Objects.equals(this.categoryIdFk, entity.categoryIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, categoryIdFk);
    }

}