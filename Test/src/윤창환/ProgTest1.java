package À±Ã¢È¯;

public class ProgTest1 {

	public static int cVar = 0;
	String iStr[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	double iDouble;
	boolean iBool = false;
	char iChar = 'a';

	String getGugudan(int dan) {

		String str = "";
		for (int i = dan; i <= dan; i++) {
			for (int j = 1; j <= 9; j++) {
				str+=(i+"*"+j+"="+i*j+"\t");
			}
		}	
		return str;
	}

	public static void main(String[] args) {
		ProgTest1 pt=new ProgTest1();
		System.out.println(pt.getGugudan(6));
	}
}
