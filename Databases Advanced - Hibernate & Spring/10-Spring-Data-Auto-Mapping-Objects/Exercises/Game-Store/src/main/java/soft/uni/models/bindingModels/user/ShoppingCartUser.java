package soft.uni.models.bindingModels.user;

import soft.uni.entities.api.UserType;
import soft.uni.enums.Role;
import soft.uni.models.bindingModels.game.BoughtGame;
import soft.uni.models.bindingModels.game.ShoppingCartGame;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class ShoppingCartUser implements UserType {

    private Long id;
    private String email;
    private String password;
    private String fullName;
    private Role role;
    private Set<ShoppingCartGame> shoppingCartGames;
    private Set<BoughtGame> boughtGames;

    public ShoppingCartUser() {
        this.shoppingCartGames = new HashSet<>();
        this.boughtGames = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<ShoppingCartGame> getShoppingCartGames() {
        return shoppingCartGames;
    }

    public void setShoppingCartGames(Set<ShoppingCartGame> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }

    public Set<BoughtGame> getBoughtGames() {
        return boughtGames;
    }

    public void setBoughtGames(Set<BoughtGame> boughtGames) {
        this.boughtGames = boughtGames;
    }

    public String addGame(ShoppingCartGame shoppingCartGame) {

        for (ShoppingCartGame cartGame : this.shoppingCartGames) {
            if (cartGame.getTitle().equalsIgnoreCase(shoppingCartGame.getTitle())) {
                return String.format("%s already in shopping cart", shoppingCartGame.getTitle());
            }
        }

        for (BoughtGame boughtGame : this.boughtGames) {
            if (boughtGame.getTitle().equalsIgnoreCase(shoppingCartGame.getTitle())) {
                return String.format("You already own %s", shoppingCartGame.getTitle());
            }
        }

        this.shoppingCartGames.add(shoppingCartGame);

        return String.format("%s added to cart.", shoppingCartGame.getTitle());
    }

    public String removeGame(ShoppingCartGame shoppingCartGame) {
        Iterator<ShoppingCartGame> iterator = this.shoppingCartGames.iterator();

        while (iterator.hasNext()) {
            ShoppingCartGame currentGame = iterator.next();

            if (Objects.equals(currentGame.getId(), shoppingCartGame.getId())) {
                this.shoppingCartGames.remove(currentGame);

                return String.format("%s removed from cart.", shoppingCartGame.getTitle());
            }
        }

        return String.format("%s is not present in your shopping cart.", shoppingCartGame.getTitle());

//        if (! this.shoppingCartGames.contains(shoppingCartGame)) {
//            return String.format("%s is not present in your shopping cart.", shoppingCartGame.getTitle());
//        }
//
//        this.shoppingCartGames.remove(shoppingCartGame);

    }

}
