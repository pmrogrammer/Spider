package com.pansoft.test;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;


public class Demo {
    public static void main(String[] args) {
        
        Driver driver = GraphDatabase.driver("bolt://localhost:7687",
                AuthTokens.basic("neo4j", "liuxingyu1314"));
        Session session1 = driver.session();
        String cql1 = "load csv with headers from 'file:///movie.csv' as movie "
                + "create (:movie{title:movie.title,rate:movie.rate});";
        String cql2 = "load csv with headers from 'file:///person.csv' as person "
                + "merge(entity1:movie{title:person.movie})"
                + "merge(entity2:person{name:person.name})"
                + "create(entity2)-[:relations{role:person.role}]->(entity1)";

        session1.run(cql1);
        session1.run(cql2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.close();
    }
}
