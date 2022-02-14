package EventsAndReports;

import HouseMain.House;
import Application.WriteToFile;

public class EventReport extends Report {

    public EventReport(House house, int count) {
        super(house, count);
    }

    private final String[] event = {"EVENT REPORT\n"};

    public void addRound(int round){
        event[0] += "========ROUND " + round + " ========\n";
        this.house.getMassages().forEach(massage-> event[0] +=massage + "\n");
        if (this.house.getMassages().isEmpty()){
            event[0] += "Nothing happened\n";
        }
        this.house.getMassages().clear();
    }

    @Override
    public void generateReport() {

        String content = event[0];

        WriteToFile writeToFile = new WriteToFile("EventsAndReports.EventReport" + count, content);
        writeToFile.write();
    }
}
