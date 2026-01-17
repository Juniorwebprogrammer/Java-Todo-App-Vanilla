<div align="center">

# ✨ JavaPoo TODO

<img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 21"/>
<img src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL"/>
<img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" alt="Maven"/>
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker"/>
<img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white" alt="JWT"/>

---

**Gestor de tareas por consola con autenticación segura**

*Un proyecto moderno que demuestra arquitectura limpia, seguridad robusta y buenas prácticas en Java*

[Características](#-características) •
[Arquitectura](#-arquitectura) •
[Instalación](#-instalación) •
[Uso](#-uso) •
[Tecnologías](#%EF%B8%8F-stack-tecnológico)

</div>

---

## 🎯 Características

<table>
<tr>
<td width="50%">

### 🔐 Autenticación Segura
- Registro e inicio de sesión de usuarios
- Contraseñas hasheadas con **BCrypt**
- Tokens **JWT** para sesiones seguras
- Validación de credenciales

</td>
<td width="50%">

### 📋 Gestión de Tareas
- Crear nuevas tareas
- Listar tareas del usuario
- Marcar tareas como completadas
- Eliminar tareas

</td>
</tr>
<tr>
<td width="50%">

### 🏗️ Arquitectura Limpia
- Separación de responsabilidades
- Patrón Repository
- Capas bien definidas
- Código mantenible

</td>
<td width="50%">

### 🐳 Containerización
- Base de datos MySQL en Docker
- Configuración simple
- Despliegue reproducible
- Aislamiento de entorno

</td>
</tr>
</table>

---

## 🏛️ Arquitectura

```
📦 javapootodo
├── 📂 src/main/java
│   ├── 🎮 ConsoleUI/          # Interfaz de usuario por consola
│   │   ├── Auth/              # UI de autenticación
│   │   └── Tasks/             # Menú de gestión de tareas
│   │
│   ├── 🔧 Service/            # Lógica de negocio
│   │   └── Auth/              # Servicio de autenticación + JWT
│   │
│   ├── 💾 database/           # Capa de persistencia
│   │   ├── DatabaseConnection # Conexión a MySQL
│   │   ├── DatabaseSetup      # Creación de tablas
│   │   └── repository/        # Patrón Repository
│   │       ├── Tasks/
│   │       └── User/
│   │
│   ├── 📊 model/              # Entidades del dominio
│   │   ├── Tasks/
│   │   └── User/
│   │
│   └── 🚀 Main.java           # Punto de entrada
│
├── 🐳 docker-compose.yml      # Configuración de contenedores
└── 📋 pom.xml                 # Dependencias Maven
```

---

## ⚡ Instalación

### Prerrequisitos

Antes de comenzar, asegúrate de tener instalado:

| Herramienta | Versión Mínima |
|-------------|----------------|
| ☕ Java JDK | 21+ |
| 📦 Maven | 3.6+ |
| 🐳 Docker | 20+ |

### Pasos de instalación

**1️⃣ Clona el repositorio**
```bash
git clone https://github.com/tu-usuario/javapootodo.git
cd javapootodo
```

**2️⃣ Levanta la base de datos**
```bash
docker-compose up -d
```
> 💡 Esto creará un contenedor MySQL con la base de datos `todo_list`

**3️⃣ Compila el proyecto**
```bash
mvn clean compile
```

**4️⃣ Ejecuta la aplicación**
```bash
mvn exec:java -Dexec.mainClass="Main"
```

---

## 🎮 Uso

### Flujo de la aplicación

```
┌─────────────────────────────────────────────────────────────┐
│                    🚀 INICIO DE APLICACIÓN                   │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                    🔐 MENÚ DE AUTENTICACIÓN                  │
│  ─────────────────────────────────────────────────────────  │
│   1. Iniciar sesión                                         │
│   2. Registrarse                                            │
│   0. Salir                                                  │
└─────────────────────────────────────────────────────────────┘
                              │
                    [ Login exitoso ]
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                    📋 GESTOR DE TAREAS                       │
│  ─────────────────────────────────────────────────────────  │
│   1. Listar tareas                                          │
│   2. Nueva tarea                                            │
│   3. Completar tarea (ID)                                   │
│   4. Eliminar tarea (ID)                                    │
│   0. Salir                                                  │
└─────────────────────────────────────────────────────────────┘
```

### Ejemplo de sesión

```
--- MENÚ DE AUTENTICACIÓN ---
1. Iniciar sesión
2. Registrarse
0. Salir
Selecciona: 2

📝 Registro de usuario
Usuario: johndoe
Contraseña: ********
✅ Usuario registrado exitosamente

--- GESTOR DE TAREAS ---
1. Listar tareas
2. Nueva tarea
Selecciona: 2

Description: Estudiar Java POO
✅ Tarea creada

--- GESTOR DE TAREAS ---
Selecciona: 1

1. [ ] Estudiar Java POO
2. [X] Completar proyecto
```

---

## 🛠️ Stack Tecnológico

<div align="center">

| Categoría | Tecnología | Propósito |
|:---------:|:----------:|:---------:|
| **Lenguaje** | Java 21 | Core de la aplicación |
| **Build** | Maven | Gestión de dependencias |
| **Base de Datos** | MySQL 8.0 | Persistencia de datos |
| **Contenedores** | Docker | Entorno de desarrollo |
| **Seguridad** | BCrypt | Hash de contraseñas |
| **Autenticación** | JWT (jjwt) | Tokens de sesión |

</div>

### 📦 Dependencias principales

```xml
<!-- Conector MySQL -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.3.0</version>
</dependency>

<!-- JWT para autenticación -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>

<!-- BCrypt para hash de contraseñas -->
<dependency>
    <groupId>org.mindrot</groupId>
    <artifactId>jbcrypt</artifactId>
    <version>0.4</version>
</dependency>
```

---

## 🗄️ Modelo de Datos

```sql
┌──────────────────────────────┐      ┌──────────────────────────────┐
│           USERS              │      │           TASKS              │
├──────────────────────────────┤      ├──────────────────────────────┤
│ • id (PK)        INT         │      │ • id (PK)        INT         │
│ • username       VARCHAR     │◄────►│ • user_id (FK)   INT         │
│ • password       VARCHAR     │      │ • description    VARCHAR     │
│   (BCrypt hash)              │      │ • completed      BOOLEAN     │
└──────────────────────────────┘      └──────────────────────────────┘
```

---

## 🔒 Seguridad

Este proyecto implementa las siguientes medidas de seguridad:

| Medida | Implementación |
|--------|----------------|
| 🔑 **Contraseñas** | Hasheadas con BCrypt (nunca en texto plano) |
| 🎫 **Sesiones** | Tokens JWT firmados |
| 🛡️ **Aislamiento** | Cada usuario solo ve sus propias tareas |
| 🐳 **Base de datos** | Contenedor Docker aislado |

---

## 📁 Configuración de Base de Datos

La conexión se configura en `DatabaseConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/todo_list";
private static final String USER = "root";
private static final String PASS = "root";
```

> ⚠️ **Nota**: Para producción, utiliza variables de entorno para las credenciales.

---

<div align="center">

## 📄 Licencia

Este proyecto está bajo la licencia MIT.

---

Desarrollado con ❤️ y ☕

**[⬆ Volver arriba](#-javapoo-todo)**

</div>

