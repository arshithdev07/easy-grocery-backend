package com.grocery.management.service;

import com.grocery.management.domain.GroceryList;
import com.grocery.management.domain.User;
import com.grocery.management.dto.GroceryListDTO;
import com.grocery.management.repository.GroceryListRepository;
import com.grocery.management.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by arshi on 5/15/2020.
 */
@Service
public class GroceryListService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroceryListRepository groceryListRepository;

    @Autowired
    UserService userService;

    public GroceryListDTO fetchGroceryListByUserName(String username) {
        User user = userService.loadUserByUsername(username);
        GroceryList groceryList = groceryListRepository.findByCurrentUser(user.getId())
                .orElseThrow(() -> new RuntimeException("Grocery List not found") );

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(groceryList, GroceryListDTO.class);
    }

    public GroceryListDTO addOrUpdateGroceryList(GroceryListDTO groceryListDTO) {
        User user = userService.loadUserByUsername(groceryListDTO.getUserName());
        Boolean isGroceryListPresent = groceryListRepository.findByCurrentUser(user.getId()).isPresent();

        ModelMapper modelMapper = new ModelMapper();

        if(!isGroceryListPresent) {
            GroceryList groceryList = new GroceryList();
            groceryList.setUser(user);
            groceryList.setCurrentList(groceryListDTO.getCurrentList());

            groceryList = groceryListRepository.save(groceryList);
            return modelMapper.map(groceryList, GroceryListDTO.class);
        }

        GroceryList existingGroceryList = groceryListRepository.findByCurrentUser(user.getId()).get();
        existingGroceryList.setCurrentList(groceryListDTO.getCurrentList());
        existingGroceryList = groceryListRepository.save(existingGroceryList);
        return modelMapper.map(existingGroceryList, GroceryListDTO.class);

    }

}
