package ucr.ac.ecci.ci1322.tareaprogramada1;

import javax.persistence.*;

/**
 * This class is for testing annotations
 */
@Entity
@Table(name = "EMPLOYEE")
public class Class1 {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private float salary;

    @Column(name = "money")
    private double money;

    @Column(name = "luckyletter")
    private char luckyletter;

    public Class1() {}

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String first_name ) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String last_name ) {
        this.lastName = last_name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary( int salary ) {
        this.salary = salary;
    }
}


