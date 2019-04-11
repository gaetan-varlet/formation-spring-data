# Les différents types de bases de données

## Les bases de données relationnelles (SQL)

Les bases relationnelles ont été inventées en 1970. Oracle a été le premier à commercialiser ce concept en 1977. Les plus utilisées sont :
- Oracle
- MySQL
- Microsoft SQL Server
- PostgreSQL

## Les bases de données NoSQL (Not only SQL)

Les 3 aspects qui ont motivé l'émergence des bases NoSQL :
- **Volume** : il y a toujours plus de données
- **Variété** : les types de données sont très variés
- **Vélocité** : les données changent à une vitesse importante

Le terme NoSQL regroupe des produits qui ne suivent pas le modèle relationnel mais qui ont une architecture différente. Il existe 4 types de bases de données NoSQL :
- bases de données orientées aggrégats :
    - **Clé-Valeur**
    - **Document**
    - **Colonnes**
- bases de données orientées graphes :
    - **Graphes**


### Les entrepôts clés-valeur

les données sont stockées en clé-valeur : une clé et un blob (dans le lequel on peut mettre du texte, un nombre, une structure objet, une image...)

C'est un système facilement scalable avec des temps de réponse en lecture/écriture très bon. L'inconvénient est que les mises à jour sont compliqués et les requêtes rudimentaires.

Les plus utilisés sont **Redis** et **Amazon DynamoDB**.


### Les bases orientées documents

Ces bases de données stockent des informations semi-structurées, au format JSON ou XML. La structure n'est pas contrainte.

L'avantage est la flexibilité, l'évolutivité, un sytème de requêtage plus complet. Les inconvénients sont la duplication des données et la cohérence pas forcément assurée.

La base la plus utilisée est **MongoDB**. D'autres également utilisées sont **Couchbase**, **Amazon DynamoDB**, **CouchDB**, **Microsoft Azure DocumentDB**.


### Les bases orientées colonnes

Ces bases se rapprochent des bases de données relationnelles, mais permettent de remplir un nombre variable de colonnes.

L'avantage est la capacité de stockage accrue et l'accès rapide aux données. L'inconvénient est que le requêtage est limité et que ces bases sont surtout efficace pour des données de même type.

Les plus utilisées sont **Cassandra** et **HBase**.


## Les bases de données orientées graphes

Elles sont basés sur la théorie des graphes, gérés par noeud, relation et propriétés.

L'avantage est que l'architecture est modelable, et adapté à la gestion de données relationnelles. L'inconvénient est que l'architecture est limitée à certains cas.

La plus utilisée est **Neo4j**.