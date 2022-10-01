package com.ceylan.myRecipesBook.entity.concrete;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "ingredients")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "measurement")
    private String measurement;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}

