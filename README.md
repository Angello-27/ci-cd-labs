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

## Estructura

```
ci-cd-labs/
│
├── README.md
├── app/
│   └── hello.txt
└── .github/
    └── workflows/
        └── pipeline.yml
```
