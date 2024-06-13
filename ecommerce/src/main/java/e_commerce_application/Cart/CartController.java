package e_commerce_application.Cart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")

public class CartController {

        private CartService cartService;

        @GetMapping
        public List<Cart> getAllCarts() {
            return cartService.getAllCarts();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Cart> getCartById(@PathVariable(value = "id") Long cartId) {
            Optional<Cart> cart = cartService.getCartById(cartId);
            return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public Cart createCart(@RequestBody Cart cart) {
            return cartService.createCart(cart);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Cart> updateCart(@PathVariable(value = "id") Long cartId, @RequestBody Cart cartDetails) {
            return ResponseEntity.ok(cartService.updateCart(cartId, cartDetails));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCart(@PathVariable(value = "id") Long cartId) {
            cartService.deleteCart(cartId);
            return ResponseEntity.noContent().build();
        }
}
