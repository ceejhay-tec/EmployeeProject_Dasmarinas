package version2;

public class MyName {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    private String isMid = middleName.isEmpty()? "" : " " + middleName;
    private String isSuf = suffix.isEmpty()? "" : " " + suffix;

    public MyName() {
        this("N/A", "N/A", "N/A", "");
    }

    public MyName(String firstName, String lastName) {
        this(firstName, "N/A", lastName, "");
    }

    public MyName(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public MyName(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void displayName(){
        System.out.println(lastName + ", " + firstName + " " + (isMid.charAt(0)) + ". " + isSuf + ".");
    }

    @Override
    public String toString() {
        return lastName + ", "
                 + firstName + " "
                 + (isMid.charAt(0)) + ". "
                 + isSuf ;
    }
}
