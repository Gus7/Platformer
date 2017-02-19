package samsung.itschool.nick.platformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import static android.R.attr.port;

import static android.R.attr.x;
import static android.R.attr.y;
import static java.lang.System.in;
import static samsung.itschool.nick.platformer.Vector.v;
import static samsung.itschool.nick.platformer.Hero.pos;


/**
 * Created by User on 29.12.2016.
 */

public class MyDraw extends View {

    public static int mDirection;
    public static int turnDirection;
    private static final int Up = 1;
    private static final int Down = 2;
    private static final int Right = 3;
    private static final int Left = 4;
    void start(Context context)
    {
        ladder = new Ladder[1];
        for(int i = 0; i < ladder.length; i++){
            ladder[i] = new Ladder(480,270,580,760,
                    context, R.drawable.ladder);
        }
        hero = new Hero(600,750-200, 1, context, R.drawable.hero);
        block = new Block[5];
        block[0] = new Block(0,845,480,845+10,context, R.drawable.block);
        block[1] = new Block(480,760,960,760+10,context, R.drawable.block);
        block[2] = new Block(960,675,1920,675+10,context, R.drawable.block);
        block[3] = new Block(960,405,1920,405+10,context, R.drawable.block);
        block[4] = new Block(480,270,960,270+10,context, R.drawable.block);


    }
    Hero hero;
    Block[] block;
    Ladder[] ladder;
    public MyDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        start(context);
    }

    void Physic(){

        onGround = false;
        onLadder = false;



        for (int i = 0; i < block.length; i++) {

            if (block[i].y1 <= hero.pos.y +90 && block[i].y1 >= hero.pos.y
                    && block[i].x1 <= hero.pos.x
                    && block[i].x2 >= hero.pos.x){
                onGround = true;
                hero.toGo.setY(hero.pos.y);
            }
        }
        for (int i = 0; i < ladder.length; i++){
            if (ladder[i].y1 <= hero.pos.y & ladder[i].y2 >= hero.pos.y & ladder[i].x1 <= hero.pos.x & ladder[i].x2 >= hero.pos.x ){
                onLadder = true;
                //hero.toGo.setY(hero.pos.y);
            }
        }

    }
    boolean onLadder;
    boolean onGround;
/* Поменять всеееее при вводе карты!!!!!!!!!!!!!!!!!*/

    @Override
    public void onDraw(Canvas canvas) {


       Physic();

        switch (mDirection) {
            case Up: {
                if(onLadder && onGround){
                    hero.pos.setY(pos.y-50);}
                else if(onLadder && !onGround){
                    hero.toGo.setY(pos.y-50);
                }else if (onGround && !onLadder){
                    hero.pos.setY(pos.y-250);

                    //hero.toGo.setY(pos.y-2050);


                }


                break;
            }

            case Down: {



                if(onLadder && onGround){
                    hero.pos.setY(pos.y+15);}
                else if(onLadder && !onGround){
                    hero.toGo.setY(pos.y+40);
                }else if (onGround && !onLadder){
                    hero.pos.setY(pos.y+15);

                    //hero.toGo.setY(pos.y-2050);


                }


                break;
            }




        }


        switch (turnDirection) {

            case Right: {

                hero.toGo.setX(pos.x+40);

                break;
            }
            case Left: {

                hero.toGo.setX(pos.x-40);

                break;
            }



        }
        for (int i = 0; i < block.length; i++){
            block[i].draw(canvas);
        }
        for (int i = 0; i < ladder.length; i++){
            ladder[i].draw(canvas);
        }
        Physic();
        if (onGround == false && onLadder == false ){
            //Toast.makeText(this.getContext(), "Toast", Toast.LENGTH_SHORT).show();
            hero.toGo.setY( (hero.pos.y + 100));

        }
        hero.draw(canvas);
        hero.move(canvas);

        this.invalidate();
    }
}
