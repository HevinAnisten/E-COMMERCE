package e_commerce_application.Address;


import e_commerce_application.Users.Users;
import jakarta.persistence.*;
import lombok.*;
import e_commerce_application.Enum.Address_Type;

@Entity
@Data  // Getters and Setters
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(nullable = false)
    private String unitNo;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private String landmark;

    @Column(nullable = false)
    private String postalCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Address_Type address_type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Transient
    private int user_id;


}
