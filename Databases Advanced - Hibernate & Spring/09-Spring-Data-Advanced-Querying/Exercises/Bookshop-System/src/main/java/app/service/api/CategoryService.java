package app.service.api;

import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * Created by Venelin on 20.7.2017 г..
 */
public interface CategoryService<Category, Long> extends ServiceInterface<Category, Long> {

    Set<app.model.Category> categoriesByName(List<String> categories);

    List<Object[]> findTotalProfitByCategory();
}
