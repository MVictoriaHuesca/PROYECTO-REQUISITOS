package es.ir.minipim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account_category")
public class AccountCategory {
    @EmbeddedId
    private AccountCategoryId id;

    @MapsId("accountIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id_fk", nullable = false)
    private Account accountIdFk;

    @MapsId("categoryIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id_fk", nullable = false)
    private Category categoryIdFk;

}