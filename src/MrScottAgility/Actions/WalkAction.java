package MrScottAgility.Actions;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.walking.impl.Walking;

import java.util.Random;

public class WalkAction {
    public static void walkToArea(Area Selectedarea){
        Walking.walk(Selectedarea.getRandomTile());
        Random random = new Random();
        int chances = random.nextInt(80);
        if(Walking.getRunEnergy() >= chances + 20){
            if(!(Walking.isRunEnabled())){
                Walking.toggleRun();
            }
        }

        MethodProvider.sleep(100, 300);
    }
}
