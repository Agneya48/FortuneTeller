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

        /*Note on Lab: Would have  used JTextPanel for more easily formattable display text, but decided to stay
        on the safe side since lab explicitly called for JTextArea. Also, seems like BorderArea doesn't automatically
        calculate new sub-frame sizes when the window resizes, without implementing some sort of component
        listener. Overall, Java is definitely showing why it's primarily a back-end language these days;
        the Swing GUI is a bit of a pain compared to some other alternatives.
         */
    }
}