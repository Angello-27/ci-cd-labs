import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1] / "app"))

from form_validator import is_valid, validate_form


def test_formulario_valido_no_genera_errores():
    errores = validate_form("miguel", "miguel@example.com", "clave1234", 25)

    assert errores == []
    assert is_valid("miguel", "miguel@example.com", "clave1234", 25)


def test_usuario_muy_corto_genera_error():
    errores = validate_form("ab", "miguel@example.com", "clave1234", 25)

    assert len(errores) == 1


def test_correo_con_formato_invalido_genera_error():
    errores = validate_form("miguel", "correo-invalido", "clave1234", 25)

    assert len(errores) == 1


def test_contrasena_muy_corta_genera_error():
    errores = validate_form("miguel", "miguel@example.com", "123", 25)

    assert len(errores) == 1


def test_edad_fuera_de_rango_genera_error():
    errores = validate_form("miguel", "miguel@example.com", "clave1234", 150)

    assert len(errores) == 1


def test_formulario_completamente_invalido_acumula_todos_los_errores():
    errores = validate_form("ab", "correo-invalido", "123", -5)

    assert len(errores) == 4
    assert not is_valid("ab", "correo-invalido", "123", -5)
