public class Main {

    public static void main(String[] args) {
        System.out.println(WordsList.wordsOne.length);
        System.out.println(WordsList2.wordsTwo.length);
        System.out.println(WordsList3.wordsThree.length);
        System.out.println(WordsList4.wordsFour.length);

        WordleClone wc = new WordleClone();
        wc.playGame();
    }
}
