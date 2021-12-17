//管理配置文件
package TankWar;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if(props == null) return null;
        return props.get(key);
    }
//读取配置文件的数据
    public static void main(String args[]){
        System.out.println(PropertyMgr.get("initTankCount"));
        System.out.println(PropertyMgr.get("tankSpeed"));
    }
}
