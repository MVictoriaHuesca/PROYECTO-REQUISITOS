package es.ir.minipim.dao;
import es.ir.minipim.entity.Account;
import es.ir.minipim.entity.AccountProduct;
import es.ir.minipim.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer>{
    @Query("select a from Account a where a.groupName = :groupName")
    public List<Account> findByGroupName(@Param("groupName") String groupName);
}
