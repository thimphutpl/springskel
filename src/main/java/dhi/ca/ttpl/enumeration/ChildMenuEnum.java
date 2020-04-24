package dhi.ca.ttpl.enumeration;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
public enum ChildMenuEnum {
    USER_CREATION(1, "User Creation"),
    USER_ACCESS_PERMISSION_SETUP(2, "User Access Permission");

    private final Integer value;
    private final String text;

    ChildMenuEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
