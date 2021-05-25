package model;

public abstract class Person implements Comparable<Person>{
    private int id;
    private String firstName, lastName;
    private int age;
    private String email, phone, sex;

    public Person() { }
    public Person(int id, String firstName, String lastName, int age, String email, String phone, String sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Person o) {
        if(this.lastName.compareTo(o.getLastName()) != 0)
            return this.lastName.compareTo(o.getLastName());
        if(this.firstName.compareTo(o.getFirstName()) != 0)
            return this.firstName.compareTo(o.getFirstName());
        if(this.id < o.getId())
            return -1;
        if(this.id == o.getId())
            return 0;
        return 1;
    }

    @Override
    public String toString() {
        return  "Nume: " + lastName + '\n' +
                "Prenume: " + firstName + '\n' +
                "Varsta: " + age + '\n' +
                "id: " + id + '\n';
    }
}
