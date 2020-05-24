package com.grocery.management.controller;

import com.grocery.management.dto.GroceryListDTO;
import com.grocery.management.service.GroceryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arshi on 5/15/2020.
 */
@RestController
public class GroceryListController {

    @Autowired
    GroceryListService groceryListService;

    @GetMapping("/groceries")
    public GroceryListDTO fetchGroceryListByUserName(@RequestParam String username) {
        return groceryListService.fetchGroceryListByUserName(username);
    }

    @PostMapping("/currentList")
    public GroceryListDTO createorUpdateGroceryList(@RequestBody GroceryListDTO groceryListDTO) {
        return groceryListService.addOrUpdateGroceryList(groceryListDTO);
    }



}
