package week02;

public class Test {

	public static void main(String[] args) {

		Polynomial p1 = new Polynomial(2, 2);
		Polynomial p2 = new Polynomial(3, 2);
		Polynomial p3 = new Polynomial(3, 4);

		Polynomial p = p1.add(p2).add(p3);
		System.out.println("Adding: " + p);
		p = p.substract(p3);
		System.out.println("Substaction: " + p);
		Polynomial q1 = new Polynomial(2, 2);
		Polynomial q2 = new Polynomial(3, 2);
		Polynomial q3 = new Polynomial(3, 4);
		Polynomial q4 = new Polynomial(3, 3);
		Polynomial q = q1.multiply(q2).multiply(q3).multiply(q4);
		System.out.println("Multi: " + q);
		System.out.println(q.multiplyByConst(5));
		System.out.println(q.evaluate(2));
	}

}
