package snfl.restapi.reactHandsOn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snfl.restapi.reactHandsOn.entity.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {


}
