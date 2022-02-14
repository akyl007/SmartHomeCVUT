package HouseMain.residents;

import Patterns.Device;
import EventsAndReports.EventType;
import HouseMain.House;
import HouseMain.Room;
import States.DeviceStateEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PersonApi extends Person {


    public void useDevice(Person person, Device device){
        switch(device.getDeviceStateEnum()) {
            case IDLE:
                person.usingTarget = device;
                device.use();
                break;
            case OFF:
                device.turnOn(); person.usingTarget = device;
                device.use();
                break;
        } person.getUsedDevices().add(device);
    }

    public String activityAndUsageReport(Person person){
        StringBuilder ret = new StringBuilder("Used : " + "\r\n");
        List<Device> a = person.getUsedDevices();
        List<Device> b = new ArrayList<>(a);

        while(!b.isEmpty()){
            int count = 1;
            Device device = b.get(0);
            b.remove(device);
            while(b.remove(device)){
                count++;
            }
            ret.append(device.getName()).append(" ").append(count).append("x.").append("\r\n");
        }
        return ret.toString();
    }

    public void startRound(Person person) {
        if(person.usingTarget == null){
            nextAction(person);
        }
        else{
            usingTarget.turnOff();
            person.usingTarget = null;
        }
    }

    public void finshRound(Person person) {
        if (person.usingTarget != null){
            person.usingTarget.stopUse();
            person.usingTarget = null;
        }
    }

    /*
     *
     *  1. Move to random room
     *
     *  2. Use Random device in room
     *
     */
    public void nextAction(Person person){
            List<Device> devicesList = new ArrayList<>();
            move(person);
            person.getRoom().getDevices().forEach(device -> {
                        if (device.getDeviceStateEnum() != DeviceStateEnum.ACTIVE && device.getDeviceStateEnum() != DeviceStateEnum.BROKEN){
                            devicesList.add(device);
                        }
                    });
            int devices = devicesList.size();
            if (devices == 0){
                String report = "Type: " + EventType.DO_NOTHING + " Source: " + person.getName();
                House.getInstance().addEventMassage(report);
            }

            if(devicesList.size() >= 1) {
                this.useDevice(person, devicesList.get(ThreadLocalRandom.current().nextInt(0, devices)));
            }

    }

    private void move(Person person){
        List<Room> roomList = new ArrayList<>();
        House.getInstance().getFloors().forEach(floor -> floor.getRooms().forEach(room ->roomList.add(room)));
            if(roomList.size() >= 1){
        person.setRoom(roomList.get(ThreadLocalRandom.current().nextInt(0,roomList.size())));}
    }
}
