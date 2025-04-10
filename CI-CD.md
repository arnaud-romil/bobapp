
# Intégration Continue et Déploiement Continu (CI/CD) pour BobApp

## Introduction

Ce document décrit le pipeline CI/CD de BobApp, une application full-stack avec un frontend Angular et un backend Spring Boot.
Le pipeline garantit des tests automatisés, une analyse de la qualité du code et le déploiement des images Docker sur Docker Hub.

## Vue d’ensemble du workflow

Le pipeline se compose des étapes suivantes:

1. **Build et Test du Backend** - Compile l’application Spring Boot, exécute les tests et génère un rapport de couverture.
2. **Build et Test du Frontend** - Installe les dépendances et exécute les tests unitaires avec couverture.
3. **Analyse de la qualité du code avec SonarCloud** - Analyse la qualité du code et la couverture des tests.
4. **Construction et déploiement des images Docker** - Crée les images Docker pour le frontend et le backend et les envoie sur Docker Hub.

## Étapes détaillées du workflow xxx

1. **Récupération du dépôt**
  - Utilise ```actions/checkout@v4``` pour récupérer la dernière version du code depuis GitHub.

2. **Build et Test du Backend** 
  - Mise en place de Java 11.
  - Utilisation de Maven pour compiler et exécuter les tests unitaires.
  - Génération d'un rapport de couverture JaCoCo.
  - Upload du rapport de couverture, des classes compilées et des dépendances en tant qu'artéfacts.

3. **Build et Test du Frontend**  
  - Mise en place de Node.js.
  - Installation des dépendances avec ```npm ci```.
  - Exécution des tests et génération d'un rapport de couverture.
  - Upload du rapport de couverture en tant qu'artéfact.

4. **Analyse de la qualité du code avec SonarCloud**
  - Téléchargement des artéfacts des étapes précédentes.
  - Exécution de l'analyse SonarCloud pour vérifier la qualité du code et la couverture des tests.

5. **Construction et déploiement des images Docker**  
  - Connexion à Docker Hub.
  - Construction des images Docker du frontend et du backend.
  - Déploiement des images sur Docker Hub.

## Conditions and dépendances

- Les tests du backend et du frontend doivent réussir avant le déclenchement de l’analyse SonarCloud.
- L’étape de déploiement s’exécute uniquement si toutes les étapes précédentes ont réussi.
- L’analyse SonarCloud doit être validée avant la construction et l’envoi des images Docker.

## Variables secrètes

Les variables secrètes suivantes sont requises pour le pipeline :
- ```SONAR_TOKEN``` - Token d’authentification pour SonarCloud.
- ```DOCKER_USERNAME``` - Nom d’utilisateur Docker Hub.
- ```DOCKER_PASSWORD``` - Token Docker Hub.

## Conclusion sur le pipeline

Ce pipeline CI/CD assure la qualité du code, la sécurité et un déploiement automatisé pour BobApp. Tout échec lors des tests ou des contrôles qualité empêche la mise en production, garantissant ainsi une version stable et fiable.

## Indicateurs Clés de Performance (KPIs) pour la Qualité du Code

Afin de garantir une haute qualité et une bonne maintenabilité du code, nous suivons trois KPIs clés : Couverture, Fiabilité et Sécurité. Ces indicateurs permettent de surveiller la robustesse du code, de détecter les problèmes potentiels en amont et de garantir l’intégrité du logiciel.

1. **Couverture: Coverage (Code Coverage >= 80%)**

La couverture mesure le pourcentage de code testé par des tests automatisés. Un seuil minimum de 80% assure que les fonctionnalités critiques sont testées, réduisant ainsi le risque de bugs non détectés. Les rapports de tests du backend (JaCoCo pour Java) et du frontend (lcov pour Angular) seront analysés dans SonarCloud pour maintenir cette norme.

2. **Fiabilité: Reliability (Bug Rating: A)**

La fiabilité évalue la présence de bugs critiques pouvant entraîner des défaillances de l’application. L’objectif est d’obtenir une note A sur Sonar, ce qui signifie un nombre minimal de problèmes critiques et majeurs. Tout bug détecté doit être corrigé avant d’intégrer du code dans la branche principale.

