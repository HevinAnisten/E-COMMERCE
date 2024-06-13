package e_commerce_application.Order;

import e_commerce_application.Users.Users;
import e_commerce_application.OrderItem.OrderItem;
import e_commerce_application.Payment.Payment;
import jakarta.persistence.*;
import lombok.*;
import e_commerce_application.Enum.Order_Status;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String orderToken;
    private String status;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "order")
    private List<Payment> payments;

    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private Order_Status order_status;
}
