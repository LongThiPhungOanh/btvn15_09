package com.example.btvn_15_09.service.iml;
import com.example.btvn_15_09.model.Category;
import com.example.btvn_15_09.model.Product;
import com.example.btvn_15_09.repository.iml.ProductRepository;
import com.example.btvn_15_09.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRep;

    public Page<Product> getPageAll(int pageNum, int pageSize){
        return productRep.getProductPage(pageNum, pageSize);
    }

    public List<Product> finAll() {
        return productRep.findAll();
    }

    @Override
    public Product finById(Long id) {
        return productRep.findById(id);
    }

    @Override
    public void create(Product product) {
        productRep.save(product);
    }

    @Override
    public void update(Product product) {
        productRep.save(product);
    }

    @Override
    public void delete(Long id) {
        productRep.deleteById(id);
    }
    public List<Product> searchByName(String name){
        List<Product> productList = finAll();
        List<Product> products1 = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                products1.add(p);
            }
        }
        return products1;
    }
    public List<Product> searchByCategory(Long id){
        List<Product> products1 = finAll();
        List<Product> productList = new ArrayList<>();
        for (Product p: products1) {
            if (p.getCategory().getId().equals(id)){
                productList.add(p);
            }
        }
        return productList;
    }
}