3. **Sécurité: Security (Vulnerabilities: A)**

La sécurité est un facteur essentiel garantissant la protection de l’application contre les exploits et les menaces. L’objectif est d’obtenir une note A, ce qui signifie aucune vulnérabilité critique et un minimum de problèmes à risque moyen. Les Security Hotspots seront examinés manuellement pour s’assurer qu’aucun risque critique ne subsiste.

En respectant ces KPIs, nous garantissons un code robuste, maintenable et sécurisé, en accord avec les meilleures pratiques.

## Analyse des KPIs Actuels et Actions Recommandées

Les KPIs actuels montrent des axes d’amélioration significatifs en termes de qualité du code et de couverture des tests. Voici une analyse des métriques actuelles avec les actions recommandées pour améliorer la qualité globale du projet.

1. **Couverture : 41.4% (Objectif >= 80%)**

La couverture des tests est bien en dessous du seuil requis de 80%, ce qui augmente le risque de bugs non détectés.

**Actions recommandées**

- Ajouter des tests unitaires et d’intégration pour le frontend (Angular) et le backend (Spring Boot).

- Se concentrer sur la couverture des logiques métier critiques et des cas limites.

- S’assurer que tout nouveau code ajouté soit testé.

2. **Fiabilité: D (Objectif : A)**

Une note **D** en fiabilité indique la présence de plusieurs bugs majeurs ou critiques pouvant affecter la stabilité du système.

**Actions recommandées**:

- Analyser et corriger les bugs signalés par SonarCloud avant tout nouveau merge.

- Renforcer le processus de revue de code pour détecter les problèmes de fiabilité au plus tôt.

3. **Sécurité : A (Bon, mais nécessite une revue)**

La note **A** indique qu’il n’y a pas de vulnérabilités critiques, ce qui est positif. Cependant, la présence de deux Security Hotspots montre des risques potentiels nécessitant un examen manuel.

**Actions recommandées**:

- Vérifier et traiter les Security Hotspots détectés par SonarCloud.

- Appliquer les bonnes pratiques de sécurité (authentification, gestion des données, sécurité des API).

- Effectuer des audits de sécurité réguliers pour prévenir l’apparition de nouvelles vulnérabilités.


**Prochaines étapes**

- Augmenter la couverture des tests à au moins 80% en ajoutant des tests unitaires et d’intégration.

- Corriger les problèmes de fiabilité pour passer d’une note D à A.

- Examiner et résoudre les Security Hotspots afin d’éliminer tout risque potentiel.

## Analyse des Retours Utilisateurs et Actions Recommandées

La note de **2/5** et les plaintes récurrentes indiquent de graves problèmes d’expérience utilisateur. Trois axes majeurs nécessitent une attention immédiate :

1. Manque de fonctionnalités

- **Problème**: Les utilisateurs estiment que l’application manque de fonctionnalités essentielles.

- **Actions**:

  - Mener des enquêtes pour identifier les fonctionnalités les plus demandées (possibilité de poster des blagues ou des vidéos).

  - Prioriser le développement des fonctionnalités à fort impact.

  - Publier des mises à jour régulières pour enrichir l’application progressivement.

2. **Erreurs et Bugs**

- **Problème**: Des erreurs fréquentes affectent l’expérience utilisateur.

- **Actions**:

  - Améliorer la couverture des tests automatisés.

  - Mettre en place un suivi des bugs pour prioriser les corrections.

3. **Mauvaise qualité globale et abandon des utilisateurs**

- **Problème**: Les utilisateurs quittent l’application en raison de problèmes de fiabilité et d’expérience utilisateur.

- **Actions**:

  - Optimiser la performance (temps de chargement, stabilité).

  - Améliorer l’UI/UX sur la base de tests utilisateurs.

  - Lancer un programme de test bêta avant chaque mise en production.

**Problèmes à résoudre en priorité**

- Résoudre les bugs qui causent des problèmes majeurs d'utilisation.

- Améliorer la stabilité de l'application et l'expérience utilisateur.

- Livrer les fonctionnalités les plus demandées par les utilisateurs.
