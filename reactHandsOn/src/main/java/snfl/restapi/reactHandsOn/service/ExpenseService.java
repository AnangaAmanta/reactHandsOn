package snfl.restapi.reactHandsOn.service;

import snfl.restapi.reactHandsOn.dto.ExpenseDTO;

import java.util.List;
/**
 * Service interface for Expense Module
 * @author AAmanta
 * */
public interface ExpenseService {
    /**
     * It will fetch the expenses from the database
     * @return list
     * */
    List<ExpenseDTO> getAllExpenses();
}
