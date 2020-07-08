package softuni.examprepspring.model.binding;

import org.hibernate.validator.constraints.Length;
import softuni.examprepspring.model.entity.Category;
import softuni.examprepspring.model.entity.CategoryName;
import softuni.examprepspring.model.entity.Gender;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ItemAddBindingModel {
    private String name;
    private String description;
    private CategoryName category;
    private Gender gender;
    private BigDecimal price;

    public ItemAddBindingModel() {
    }

    @Length(min = 2,message = "Name length must be more than two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 3,message = "Description length must be more than three characters!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Enter valid category name!")
    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @DecimalMin(value = "0",message = "Enter valid price!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
