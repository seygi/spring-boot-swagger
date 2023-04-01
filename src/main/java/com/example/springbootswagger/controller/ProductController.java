package com.example.springbootswagger.controller;

import com.example.springbootswagger.entity.Product;
import com.example.springbootswagger.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    // Create a new product
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        var newProduct = productService.saveProduct(product);
        return ResponseEntity.ok(newProduct.getBody());
    }

    // Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return productService.fetchAllProducts().getBody();
    }

    // Get a product by ID
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id)
    {
        var product = productService.fetchProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product.getBody().get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a product
    @PutMapping(path = "/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "productId")
                                                 Long productId, @RequestBody Product product)
    {
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping(value = "/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}