package es.ir.minipim.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import es.ir.minipim.entity.AccountsEntity;
public interface AccountRepository extends JpaRepository<AccountsEntity, Integer>{
}
