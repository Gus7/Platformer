package samsung.itschool.nick.platformer;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static samsung.itschool.nick.platformer.DBManager.dbManager;
import static samsung.itschool.nick.platformer.FirstSplashDraw.height;
import static samsung.itschool.nick.platformer.FirstSplashDraw.width;
import static samsung.itschool.nick.platformer.Hero.pos;
import static samsung.itschool.nick.platformer.MainActivity.fire;
import static samsung.itschool.nick.platformer.SuperAdapter.levelId;

/**
 * Created by User on 29.12.2016.
 */

public class MyDraw extends View  {

    public static int mDirection;
    public static int turnDirection;
    public static int side = 0;
    private static final int Up = 1;
    private static final int Down = 2;
    private static final int Right = 3;
    private static final int Left = 4;




    void start(Context context)
    {
        int id = levelId+1;
        rubypic = BitmapFactory.decodeResource(context.getResources(), R.drawable.ruby);
        thrower = BitmapFactory.decodeResource(context.getResources(), R.drawable.thrower);
        throwerl = BitmapFactory.decodeResource(context.getResources(), R.drawable.throwerl);
        herostpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.herost);
        heropic = BitmapFactory.decodeResource(context.getResources(), R.drawable.hero);
        heropicl = BitmapFactory.decodeResource(context.getResources(), R.drawable.herol);
        heropic2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.hero2);
        heropicl2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.herol2);
        heropic3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.hero3);
        heropicl3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.hero3l);
        heropic4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.hero4);
        heropicl4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.hero4l);
        ladderpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.ladder);
        blockpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.block);
        mobpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.mob);
        mobpic2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.mob2);
        doorpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.door);
        bulletpic = BitmapFactory.decodeResource(context.getResources(), R.drawable.bullet);
        heropla2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.heroonl2);
        heropla = BitmapFactory.decodeResource(context.getResources(), R.drawable.heroonl);
        th3= BitmapFactory.decodeResource(context.getResources(), R.drawable.th3);
        th2= BitmapFactory.decodeResource(context.getResources(), R.drawable.th2);
        th2l= BitmapFactory.decodeResource(context.getResources(), R.drawable.th2l);
        th3l= BitmapFactory.decodeResource(context.getResources(), R.drawable.th3l);
        /*h1l= BitmapFactory.decodeResource(context.getResources(), R.drawable.h1l);
        h2l= BitmapFactory.decodeResource(context.getResources(), R.drawable.h2l);
        h3l= BitmapFactory.decodeResource(context.getResources(), R.drawable.h3l);
        h4l= BitmapFactory.decodeResource(context.getResources(), R.drawable.h4l);
        */h5l= BitmapFactory.decodeResource(context.getResources(), R.drawable.h5l);
        h5= BitmapFactory.decodeResource(context.getResources(), R.drawable.h5);
        /*h4= BitmapFactory.decodeResource(context.getResources(), R.drawable.h4);
        h3= BitmapFactory.decodeResource(context.getResources(), R.drawable.h3);
        h2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.h2);
        h1= BitmapFactory.decodeResource(context.getResources(), R.drawable.h1);
            */
        side = 0;
        try {
            /*

            //создаем объект FileReader для объекта File
            FileReader fr = sp FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания

            // считаем сначала первую строку*/

            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = new InputStreamReader(assetManager.open("a.txt"));
            BufferedReader reader = new BufferedReader(istream);










            String line_ = reader.readLine();
            line_ = reader.readLine();
            String[] levs_ = line_.split(";");
            String[] words_ = levs_[1].split(" ");

            String Name = words_[1];

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            hero = new Hero(Float.parseFloat(words_[1])*width/1920, Float.parseFloat(words_[2])*height/1005, 1, context);
            //hero.pos.set(200.1f,400f);
            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            hero.toGo = new Vector(1,1);
            hero.toGo.set(Float.parseFloat(words_[1])*width/1920, Float.parseFloat(words_[2])*height/1005);


            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            int N_Ladd = 2;
            N_Ladd = Integer.parseInt(words_[1]);
            //int N_Ladd = Integer.parseInt(words_[1]);
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
            int N_Blo = 1;
            N_Blo = Integer.parseInt(words_[1]);
            //int N_Blo = Integer.parseInt(words_[1]);
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
            String Background = words_[1];

            int resourceId = context.getResources().getIdentifier(Background, "drawable", context.getPackageName());

            background = BitmapFactory.decodeResource(context.getResources(), resourceId);


            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            door = new Door(Float.parseFloat(words_[1])*width/1920, Float.parseFloat(words_[2])*height/1005,
                    Float.parseFloat(words_[3])*width/1920, Float.parseFloat(words_[4])*height/1005,doorpic, context);


            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            int N_Mob = 1;
            N_Mob = Integer.parseInt(words_[1]);
            //int N_Blo = Integer.parseInt(words_[1]);
            mob = new Moby[N_Mob];

            //Log.i(TAG, N_Blo + " ++++++++++++++++++++++++++++++");

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] mobX1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] mobY1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] mobX2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] mobY2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] mobSPX = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            int N_Rub = 1;
            N_Rub = Integer.parseInt(words_[1]);
            //int N_Blo = Integer.parseInt(words_[1]);
            ruby = new Ruby[N_Rub];

            //Log.i(TAG, N_Blo + " ++++++++++++++++++++++++++++++");

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] rubyX1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] rubyY1 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] rubyX2 = words_;

            line_ = reader.readLine();
            levs_ = line_.split(";");
            words_ = levs_[id].split(" ");
            String[] rubyY2 = words_;



            reader.close();
            for(int i = 0; i < ruby.length; i++){
                ruby[i] = new Ruby(Float.parseFloat(rubyX1[2*i+1])*width/1920,Float.parseFloat(rubyY1[2*i+1])*height/1005,
                        Float.parseFloat(rubyX2[2*i+1])*width/1920,Float.parseFloat(rubyY2[2*i+1])*height/1005,
                        rubypic, context);
            }

            for(int i = 0; i < ladder.length; i++){
                ladder[i] = new Ladder(Float.parseFloat(ladderX1[2*i+1])*width/1920,Float.parseFloat(ladderY1[2*i+1])*height/1005,Float.parseFloat(ladderX2[2*i+1])*width/1920,Float.parseFloat(ladderY2[2*i+1])*height/1005,
                        context, ladderpic);
            }

            for(int i = 0; i < block.length; i++){
                //Log.i(TAG,Float.parseFloat(blockX1[i])+ Float.parseFloat(blockY1[i])+ Float.parseFloat(blockX2[i])+Float.parseFloat(blockY2[i])+ " ");
                block[i] = new Block(Float.parseFloat(blockX1[2*i+1])*width/1920,Float.parseFloat(blockY1[2*i+1])*height/1005,Float.parseFloat(blockX2[2*i+1])*width/1920,Float.parseFloat(blockY2[2*i+1])*height/1005,
                        context, blockpic);
            }

            for(int i = 0; i < mob.length; i++){
                if (i % 2 == 0){
                mob[i] = new Moby(Float.parseFloat(mobX1[2*i+1])*width/1920,Float.parseFloat(mobY1[2*i+1])*height/1005,Float.parseFloat(mobX2[2*i+1])*width/1920,Float.parseFloat(mobY2[2*i+1])*height/1005,
                        Float.parseFloat(mobSPX[2*i+1])*width/1920, mobpic);
                }else {
                    mob[i] = new Moby(Float.parseFloat(mobX1[2*i+1])*width/1920,Float.parseFloat(mobY1[2*i+1])*height/1005,Float.parseFloat(mobX2[2*i+1])*width/1920,Float.parseFloat(mobY2[2*i+1])*height/1005,
                            Float.parseFloat(mobSPX[2*i+1])*width/1920, mobpic2);
                }
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
            ladder[i] = sp Ladder(480,270,580,760,
                    context, R.drawable.ladder);
        }
        hero = sp Hero(600,750-200, 1, context, R.drawable.hero);

        block[0] = sp Block(0,845,480,845+10,context, R.drawable.block);
        block[1] = sp Block(480,760,960,760+10,context, R.drawable.block);
        block[2] = sp Block(960,675,1920,675+10,context, R.drawable.block);
        block[3] = sp Block(960,405,1920,405+10,context, R.drawable.block);
        block[4] = sp Block(480,270,960,270+10,context, R.drawable.block);
        */

    }
    Hero hero;
    Door door;
    Block[] block;
    Ladder[] ladder;
    Moby[] mob;
    Ruby[] ruby;
    static ArrayList<Bullet> bullet = new ArrayList<>();
    Bitmap rubypic;
    Bitmap background;
    Bitmap heropic;
    Bitmap heropicl;
    Bitmap herostpic;
    Bitmap heropic2;
    Bitmap heropicl2;
    Bitmap ladderpic;
    Bitmap blockpic;
    Bitmap mobpic;
    Bitmap mobpic2;
    Bitmap doorpic;
    Bitmap thrower;
    Bitmap throwerl;
    Bitmap heropla;
    Bitmap heropla2;
    Bitmap th3;
    Bitmap th2;
    Bitmap th3l;
    Bitmap th2l;
    Bitmap heropic3;
    Bitmap heropicl3;
    Bitmap heropic4;
    Bitmap heropicl4;
    Bitmap h5l;/*
    Bitmap h4l;
    Bitmap h3l;
    Bitmap h2l;
    Bitmap h1l;*/
    Bitmap h5;/*
    Bitmap h4;
    Bitmap h3;
    Bitmap h2;
    Bitmap h1;*/
    static Bitmap bulletpic;
    Paint p = new Paint();


    public MyDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        start(context);
        this.context = context;
    }


    void Physic(float w, float h){

        onGround = false;
        onLadder = false;



        for (int i = 0; i < block.length; i++) {

            if (block[i].y1 - 80*width/1080  <= pos.y  && block[i].y1 -60*width/1080 >= pos.y
                    && block[i].x1-20*width/1920 <= hero.pos.x
                    && block[i].x2+20*width/1920 >= hero.pos.x){
                onGround = true;
                hero.toGo.setY(hero.pos.y);
                //hero.pos.setY(hero.pos.y);
            }
        }
        for (int i = 0; i < ladder.length; i++){
            if (ladder[i].y1 - 70*width/1080 <= hero.pos.y & ladder[i].y2 >= hero.pos.y & ladder[i].x1 <= hero.pos.x & ladder[i].x2 >= hero.pos.x ){
                onLadder = true;
                //hero.toGo.setY(hero.pos.y);
            }
        }
        for (int i = 0; i < mob.length; i++) {

            if (mob[i].y1 - 60*width/1080 <= hero.pos.y && mob[i].y2 + 40*width/1080 >= hero.pos.y
                    && mob[i].x1 - 20*height/1920  <= hero.pos.x
                    && mob[i].x2 + 20*height/1920 >= hero.pos.x){
                bullet.clear();
                numf =0;
                try{
                dbManager.addResult(levelId+1,
                        rubies, (int) mobs);
                }catch (NullPointerException e) {
                    e.printStackTrace();
                    Log.i(TAG,"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                }

                mobs = 0;
                rubies = 0;
                MainActivity.rubies.setText("Rubies: " + rubies);
                MainActivity.mobs.setText("Mobs: " + (int)(mobs));
                start(getContext());

            }
        }
        if (pos.y > h + 200 || pos.y < 0-200 || pos.x > w + 300 || pos.x < 0 - 300   ){
            bullet.clear();
            numf =0;
            try{
                dbManager.addResult(levelId+1,
                        rubies, (int) mobs);
            }catch (NullPointerException e) {
                e.printStackTrace();
                Log.i(TAG,"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb2");
            }
            mobs = 0;
            rubies = 0;
            MainActivity.rubies.setText("Rubies: " + rubies);
            MainActivity.mobs.setText("Mobs: " + (int)(mobs));

            start(getContext());
        }
        if (bullet.size() > 0) {
            for (int i = 0; i < mob.length; i++) {
                for (int j = 0; j < bullet.size(); j++) {
                    if (mob[i].y1 <= bullet.get(j).y & mob[i].y2 >= bullet.get(j).y & mob[i].x1 <= bullet.get(j).x + bulletpic.getWidth() & mob[i].x2 >= bullet.get(j).x) {
                        mob[i].isalife = false;
                        bullet.get(j).isalife = false;
                        mobs += 0.5;
                        //hero.toGo.setY(hero.pos.y);
                        MainActivity.mobs.setText("Mobs: " + (int)(mobs));
                    }
                }
            }
        }

        for (int i =0 ; i < ruby.length; i++){
                if (ruby[i].x1 <= pos.x && ruby[i].x2 >= pos.x && ruby[i].y1-40 <= pos.y && ruby[i].y2  >= pos.y){
                    ruby[i].x1 = 10000;
                    rubies += 1;
                    MainActivity.rubies.setText("Rubies: " + rubies);
                }
        }




    }
    float mobs = 0;
    int rubies = 0;
    boolean onLadder;
    boolean onGround;
/* Поменять всеееее при вводе карты!!!!!!!!!!!!!!!!!*/
    Context context;
    RectF rectF;
    int numstep = 0;
    int numl = 0;
    int numfire = 0;
    int numf=0;
    @Override
    public void onDraw(Canvas canvas) {
        //Log.i(TAG,canvas.getHeight() + " " + canvas.getWidth() );


        Physic(canvas.getWidth(), canvas.getHeight());
        rectF = new RectF(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.drawBitmap(background, null, rectF , p);
        //canvas.drawColor(Color.GREEN);
        for (int i = 0; i < block.length; i++){
            block[i].draw(canvas, blockpic);
        }
        for (int i = 0; i < ladder.length; i++){
            ladder[i].draw(canvas, ladderpic);
        }


        for (int i = 0; i < mob.length; i++){
            if(mob[i].isalife){
                if(i%2==0) mob[i].draw(canvas, mobpic);
                else mob[i].draw(canvas, mobpic2);
            mob[i].move(canvas);}
            else {mob[i].y1 -= 10000;
                mob[i].y2 -= 10000;}
        }
        if (bullet.size() > 0) {
            for (int i = 0; i < bullet.size(); i++) {
                if (bullet.get(i).isalife) {
                    bullet.get(i).move(canvas);
                    bullet.get(i).draw(canvas);
                } else {
                    bullet.remove(i);
                }
            }
        }


        switch (mDirection) {
            case Up: {

                if(onLadder && onGround){
                    //hero.toGo.setY(pos.y-50*height/1080);
                    hero.pos.setY(pos.y-50*height/1080);
                }
                else if(onLadder && !onGround){
                    hero.toGo.setY(pos.y-50*height/1080);
                }else if (onGround && !onLadder){
                    hero.pos.setY(pos.y-180*height/1080);

                    //hero.toGo.setY(pos.y-2050);


                }


                break;
            }

            case Down: {
                



                if(onLadder && onGround){
                    hero.pos.setY(pos.y+15*height/1080);}
                else if(onLadder && !onGround){
                    hero.toGo.setY(pos.y+40*height/1080);
                }else if (onGround && !onLadder){
                    hero.pos.setY(pos.y+70*height/1080);

                    //hero.toGo.setY(pos.y-2050);


                }


                break;
            }




        }


        switch (turnDirection) {

            case Right: {

                if (side == 3){
                if (onGround == false && onLadder == false ) hero.toGo.setX(pos.x+100*width/1920);
                else if(onLadder == true)hero.toGo.setX(pos.x+20*width/1920);
                else hero.toGo.setX(pos.x+70*width/1920);}
                else{
                    hero.toGo.setX(pos.x+0*width/1920);
                }
                side = 3;
                break;
            }
            case Left: {
                if (side == 4) {
                    if (onGround == false && onLadder == false)
                        hero.toGo.setX(pos.x - 100 * width / 1920);
                    else if (onLadder == true) hero.toGo.setX(pos.x - 20 * width / 1920);
                    else hero.toGo.setX(pos.x - 70 * width / 1920);
                }
                else{
                    hero.toGo.setX(pos.x-0*width/1920);
                }
                side = 4;
                break;
            }

        }
        door.draw(canvas);
        for (int i = 0; i < ruby.length; i++){
            ruby[i].draw(canvas);
        }
        /*if(turnDirection == 0){
            if(side == 4) hero.draw(canvas, heropicl);
            if(side == 3) hero.draw(canvas, heropic);
        }*/
        if (fire == 0&& onGround ) {
            numf = 0;
            if (side == 4&& turnDirection != 0 ) {
                if (numstep == 14 || numstep == 15 || numstep == 13 || numstep ==12 && onGround){
                    hero.draw(canvas, heropicl4);
                    numstep += 1;
                    if (numstep == 16) numstep = 0;}
                else if (numstep == 8 || numstep == 9||numstep == 10 || numstep == 11 && turnDirection != 0){
                    numstep += 1;
                    hero.draw(canvas, heropicl3);}
                else if (numstep == 4 || numstep == 5 || numstep == 6 || numstep == 7 && onGround){
                    hero.draw(canvas, heropicl2);
                    numstep += 1;
                }
                else if (numstep == 2 || numstep == 3||numstep == 1 || numstep == 0 && turnDirection != 0){
                    numstep += 1;
                    hero.draw(canvas, heropicl);}

            } else if (side == 3&& turnDirection != 0) {
                if (numstep == 14 || numstep == 15 || numstep == 13 || numstep ==12 && onGround){
                        hero.draw(canvas, heropic4);
                        numstep += 1;
                    if (numstep == 16) numstep = 0;}
                else if (numstep == 8 || numstep == 9||numstep == 10 || numstep == 11 && turnDirection != 0){
                            numstep += 1;
                            hero.draw(canvas, heropic3);}
                else if (numstep == 4 || numstep == 5 || numstep == 6 || numstep == 7 && onGround){
                    hero.draw(canvas, heropic2);
                    numstep += 1;
                    }
                else if (numstep == 2 || numstep == 3||numstep == 1 || numstep == 0 && turnDirection != 0){
                    numstep += 1;
                    hero.draw(canvas, heropic);}


            }else if(turnDirection == 0&& fire == 0){
                if(side == 4) hero.draw(canvas, heropicl);
                else if(side == 3) hero.draw(canvas, heropic);
            else hero.draw(canvas, herostpic);}
        }else if(onLadder&&fire == 0 && !onGround){
            numf =0;
            if(mDirection != 0) {
                if (numl == 4 || numl == 5 || numl == 6 || numl == 7) {
                    hero.draw(canvas, heropla);
                    numl += 1;
                    if (numl == 8) numl = 0;
                } else if (numl == 2 || numl== 3 || numl== 1 || numl== 0) {
                    numl += 1;
                    hero.draw(canvas, heropla2);
                }
            }else hero.draw(canvas, heropla);
        }
        else if (!onLadder && !onGround){
            if(side == 3)hero.draw(canvas, h5);
            else if(side == 4)hero.draw(canvas, h5l);
            else hero.draw(canvas, herostpic);
            fire = 0;/*
                if(side == 3) {
                if (numf >= 14 || numf == 13 || numf == 12) {
                    hero.draw(canvas, h5);
                    numf += 1;
                } else if (numf == 9|| numf == 10 || numf == 11 ) {
                    hero.draw(canvas, h4);
                    numf += 1;
                }else if (numf == 8 || numf == 7 || numf == 6) {
                    hero.draw(canvas, h3);
                    numf += 1;
                }else if (numf == 3|| numf == 4|| numf == 5) {
                    hero.draw(canvas, h2);
                    numf += 1;
                }else if (numf == 2 || numf == 1 || numf == 0 ) {
                    hero.draw(canvas, h1);
                    numf += 1;
                }

            }
            else if(side == 4) {
                if (numf == 9|| numf == 10 || numf >= 11) {
                    hero.draw(canvas, h5l);
                    numf += 1;
                } else if (numf == 8 || numf == 7 || numf == 6 ) {
                    hero.draw(canvas, h4l);
                    numf += 1;
                }else if (numf == 3|| numf == 4|| numf == 5) {
                    hero.draw(canvas, h3l);
                    numf += 1;
                }else if (numf == 2 || numf == 1 || numf == 0 ) {
                    hero.draw(canvas, h1l);
                    numf += 1;
                }
            }*/


        }
        else if(fire == -1){
            if (  numfire== 9 ||numfire== 12|| numfire== 10|| numfire== 11 ) {
                hero.draw(canvas, th3l);
                numfire += 1;
                if (numfire== 13){
                    numfire = 0;
                    fire = 0;
                }
            } else if (numfire == 5  || numfire== 4||numfire == 6 ||numfire== 7|| numfire== 8) {
                numfire += 1;
                hero.draw(canvas, th2l);
            }else if (numfire == 2 || numfire== 1 || numfire== 0|| numfire== 3) {
                numfire += 1;
                hero.draw(canvas, throwerl);
            }


        }else if (fire == 1){
            if (  numfire== 9 ||numfire== 12|| numfire== 10|| numfire== 11 ) {
                hero.draw(canvas, th3);
                numfire += 1;
                if (numfire== 13){
                    numfire = 0;
                    fire = 0;
                }
            } else if (numfire == 5  || numfire== 4||numfire == 6 ||numfire== 7|| numfire== 8) {
                numfire += 1;
                hero.draw(canvas, th2);
            }else if (numfire == 2 || numfire== 1 || numfire== 0|| numfire== 3) {
                numfire += 1;
                hero.draw(canvas, thrower);
            }
        }
        Physic(canvas.getWidth(), canvas.getHeight());


        if (onGround == false && onLadder == false ){
            //Toast.makeText(this.getContext(), "Toast", Toast.LENGTH_SHORT).show();
            hero.toGo.setY( (hero.pos.y + 100*height/1080));

        }




        hero.move(canvas);


        if (door.x1 <= pos.x && door.x2 >= pos.x && door.y1 <= pos.y && door.y2>= pos.y){



            numf =0;
            bullet.clear();
            levelId += 1;
            if (levelId==5)try{
                levelId = 0;
                //dbManager.addResult(levelId,
                 //       rubies, (int) mobs);
            }catch (NullPointerException e) {
                e.printStackTrace();

                Log.i(TAG,"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb3");
            }
            start(getContext());


        }




        this.invalidate();
    }



}