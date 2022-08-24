package com.springframework.pets;


// We will act like PetService is a 3rd party utility.
public class PetServiceFactory {
    public PetService getPetService(String petType){
        switch (petType){
            case "dog":
                return new DogPetService();
            case "cat":
                return new CatPetService();
            default:
                return new DogPetService();
        }
    }
}