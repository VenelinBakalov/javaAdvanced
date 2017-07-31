package soft.uni.services.api;

import soft.uni.entities.api.GameType;
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


    <T extends GameType> void persist(T gameToPersist);
    List<GameView> getAll();
    <T extends GameType> T findById(Long id, Class<T> gameType);
    void delete(DeleteGame deleteGame);

    <T extends GameType> T findByTitle(String title, Class<T> gameType);

    List<OwnedGameView> findOwnedByUser(Long id);

}
