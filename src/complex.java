import java.text.DecimalFormat;
public class complex {
    private double a,b;
    complex(){
        a=0;
        b=0;
    }
    complex(double a, double b){
        this.a=a;
        this.b=b;
    }
    public double getA(){return a;}
    public double getB(){return b;}
    public void setA(double a){
        this.a=a;
    }
    public void setB(double b){
        this.b=b;
    }

    public complex add (complex value) {
        return new complex(this.a + value.a, this.b + value.b);
    }
    public complex subtract (complex value) {
        return new complex(this.a - value.a, this.b - value.b);
    }
    public complex multiply(complex value){
        return new complex(this.a * value.a - this.b * value.b, this.a * value.b + this.b * value.a );
    }
    public complex div(complex value){ //(a + bi) / (c + di) = (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
        return new complex ((this.a * value.a + this.b * value.b)/(value.a * value.a + value.b * value.b), (this.b * value.a - this.a * value.b)/(value.a * value.a + value.b * value.b));
    }
    public String printI(){
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.##");
        String fa = df.format(a);
        String fb = df.format(Math.abs(b));
        if (b>0){
            sb.append(fa).append(" + ").append(fb).append("i");
        }
        else if (b==0){
            sb.append(fa);
        }
        else{
            sb.append(fa).append(" - ").append(fb).append("i");
        }
        String result = sb.toString();
        return result;
    }

}
