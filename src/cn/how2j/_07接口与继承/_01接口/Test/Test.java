package cn.how2j._07接口与继承._01接口.Test;

import cn.how2j.Hero;

/**
 * 类作用: 练习
 * 类说明: 练习接口
 *继承 Hero 类,实现 治疗接口
 *
 * @author 彭继工
 * @date 2020 - 03 - 05:16:01
 */
public class Test extends Hero implements Healer {

    public static void main(String[] args) {
        // 测试
        Test test = new Test();
        test.heal();
    }

    /**
     * 治疗方法
     */
    @Override
    public void heal() {
        System.out.println(this.name + "发动治疗技能");
    }
}

/**
 * 治疗接口
 */
interface Healer {
    /** 治疗方法 */
    void heal();
}