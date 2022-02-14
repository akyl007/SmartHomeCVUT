package HouseMain.residents;

import EventsAndReports.EventType;
import HouseMain.House;
import HouseMain.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PetApi {


    // Move to next random room

    // create event
    public void startRound(Pet pet) {

        move(pet);

        Random random = new Random();
        int chance = random.nextInt(5);
        String report;
        if (chance == 0){
            switch (pet.getType()){
                case CAT:
                    report = "Type: " + EventType.VOICE + " Source: " + pet.getName() + " Action: MEW!";
                    House.getInstance().addEventMassage(report);
                    break;
                case DOG:
                    report = "Type: " + EventType.VOICE + " Source: " + pet.getName() + " Action: BARK!";
                    House.getInstance().addEventMassage(report);
                    break;
            }
        }
    }
    private void move(Pet pet){
        List<Room> roomList = new ArrayList<>();
        House.getInstance().getFloors().forEach(floor -> floor.getRooms().forEach(room ->roomList.add(room)));

        pet.setRoom(roomList.get(ThreadLocalRandom.current().nextInt(0,roomList.size())));
    }


}
