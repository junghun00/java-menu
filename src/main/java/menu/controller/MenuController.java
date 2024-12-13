package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.model.Coach;
import menu.model.Restaurant;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private MenuService menuService;
    private InputView inputView;
    private OutputView outputView;

    public MenuController(MenuService menuService, InputView inputView, OutputView outputView) {
        this.menuService = menuService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> names = inputCoachName();
        List<Coach> coaches = createCoaches(names);
        menuRecommendation(coaches);
    }

    private void menuRecommendation(List<Coach> coaches) {
        List<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant(menuService.randomCategories()));

        for (Coach coach : coaches) {
            restaurants.add(new Restaurant(menuService.randomMenus(coach, restaurants.getFirst().getMenus())));
        }
        outputView.printMenu(restaurants);
    }

    private List<Coach> createCoaches(List<String> names) {
        List<Coach> coaches = new ArrayList<>();

        for (String name : names) {
            List<String> cantEat = inputCatEat(name);
            coaches.add(new Coach(name, cantEat));
        }

        return coaches;
    }

    private List<String> inputCoachName() {
        outputView.guideMessage();

        while (true) {
            try {
                String input = inputView.inputCoach();
                List<String> names = Arrays.asList(input.split(","));
                menuService.validateName(names);
                return names;
            } catch (IllegalArgumentException e) {
                outputView.errorMessage(e.getMessage());
            }
        }
    }

    private List<String> inputCatEat(String name) {
        while (true) {
            try {
                String input = inputView.cantEat(name);
                List<String> cantEat = Arrays.asList(input.split(","));
                menuService.validateCantEatSize(cantEat);
                return cantEat;
            } catch (IllegalArgumentException e) {
                outputView.errorMessage(e.getMessage());
            }
        }
    }
}
