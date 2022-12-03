package com.example.eataway;

import com.example.eataway.model.entity.Item;
import com.example.eataway.model.entity.Menu;
import com.example.eataway.model.entity.Restaurant;
import com.example.eataway.repository.ItemRepository;
import com.example.eataway.repository.MenuRepository;
import com.example.eataway.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class AppInit implements CommandLineRunner {
    private final ItemRepository itemRepository;
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public AppInit(ItemRepository itemRepository, MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.itemRepository = itemRepository;
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.itemRepository.count() == 0 && this.restaurantRepository.count() == 0 && this.menuRepository.count() == 0) {
            initDb();
        }
        Restaurant heartAttack = this.restaurantRepository.findByName("Heart Attack").get().setDescription("You don't mind consuming extra calories? Well, you're at the right place! Our restaurant offers the most delicious fast food in town.");
        Restaurant healthyStop = this.restaurantRepository.findByName("Healthy Stop").get().setDescription("We believe a well balanced diet is essential to your well-being. Don't hesitate to visit us and eat something delicious and healthy at the same time.");
        this.restaurantRepository.save(healthyStop);
        this.restaurantRepository.save(heartAttack);
    }

    private void initDb() {
        List<Item> items = List.of(new Item().setName("Fries").setQuantity(300), new Item().setName("Burger").setQuantity(450),
                new Item().setName("Sprite").setQuantity(500), new Item().setName("Pizza").setQuantity(400),
                new Item().setName("Fanta").setQuantity(500), new Item().setName("Fried chicken").setQuantity(500),
                new Item().setName("Spaghetti").setQuantity(450), new Item().setName("Steamed vegetables").setQuantity(450),
                new Item().setName("Water").setQuantity(500), new Item().setName("Scrambled eggs").setQuantity(300),
                new Item().setName("Fried rice").setQuantity(450), new Item().setName("Orange juice").setQuantity(400),
                new Item().setName("Apple juice").setQuantity(400), new Item().setName("Mashed potatoes").setQuantity(350));

        this.itemRepository.saveAll(items);

        List<Restaurant> restaurants = List.of(new Restaurant().setName("Heart Attack").setAddress("Lake Street 35"),
                new Restaurant().setName("Healthy Stop").setAddress("Apple Street 4"));

        this.restaurantRepository.saveAll(restaurants);

        List<Menu> menus = List.of(new Menu()
                        .setName("Fries and Sprite")
                        .setDescription("Crispy fries with cheese accompanied by Sprite drink")
                        .setPrice(4.00)
                        .setItems(Set.of(
                                this.itemRepository.findByName("Fries").get(),
                                this.itemRepository.findByName("Sprite").get()
                        ))
                        .setRestaurant(this.restaurantRepository.findByName("Heart Attack").get()),
                new Menu()
                        .setName("Vegetables with apple juice")
                        .setDescription("Steamed vegetables with freshly squeezed apple juice")
                        .setPrice(3.50)
                        .setItems(Set.of(
                                this.itemRepository.findByName("Steamed vegetables").get(),
                                this.itemRepository.findByName("Apple juice").get()
                        ))
                        .setRestaurant(this.restaurantRepository.findByName("Healthy stop").get())
        );

        this.menuRepository.saveAll(menus);
    }
}
