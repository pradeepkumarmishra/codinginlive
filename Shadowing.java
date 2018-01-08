//Example of shadowing primitive and object
//shadowing primitive does not change value but passing object ref objects gets changed


public class Shadowing {

	int a = 9;
	String s="hello";
	StringBuffer sb=new StringBuffer("hello");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shadowing cp = new Shadowing();
		//System.out.println(new CommonPractice().a);
		cp.show(cp.a,cp.s,cp.sb);
		System.out.println(cp.a);
		System.out.println(cp.s);
		System.out.println(cp.sb);
	}

	void show(int b,String s,StringBuffer sb) {
		
		int a;//always initilize local variable otherwise will give compilation error
		 b=10;
		 s="pradeep";
		 sb.append("pradeep");
		System.out.println(b);
		System.out.println(s);
		System.out.println(sb);
	}
}
