package softuni.examprepspring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.examprepspring.model.entity.Item;
import softuni.examprepspring.model.service.CategoryServiceModel;
import softuni.examprepspring.model.service.ItemServiceModel;
import softuni.examprepspring.model.view.ItemViewModel;
import softuni.examprepspring.repository.ItemRepository;
import softuni.examprepspring.service.CategoryService;
import softuni.examprepspring.service.ItemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {

//        CategoryServiceModel categoryServiceModel = this.categoryService
//                .findByCategoryName(itemServiceModel.getCategory().getCategoryName());
//
//        itemServiceModel.setCategory(categoryServiceModel);
//        this.itemRepository.saveAndFlush(this.modelMapper
//                .map(itemServiceModel, Item.class));

        Item item = this.modelMapper.map(itemServiceModel,Item.class);
        System.out.println();
        item.setCategory(this.categoryService
                .find(itemServiceModel.getCategory().getCategoryName()));
        System.out.println();
        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return this.itemRepository
                .findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper
                            .map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",item.getGender(),
                            item.getCategory().getCategoryName().name()));
                    System.out.println();
                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {
        return this.itemRepository.
                findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper
                            .map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",item.getGender(),
                            item.getCategory().getCategoryName().name()));

                    return itemViewModel;
                })
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteById(id);
    }


}
