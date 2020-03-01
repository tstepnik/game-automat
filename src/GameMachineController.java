import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class GameMachineController {

    private Scanner sc = new Scanner(System.in);
    private GameMachine machine = new GameMachine();

    public void gameShop() {
        System.out.println("What game do you want to buy?");
        try {
            String wantedGame = sc.nextLine();
            System.out.println("Pay:");
            double payment = sc.nextDouble();
            sc.nextLine();
            machine.buyGame(wantedGame, payment);
        } catch (NotEnoughtMoneyException | NoSuchGameException e) {
            System.err.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("You should write only numbers.");
        }
        sc.close();
    }
}
