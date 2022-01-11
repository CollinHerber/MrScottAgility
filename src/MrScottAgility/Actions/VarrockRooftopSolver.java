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
        solveEigthStep();
        solveNinthStep();
    }

    private static void solveFirstStep() {
        RooftopAgilityActions.ClimbRoughWall();
        waitForPeriod(1500);
    }

    private static void solveSecondStep() {
        RooftopAgilityActions.CrossClothesLines();
        waitForPeriod(3500);
    }

    private static void solveThirdStep() {
        RooftopAgilityActions.LeapGap();
        waitForPeriod(2680);
    }

    private static void solveFourthStep() {
        RooftopAgilityActions.BalanceWall();
        waitForPeriod(15000);
        MethodProvider.sleep(1987, 3500);
    }

    private static void solveFifthStep() {
        RooftopAgilityActions.LeapGap();
        waitForPeriod(5000);
    }

    private static void solveSixthStep() {
        RooftopAgilityActions.LeapGap(14834);
        waitForPeriod(5000);
    }

    private static void solveSeventhStep() {
        RooftopAgilityActions.LeapGap(14835);
        waitForPeriod(5000);
        MethodProvider.sleep(1987, 3500);
    }

    private static void solveEigthStep() {
        RooftopAgilityActions.HurdleLedge();
        waitForPeriod(5000);
    }

    private static void solveNinthStep() {
        RooftopAgilityActions.JumpOffEdge();
        waitForPeriod(5000);
    }

    private static void waitForPeriod(int timeout) {
        sleepUntil(() -> !Players.localPlayer().isAnimating(), timeout);
        MethodProvider.sleep(250, 1000);
    }
}