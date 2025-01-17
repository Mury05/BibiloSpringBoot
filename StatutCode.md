Voici un résumé des statuts HTTP utilisés dans un projet Spring Boot pour gérer les réponses et les erreurs :

### Statuts HTTP courants

1. **200 OK** : 
   - **Utilisation** : Lorsque la requête est réussie.
   - **Exemple** : Un `GET` réussit et renvoie une ressource demandée.
   - **Code retour dans Spring** : `ResponseEntity.ok()`.

2. **201 Created** : 
   - **Utilisation** : Lorsque la création d'une ressource est réussie.
   - **Exemple** : Un `POST` réussit et crée une nouvelle entité.
   - **Code retour dans Spring** : `ResponseEntity.status(HttpStatus.CREATED).body(savedEntity)`.

3. **400 Bad Request** : 
   - **Utilisation** : Lorsque la requête est mal formée ou invalide.
   - **Exemple** : Des données invalides sont envoyées dans un `POST`.
   - **Code retour dans Spring** : `ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage)`.

4. **404 Not Found** : 
   - **Utilisation** : Lorsque la ressource demandée n'existe pas.
   - **Exemple** : Un `GET` sur un ID qui n'existe pas dans la base de données.
   - **Code retour dans Spring** : `throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found")`.

5. **500 Internal Server Error** : 
   - **Utilisation** : Lorsque quelque chose échoue sur le serveur (erreur système ou exception non gérée).
   - **Exemple** : Une exception de base de données ou un problème interne au serveur.
   - **Code retour dans Spring** : `ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred")`.

### Gestion des erreurs avec `ResponseStatusException`

- **Spring propose `ResponseStatusException`** pour lancer une exception spécifique avec un code HTTP et un message. Cette exception peut être capturée et renvoyée dans une réponse HTTP.
  
  Exemple :
  ```java
  throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
  ```

### Gestion centralisée des erreurs avec `@ControllerAdvice`

- **`@ControllerAdvice`** vous permet de gérer toutes les exceptions de manière centralisée et de renvoyer des réponses HTTP appropriées.
  
  Exemple de gestion d'exception dans `@ControllerAdvice` :
  ```java
  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<String> handleResponseStatusException(ResponseStatusException e) {
      return ResponseEntity.status(e.getStatus()).body(e.getMessage());
  }
  ```

Cela permet de structurer vos réponses d'API et d'assurer une gestion des erreurs cohérente et propre tout au long de l'application.