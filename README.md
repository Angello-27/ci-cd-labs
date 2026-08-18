# ci-cd-labs

Repositorio para los laboratorios del módulo de CI/CD.

## Laboratorio 1 — Primer Pipeline de Integración Continua

Este repositorio contiene el primer pipeline del módulo, construido con **GitHub Actions**.

El pipeline se ejecuta automáticamente después de cada push y realiza lo siguiente:

- Muestra un mensaje de bienvenida.
- Muestra la fecha y hora de ejecución.
- Muestra la versión de Git instalada.
- Finaliza correctamente.

## Laboratorio 2 — Branching, Pull Requests y Ejecución de CI

En este laboratorio el flujo de trabajo evoluciona de un proceso basado únicamente
en push hacia un flujo colaborativo basado en ramas de funcionalidad y Pull Requests.

### Estrategia de branching

- `master` representa la versión principal del proyecto y está protegida.
- Cada cambio se desarrolla en una rama independiente con nombre descriptivo
  (por ejemplo, `feature/update-readme`).
- Los cambios se incorporan a `master` únicamente mediante Pull Request.

### Ejecución del pipeline

El pipeline ahora se ejecuta automáticamente en dos eventos:

- `push` a `master` o a ramas `feature/**`.
- `pull_request` con destino a `master`.

### Protección de la rama principal

La rama `master` cuenta con un ruleset activo que exige:

- Incorporar cambios únicamente mediante Pull Request.
- Que el check de CI **Hello CI** finalice exitosamente antes del merge.
- Bloqueo de force pushes y de eliminación de la rama.

## Laboratorio 3 — Integración de Pruebas Automatizadas al Pipeline

En este laboratorio se incorpora al pipeline un proyecto Java real (`webform`) que
valida los datos de un formulario web de registro, junto con su suite de pruebas
unitarias (JUnit 5) y reporte de cobertura de código (JaCoCo).

### Etapas del pipeline

El pipeline se amplía con dos jobs nuevos, además de `Hello CI`:

- **Build**: compila el proyecto con Maven (`mvn compile`).
- **Test**: se ejecuta únicamente si `Build` finaliza correctamente (`needs: build`).
  Corre las pruebas unitarias (`mvn test`), muestra el resumen de resultados en los
  registros y publica como artefactos descargables:
  - el reporte de ejecución de pruebas (`target/surefire-reports/`);
  - el reporte de cobertura de código (`target/site/jacoco/`).

### Quality Gate

Si alguna prueba unitaria falla, el job `Test` finaliza con error y el pipeline se
detiene en esa etapa, evitando que un cambio que no cumple con las validaciones
mínimas continúe el proceso de integración continua.

## Estructura

```
ci-cd-labs/
│
├── README.md
├── pom.xml
├── app/
│   └── hello.txt
├── src/
│   ├── main/java/com/cicdlabs/webform/
│   │   ├── RegistrationForm.java
│   │   └── FormValidator.java
│   └── test/java/com/cicdlabs/webform/
│       └── FormValidatorTest.java
└── .github/
    └── workflows/
        └── pipeline.yml
```
