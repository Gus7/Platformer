package samsung.itschool.nick.platformer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by User on 04.04.2017.
 */

public class Ruby {
    Bitmap pic;
    float x, y;


    Ruby(float x, float y, Bitmap pic) {

        this.y = y;
        this.x = x;

        this.pic = pic;

    }


    Paint paint = new Paint();

    void draw(Canvas canvas) {

        RectF rect = new RectF(x,y,x+(pic.getWidth()),y+(pic.getHeight()));

        canvas.drawBitmap(pic, null, rect, paint);
/*

*/
    }






}
