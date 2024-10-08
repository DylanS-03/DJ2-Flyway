package org.example.services;

import org.example.daos.DeliveryEmployeeDao;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.FailedToCreateException;
import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;
import org.example.exceptions.Entity;

import java.sql.SQLException;
import java.util.List;

public class DeliveryEmployeeService {

    DeliveryEmployeeDao deliveryEmployeeDao;

    public DeliveryEmployeeService(
            final DeliveryEmployeeDao deliveryEmployeeDao) {
        this.deliveryEmployeeDao = deliveryEmployeeDao;
    }
    public List<DeliveryEmployee> getAllDeliveryEmployees()
            throws SQLException {
        return deliveryEmployeeDao.getAllDeliveryEmployees();
    }

    public int createDeliveryEmployee(
            final DeliveryEmployeeRequest deliveryEmployeeRequest)
            throws FailedToCreateException,
            SQLException, DoesNotExistException {
        int id = deliveryEmployeeDao
                .createDeliveryEmployee(deliveryEmployeeRequest);

        if (id == -1) {
            throw new FailedToCreateException(Entity.DELIVERYEMPLOYEE);
        }
        return id;
    }


}
