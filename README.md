# Proyecto: Biblioteca Web con Servlets, JSP y JDBC

## 📌Descripción

Este proyecto académico es una aplicación web educativa creada como parte de una evidencia práctica en el desarrollo de software con Java EE. Utiliza Servlets, JSP y JDBC para la gestión de libros en una base de datos MySQL, permitiendo registrar y visualizar información de manera dinámica.

## 🛠️Tecnologías Utilizadas

-   **Java EE** (Jakarta EE 10)
    
-   **Servlets** y **JSP**
    
-   **JDBC** para la conexión con MySQL
    
-   **MySQL** como base de datos
    
-   **Apache Tomcat** como servidor de aplicaciones
    
-   **Maven** para la gestión de dependencias
    

## 📂Estructura del Proyecto

```
BibliotecaWeb/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── servlets/
│   │   │   │   ├── SvLibros.java  # Servlet para manejar libros
│   │   │   ├── logica/
│   │   │   │   ├── Libro.java  # Clase modelo para representar libros
│   │   ├── webapp/
│   │   │   ├── index.jsp  # Página principal
│   │   │   ├── mostrarLibros.jsp  # Página para mostrar libros
│   │   │   ├── WEB-INF/
│   │   │   │   ├── web.xml  # Configuración del servlet
├── pom.xml  # Archivo de configuración Maven
```
## Dependencias Requeridas

Agrega el conector de MySQL en `WEB-INF/lib/` o usa Maven con:

```
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>9.2.0</version>
        </dependency>
```
## Configuración de la Base de Datos

El proyecto usa MySQL como base de datos. Se debe crear una base de datos llamada `biblioteca` y una tabla `libros` con la siguiente estructura:

```
CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year INT NOT NULL
);
```

## Configuración de la Conexión JDBC

En el archivo `SvLibros.java`, se establece la conexión con MySQL usando JDBC:

```
String usuario = "root";
String password = "";
String db = "biblioteca";
String ip = "localhost";
String puerto = "3306";
String url = "jdbc:mysql://" + ip + ":" + puerto + "/" + db;
```
> [!IMPORTANT] 
> Asegúrate de que los valores coincidan con la configuración de tu servidor MySQL..

## Funcionalidades

-   **Registrar libros**: Se pueden añadir libros desde un formulario en la página principal.
    
-   **Listar libros**: Se muestran los libros registrados en una página JSP.
    
    

## Autor

**Jefferson David Cano**
