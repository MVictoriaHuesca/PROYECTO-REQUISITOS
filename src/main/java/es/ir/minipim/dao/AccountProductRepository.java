package es.ir.minipim.dao;

import es.ir.minipim.entity2.AccountProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountProductRepository extends JpaRepository<AccountProductEntity, Integer> {
}
