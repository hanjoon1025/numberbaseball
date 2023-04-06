//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package week02.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class numbaseball {
    public numbaseball() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean correct = false;
        int[] answer = new int[3];
        int[] guess = new int[3];
        int count = 0;

        int strike;
        int ball;
        for(strike = 0; strike < answer.length; ++strike) {
            answer[strike] = random.nextInt(10);

            for(ball = 0; ball < strike; ++ball) {
                if (answer[strike] == answer[ball]) {
                    --strike;
                    break;
                }
            }

            if (answer[0] == 0) {
                --strike;
            }
        }

        System.out.println("정답 : " + Arrays.toString(answer));

        while(true) {
            while(!correct) {
                ++count;
                strike = 0;
                ball = 0;
                System.out.println("" + count + "번째 시도: ");
                String input = sc.nextLine();
                if (input.length() != 3) {
                    System.out.println("입력값이 잘못되어있습니다.");
                } else {
                    int i;
                    int j;
                    for(i = 0; i < guess.length; ++i) {
                        j = input.charAt(i);
                        guess[i] = Integer.parseInt(String.valueOf((char)j));
                    }


                    if(guess[0]==guess[1]||guess[0]==guess[2] || guess[1] == guess[2]) {
                        System.out.println("중복된 숫자가 입력되었습니다.");
                        continue;
                    }


                    for(i = 0; i < answer.length; ++i) {
                        for(j = 0; j < guess.length; ++j) {
                            if (answer[i] == guess[j]) {
                                if (i == j) {
                                    ++strike;
                                } else {
                                    ++ball;
                                }
                            }
                        }
                    }

                    if (strike == 3) {
                        correct = true;
                        System.out.println("3S");
                    } else {
                        System.out.println("" + ball + "B" + strike + "S");
                    }
                }
            }

            System.out.println("" + count + "번만에 맞추셨습니다. 게임을 종료합니다.");
            System.out.println("정답 : " + Arrays.toString(answer));
            sc.close();
            return;
        }
    }
}