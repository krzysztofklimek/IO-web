package entities;

import entities.Grupa;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-24T02:21:11")
@StaticMetamodel(Trener.class)
public class Trener_ { 

    public static volatile SingularAttribute<Trener, String> imie;
    public static volatile SingularAttribute<Trener, String> nazwisko;
    public static volatile SingularAttribute<Trener, Integer> trenerId;
    public static volatile CollectionAttribute<Trener, Grupa> grupaCollection;
    public static volatile SingularAttribute<Trener, String> email;

}