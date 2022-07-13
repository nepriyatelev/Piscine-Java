package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsRepositoryJdbcImplTest {
    private DataSource dataSource;
    private final String DELETE = "drop table product";
    @BeforeEach
    public void init() {
        dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
    }

    @AfterEach
    public void deletingDB() {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e); //TODO надо писать в консоль
        }
    }
    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(0L, "product1", 10),
            new Product(1L, "product2", 20),
            new Product(2L, "product3", 30),
            new Product(3L, "product4", 40),
            new Product(4L, "product5", 50),
            new Product(5L, "product6", 60),
            new Product(6L, "product7", 70),
            new Product(7L, "product8", 80),
            new Product(8L, "product9", 90),
            new Product(9L, "product10", 100));
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(8L, "product9", 90);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(0L, "product1", 20);

    final Product SAVE_PRODUCT = new Product("kek", 1001120);
    final Product EXPECTED_SAVE_PRODUCT = new Product(10L, "kek", 1001120);

    @Test
    void findAll() {
        assertEquals(EXPECTED_FIND_ALL_PRODUCTS, new ProductsRepositoryJdbcImpl(dataSource).findAll());
    }

    @Test
    void findById() {
        assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, new ProductsRepositoryJdbcImpl(dataSource).findById(8L).get());
    }

    @Test
    void update() {
        ProductsRepositoryJdbcImpl productsRepositoryJdbc = new ProductsRepositoryJdbcImpl(dataSource);
        productsRepositoryJdbc.update(EXPECTED_UPDATED_PRODUCT);
        assertEquals(EXPECTED_UPDATED_PRODUCT, productsRepositoryJdbc.findById(0L).get());
    }

    @Test
    void save() {
        ProductsRepositoryJdbcImpl productsRepositoryJdbc = new ProductsRepositoryJdbcImpl(dataSource);
        productsRepositoryJdbc.save(SAVE_PRODUCT);
        assertEquals(EXPECTED_SAVE_PRODUCT, productsRepositoryJdbc.findById(10L).get());
    }

    @Test
    void delete() {
        ProductsRepositoryJdbcImpl productsRepositoryJdbc = new ProductsRepositoryJdbcImpl(dataSource);
        productsRepositoryJdbc.delete(0L);
        assertFalse(productsRepositoryJdbc.findById(0L).isPresent());
    }
}