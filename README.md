# Gestion- École Maternelle  
## Objectif
Mise en place d’une application web MVC Spring Boot complète utilisant :
- Spring Boot 3.5.7
- Spring Data JPA + Hibernate
- MySQL
- Thymeleaf
- Bootstrap 5 
- Architecture en couches (Controller → Service → Repository → Entity)

Fonctionnalités implémentées :
- Gestion des **Classes**
- Gestion des **Étudiants** 
- Gestion des **Absences** par étudiant
- CRUD complet sur toutes les entités

## Fonctionnalités disponibles
| Module             | Fonctionnalités                                                                 |
|--------------------|----------------------------------------------------------------------------------|
| Classes            | Ajouter / Modifier / Supprimer / Lister                                          |
| Étudiants          | Ajouter / Modifier / Supprimer / Lister avec photo + infos complètes            |
| Absences           | Gérer les absences par étudiant (date, heure début/fin, justification, motif)  |

## Technologies utilisées
- **Backend** : Java 17, Spring Boot 3.5.7, Spring Data JPA, Lombok
- **Base de données** : MySQL 8.0
- **Frontend** : Thymeleaf, Bootstrap 5.3, Bootstrap Icons
- **Build** : Maven

## Structure du projet
 ```
src/
└── main/
├── java/ma/fstt/
│   ├── entities/      → Classe, Etudiant, Absence
│   ├── repositories/  → JpaRepository
│   ├── services/      → Interfaces + implémentations
│   └── controller/    → EtudiantController, ClasseController, AbsenceController
└── resources/
├── static/images/ → Photos des étudiants (déjà incluses)
├── templates/     → Pages HTML Thymeleaf
└── application.properties
 ```
## Prérequis
- Java 17 ou supérieur
- Maven 3.8+
- MySQL 8.0

## Installation & lancement

1. **Cloner le projet**
   ```
   git clone https://github.com/salmaaz29/web_app_spring.git
   cd web_app_spring
    ```
2. **Configurer MySQLSQL**
   ```
   CREATE DATABASE ecole_maternelle;
   ```
3. **Modifier**
   ```
   src/main/resources/application.propertiespropertiesspring.datasource.url=jdbc:mysql://localhost:3306/ecole_maternelle?useSSL=false&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```
4. **Lancer l’application**
  ```
./mvnw spring-boot:run
# ou
mvn spring-boot:run
  ```
5. **Accéder à l’application**
  ```
Ouvre ton navigateur → http://localhost:8080
  ```
