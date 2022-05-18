package repository.service.impl;

import model.CustomerType;
import model.ServiceType;
import repository.BaseRepository;
import repository.customer.ICustomerTypeRepository;
import repository.service.IServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements IServiceTypeRepository {

    private static final String SELECT_ALL_SERVICE_TYPE = "select * from service_type";

    @Override
    public List<ServiceType> findAll() {
        Connection connection = BaseRepository.getConnection();
        List<ServiceType> serviceTypeList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if(connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String serviceTypeName = resultSet.getString("service_type_name");
                    serviceTypeList.add(new ServiceType(serviceTypeId, serviceTypeName));
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
        return serviceTypeList;
    }
}