Description du Projet : generate-backend
Ce projet expose des APIs via Swagger pour générer et sauvegarder des numéros en fonction d'une configuration dynamique. Pour accéder à la documentation Swagger de l'API, lancez le projet et accédez au lien suivant :
http://localhost:8080/swagger-ui/index.html#/

****Détails Techniques
1-Version SDK : Java 17

2-Version de Spring Boot : 3.1.0

3-Base de données : PostgreSQL

4-Dépendances principales :

  **spring-boot-starter-web : 3.1.0

  **spring-boot-starter-data-jpa : 3.0.1

  **org.postgresql:42.6.0

  **springdoc-openapi-starter-webmvc-ui:2.1.0

  **org.projectlombok:1.18.24

  **spring-boot-starter-jdbc

  **org.hibernate.validator:6.0.13

  **spring-boot-starter-test:2.7.9

  **org.mapstruct:1.5.2

  **org.apache.maven.plugins:3.8.0

5-Base de données :

  Nom de la base : numerotation_db

  Remarque : Assurez-vous de modifier le username et le password pour configurer l'accès à la base de données correctement.

  Structure des tables : La base de données contient trois tables principales :

  configuration : Contient les configurations de numérotation.

  generated_number : Stocke les numéros générés.

  numbering_criteria : Décrit les critères de configuration tels que les préfixes et suffixes.

6-Structure du Projet
  -Le projet suit une architecture bien définie pour faciliter la gestion, la génération et la sauvegarde des numéros, avec les modules suivants :

    **Entity : Contient les entités nécessaires à la gestion des données.

      *Configuration : Représente une configuration de numérotation et contient une liste d'NumbreingCriteria associée (relation OneToMany).

      *GeneratedNumber : Utilisée pour sauvegarder les détails des numéros générés.

      *NumberingCriteria : Contient les détails spécifiques de chaque critère de numérotation, tels que les préfixes et suffixes.

      *TimeStampEntity : Fournit un attribut createDate pour chaque table afin de suivre les dates de création des enregistrements.

  **DTO : Contient des objets qui facilitent la manipulation des données entre les couches du projet.

    *ConfigurationCreateDto : Représente les données envoyées lors de la création d'une configuration.

    *ConfigurationDto : Contient les données retournées après l'enregistrement d'une configuration.

    *NumberingCriteriaDto : Contient les données de chaque critère de numérotation.

    *GeneratedNumberDTO : Représente les données saisies par l'utilisateur pour générer le numéro final.

  **Repository : Contient les interfaces JPA pour l'accès aux données.

  **Mapper : Comprend des interfaces de mappage pour convertir les entités en DTO et inversement, facilitant ainsi les interactions entre les couches de l'application.

  **Exceptions : Contient une classe qui gère les erreurs, notamment les erreurs de type NotFound, BadRequest et InternalServerError via un ExceptionHandler global.

  **Config : Comprend la configuration de Swagger pour exposer la documentation de l'API.

-Service :

  **NumberingService : Interface qui contient les méthodes principales :

  **generateAndSaveNumber : Génère et sauvegarde un numéro selon la configuration.

  **saveConfiguration : Sauvegarde une nouvelle configuration avec les critères de numérotation (préfixe, suffixe, longueur, etc.).

    -La classe implémentant cette interface contient la logique de gestion de la configuration et de la génération des numéros.

  **Controller : Contient les classes responsables de l'implémentation des APIs exposées, permettant aux utilisateurs de créer des configurations et de générer des numéros.

  **Tests : Des tests unitaires ont été créés pour garantir le bon fonctionnement de l'application dans divers cas, incluant les tests de génération de numéros et la validation des configurations.   
