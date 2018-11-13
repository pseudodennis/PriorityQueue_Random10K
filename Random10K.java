import java.util.Comparator;
import java.util.Random;

public class Random10K
{
	public enum Sort {INCREASING, DECREASING, SUM_OF_DIGITS_INCREASING};

	protected SortedABPriQ<Integer> queueIncreasing;
	protected SortedABPriQ<Integer> queueDecreasing;
	protected SortedABPriQ<Integer> queueSumOfDigitsIncreasing;

	protected Comparator<Integer> compIncreasing;
	protected Comparator<Integer> compDecreasing;
	protected Comparator<Integer> compSumOfDigitsIncreasing;

	public Random10K(int qty)
	{
		setComp();
		setQueue(qty);
	}

	public String toString(Sort sort)
	{
		String string;

		if (sort == Sort.DECREASING)
			string = queueDecreasing.toString();
		else if (sort == Sort.SUM_OF_DIGITS_INCREASING)
			string = queueSumOfDigitsIncreasing.toString();
		else
			string = queueIncreasing.toString();

		return string;
	}

	protected void setQueue(int qty)
	{
		queueIncreasing = new SortedABPriQ<>(compIncreasing);
		queueDecreasing = new SortedABPriQ<>(compDecreasing);
		queueSumOfDigitsIncreasing = new SortedABPriQ<>(compSumOfDigitsIncreasing);
		Random r = new Random();

		for (int i=0; i<qty; i++)
		{
			int next = r.nextInt(10000) + 1;
			this.queueIncreasing.enqueue(next);
			this.queueDecreasing.enqueue(next);
			this.queueSumOfDigitsIncreasing.enqueue(next);
		}
	}

	private void setComp()
	{
			this.compDecreasing = new Comparator<Integer>()
			{
				@Override
				public int compare(Integer o1, Integer o2)
				{
					return ((Comparable)o2).compareTo(o1);
				}
			};

			this.compSumOfDigitsIncreasing = new Comparator<Integer>()
			{
				@Override
				public int compare(Integer o1, Integer o2)
				{
					int x = 0;
					int element1 = sumDigits(o1);
					int element2 = sumDigits(o2);
					int result = 0;

					if (element1 == element2)
						result = 0;
					if (element1 > element2)
						result = 1;
					if (element1 < element2)
						result = -1;
					return result;
				}
			};

			this.compIncreasing = new Comparator<Integer>()
			{
				@Override
				public int compare(Integer o1, Integer o2)
				{
					return ((Comparable)o1).compareTo(o2);
				}
			};
	}

	// https://stackoverflow.com/questions/27096670/how-to-sum-digits-of-an-integer-in-java
	protected static int sumDigits(Integer num)
	{
		int n = num;
		int sum = 0;
		while (num > 0)
		{
			sum += num % 10;
			num = num / 10;
		}

		return sum;
	}


} // end Random10K
