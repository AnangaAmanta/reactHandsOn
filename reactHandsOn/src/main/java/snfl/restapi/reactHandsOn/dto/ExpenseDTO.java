package snfl.restapi.reactHandsOn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseDTO {

    private String expenseId;
    private String name;
    private String note;
    private String category;
    private Date ExpDate;
    private BigDecimal amount;
    private Timestamp createdAt;
    private Timestamp updateAt;
}
