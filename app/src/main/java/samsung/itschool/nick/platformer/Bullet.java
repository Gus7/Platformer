package samsung.itschool.nick.platformer;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by kolya on 30.03.2017.
 */

public class Bullet
{
    /**Картинка*/
    Bitmap bmp;

    /**Позиция*/
    public float x;
    public float y;

    int side;

    Boolean isalife;

    /**Конструктор*/
    public Bullet(Float x, Float y , int side, Bitmap bmp) {
        this.side = side;
        this.bmp=bmp;
        isalife = true;
        this.x = x-79;
        this.y = y;

    }

    /**Перемещение объекта, его направление*/
    public void move(Canvas canvas) {
        if (x < canvas.getWidth()+200 & x > -200) {
            x += 45 * side *canvas.getWidth()/1920;        //движение по Х со скоростью mSpeed и углу заданном координатой angle
        }else {
            isalife = false;
        }
    }

    /**Рисуем наши спрайты*/
    public void draw(Canvas canvas) {
        //говорим что эту функцию нам нужно вызывать для работы класса
        canvas.drawBitmap(bmp, x, y, null);
    }
}
