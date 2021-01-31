package org.itstep.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "generes")
@ToString(exclude = "movies")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String Name;

    @OneToMany(mappedBy = "genre")
    private List<Movie> movies;
}
