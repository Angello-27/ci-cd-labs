package com.cicdlabs.webform;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FormValidatorTest {

    private final FormValidator validator = new FormValidator();

    @Test
    void formularioValidoNoGeneraErrores() {
        RegistrationForm form = new RegistrationForm("miguel", "miguel@example.com", "clave1234", 25);

        List<String> errores = validator.validate(form);

        assertTrue(errores.isEmpty());
        assertTrue(validator.isValid(form));
    }

    @Test
    void usuarioMuyCortoGeneraError() {
        RegistrationForm form = new RegistrationForm("ab", "miguel@example.com", "clave1234", 25);

        List<String> errores = validator.validate(form);

        assertEquals(1, errores.size());
        assertFalse(validator.isValid(form));
    }

    @Test
    void correoConFormatoInvalidoGeneraError() {
        RegistrationForm form = new RegistrationForm("miguel", "correo-invalido", "clave1234", 25);

        List<String> errores = validator.validate(form);

        assertEquals(1, errores.size());
    }

    @Test
    void contrasenaMuyCortaGeneraError() {
        RegistrationForm form = new RegistrationForm("miguel", "miguel@example.com", "123", 25);

        List<String> errores = validator.validate(form);

        assertEquals(1, errores.size());
    }

    @Test
    void edadFueraDeRangoGeneraError() {
        RegistrationForm form = new RegistrationForm("miguel", "miguel@example.com", "clave1234", 150);

        List<String> errores = validator.validate(form);

        assertEquals(1, errores.size());
    }

    @Test
    void formularioCompletamenteInvalidoAcumulaTodosLosErrores() {
        RegistrationForm form = new RegistrationForm("ab", "correo-invalido", "123", -5);

        List<String> errores = validator.validate(form);

        assertEquals(4, errores.size());
        assertFalse(validator.isValid(form));
    }
}
