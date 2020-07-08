package softuni.examprepspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.examprepspring.model.entity.Category;
import softuni.examprepspring.model.entity.CategoryName;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {

    Optional<Category> findByCategoryName(CategoryName categoryName);
}
