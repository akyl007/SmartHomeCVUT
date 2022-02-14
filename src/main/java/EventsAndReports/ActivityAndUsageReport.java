package EventsAndReports;

import Application.WriteToFile;
import HouseMain.House;
import HouseMain.residents.Person;
import HouseMain.residents.PersonApi;
import Patterns.PersonIterator;

public class ActivityAndUsageReport extends Report {

    public ActivityAndUsageReport(House house, int count) {
        super(house, count);
    }

    static int callerCounter = 1;

    @Override
    public void generateReport() {
        PersonApi personApi = new PersonApi();
        int personNum = 1;
        String content = "";
        PersonIterator pi = new PersonIterator(house);
        while (pi.hasNext()) {
            Person p = pi.next();
            content += p.getName() + " ";
            content += personApi.activityAndUsageReport(p) + "\n";
            personNum++;
            content += "-----------------------------\n";

        }

        WriteToFile writeToFile = new WriteToFile("EventsAndReports.ActivityAndUsageReport" + callerCounter, content);
        writeToFile.write();
        callerCounter++;
    }
}
