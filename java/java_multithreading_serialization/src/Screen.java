/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 01
 * Course: COMP 308
 * Athabasca University
 */

/**
 * title: Screen.java
 * description: a basic Screen class, JFrame window.
 * date: April 25, 2020
 * @author Alvee Hassan Akash
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 * Screen
 *
 * Purpose and Description
 *
 * A class to show the Screen with the ability of controlling the GreenhouseControls object.
 *
 * This program does not use User input, all inputs are from directory based.
 *
 * Sun Java SDK version 1.3 or better.
 *
 * Compiling and running instructions
 * Assuming SDK 1.3 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 *
 * Compile:    See Application class file
 * Run:        See Application class file
 *
 */

/**
 * Classes
 *
 * public class Screen extends JFrame
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * public Screen()
 *
 *
 *
 * protected void greenHouseStartRunning()
 *
 * protected void greenHouseEndRunning()
 *
 * public void problemListener(GreenhouseControls gc)
 *
 * public void jFileOpenDialog()
 *
 * public void jDumpFileOpenDialog()
 *
 * public void changeImage(String imageName)
 *
 * public static void serializeObject(Object object)
 *
 *
 *
 *
 *
 *
 */

/**
 * CODE...
 */

import tme3.Event;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

/**
 *  class Screen
 */

public class Screen extends JFrame {
    /**
     * Instance Variables
     *
     * jFrame
     * jScrollPane
     * jPanelForButtons
     * jPanelForText
     * jStatus
     * jImage
     * startBtn
     * restartBtn
     * terminateBtn
     * suspendBtn
     * resumeBtn
     * openFileWindowBtn
     * openDumpWindow
     * jGreenhouseConsole
     * jFilename
     * jFileChooser
     * jMenuBar
     * jMenu
     * openWindow
     * closeWindow
     * openEventFile
     * openDumpFile
     * exit
     * imageHolder
     * fileNameLabel
     * buttonDimension
     * screenFileName
     * printStream
     * isEventFile
     * isThreadRunning
     * gc
     *
     *
     */
    protected JFrame jFrame;

    protected JScrollPane jScrollPane;

    protected JPanel jPanelForButtons, jPanelForText, jStatus, jImage;
    protected JButton startBtn, restartBtn, terminateBtn, suspendBtn, resumeBtn, openFileWindowBtn, openDumpWindowBtn;

    protected JTextArea jGreenhouseConsole, jFilename;
    protected JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    protected JMenuBar jMenuBar;
    protected JMenu jMenu;
    protected JMenuItem openWindow, closeWindow, openEventFile, openDumpFile, exit;

    protected JPopupMenu jPopupMenu = new JPopupMenu();
    protected JMenuItem pStartBtn, pRestartBtn, pTerminateBtn, pSuspendBtn, pResumeBtn;


    protected JLabel imageHolder, fileNameLabel;

    protected Dimension buttonDimension = new Dimension(80, 40);
    protected String screenFileName;

    protected PrintStream printStream;

    protected boolean isEventFile;
    protected volatile boolean isThreadRunning = false;
    //protected volatile boolean running = true;
    private GreenhouseControls gc;

