package Strings;

public class RemoveColoredPieces {
//        public static boolean winnerOfGame(String colors) {
//        boolean run = true;
//        int turn = 1;
//        while(run){
//            if(turn%2!=0){
//                if(colors.contains("AAA")){
//                    int indexToRemove = colors.indexOf("AAA");
//                    indexToRemove+=1;
//                    String part1 = colors.substring(0, indexToRemove);
//                    String part2 = colors.substring(indexToRemove + 1);
//                    colors = part1 + part2;
//                    turn+=1;
//                    continue;
//                }else{
//                    return false;
//                }
//            }else{
//
//                if(colors.contains("BBB")){
//                    int indexToRemove = colors.indexOf("BBB");
//                    indexToRemove+=1;
//                    String part1 = colors.substring(0, indexToRemove);
//                    String part2 = colors.substring(indexToRemove + 1);
//                    colors = part1 + part2;
//                    turn+=1;
//                    continue;
//                }else{
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }
    public static boolean winnerOfGame(String colors) {

        int alice = 0;
        int bob = 0;

        //The intituation here is count becuase posiotn of character or removal of character will
        // not increase any chances of other player or increase in move
//        //why because we will be only removing the char in b.w the boundary of same neighbour
//        When one player removes a letter, it will never create a new removal opportunity for the other player.
//        For example, let's say you had "ABAA".
//        If the "B" wasn't there, then Alice would have a new removal opportunity. However, the "B" can never be removed because of the rules of the game. This observation implies that at the start of the game, all moves are already available to both players.
//         The order in which the removals happen is irrelevant. This is a side effect of the
//         previous observation. Let's say there was a section in the middle of the string "BAAAAAB".
//         Alice has three removal choices here, "BA[A]AAAB", "BAA[A]AAB", and "BAAA[A]AB". However,
//         her choice is irrelevant, because all three choices will result in "BAAAAB".
        for (int i = 1; i < colors.length() - 1; i++) {

            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {

                if (colors.charAt(i) == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
        }
        return alice - bob >= 1; //whoever has more moves will win
    }

    public static void main(String[] args) {
        System.out.println(winnerOfGame("ABBBBBBBAAA"));
    }
}
