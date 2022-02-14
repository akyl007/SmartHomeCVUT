package Patterns;

import HouseMain.Floor;
import HouseMain.House;
import HouseMain.Room;
import HouseMain.residents.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonIterator {
    List<Person> people = new ArrayList<>();
    Person curr;

    public PersonIterator(House house){
        for(Floor f : house.getFloors()){
            for (Room r : f.getRooms()){
                for(Person p : r.getPersons()){
                    people.add(p);
                }
            }
        }

    }

    public boolean hasNext(){
        Iterator<Person> it = people.iterator();
        if(curr == null){
            return it.hasNext();
        }
        while (it.next() != curr){

        }
        return it.hasNext();

    }

    public Person next(){
        if(curr == null){
            curr = people.get(0);
            return curr;
        }
        curr = people.get(people.indexOf(curr)+1);
        return people.get(people.indexOf(curr));
    }
}
