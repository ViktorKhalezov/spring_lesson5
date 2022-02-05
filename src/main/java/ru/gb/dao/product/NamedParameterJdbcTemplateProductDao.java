package ru.gb.dao.product;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

//@Component
@RequiredArgsConstructor
public class NamedParameterJdbcTemplateProductDao implements ProductDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM product";
        return namedParameterJdbcTemplate.query(sql, (rs, rn) ->
                Product.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .cost(rs.getBigDecimal("cost"))
                .date(rs.getDate("manufacture_date").toLocalDate())
                        .manufacturerId(rs.getLong("manufacturer_id"))
                .build());
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT p.id, title, cost, manufacture_date, manufacturer_id, name AS manufacturer_name FROM product p\n" +
                "JOIN manufacturer m ON p.manufacturer_id = m.id\n" +
                "WHERE p.id = :productId";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, new ProductMapper());
    }

    @Override
    public String findTitleById(Long id) {
        String sql = "SELECT title FROM product WHERE id = :productId";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    private static class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Product.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("title"))
                    .cost(rs.getBigDecimal("cost"))
                    .date(rs.getDate("manufacture_date").toLocalDate())
                    .manufacturerId(rs.getLong("manufacturer_id"))
                    .manfacturerName(rs.getString("manufacturer_name"))
                    .build();
        }

    }


}
