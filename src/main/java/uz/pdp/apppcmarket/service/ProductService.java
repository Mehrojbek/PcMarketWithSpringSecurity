package uz.pdp.apppcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.apppcmarket.entity.Product;
import uz.pdp.apppcmarket.payload.ProductDto;
import uz.pdp.apppcmarket.repository.ProductRepository;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllByProperties(ProductDto productDto){
        return productRepository.getAllByProperty(productDto.getId());
    }
}
