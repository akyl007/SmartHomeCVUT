package Patterns;

import HouseMain.residents.Person;
import HouseMain.residents.PersonType;
import HouseMain.residents.Pet;
import HouseMain.residents.PetType;

public class ResidentFactory {

    public Person createFather(){
        return new Person("Father", PersonType.FATHER);
    }

    public Person createMother(){
        return new Person("Mother", PersonType.MOTHER);
    }

    public Person createSon(){
        return new Person("Son", PersonType.SON);
    }

    public Person createDaughter(){
        return new Person("Daughter", PersonType.DAUGHTER);
    }

    public Person createLittleDaughter(){
        return new Person("L-Daughter", PersonType.DAUGHTER);
    }

    public Person createLittleSon(){
        return new Person("L-Son", PersonType.DAUGHTER);
    }

    public Pet createCat(){
        return new Pet("Cat", PetType.CAT);
    }

    public Pet createDog(){
        return new Pet("Dog", PetType.DOG);
    }

}
