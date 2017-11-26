package PO;

/**
 * Created by hp on 2017/11/21.
 */
public class Person {

    private String name;

    private String password;

    private String identity;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {

        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getIdentity() {
        return identity;
    }
}
