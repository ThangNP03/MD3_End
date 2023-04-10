package rikkei.academy.service.category;

import rikkei.academy.model.Category;
import rikkei.academy.model.Product;
import rikkei.academy.service.IGenericService;

import java.util.List;

public interface ICategoryService extends IGenericService<Category> {
    List<Category> searchCategoryByName(String name);
}
