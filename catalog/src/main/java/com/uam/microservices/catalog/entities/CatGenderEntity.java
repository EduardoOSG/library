package com.uam.microservices.catalog.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cat_genre", schema = "catalog")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatGenderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private Boolean active;


}
