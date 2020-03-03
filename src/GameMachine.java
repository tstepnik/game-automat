import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameMachine {

    private List<Game> games = List.of(
            new Game("Warcraft III", 60),
            new Game("Diablo II", 80),
            new Game("Starcraft", 35)
    );

    public void buyGame(String gameName, double payment) throws NoSuchGameException, NotEnoughtMoneyException {
        Game foundGame = games.stream()
                .filter(game -> game.getName().equals(gameName))
                .findFirst()
                .orElseThrow(() -> new NoSuchGameException("There is no game with this title."));
        if (foundGame.getPrice() <= payment) {
            System.out.println("Collect game " + foundGame.getName());
            System.out.println("Collect the rest " + (payment - foundGame.getPrice()));
        } else {
            throw new NotEnoughtMoneyException("Game costs " + foundGame.getPrice() + " You ante only: " + payment);
        }
    }
}