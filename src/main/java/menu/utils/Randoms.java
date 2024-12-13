package menu.utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;

public class Randoms {
    public static int getCategory() {
        return pickNumberInRange(1, 5) - 1;
    }

    public static String getMenu(List<String> menus) {
        return camp.nextstep.edu.missionutils.Randoms.shuffle(menus).get(0);
    }
}
