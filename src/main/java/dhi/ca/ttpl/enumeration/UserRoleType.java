package dhi.ca.ttpl.enumeration;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
public enum UserRoleType {
    Administrator(1, "Administrator");


    private final Integer value;
    private final String text;

    UserRoleType(Integer value, String text) {
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
