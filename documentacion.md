<h1 align="center">Saludos, futuros compañeros!</h1>

Resumo en pocas palabras mis habilidades utilizadas en este mini proyecto.

### Acerca del Proyecto

Mi objetivo con este proyecto fue desarrollar la API Rest simple con Spring Boot, así como integrarla con la mayoria de los desafíos frontend solicitados.

### Instruccion a tener en cuenta
* Para el backend utilice el lenguaje **Java**, junto con el framework **Springboot**.
* Trate de Utilizar todos los HTTP METHODS adecuados para cada servicio.
* Para el frontend lo hice con HTML sencillo trate de no complicarme demasiado con eso y me concentre en el backend.
* Para la persistencia utilize postgres el DML esta adjunto en la carpeta de este proyecto.

### Desafíos Backend con Spring Boot

**1. API de Usuarios:** Diseñar los servicios necesarios para un CRUD de Usuarios:
* Crear, modificar, eliminar y listar usuarios
* Filtro por estado, nombre y lo que se crea pertinente
Cada Usuario debe contener minimamente los siguientes datos:
* Identificador único
* Nombre comleto
* Contraseña (cifrado es opcional)
* Correo electrónico 
* Estado (ACTIVO e INACTIVO) 

*Obs: Trate de hacer el trabajo que me dieron de la forma mas sencilla posible sin complicarme demasiado para 
tratar de hacer todos los items solicitados. 
- No implemente ninguna Seguridad. 
- No le agregue ninguna documentacion al proyecto(swagger). 
- No cree un proyecto Dockerizado, es un sencillo proyecto Spring Boot.*

### Test Unitarios

Escribir test unitarios o de integración que verifiquen los anteriores requerimientos funcionales. No es necesario tener full covertura, sino seleccionar los puntos más críticos de la lógica del sistema y enfocarse en eso. Por ejemplo, asegurarse de que se puedan crear correctamente los Usuarios y marcarlas como activos.

### Desafíos Frontend Integrados

1. **Interfaz para inicio de sesion** Pagina de inicio de sesion. 

2. **Interfaz para mostrar la lista de usuarios:**

3. **Formulario para agregar nuevos usuarios:** API backend