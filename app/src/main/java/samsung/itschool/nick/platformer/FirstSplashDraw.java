package samsung.itschool.nick.platformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by User on 03.01.2017.
 */

public class FirstSplashDraw extends View{
    public FirstSplashDraw(Context context, AttributeSet attrs) {
        super(context, attrs);

    }
    Bitmap pic = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.firstBackground);
    Paint paint = new Paint();
    @Override
    public void onDraw(Canvas canvas){

        canvas.drawBitmap(pic, 0, 0,paint);
    }
}
