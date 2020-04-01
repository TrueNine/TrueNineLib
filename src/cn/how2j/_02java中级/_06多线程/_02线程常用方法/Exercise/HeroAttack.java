package cn.how2j._02java中级._06多线程._02线程常用方法.Exercise;

/**
 * 练习 波动拳
 *
 * @author TrueNine
 * @version 1.0
 * @time 2020/4/1
 */
public class HeroAttack {
    public static void main(String[] args) {
        Hero h = new Hero("张三", 10000);
        Hero h1 = new Hero("李四", 9);
        Hero h2 = new Hero("王五", 99);
        Hero h3 = new Hero("赵六", 999);
        Hero h4 = new Hero("钱七", 9999);

        // 测试同时攻击多个英雄
        h.attack(h1, h2, h3, h4);
    }
}

/**
 * 英雄类
 * 自带攻击方法
 * 自带死亡方法
 * 可以同时攻击多个英雄
 */
class Hero {

    /**
     * 名称
     */
    String name;
    /**
     * 血量
     */
    int hp;
    /**
     * 攻击力
     */
    int attackSize;
    /**
     * 是否死亡
     */
    boolean isBoom;
    /**
     * 技能攻击间隔
     */
    int spacingTime;
    /**
     * 技能冷却
     */
    int sleepTime;
    /**
     * 技能可使用次数
     */
    int attackOfNumbers;
    /**
     * 技能攻击次数备份
     */
    int attackOfNumbersCopy;

    /**
     * 空构造器
     * 私有
     */
    private Hero() {

    }

    /**
     * 构造器,传入英雄的名称和血量
     *
     * @param name 名称
     * @param hp   血量
     */
    public Hero(String name, int hp) {
        this.init(name, hp);
    }

    /**
     * 私有,用于初始化一些参数
     *
     * @param name 名称
     * @param hp   血量
     */
    private void init(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.attackSize = 102;
        this.spacingTime = 1000;
        this.sleepTime = spacingTime * 3;
        this.attackOfNumbers = 3;
        this.attackOfNumbersCopy = attackOfNumbers;
    }

    /**
     * 攻击方法,可传入多个地方英雄
     *
     * @param heros 地方英雄
     */
    public void attack(Hero... heros) {
        if (null != heros) {
            // 开辟多条线程同时攻击
            for (Hero temp : heros) {
                new Thread(new AttackThread(this, temp)).start();
            }
        } else {
            System.out.println(this.name + "在放空屁");
        }
    }

    /**
     * 英雄死亡
     * 设置死亡状态为 true
     * 打印显示
     */
    public void Boom() {
        this.isBoom = true;
        System.out.println(this.name + "死了");
    }


}

/**
 * 多线程攻击类
 * 实现攻击多个英雄
 */
class AttackThread implements Runnable {

    /**
     * 多个英雄
     */
    Hero[] toHeros;
    /**
     * 发起攻击的英雄
     */
    Hero hero;

    /**
     * 空构造器,私有
     */
    private AttackThread() {

    }

    /**
     * 构造器,初始化发起攻击的英雄
     * 初始化需要攻击的对象
     *
     * @param hero  发起攻击的英雄
     * @param heros 攻击对象
     */
    public AttackThread(Hero hero, Hero... heros) {
        this.toHeros = heros;
        this.hero = hero;
    }

    /**
     * 重写 run 方法
     * 调用本类的攻击方法
     */
    @Override
    public void run() {
        this.attack(this.hero, this.toHeros);
    }

    /**
     * 传入发起攻击的英雄
     * 传入要攻击的对象
     * 循环建立线程
     *
     * @param hero    发起攻击的英雄
     * @param toHeros 攻击对象
     */
    public void attack(Hero hero, Hero[] toHeros) {
        for (Hero temp : toHeros) {
            attack(hero, temp);
        }
    }

    /**
     * 攻击方法,单个攻击
     *
     * @param hero   发起攻击的英雄
     * @param toHero 攻击对象
     */
    private synchronized void attack(Hero hero, Hero toHero) {
        try {
            do {
                // 判断该英雄是否死亡
                if (hero.isBoom) {
                    System.out.println("敌方" + hero.name + "已经死亡");
                } else {
                    System.out.println("敌方" + toHero.name + "血量: " + toHero.hp);
                    toHero.hp -= hero.attackSize;
                    // 英雄死亡,不能攻击,退出
                    if (toHero.hp <= 0) {
                        System.out.println(hero.name + "一拳打死了: " + toHero.name);
                        // 设定敌方为死亡状态
                        toHero.Boom();
                        break;
                    }
                    // 暂停技能间隔
                    System.out.println(hero.name + "技能间隔");
                    Thread.sleep(hero.spacingTime);
                    // 攻击次数少一次
                    hero.attackOfNumbers -= 1;
                }
                // 如果攻击次数没了,进入冷却
                if (hero.attackOfNumbers <= 0) {
                    // 重置攻击次数
                    hero.attackOfNumbers = hero.attackOfNumbersCopy;
                    System.out.println(hero.name + "技能进入冷却");
                    Thread.sleep(hero.sleepTime);
                }
            } while (!hero.isBoom);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}