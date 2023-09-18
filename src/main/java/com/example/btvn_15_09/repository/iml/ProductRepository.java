package com.example.btvn_15_09.repository.iml;
import com.example.btvn_15_09.model.Product;
import com.example.btvn_15_09.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public class ProductRepository{

    @Autowired
    private IProductRepository productRepository;

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public Page<Product> getProductPage(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return productRepository.findAll(pageRequest);
    }
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
 }

    public void save(Product product) {
        productRepository.save(product);
    }
}
