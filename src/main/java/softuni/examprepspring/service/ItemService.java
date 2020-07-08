package softuni.examprepspring.service;

import softuni.examprepspring.model.service.ItemServiceModel;
import softuni.examprepspring.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(String id);

    void delete(String id);
}
