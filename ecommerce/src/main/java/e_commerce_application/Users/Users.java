package e_commerce_application.Users;

import e_commerce_application.Address.Address;
import e_commerce_application.Cart.Cart;
import e_commerce_application.Order.Order;
import e_commerce_application.Product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import e_commerce_application.Enum.User_Type;
@Entity
@Data // Getters and Setters
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String mobileNumber;
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private User_Type user_type;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Product> products;


}
