package States;

import Patterns.Device;

public class ActiveState implements State {

    public void turnOn(Device device) {
        System.out.println("Is active");
    }

    public void turnOff(Device device) {
        device.setState(new OffState());
        device.deviceStateEnum = DeviceStateEnum.OFF;
    }

    public void use(Device device) {
        System.out.println("Is active");
    }

    public void stopUse(Device device) {
        device.setState(new IdleState());
        device.deviceStateEnum = DeviceStateEnum.IDLE;
    }

    public void fix(Device device) {
        System.out.println("Is not broken");
    }
}
