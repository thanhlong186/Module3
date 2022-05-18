package repository.employee.impl;

import model.EducationDegree;
import model.Position;
import repository.BaseRepository;
import repository.employee.IEducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    private static final String SELECT_ALL_EDUCATION_DEGREE = "select * from education_degree";

    @Override
    public List<EducationDegree> findAllEducation() {
            Connection connection = BaseRepository.getConnection();
            List<EducationDegree> educationDegreeList = new ArrayList<>();
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;
            if(connection != null) {
                try {
                    preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREE);
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        int educationDegreeId = resultSet.getInt("education_degree_id");
                        String educationDegreeName = resultSet.getString("education_degree_name");
                        educationDegreeList.add(new EducationDegree(educationDegreeId, educationDegreeName));
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
            return educationDegreeList;
    }
}
