package es.ir.minipim.dao;

import es.ir.minipim.entity.AccountAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountAttributeRepository extends JpaRepository<AccountAttributeEntity, Integer> {

}
