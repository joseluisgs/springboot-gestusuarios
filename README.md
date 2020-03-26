# springbootapirestsegura
Ejemplo de como hacer un API REST en Springboot con elementos de Seguridad

## Tecnologías
* Spring Security
* Lombok para potenciar las anotaciones: https://projectlombok.org/features/all
* Base de Datos: H2



### Desarrollo
* 25/03/2020: Inicio del proyecto. Configuración Spring Security
* 25/03/2020: Modelo de usuario. Entidad, Rol, Servicio y Repositorio
* 26/03/2020: UserDetailsService. Registro de usuario (Controladior y DTO)


##### Ejecución
* http://localhost:8080/
> * user:user
> * pass: Mirad en la consola algo como Using generated security password: 9b1e622c-105b-4cf3-92d2-c0bbaccbbcda

* H2: http://localhost:8080/h2-console. 
> * user:sa
> * db: jdbc:h2:./springdatarestapi



## Acerca de
José Luis González Sánchez: [@joseluisgonsan](https://twitter.com/joseluisgonsan)

##### Otros
Inspirado en el curso de [OpenWebinars](https://openwebinars.net/cursos/seguridad-api-rest-spring-boot/) que se recomendó al alumnado.

