package EventsAndReports;

import HouseMain.House;

public abstract class Report {

    public House house;
    public int count;

    public Report(House house, int count) {
        this.house = house;
        this.count = count;
    }

    abstract void generateReport();

}
