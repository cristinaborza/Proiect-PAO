package model;

public class Assistant extends Stuff{
    private boolean haveSuperiorStudies;

    public Assistant() {
        super();
    }
    public Assistant(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, int experience, boolean haveSuperiorStudies) {
        super(cnp, firstName, lastName, age, email, phone, sex, salary, experience);
        this.haveSuperiorStudies = haveSuperiorStudies;
    }

    public void setHaveSuperiorStudies(boolean haveSuperiorStudies) {
        this.haveSuperiorStudies = haveSuperiorStudies;
    }

    @Override
    public String toString() {
        if (this.haveSuperiorStudies)
            return super.toString() + "Asistent cu studii superioare\n";
        return super.toString() + "Asistent fara studii superioare\n";
    }
}
