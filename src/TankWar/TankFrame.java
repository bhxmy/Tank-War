package TankWar;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame{   //重写Frame里的方法
    static final int GAME_WIDTH = Integer.parseInt((String)PropertyMgr.get("gameWidth"));
    static final int GAME_HEIGHT = Integer.parseInt((String)PropertyMgr.get("gameHigh"));

//调用Tank
    Tank myTank = new Tank((GAME_WIDTH-Tank.WIDTH)/2,(GAME_HEIGHT-100+Tank.HEIGHT/2),Dir.UP,Group.GOOD,this);


    List<Bullet> bullets = new ArrayList<>();       //子弹容器........... 加子弹
    List<Tank> enemy = new ArrayList<>();  //复数
    List<Explode> explodes = new ArrayList<>();
    Explode e = new Explode(100,100,this);


   //   Bullet b = new Bullet(300,300,Dir.UP ,this); 一个子弹

    public TankFrame(){
        this.setSize(GAME_WIDTH,GAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("坦克大战");
        this.setVisible(true);
        this.addKeyListener(new MyKeyListener());       //键盘监听处理对象
//可以点×关闭窗口..................................................................
        this.addWindowListener(new WindowAdapter(){         //这里括号在下面
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
//解决闪烁问题.............................................................................
    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.DARK_GRAY);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    @Override
    public void paint(Graphics g){   //添加画笔
        Color c = g.getColor();
        g.setColor(Color.GREEN);
        g.drawString("子弹的数量：" + bullets.size(),10,60);
        g.drawString("敌人的数量：" + enemy.size(),10,80);
        g.drawString("爆炸的数量：" + explodes.size(),10,100);
        g.drawString("_______________________________________________________________________________" +
                "________________________________________________________________________________" ,10,110);

        g.setColor(c);
//画笔传过去，画出坦克，子弹..............................................................
        myTank.paint(g);
        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).paint(g);
        }
//画敌人坦克
        for(int i = 0; i < enemy.size(); i++){
            enemy.get(i).paint(g);
        }
//判断碰撞
        for(int i = 0; i< bullets.size(); i++){               //每一次绘画把所有子弹和所有坦克进项判断
            for(int j = 0; j < enemy.size(); j++){
                bullets.get(i).collideWith(enemy.get(j));
            }
        }
//画爆炸
        for(int i = 0; i < explodes.size(); i++){
            explodes.get(i).paint(g);
        }


    }
    class MyKeyListener extends KeyAdapter { //处理键盘
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key){
                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;
                default:
                    break;
            }
           setMainTankDir(); //设定坦克方向
        }
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch(key){
                case KeyEvent.VK_LEFT:
                    bL=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    break;
                case KeyEvent.VK_UP:
                    bU=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    break;
                //抬起Ctrl打出子弹
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;

                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {


            if (!bL && !bR && !bU && !bD) {
                myTank.setMoving(false);
            }
            else{
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);  // if只有一条语句的时候{}可以省去，不建议省去（因为不保证以后不会加代码）
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);


                }
        }
    }
}
