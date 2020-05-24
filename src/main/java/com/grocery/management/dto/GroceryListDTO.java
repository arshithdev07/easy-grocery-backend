package com.grocery.management.dto;

/**
 * Created by arshi on 5/15/2020.
 */
public class GroceryListDTO {

    String currentList;
    String userName;

    public String getCurrentList() {
        return currentList;
    }

    public void setCurrentList(String currentList) {
        this.currentList = currentList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
