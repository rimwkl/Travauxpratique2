package com.example.jpa_appl.repository;

import com.example.jpa_appl.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>
{
    //chercher les produits dans la designation contient un mot clé
    //solution1 ajouter methode qui retourne un produit
    List<Product>findByNameContains(String mc);
    List<Product>findByPriceGreaterThan(double price);

    //solution 2 appel une methode comme je veux
    @Query("select p from Product p where p.name like :x")
    //mc sa represente parametre x
    List<Product>search(@Param("x") String mc);

    @Query("select p from Product p where p.price>:x")
    List<Product>searchByPrice(@Param("x") double price );
}
