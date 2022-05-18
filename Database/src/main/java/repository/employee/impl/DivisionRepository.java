package repository.employee.impl;

import model.Division;
import model.EducationDegree;
import repository.BaseRepository;
import repository.employee.IDivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    private static final String SELECT_ALL_DIVISION = "select * from division";
    @Override
    public List<Division> findAllDivision() {
        Connection connection = BaseRepository.getConnection();
        List<Division> divisionList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if(connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int divisionId = resultSet.getInt("division_id");
                    String divisionName = resultSet.getString("division_name");
                    divisionList.add(new Division(divisionId, divisionName));
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
        return divisionList;
    }
}
