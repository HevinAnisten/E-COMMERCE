package e_commerce_application.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

        @Autowired
        private ProductRepository productRepository;

        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }

        public Optional<Product> getProductById(Long productId) {
            return productRepository.findById(productId);
        }

        public Product createProduct(Product product) {
            return productRepository.save(product);
        }

        public Product updateProduct(Long productId, Product productDetails) {
            Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException() );
            product.setProductName(productDetails.getProductName());
            product.setProductDescription(productDetails.getProductDescription());
            product.setPrice(productDetails.getPrice());
            product.setGstPercentage(productDetails.getGstPercentage());
            return productRepository.save(product);
        }

        public void deleteProduct(Long productId) {
            productRepository.deleteById(productId);
        }


}
