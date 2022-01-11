package MrScottAgility;
import MrScottAgility.Actions.AnitBanAction;
import MrScottAgility.Actions.VarrockRooftopSolver;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Map;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.SkillTracker;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.interactive.Player;

import java.awt.*;
import java.util.Random;

@ScriptManifest(
        category = Category.AGILITY,
        name = "MrScott Agility",
        author = "MrScott",
        version = 0.1
)
public class MainClass extends AbstractScript {
    public static Area _currentArea;

    @Override
    public void onStart(){
        log("Starting MrScott Agility Script!");
        SkillTracker.start(Skill.AGILITY);
    }

    @Override
    public void onExit() {
        log("Stopping MrScott Agility Script!");
        super.onExit();
    }

    @Override
    public int onLoop() {
        setCurrentArea();
        if(!getRandomManager().isSolving() && _currentArea != null) {
            log("We are inside the first if!");
            Random random = new Random();
            int chances = random.nextInt(10);
            if (chances > 6) {
                log("Running AntiBan");
                AnitBanAction.doRandomAntiBanAction();
            }
            VarrockRooftopSolver.solveVarrockRooftop();
        }
        return Calculations.random(940, 8615);
    }

    public static void setCurrentArea() {
        if (_currentArea == null) {
            Areas.setCurrentArea(Areas.VARROCK_ROOFTOP_START);
//            Tile currentTile = Players.localPlayer().getTile();
//            log(currentTile);
//            if(Areas.VARROCK_ROOFTOP_START.contains(currentTile)) {
//                log("Current area set to Varrock Rooftop");
//                Areas.setCurrentArea(Areas.VARROCK_ROOFTOP_START);
//            } else {
//                log("Not in any starting areas! Stop script and move your character to a proper starting area");
//                return;
//            }
        }
        _currentArea = Areas.getCurrentArea();
    }
}
