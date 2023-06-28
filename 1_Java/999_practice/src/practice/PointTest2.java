package practice;

public class PointTest2 {

	public static void main(String[] args) {
		
	
	Point3D p3 = new Point3D();
	System.out.println("p3.x=" + p3.x);
	System.out.println("p3.x=" + p3.y);
	System.out.println("p3.x=" + p3.z);
	}
	
}

class Point{
	int x = 10;
	int y = 20;
	
	
	
	Point(int x, int y){
		super();
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point{
	
	int z =30;
	
	Point3D(){
		this(100,200,300);
	
	}
	
	Point3D(int x, int y, int z){
		//super(x, y); 이렇게 안부르면 컴파일러 자동으로 super(); 함 근데 부모가 기본 생성자가 없음
		super(x,y);
		this.z = z;
	}
	
	
}