package es.ir.minipim.dao;

import es.ir.minipim.entity.AccountRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRelationshipRepository extends JpaRepository<AccountRelationship, Integer> {
    @Query("SELECT c FROM AccountRelationship c WHERE c.accountIdFk.id = :accountId")
    List<AccountRelationship> findByAccountId(@Param("accountId") Integer accountId);
}
