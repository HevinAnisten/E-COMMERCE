package e_commerce_application.Category;

import e_commerce_application.Enum.Category_Type;
import e_commerce_application.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private Category_Type category_type;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
