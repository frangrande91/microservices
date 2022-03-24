package cursos.udemy.service;

import cursos.udemy.models.Item;

import java.util.List;

public interface IItemService {

    List<Item> getAll();
    Item getById(Integer idItem, Integer quantity);
}
