import java.util.Objects;

public class Cast {
    private String fullName;
    private String role;

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return String.format("%s plays the role '%s'%n", fullName, role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        Cast that = (Cast) o;
        return role.equals(that.role);
    }
}