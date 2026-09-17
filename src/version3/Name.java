package version3;

import java.util.Locale;
import java.util.Objects;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this("", "", "", "");
    }

    public Name(String lastName, String firstName) {
        this(firstName, "", lastName, "");
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName == null ? "" : firstName;
        this.middleName = middleName == null ? "" : middleName;
        this.lastName = lastName == null ? "" : lastName;
        this.suffix = suffix == null ? "" : suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? "" : firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName == null ? "" : middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? "" : lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? "" : suffix;
    }

    public void displayName() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String middleInitial = middleName.isEmpty() ? "" : " " + middleName.charAt(0) + ".";
        String suffixText = suffix.isEmpty() ? "" : " " + suffix;
        return lastName + ", " + firstName + middleInitial + suffixText;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name other = (Name) obj;
        return firstName.equalsIgnoreCase(other.firstName)
                && middleName.equalsIgnoreCase(other.middleName)
                && lastName.equalsIgnoreCase(other.lastName)
                && suffix.equalsIgnoreCase(other.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                firstName.toLowerCase(Locale.ROOT),
                middleName.toLowerCase(Locale.ROOT),
                lastName.toLowerCase(Locale.ROOT),
                suffix.toLowerCase(Locale.ROOT));
    }

    @Override
    public Name clone() throws CloneNotSupportedException {
        return (Name) super.clone();
    }
}
