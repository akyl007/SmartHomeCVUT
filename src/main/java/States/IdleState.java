package States;

import Patterns.Device;

public class IdleState implements State {

    public void turnOn(Device device) {
        System.out.println("Is idle");
    }

    public void turnOff(Device device) {
        device.setState(new OffState());
        device.deviceStateEnum = DeviceStateEnum.OFF;
    }

    public void use(Device device) {
        device.setState(new ActiveState());
        device.deviceStateEnum = DeviceStateEnum.ACTIVE;
    }

    @Override
    public void stopUse(Device device) {
        System.out.println("Is idle");
    }

    public void fix(Device device) {
        System.out.println("Is not broken");
    }

}

