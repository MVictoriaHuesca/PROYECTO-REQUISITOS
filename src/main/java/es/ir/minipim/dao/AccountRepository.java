package es.ir.minipim.dao;
import es.ir.minipim.entity2.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer>{

}
