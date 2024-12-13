package menu.model;

import java.util.List;

public class Restaurant {
    private final List<String> menus;

    public Restaurant(List<String> menus) {
        this.menus = menus;
    }

    public List<String> getMenus() {
        return menus;
    }
}
