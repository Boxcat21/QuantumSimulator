import java.util.Arrays;

public class Observable {
    private Complex[][] mat;

    public Observable(String s) {
        if(s == null) {
            throw new IllegalArgumentException("String cannot be null");
        }

        switch(s) {
            case "h":
                fillMat(Gates.H);
                break;
            case "x":
                fillMat(Gates.X);
                break;
            case "y":
                fillMat(Gates.Y);
                break;
            case "z":
                fillMat(Gates.Z);
                break;
            case "id":
                fillMat(Gates.I);
                break;
            case "s":
                fillMat(Gates.S);
                break;
            case "sdg":
                fillMat(Gates.SDG);
                break;
            case "0":
                fillMat(Gates.h);
                break;
            case "1":
                fillMat(Gates.v);
                break;
            case "+":
                fillMat(Gates.d);
                break;
            case "-":
                fillMat(Gates.a);
                break;
            default:
                throw new IllegalArgumentException("String  " + s + " is not a state");
        }
    }

    public Observable(Complex[][] input) {
        fillMat(input);
    }

    //an implicit empty vector
    public Observable() {
        mat = new Complex[2][1];
    }

    private void fillMat(Complex[][] in) {
        mat = new Complex[in.length][in[0].length];

        for(int r = 0; r < in.length; r++) {
            for(int c = 0; c < in[r].length; c++) {
                Complex num = new Complex(in[r][c].re(), in[r][c].im());
                mat[r][c] = num;
            }
        }
    }

    public int numRows() {
        return mat.length;
    }

    public int numCols() {
        return mat[0].length;
    }

    public Complex get(int r, int c) {
        return mat[r][c];
    }

    public void set(int r, int c, Complex complex) {
        mat[r][c] = complex;
    }

    //this instance of observable should be a vector
    public Observable compute(Observable oth) {
        if(this.numCols() != 1 || this.numRows() != 2) {
            throw new IllegalStateException("this object is not a vector");
        }

        Observable res = new Observable();

        for(int r = 0; r < oth.numRows(); r++) {
            Complex sum = new Complex(0, 0);
            for(int c = 0; c < oth.numCols(); c++) {
                Complex matVal = oth.get(r,c);
                Complex vectorVal = this.get(c, 0);
                sum = sum.plus(matVal.times(vectorVal));
            }
            res.set(r,0,sum);
        }

        return res;
    }

    public String toString() {
        return "" + Arrays.toString(this.mat);
    }
}
