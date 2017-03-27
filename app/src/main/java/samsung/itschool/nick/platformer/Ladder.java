package samsung.itschool.nick.platformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by User on 01.01.2017.
 */

public class  Ladder {
    Bitmap pic;
    float x1,x2,y1,y2;
    Ladder(float x1, float y1, float x2, float y2, Context context, int picResId){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

        pic = BitmapFactory.decodeResource(context.getResources(), picResId);
    }

    Paint paint = new Paint();

    void draw(Canvas canvas){

        int heightCount = (int)(y2 - y1)/(pic.getHeight()/2);
        for (int i = 0; i <= heightCount; i++){
        RectF rect = new RectF(x1,y1+(pic.getHeight()/2)*i,x2,y1+(pic.getHeight()/2)*(i+1));

        canvas.drawBitmap(pic, null, rect, paint);
        }
/*

*/
    }
}
