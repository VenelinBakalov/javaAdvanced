package soft.uni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soft.uni.entities.Game;
import soft.uni.models.bindingModels.game.AddGame;
import soft.uni.models.bindingModels.game.EditGame;
import soft.uni.models.viewModels.game.GameView;
import soft.uni.repositories.GameRepository;
import soft.uni.services.api.GameService;
import soft.uni.utils.ModelParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 27.7.2017 г..
 */
@Service
@Transactional
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void persist(AddGame addGame) {
        Game game = ModelParser.getInstance().map(addGame, Game.class);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public void persist(EditGame editGame) {
        Game game = ModelParser.getInstance().map(editGame, Game.class);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public List<GameView> getAll() {
        List<Game> games = this.gameRepository.findAll();
        List<GameView> gameViews = new ArrayList<>();

        for (Game game : games) {
            GameView gameView = ModelParser.getInstance().map(game, GameView.class);
            gameViews.add(gameView);
        }

        return gameViews;
    }

    @Override
    public EditGame findById(Long id) {
        Game game = this.gameRepository.findOne(id);
        return ModelParser.getInstance().map(game, EditGame.class);
    }
}
