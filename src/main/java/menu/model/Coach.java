package menu.model;

import static menu.utils.ErrorMessage.CANT_EAT_MAX_NUM;
import static menu.utils.ErrorMessage.COACH_MAX_NUM;
import static menu.utils.ErrorMessage.COACH_MIN_NUM;
import static menu.utils.ErrorMessage.NAME_MAX_NUM;
import static menu.utils.ErrorMessage.NAME_MIN_NUM;

import java.util.List;

public class Coach {
    private final String name;
    private final List<String> nonEat;

    public Coach(String name, List<String> nonEat) {
        this.name = name;
        this.nonEat = nonEat;
    }

    public static void checkNameLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(NAME_MIN_NUM);
        }

        if (name.length() >  5) {
            throw new IllegalArgumentException(NAME_MAX_NUM);
        }
    }

    public static void checkCoachLength(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException(COACH_MIN_NUM);
        }

        if (names.size() > 5) {
            throw new IllegalArgumentException(COACH_MAX_NUM);
        }
    }

    public static void checkCantEatSize(List<String> nonEat) {
        if (nonEat.size() > 2) {
            throw new IllegalArgumentException(CANT_EAT_MAX_NUM);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getNonEat() {
        return nonEat;
    }
}
