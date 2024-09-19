package org.mihailivadaru.ecommerce.DTO;

/*
Before creating a product, we need to understand, what is a DTO (data transfer object)
Martin Fowler introduced the concept of a Data Transfer Object (DTO) as an object that carries data between processes.
In category controller, we directly used the model as request body, but that is not practical in many cases. We need to create a different object because
sometimes we might have to change the model, and we do not want to change the API for backward compatibility
We can’t use the model as request body if it has relationship with another model.
 */


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;
    private @NotNull String name;
    private @NotNull String imageURL;
    private @NotNull double price;
    private @NotNull String description;
    private @NotNull Integer categoryId;

}
