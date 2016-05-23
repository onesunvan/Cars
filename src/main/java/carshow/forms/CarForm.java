package carshow.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ivan
 */
public class CarForm {
    
    @NotEmpty
    @Size(min = 1, max = 25)
    private String brand;
    
    @NotEmpty
    @Size(min = 1, max = 25)
    private String model;
    
    @NotNull
    @Min(value = 200)
    private Integer price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
