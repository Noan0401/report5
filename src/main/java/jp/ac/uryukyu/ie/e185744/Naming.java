package jp.ac.uryukyu.ie.e185744;
import java.util.Scanner;

/*********************/
/*勇者の名前設定クラス */
/********************/


public class Naming {
    private String name;

    String getName() {
        return name;
    }

    void setName(int num) {
        String character_name = user_input(num);
        this.name = character_name;
    }

    private String user_input(int number){

        String input;

        Scanner in = new Scanner(System.in);

        /*名前入力時で分岐*/
        if (number == 1){
            System.out.println("あなたの名前を入力してください: ");
        }
        else{
            System.out.println("仲間の名前を入力してください： ");
        }
        input = in.nextLine();

        return input;
    }

}
