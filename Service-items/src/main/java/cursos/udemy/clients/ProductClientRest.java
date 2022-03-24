package cursos.udemy.clients;

import cursos.udemy.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "service-products", url = "localhost:8001")
public interface ProductClientRest {

    @GetMapping("/products")
    List<Product> getAll();

    @GetMapping("/products/{idProduct}")
    Product getById(@PathVariable Integer idProduct);
}
