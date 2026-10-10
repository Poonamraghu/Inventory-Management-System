package com.mannpatel.inventoryapi;

import com.mannpatel.inventoryapi.model.Product;
import com.mannpatel.inventoryapi.repository.ProductRepository;
import com.mannpatel.inventoryapi.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1L);
        product.setName("Samsung Galaxy S24");
        product.setCategory("Smartphones");
        product.setPrice(999.99);
        product.setStockQuantity(50);
    }

    @Test
    void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product));
        List<Product> products = productService.getAllProducts();
        assertEquals(1, products.size());
        assertEquals("Samsung Galaxy S24", products.get(0).getName());
    }

    @Test
    void testGetProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Optional<Product> found = productService.getProductById(1L);
        assertTrue(found.isPresent());
        assertEquals("Samsung Galaxy S24", found.get().getName());
    }

    @Test
    void testCreateProduct() {
        when(productRepository.save(product)).thenReturn(product);
        Product created = productService.createProduct(product);
        assertNotNull(created);
        assertEquals("Samsung Galaxy S24", created.getName());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);
        productService.deleteProduct(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetProductsByCategory() {
        when(productRepository.findByCategory("Smartphones")).thenReturn(Arrays.asList(product));
        List<Product> products = productService.getProductsByCategory("Smartphones");
        assertEquals(1, products.size());
        assertEquals("Smartphones", products.get(0).getCategory());
    }
}