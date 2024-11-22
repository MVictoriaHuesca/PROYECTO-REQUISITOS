package es.ir.minipim.dao;

import es.ir.minipim.entity.AccountAttribute;
import es.ir.minipim.entity.AccountProduct;
import es.ir.minipim.entity.Attribute;
import es.ir.minipim.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountAttributeRepository extends JpaRepository<AccountAttribute, Integer> {
    @Query("select ap from AccountAttribute ap where ap.attributeIdFk = :attribute")
    public List<AccountAttribute> atributosDeCuenta(@Param("attribute") Attribute attribute);

}
