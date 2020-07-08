package softuni.examprepspring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.examprepspring.model.entity.Category;
import softuni.examprepspring.model.entity.CategoryName;
import softuni.examprepspring.model.service.CategoryServiceModel;
import softuni.examprepspring.repository.CategoryRepository;
import softuni.examprepspring.service.CategoryService;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {
        if(this.categoryRepository.count() == 0){
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                    this.categoryRepository
                            .save(new Category(categoryName,
                                    String.format("Description for %s",
                                            categoryName.name())));
                    });
        }
    }

    @Override
    public CategoryServiceModel findByCategoryName(CategoryName categoryName) {
        return this.categoryRepository
                .findByCategoryName(categoryName)
                .map(category -> this.modelMapper.map(category,CategoryServiceModel.class))
                .orElse(null);
    }

    @Override
    public Category find(CategoryName categoryName) {
        return this.categoryRepository
                .findByCategoryName(categoryName)
                .orElse(null);
    }
}
