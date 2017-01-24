package JavaHW1_2;

public class TwoDimArr
{
    private int randomInt(int min, int max)
    {
        return (int) (Math.random() * (++max - min)) + min;
    }

    public int arrSum(int x, int y)
    {
        int[][] arr = new int[x][y];
        int result = 0;

        for (int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                arr[i][j] = randomInt(0, 100);
                result += arr[i][j];
                if (arr[i][j] < 10)
                {
                    System.out.print(arr[i][j] + "  | ");
                }
                else if (arr[i][j] >= 100)
                {
                    System.out.print(arr[i][j] + "| ");
                }
                else
                {
                    System.out.print(arr[i][j] + " | ");
                }

            }
            System.out.println("");
        }
        System.out.println("---------------------------------------");
        System.out.print((char) 27 + "[31m" + "Сумма всех чисел в массиве: " + result + (char)27 + "[0m");
        return result;
    }

    public static void main(String[] args)
    {
        TwoDimArr a = new TwoDimArr();
        a.arrSum(5, 8);
    }
}
