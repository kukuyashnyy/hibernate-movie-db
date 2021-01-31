package org.itstep;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.itstep.domain.entity.Actor;
import org.itstep.domain.entity.Director;
import org.itstep.domain.entity.Genre;
import org.itstep.domain.entity.Movie;


public class App1
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Movie movie = new Movie("MyComedy");

            Director director = new Director("Director1", "Director1");
            session.saveOrUpdate(director);
            movie.setDirector(director);

            Genre genre = new Genre("Comedy");
            session.saveOrUpdate(genre);
            movie.setGenre(genre);

            Actor actor = new Actor("Actor1", "Actor1");
            session.saveOrUpdate(actor);
            movie.addActor(actor);

            actor = new Actor("Actor2", "Actor2");
            session.saveOrUpdate(actor);
            movie.addActor(actor);

            session.persist(movie);
            Movie movie1 = session.get(Movie.class, 1);
            System.out.println(movie1);

        } catch (Throwable ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
}
