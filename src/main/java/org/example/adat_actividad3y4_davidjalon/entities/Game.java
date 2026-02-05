package org.example.adat_actividad3y4_davidjalon.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "platform", length = 50)
    private String platform;

    @Column(name = "genre", length = 50)
    private String genre;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "developer", length = 100)
    private String developer;

    @Column(name = "publisher", length = 100)
    private String publisher;

    @ColumnDefault("0")
    @Column(name = "is_special_edition")
    private Boolean isSpecialEdition;

    @ColumnDefault("'Backlog'")
    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "estimated_value", precision = 10, scale = 2)
    private BigDecimal estimatedValue;

    @Lob
    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER) // <--- EAGER: Evita el error "No serializer found for ByteBuddy"
    @JoinColumn(name = "user_id")
    @ToString.Exclude // Evita bucles al hacer logs o imprimir el objeto
    private User user;


}