package com.e_comm.product_api.service;

import com.e_comm.product_api.dto.ProductDTO;
import org.springframework.data.domain.Page;

public interface ProductService {
    ProductDTO createProduct(ProductDTO dto);
    ProductDTO getProductById(Long id);

    Page<ProductDTO> getAllProducts(int page, int size);

    ProductDTO updateProduct(Long id, ProductDTO dto);

    void deleteProduct(Long id);
}
