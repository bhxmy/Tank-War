package TankWar;

public class Main {

    public static void main(String args[]) throws InterruptedException {
        TankFrame tf = new TankFrame();

        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        int interval = TankFrame.GAME_WIDTH/(initTankCount+1); //敌人间距

        //初始化敌方坦克
        for(int i=0; i<initTankCount; i++){
            tf.enemy.add(new Tank((interval-Tank.WIDTH/2)+i*interval,113,Dir.DOWN, Group.BAD,tf));
        }

        //new Thread(()->new Audio("audio/war.wav").loop()).start();

     //重画线程
         while(true){
             Thread.sleep(50);  //50ms刷新一次窗口
             tf.repaint();
         }

    }
}
