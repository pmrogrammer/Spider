package com.pansoft.neo4j;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;

public class Import {
    /*
     * load csv with headers from 'file:///movie.csv' as movie create
     * (:movie{title:movie.title,rate:movie.rate}); load csv with headers from
     * 'file:///person.csv' as person create
     * (:person{name:person.name})-[:relations
     * {role:person.role}]->(:movie{title:person.movie})
     */

    public static void importData() {

        Driver driver = GraphDatabase.driver("bolt://localhost:7687",
                AuthTokens.basic("neo4j", "liuxingyu1314"));
        Session session = driver.session();
        String cql1 = "load csv with headers from 'file:///movie.csv' as movie "
                + "create (:movie{title:movie.title,rate:movie.rate});";
        String cql2 = "load csv with headers from 'file:///person.csv' as person "
                + "merge(entity1:movie{title:person.movie})"
                + "merge(entity2:person{name:person.name})"
                + "merge(entity2)-[:relations{role:person.role}]->(entity1)";
        String cql3 = "create index on:movie(title)";
        String cql4 = "create index on:person(name)";
        try {
            session.run(cql1);
            session.run(cql2);
            session.run(cql3);
            session.run(cql4);
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            driver.close();    
        }
        
    }
}
