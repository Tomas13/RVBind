package ru.startandroid.rvbind;

/**
 * Created by zhangali on 26.12.16.
 */
public class User {
    private String name;
    private String surname;

    public User(String name, String surname){
        this.name = name;
        this.surname = surname;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
