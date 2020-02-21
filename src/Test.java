/**
 * 类作用:
 * 类说明:
 *
 * @author 彭继工
 * @date 2020 - 02 - 21:11:42
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("乌鸦坐飞机! \n");
        int sppe = 1;

        Hero hero = new Hero("彭二佬", 100, 20);
        Hero hero1 = new Hero("彭大佬", 100, 30);

        hero1.sa(hero, 21);
        hero.sa(hero1, 1);

        System.out.println("彭二佬的血量是: " + hero.hp);
        System.out.println("彭大佬的血量是: " + hero1.hp);
    }
}

class Hero {
    String name;
    String descript;
    int hp;
    int speed;

    Hero(String name, int hp, int speed) {
        this.name = name;
        this.speed = speed;
        this.hp = hp;
    }

    public Hero sa(Hero hero, int shanghai) {
        hero.hp -= shanghai;
        return hero;
    }
}