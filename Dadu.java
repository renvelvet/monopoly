import java.util.Random;

public class Dadu{
	private int a;
	private int b;
	private boolean dobel;
	Random r = new Random();
	
	public Dadu(){
		a = 1 + r.nextInt(6);
		b = 1 + r.nextInt(6);
		if (a==b) {
			dobel = true;
		} else {
			dobel = false;
		}
		//System.out.println("Dadu: "+a+" dan "+b);
	}
	
	public void roll(){
		a = 1 + r.nextInt(6);
		b = 1 + r.nextInt(6);
		if (a==b) {
			dobel = true;
		} else {
			dobel = false;
		}
		System.out.println("Dadu yang didapat "+a+" dan "+b);
	}

	public int getOne(){
		return 1 + r.nextInt(6);
	}
	
	public int rollNumber(){
		return a+b;
	}
	
	public boolean isDouble(){
		return dobel;
	}


}
