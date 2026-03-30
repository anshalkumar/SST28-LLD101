import java.util.*;

public class Theatre {
    int id;
    String name;
    String city;
    List<Screen> screens;

    public Theatre(int id, String name, String city, List<Screen> screens) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.screens = screens;
    }
}
