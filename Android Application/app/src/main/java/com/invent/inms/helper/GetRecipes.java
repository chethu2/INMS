package com.invent.inms.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import inms.Inms;

public class GetRecipes implements Serializable {
    private static List<String> recipeName = new ArrayList<>();
    private static List<String> imageUrl;
    private static String calories;
    private static String totalTime;

    public static List<String> getRecipeName(Inms.GetRecipesResponse getRecipesResponse) {
        for (Inms.Recipes recipes : getRecipesResponse.getRecipesList()){
            recipeName.add(recipes.getRecipeName());
        }
        return recipeName;
    }

    public static Inms.Recipes getRecipeObject(Inms.GetRecipesResponse getRecipesResponse, String recipeName){
        for (Inms.Recipes recipes : getRecipesResponse.getRecipesList()){
           if (recipes.getRecipeName() == recipeName){
               return recipes;
           }
        }
        return null;
    }
}
