package es.ir.minipim.dao;

import es.ir.minipim.entity.AccountCategory;
import es.ir.minipim.entity.Category;
import es.ir.minipim.entity.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelationshipRepository extends JpaRepository<Relationship, Integer> {
    //count relatioships with same name as param
    @Query("SELECT COUNT(r) FROM Relationship r WHERE r.name = :name")
    public int existeNombreRelacion(@Param("name") String name);
}
