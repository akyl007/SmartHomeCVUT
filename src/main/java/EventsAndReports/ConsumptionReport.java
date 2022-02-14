package EventsAndReports;

import HouseMain.House;
import Application.WriteToFile;

public class ConsumptionReport extends Report {
    public ConsumptionReport(House house, int count) {
        super(house, count);
    }

    @Override
    public void generateReport() {


        String[] dev = {""};
        this.house.getFloors().forEach(f -> f.getRooms().forEach(room ->
                room.getDevices().forEach(device -> dev[0] += device.getName() + ": { \n"
                        + " Electricity consumption: " + device.getTotalElectricityConsumption() + " = " + device.getTotalElectricityConsumption() * 0.15 + "Kc; \n"
                        + " Gas consumption: " + device.getTotalGasConsumption() + " = " + device.getTotalGasConsumption() * 0.07 + "Kc; \n"
                        + " Water consumption:" + device.getTotalWaterConsumption() + " = " + device.getTotalWaterConsumption() * 0.05 + "Kc;\n } \n \n")));

        String content = dev[0];

        WriteToFile writeToFile = new WriteToFile("EventsAndReports.ConsumptionReport" + count, content);
        writeToFile.write();

    }
}
