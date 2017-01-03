package samsung.itschool.nick.platformer;

import android.view.View;

import static samsung.itschool.nick.platformer.MyDraw.mDirection;


/**
 * Created by User on 30.12.2016.
 */
public class DownListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        mDirection = 2;
    }
}
