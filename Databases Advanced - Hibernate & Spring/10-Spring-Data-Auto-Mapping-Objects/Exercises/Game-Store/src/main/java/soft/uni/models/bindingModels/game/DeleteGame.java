package soft.uni.models.bindingModels.game;

import soft.uni.entities.api.GameType;

/**
 * Created by Venelin on 28.7.2017 г..
 */
public class DeleteGame  implements GameType {

    private Long id;
    private String title;

    public DeleteGame() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
