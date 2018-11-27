package jp.ac.uryukyu.ie.e185744;
import java.util.Scanner;


/**
 * キャラのステータスを作るクラス
 */
public class LivingThing {

    private String name;
    private int hitPoint; //HP
    private int maxHP;
    private int attack;   //攻撃力
    private int defence;
    private int defence_1;
    private int magicPoint;
    private int damage;
    private boolean dead;


    /**
     * 変数達
     * @param name      キャラクターの名前
     * @param maximumHP ヒットポイント(体力)
     * @param attack    攻撃力
     * @param defence   防御力
     * @param maximumMP マジックポイント(魔力)
     */
    LivingThing (String name, int maximumHP, int attack , int defence, int maximumMP) {
        int pulus = (int) (Math.random() * 4);

        this.name = name;
        this.hitPoint = maximumHP;
        this.maxHP = maximumHP + pulus;
        this.attack = attack;
        this.defence = defence;
        this.defence_1 = defence;
        this.magicPoint = maximumMP;
        this.dead = false;
        System.out.printf("%sのHPは%d。MPは%d。", this.name, this.hitPoint, this.magicPoint);
        System.out.printf("攻撃力hは%dで、防御力は%dです。\n",this.attack, this.defence);
    }

    /**
     * HPのgetter
     * @return  HP
     */
    int getHitPoint() {
        return hitPoint;
    }

    /**
     * HPのsetter
     * @param hitPoint
     */
    void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }


    /**
     * 死亡に関して
     * @return  dead
     */
    boolean isDead() {
        return dead;
    }

    /**
     * 死亡に関してsetter
     * @param dead
     */
    void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * 名前setter
     * @return name
     */
    String getName(){
        return name;
    }


    /**
     * 攻撃メソッド
     * @param opponent　敵の事
     */
    public void attack(LivingThing opponent){
        if(!isDead()) {
            int protect = opponent.defence / 2;
            int damage = (int) (Math.random() * attack) - protect + (attack/3) ;
            this.damage = damage;

            if(damage < 0){
                damage = 0;
            }
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n",this.name, opponent.getName(), damage);
            opponent.wounded(damage);

        }
    }

    /**
     * 死亡判定
     * @param damage　敵が与えたダメージ
     */
    public void wounded(int damage){
        this.hitPoint -= damage;
        if( LivingThing.this.hitPoint < 1 ) {
            LivingThing.this.dead = true;
            System.out.printf("%sは倒れた。\n", LivingThing.this.name);
        }
    }

    /**
     * 回復メソッド
     * @param opponent　敵
     */
    public void heal(LivingThing opponent){

        int heal = (int) (Math.random() * 5) +1;
        this.magicPoint = this.magicPoint - 3;

        int damage = maxHP - hitPoint;
        int my_hitpoint = this.hitPoint;

        if(!this.isDead() && damage > 0){

            if(damage < heal){
                heal = damage;
            }

            my_hitpoint += heal;
            this.setHitPoint(my_hitpoint);
            System.out.printf("%sは%sを%d回復した！！\n",this.name, this.name,heal);
        }
    }

    /**
     *防御メソッド
     *防御時、防御力2倍。
     * @param opponemt 敵
     */
    void protecthion(LivingThing opponemt){
        this.defence = this.defence * 2;
        System.out.printf("%sは防御している！\n",this.name);
    }

    /**
     * 2倍した防御力を戻す。
     */
    void reset_defence(){
        this.defence = this.defence_1;
    }

    /**
     *行動選択
     *"1.攻撃　2.防御　3.呪文"選べる。
     * @param number    切り替え用    1の時     呪文選択の表示になる。
     *                              その他     行動選択の表示になる。
     * @return  selectionメソッドに生かすためにuserが選んだ行動番号を返す。
     */
    private int user_input(int number){

        int input;
        Scanner in = new Scanner(System.in);

        if(number == 1){
            System.out.println("1.攻撃魔法　2.回復魔法");
        }else{
            System.out.printf("\t%s\n\tHP:%d\n\tMP:%d\n\n",this.name,this.hitPoint,this.magicPoint);
            System.out.println("1.攻撃　2.防御　3.呪文");
        }

        input = in.nextInt();
        return input;
    }

    /**
     * 行動選択分岐実行メソッド
     * @param opponent　敵
     */
    public void selection(LivingThing opponent){
        int select = user_input(0);
        Skill skill = new Skill(magicPoint,name);

        switch (select){

            case 1: //攻撃
                attack(opponent);
                break;

            case 2: //防御
                protecthion(opponent);
                System.out.println(this.defence);
                break;
            case 3: //呪文
                int select_2 = user_input(1);

                if(magicPoint > 1){ //MP歩かないかの分岐

                    if(select_2 == 1){
                        opponent.wounded(skill.magic(opponent.name,2));
                        this.magicPoint = skill.getMagick_point();

                    }else{
                        heal(opponent);
                    }

                }else {
                    System.out.println("MPが足りない！！");
                }

                break;

            default:
                attack(opponent);
        }

    }

}
