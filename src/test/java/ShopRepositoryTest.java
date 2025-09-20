import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.AlreadyExistsException;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product lemonade = new Product(1, "Lemonade", 250);
    Product milk = new Product(2, "Milk", 50);
    Product tea = new Product(3, "Tea", 340);
    Product coffee = new Product(4, "Coffee", 740);


    @BeforeEach
    public void setup() {
        repo.add(lemonade);
        repo.add(milk);
        repo.add(tea);
        repo.add(coffee);
    }

    @Test
    public void shouldRemove() {
        Product[] expected = {lemonade, milk, coffee};
        repo.remove(3);
        Assertions.assertArrayEquals(expected, repo.findAll());

    }

    @Test
    public void shouldNotRemoveWithException() {
        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(5));
    }

    @Test
    public void shouldNotAddNewProductWithAlreadyExistsIdAndException() {
        Product chocolate = new Product(3, "Chocolate", 345);
        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.add(chocolate));
    }
}
