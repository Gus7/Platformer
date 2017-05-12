package samsung.itschool.nick.platformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.io.IOException;



/**
 * Created by User on 29.12.2016.
 */

public class Hero {

    Vector toGo;
    static Vector pos;

    Float size;
    
/*
    Hero(Context context, int picResId){
        pos = sp Vector(0,0);
        size = 1f;
        pic = BitmapFactory.decodeResource(context.getResources(), R.drawable.hero);
    }*/

    Hero(float x, float y, float size, Context context) throws IOException {
        pos = new Vector(x, y);
        this.size = size;


/*
        try {
            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = sp InputStreamReader(assetManager.open("a.txt"));
            BufferedReader reader = sp BufferedReader(istream);
            String line_ = reader.readLine();
            String[] levs_ = line_.split(";");
            String[] words_ = levs_[1].split(" ");
            toGo = sp Vector(Float.parseFloat(words_[1])*width/1920, Float.parseFloat(words_[2])*height/1005);
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

        float k = ((float) pic.getHeight()/pic.getWidth());

        RectF rect = new RectF(pos.x - (canvas.getWidth()/12)/k, pos.y - canvas.getWidth()/12,
                pos.x +  (canvas.getWidth()/12)/k, pos.y + canvas.getWidth()/12);

        canvas.drawBitmap(pic, null, rect, paint);

    }

    void move(Canvas canvas) {
        Vector velocity = new Vector(toGo);
        velocity.sub(pos);
        velocity.mul((float)Math.random()/5);
        pos.sum(velocity);
    }


}
