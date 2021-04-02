package Model;

public class Assistant extends Stuff{
    private boolean haveSuperiorStudies;

    public Assistant(String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, int experience, boolean haveSuperiorStudies) {
        super(firstName, lastName, age, email, phone, sex, salary, experience);
        this.haveSuperiorStudies = haveSuperiorStudies;
    }

    public boolean isHaveSuperiorStudies() {
        return haveSuperiorStudies;
    }

    public void setHaveSuperiorStudies(boolean haveSuperiorStudies) {
        this.haveSuperiorStudies = haveSuperiorStudies;
    }
}
