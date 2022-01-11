package MrScottAgility.Actions;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.item.GroundItems;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.items.GroundItem;

import static org.dreambot.api.methods.MethodProvider.log;
import static org.dreambot.api.methods.MethodProvider.sleepUntil;

public class ObstacleActions {
    private static void PreObstacleChecks(GameObject obj) {
        GrabMarkOfGrace();
        WalkCheck(obj);
    }

    private static GameObject GetObstacle(String objName) {
        return GameObjects.closest(objName);
    }

    private static GameObject GetObstacle(int objId) {
        return GameObjects.closest(objId);
    }

    public static void HandleObstacle(String objName, String interactOption) {
        DoObstacle(GetObstacle(objName), interactOption);
    }

    public static void HandleObstacle(int objectId, String interactOption) {
        DoObstacle(GetObstacle(objectId), interactOption);
    }

    private static void DoObstacle(GameObject obj, String interactOption) {
        PreObstacleChecks(obj);
        if (obj != null) {
            if (obj.interact(interactOption)) {
                sleepUntil(() -> Players.localPlayer().getTile() == obj.getTile(), 6000);
            } else {
                MethodProvider.sleep(250, 1000);
                DoObstacle(obj, interactOption);
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
