package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket.entity.Product;
import uz.pdp.apppcmarket.payload.ProductDto;
import uz.pdp.apppcmarket.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product/properties")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<?> getAllByProperties(@RequestBody ProductDto productDto){
        List<Product> byProperties = productService.getAllByProperties(productDto);
        return ResponseEntity.status(!byProperties.isEmpty()?200:404).body(byProperties);
    }

}
