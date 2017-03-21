package samsung.itschool.nick.platformer;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.R.attr.port;

import static android.R.attr.x;
import static android.R.attr.y;
import static android.content.ContentValues.TAG;
import static java.lang.System.in;
import static samsung.itschool.nick.platformer.Vector.v;
import static samsung.itschool.nick.platformer.Hero.pos;
import static samsung.itschool.nick.platformer.SuperAdapter.levelId;


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
        int id = levelId;
        try {
            /*

            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания

            // считаем сначала первую строку*/

            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = new InputStreamReader(assetManager.open("/assets/a.txt"));
            BufferedReader reader = new BufferedReader(istream);




            String line_ = reader.readLine();

            line_ = reader.readLine();
            String[] levs_ = line_.split(";");
            String[] words_ = levs_[id].split(" ");
            String Name = words_[0];

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            hero = new Hero(600,750-200, 1, context, R.drawable.hero);
            hero.pos.set(Float.parseFloat(words_[0]), Float.parseFloat(words_[1]));

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            int N_Ladd = Integer.parseInt(words_[0]);
            ladder = new Ladder[N_Ladd];

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] ladderX1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] ladderY1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] ladderX2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] ladderY2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            int N_Blo = Integer.parseInt(words_[0]);
            block = new Block[N_Blo];

            Log.i(TAG, N_Blo + " ++++++++++++++++++++++++++++++");

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] blockX1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] blockY1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] blockX2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] blockY2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String Background = words_[0];

            reader.close();

            for(int i = 0; i < ladder.length; i++){
                ladder[i] = new Ladder(Float.parseFloat(ladderX1[i]),Float.parseFloat(ladderY1[i]),Float.parseFloat(ladderX2[i]),Float.parseFloat(ladderY2[i]),
                        context, R.drawable.ladder);
            }

            for(int i = 0; i < block.length; i++){
                Log.i(TAG,Float.parseFloat(blockX1[i])+ Float.parseFloat(blockY1[i])+ Float.parseFloat(blockX2[i])+Float.parseFloat(blockY2[i])+ " ");
                block[i] = new Block(Float.parseFloat(blockX1[i]),Float.parseFloat(blockY1[i]),Float.parseFloat(blockX2[i]),Float.parseFloat(blockY2[i]),
                        context, R.drawable.block);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i(TAG,"///////////////////////////////////////////////////");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG,"--------------------------------------------------");
        }

        /*
        for(int i = 0; i < ladder.length; i++){
            ladder[i] = new Ladder(480,270,580,760,
                    context, R.drawable.ladder);
        }
        hero = new Hero(600,750-200, 1, context, R.drawable.hero);

        block[0] = new Block(0,845,480,845+10,context, R.drawable.block);
        block[1] = new Block(480,760,960,760+10,context, R.drawable.block);
        block[2] = new Block(960,675,1920,675+10,context, R.drawable.block);
        block[3] = new Block(960,405,1920,405+10,context, R.drawable.block);
        block[4] = new Block(480,270,960,270+10,context, R.drawable.block);
        */

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
        Log.i(TAG,"Обвал тут");
        Toast.makeText(this.getContext(), "Toast", Toast.LENGTH_SHORT).show();

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