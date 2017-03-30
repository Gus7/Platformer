package samsung.itschool.nick.platformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by kolya on 25.03.2017.
 */

public class Door {
    Bitmap pic;
    float x,y;
    Door(Float x, Float y, Bitmap pic, Context context){
        this.x = x;
        this.y = y;
        this.pic = pic;
    }


    Paint paint = new Paint();

    void draw(Canvas canvas){


            RectF rect = new RectF(x,y,x+(pic.getWidth()),y+(pic.getHeight()));

            canvas.drawBitmap(pic, null, rect, paint);
    }
/*

*/
}

