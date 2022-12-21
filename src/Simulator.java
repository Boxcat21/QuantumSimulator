import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Scanner;

public class Simulator {
    private Observable[][] state;
    private Complex[] eigenvals;
    private Scanner sc;
    private String curLine;
    private String stringFile;

    public Simulator(String file) throws IOException, ScriptException {
        stringFile = file;
//        working = true;
//        valid = true;
//        probs = new HashMap<String, Double>();
        sc = new Scanner(file);

        //read the import statement/header info of qasm file
        sc.nextLine();
        sc.nextLine();
        sc.nextLine();

        //qreg q[3];
        //7-8 is 3
        int numQubits = Integer.parseInt(sc.nextLine().substring(7,8));
        int numOutcomes = (int) (Math.pow(2, numQubits));

        state = new Observable[numOutcomes][numQubits];
        eigenvals = new Complex[numOutcomes];

        for(int i = 0b0; i < numOutcomes; i++) {
            //get binary string of length numqubits
            String bitstring = Integer.toBinaryString(i);
            while(bitstring.length() < numQubits) {
                bitstring = 0 + bitstring;
            }

            //all outcomes
            for(int j = 0; j < numQubits; j++) {
                if(bitstring.charAt(j) == '0') {
                    state[i][j] = new Observable("0");
                } else {
                    state[i][j] = new Observable("1");
                }
            }
        }

        eigenvals[0b0] = new Complex(1, 0);

        //skip 2 lines
        sc.nextLine();
        sc.nextLine();

        curLine = sc.nextLine();
    }

    public void printState() {
        String zeroProb = "";
        for(int i = 0; i < state.length; i++) {
            for(int j = 0; j < state[i].length; j++) {
                zeroProb += state[i][j].get(0,0) + "  ";
            }
            zeroProb += " | ";
        }
        String oneProb = "";
        for(int i = 0; i < state.length; i++) {
            for(int j = 0; j < state[i].length; j++) {
                oneProb += state[i][j].get(1,0) + "  ";
            }
            oneProb += " | ";
        }
        System.out.println(zeroProb);
        System.out.println(oneProb);

        System.out.println(Arrays.toString(eigenvals));
    }
}
