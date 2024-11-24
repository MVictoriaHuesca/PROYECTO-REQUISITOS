package es.ir.minipim.dao;

import es.ir.minipim.entity.Attribute;
import es.ir.minipim.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Integer> {
    @Query("SELECT pa FROM ProductAttribute pa WHERE pa.attributeIdFk = :attributeId")
    List<ProductAttribute> findProductByAttributeId(@Param("attributeId") Integer attributeId);
}
