package cursos.udemy.controller;

import cursos.udemy.models.Product;
import cursos.udemy.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("/{idProduct}")
    public Product getById(@PathVariable Integer idProduct){
        return productService.findById(idProduct);
    }
}
