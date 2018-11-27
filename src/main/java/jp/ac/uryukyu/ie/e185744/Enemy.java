package jp.ac.uryukyu.ie.e185744;

public class Enemy extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    Enemy (String name, int maximumHP, int attack, int defence, int maximumMP) {
        super(name,maximumHP,attack,defence,maximumMP);
    }


    public void wounded(int damage){
        int hitpoint_e = super.getHitPoint();
        hitpoint_e -= damage;
        setHitPoint(hitpoint_e);
        if( hitpoint_e < 1 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", super.getName());
        }
    }
}
