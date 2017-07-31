package soft.uni.models.viewModels.game;

import soft.uni.entities.api.GameType;

/**
 * Created by Venelin on 28.7.2017 г..
 */
public class OwnedGameView implements GameType {

    private String title;

    public OwnedGameView() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
