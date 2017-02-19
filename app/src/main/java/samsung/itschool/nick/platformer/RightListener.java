package samsung.itschool.nick.platformer;

import android.view.MotionEvent;
import android.view.View;

import static samsung.itschool.nick.platformer.MyDraw.mDirection;
import static samsung.itschool.nick.platformer.MyDraw.turnDirection;
;

/**
 * Created by User on 30.12.2016.
 */
public class RightListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN //||
                /*event.getAction() == MotionEvent.ACTION_CANCEL*/) {
            turnDirection= 3;

        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            turnDirection= 0;
        }
        return false;
    }

}


