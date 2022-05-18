package repository.customer.impl;

import model.Customer;
import model.Service;
import repository.BaseRepository;
import repository.customer.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String INSERT_CUSTOMER = "insert into casestudy_jsp.`customer`(`customer_code`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static String SELECT_ALL_CUSTOMER = "SELECT * FROM casestudy_jsp.customer join customer_type on customer.customer_type_id = customer_type.customer_type_id;";
    private static String UPDATE_CUSTOMER = "update customer set customer_code = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ?, customer_type_id = ? where customer_id = ?;";
    private static String SELECT_CUSTOMER_BY_ID ="SELECT * FROM customer \n" +
            "JOIN customer_type ON customer.customer_type_id = customer_type.customer_type_id WHERE customer_id = ? ;";
    private static String SEARCH_CUSTOMER = "select * from customer join  customer_type ON customer.customer_type_id = customer_type.customer_type_id where customer_name like ?;";


    @Override
    public List<Customer> getAllCustomer() {
        Connection connection = baseRepository.getConnection();
        List<Customer> customerList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = preparedStatement.executeQuery();
                Customer customer;
                while (resultSet.next()) {
                        //lấy gía trị từ database để hiển thị list
                    customer = new Customer();
                    customer.setCustomerID(resultSet.getInt("customer_id"));
                    customer.setCustomerCode(resultSet.getString("customer_code"));
                    customer.setCustomerTypeName(resultSet.getString("customer_type_Name"));
                    customer.setCustomerName(resultSet.getString("customer_name"));
                    customer.setCustomerBirthday(resultSet.getString("customer_birthday"));
                    customer.setCustomerGender(resultSet.getBoolean("customer_gender"));
                    customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                    customer.setCustomerPhone(resultSet.getString("customer_phone"));
                    customer.setCustomerEmail(resultSet.getString("customer_email"));
                    customer.setCustomerAddress(resultSet.getString("customer_address"));
                    customerList.add(customer);
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
        return customerList;
    }

    @Override
    public void createCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                // lấy giá trị để tạo thêm mơi
                preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
                preparedStatement.setString(1,customer.getCustomerCode());
                preparedStatement.setString(2,customer.getCustomerName());
                preparedStatement.setString(3,customer.getCustomerBirthday());
                preparedStatement.setBoolean(4,customer.getCustomerGender());
                preparedStatement.setString(5,customer.getCustomerIdCard());
                preparedStatement.setString(6,customer.getCustomerPhone());
                preparedStatement.setString(7,customer.getCustomerEmail());
                preparedStatement.setString(8,customer.getCustomerAddress());
                preparedStatement.setInt(9,customer.getCustomerTypeId());

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
    public Customer findByCustomer(int id) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idCus = resultSet.getInt("customer_id");
                    String code = resultSet.getString("customer_code");
                    String name = resultSet.getString("customer_name");
                    String birthday = resultSet.getString("customer_birthday");
                    boolean gender = resultSet.getBoolean("customer_gender");
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    int cusTypeId = resultSet.getInt("customer_type_id");
                    String cusTypeName = resultSet.getString("customer_type_name");
                    customer = new Customer(idCus, code, name, birthday, gender, idCard, phone, email, address, cusTypeId, cusTypeName);

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
        return customer;
    }


    @Override
    public void updateCustomer(int id, Customer customer) {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement =  null;
        if (connection != null) {
            try {
                //lấy giá trị từ DB để
                preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
                preparedStatement.setString(1, customer.getCustomerCode());
                preparedStatement.setString(2, customer.getCustomerName());
                preparedStatement.setString(3, customer.getCustomerBirthday());
                preparedStatement.setBoolean(4, customer.getCustomerGender());
                preparedStatement.setString(5, customer.getCustomerIdCard());
                preparedStatement.setString(6, customer.getCustomerPhone());
                preparedStatement.setString(7, customer.getCustomerEmail());
                preparedStatement.setString(8, customer.getCustomerAddress());
                preparedStatement.setInt(9, customer.getCustomerTypeId());
                preparedStatement.setInt(10, id); // ko dc sua id.
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteCustomer(int id) {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("delete from `customer` where customer_id = ?");
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

    @Override
    public List<Customer> searchCustomer(String name) {
        Connection connection = BaseRepository.getConnection();
        List<Customer> customerList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try{
            Customer customer;
            preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER);
            preparedStatement.setString(1, "%"+name+"%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerID(resultSet.getInt("customer_id"));
                customer.setCustomerCode(resultSet.getString("customer_code"));
                customer.setCustomerTypeName(resultSet.getString("customer_type_Name"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getString("customer_birthday"));
                customer.setCustomerGender(resultSet.getBoolean("customer_gender"));
                customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }


}

