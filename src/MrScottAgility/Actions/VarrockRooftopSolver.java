package MrScottAgility.Actions;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.interactive.Players;

import static org.dreambot.api.methods.MethodProvider.sleepUntil;

public class VarrockRooftopSolver {
    public static void solveVarrockRooftop() {
        solveFirstStep();
        solveSecondStep();
        solveThirdStep();
        solveFourthStep();
        solveFifthStep();
        solveSixthStep();
        solveSeventhStep();
        solveEighthStep();
        solveNinthStep();
    }

    private static void solveFirstStep() {
        ObstacleActions.HandleObstacle("Rough Wall", "Climb");
        waitForPeriod(1500);
    }

    private static void solveSecondStep() {
        ObstacleActions.HandleObstacle("Clothes Line", "cross");
        waitForPeriod(3500);
    }

    private static void solveThirdStep() {
        ObstacleActions.HandleObstacle("Gap", "leap");
        waitForPeriod(2680);
    }

    private static void solveFourthStep() {
        ObstacleActions.HandleObstacle("Wall", "Balance");
        waitForPeriod(15000);
        MethodProvider.sleep(1987, 3500);
    }

    private static void solveFifthStep() {
        ObstacleActions.HandleObstacle("Gap", "leap");
        waitForPeriod(3000);
    }

    private static void solveSixthStep() {
        ObstacleActions.HandleObstacle(14834, "leap");
        waitForPeriod(4000);
    }

    private static void solveSeventhStep() {
        ObstacleActions.HandleObstacle(14835, "leap");
        waitForPeriod(4000);
        MethodProvider.sleep(987, 3100);
    }

    private static void solveEighthStep() {
        ObstacleActions.HandleObstacle("Ledge", "hurdle");
        waitForPeriod(4000);
    }

    private static void solveNinthStep() {
        ObstacleActions.HandleObstacle("Edge", "jump-off");
        waitForPeriod(4000);
    }

    private static void waitForPeriod(int timeout) {
        sleepUntil(() -> !Players.localPlayer().isAnimating(), timeout);
        AnitBanAction.maybeMoveMouseOutsideScreen();
        MethodProvider.sleep(250, 1000);
    }
}
