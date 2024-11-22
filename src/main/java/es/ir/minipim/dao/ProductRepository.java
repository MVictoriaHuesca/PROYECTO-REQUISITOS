package es.ir.minipim.dao;

import es.ir.minipim.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p order by p.productId desc limit 1")
    public Product ultimoId();
}
