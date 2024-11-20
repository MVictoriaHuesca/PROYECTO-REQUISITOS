package es.ir.minipim.dao;

import es.ir.minipim.entity.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeRepository extends JpaRepository <AttributeEntity, Integer> {
}
