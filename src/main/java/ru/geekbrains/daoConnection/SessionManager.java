package ru.geekbrains.daoConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {

    private static Session session;
    private static SessionFactory factory;


    public static Session getSession() {
        if (session == null) {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();

            session = factory.openSession();

        }
        return session;
    }

    public static void close() {
        if (session != null) {
            session.close();
        }
        if (factory != null) {
            factory.close();
        }

    }
}
