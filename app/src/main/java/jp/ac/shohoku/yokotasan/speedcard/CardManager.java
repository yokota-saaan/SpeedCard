package jp.ac.shohoku.yokotasan.speedcard;

import android.graphics.Canvas;
import java.util.Random;

import javax.smartcardio.Card;

/**
 * カード全体を管理するクラス
 * @author yokotasan
 * @version 2018.12.6
 */

public  class CardManager{
    Card mCards[]; //ゲームで使うカードの配列
    int mCount;    //どこまでカウントしたかを表す変数
    /**
     * カードを枚数分用意する
     * @param sview 表示するSpeedCardView
     * @param num 生成するカードの枚数
     */

    CardManager(SpeedCardView sview, int num){
        mCards = new Card[num];
        for (int i=1; i<=num; i++){
            mCards[i-1] = new Card(sview, "card"+i);  //カードの名前はcard1, card2, ...
        }
        mCount = 0; //はじめはカウントされていないので0としておく
        distCards();  //カードを配布
    }
    /**
     * カードを配布
     */

    public void distCards(){
        int left, top, right, bottom;
        Random rand = new Random();
        for (int i = mCards.length -1; i >= 0; i--) {
            left=rand.nextInt(MainActivity.getViewWidth() -mCards[i].getW());
            top=rand.nextInt(MainActivity.getViewHeight() -mCards[i].getH());
            right = left + mCards[i].getW();
            bottom = top + mCards[i].getH();
            mCards[i].setmLocation(left, top, right, bottom);
        }
    }
    /**
     * タップされるべき最小の番号のカードがタップされているかどうかチェックする
     * @param x
     * @param y
     */
    public void checkCards(int x, int y){
        if(mCards[mCount].checkTapped(x,y)){
            mCards[mCount].setTapped(true);
            mCount++;
        }
    }

    /**
     * すべてのカードがタップされたかどうかをチェックする．
     * 最後のカードがタップされたかどうかでチェックしている．
     * すべてのカードがタップされていればtrue, そうでなければfalse
     * @return true or false
     */

    public boolean isFinished() {
        if (mCards.length <= mCount) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * タップされていないすべてのカードを描画する
     * @param canvas
     */

    public void draw(Canvas canvas) {
        for (int i = mCards.length -1; i >= mCount; i--) {
            if(mCards[i].isTapped() == false){
                mCards[i].draw(canvas);
            }
        }
    }
}
