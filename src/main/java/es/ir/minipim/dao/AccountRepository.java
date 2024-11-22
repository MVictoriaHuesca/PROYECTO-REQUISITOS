package es.ir.minipim.dao;
import es.ir.minipim.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
