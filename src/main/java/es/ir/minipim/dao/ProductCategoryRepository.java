package es.ir.minipim.dao;

import es.ir.minipim.entity.Category;
import es.ir.minipim.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryIdFk(Category categoryIdFk);
}
