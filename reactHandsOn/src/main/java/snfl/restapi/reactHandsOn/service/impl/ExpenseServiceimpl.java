package snfl.restapi.reactHandsOn.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import snfl.restapi.reactHandsOn.dto.ExpenseDTO;
import snfl.restapi.reactHandsOn.entity.ExpenseEntity;
import snfl.restapi.reactHandsOn.repository.ExpenseRepository;
import snfl.restapi.reactHandsOn.service.ExpenseService;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceimpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<ExpenseDTO> getAllExpenses() {
        //Call the repository  method
        List<ExpenseEntity> list = expenseRepository.findAll();
        log.info("Printing the data from the respository {}",list);
        //Convert the Entity Object to DTO Object
        List<ExpenseDTO> listOfExpenses  = list.stream().map(expenseEntity -> mapToExpenseDTO(expenseEntity)).collect(Collectors.toList());
        //Return the list
        log.info("Successfull getAllExpenses");
        return listOfExpenses;

    }

    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }

}
