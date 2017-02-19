package samsung.itschool.nick.platformer;

import android.view.MotionEvent;
import android.view.View;

import static samsung.itschool.nick.platformer.MyDraw.mDirection;
import static samsung.itschool.nick.platformer.MyDraw.turnDirection;
;

/**
 * Created by User on 30.12.2016.
 */
public class UpListener implements View.OnTouchListener
{

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN//||
                /*event.getAction() == MotionEvent.ACTION_CANCEL*/) {
            mDirection = 1;

        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            mDirection = 0;
        }
        return false;
    }
}
