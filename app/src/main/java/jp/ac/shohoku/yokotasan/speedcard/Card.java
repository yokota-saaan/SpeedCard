package jp.ac.shohoku.yokotasan.speedcard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
/**
 * 一枚一枚のカードを表すクラス
 * @author miku.E
 * @version 0.128 */

public class Card {
    private Bitmap mBmp = null;
    private Rect mLocation;
    private boolean mIsTapped;
    private int mW, mH;
    public Card(SpeedCardView sview, String cardName) {
        Resources rs = sview.getResources();  //リソースを取得
        Context context = sview.getContext();  //パッケージ名を取得するためにContextを取得 int resId = rs.getIdentifier(cardName, "drawable", context.getPackageName());
        mBmp = BitmapFactory.decodeResource(rs, resId); //画像を取得
        mW = mBmp.getWidth();
        mH = mBmp.getHeight();
        setmLocation(0, 0, mW, mH); //いったん左上に配置
        mIsTapped = false; //タップされていない
    }
    public void setmLocation(int left, int top, int right, int bottom) {
        mLocation = new Rect(left, top, right, bottom);
    }
    public boolean checkTapped(int x, int y) {
        if(mLocation.left < x && x < mLocation.right && mLocation.top < y && y < mLocation.bottom) {
            return true;
        } else {
            return false;
        }
    }
    public void setTapped(boolean b) {
        mIsTapped = b;
    }
    public boolean isTapped() {
        return mIsTapped;
    }
    public int getW() {
        return mW;
    }
    public int getH() {
        return mH;
    }
    public void draw(Canvas canvas) {
        float left = mLocation.left;
        float top = mLocation.top;
        if (mBmp != null) {
            canvas.drawBitmap(mBmp, left, top, new Paint());
        }
    }
}
