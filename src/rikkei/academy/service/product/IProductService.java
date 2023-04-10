package rikkei.academy.service.product;

import rikkei.academy.model.Product;
import rikkei.academy.service.IGenericService;

import java.util.List;

public interface IProductService extends IGenericService<Product> {
    List<Product> searchProductsByName(String name);
}
