package EventsAndReports;

import HouseMain.House;
import Application.WriteToFile;

public class HouseConfigurationReport extends Report {

    public HouseConfigurationReport(House house, int count) {
        super(house, count);
    }

    @Override
    public void generateReport() {

        int[] countRooms = {0};
        this.house.getFloors().forEach(f -> countRooms[0] += +f.getRooms().size());
        String rooms ="\t \t Rooms: "+ countRooms[0];

        int[] countWindows = {0};
        int[] countDevice = {0};
        String[] person = {""};
        String[] pet = {""};
        this.house.getFloors().forEach(f->f.getRooms().forEach(r->{
            countWindows[0]= countWindows[0] + r.getWindows().size();
            countDevice[0] = countDevice[0]+r.getDevices().size();
            r.getPersons().forEach(p-> person[0] = person[0] + p.getName() + ", ");
            r.getPets().forEach(p -> pet[0]= pet[0] + p.getName() + ", ");
        }));
        String floors = "\t Number of floors: " + this.house.getFloors().size();
        String windows = "\t \t \tWindows: "+ countWindows[0];
        String blinds = "\t \t \tBlinds: "+ countWindows[0];
        String devices ="\t \t \tHouseMain.Devices: "+countDevice[0];

        String content = "HouseMain.House {" + "\r\n" + floors + "\r\n" + rooms +
                "\r\n" + windows+ "\n " +blinds + "\r\n" + devices + "\r\n" + "\t \t \tResidents: " + person[0] + "\r\n" + "\t \t \tPets: "+ pet[0] + "\n" + " \t \t \t \t \t \t}" ;
        WriteToFile writeToFile = new WriteToFile("EventsAndReports.HouseConfigurationReport"+count,content);
        writeToFile.write();


    }
}

