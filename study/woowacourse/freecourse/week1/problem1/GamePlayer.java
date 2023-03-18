package freecourse.week1.problem1;

import java.util.List;

public class GamePlayer {

    private final List<Integer> pages;
    private final PageValidator pageValidator;

    public GamePlayer(List<Integer> pages) {
        pageValidator = new PageValidator();
        pageValidator.validate(pages);
        this.pages = pages;
    }

    public List<Integer> getPages() {
        return pages;
    }
}
