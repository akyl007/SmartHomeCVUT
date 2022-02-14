package States;

import Patterns.Device;

public interface State {
    void turnOn(Device device);
    void turnOff(Device device);
    void use(Device device);
    void stopUse(Device device);
    void fix(Device device);
}