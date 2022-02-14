package Patterns;

import HouseMain.Devices.*;
import States.DeviceStateEnum;

import java.util.HashMap;
import java.util.Map;

public class DeviceFactory {


    public Computer createComputer(String name){

        Map<DeviceStateEnum, Integer> el = new HashMap<>();
        Map<DeviceStateEnum, Integer> gas = new HashMap<>();
        Map<DeviceStateEnum, Integer> water = new HashMap<>();

        el.put(DeviceStateEnum.IDLE, 20);
        el.put(DeviceStateEnum.OFF, 0);
        el.put(DeviceStateEnum.ACTIVE, 40);

        gas.put(DeviceStateEnum.IDLE, 0);
        gas.put(DeviceStateEnum.OFF, 0);
        gas.put(DeviceStateEnum.ACTIVE, 0);


        water.put(DeviceStateEnum.IDLE, 0);
        water.put(DeviceStateEnum.OFF, 0);
        water.put(DeviceStateEnum.ACTIVE, 0);


        ResourceConsumption resourceConsumption = new ResourceConsumption(el, gas, water);

        return new Computer(name, resourceConsumption);
    }

    public Fridge createFridge(String name){

        Map<DeviceStateEnum, Integer> el = new HashMap<>();
        Map<DeviceStateEnum, Integer> gas = new HashMap<>();
        Map<DeviceStateEnum, Integer> water = new HashMap<>();

        el.put(DeviceStateEnum.IDLE, 100);
        el.put(DeviceStateEnum.OFF, 0);
        el.put(DeviceStateEnum.ACTIVE, 110);


        gas.put(DeviceStateEnum.IDLE, 0);
        gas.put(DeviceStateEnum.OFF, 0);
        gas.put(DeviceStateEnum.ACTIVE, 0);


        water.put(DeviceStateEnum.IDLE, 0);
        water.put(DeviceStateEnum.OFF, 0);
        water.put(DeviceStateEnum.ACTIVE, 0);


        ResourceConsumption resourceConsumption = new ResourceConsumption(el, gas, water);

        return new Fridge(name, resourceConsumption);
    }

    public CdPlayer createCdPlayer(String name){

        Map<DeviceStateEnum, Integer> el = new HashMap<>();
        Map<DeviceStateEnum, Integer> gas = new HashMap<>();
        Map<DeviceStateEnum, Integer> water = new HashMap<>();

        el.put(DeviceStateEnum.IDLE, 10);
        el.put(DeviceStateEnum.OFF, 0);
        el.put(DeviceStateEnum.ACTIVE, 20);


        gas.put(DeviceStateEnum.IDLE, 0);
        gas.put(DeviceStateEnum.OFF, 0);
        gas.put(DeviceStateEnum.ACTIVE, 0);

        water.put(DeviceStateEnum.IDLE, 0);
        water.put(DeviceStateEnum.OFF, 0);
        water.put(DeviceStateEnum.ACTIVE, 0);


        ResourceConsumption resourceConsumption = new ResourceConsumption(el, gas, water);

        return new CdPlayer(name, resourceConsumption);

    }

    public Lamp createLamp(String name){

        Map<DeviceStateEnum, Integer> el = new HashMap<>();
        Map<DeviceStateEnum, Integer> gas = new HashMap<>();
        Map<DeviceStateEnum, Integer> water = new HashMap<>();

        el.put(DeviceStateEnum.IDLE, 5);
        el.put(DeviceStateEnum.OFF, 0);
        el.put(DeviceStateEnum.ACTIVE, 10);

        gas.put(DeviceStateEnum.IDLE, 0);
        gas.put(DeviceStateEnum.OFF, 0);
        gas.put(DeviceStateEnum.ACTIVE, 0);

        water.put(DeviceStateEnum.IDLE, 0);
        water.put(DeviceStateEnum.OFF, 0);
        water.put(DeviceStateEnum.ACTIVE, 0);


        ResourceConsumption resourceConsumption = new ResourceConsumption(el, gas, water);

        return new Lamp(name, resourceConsumption);

    }

