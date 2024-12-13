package menu.view;

import static menu.utils.ErrorMessage.ERROR;

import java.util.List;
import menu.model.Restaurant;

public class OutputView {
    private final String GUIDE_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private final String RECOMMENDED_MENU_MESSAGE = "메뉴 추천 결과 입니다.";
    private final String RECOMMENDED_MENU = "[%s | %s | %s | %s | %s | %s]\n";

    public void guideMessage() {
        System.out.println(GUIDE_MESSAGE);
    }

    public void errorMessage(String message) {
        System.out.print(ERROR);
        System.out.println(message);
        System.out.println();
    }

    public void printMenu(List<Restaurant> restaurants) {
        printMenuMessage();
        for (Restaurant restaurant : restaurants) {
            System.out.printf(RECOMMENDED_MENU
                    , restaurant.getMenus().get(0)
                    , restaurant.getMenus().get(1)
                    , restaurant.getMenus().get(2)
                    , restaurant.getMenus().get(3)
                    , restaurant.getMenus().get(4)
                    , restaurant.getMenus().get(5));
        }

        System.out.println("\n추천을 완료했습니다.");
    }

    private void printMenuMessage() {
        System.out.println(RECOMMENDED_MENU_MESSAGE);
        System.out.printf(RECOMMENDED_MENU, "구분", "월요일", "화요일", "수요일", "목요일", "금요일");
    }
}
