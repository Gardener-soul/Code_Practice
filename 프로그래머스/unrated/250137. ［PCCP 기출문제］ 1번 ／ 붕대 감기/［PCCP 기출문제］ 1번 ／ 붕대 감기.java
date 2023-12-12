class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int lenAttack = attacks.length;
        int lateAttack = attacks[lenAttack-1][0];
        int realHealth = health;
        int cast = 0;
        int time = bandage[0];
        int heal = bandage[1];
        int plusHeal = bandage[2];
        int attack = 0;
        
        for(int i=1; i<=lateAttack; i++){
          for(int j=attack; j<=lenAttack; j++){
              if(i==attacks[j][0]) {
                  health-=attacks[j][1];
                  cast = 0;
                  attack++;
                  break;
              } else {
                  cast++;
                  if(cast==time) {
                    health=health+heal+plusHeal;
                    cast = 0;
                  }
                  else health+=heal;
                  break;
              }
          }
            if(health > realHealth) health = realHealth;
            else if(health<=0) {
                health = -1;
                break;
            }
        }
        return health;
    }
}