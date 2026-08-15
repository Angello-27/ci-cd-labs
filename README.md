# ci-cd-labs

Repositorio para los laboratorios del módulo de CI/CD.

## Laboratorio 1 — Primer Pipeline de Integración Continua

Este repositorio contiene el primer pipeline del módulo, construido con **GitHub Actions**.

El pipeline se ejecuta automáticamente después de cada push y realiza lo siguiente:

- Muestra un mensaje de bienvenida.
- Muestra la fecha y hora de ejecución.
- Muestra la versión de Git instalada.
- Finaliza correctamente.

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
