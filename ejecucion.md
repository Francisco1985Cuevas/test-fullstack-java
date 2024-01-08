Ejecucion de la aplicación Spring Boot con Maven
------------------------------------------------

1. Asegúrarse de tener Maven instalado:
Se debe verificar si Maven está instalado ejecutando mvn -v en la terminal o línea de comandos. Si no está 
instalado, descárgarlo e instálarlo desde Maven Apache.

2. Ejecutar la aplicación:
Abrir la terminal o línea de comandos, navegar al directorio raíz del proyecto donde se encuentra el 
archivo pom.xml y ejecutar el siguiente comando:
mvn spring-boot:run

Esto compilará el proyecto, resolverá las dependencias y ejecutará la aplicación Spring Boot. Se deben ver 
los mensajes de inicio en la consola y la aplicación estará disponible en el puerto por 
defecto (normalmente el 8080).

3. Acceder a la aplicación:
Abrir un navegador web y ingresar http://localhost:8080 (o el puerto en el que se esté ejecutando 
la aplicación). Si todo se ha configurado correctamente se podrá ver la aplicación.

