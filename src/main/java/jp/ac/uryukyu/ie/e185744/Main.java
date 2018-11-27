package jp.ac.uryukyu.ie.e185744;

public class Main {
    public static void main(String[] args){

        //主人公の設定
        Naming naming_h = new Naming();
        naming_h.setName(1);
        Hero hero = new Hero(naming_h.getName(), 10, 15,6,6);


        //敵
        Enemy enemy = new Enemy("キングスライム", 15, 10,6,0);


        System.out.printf("\n%s vs. %s\n\n", hero.getName(), enemy.getName());

        int turn = 0;
        while( !hero.isDead() && !enemy.isDead() ){
            turn++;
            System.out.printf("%dターン目開始！\n\n", turn);
            hero.selection(enemy);
            enemy.attack(hero);
            hero.reset_defence();

        }
        System.out.println("戦闘終了");
    }

}
