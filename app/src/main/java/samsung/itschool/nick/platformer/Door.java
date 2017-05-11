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
    float x1,y1,x2,y2;
    Door(Float x1, Float y1,Float x2, Float y2, Bitmap pic, Context context){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.pic = pic;
    }


    Paint paint = new Paint();

    void draw(Canvas canvas){


            RectF rect = new RectF(x1,y1,x2,y2);

            canvas.drawBitmap(pic, null, rect, paint);
    }
/*

*/
}

