package MrScottAgility.Actions;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.dialogues.Dialogues;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;

import java.util.Random;

public class AnitBanAction {
    public static void doRandomAntiBanAction() {
        Random random = new Random();
        int chances = random.nextInt(800);
        if (chances < 100) {
            Skills.open();
            MethodProvider.sleep(100, 500);
            Skills.hoverSkill(ChoseRandomSkill());
            MethodProvider.sleep(1000, 1500);
        } else if(chances > 100 && chances < 200){
            Mouse.move();
        } else if(chances > 200 && chances < 220){
            Skills.open();
            MethodProvider.sleep(100, 500);
            Skills.hoverSkill(ChoseRandomSkill());
            MethodProvider.sleep(1000, 1500);
        } else if(chances > 330 && chances < 350){
            Mouse.moveMouseOutsideScreen();
            MethodProvider.sleep(2888, 5111);
            Mouse.isMouseInScreen();
        } else if(chances > 350 && chances < 355){
            Tabs.openWithMouse(getRandomTab());
            MethodProvider.sleep(200, 500);
        }
        if(Dialogues.canContinue()){
            Dialogues.clickContinue();
        }
    }

    public static void maybeMoveMouseOutsideScreen(){
        Random random = new Random();
        if(random.nextInt(Calculations.random(3, 20)) == 0) {
            if(random.nextInt(Calculations.random(2, 10)) == 0) {
                Mouse.moveMouseOutsideScreen();
            }
            MethodProvider.sleep(1000, 20000);
        }
    }

    private static Skill ChoseRandomSkill(){
        Skill[] Skills = new Skill[]{
                Skill.WOODCUTTING,
                Skill.FIREMAKING,
                Skill.AGILITY,
                Skill.ATTACK,
                Skill.COOKING
        };
        Random ran = new Random();
        return Skills[ran.nextInt(Skills.length - 1)];
    }
    public static Tab getRandomTab(){
        Tab[] Tabs = new Tab[]{
                Tab.FRIENDS,
                Tab.EMOTES,
                Tab.EQUIPMENT,
                Tab.QUEST,
                Tab.MUSIC,
                Tab.CLAN,
                Tab.OPTIONS,
                Tab.INVENTORY,
                Tab.PRAYER
        };
        Random ran = new Random();
        return Tabs[ran.nextInt(Tabs.length - 1)];
    }
}
