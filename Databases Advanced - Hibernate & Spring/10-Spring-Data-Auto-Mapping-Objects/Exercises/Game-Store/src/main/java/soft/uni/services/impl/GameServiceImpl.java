package soft.uni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soft.uni.entities.Game;
import soft.uni.entities.api.GameType;
import soft.uni.models.bindingModels.game.AddGame;
import soft.uni.models.bindingModels.game.DeleteGame;
import soft.uni.models.bindingModels.game.EditGame;
import soft.uni.models.viewModels.game.GameDetailsView;
import soft.uni.models.viewModels.game.GameView;
import soft.uni.models.viewModels.game.OwnedGameView;
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
    public <T extends GameType> void persist(T gameToPersist) {
        Game game = ModelParser.getInstance().map(gameToPersist, Game.class);
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
    public <T extends GameType> T findById(Long id, Class<T> gameType) {
        Game game = this.gameRepository.findOne(id);
        if (game == null) return null;
        return ModelParser.getInstance().map(game, gameType);
    }

    @Override
    public void delete(DeleteGame deleteGame) {
        Game game = ModelParser.getInstance().map(deleteGame, Game.class);
        this.gameRepository.delete(game);
    }

    @Override
    public <T extends GameType> T findByTitle(String title, Class<T> gameType) {
        Game game = this.gameRepository.findByTitle(title);
        if (game == null) return null;
        return ModelParser.getInstance().map(game, gameType);
    }

    @Override
    public List<OwnedGameView> findOwnedByUser(Long id) {
        List<Game> games = this.gameRepository.findOwnedByUser(id);
        List<OwnedGameView> ownedGames = new ArrayList<>();

        for (Game game : games) {
            OwnedGameView ownedGameView = ModelParser.getInstance().map(game, OwnedGameView.class);
            ownedGames.add(ownedGameView);
        }
        return ownedGames;
    }


}
