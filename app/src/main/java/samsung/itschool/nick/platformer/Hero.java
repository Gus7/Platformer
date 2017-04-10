package samsung.itschool.nick.platformer;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.content.ContentValues.TAG;
import static samsung.itschool.nick.platformer.FirstSplashDraw.height;
import static samsung.itschool.nick.platformer.FirstSplashDraw.width;



/**
 * Created by User on 29.12.2016.
 */

public class Hero {

    Vector toGo;
    static Vector pos;

    Float size;
    
/*
    Hero(Context context, int picResId){
        pos = new Vector(0,0);
        size = 1f;
        pic = BitmapFactory.decodeResource(context.getResources(), R.drawable.hero);
    }*/

    Hero(float x, float y, float size, Context context) throws IOException {
        pos = new Vector(x, y);
        this.size = size;


/*
        try {
            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = new InputStreamReader(assetManager.open("a.txt"));
            BufferedReader reader = new BufferedReader(istream);
            String line_ = reader.readLine();
            String[] levs_ = line_.split(";");
            String[] words_ = levs_[1].split(" ");
            toGo = new Vector(Float.parseFloat(words_[1])*width/1920, Float.parseFloat(words_[2])*height/1005);
            reader.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i(TAG,"///////////////////////////////////////////////////");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG,"--------------------------------------------------");
        }*/

    }

    Paint paint = new Paint();

    void draw(Canvas canvas, Bitmap pic) {

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
