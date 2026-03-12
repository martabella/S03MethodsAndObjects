
Este repositorio contiene el trabajo práctico desarrollado durante las videoconferencias de los días **2 y 11 de marzo**, enfocado en los contenidos de la **Sesión 3**: Programación Modular e Introducción a la Programación Orientada a Objetos (POO).
El proyecto está dividido en bloques que demuestran la evolución desde la lógica básica hasta la gestión de objetos complejos.

### 1. Demos fundamentos programación modular
* **`BasicMethods`**: Demostración de definición de métodos, retorno de valores y sobrecarga.
* **`ChallengeMethods`**: El juego del "Número Mágico", aplicando métodos
* 
### 2. Gestión de Librería (POO)
Un sistema de inventario que utiliza una clase `Libro` con las siguientes características:
* **Encapsulamiento:** Atributos privados con métodos de acceso.
* **Constructores Sobrecargados:** Flexibilidad al crear libros con o sin precio inicial.
* **Lógica de Negocio:** Métodos para actualización de stock y validación de ventas.
* **Enums y Fechas:** Uso de `Genero` (Enum) y `LocalDate` para un manejo de datos robusto.

La interacción con el usuario se ha centrado en la clase `Utils` para garantizar:
* **Validación de tipos:** Evita errores si el usuario introduce texto en lugar de números.
* **Validación de rangos:** Control estricto sobre valores mínimos y máximos.
* **Reutilización:** Métodos preparados para ser usados en cualquier parte del programa.

---

## 🛠️ Desafíos Pendientes (Colaboración)

El código incluye secciones diseñadas para la práctica activa. Se invita a los estudiantes a completar las siguientes funcionalidades:

1.  **Consulta por Precio (`MainLibreria`):** * `// TODO`: Desarrollar la funcionalidad que permita filtrar libros por precio
2.  **Lógica de Autores (`altaLibro`):** * `// TODO`: Implementar la recogida dinámica de múltiples autores usando métodos de la clase `Utils`.

> 📢 **¡Participa!** Se anima a todos los estudiantes a proponer sus soluciones y resolver dudas en el **Foro de la Asignatura**. ¡La mejor forma de aprender es compartiendo código!

---


## 🛠️ Tecnologías Utilizadas
* **Lenguaje:** Java 24+
* **IDE:** IntelliJ IDEA
* **Conceptos Clave:** Métodos, Objetos, ArrayLists, JavaDoc.

---

## 📋 Estructura de Clases

| Clase | Responsabilidad                                       |
| :--- |:------------------------------------------------------|
| `Libro` | Modelo de datos y lógica de objeto.                   |
| `Utils` | Herramientas de lectura y validación de consola.      |
| `MainLibreria` | Controlador principal y menú de la aplicación.        |
| `Genero` | Definición de categorías de libros.                   |
| `ChallengeMethods` | Juego interactivo para práctica de lógica de métodos. |

---
