package es.ir.minipim.dao;

import es.ir.minipim.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttributeRepository extends JpaRepository <Attribute, Integer> {

    @Query("select a from Attribute a where a.accountIdFk = :id")
    public List<Attribute> listarAtributosCuenta (@Param("id") Integer id);

}
