package es.ir.minipim.dao;
import es.ir.minipim.entity.AccountEntity;
import es.ir.minipim.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer>{

}
