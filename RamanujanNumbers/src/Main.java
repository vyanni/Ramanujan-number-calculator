import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner userInput = new Scanner(System.in);

            System.out.println("Please write the lower and upper bounds separated by a space: ");
            String cubeBounds = userInput.nextLine();
            String spaceCut = " ";
            //long startTime = System.nanoTime();

            String[] cubeBoundsArray = cubeBounds.split(spaceCut);
            int lowerBound = Integer.valueOf(cubeBoundsArray[0]);
            int upperBound = Integer.valueOf(cubeBoundsArray[1]);
            //int repeats = 0;

            int RamanujanCube = 0;
            int[] cubeArray = new int[(upperBound - lowerBound)];

            for(int j = 0; j < (upperBound); j++){
                int currentNum = j;
                int firstNum = (currentNum)*(currentNum)*(currentNum);

                for(int e = 0; e < (upperBound - currentNum); e++){
                    int currentsecondNum = j+1+e;
                    int secondNum = (currentsecondNum)*(currentsecondNum)*(currentsecondNum);

                    for(int y = 0; y < (upperBound - currentsecondNum); y++){
                        int currentthirdNum = currentsecondNum+1+y;
                        int thirdNum = (currentthirdNum)*(currentthirdNum)*(currentthirdNum);
                        double trialNum = Math.cbrt(firstNum+secondNum+thirdNum); 

                        finaliteration:
                        if(trialNum == Math.floor(trialNum) && trialNum >= lowerBound && trialNum <= upperBound){
                            System.out.println("There is a Ramanujan cube at " + currentNum + ", " + currentsecondNum + ", " + currentthirdNum);
                            int cubeSolution = (int)trialNum;

                            for(int q = 0; q < cubeArray.length; q++){
                                if(cubeArray[q] == cubeSolution){
                                    //repeats++;
                                    //System.out.println(cubeSolution + " is a repeated number.");
                                    break finaliteration;
                                }
                            }
                            //System.out.println("The number whose cube is: " + cubeSolution);
                            cubeArray[RamanujanCube] = cubeSolution;
                            RamanujanCube++;
                        }
                    }
                }
            }
            //long endTime = System.nanoTime();
            //long elapsed = endTime - startTime;

            //System.out.println(elapsed);
            System.out.println("There are " + RamanujanCube + " Ramanujan cubes between " + lowerBound + " and " + upperBound /*+ ", with " + repeats + " repeats"*/);
            userInput.close();
        }
}
