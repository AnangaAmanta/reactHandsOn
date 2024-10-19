package snfl.restapi.reactHandsOn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
@Entity
@Table(name = "SNFL_EXPENSES_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseEntity {

    @Id
    @SequenceGenerator(initialValue=1, name="id_expense", sequenceName="id_expense", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_expense")
    private Long IdExp;

    @Column(unique = true)
    private String expenseId;
    private String name;
    private String note;
    private String category;
    private Date ExpDate;
    private BigDecimal amount;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updateAt;
}
