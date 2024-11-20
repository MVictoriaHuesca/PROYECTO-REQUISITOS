package es.ir.minipim.dao;

import es.ir.minipim.entity.AccountsEntity;
import es.ir.minipim.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductsEntity, Integer> {

}
