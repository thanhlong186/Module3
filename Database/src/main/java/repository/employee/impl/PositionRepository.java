package repository.employee.impl;

import model.Position;
import model.ServiceType;
import repository.BaseRepository;
import repository.employee.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    private static final String SELECT_ALL_POSITION = "select * from position";
    @Override
    public List<Position> findAllPosition() {
        Connection connection = BaseRepository.getConnection();
        List<Position> positionList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if(connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int positionId = resultSet.getInt("position_id");
                    String positionName = resultSet.getString("position_name");
                    positionList.add(new Position(positionId, positionName));
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
        return positionList;
    }
}
