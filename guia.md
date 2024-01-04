Desafíos Backend con Spring Boot.
---------------------------------


1.) API DE USUARIOS: Diseña los servicios necesarios para un CRUD de Usuarios:

* Crear, modificar, eliminar y listar usuarios.

* Filtro por estado, nombre y lo que se crea pertinente Cada Usuario debe contener minimamente los siguientes datos:
- Identificador único
- Nombre completo
- Contraseña (cifrado es opcional)
- Correo electrónico
- Estado (ACTIVO e INACTIVO)
- Y otra información relevante.
- Rol (Obs: Los roles pueden ser ADMIN, CONSULTOR)

Obs: Puedes agregar cualquier servicio que se crea necesario al API.

Obs 2: El rol ADMIN puede consumir todos los servicios, el rol CONSULTOR solo los listados (GET)

Obs 3: Los usuarios inactivos no pueden iniciar sesion