package demos;


public class BatchIteratorTest {

	public static void main(String[] args) {
		
		int totalSize = 30;
		int totalCounter = 0;
		int batchSize = 3;
		int batchCounter = 1;
	

		while (totalCounter < totalSize ) {
			for (int i = 0; i<batchSize; i++) {
				System.out.println("Batch Count: " + batchCounter + "  Interation Count: " + i);
				totalCounter++;
				System.out.println("Total Counter = " + totalCounter);
			}
			/*while () {
				System.out.println("Switching to the next Tab");
				if ()
			}*/
			batchCounter++;
			System.out.println("Batch Counter = " + batchCounter + "\n");
		}
	}
}
