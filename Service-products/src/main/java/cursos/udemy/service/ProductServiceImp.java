package cursos.udemy.service;

import cursos.udemy.DAO.ProductDAO;
import cursos.udemy.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements IProductService{

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(Integer idProduct) {
        return productDAO.findById(idProduct).orElse(null);
    }
}
