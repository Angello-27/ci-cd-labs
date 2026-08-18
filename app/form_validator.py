"""Validador de un formulario de registro sencillo."""

import re

EMAIL_PATTERN = re.compile(r"^[\w.+-]+@[\w-]+\.[a-zA-Z]{2,}$")

MIN_USERNAME_LENGTH = 3
MIN_PASSWORD_LENGTH = 8
MIN_AGE = 0
MAX_AGE = 120


def validate_form(username, email, password, age):
    """Devuelve la lista de errores encontrados en los datos del formulario."""
    errors = []

    if not username or len(username.strip()) < MIN_USERNAME_LENGTH:
        errors.append(f"El nombre de usuario debe tener al menos {MIN_USERNAME_LENGTH} caracteres.")

    if not email or not EMAIL_PATTERN.match(email):
        errors.append("El correo electrónico no tiene un formato válido.")

    if not password or len(password) < MIN_PASSWORD_LENGTH:
        errors.append(f"La contraseña debe tener al menos {MIN_PASSWORD_LENGTH} caracteres.")

    if age < MIN_AGE or age > MAX_AGE:
        errors.append(f"La edad debe estar entre {MIN_AGE} y {MAX_AGE} años.")

    return errors


def is_valid(username, email, password, age):
    """Indica si el formulario no contiene errores."""
    return len(validate_form(username, email, password, age)) == 0
