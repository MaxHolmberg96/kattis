import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        Player max = new Player();
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == 'W')
                max.getStar();
            else
                max.removeStar();
        }

        if(max.getRank() == 0)
            System.out.println("Legend");
        else
            System.out.println(max.getRank());

    }

    public static class Player {
        int rank = 25; //the rank the player have
        int stars = 0;
        boolean bronze = true;
        boolean silver = false;
        boolean gold = false;
        boolean platinum = false;
        boolean legend = false;
        int thirdConsecutiveWin = 0;

        public int getRank(){
            return rank;
        }



        public void getStar(){

            thirdConsecutiveWin++;

            if(thirdConsecutiveWin >= 3 && rank >= 6){
                stars += 2;
            }
            else
                stars++;

            if(bronze){
                if(stars > 2){
                    rank--;
                    if(stars == 4)
                        stars = 2;
                    else
                        stars = 1;
                    if(rank == 20){
                        bronze = false;
                        silver = true;
                    }
                }
            }


            else if(silver){
                if(stars > 3){
                    rank--;
                    if(stars == 5)
                        stars = 2;
                    else
                        stars = 1;
                    if(rank == 15){
                        silver = false;
                        gold = true;
                    }
                }
            }
            else if(gold){
                if(stars > 4){
                    rank--;
                    if(stars == 6)
                        stars = 2;
                    else
                        stars = 1;
                    if(rank == 10){
                        gold = false;
                        platinum = true;
                    }
                }
            }
            else if(platinum){
                if(stars > 5){
                    rank--;
                    if(stars == 7)
                        stars = 2;
                    else
                        stars = 1;
                    if(rank == 0){
                        platinum = false;
                        legend = true;
                    }
                }
            }
        }


        public void removeStar(){
            thirdConsecutiveWin = 0;
            if(silver){
                if(rank < 21)
                    if(rank < 20){
                        stars--;
                        if(stars < 0){
                            rank++;
                            stars = 2;
                        }
                    }
                    else{
                        if(stars > 0)
                            stars--;
                    }
            }
            else if(gold){
                stars--;
                if(stars < 0){
                    rank++;
                    if(rank == 16){
                        silver = true;
                        gold = false;
                        stars = 2;
                    }
                    else
                        stars = 3;
                }
            }
            else if(platinum){
                stars--;
                if(stars < 0){
                    rank++;
                    if(rank == 11){
                        gold = true;
                        platinum = false;
                        stars = 3;
                    }
                    else
                        stars = 4;
                }
            }
            else if(legend){
                stars--;
                if(stars < 0)
                    stars = 0;
            }
        }
    }
}

