package repository.impl;

import model.Product;
import repository.BaseRepository;
import repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String INSERT_PRODUCT = "insert into product(`id_product`, `name_product`, `price`, `quantity`, `color`, `id_category`) values (?, ?, ?, ?, ?, ?);";

    private static String SELECT_ALL_PRODUCT = "SELECT * FROM product join category on product.id_category = category.id_category;";
    @Override
    public List<Product> getAllProduct() {
        Connection connection = baseRepository.getConnection();
        List<Product> productList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
                resultSet = preparedStatement.executeQuery();
                Product product;
                while (resultSet.next()) {
                    //lấy gía trị từ database để hiển thị list
                    product = new Product();


                    product.setProductId(resultSet.getInt("id_product"));
                    product.setProductName(resultSet.getString("name_product"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setQuantity(resultSet.getInt("quantity"));
                    product.setColor(resultSet.getString("color"));
                    product.setCategoryName(resultSet.getString("name_category"));


                    productList.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return productList;
    }

    @Override
    public void createProduct(Product product) {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                // lấy giá trị để tạo thêm mơi
                preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
                preparedStatement.setString(1,product.getProductName());
                preparedStatement.setDouble(2,product.getPrice());
                preparedStatement.setInt(3,product.getQuantity());
                preparedStatement.setString(4,product.getColor());
                preparedStatement.setInt(5,product.getCategoryID());


                preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public Product findByProduct(int id) {
        return null;
    }

    @Override
    public void updateProduct(int id, Product product) {

    }

    @Override
    public void deleteProduct(int id) {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("delete from `product` where id_product = ?");
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

}
