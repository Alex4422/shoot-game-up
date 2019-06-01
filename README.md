# ConnexionXX

* Description Courte: `Le microsercice permet de se connecter`
* API référence:  /

## Version

* Nexus: `1.0.0 (2019-01-21)`
* Impact Client: `NON`
* Impact Déploiement: `NON`
* Release Note: [ChangeLog.md](XX)

## Liste des URI exposée

* **GET** **/v1/get_info_ttt** :	

 Service permettant de récupérer un objet ttt
 
 Nom de la m&#233;thode d'entr&#233;e : getInfoTtt

* **POST** **/v1/service_xxx** : 

 Service permettant de faire l'opération xxx
 
 Nom de la m&#233;thode d'entr&#233;e : serviceXxx

* **POST** **/v1/service_ddd**

 Service permettant de faire l'opération ddd
 
 Nom de la m&#233;thode d'entr&#233;e : serviceDdd
 
* **POST** **/v1/service_sss**

 Service permettant de faire l'opération sss

 Nom de la m&#233;thode d'entr&#233;e : serviceSss
 
* **POST** **/v1/service_hhh**

 Service permettant de faire l'opération hhh
 
 Nom de la m&#233;thode d'entr&#233;e : serviceHhh

## Liste des services que le projet utilise

 * **BACK**

 XX

 * **MIDDLE**

 YY

## Prérequis pour le lancement du service en développement

* XX

## Documentation

* Lien Swagger contenant les signatures des méthodes : XX

## Déploiement

* Configuration spécifique: `NON`
* Paramètres de lancement spécifique: `NON`
* Autres

## Développement
* Prérequis: `NON`
* Installation: `mvn clean install`
* Dépendances:
    * API : XX
* Exécution:
    * Ligne de commande :  `java -jar target/*.war --spring.profiles.active=dev  --spring.cloud.config.uri=http://localhost:8761/config -Xmx50m`
        * Attention, il faut que la registry soit démarrée
    * STS :
        * Faire un clic droit sur le fichier "*.launch"
        * Avec la vue "Boot Dashboard", clic droit -> Start sur votre projet
* Tests: `mvn test`

## Intégration continue
* [Job](XX)

## SONAR
* [Qualité](XX)
* [Sécurité](XX)

## Auteur(s)

* AGA : `agaut755@part.cnaf.info`
