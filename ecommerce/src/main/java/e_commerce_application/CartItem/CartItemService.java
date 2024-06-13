package e_commerce_application.CartItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public Optional<CartItem> getCartItemById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId);
    }

    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem updateCartItem(Long cartItemId, CartItem cartItemDetails) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(() -> new IllegalArgumentException("Cart item not found for this id :: " + cartItemId));
        cartItem.setUnitPrice(cartItemDetails.getUnitPrice());
        cartItem.setQuantity(cartItemDetails.getQuantity());
        cartItem.setGstAmount(cartItemDetails.getGstAmount());
        cartItem.setItemTotal(cartItemDetails.getItemTotal());
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

}
