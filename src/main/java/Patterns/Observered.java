package Patterns;

import EventsAndReports.Event;

public interface Observered {

    void addObserver(Observer observer);

    void notifyAll(Event event);
}
