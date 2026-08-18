package com.cicdlabs.webform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Valida los datos ingresados en el formulario web de registro.
 */
public class FormValidator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$");

    private static final int MIN_USERNAME_LENGTH = 3;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 120;

    public List<String> validate(RegistrationForm form) {
        List<String> errors = new ArrayList<>();

        if (form.getUsername() == null || form.getUsername().trim().length() < MIN_USERNAME_LENGTH) {
            errors.add("El nombre de usuario debe tener al menos " + MIN_USERNAME_LENGTH + " caracteres.");
        }

        if (form.getEmail() == null || !EMAIL_PATTERN.matcher(form.getEmail()).matches()) {
            errors.add("El correo electrónico no tiene un formato válido.");
        }

        if (form.getPassword() == null || form.getPassword().length() < MIN_PASSWORD_LENGTH) {
            errors.add("La contraseña debe tener al menos " + MIN_PASSWORD_LENGTH + " caracteres.");
        }

        if (form.getAge() < MIN_AGE || form.getAge() > MAX_AGE) {
            errors.add("La edad debe estar entre " + MIN_AGE + " y " + MAX_AGE + " años.");
        }

        return Collections.unmodifiableList(errors);
    }

    public boolean isValid(RegistrationForm form) {
        return validate(form).isEmpty();
    }
}
