package HouseMain.window;

import HouseMain.window.Blind;

public class Window {

    private Blind blind;

    public Window(){
    }

    public Window(Blind blind) {
        this.blind = blind;
    }

    public Blind getBlind() {
        return blind;
    }

    public void setBlind(Blind blind) {
        this.blind = blind;
    }
}
