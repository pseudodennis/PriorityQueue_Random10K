public class TestDrive
{
	public static void main(String[] args)
	{
		Random10K series = new Random10K(100);

		System.out.println("Increasing " + series.toString(Random10K.Sort.INCREASING));
		System.out.println("Decreasing " + series.toString(Random10K.Sort.DECREASING));
		System.out.println("Sum of Digits Increasing " + series.toString(Random10K.Sort.SUM_OF_DIGITS_INCREASING));



	}
}
