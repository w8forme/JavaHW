package JavaHW1_2;
import java.util.Arrays;

public class MergeArr
{
    public static int[] merge(int[] arr0, int[] arr1)
    {
        int[] result = new int[arr1.length + arr0.length];

        System.out.println("arr0 - " + Arrays.toString(arr0));
        System.out.println("arr1 - " + Arrays.toString(arr1));

        int index0 = 0;
        int index1 = 0;

        while (index0 + index1 < result.length)
        {
            if (index0 < arr0.length && index1 < arr1.length)
            {
                if (arr0[index0] <= arr1[index1])
                {
                    result[index0 + index1] = arr0[index0++];
                }
                else
                {
                    result[index0 + index1] = arr1[index1++];
                }
            }
            else if (index0 == arr0.length)
            {
                index0 = arr0.length - 1;
                System.arraycopy(arr1, index1, result, index1 + index0 + 1, arr1.length - index1);
                break;
            }
            else if (index1 == arr1.length)
            {
                index1 = arr1.length - 1;
                System.arraycopy(arr0, index0, result, index1 + index0 + 1, arr0.length - index0);
                break;
            }
            System.out.println("---" + Arrays.toString(result));
        }
        System.out.println("---" + Arrays.toString(result));
        return result;
    }

    public static void main(String[] args)
    {
        MergeArr e = new MergeArr();
        int[] arr0 = {1, 2, 5, 6, 8, 37};
        int[] arr1 = {2, 4, 5, 7, 8, 22};

        System.out.println(Arrays.toString(MergeArr.merge(arr0, arr1)));

    }

}
