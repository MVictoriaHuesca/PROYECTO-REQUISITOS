package es.ir.minipim.dao;

import es.ir.minipim.entity2.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query("select p from ProductEntity p order by p.productId desc limit 1")
    public ProductEntity ultimoId();
}
