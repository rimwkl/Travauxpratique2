package com.example.jpa_appl.web;

import com.example.jpa_appl.entities.Product;
import com.example.jpa_appl.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    private ProductRepository productRepository;
    //methode qui permet de consulter la liste des produits

    //acceder a cette methode je vais utiliser annotaions , si j'envoie une requete http /products il va me retourner les produits en format json car j'ai utiliser restcontroller
    @GetMapping("/products")
    public List<Product>products(){
        return productRepository.findAll();
    }
    //retourner 1 seul produit par son id avec get ou orelse,PathVariable=pour dire que id qui est dans url cest la meme dans le path
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable Long id){
        Product product= productRepository.findById(id).orElse(null);
        return product;
    }
}

