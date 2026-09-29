package version6;

public final class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name(String lastName, String firstName) {
        this(firstName, "", lastName, "");
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        validateRequiredName(firstName);
        validateRequiredName(lastName);
        this.firstName = firstName;
        this.middleName = requireOptionalValue(middleName, "Middle name cannot be null");
        this.lastName = lastName;
        this.suffix = requireOptionalValue(suffix, "Suffix cannot be null");
    }

    private static void validateRequiredName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
    }

    private static String requireOptionalValue(String value, String message) {
        if (value == null) {
            throw new NullPointerException(message);
        }
        return value;
    }

    public final String getFirstName() { return firstName; }

    public final void setFirstName(String firstName) {
        validateRequiredName(firstName);
        this.firstName = firstName;
    }

    public final String getMiddleName() { return middleName; }

    public final void setMiddleName(String middleName) {
        this.middleName = requireOptionalValue(middleName, "Middle name cannot be null");
    }

    public final String getLastName() { return lastName; }

    public final void setLastName(String lastName) {
        validateRequiredName(lastName);
        this.lastName = lastName;
    }

    public final String getSuffix() { return suffix; }

    public final void setSuffix(String suffix) {
        this.suffix = requireOptionalValue(suffix, "Suffix cannot be null");
    }

    @Override
    public String toString() {
        String middleInitial = middleName.isEmpty() ? "" : " " + middleName.charAt(0) + ".";
        String suffixText = suffix.isEmpty() ? "" : " " + suffix;
        return lastName + ", " + firstName + middleInitial + suffixText;
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new AssertionError(exception);
        }
    }
}
