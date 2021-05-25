package model;

public abstract class Stuff extends Person{
    private int salary, experience;

    public Stuff() {
        super();
    }

    public Stuff(int id, String firstName, String lastName, int age, String email, String phone, String sex, int salary, int experience) {
        super(id, firstName, lastName, age, email, phone, sex);
        this.salary = salary;
        this.experience = experience;
    }

    public Stuff(String firstName, String lastName, int age, String email, String phone, String sex, int salary, int experience) {
        super(firstName, lastName, age, email, phone, sex);
        this.salary = salary;
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Salary: " + salary + '\n' +
                "Experience: " + experience + "ani\n";
    }
}
