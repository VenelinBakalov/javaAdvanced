package soft.uni.models.viewModels.game;

import soft.uni.entities.api.GameType;

import java.math.BigDecimal;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public class GameView implements GameType {

    private String title;
    private BigDecimal price;

    public GameView() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getTitle(), this.getPrice());
    }
}
