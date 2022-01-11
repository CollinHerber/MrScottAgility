package MrScottAgility;

import org.dreambot.api.methods.map.Area;

public class Areas {
    public static Area _currentArea;
    public static final Area VARROCK_ROOFTOP_START = new Area(3221, 3417, 3221, 3411, 0);

    public static Area getCurrentArea() {
        return _currentArea;
    }

    public static void setCurrentArea(Area area) {
        _currentArea = area;
    }

    public static Area[] getAllAreas() {
        return new Area[]{
                VARROCK_ROOFTOP_START
        };
    }
}
