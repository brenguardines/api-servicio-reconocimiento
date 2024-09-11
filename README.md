# API Servicio de Reconocimiento

## Descripción
Esta API fue desarrollada para el Servicio Número 2 del trabajo práctico anual de la materia Diseño de Sistemas.

**Servicio 2: Reconocimientos Extra**

Hay empresas que decidieron brindar beneficios a los colaboradores pero desde sus propias plataformas.
Para eso vamos a implementar un servicio que recomiende colaboradores de acuerdo a los parámetros
solicitados por las distintas empresas.

La empresa solicitará una cantidad mínima de puntos requeridos, una cantidad mínima de donación de
viandas realizada en el último mes y una cantidad máxima de colaboradores a ser incorporados en la
plataforma externa. En caso de que no se llegue a la cantidad de colaboradores solicitados, se deberán
devolver únicamente los que cumplan las condiciones.

Nuestro sistema debe devolver una lista de colaboradores a ser reconocidos por otras empresas, junto con
el puntaje que obtuvo cada uno hasta el momento.

## Tecnologías utilizadas
### Backend
- **Java**: 17
- **Spring Boot**: 3.3.3
- **Maven**: 3.8.6
- **MySQL**: 8.0

## IDE
- **IntelliJ IDEA** 

## Requisitos
- **Java**: Versión 17 o mayor
- **MySQL**: Versión 8.0 o mayor, instalado y en ejecución.
- **Maven**: Instalado globalmente si no se utiliza el wrapper de Maven.

  
## Instrucciones de configuración
### Clonar el repositorio
1. ```git clone https://github.com/brenguardines/api-servicio-reconocimiento.git```
2. ```cd api-servicio-reconocimiento```
   
### Configuración del Backend
1. Navegar al directorio de la api:
    ```cd api-servicio-reconocimiento```
2. Instalar las dependencias del backend con Maven:
    ```./mvnw clean install```
3. Configurar el archivo application.properties ubicado en src/main/resources/:
   - Asegúrate de que las credenciales de la base de datos coincidan con tu configuración de MySQL:
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/servicio_reconocimiento_db?useSSL=false&allowPublicKeyRetrieval=true
    spring.datasource.username=dds
    spring.datasource.password=1234
    ```
4. Ejecutar la aplicación:
    ```./mvnw spring-boot:run```


### Configuración de la base de datos
1. Asegúrate de que MySQL esté instalado y en ejecución.
2. Crear la base de datos:
    ```mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS servicio_reconocimiento_db;"```
  
### Documentación de la API con Swagger
Swagger está integrado para generar documentación interactiva de la API. Una vez que la aplicación esté en ejecución, puedes acceder a la documentación visitando:
    http://localhost:8080/swagger-ui/index.html

## API Endpoints
- POST `/api/reconocimientos/recomendar`: Devuelve una lista de colaboradores recomendados
    - Requiere un objeto JSON en el cuerpo de la solicitud con los siguientes parámetros:
  
   ```   
    {
        "nombre": "Nombre de la empresa",
        "puntosMinimos": Numero de Puntos,
        "viandasMinimas": Numero de Viandas,
        "maxColaboradores": Numero de Colaboradores
    }
    ```
- POST `/api/colaboradores/crear`: Crea un colaborador
    - Requiere un objeto JSON en el cuerpo de la solicitud con los siguientes parámetros:

   ```   
    {
        "nombre": "Nombre",
        "apellido": "Apellido",
        "puntos": Numero de puntos,
        "viandasDonadas": Numero de Viandas
    }
    ```

- GET `/api/colaboradores/{id}`: Devuelve un colaborador
- GET `/api/colaboradores`: Devuelve todos los colaboradores
