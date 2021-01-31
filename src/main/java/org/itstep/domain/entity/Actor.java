package org.itstep.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Actors")
@ToString(exclude = "movies")
@EqualsAndHashCode(exclude = "movies")
public class Actor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String FirstName;

    @NonNull
    private String LastName;

    private String Nationality;

    private Date Birth;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies = new HashSet<>();

}
