# Exemples relatifs à DactyloGame

Ce projet contient une configuration gradle (`build.gradle`, `settings.gradle`, `gradle/wrapper/gradle-wrapper.properties`) dont on peut s'inspirer pour le projet, ainsi que des démos d'utilisation des différentes bibliothèques impliquées.

La configuration gradle contient les déclarations de toutes ces dépendances, ainsi que des définitions de tâches pour exécuter les différentes démos. Notamment :

- `./gradlew run` : lance la tâche JavaFX configurée, ici une démonstration de la bibliothèque RichTextFX.
- `./gradlew chatserver` : lance un serveur de chat utilisant une socket TCP.
- `./gradlew chatclient` : lance un client de chat utilisant une socket TCP. Il fonctionne avec le serveur décrit ci-dessus. Ce programme vous demande au début l'adresse IP de la machine qui fait tourner le serveur. Si vous faites tout sur la même machine, entrez juste `localhost`.
- `./gradlew jsondemo` : lance une demonstration de sérialisation et de dé-sérialisation d'objet en JSON en utilisant la bibliothèque JSON.
- `./gradlem test` : lance les tests JUnit5 (définis dans `src/test/java`). Vous pourrez lire le rapport généré dans le fichier `build/reports/tests/test/index.html`.

Vous pouvez récupérer tout ou partie de ce matériel pour votre projet, à condition de bien penser à supprimer tout ce qui ne vous sert pas (que ce soit les fichiers dans `src` ou bien les tâches gradle personnalisées).
