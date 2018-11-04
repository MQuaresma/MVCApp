package GestAcademicaApp;

import java.util.HashMap;
import java.util.Map;

public class Menus {
    Map<Integer, Menu> menus;

    public Menus() {
        this.menus = new HashMap<Integer, Menu>();
    }

    public void addMenu(int index, Menu newMenu){
        this.menus.put(index, newMenu);
    }

    public Menu getMenu(int index){
        return this.menus.get(index);
    }
}
