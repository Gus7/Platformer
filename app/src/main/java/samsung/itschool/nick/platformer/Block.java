package samsung.itschool.nick.platformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by User on 30.12.2016.
 */
public class Block {

    Bitmap pic;
    float x1,x2,y1,y2;
    Block(float x1, float y1, float x2, float y2, Context context, Bitmap pic){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

        this.pic = pic;
    }

    Paint paint = new Paint();

    void draw(Canvas canvas, Bitmap pic){
        RectF rect = new RectF(x1,y1,x2,y2);

        canvas.drawBitmap(pic, null, rect, paint);
    }
}
