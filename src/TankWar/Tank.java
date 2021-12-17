package TankWar;

import java.awt.*;
import java.util.Random;

//封装坦克属性
public class Tank {
    public static final int WIDTH = ResourceMgr.goodTankU.getWidth() ;
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight() ;
    private static final int SPEED = Integer.parseInt((String)PropertyMgr.get("tankSpeed")); // 配置文件修改

    Rectangle rect = new Rectangle();

    private int x,y;
    private Dir dir = Dir.UP;
    private boolean moving = false;
    private Random random = new Random();  //随机
    private Group group = Group.BAD;

    private TankFrame tf = null;     //和 TankFrame 引用起来           构造方法里
    private boolean living = true;

    public Tank(){}

    public void setDir(Dir dir){
        this.dir = dir;
    }
    public Dir getDir(){
        return dir;
    }
    public void setMoving(boolean moving){
        this.moving = moving;
    }
    public boolean isMoving() {
        return moving;
    }

    public Tank(int x, int y, Dir dir,Group group,TankFrame tf){  //把自己传进去，传之后就拥有了窗口的引用
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;  //...
        rect.y = this.y;  //...
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if(!living){             //   清除list
            tf.enemy.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankL : ResourceMgr.badTankL, x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankR : ResourceMgr.badTankR,x,y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankU : ResourceMgr.badTankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankD : ResourceMgr.badTankD,x,y,null);
                break;
        }

        move();
    }

    private void move() {
        if(!living){
            return;
        }
        if(!moving){            //...........
            return;
        }
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }

        if(this.group == Group.BAD && random.nextInt(100)<3){  //（0-100 ） <3的时候开火  概率
            this.fire();
        }
        if(this.group == Group.BAD && random.nextInt(100)<3) {
            randomDir();
        }
        //边界检测 boundsCheck
        boundsCheck();

        rect.x = this.x;  //...要在边界检测之后
        rect.y = this.y;  //...

    }

    private void boundsCheck() {
        if(this.x < 3 ){x = 3;}
        if(this.y < 113){y = 113;}
        if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 3){x = TankFrame.GAME_WIDTH - Tank.WIDTH - 3;}
        if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT -3){y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 3;}
    }

    private void randomDir() {      //随机换方向
        this.dir = Dir.values()[random.nextInt(4)]; //  下标为0-3的数组值

    }

    public void fire() {
        //可以int一个距离参数
        int bx = this.x + (Tank.WIDTH - Bullet.WIDTH)/2;
        int by = this.y + (Tank.HEIGHT - Bullet.HEIGHT)/2;
        tf.bullets.add(new Bullet(bx ,by , this.dir, this.group,this.tf));
    }
    public void setGroup(Group group){
        this.group = group;
    }
    public Group getGroup(){
        return group;
    }


    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }

    public void die() {
        this.living = false;
    }
}




