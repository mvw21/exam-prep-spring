package softuni.examprepspring.service;

import softuni.examprepspring.model.entity.Category;
import softuni.examprepspring.model.entity.CategoryName;
import softuni.examprepspring.model.service.CategoryServiceModel;

public interface CategoryService {

    void initCategories();

    CategoryServiceModel findByCategoryName(CategoryName categoryName);
    Category find(CategoryName categoryName);
}
