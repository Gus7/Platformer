package samsung.itschool.nick.platformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.widget.Switch;


import static android.R.attr.port;


import static android.R.attr.x;
import static android.R.attr.y;
import static java.security.AccessController.getContext;
import static samsung.itschool.nick.platformer.Vector.v;

/**
 * Created by User on 29.12.2016.
 */

public class Hero {
    Vector toGo = pos;
    static Vector pos;

    Float size;
    Bitmap pic;
/*
    Hero(Context context, int picResId){
        pos = new Vector(0,0);
        size = 1f;
        pic = BitmapFactory.decodeResource(context.getResources(), R.drawable.hero);
    }*/

    Hero(float x, float y, float size, Context context, int picResId) {
        pos = new Vector(x, y);
        this.size = size;

        pic = BitmapFactory.decodeResource(context.getResources(), picResId);
    }

    Paint paint = new Paint();

    void draw(Canvas canvas) {
        float k = ((float) pic.getHeight() / pic.getWidth());
        RectF rect = new RectF(pos.x - pic.getWidth() * 0.5f, pos.y - pic.getHeight() * 0.5f,
                pos.x + size + 50, pos.y + size * k + 100);

        canvas.drawBitmap(pic, null, rect, paint);
    }

    void move(Canvas canvas) {
        Vector velocity = new Vector(toGo);
        velocity.sub(pos);
        velocity.mul((float)Math.random()/5);
        pos.sum(velocity);
    }


}
