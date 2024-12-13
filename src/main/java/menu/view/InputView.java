package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_COACH = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private final String CANT_EAT_MENU = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public String inputCoach() {
        System.out.println(INPUT_COACH);
        return Console.readLine();
    }

    public String cantEat(String name) {
        System.out.printf(CANT_EAT_MENU, name);
        return Console.readLine();
    }
}
