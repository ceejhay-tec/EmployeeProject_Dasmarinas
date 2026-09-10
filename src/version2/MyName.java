package version2;

public class MyName {
    private String firstName;
    private String midName;
    private String lastName;
    private String suffix;

    public MyName() {
        this("N/A", "N/A", "N/A", "N/A");
    }

    public MyName(String firstName, String midName, String lastName, String suffix) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.suffix = suffix;
    }
}
