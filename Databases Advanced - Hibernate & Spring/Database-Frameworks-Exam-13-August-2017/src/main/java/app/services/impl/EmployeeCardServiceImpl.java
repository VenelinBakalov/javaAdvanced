package app.services.impl;

import app.constants.ResultMessages;
import app.entities.EmployeeCard;
import app.repositories.EmployeeCardRepository;
import app.services.api.EmployeeCardService;
import app.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private static final String EMPLOYEE_CARD = "Employee Card";

    @Autowired
    private EmployeeCardRepository employeeCardRepository;

    @Override
    public String add(EmployeeCard employeeCard) {
        String result;

        if (DataValidator.isValid(employeeCard) && ! cardExists(employeeCard)) {
            this.employeeCardRepository.save(employeeCard);
            result = String.format(ResultMessages.SUCCESSFUL,
                    EMPLOYEE_CARD,
                    employeeCard);
        } else {
            result = ResultMessages.ERROR;
        }

        return result;
    }

    @Override
    public List<EmployeeCard> findAllUnusedCards() {
        return employeeCardRepository.findAllUnusedCards();
    }

    private boolean cardExists(EmployeeCard employeeCard) {
        EmployeeCard duplicate = this.employeeCardRepository.findByNumber(employeeCard.getNumber());
        return duplicate != null;
    }

}
