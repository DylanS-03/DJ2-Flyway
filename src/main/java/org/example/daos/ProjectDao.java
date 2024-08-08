package org.example.daos;

import org.example.models.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {

    public List<Project> getAllProjects()
            throws SQLException {
        List<Project> projectList = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM `Projects`;");

            while (resultSet.next()) {
                Project project = new Project(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("value"),
                        resultSet.getInt("clientID"),
                        resultSet.getBoolean("completed")
                );
                projectList.add(project);
            }
        }

        return projectList;
    }
}

