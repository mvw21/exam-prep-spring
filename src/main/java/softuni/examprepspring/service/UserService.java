package softuni.examprepspring.service;

import softuni.examprepspring.model.entity.User;
import softuni.examprepspring.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);
}
