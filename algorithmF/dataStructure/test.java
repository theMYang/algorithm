package dataStructure;

class ddd{
	public ddd() {
		// TODO Auto-generated constructor stub
		System.out.println("ddd");
	}
}

class aaa{
	aaa(){
		System.out.println("aaa");
	}
}

class bbb extends aaa {
	bbb(){
		System.out.println("bbb");
	}
}

public class test extends bbb{
	ddd aDdd  = new ddd();
	public test() {
		// TODO Auto-generated constructor stub
		System.out.println("ccc");
	}
	public static void main(String[] args) {
		new test();
	}
}
