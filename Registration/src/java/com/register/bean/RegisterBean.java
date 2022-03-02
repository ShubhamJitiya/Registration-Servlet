
package com.register.bean;

public class RegisterBean {
    String name;
    String email;
    String pass;

    public RegisterBean(String name, String email, String pass) {
        super();
        this.name = name;
        this.email = email;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
    
}
