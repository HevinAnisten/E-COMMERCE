package e_commerce_application.Cart;

import e_commerce_application.Users.Users;
import e_commerce_application.CartItem.CartItem;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private BigDecimal total;
    private BigDecimal gstAmount;
    private BigDecimal finalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;
}
