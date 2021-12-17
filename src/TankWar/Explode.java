//子弹类
package TankWar;

import java.awt.*;

public class Explode {      //爆炸
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;


    TankFrame tf = null;
    private int step = 0;
    //构造方法
    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
     //   new Audio("audio/explode.wav").play(); //声音
    }

    //画笔画出来
    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step >= ResourceMgr.explodes.length){
            tf.explodes.remove(this);  //爆炸完去掉
        }

    }
}