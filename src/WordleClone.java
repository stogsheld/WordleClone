
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordleClone {

    public void playGame() {
        ArrayList<String> attempts = new ArrayList();
        int noOfAttempts = 0;
        displayTitle();
        Scanner scn = new Scanner(System.in);
        String correctWord = selectWord();
        System.out.println(correctWord);

        while (noOfAttempts < 6) {
            for (int i = 0; i < attempts.size(); i++) {
                System.out.println(attempts.get(i));
            }
            System.out.println("Enter your attempt:");
            String attempt = scn.nextLine();
            System.out.println(attempt.length());
            if (attempt.length() == 5) {
                if (attempt.equals(correctWord)) {
                    System.out.println(DesignClass.GREEN_BOLD_BRIGHT + correctWord + " " + DesignClass.RESET);
                    System.out.println("Correct! You win!");
                    System.exit(0);
                } else {
                    for (int i = 0; i < attempt.length(); i++) {
                        char currentCorrectLetter = correctWord.charAt(i);
                        char currentAttemptLetter = attempt.charAt(i);
                        String currentAttemptLetterString = Character.toString(currentAttemptLetter);
                        int comparison = Character.compare(currentAttemptLetter, currentCorrectLetter);
                        if (comparison == 0) {
                            System.out.print(DesignClass.GREEN_BOLD_BRIGHT + currentAttemptLetter +
                                    DesignClass.RESET);
                        } else if (correctWord.contains(currentAttemptLetterString)) {
                            System.out.print(DesignClass.YELLOW_BOLD_BRIGHT + currentAttemptLetterString +
                                    DesignClass.RESET);
                        } else {
                            System.out.print(currentAttemptLetter);
                        }
                    }
                    System.out.println();
                }
                attempts.add(attempt);
                noOfAttempts++;
            } else {
                System.out.println("Please enter a 5 letter word.");
            }
        }
        System.out.println("Game Over.");
    }

    private String selectWord() {
        String chosenWord = null;
        int wordBankChosen = randomiser(4) + 1;
        System.out.println(wordBankChosen);
        int wordPlaceChosen = randomiser(3236);
        switch (wordBankChosen) {
            case 1:
                chosenWord = WordsList.wordsOne[wordPlaceChosen - 1];
                break;
            case 2:
                chosenWord = WordsList2.wordsTwo[wordPlaceChosen - 1];
                break;
            case 3:
                chosenWord = WordsList3.wordsThree[wordPlaceChosen - 1];
                break;
            case 4:
                chosenWord = WordsList4.wordsFour[wordPlaceChosen - 1];
                break;
            default:
                System.out.println("This shouldn't happen. Please try again");
                break;
        }
        return chosenWord;
    }

    private int randomiser(int i) {
        Random rand = new Random();
        return rand.nextInt(i);
    }

    private void displayTitle() {
        System.out.println("Wordle");
    }
}
