//子弹类
package TankWar;

import java.awt.*;

public class Bullet {
    public static final int WIDTH = ResourceMgr.bulletL.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletL.getHeight();
    private static final int SPEED = Integer.parseInt((String)PropertyMgr.get("bulletSpeed"));

    Rectangle rect = new Rectangle();

    private int x,y;
    private Dir dir;
    private boolean living = true;   //也处理子弹边界问题
    private Group group = Group.BAD;

    TankFrame tf = null;

    public void setGroup(Group group){
        this.group = group;
    }
    public Group getGroup(){
        return group;
    }
    //构造方法
    public Bullet(int x, int y, Dir dir,Group group, TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf=tf;

        rect.x = this.x;  //...
        rect.y = this.y;  //...
        rect.width = WIDTH;
        rect.height = HEIGHT;


    }
    //画笔画出来
    public void paint(Graphics g){
        if(!living){
            tf.bullets.remove(this);  // ..............
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x-Tank.WIDTH/2,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x+Tank.WIDTH/2,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y- Tank.HEIGHT/2,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y+Tank.HEIGHT/2,null);
                break;
        }

        move();

    }

    private void move() {

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

        //move完之后 更新rect. update rect
        rect.x = this.x;
        rect.y = this.y;

        if(x < 0|| y< 0  || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
            living = false;
        }
    }

    public void  collideWith(Tank tank) {  //碰撞的方法（可以重新定义成圆形判断圆心距离）或者直接调用自带的intersects方法
        if(this.group == tank.getGroup()){
            return;
        }
        // todo: 用一个rect来记录子弹位置            修改后是矩形跟随坦克和子弹走
        //  Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);        这是碰撞的时候new出2个矩形
        //  Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if(rect.intersects(tank.rect)){
            this.die();
            tank.die();
            int ex = tank.getX() + (Tank.WIDTH - Explode.WIDTH)/2;       // .........................................
            int ey = tank.getY() + (Tank.HEIGHT - Explode.HEIGHT)/2;
            tf.explodes.add(new Explode(ex,ey,tf));
        }


    }

    private void die() {
        this.living = false;
    }
}
