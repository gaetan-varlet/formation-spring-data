# Formation Spring Data

## Programme

### Découvrir Spring Data
- Galaxie Spring
- Apport de Spring Core
- Spring Data : principe, fonctionnalités
- Panorama des modules Spring Data :
    - Principaux modules : Commons, Gemfire, JPA, JDBC, KeyValue, LDAP, MongoDB, REST, Redis, Cassandra, Solr
    - Modules community : Aerospike, ArangoDB, Couchbase, Azure DocumentDB, DynamoDB, Elasticsearch, Hazelcast, Jest, Neo4j, Vault
    - Autres : JDBC Extensions, Spring for Apache Hadoop, Content
- Installation de l'environnement et configuration des dépendances

### Implémenter une couche de persistance avec Spring Data JDBC
- Rappels JDBC
- Pattern DAO (Data Access Object)
- Spring Data JDBC : apports, dépendances, configuration
- Apport de Spring DAO (JdbcTemplate)
- Configuration de datasources et accès aux ressources JNDI
- Ecriture de requêtes
- Traitement des résultats
- Gestion des transactions
- Gestion des erreurs

### Coupler un framework ORM avec Spring Data JPA
- Mapping Relationnel Objet (ORM) : principe, standard JPA (Java Persistence API)
- Implémentations de JPA : Hibernate, EclipseLink, OpenJPA,...
- Mise en place de JPA/Hibernate dans un projet : dépendances, configuration
- Mapping des entités : clés, champs, association, héritage
- Objets EntityManagerFactory, EntityManager, EntityTransaction,...
- Spring Data JPA : principe, apports
- Transposition de la configuration de l'unité de persistance dans Spring Data JPA
- Présentation des DAOs disponibles
- Ecriture de requêtes et exploitation des résultats
- Gestion des transactions par annotations
- Gestion des exceptions

### Spring Data LDAP
- LDAP : principe d'annuaire, structure
- Spring LDAP : principe, apports
- Gestion des accès à un annuaire LDAP
- Spring Data LDAP : intégration de données avec Spring LDAP
- Manipulation de l'annuaire et récupération d'objets Java
- Gestion des erreurs

### Spring Data MongoDB
- Modèle relationnel vs modèle orienté documents (NoSQL)
- MongoDB : présentation, fonctionnalités, paramétrage
- Infrastructure MangoDB : définition, optimisation
- Référentiels Mongo
- Insertion et modification de données
- Spring Data MongoDB : principe, fonctionnalités
- Couplage MongoDB - Spring : dépendances, configuration
- Requêtes et traitement des résultats
- Gestion des erreurs


## Questions

- objet sur 2 tables avec un join : pb qui fait une requete pour chaque ligne avec un where au lieu d'un join
- suppression d'un objet et insertion d'un objet avec la même contrainte d'unicité dans une même transaction ne fonctionne pas
- configurer plusieurs BDD
- requêtes perso avec des jointures, group by, clause where sur plusieurs variables...
- mapping objets JPA avec mapping objets métiers
