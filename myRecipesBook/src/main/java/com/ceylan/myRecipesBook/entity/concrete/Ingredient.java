package com.ceylan.myRecipesBook.entity.concrete;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "ingredients")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private int ingredientId;

    @Column(name = "name")
    private String name;

    @Column(name = "measurement")
    private String measurement;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Recipe.class)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}

