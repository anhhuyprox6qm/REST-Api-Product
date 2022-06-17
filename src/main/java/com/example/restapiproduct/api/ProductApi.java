package com.example.restapiproduct.api;

import com.example.restapiproduct.entity.Product;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public class ProductApi {
    private static List<Product> products = new ArrayList<>();
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll(){
        return products;
    }
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Product findById(@PathVariable int id){
        int foundIndex = -1;
        for (int i = 0; i<products.size();i++){
            if (products.get(i).getId()==id){
                foundIndex = i;
            }
        }
        if (foundIndex==-1){
            return null;
        }
        return products.get(foundIndex);
    }
    @RequestMapping(method= RequestMethod.POST)
    public Product save(@RequestBody Product product){
        products.add(product);
        return product;
    }
    @RequestMapping(method = RequestMethod.PUT,path="{id}")
    public Product update(@PathVariable int id,@RequestBody Product updateProduct) {
        int foundIndex = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                foundIndex = i;
            }
        }
        if (foundIndex == -1) {
            return null;
        }
        products.remove(foundIndex).setName(updateProduct.getName());
        products.get(foundIndex).setDescription(updateProduct.getDescription());
        return products.get(foundIndex);
    }
    @RequestMapping(method=RequestMethod.DELETE,path="{id}")
    public Product update(@PathVariable int id){
        int foundIndex =-1;
        for (int i=0;i<products.size();i++){
            if (products.get(i).getId()==id){
                foundIndex=i;
            }
        }
        if (foundIndex==-1){
            return null;
        }
        products.remove(foundIndex);
        return null;
    }
}


