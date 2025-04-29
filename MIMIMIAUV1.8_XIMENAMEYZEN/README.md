# Proyecto: Mimimiau

**Mimimiau** es un juego de simulación en Java donde los jugadores gestionan un acogedor catcafé. Dentro de Mimimiau te encargarás de tareas como atender clientes y cuidar gatos. Combina actividades interactivas, desafíos y minijuegos.

| Detalle             | Información         |
| ------------------- | ------------------- |
| **Autor**           | Ximena Meyzen        |
| **Fecha de inicio** | 20/04/2025           |
| **Última revisión** | v1.8 - 29/04/2025    |

---

## Contenido del Proyecto

- **Versión 1.8 (`Mimimiau.java`)**: Incluye minijuegos para atender clientes y cuidar gatos, formando un sistema completo de simulación del catcafé.

---

## Estructura del Proyecto

```plaintext
MIMIMIAU_V1.8_XIMENA_MEYZEN/
├── .vscode/               # Configuraciones de VSCode
│   └── settings.json
├── bin/                   # Clases compiladas
├── lib/                   # Librerías externas
│   ├── Mimimiau_v1.8_XimenaMeyzen.jar   # Archivo ejecutable del juego
│   └── mysql-connector-j-8.0.33.jar     # Driver para conexión MySQL
├── files/                 # Archivos externos y persistencia de datos
│   ├── mimimiau.sql       # Script de creación de la base de datos
│   └── partidas.txt       # Historial de partidas guardadas (se crea si no existe)
├── src/                   # Código fuente
│   ├── basedatos/
│   │   ├── ConexionBD.java
│   │   └── PartidaBD.java
│   ├── ficheros/
│   │   └── PartidaFichero.java
│   ├── juego/
│   │   ├── Juego.java
│   │   └── minijuegos/
│   │       ├── MinijuegoAtenderClientes.java
│   │       └── MinijuegoCuidarGatos.java
│   ├── modelo/
│   │   ├── Jugador.java
│   │   ├── Partida.java
│   │   └── gatos/
│   │       ├── Gato.java
│   │       ├── GatoMaineCoon.java
│   │       ├── GatoPersa.java
│   │       └── GatoSiames.java
│   └── utilidades/
│       ├── Colores.java
│       └── Lector.java
├── README.md              # Este archivo
└── Mimimiau.java          # Clase principal del proyecto
```

---

## Requisitos del Sistema

- **Java Development Kit (JDK)** versión 21 o superior.
- Entorno de desarrollo recomendado: **Visual Studio Code**.
- **MySQL** para la base de datos (opcional, si deseas probar el guardado en base de datos).

---

## Instrucciones de Ejecución

### 1. Verificar Java instalado

```bash
java -version
```

Debes ver una versión de Java 21 o superior.

---

### 2. Clonar el repositorio

Puedes descargar el proyecto ejecutando:

```bash
git clone https://github.com/xmeyzzzenx/Mimimiau.git
```

Luego, navega al directorio del proyecto:

```bash
cd Mimimiau
```

---

### 3. Ejecutar el juego

Ubica el archivo `.jar` dentro de la carpeta `lib/` y ejecuta:

```bash
java -jar lib/Mimimiau_v1.8_XimenaMeyzen.jar
```

---

## Funcionalidades Principales

- **Gestión del Catcafé**:
  - Realiza tareas clave como cuidar gatos y atender clientes.

- **Minijuego: Atender Clientes**:
  - Escribe los pedidos correctamente dentro del límite de tiempo.

- **Minijuego: Cuidar Gatos**:
  - Alimenta, juega y deja dormir a los gatos para cumplir misiones.

- **Sistema de puntos y monedas**:
  - Gana recompensas por cada tarea o desafío cumplido.

- **Interacción amigable**:
  - Uso de colores y mensajes claros.

- **Persistencia de partidas**:
  - Las partidas se guardan automáticamente en la base de datos y en archivos de texto.

---

## Notas Finales

**Mimimiau** es un proyecto académico que demuestra:

- **Organización y estructura profesional** de código Java.
- **Control de errores** y entradas de usuario robustas.
- **Documentación** clara y limpia en todas las clases.
- **Diseño modular**, fácil de mantener y escalar.

---
