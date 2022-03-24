package cursos.udemy.service;

import cursos.udemy.models.Item;
import cursos.udemy.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ItemServiceImp implements IItemService {

    /** UTILIZA REST TEMPLATE **/

    @Autowired
    private RestTemplate clientRest;

    @Override
    public List<Item> getAll() {
        List<Product> products = Arrays.asList(Objects.requireNonNull(clientRest.getForObject("http://localhost:8001/products", Product[].class)));
        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item getById(Integer idItem, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("idProduct", idItem.toString());
        Product product = clientRest.getForObject("http://localhost:8001/products/{idProduct}" , Product.class, pathVariables);
        return new Item(product, quantity);
    }
}
