package jp.ac.uryukyu.ie.e185744;

/******************/
/*攻撃呪文設定クラス */
/******************/

public class Skill {
    private int magick_point;
    private String name;

    Skill(int MP,String name){
        this.magick_point = MP;
        this.name = name;
    }

    int magic(String opponent, int number){
        int damage = 0;

        switch (number){

            case 1: //メラ　炎攻撃
                damage = (int) (Math.random() * 5) + 3;
                this.magick_point = this.magick_point -3;
                System.out.printf("%sは魔法弾を放った!\n",this.name);
                System.out.printf("%sに%dのダメージ！",opponent,damage);
                break;

            case 2: //マダンテ
                damage = this.magick_point * 2;
                this.magick_point = 0;
                System.out.printf("%sは魔法弾を放った!\n",this.name);
                System.out.printf("%sに%dのダメージ！\n",opponent,damage);
                break;

            default:
                break;

        }
        return damage;

    }

    //MP再設定時に使う。
    int getMagick_point() {
        return magick_point;
    }

}
