package samsung.itschool.nick.platformer;

/**
 * Created by User on 29.12.2016.
 */

public class Vector {
    float x, y;

    public Vector(Vector v)
    {
        this.x = v.x;
        this.y = v.y;
    }
    public void print()
    {
        System.out.print("("+x+ ", "+ y +")");
    }
    public String toString()
    {
        return "("+x+ "; "+ y +")";
    }
    public void mul(float k)
    {
        x *= k;
        y *= k;
    }

    public void sum(Vector v)
    {
        this.x += v.x;
        this.y += v.y;
    }

    public void set(float x, float y)
    {
        this.x = x;
        this.y = y;

    }
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }

    public void sub(Vector v)
    {
        this.x -= v.x;
        this.y -= v.y;

    }
    Vector(float x, float y)
    {
        this.x = x;
        this.y = y;

    }

    Vector()
    {
        this.x = 0;
        this.y = 0;
    }

    static Vector v;
    public static void main(String argS[])
    {


        v.print();
    }

    public static void print(Vector a, float b) {
        System.out.print(a.x+" "+ a.y+" "+b);
    }
}
