public class HangingMan {

    private int numWrongGuesses;
    String[] HangmanImage = 
        {"+----+\n"+ //0
            "|\n"+
            "|\n"+
            "|\n"+
            "/\\\n",

            "+----+\n"+ //1
            "|    O\n"+
            "|\n"+
            "|\n"+
            "/\\\n",

            "+----+\n"+ //2
            "|    O\n"+
            "|    +\n"+
            "|\n"+
            "/\\\n",

            "+----+\n"+ //3
            "|    O\n"+
            "|    +-\n"+
            "|\n"+
            "/\\\n",

            "+----+\n"+ //4
            "|    O\n"+
            "|   -+-\n"+
            "|\n"+
            "/\\\n",

            "+----+\n"+ //5
            "|    O\n"+
            "|   -+-\n"+
            "|   / \n"+
            "/\\\n",

            "+----+\n"+  //6
            "|    O\n"+
            "|   -+-\n"+
            "|   / \\\n"+
            "/\\\n",
        };

    HangingMan(){
        numWrongGuesses = 0;
    }

    public void show(){
        System.out.println(HangmanImage[numWrongGuesses]);
    }

    public boolean isntDead(){
        return numWrongGuesses < 6;
    }

    public void dieSomeMore(){
        numWrongGuesses++;
    }
}
