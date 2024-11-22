package es.ir.minipim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account_attribute")
public class AccountAttribute {
    @EmbeddedId
    private AccountAttributeId id;

    @MapsId("accountIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id_fk", nullable = false)
    private Account accountIdFk;

    @MapsId("attributeIdFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "attribute_id_fk", nullable = false)
    private Attribute attributeIdFk;

}