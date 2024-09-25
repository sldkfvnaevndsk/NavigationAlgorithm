import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Web Method");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1014, 738);
        setLocation(270, 70);
        add(new MethodField());
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }
}
