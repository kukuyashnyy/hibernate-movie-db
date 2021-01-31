package org.itstep.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"movies"})
@Table(name = "directors")
public class Director {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String FirstName;

    @NonNull
    private String LastName;

    private String Nationality;

    private Date Birth;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;
}
