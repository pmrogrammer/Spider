package com.pansoft.neo4j;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

public class Neo4jUtil {
    private static Driver driver ;
    public static Transaction getTransaction(String dbURL,String username,String password) {
//        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j","liuxingyu1314"));
        driver = GraphDatabase.driver(dbURL,AuthTokens.basic(username,password));
        Session session = driver.session();
        return session.beginTransaction();
    }
    public static boolean closeDriver() {
        driver.close();
        return true;
    }
}
