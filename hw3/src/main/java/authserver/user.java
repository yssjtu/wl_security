package authserver;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

@Entity
public class user {

    @Id
    private String username;

    private String password;
    protected  user(){}
    public user(String username,String password){
        this.username=username;
        this.password=password;
    }


    public void setPassword(String password) {
        this.password=password;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
