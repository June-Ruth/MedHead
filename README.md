# MeadHead - Système d’intervention d’urgence en temps réel - POC

## Fonctionnalités
Le POC permet à travers une interface simple de renseigner une spécialité ainsi qu’une position (latitude, longitude), de trouver l’hôpital le plus proche disposant d’une place et de réserver automatiquement un lit avec un numéro de réservation associée.
La gestion des disponibilités est simulée, celle-ci dépendant d’un autre service existant.
La liste des hôpitaux existants est renseignée à partir des données fournies par le NHS. Les spécialités associées sont simulées. Les données réelles pourront être récupérées par un autre service existant.
L'hôpital renvoyé en réponse est simulé.

Les utilisateurs disponibles sont :
```
Utilisateur : user - Mot de passe : user
Utilisateur : admin - Mot de passe : admin
```
Emergency Speciality prend en paramètre des données telles que définies dans la class Speciality. Latitude et longitude prennent en paramètre des données de type numéraire.
```
Emergency Speciality : ALLERGY
Latitude : 1
Longitude : 1
```
## Application Backend
### Préalables
L’application nécessite les variables d’environnement suivante :
```
DATABASE_DRIVER: com.mysql.cj.jdbc.Driver
DATABASE_URL: addresse de la base de donnée
DATABASE_USERNAME: utilisateur de la base de donnée
DATABASE_PASSWORD: mot de passe de la base de donnée
```
Ces variables peuvent être insérées dans un fichier .env à la racine du projet.

### Exécution
Pour lancer l’application backend, exécuter `./gradlew bootRun` depuis le dossier MedHeadBackEnd.
L’application est paramétrée pour tourner sur http://localhost/8081
### Tests
Exécuter `./gradlew test` depuis le dossier MedHeadBackEnd.
### Documentation
Une documentation Swagger - OpenAPI des controllers est disponible sur http://localhost:8081/swagger-ui/index.html
## Application Frontend
### Préalables
Pour fonctionner correctement, l’application frontend nécessite le lancement de l’application backend. L’hôte et le port de l’application backend doivent être déclarés dans un fichier .env à la racine du projet comme suit :
```
REACT_APP_HOST = localhost
REACT_APP_PORT = 8081
```
### Exécution
Avant tout lancement, il est nécessaire d'installer l'environnement node js avec la commande `npm install`.
Pour lancer l’application frontend, exécuter `npm start` depuis le dossier MedHeadFrontEnd/medheadfrontend.
L’application est paramétrée pour tourner sur http://localhost/3000
### Tests
Pour exécuter les tests en local, exécuter `npm test` depuis le dossier MedHeadFrontEnd/medheadfrontend.

## Standards de développement
Les documents faisant part des standards de développement attendus pour le projet peuvent être retrouvés dans le dossier `Documentation/Development.`

[Intégration et déploiement continu](Documentation/Development/GIT.md)

[Workflow Git](Documentation/Development/CI_CD.md)