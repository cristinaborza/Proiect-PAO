package Model;

public abstract class Person implements Comparable<Person>{
    private String firstName, lastName;
    private int age;
    private String email, phone;
    private boolean sex;

    @Override
    public int compareTo(Person o) {
        if(this.lastName.compareTo(o.getLastName()) != 0)
            return this.lastName.compareTo(o.getLastName());
        return this.firstName.compareTo(o.getFirstName());
    }

    public Person(String firstName, String lastName, int age, String email, String phone, boolean sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
