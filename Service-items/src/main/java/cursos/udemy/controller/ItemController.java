package cursos.udemy.controller;

import cursos.udemy.models.Item;
import cursos.udemy.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    @Qualifier("serviceFeign")   //Sirve para identificar que servicio utilizar (otra forma de hacerlo es con @Primary en el servicio que se quiere inyectar)
    private IItemService iItemService;

    @GetMapping()
    public List<Item> getAll() {
        return iItemService.getAll();
    }

    @GetMapping("/{idItem}/{quantity}")
    public Item getItemById(@PathVariable Integer idItem, @PathVariable Integer quantity) {
        return iItemService.getById(idItem, quantity);
    }
}
