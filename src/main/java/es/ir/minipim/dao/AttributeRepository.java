package es.ir.minipim.dao;

import es.ir.minipim.entity.AccountAttributeEntity;
import es.ir.minipim.entity.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttributeRepository extends JpaRepository <AttributeEntity, Integer> {

}
