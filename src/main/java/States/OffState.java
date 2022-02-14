package States;

import Patterns.Device;

public class OffState implements State {

    public void turnOn(Device device) {
        device.setState(new IdleState());
        device.deviceStateEnum = DeviceStateEnum.IDLE;
    }

    public void turnOff(Device device) {
        System.out.println("Is off");
    }

    public void use(Device device) {
        System.out.println("Is off");
    }

    public void stopUse(Device device) {
        System.out.println("Is off");
    }

    public void fix(Device device) {
        System.out.println("Is not broken");
    }
}

