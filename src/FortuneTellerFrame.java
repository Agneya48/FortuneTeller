import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private int width;
    private int height;
    private String title;
    private static ArrayList<String> fortunes = new ArrayList<>();
    Random rnd = new Random();


    JScrollPane mainPnlScroller;
    JPanel mainPnl;
    JPanel imagePnl; // Top panel with fortune teller image
    JPanel displayPnl; // Middle Panel with text area that displays fortunes
    JPanel controlPnl; // Bottom control panel

    JLabel titleLbl;
    ImageIcon icon;

    JTextArea textArea;
    JScrollPane textScroller;

    JButton fortuneBtn;
    JButton quitBtn;

    int recentFortuneID; //keeps track of most recently given fortune so same fortune is not immediately repeated

    public FortuneTellerFrame(int width, int height, String title) throws HeadlessException {
        this.width = width;
        this.height = height;
        this.title = title;
        initialize();
    }

    public FortuneTellerFrame(int width, int height) throws HeadlessException {
        this.width = width;
        this.height = height;
        this.title = "Fortune Teller";
        initialize();
    }

    public FortuneTellerFrame() throws HeadlessException {
        this.width = 400;
        this.height = 600;
        this.title = "Fortune Teller";
        initialize();
    }

    /*
    private method that acts as list of possible fortunes, and adds them to the ArrayList
    the class generates when the FortuneTellerFrame Object is initialized.
     */
    private void createFortunesList() {
        //realistically, it'd be better to include these a CSV text file or equivalent, but we'll just have this in the program for now.
        fortunes.add("The hand that guides your fate is fickle, but well moisturised.");
        fortunes.add("You should get that mole looked at.");
        fortunes.add("You will soon find something you thought was lost. Check under the couch!");
        fortunes.add("You will soon develop an irrational fear of garden gnomes. Don't worry, it's perfectly normal.");
        fortunes.add("You are about to discover the true meaning of 'Netflix and chill.' It involves ice cream.");
        fortunes.add("You are destined to find the perfect pair of socks. They will vanish mysteriously within a week.");
        fortunes.add("Fortune Not Found: Abort, Retry, Ignore?");
        fortunes.add("It will be light in the morning and dark at night.");
        fortunes.add("Instructions unclear. Try again later.");
        fortunes.add("Pack your bags. You're headed for an adventure in the east!");
        fortunes.add("Ideas are like children. None are ever as good as your own.");
        fortunes.add("To courageously shoulder the responsibility of one's mistake is character. And a good way to collect a pink slip.");
        fortunes.add("You have a great capacity for clicking buttons. Use it wisely.");
        fortunes.add("You will be attacked by a clown tonight. Go for the juggler!");
        fortunes.add("Beware the Ides of March.");
        fortunes.add("Dodongo dislikes smoke.");
        fortunes.add("Walk into the waterfall.");
        fortunes.add("Mhmm... well, one is not your lucky number. You should avoid it whenever possible.");
        fortunes.add("I have spoken with the spirits, and they see good things in your future, but only if you give me an extra 10 silver.");
        fortunes.add("You will have an amazing dream but forget to write it down.");
        fortunes.add("Your finances will be a key to your financial future.");
        fortunes.add("Your future is in the time ahead of you that you have not lived through yet.");
        fortunes.add("If you ever feel stupid, just remember that there are people out there who take advice from fortune tellers.");
        fortunes.add("Remember: Your mother loves you even though you never call her.");
        fortunes.add("You need not worry about your future.");
        fortunes.add("Snape kills Dumbledore.");
        fortunes.add("Test fortune - please ignore");
        fortunes.add("Change your password.");
        fortunes.add("It would be best to maintain a low profile for now.");
        fortunes.add("Hope for the best, but prepare for the worst... in bed.");
    }

    private void initialize() {

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        JScrollPane mainPnlScroller = new JScrollPane(mainPnl);

        createImgPanel();
        mainPnl.add(imagePnl, BorderLayout.NORTH);
        mainPnl.setBackground(Color.DARK_GRAY);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        this.createFortunesList();

        add(mainPnlScroller);
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createImgPanel() {

        imagePnl = new JPanel();
        imagePnl.setBackground(Color.DARK_GRAY);
        icon = new ImageIcon(getClass().getResource("FortuneTeller180x180.jpg"));
        titleLbl = new JLabel("Gaze into the Crystal Ball", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Inter", Font.BOLD, 36));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setForeground(Color.WHITE);

        imagePnl.add(titleLbl);
    }

    private void createDisplayPanel() {

        displayPnl = new JPanel();
        displayPnl.setBackground(Color.DARK_GRAY);
        textArea = new JTextArea(20, 50);
        textArea.setBackground(Color.GRAY);
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        setAutoRequestFocus(false);
        textArea.setPreferredSize(new Dimension(400, 9999));
        textScroller = new JScrollPane(textArea);
        textScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroller.setMaximumSize(new Dimension(400, 800));
        textArea.setFont(new Font("Open Sans", Font.ITALIC, 14));
        textArea.setMargin(new Insets(10, 20, 10, 10));
        textArea.append("\n");
        displayPnl.add(textScroller);
    }

    private void createControlPanel() {

        controlPnl = new JPanel();
        controlPnl.setBackground(Color.DARK_GRAY);

        fortuneBtn = new JButton("Read My Fortune!");
        fortuneBtn.setPreferredSize(new Dimension(350, 50));
        fortuneBtn.setFont(new Font("Roboto", Font.BOLD, 20));
        fortuneBtn.addActionListener((ActionEvent ae) -> giveFortune());

        quitBtn = new JButton("Quit");
        quitBtn.setPreferredSize(new Dimension(150, 50));
        quitBtn.setFont(new Font("Roboto", Font.BOLD, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setAlignmentY(JButton.CENTER_ALIGNMENT);

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);
    }

    /*
    Displays a random String fortune from the fortunes ArrayList in the diplayPanel's textArea.
    Does not return the same fortune twice in a row.
     */
    public void giveFortune() {

        boolean done = false;
        while (!done) {
            int roll = rnd.nextInt(fortunes.size());
            if (roll != recentFortuneID) {
                recentFortuneID = roll;
                String chosenFortune = fortunes.get(roll);
                textArea.append(chosenFortune + "\n\n");
                done = true;
            }
        }
    }

}
