package org.meghraj.docker.samples.data;

import javax.persistence.*;

/**
 * Created by C840290 on 8/30/2018.
 *
 * @author Chandra Annavajjala (C840290)
 */
@Entity(name = "ACCOUNT")
@Table(name = "ACCOUNT")
public class Account {
    /**
     * Database primary key
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue //(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "first_name", unique = false, nullable = false)
    private String firstName;

    @Column(name = "last_name", unique = false, nullable = false)
    private String lastName;

    @Column(name = "email", unique = false, nullable = true)
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
