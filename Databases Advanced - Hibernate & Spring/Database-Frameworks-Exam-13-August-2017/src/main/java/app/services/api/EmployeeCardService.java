package app.services.api;

import app.entities.EmployeeCard;

import java.util.List;

public interface EmployeeCardService {

    String add(EmployeeCard employeeCard);
    List<EmployeeCard> findAllUnusedCards();

}
