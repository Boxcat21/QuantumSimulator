import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextRunner {
    public static void main(String[] args) throws IOException, ScriptException {

        String stringOfFile = "";
        Scanner sc = new Scanner(new FileReader(new File("TestStuff.qasm")));
        stringOfFile += sc.nextLine();
        while(sc.hasNextLine()) {
            stringOfFile += "\n" + sc.nextLine();
        }

        Simulator sim = new Simulator(stringOfFile);
        sim.printState();
    }
}
