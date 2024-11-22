package es.ir.minipim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account_product")
public class AccountProduct {
    @EmbeddedId
    private AccountProductId id;

    @MapsId("accountIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id_fk", nullable = false)
    private Account accountIdFk;

    @MapsId("productIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id_fk", nullable = false)
    private Product productIdFk;

}