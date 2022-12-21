import java.lang.Math;
public final class Gates {
    //constants
    public static final double PI = Math.PI;
    public static final double e = Math.E;

    //matricies
    public static final Complex[][] H = {{new Complex(1/Math.sqrt(2.0),0), new Complex(1/Math.sqrt(2.0),0)},{new Complex(1/Math.sqrt(2.0),0), new Complex(-1/Math.sqrt(2.0),0)}};
    public static final Complex[][] X = {{new Complex(0,0), new Complex(1,0)},{new Complex(1, 0), new Complex(0,0)}};
    public static final Complex[][] Y = {{new Complex(0,0), new Complex(0,-1)},{new Complex(0,1), new Complex(0,0)}};
    public static final Complex[][] Z = {{new Complex(1,0), new Complex(0,0)},{new Complex(0,0), new Complex(-1,0)}};
    public static final Complex[][] I = {{new Complex(1,0), new Complex(0,0)},{new Complex(0,0), new Complex(1,0)}};
    public static final Complex[][] S = {{new Complex(1, 0), new Complex(0, 0)}, {new Complex(0, 0), new Complex(0, 1)}};
    public static final Complex[][] Q = {{new Complex(1/Math.sqrt(2), 0), new Complex(1/Math.sqrt(2), 0)},{new Complex(0, 1/Math.sqrt(2)), new Complex(0, -1/Math.sqrt(2))}};
    public static final Complex[][] SDG = {{new Complex(1, 0), new Complex(0, 0)}, {new Complex(0, 0), new Complex(0, -1)}};



    //vectors
    public static final Complex[][] h = {{new Complex(1,0)},{new Complex(0,0)}};
    public static final Complex[][] v = {{new Complex(0,0)},{new Complex(1,0)}};
    public static final Complex[][] d = {{new Complex(1/Math.sqrt(2),0)},{new Complex(1/Math.sqrt(2),0)}};
    public static final Complex[][] a = {{new Complex(1/Math.sqrt(2),0)},{new Complex(-1/Math.sqrt(2),0)}};

}
