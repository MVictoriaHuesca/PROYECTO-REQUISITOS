package es.ir.minipim.dao;

import es.ir.minipim.entity.AccountProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountProductRepository extends JpaRepository<AccountProduct, Integer> {
}
