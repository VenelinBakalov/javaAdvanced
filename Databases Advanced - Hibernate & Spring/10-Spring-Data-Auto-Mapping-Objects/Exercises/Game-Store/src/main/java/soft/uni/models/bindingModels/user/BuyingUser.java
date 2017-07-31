package soft.uni.models.bindingModels.user;

import soft.uni.entities.api.UserType;
import soft.uni.enums.Role;
import soft.uni.models.bindingModels.game.BoughtGame;
import soft.uni.models.bindingModels.game.ShoppingCartGame;
import soft.uni.utils.ModelParser;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BuyingUser implements UserType {

    private Long id;
    private String email;
    private String password;
    private String fullName;
    private Role role;
    private Set<ShoppingCartGame> shoppingCartGames;
    private Set<BoughtGame> boughtGames;

    public BuyingUser() {
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

    public String buyGames() {

        if (this.shoppingCartGames.isEmpty()) {
            return "Your shopping cart is empty.";
        }
        for (ShoppingCartGame shoppingCartGame : this.shoppingCartGames) {
            BoughtGame boughtGame = ModelParser.getInstance().map(shoppingCartGame, BoughtGame.class);
            this.boughtGames.add(boughtGame);
        }

        String result = String.format("Successfully bought games:\n%s",
                this.shoppingCartGames.stream()
                        .map(g -> String.format("-%s", g.getTitle()))
                        .collect(Collectors.joining("\n")));

        this.shoppingCartGames.clear();

        return result;
    }
}
