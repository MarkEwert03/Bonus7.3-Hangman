import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle{
    private String actualPuzzle;
    private String guessedLetters;

    public Puzzle(){
        ArrayList<String> words = new ArrayList<String>();
        guessedLetters = "";

        try {
            File file = new File("words.txt");
            Scanner src = new Scanner(file);

            while (src.hasNext()){
                String w = src.next().toUpperCase();
                words.add(w);
            }
            src.close();

            actualPuzzle = words.get((int)(Math.random()*words.size()));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void show(){

        System.out.print("Puzzle: ");
        for (int i = 0; i < actualPuzzle.length(); i++){
            String letter = actualPuzzle.substring(i, i+1);
            if (guessedLetters.contains(letter)){
                System.out.print(letter);
            } else {
                System.out.print("_");
            }
            System.out.print(" ");
        }

        System.out.print("\n\nGuesses: ");
        for (int i = 0; i < guessedLetters.length(); i++){
            String letter = guessedLetters.substring(i, i+1);
            System.out.print(letter);
            if (actualPuzzle.contains(letter)) System.out.print("✔");
            else System.out.print("❌");
            if (i != guessedLetters.length()-1) System.out.print(", ");
        }
    }

    public String getWord(){
        return actualPuzzle;
    }

    public boolean isUnsolved(){
        for (int i = 0; i < actualPuzzle.length(); i++){
            String letter = actualPuzzle.substring(i, i+1);
            if (!guessedLetters.contains(letter)) {
                return true;
            }
        }
        return false;
    }

    public boolean makeGuess(String g){
        String G = g.toUpperCase();
        
        //actual word checking
        if (G.equals(actualPuzzle)) guessedLetters = actualPuzzle;
        
        //non-letter error checking
        if (G.length() != 1) return true;
        
        //letter checking
        if (!guessedLetters.contains(G)) {
            //represents guesses in alphabetical order
            guessedLetters = alphabetize(guessedLetters + G);
            
            //represents guesses in order shown in your video
            //guessedLetters += G;
            
            return actualPuzzle.contains(G);
        } else return true;
    }

    //helper method that uses... RECURSION!
    private String alphabetize(String s){
        int index = 0;
        String min = "z";

        if (s.length() == 0) return "";
        else {
            for (int i = 0; i < s.length(); i++){
                String letter = s.substring(i, i+1);
                if (min.compareToIgnoreCase(letter) > 0) {
                    min = letter;
                    index = i;
                }
            }
            return min.toUpperCase() + alphabetize(s.substring(0, index) + s.substring(index + 1));
        }
    }
}
