package Patterns;

import EventsAndReports.Event;

public interface Observer {

    void handleEvent(Event event, Object source);
}
