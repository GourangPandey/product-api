package com.e_comm.product_api.service;

import com.e_comm.product_api.dto.ProductDTO;
import com.e_comm.product_api.entities.Product;
import com.e_comm.product_api.exception.ResourceNotFoundException;
import com.e_comm.product_api.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceIMP implements ProductService {
    private final ProductRepository repository;

    public ProductServiceIMP(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) {

        Product product = new Product(
                null,
                dto.getName(),
                dto.getCategory(),
                dto.getPrice(),
                dto.getStock()
        );

        Product saved = repository.save(product);
        return mapToDTO(saved);
    }

    @Override
    public ProductDTO getProductById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id));

        return mapToDTO(product);
    }

    @Override
    public Page<ProductDTO> getAllProducts(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = repository.findAll(pageable);

        List<ProductDTO> dtoList = new ArrayList<>();
        for (Product product : productPage.getContent()) {
            dtoList.add(mapToDTO(product));
        }

        return new PageImpl<>(dtoList, pageable, productPage.getTotalElements());
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO dto) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id));

        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());

        return mapToDTO(repository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id));

        repository.delete(product);
    }

    private ProductDTO mapToDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getStock()
        );
    }
}
