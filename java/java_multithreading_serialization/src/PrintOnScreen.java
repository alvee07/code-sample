//import javax.swing.*;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintStream;
//
//public class PrintOnScreen extends OutputStream {
//    PrintStream printStream;
//    JTextArea jTextArea;
//
//    public PrintOnScreen (PrintStream ps, JTextArea jText){
//        printStream = ps;
//        jTextArea = jText;
//        System.out.println("something is here");
//    }
//
//    @Override
//    public void write(int b) throws IOException {
//        char c = (char) b;
//        String s = Character.toString(c);
//        //printStream.append(c);
//        //printStream.print(printStream);
//        jTextArea.append(s);
//    }
//}
