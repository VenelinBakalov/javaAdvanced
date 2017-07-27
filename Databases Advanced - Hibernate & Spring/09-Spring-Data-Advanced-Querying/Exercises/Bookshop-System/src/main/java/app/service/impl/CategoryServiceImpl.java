package app.service.impl;

import app.repository.api.CategoryRepository;
import app.model.Category;
import app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService<Category, Long> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void remove(Category object) {
        categoryRepository.delete(object);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category object) {
        categoryRepository.save(object);
    }

    @Override
    public Set<Category> categoriesByName(List<String> categories) {
        return this.categoryRepository.categoriesByName(categories);
    }

    @Override
    public List<Object[]> findTotalProfitByCategory() {
        return this.categoryRepository.findTotalProfitByCategory();
    }

    @Override
    public List<Category> findAllCategoriesOrderByBookCount() {
        return this.categoryRepository.findAllCategoriesOrderByBookCount();
    }

}
