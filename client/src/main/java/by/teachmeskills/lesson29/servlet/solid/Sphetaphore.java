package by.teachmeskills.lesson29.servlet.solid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Sphetaphore {

    RED("red", false),
    YELLOW("yellow", false),
    GREEN("green", true);

    private final String color;
    private final boolean allowCrossRoad;

    public void checkAndInform() {
        System.out.println((!allowCrossRoad ? "Don't " : "") + "cross road");
    }
}
