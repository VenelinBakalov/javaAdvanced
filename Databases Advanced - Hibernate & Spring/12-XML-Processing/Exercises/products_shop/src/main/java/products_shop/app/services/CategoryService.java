package products_shop.app.services;

import products_shop.app.dto.bind.add.CategoryAddDto;
import products_shop.app.dto.view.CategoryDto;
import products_shop.app.dto.view.CategoryDtoView;

import java.util.List;


public interface CategoryService {
    void register(CategoryAddDto category);
    List<CategoryDto> findAll();
    List<CategoryDtoView> findAllOrderedByProductCount();
}
