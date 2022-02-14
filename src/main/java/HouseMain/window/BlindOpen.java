package HouseMain.window;

public class BlindOpen implements BlindState {

    public void open(Blind blind) {
        System.out.println("HouseMain.window.Blind is open");
    }

    public void close(Blind blind) {
        blind.setBlindState(new BlindClose());
        blind.isOpen = false;
    }
}
