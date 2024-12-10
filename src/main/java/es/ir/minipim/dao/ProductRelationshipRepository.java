package es.ir.minipim.dao;

import es.ir.minipim.entity.ProductRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRelationshipRepository extends JpaRepository<ProductRelationship, Integer> {
}
