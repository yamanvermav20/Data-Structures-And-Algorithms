// package Questions.AutoDesk;

//Problem: Maximum Warriors Surviving After Defeating a Monster
// You are given a monster with:

// HP (health points) = MHP
// Attack Damage (AD) = MAD

// You also have N warriors, where each warrior has:

// whp[i] → health points of the i-th warrior
// wad[i] → attack damage of the i-th warrior

// ⚔️ Battle Rules:
// Warriors fight the monster one by one (in any order you choose).
// When a warrior fights the monster:
// The monster’s HP decreases by wad[i]
// The warrior’s HP decreases by MAD
// A warrior dies immediately if their HP becomes ≤ 0
// A warrior can continue attacking only if they are alive
// 🎯 Goal:

// Determine the maximum number of warriors that can survive after defeating the monster.

import java.util.Scanner;

public class AutoDesk {
    public static int maxSurvivingWarriors(int MHP, int MAD, int[] whp, int[] wad) {
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Monster input
        int MHP = sc.nextInt(); // Monster Health
        int MAD = sc.nextInt(); // Monster Attack Damage

        // Number of warriors
        int n = sc.nextInt();

        int[] whp = new int[n];
        int[] wad = new int[n];

        // Warrior health input
        for (int i = 0; i < n; i++) {
            whp[i] = sc.nextInt();
        }

        // Warrior attack input
        for (int i = 0; i < n; i++) {
            wad[i] = sc.nextInt();
        }

        int result = maxSurvivingWarriors(MHP, MAD, whp, wad);

        System.out.println(result);

        sc.close();
    }
}
