package org.itstep.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "movies")
@EqualsAndHashCode(exclude = "actors")
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String title;

    private Date releaseYear;

    private int rating;

    private int plot;

    @ManyToOne(cascade = CascadeType.ALL)
    private Director director;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "movies_actors",
            foreignKey = @ForeignKey(name = "movie_fk"),
            inverseForeignKey = @ForeignKey(name = "actor_fk")
    )
    private Set<Actor> actors = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Genre genre;

    public void addActor(Actor actor) {
        actors.add(actor);
        actor.getMovies().add(this);
    }
}
