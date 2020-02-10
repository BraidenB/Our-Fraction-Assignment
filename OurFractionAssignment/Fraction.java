class Fraction {

    private int num;
    private int denom;

    public Fraction() {
        this.num = 2;
        this.denom = 4;
    }

    public Fraction(int num, int denom) {
        this.num = num;
        if(denom == 0) {
            System.out.println("You fool! The denominator is Zero!, I'll set to 1!");
            this.denom = 1;
        } else {
            this.denom = denom;
        }
    }

    public Fraction(String f) {
        int slashIndex = f.indexOf("/");
        String numerator = f.substring(0, slashIndex);
        String denominator = f.substring(slashIndex+1);
        this.num = Integer.parseInt(numerator);
        int d = Integer.parseInt(denominator);
        if(d == 0) {
            System.out.println("You fool! The denominator is Zero!");
        } else {
            this.denom = d;
        }
    }

    public Fraction(Fraction f) {
        this.num = f.num;
        this.denom = f.denom;
    }

    public int getNum() {
        return this.num;
    }

    public int getDenom(){
        return this.denom;
    }

    public String toString() {
        return this.getNum() + "/" + this.getDenom();
    }

    public double toDouble() {
        return this.getNum()/this.getDenom();
    }

    public void reduce() {
        int gcd = gcd(this.num, this.denom);
        this.num = this.num / gcd;
        this.denom = this.denom / gcd; 
    }

    public void setNum() {
        this.num = 4;
    }

    public void setDenom() {
        this.denom = 8;
    }

    public static Fraction add (Fraction a, Fraction b) {
        int newNum = a.num * b.denom + b.num * a.denom;
        int newDenom = a.denom * b.denom;

        Fraction ans = new Fraction(newNum, newDenom);
        ans.reduce();

        return ans;
    }

    public static Fraction subtract (Fraction a, Fraction b) {
        int newNum = a.num * b.denom - b.num * a.denom;
        int newDenom = a.denom * b.denom;

        Fraction ans = new Fraction(newNum, newDenom);
        ans.reduce();

        return ans;
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        int newNum = a.num * b.num;
        int newDenom = a.denom * b.denom;

        Fraction ans = new Fraction(newNum , newDenom);
        ans.reduce();

        return ans;
    }

    public static Fraction divide (Fraction a, Fraction b) {
        if (b.num == 0) {
            System.out.println("Error, cannot divide by zero; returning a default fraction");
            return new Fraction();
        } else {
            Fraction reciprocal = b.getReciprocal();

            Fraction ans = Fraction.multiply(a, reciprocal);
            ans.reduce();
            return ans;
        }
    }

    private Fraction getReciprocal() {
        Fraction reciprocal = new Fraction(this.denom, this.num);
        return reciprocal;
    }

    public int gcd(int a, int b) {
        //calculates and returns the GCF between two numbers

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0)
        {
            return 1;
        }

        while (a != b)
        {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
}
