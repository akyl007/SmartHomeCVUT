package States;

import Patterns.Device;

public class BrokenState implements State {

    public void turnOn(Device device) {
        System.out.println("Is broken");
    }

    public void turnOff(Device device) {
        System.out.println("Is broken");
    }


    public void use(Device device) {
        System.out.println("Is broken");
    }

    public void stopUse(Device device) {
        System.out.println("Is broken");
    }


    public void fix(Device device) {
        device.deviceStateEnum = DeviceStateEnum.IDLE;
        device.setState(new IdleState());
    }
}

