package com.example.jpa_appl;

import com.example.jpa_appl.entities.Product;
import com.example.jpa_appl.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaApplApplication implements CommandLineRunner {
    //injection des dependances
    @Autowired
private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaApplApplication.class, args);
    }
//enregistrer les donnes dans la BD
    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",4300,3));
        productRepository.save(new Product(null,"Printer",1200,4));
        productRepository.save(new Product(null,"Smart phone",3200,32));
        //afficher les donnes retourner liste du produit
        List<Product>products= productRepository.findAll();
        //parcourir la liste
        products.forEach(p->{
            System.out.println(p.toString());
        });
        //si je veux un produit dans id=1
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("**************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("*************");
        //utilisation dune base donnes de type h2 to:qui demarre en memoire
        //-----------------------
        //si je veux utiliser une bd de type mysql, je vais ajouter dependance dans .xml
        //-------------------
        //utiliser methode de chercher
        System.out.println("-----------------------------------------");
        List<Product>productList=productRepository.findByNameContains("C");
        productList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("-----------------------------------------");
        List<Product>productList2=productRepository.search("%C%");
        productList2.forEach(p->{
            System.out.println(p);
        });
        System.out.println("-----------------------------------------");
        List<Product>productList3=productRepository.findByPriceGreaterThan(3000);
        productList3.forEach(p->{
            System.out.println(p);
        });
        System.out.println("-----------------------------------------");
        List<Product>productList4=productRepository.searchByPrice(3000);
        productList4.forEach(p->{
            System.out.println(p);
        });


    }

}
