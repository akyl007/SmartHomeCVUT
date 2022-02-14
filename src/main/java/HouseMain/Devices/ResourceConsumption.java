package HouseMain.Devices;

import States.DeviceStateEnum;

import java.util.Map;

public class ResourceConsumption {

    public Map<DeviceStateEnum, Integer> electricityUsage;
    public Map<DeviceStateEnum, Integer> gasUsage;
    public Map<DeviceStateEnum, Integer> waterUsage;

    public ResourceConsumption(Map<DeviceStateEnum, Integer> electricityUsage, Map<DeviceStateEnum, Integer> gasUsage, Map<DeviceStateEnum, Integer> waterUsage) {
        this.electricityUsage = electricityUsage;
        this.gasUsage = gasUsage;
        this.waterUsage = waterUsage;
    }

    public Integer getElectricityUsage(DeviceStateEnum deviceStateEnum) {
        return electricityUsage.get(deviceStateEnum);
    }

    public Integer getGasUsage(DeviceStateEnum deviceStateEnum) {
        return gasUsage.get(deviceStateEnum);
    }

    public Integer getWaterUsage(DeviceStateEnum deviceStateEnum) {
        return waterUsage.get(deviceStateEnum);
    }
}

