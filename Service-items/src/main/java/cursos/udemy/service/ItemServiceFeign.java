package cursos.udemy.service;

import cursos.udemy.clients.ProductClientRest;
import cursos.udemy.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
@Primary    //Aplica por default que se use esta clase ya que en el comtroller como tiene como atributo la interfaz, no sabe cual inyectar
public class ItemServiceFeign implements IItemService {

    /** UTILIZA FEIGN CLIENT **/

    @Autowired
    private ProductClientRest clientFeign;

    @Override
    public List<Item> getAll() {
        return clientFeign.getAll().stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    @Override
    public Item getById(Integer idItem, Integer quantity) {
        return new Item(clientFeign.getById(idItem), quantity);
    }
}
