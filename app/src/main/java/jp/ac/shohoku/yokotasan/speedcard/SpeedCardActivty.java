package jp.ac.shohoku.yokotasan.speedcard;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
    public static int width = 0;
    public static int height = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specifya parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override

    public void onWindowFocusChanged(boolean hasFocus) {
// TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        // Viewのサイズを取得
        SpeedCardView sview = (SpeedCardView) findViewById(R.id.SpeedCardView);
        width = sview.getWidth();
        height = sview.getHeight();
    }

    /**
     * SpeedCardViewの幅を取得
     * @return
     */
    public static int getViewWidth(){
        return width;
    }

    /**
     * SpeedCardViewの高さを取得
     * @return
     */
    public static int getViewHeight() {
        return height;
    }
}
