package repository.impl;

import model.Category;
import repository.BaseRepository;
import repository.ICategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private static String SELECT_ALL_CATEGORY = "SELECT * FROM category";


        @Override
        public List<Category> findAll() {
            Connection connection = BaseRepository.getConnection();
            List<Category> categoryList = new ArrayList<>();
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;

            if(connection != null) {
                try {
                    preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int categoryId = resultSet.getInt("id_category");
                        String categoryName = resultSet.getString("name_category");
                        categoryList.add(new Category(categoryId, categoryName));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
            return categoryList;
        }
    }

