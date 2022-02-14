package HouseMain.window;

public class BlindClose implements BlindState{

    public void open(Blind blind) {
        blind.setBlindState(new BlindOpen());
        blind.isOpen = true;
    }

    public void close(Blind blind) {
        System.out.println("HouseMain.window.Blind is closed");
    }
}
