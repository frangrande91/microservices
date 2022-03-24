package cursos.udemy.service;

import cursos.udemy.models.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    Product findById(Integer idProduct);
}
