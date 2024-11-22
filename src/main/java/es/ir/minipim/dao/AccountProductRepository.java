package es.ir.minipim.dao;

import es.ir.minipim.entity.AccountProduct;
import es.ir.minipim.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountProductRepository extends JpaRepository<AccountProduct, Integer> {

    @Query("select ap from AccountProduct ap where ap.productIdFk = :producto")
    public List<AccountProduct> productosDeCuenta(@Param("producto") Product producto);
}
