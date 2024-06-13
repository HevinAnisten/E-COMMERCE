package e_commerce_application.Payment;

import e_commerce_application.Order.Order;
import e_commerce_application.Users.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import e_commerce_application.Enum.Payment_Status;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data


public class Payment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long paymentId;

        private String transactionId;
        private String paymentMethod;
        private BigDecimal amount;
        private LocalDateTime timestamp;


        @ManyToOne
        @JoinColumn(name = "order_id")
        private Order order;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private Users user;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Payment_Status payment_status;

        // Getters and Setters
}
