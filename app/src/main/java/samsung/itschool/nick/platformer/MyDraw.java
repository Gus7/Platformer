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
    private static final int Up = 1;
    private static final int Down = 2;
    private static final int Right = 3;
    private static final int Left = 4;
    void start(Context context)
    {
        ladder = new Ladder[2];
        for(int i = 0; i < ladder.length; i++){
            ladder[i] = new Ladder((float) Math.random()*600,(float) Math.random()*500,(float) Math.random()*500,(float) Math.random()*500,
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
        Bitmap heropic = BitmapFactory.decodeResource(getContext().getResources(),R.drawable.hero);
        onGround = false;
        for (int i = 0; i < block.length; i++){

            if (block[i].y1+30 <= hero.toGo.y +(heropic.getHeight()) & block[i].y1 >= hero.toGo.y +(heropic.getHeight())
                    & block[i].x1 <= hero.toGo.x
                    & block[i].x2 >= hero.toGo.x +(heropic.getWidth())){
                onGround = true;
            }
        }
        /*
        for (int i = 0; i < ladder.length; i++){
            if (ladder[i].y1 <= hero.pos.y & ladder[i].y2 >= hero.pos.y & ladder[i].x1 <= hero.pos.x & ladder[i].x2 >= hero.pos.x ){
                onLadder = true;
            }
        }
        */
    }
    boolean onLadder = false;
    boolean onGround;
/* Поменять всеееее при вводе карты!!!!!!!!!!!!!!!!!*/

    @Override
    public void onDraw(Canvas canvas) {

        Bitmap heropic = hero.pic;;
        onGround = false;
        for (int i = 0; i < block.length; i++) {

            /*if (block[i].y1 + 30 <= hero.toGo.y + (heropic.getHeight()) & block[i].y1 >= hero.toGo.y + (heropic.getHeight())
                    & block[i].x1 <= hero.toGo.x
                    & block[i].x2 >= hero.toGo.x + (heropic.getWidth())) {
                */onGround = true;
            //}
        }
        switch (mDirection) {
            case Up: {
                if (onGround){

                    hero.pos.setY(pos.y-500);


                }else if(onLadder){
                    hero.toGo.setY(pos.y-50);
                }
                mDirection=0;

                break;
            }

            case Down: {
                //if (onLadder){

                    hero.toGo.setY(pos.y+20);
                //}
                mDirection=0;
                break;
            }
            case Right: {

                hero.toGo.setX(pos.x+20);
                mDirection=0;
                break;
            }
            case Left: {

                hero.toGo.setX(pos.x-20);
                mDirection=0;
                break;
            }



        }

        for (int i = 0; i < block.length; i++){
            block[i].draw(canvas);
        }
        for (int i = 0; i < ladder.length; i++){
            ladder[i].draw(canvas);
        }
        onGround = false;
        for (int i = 0; i < block.length; i++){

            /*if (block[i].y1+30 <= hero.pos.y +(heropic.getHeight()) & block[i].y1 >= hero.pos.y +(heropic.getHeight())
                    & block[i].x1 <= hero.pos.x
                    & block[i].x2 >= hero.pos.x +(heropic.getWidth())){*/
                onGround = true;
                //hero.pos.setY(pos.y-50);
            //}
        }
        if (onGround == false ){

            hero.toGo.setY((float) (pos.y-0.5));

        }

        hero.draw(canvas);
        hero.move(canvas);

        this.invalidate();
    }
}
