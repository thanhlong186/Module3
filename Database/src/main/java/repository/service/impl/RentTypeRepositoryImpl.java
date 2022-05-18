package repository.service.impl;

import model.RentType;
import model.ServiceType;
import repository.BaseRepository;
import repository.service.IRentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements IRentTypeRepository {
    private static final String SELECT_ALL_RENT_TYPE = "select * from rent_type";
    @Override
    public List<RentType> findRentAll() {
        Connection connection = BaseRepository.getConnection();
        List<RentType> rentTypeList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if(connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_TYPE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int rentTypeId = resultSet.getInt("rent_type_id");
                    String rentTypeName = resultSet.getString("rent_type_name");

                    rentTypeList.add(new RentType(rentTypeId, rentTypeName));
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
        return rentTypeList;
    }
    }

