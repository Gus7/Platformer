package samsung.itschool.nick.platformer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;



/**
 * Created by kolya on 30.03.2017.
 */

public class Moby {

    Bitmap pic;
    float startx,x1, x2, y1, y2, spx;
    Boolean isalife;
    Moby(float x1, float y1, float x2, float y2, float spx, Bitmap pic) {
        isalife = true;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.spx = spx;
        this.pic = pic;
        startx = x1;
    }


    Paint paint = new Paint();

    void draw(Canvas canvas, Bitmap pic) {

        RectF rect = new RectF(x1, y1,x2,y2);

        canvas.drawBitmap(pic, null, rect, paint);
/*

*/
    }



    boolean ifx = false;

    void move(Canvas canvas)
    {
        if (spx - (x2-x1) < x1){ifx = true;}
        else if (startx > x1){ifx = false;}
        if (ifx == false)
        {
            x1 += 5;
            x2 += 5;
        }
        else{
            x1 -= 5;
            x2 -= 5;
        }


    }

}