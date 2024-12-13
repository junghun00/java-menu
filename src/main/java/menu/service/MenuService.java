package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.model.Categories;
import menu.model.Coach;
import menu.utils.Randoms;

public class MenuService {
    public void validateName(List<String> names) {
        for (String name : names) {
            Coach.checkNameLength(name);
        }
        Coach.checkCoachLength(names);
    }

    public void validateCantEatSize(List<String> catEat) {
        Coach.checkCantEatSize(catEat);
    }

    public List<String> randomMenus(Coach coach, List<String> category) {
        List<String> menus = new ArrayList<>();

        menus.add(coach.getName());
        for (int i = 1; i <= 5; i++) {
            Categories categories = Categories.findCategory(category.get(i));
            menus.add(Randoms.getMenu(categories.getFoods()));
        }

        return menus;
    }

    public List<String> randomCategories() {
        List<String> categories = new ArrayList<>();

        categories.add("카테고리");
        for (int i = 0; i < 5; i++) {
            categories.add(randomCategory());
        }

        return categories;
    }

    public String randomCategory() {
        return Categories.getCategory(Randoms.getCategory()).getCategory();
    }
}

