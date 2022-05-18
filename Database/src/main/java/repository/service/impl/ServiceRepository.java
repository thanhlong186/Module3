package repository.service.impl;

import model.Service;
import repository.BaseRepository;
import repository.service.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_SERVICE = "Select * from service join service_type on service.service_type_id = service_type.service_type_id join rent_type on service.rent_type_id = rent_type.rent_type_id;";
    private static final String INSERT_SERVICE = "insert into service (service_code, service_name, service_area, service_cost, service_max_people,\n" +
            "standard_room, description_other_convenience, pool_area, number_of_floor, rent_type_id, service_type_id) value (?,?,?,?,?,?,?,?,?,?,?);";


    @Override
    public List<Service> getAllService() {
        Connection connection = baseRepository.getConnection();
        List<Service> serviceList = new ArrayList<>();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
                resultSet = preparedStatement.executeQuery();
                Service service;
                while (resultSet.next()) {
                    service = new Service();
                    service.setServiceId(resultSet.getInt("service_id"));
                    service.setCode(resultSet.getString("service_code"));
                    service.setServiceName(resultSet.getString("service_name"));
                    service.setServiceArea(resultSet.getInt("service_area"));
                    service.setServiceCost(resultSet.getDouble("service_cost"));
                    service.setServiceMaxPeople(resultSet.getInt("service_max_people"));
                    service.setRentTypeName(resultSet.getString("rent_type_name"));
                    service.setServiceTypeName(resultSet.getString("service_type_name"));
                    service.setStandardRoom(resultSet.getString("standard_room"));
                    service.setDescriptionOtherConvenience(resultSet.getString("description_other_convenience"));
                    service.setPoolArea(resultSet.getDouble("pool_area"));
                    service.setNumberOfFloor(resultSet.getInt("number_of_floor"));

                    serviceList.add(service);


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
        return serviceList;
    }

    @Override
    public void createService(Service service) {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement;
        if (connection != null) {
            try{
                preparedStatement = connection.prepareStatement(INSERT_SERVICE);
                preparedStatement.setString(1,service.getCode());
                preparedStatement.setString(2, service.getServiceName());
                preparedStatement.setInt(3,service.getServiceArea());
                preparedStatement.setDouble(4,service.getServiceCost());
                preparedStatement.setInt(5,service.getServiceMaxPeople());
                preparedStatement.setString(6,service.getStandardRoom());
                preparedStatement.setString(7,service.getDescriptionOtherConvenience());
                preparedStatement.setDouble(8,service.getPoolArea());
                preparedStatement.setInt(9,service.getNumberOfFloor());
                preparedStatement.setInt(10,service.getRentTypeId());
                preparedStatement.setInt(11,service.getServiceTypeId());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try{
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
