package org.example.daos;

import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryEmployeeDao {

    public List<DeliveryEmployee> getAllDeliveryEmployees()
            throws SQLException {
        List<DeliveryEmployee> deliveryEmployees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM `DeliveryEmployees`;");

            while (resultSet.next()) {
                DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bank_acc"),
                        resultSet.getString("ni")
                );
                deliveryEmployees.add(deliveryEmployee);
            }
        }

        return deliveryEmployees;
    }

    public int createDeliveryEmployee(
            final DeliveryEmployeeRequest deliveryEmployeeRequest)
            throws SQLException {
        Connection c =
                DatabaseConnector.getConnection();
        String insertStatement =
                "INSERT INTO DeliveryEmployees "
                        + "(`name`, salary, bank_acc, ni) VALUES (?,?,?,?);";

        PreparedStatement st =
                c.prepareStatement(
                        insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, deliveryEmployeeRequest.getName());
        st.setDouble(2, deliveryEmployeeRequest.getSalary());
        st.setString(2 + 1, deliveryEmployeeRequest.getBankAccount());
        st.setString(2 + 2, deliveryEmployeeRequest.getnI());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return -1;

    }
}
