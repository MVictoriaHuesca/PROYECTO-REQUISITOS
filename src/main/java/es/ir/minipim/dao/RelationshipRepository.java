package es.ir.minipim.dao;

import es.ir.minipim.entity.AccountCategory;
import es.ir.minipim.entity.Category;
import es.ir.minipim.entity.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelationshipRepository extends JpaRepository<Relationship, Integer> {
    @Query("SELECT c FROM AccountCategory c WHERE c.accountIdFk.id = :accountId")
    List<AccountCategory> findByAccountId(@Param("accountId") Integer accountId);
}
