package LLD.EASY.TaskManagement;

import java.util.UUID;

public class USER {

    private String id;
    private String name;
    private String Email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public USER(String id , String name , String Email){
        this.id = id;
        this.name = name;
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "USER{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

}
