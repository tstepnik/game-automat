import java.util.Optional;
import java.util.Scanner;

public class GameMachineController {

    private Scanner sc = new Scanner(System.in);
    private GameMachine machine = new GameMachine();

    public void GameShop() {

        System.out.println("Give game's name which you want buy:");
        String wantedGame = sc.nextLine();
        System.out.println("Pay:");
        double payment = sc.nextDouble();
        sc.nextLine();

        try {
            Game game = machine.getGame(wantedGame);
            double rest = machine.paidForGame(payment, game);
            System.out.println("Odbierz grę " + game.getName());
            System.out.println("Odbierz resztę " + rest);
        } catch (NotSuchGameException e) {
            System.err.println(e.getMessage());
        } catch (NotEnoughtMoneyException e) {
            System.err.println(e.getMessage());
        }
    }
}
