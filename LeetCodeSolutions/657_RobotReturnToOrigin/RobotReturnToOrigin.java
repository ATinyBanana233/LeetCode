package string;

public class RobotReturnToOrigin {
    /**
     * Function to determine a robot is back to the original by reading a string
     * containing the moves. U - up, D - down, L - left, R - right.
     * @param moves     String containing the moves
     * @return          True if robot is back to the origin, false otherwise.
     */
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
