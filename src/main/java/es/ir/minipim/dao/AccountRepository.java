package es.ir.minipim.dao;
import es.ir.minipim.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer>{
}
