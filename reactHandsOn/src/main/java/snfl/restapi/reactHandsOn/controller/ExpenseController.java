package snfl.restapi.reactHandsOn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import snfl.restapi.reactHandsOn.dto.ExpenseDTO;
import snfl.restapi.reactHandsOn.io.ExpenseResponse;
import snfl.restapi.reactHandsOn.service.ExpenseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;
/**
 * It will fetch the expenses from the database
 * @retun list
 * */
    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses(){
         log.info("GET /expenses called");
        //Call the service method
        List<ExpenseDTO> list =  expenseService.getAllExpenses();
        log.info("Printing the data from service {}", list);
        //Convert the Expense DTO to Expense Response
        List<ExpenseResponse> response = list.stream().map(expenseDTO -> mapToExpenseResponse(expenseDTO)).collect(Collectors.toList());
        //return the list/response
        return response;
    }
/**
 * Mapper method for converting expense dto object to expense response
 * */
    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {
        return modelMapper.map(expenseDTO, ExpenseResponse.class);
    }
}
