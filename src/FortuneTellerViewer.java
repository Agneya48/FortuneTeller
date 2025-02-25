import javax.swing.*;
import java.awt.*;

public class FortuneTellerViewer {
    public static void main(String[] args) {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //get native screen resolution
        //use that resolution to open Fortune teller by default at 3/4 of max
        //could do it in the Frame class file, but I kept it here  so it was easy to set various window sizes for testing
        FortuneTellerFrame appFrame = new FortuneTellerFrame(dim.width * 3/4, dim.height * 7/8, "Fortune Teller");

        appFrame.giveFortune();
    }
}