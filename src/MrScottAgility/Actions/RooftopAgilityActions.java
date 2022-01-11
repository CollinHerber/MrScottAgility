package MrScottAgility.Actions;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.items.GroundItem;

import static org.dreambot.api.methods.MethodProvider.log;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;

public class RooftopAgilityActions {
    private static void PreObstacleChecks(GameObject obj) {
        GrabMarkOfGrace();
        WalkCheck(obj);
    }
    public static void LeapGap() {
        HandleObstacle("Gap", "leap");
    }

    public static void LeapGap(int objectId) {
        HandleObstacle(objectId, "leap");
    }

    public static void BalanceWall() {
        HandleObstacle("Wall", "Balance");
    }

    public static void CrossClothesLines() {
        HandleObstacle("Clothes Line", "cross");
    }

    public static void HurdleLedge() {
        HandleObstacle("Ledge", "hurdle");
    }

    public static void JumpOffEdge() {
        HandleObstacle("Edge", "jump-off");
    }

    public static void ClimbRoughWall() {
        HandleObstacle("Rough Wall", "Climb");
    }

    private static GameObject GetObstacle(String objName) {
        return GameObjects.closest(objName);
    }

    private static GameObject GetObstacle(int objId) {
        return GameObjects.closest(objId);
    }

    private static void HandleObstacle(String objName, String interactOption) {
        DoObstacle(GetObstacle(objName), interactOption);
    }

    private static void HandleObstacle(int objectId, String interactOption) {
        DoObstacle(GetObstacle(objectId), interactOption);
    }

    private static void DoObstacle(GameObject obj, String interactOption) {
        PreObstacleChecks(obj);
        if (obj != null) {
            if (obj.interact(interactOption)) {
                sleepUntil(() -> Players.localPlayer().getTile() == obj.getTile(), 8000);
            } else {
                MethodProvider.sleep(250, 1000);
                BalanceWall();
            }
        } else {
            log("No Obstacle Found. Failing!");
        }
    }

    private static void WalkCheck(GameObject obj) {
        if (Players.localPlayer().getTile().distance(obj.getTile()) > 20) {
            WalkAction.walkToArea(obj.getSurroundingArea(2));
            sleepUntil(() -> obj.getSurroundingArea(3).contains(Players.localPlayer().getTile()), 5000);
        }
    }

    private static void GrabMarkOfGrace() {
        GroundItem obj = GroundItems.closest("Mark of grace");
        if (obj != null) {
            obj.interact("Take");
            MethodProvider.sleep(250, 1000);
        }
    }
}
