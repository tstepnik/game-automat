import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameMachine {

    private List<Game> games = List.of(
            new Game("Warcraft III", 60),
            new Game("Diablo II", 80),
            new Game("Starcraft", 35)
    );

    void buyGame(String gameName, double payment) throws NoSuchGameException, NotEnoughtMoneyException {
        Optional<Game> foundGame = games.stream()
                .filter(game -> game.getName().equals(gameName))
                .findFirst();
        if (foundGame.isEmpty()) {
            throw new NoSuchGameException("There is no game with this title.");

        } else {
            Game game = foundGame.get();
            if (game.getPrice() <= payment) {
                System.out.println("Collect game " + game.getName());
                System.out.println("Collect the rest " + (payment-game.getPrice()));
            } else {
                throw new NotEnoughtMoneyException("Game costs " + game.getPrice() + " You ante only: " + payment);
            }
        }
    }
}