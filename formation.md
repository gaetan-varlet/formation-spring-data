- bon tuto de Spring Data JPA
- OneToOne, ManyToOne, OneToMany, ManyToMany
- unidirectionnel vs bidirectionnel
    - pb en bidirectionnel des boucles "infinies" (https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion)
- faire du critéria avec Spring Data JPA

- pb que le JOIN ne se fait pas en OneToMany : 
    - solution : @NamedEntityGraph and @EntityGraph ?
    - https://stackoverflow.com/questions/29602386/how-does-the-fetchmode-work-in-spring-data-jpa
    - https://blog.ippon.fr/2017/07/19/boostez-performances-de-application-spring-data-jpa/
    - https://www.baeldung.com/jpa-entity-graph

```java
@Entity
@Table(name = "croisement")
public class Croisement {

    @Id
    private Integer id;
    
    @ElementCollection
    @JoinTable(name="croisement_attributes", joinColumns=@JoinColumn(name="id_croisement"))
    @MapKeyColumn(name="dimension")
    @Column(name="modalite")
    private Map<String, String> map;
    
    private Double valeur;
```

```sql
insert into croisement (id, valeur) values (1, 12);
insert into croisement (id, valeur) values (2, 13);

insert into croisement_attributes(id_croisement, dimension, modalite) values (1, 'DA', 'DA2016');
insert into croisement_attributes(id_croisement, dimension, modalite) values (1, 'AE', 'AETOTAL');

insert into croisement_attributes(id_croisement, dimension, modalite) values (2, 'DA', 'DA2012');
insert into croisement_attributes(id_croisement, dimension, modalite) values (2, 'AE', 'AEAZE');
```
