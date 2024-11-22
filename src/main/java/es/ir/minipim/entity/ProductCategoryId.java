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
public class ProductCategoryId implements java.io.Serializable {
    private static final long serialVersionUID = 4193031839496006090L;
    @Column(name = "category_id_fk", nullable = false)
    private Integer categoryIdFk;

    @Column(name = "product_id_fk", nullable = false)
    private Integer productIdFk;

    @Column(name = "account_id_fk", nullable = false)
    private Integer accountIdFk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductCategoryId entity = (ProductCategoryId) o;
        return Objects.equals(this.accountIdFk, entity.accountIdFk) &&
                Objects.equals(this.categoryIdFk, entity.categoryIdFk) &&
                Objects.equals(this.productIdFk, entity.productIdFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdFk, categoryIdFk, productIdFk);
    }

}