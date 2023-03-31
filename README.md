# AppUsuariosEJB-JPA 👨‍💻

## About app 🎯

This application implements a crud to a table of person. You could found Crud operations in this project, an about the technologies this application uses:
- Java (JSF)
- REST WebServices
- JPA (Java Persistence Api)
- EJB (Enterprise Java Beans)
- Primefaces
- MVC (Model View Controller)
- Java Security (ROLE_ADMIN, ROLE_USER and ROLE_GUEST)

## Preview 📸

### Main View
![Main View](https://github.com/JuanPatarroyo/appUsuariosEJB-JPA/blob/main/img/preview_1.png?raw=true)
### Insert new row
![Main View](https://github.com/JuanPatarroyo/appUsuariosEJB-JPA/blob/main/img/preview_2.png?raw=true)
### Update/Delete row
![Main View](https://github.com/JuanPatarroyo/appUsuariosEJB-JPA/blob/main/img/preview_3.png?raw=true)



## Requirements 💻

- You need to create a persistence called "SgaPU" and a datasource "jdbc/PersonaDb", or just change their names in the file persistence.xml
- Create two tables: Persona and Usuario,
  - Persona has: id_persona, nombre, apellido, email, telefono, segundo_apellido, saldo
  - Usuario has: id_usuario, id_persona, username, password
- you could change the way to connect to the database, but remember the project works with JPA.

*Feel you free to use it* 🤓.
