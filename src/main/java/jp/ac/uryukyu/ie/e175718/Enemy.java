package jp.ac.uryukyu.ie.e175718;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing {
    public Enemy(String e_name, int e_hitpoint, int e_attack) {
        super(e_name, e_hitpoint, e_attack);
    }

    @Override
    public void attack(LivingThing opponent) {
        if (getHitPoint() >= 0) {
            int prob = (int) (Math.random() * 10);
            int damage = (int) (Math.random() * getAttack());
            if (prob <= 2) {
                damage = damage * 2;
                if (damage == 0) {
                    System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
                } else {
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            } else {
                if (damage == 0) {
                    System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
                } else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            }
        }
    }
}