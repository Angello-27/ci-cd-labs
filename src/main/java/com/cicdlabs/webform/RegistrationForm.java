package com.cicdlabs.webform;

/**
 * Datos capturados por el formulario web de registro.
 */
public class RegistrationForm {

    private final String username;
    private final String email;
    private final String password;
    private final int age;

    public RegistrationForm(String username, String email, String password, int age) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }
}
