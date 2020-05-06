package _02java中级._07JDBC尝试_尚硅谷._06dao.ORM;

import java.sql.Date;

/**
 * @author TrueNine
 * @version 1.0
 * @date 2020/4/30
 */
public class Customer {


    private int id;
    private String name;
    private String email;
    private Date birth;
    private Object photo;

    public Customer() {

    }

    public Customer(int id, String name, String email, Date birth, Object photo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.photo = photo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            return this.id == id;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth + '\'' +
                ", photo=" + photo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public Object getPhoto() {
        return this.photo;
    }
}