    public Shower createShower(String name){

        Map<DeviceStateEnum, Integer> el = new HashMap<>();
        Map<DeviceStateEnum, Integer> gas = new HashMap<>();
        Map<DeviceStateEnum, Integer> water = new HashMap<>();

        el.put(DeviceStateEnum.IDLE, 0);
        el.put(DeviceStateEnum.OFF, 0);
        el.put(DeviceStateEnum.ACTIVE, 0);


        gas.put(DeviceStateEnum.IDLE, 0);
        gas.put(DeviceStateEnum.OFF, 0);
        gas.put(DeviceStateEnum.ACTIVE, 100);


        water.put(DeviceStateEnum.IDLE, 0);
        water.put(DeviceStateEnum.OFF, 0);
        water.put(DeviceStateEnum.ACTIVE, 100);


        ResourceConsumption resourceConsumption = new ResourceConsumption(el, gas, water);

        return new Shower(name, resourceConsumption);
    }

    public Tv createTv(String name){

        Map<DeviceStateEnum, Integer> el = new HashMap<>();
        Map<DeviceStateEnum, Integer> gas = new HashMap<>();
        Map<DeviceStateEnum, Integer> water = new HashMap<>();

        el.put(DeviceStateEnum.IDLE, 35);
        el.put(DeviceStateEnum.OFF, 0);
        el.put(DeviceStateEnum.ACTIVE, 60);


        gas.put(DeviceStateEnum.IDLE, 0);
        gas.put(DeviceStateEnum.OFF, 0);
        gas.put(DeviceStateEnum.ACTIVE, 0);


        water.put(DeviceStateEnum.IDLE, 0);
        water.put(DeviceStateEnum.OFF, 0);
        water.put(DeviceStateEnum.ACTIVE, 0);

        ResourceConsumption resourceConsumption = new ResourceConsumption(el, gas, water);

        return new Tv(name, resourceConsumption);
    }

    public WashingMachine createWashingMachine(String name){

        Map<DeviceStateEnum, Integer> el = new HashMap<>();
        Map<DeviceStateEnum, Integer> gas = new HashMap<>();
        Map<DeviceStateEnum, Integer> water = new HashMap<>();

        el.put(DeviceStateEnum.IDLE, 25);
        el.put(DeviceStateEnum.OFF, 0);
        el.put(DeviceStateEnum.ACTIVE, 50);


        gas.put(DeviceStateEnum.IDLE, 0);
        gas.put(DeviceStateEnum.OFF, 0);
        gas.put(DeviceStateEnum.ACTIVE, 50);


        water.put(DeviceStateEnum.IDLE, 0);
        water.put(DeviceStateEnum.OFF, 0);
        water.put(DeviceStateEnum.ACTIVE, 100);


        ResourceConsumption resourceConsumption = new ResourceConsumption(el, gas, water);

        return new WashingMachine(name, resourceConsumption);
    }

    public Cookstove createCookstove(String name){

        Map<DeviceStateEnum, Integer> el = new HashMap<>();
        Map<DeviceStateEnum, Integer> gas = new HashMap<>();
        Map<DeviceStateEnum, Integer> water = new HashMap<>();

        el.put(DeviceStateEnum.IDLE, 10);
        el.put(DeviceStateEnum.OFF, 0);
        el.put(DeviceStateEnum.ACTIVE, 20);

        gas.put(DeviceStateEnum.IDLE, 0);
        gas.put(DeviceStateEnum.OFF, 0);
        gas.put(DeviceStateEnum.ACTIVE, 100);

        water.put(DeviceStateEnum.IDLE, 0);
        water.put(DeviceStateEnum.OFF, 0);
        water.put(DeviceStateEnum.ACTIVE, 0);

        ResourceConsumption resourceConsumption = new ResourceConsumption(el, gas, water);

        return new Cookstove(name, resourceConsumption);
    }


}
