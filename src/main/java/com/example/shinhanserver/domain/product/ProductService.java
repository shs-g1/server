package com.example.shinhanserver.domain.product;

import com.example.shinhanserver.domain.entity.Product;
import com.example.shinhanserver.domain.pbinfo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService{

  private final ProductRepository productRepository;

  public Product findProductById(Long productId) {
    if (productId == null) {
      return null;
    }
    return productRepository.findById(productId).orElse(null);
  }

}