    /**
     * Constructor
     */
    public Screen(){
        jFrame = new JFrame("GreenhouseControls Application");

        //------------------------------------------------------------------------
        // Frame's Main panel contains four panels
        // Panel for file name status
        // Panel for Greenhouse console
        // Panel for Images
        // Panel for buttons

        //jPanelForMain = new JPanel(new FlowLayout());
        jPanelForButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //jPanelForButtons.setBackground(Color.LIGHT_GRAY);

        jPanelForText = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //jPanelForText.setBackground(Color.gray);

        jImage = new JPanel(new GridBagLayout());
        //jImage.setBackground(Color.lightGray);

        jStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jStatus.setBackground(Color.LIGHT_GRAY);


        //------------------------------------------------------------------------
        // Frame's Menu bar

        jMenuBar = new JMenuBar();
        jMenu = new JMenu("File");

        openWindow = new JMenuItem("New Window"); openWindow.addActionListener(actionListener);
        openWindow.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.SHIFT_DOWN_MASK));

        closeWindow = new JMenuItem("Exit Window"); closeWindow.addActionListener(actionListener);
        closeWindow.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.SHIFT_DOWN_MASK));

        openEventFile = new JMenuItem("Open Event File"); openEventFile.addActionListener(actionListener);
        openEventFile.setAccelerator(KeyStroke.getKeyStroke('E', InputEvent.SHIFT_DOWN_MASK));

        openDumpFile = new JMenuItem("Open Dump File"); openDumpFile.addActionListener(actionListener);
        openDumpFile.addChangeListener(e -> openDumpFile.setEnabled(!isThreadRunning));
        openDumpFile.setAccelerator(KeyStroke.getKeyStroke('D', InputEvent.SHIFT_DOWN_MASK));

        exit = new JMenuItem("Exit"); exit.addActionListener(actionListener);
        exit.setAccelerator(KeyStroke.getKeyStroke('Q', InputEvent.SHIFT_DOWN_MASK));

        jMenu.add(openWindow); jMenu.add(closeWindow); jMenu.addSeparator();
        jMenu.add(openEventFile); jMenu.add(openDumpFile); jMenu.addSeparator();
        jMenu.add(exit);
        jMenuBar.add(jMenu);

        jFrame.setJMenuBar(jMenuBar);

        //------------------------------------------------------------------------
        // Panel for file name status
        fileNameLabel = new JLabel("Event File: ");
        jFilename = new JTextArea(); jFilename.setEditable(false);
        jFilename.setVisible(false); jFilename.setBackground(Color.LIGHT_GRAY);

        openFileWindowBtn = new JButton("Open Event File");
        openFileWindowBtn.setPreferredSize(new Dimension(130, 40));
        openFileWindowBtn.addActionListener(actionListener);
        openFileWindowBtn.setEnabled(true);

        openDumpWindowBtn = new JButton("Open Dump File");
        openDumpWindowBtn.setPreferredSize(new Dimension(130, 40));
        openDumpWindowBtn.addActionListener(actionListener);
        openDumpWindowBtn.setEnabled(true);

        jStatus.add(openFileWindowBtn);
        jStatus.add(openDumpWindowBtn);
        jStatus.add(fileNameLabel);
        jStatus.add(jFilename);


        //------------------------------------------------------------------------
        // Panel for Greenhouse console Textarea
        jGreenhouseConsole = new JTextArea(); jGreenhouseConsole.setEditable(false);
        jGreenhouseConsole.addMouseListener(mouseListener);
        //printStream = System.out;
        //printStream = System.out;

        //printStream = System.out;
        printStream = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                char c = (char) b;
                String s = String.valueOf(c);
                jGreenhouseConsole.append(s);
            }
        });

        //System.setOut(printStream);

        //System.setErr(printStream);


        jScrollPane = new JScrollPane(jGreenhouseConsole, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setPreferredSize(new Dimension(600, 255));
//        jScrollPane.setBackground(Color.lightGray);
//        jScrollPane.setBackground(Color.lightGray);
//        jPanelForText.setBackground(Color.lightGray);
        jPanelForText.add(jScrollPane);



        //------------------------------------------------------------------------
        // Panel for Greenhouse console Textarea
        jImage.setPreferredSize(new Dimension(150, 255));
        imageHolder = new JLabel();
        //imageHolder.setBackground(Color.lightGray);
        jImage.add(imageHolder);



        //------------------------------------------------------------------------
        // Panel for buttons
        startBtn = new JButton("Start"); startBtn.setPreferredSize(buttonDimension);
        startBtn.addActionListener(actionListener);
        startBtn.setEnabled(false);

        restartBtn = new JButton("Restart"); restartBtn.setPreferredSize(buttonDimension);
        restartBtn.addActionListener(actionListener);
        restartBtn.setEnabled(false);
        restartBtn.addActionListener(e -> {
            jGreenhouseConsole.append("Bt2");
        });

        terminateBtn = new JButton("Terminate"); terminateBtn.setPreferredSize(buttonDimension);
        terminateBtn.addActionListener(actionListener);
        terminateBtn.setEnabled(false);

        suspendBtn = new JButton("Suspend"); suspendBtn.setPreferredSize(buttonDimension);
        suspendBtn.addActionListener(actionListener);
        suspendBtn.setEnabled(false);

        resumeBtn = new JButton("Resume"); resumeBtn.setPreferredSize(buttonDimension);
        resumeBtn.addActionListener(actionListener);
        resumeBtn.setEnabled(false);

        jPanelForButtons.add(startBtn); jPanelForButtons.add(restartBtn);
        jPanelForButtons.add(terminateBtn); jPanelForButtons.add(suspendBtn);
        jPanelForButtons.add(resumeBtn);



        //------------------------------------------------------------------------
        // Popup Menu items setup
        pStartBtn = new JMenuItem("Start"); pStartBtn.setEnabled(false);
        pRestartBtn = new JMenuItem("Restart"); pRestartBtn.setEnabled(false);
        pTerminateBtn = new JMenuItem("Terminate"); pTerminateBtn.setEnabled(false);
        pSuspendBtn = new JMenuItem("Suspend"); pSuspendBtn.setEnabled(false);
        pResumeBtn = new JMenuItem("Resume"); pResumeBtn.setEnabled(false);
        pStartBtn.addActionListener(actionListener); pRestartBtn.addActionListener(actionListener);
        pTerminateBtn.addActionListener(actionListener); pSuspendBtn.addActionListener(actionListener);
        pResumeBtn.addActionListener(actionListener);

        jPopupMenu.add(pStartBtn); jPopupMenu.add(pRestartBtn);
        jPopupMenu.add(pTerminateBtn); jPopupMenu.add(pSuspendBtn);
        jPopupMenu.add(pResumeBtn);



        //------------------------------------------------------------------------
        // Adding all the Panels to Main Panel
        jFrame.add(jStatus, BorderLayout.PAGE_START);
        jFrame.add(jPanelForText, BorderLayout.LINE_START);
        jFrame.add(jImage, BorderLayout.LINE_END);
        jFrame.add(jPanelForButtons, BorderLayout.PAGE_END);

        jFrame.addMouseListener(mouseListener);
//        jFrame.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                if (SwingUtilities.isRightMouseButton(e)){
//                    //printStream.println("popup menu showwwww please for Gods Sake");
//                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
//                }
//            }
//        });

        jFrame.setSize(760,400);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        //jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.addWindowListener(windowAdapter);

    } // Screen class

    /**
     * triggers the right click on the mouse and show the popup menu
     */
    MouseListener mouseListener = new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)){
                //printStream.println("popup menu showwwww please for Gods Sake");
                jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    };


    /**
     * Checks which window is currently clicked to close, then a popup window to show
     * yes or no option to close. popup window only appears when the GreenhouseControls
     * object is running.
     */
    WindowAdapter windowAdapter = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
                if (isThreadRunning) {
                    int yesNo = JOptionPane.showConfirmDialog(getParent(), "Are you sure ?",
                            "Exit Program", JOptionPane.YES_NO_OPTION);
                    if (yesNo == JOptionPane.YES_OPTION) {
                        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    } else jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                } else jFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

    };


    /**
     * While the GreenhouseControls object starts running, it would set these variable for Screen object
     * to collaborate with its Interface UI.
     */
    public void greenHouseStartRunning() {
        //printStream.println("object is running");
        isThreadRunning = true;
        openFileWindowBtn.setEnabled(false);
        openDumpWindowBtn.setEnabled(false);

        // Regular buttons
        startBtn.setEnabled(false);
        restartBtn.setEnabled(false);
        terminateBtn.setEnabled(true);
        suspendBtn.setEnabled(true);
        resumeBtn.setEnabled(true);

        // Popup menu items
        pStartBtn.setEnabled(false);
        pRestartBtn.setEnabled(false);
        pTerminateBtn.setEnabled(true);
        pSuspendBtn.setEnabled(true);
        pResumeBtn.setEnabled(true);

    }

    /**
     * While the GreenhouseControls object ends running, it would set these variable for Screen object
     * to collaborate with its Interface UI.
     */
    public void greenHouseEndRunning() {
        isThreadRunning = false;
        openFileWindowBtn.setEnabled(true);
        openDumpWindowBtn.setEnabled(true);

        // Regular buttons
        startBtn.setEnabled(true);
        restartBtn.setEnabled(true);
        terminateBtn.setEnabled(false);
        suspendBtn.setEnabled(false);
        resumeBtn.setEnabled(false);

        // Popup menu items
        pStartBtn.setEnabled(true);
        pRestartBtn.setEnabled(true);
        pTerminateBtn.setEnabled(false);
        pSuspendBtn.setEnabled(false);
        pResumeBtn.setEnabled(false);


    }


    /**
     * This object listens all the button click and does their functionality.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            //------------------------------------------------------------------------
            // Menu Bar action listener

            // Open Window Menu Item
            if (e.getSource().equals(openWindow)) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new Screen();
                    }
                });

            } // Open Window

            // Close window Menu Item
            if (e.getSource().equals(closeWindow)) {
                if (isThreadRunning) {
                    int yesNo = JOptionPane.showConfirmDialog(getParent(), "Are you sure ?",
                            "Exit Program", JOptionPane.YES_NO_OPTION);
                    if (yesNo == JOptionPane.YES_OPTION) {
                        jFrame.dispose();
                    } else jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                } else jFrame.dispose();
            } // Close window

            // Open Event File Menu Item
            if (e.getSource().equals(openEventFile)) {
                jFileOpenDialog();
            }

            // Open Dump File Menu Item
            if (e.getSource().equals(openDumpFile)) {
                jDumpFileOpenDialog();
            }

            // Exit Menu Item
            if (e.getSource().equals(exit)) {
                if (isThreadRunning) {
                    int yesNo = JOptionPane.showConfirmDialog(getParent(), "Are you sure ?",
                            "Exit Program", JOptionPane.YES_NO_OPTION);
                    if (yesNo == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    } else jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                } else System.exit(0);
            } // Exit


            //------------------------------------------------------------------------
            // Status Bar Buttons listener

            // Open File Window Button
            if (e.getSource().equals(openFileWindowBtn)) {
                jFileOpenDialog();
            }

            // Open Dump window Button
            if (e.getSource().equals(openDumpWindowBtn)){
                jDumpFileOpenDialog();
            }

            //------------------------------------------------------------------------
            // Regular Buttons listener

            // Start button
            if (e.getSource().equals(startBtn) || e.getSource().equals(pStartBtn)) {
                if (isEventFile) {
                    gc = new GreenhouseControls("-f", screenFileName, Screen.this);
                }
                if (!isEventFile){
                    gc = new GreenhouseControls("-d", screenFileName, Screen.this);

//                    try {
//
//                        FileInputStream dumpFileName = new FileInputStream(screenFileName);
//                        ObjectInputStream dumpFileIn = new ObjectInputStream(dumpFileName);
//
//                        // Method for deserialization of object
//                        // Reading the object from file
//                        gc = (GreenhouseControls) dumpFileIn.readObject();
//
//                        dumpFileIn.close();
//                        dumpFileName.close();
//
//                        // Event that fixes the problem
//                        //Event event = (Event) newGC.getFixable(newGC.getError());
//
//                        gc.reStart();
//
//                        // Add event if you wanna see the changes in the list what is fixed
//                        //newGC.addEvent(event);
//
//                        // Run the rest of the events from the list
//                        //newGC.run();
//
//                    } // end of try
//                    catch (IOException | ClassNotFoundException err) {
//                        err.printStackTrace();
//                    } // catch
                } // if (!isEventFile)

            } // Start button

            // Restart button
            if (e.getSource().equals(restartBtn) || e.getSource().equals(pRestartBtn)){
                if (!screenFileName.isEmpty() && !isThreadRunning){
                    jGreenhouseConsole.setText("");
                    gc.pauseThread.shutdownNow();
                    gc = new GreenhouseControls("-f", screenFileName, Screen.this);
                }
            } // Restart button

            // Terminate button
            if (e.getSource().equals(terminateBtn) || e.getSource().equals(pTerminateBtn)) {
                if (isThreadRunning) {
                    String delay = JOptionPane.showInputDialog(getParent(), "Green House Terminating in Milliseconds ?");
                    if (!(delay == null)) {
                        long delayTime = Long.parseLong(delay);
                        Event event = new Terminate(delayTime, gc);
                        gc.addTerminateEvent(event);
                    }
                    return;
                }
            } // Terminate button

            // Suspend button
            if (e.getSource().equals(suspendBtn) || e.getSource().equals(pSuspendBtn)){
                gc.pauseThread.pause();
            }

            // Resume button
            if (e.getSource().equals(resumeBtn) || e.getSource().equals(pResumeBtn)){
                gc.pauseThread.resume();
                printStream.println("POPUP MENU RESUME BTN");
            }


        } // actionPerformed method

    }; // actionListener method


    /**
     * Checks for the error code in GreenhouseControls object and Serialize the object.
     * @param gc - GreenhouseControls value
     */
    public void sentBackToSerialize(GreenhouseControls gc){
        if (gc.getErrorCode() == 1 || gc.getErrorCode() == 2) {
            serializeObject(gc, this);
            printStream.println("GreenhouseControls serialized");
            printStream.println("\nSystem is exiting");

            // According to TME3, it should exit the system, but here I want to exit only
            // GreenhouseControls object and keep the window alive for other things to run
            // like open dump file, New window to run something else.

            //System.exit(0);
        } // if
    } // problemListener

    /**
     * Opens up file choosing option on the window screen, then it opens the file to check its
     * compatibility to run in this application or not.
     * it checks "Event" related file with its appropriate line matches.
     * if not usable, it will show an error popup dialog window and not save the file.
     */
    public void jFileOpenDialog() {
        if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File file = jFileChooser.getSelectedFile().getAbsoluteFile();

            try {
                Scanner scanner = new Scanner(file);
                if (!scanner.hasNextLine()) {
                    JOptionPane.showMessageDialog(getParent(), "File not Readable", "Invalid File", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (scanner.nextLine().matches("\\A\\p{ASCII}*\\z")){
                    boolean fileOpenAble = scanner.nextLine().matches("Event=(.*).time=(.*)");
                    if (!fileOpenAble) {
                        JOptionPane.showMessageDialog(getParent(), "File not programmable", "Invalid File", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        screenFileName = file.getAbsolutePath();
                        jFilename.setText(screenFileName);
                        isEventFile = true;
                        jFilename.setVisible(true);
                        startBtn.setEnabled(true);
                        pStartBtn.setEnabled(true);
                        openDumpWindowBtn.setEnabled(false);
                        jGreenhouseConsole.setText("");
                    }
                }

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    } // jFileOpenDialog

    /**
     * Opens up file choosing option on the window screen, then it opens the file to check its
     * compatibility to run in this application or not.
     * it checks "dump.out" file with its name to so that it can use it to retrieve the object.
     * if not usable, it will show an error popup dialog window and not save the file.
     */
    public void jDumpFileOpenDialog() {
        if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File file = jFileChooser.getSelectedFile().getAbsoluteFile();
            if (!file.getName().matches("dump.out")) {
                JOptionPane.showMessageDialog(getParent(), "Invalid Dump File", "File not programmable", JOptionPane.ERROR_MESSAGE);
            }
            else {
                screenFileName = file.getAbsolutePath();
                jFilename.setText(screenFileName);
                isEventFile = false;
                jFilename.setVisible(true);
                startBtn.setEnabled(true);
                pStartBtn.setEnabled(true);
                openFileWindowBtn.setEnabled(false);
                jGreenhouseConsole.setText("");
            }
        }
    }

    /**
     * it is an extra functionality. it will show the GreenhouseControls activity on the
     * screen as an image. due to lack of image resources, it only shows certain images.
     * When the system runs "terminate" segment, it will reset the image to null by
     * a thread with a very short period of time.
     * images are collected from a open source web page.
     * see link: https://www.flaticon.com/home
     * @param imageName - string name of the image
     */
    public void changeImage(String imageName) {
        imageHolder.setIcon(new ImageIcon(Screen.class.getResource("/imageFolder/"+imageName+".png")));
        if (imageName.equals("terminate")){
            (new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(800);
                        imageHolder.setIcon(null);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * it sets isThreadRunning variable in Screen. so it will know GreenhouseControls
     * object is running or not running currently.
     * @param threadRunning - boolean value
     */
    public void setThreadRunning(boolean threadRunning) {
        isThreadRunning = threadRunning;
    }

    /**
     * Serialize object to start from the same state
     * @param object - any type of object class
     */
    public static void serializeObject(Object object, Screen screen) {
        try
        {
            // New file to dump the current state
            FileOutputStream file = new FileOutputStream("dump.out");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of GreenhouseControls object
            out.writeObject(object);

            // closing the file outputs
            out.close();
            file.close();

        } // try

        catch(IOException ex)
        {
            ex.printStackTrace();
            //screen.printStream.println("IOException is caught");
        }
    } // end of serializeObject method

    /**
     * Printing on the Screen window from everywhere of this program.
     * @return - PrintStream value
     */
    public PrintStream getPrintStream() {
        return printStream;
    }


} // Screen





