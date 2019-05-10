package string;

public class RobotReturnToOrigin {
    
    public boolean judgeCircle(String moves) {
        int uNum = 0, dNum = 0, lNum = 0, rNum = 0;
        for (Character c : moves.toCharArray())
        {
            switch (c)
            {
                case 'U':
                    uNum++;
                    break;
                case 'D':
                    dNum++;
                    break;
                case 'L':
                    lNum++;
                    break;
                case 'R':
                    rNum++;
                    break;
            }
        }

        return (uNum == dNum) && (lNum == rNum);
    }
}
