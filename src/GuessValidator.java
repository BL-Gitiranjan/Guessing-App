


class GuessValidator {
    public static String validateGuess(int guess,int target)
    {
        if(guess==target)
            return "correct";
        else if(guess<target)
        {
            return low;
        }
        return high;

    }

    }
