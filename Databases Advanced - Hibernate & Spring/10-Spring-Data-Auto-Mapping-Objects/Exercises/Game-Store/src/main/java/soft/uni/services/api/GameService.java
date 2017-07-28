package soft.uni.services.api;

import soft.uni.models.bindingModels.game.AddGame;
import soft.uni.models.bindingModels.game.DeleteGame;
import soft.uni.models.bindingModels.game.EditGame;
import soft.uni.models.viewModels.game.GameDetailsView;
import soft.uni.models.viewModels.game.GameView;
import soft.uni.models.viewModels.game.OwnedGameView;

import java.util.List;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public interface GameService {

    void persist(AddGame addGame);
    void persist(EditGame editGame);
    List<GameView> getAll();
    <T> T findById(Long id, Class<T> gameType);
    void delete(DeleteGame deleteGame);
    GameDetailsView findByTitle(String title);
    List<OwnedGameView> findOwnedByUser(Long id);

}
