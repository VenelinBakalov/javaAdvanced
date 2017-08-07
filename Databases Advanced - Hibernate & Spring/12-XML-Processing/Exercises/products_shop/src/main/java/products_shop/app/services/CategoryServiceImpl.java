package products_shop.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.app.dto.bind.add.CategoryAddDto;
import products_shop.app.dto.view.CategoryDto;
import products_shop.app.dto.view.CategoryDtoAdapter;
import products_shop.app.dto.view.CategoryDtoView;
import products_shop.app.entities.Category;
import products_shop.app.repos.CategoryRepositery;
import products_shop.app.utils.ModelParser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepositery categoryRepositery;

    @Autowired
    public CategoryServiceImpl(CategoryRepositery userRepositery) {
        this.categoryRepositery = userRepositery;
    }

    @Override
    public void register(CategoryAddDto category) {
        Category categoryToSave = ModelParser.map(category, Category.class);
        if (categoryToSave != null) {
            this.categoryRepositery.save(categoryToSave);
        }
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> all = this.categoryRepositery.findAll();
        List<CategoryDto> categories = new ArrayList<>();

        for (Category category : all) {
            CategoryDto maped = ModelParser.map(category, CategoryDto.class);

            categories.add(maped);
        }

        return categories;
    }

    @Override
    public List<CategoryDtoView> findAllOrderedByProductCount() {
        List<Category> allOrderedByProductCount = this.categoryRepositery.findAllOrderedByProductCount();
        List<CategoryDtoView> categoryDtoViewList = new LinkedList<>();

        for (Category category : allOrderedByProductCount) {
            CategoryDtoAdapter mapAdapter = ModelParser.map(category, CategoryDtoAdapter.class);
            CategoryDtoView map = ModelParser.map(mapAdapter, CategoryDtoView.class);
            categoryDtoViewList.add(map);
        }

        return categoryDtoViewList;
    }


}
