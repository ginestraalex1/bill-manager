package Tydek.billmanager.dto;

import lombok.Data;

@Data
public class Credentials {
    public String username;
    public String password;

    public Credentials() {

    }
    public Credentials(Credentials credentials){
        this.username = credentials.getUsername();
        this.password = credentials.getPassword();
    }
}
