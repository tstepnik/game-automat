import java.util.ArrayList;
import java.util.List;

public class GameMachine {

    private List<Game> games = List.of(
            new Game("Warcraft III", 60),
            new Game("Diablo II", 80),
            new Game("Starcraft", 35)
    );

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Game getGame(String gameName) throws NotSuchGameException {
        for (Game game : games) {
            if (game.getName().equals(gameName)) {
                return game;
            }
        }
        throw new NotSuchGameException("Podanej gry nie ma w magazynie");
    }

    public double paidForGame(double payment, Game game) throws NotEnoughtMoneyException {
        if (game.getPrice() <= payment) {
            return payment - game.getPrice();
        }
        throw new NotEnoughtMoneyException("Gra kosztuję " + game.getPrice() + " Ty wpłaciłeś tylko " + payment);
    }
}