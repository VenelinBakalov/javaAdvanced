package soft.uni.services.api;

import soft.uni.models.bindingModels.game.AddGame;
import soft.uni.models.bindingModels.game.EditGame;
import soft.uni.models.viewModels.game.GameView;

import java.util.List;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public interface GameService {

    void persist(AddGame addGame);
    void persist(EditGame editGame);
    List<GameView> getAll();
    EditGame findById(Long id);
}
