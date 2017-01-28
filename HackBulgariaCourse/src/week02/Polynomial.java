package week02;

public class Polynomial {

	private int[] coef;
	private int deg;

	public Polynomial(int a, int b) {
		coef = new int[b + 1];
		coef[b] = a;
		deg = degr();
	}

	public int degr() {
		int deg = 0;
		for (int i = 0; i < coef.length; i++) {
			if (coef[i] != 0)
				deg = i;
		}
		return deg;
	}

	public Polynomial add(Polynomial p) {
		Polynomial a = this;
		Polynomial c = new Polynomial(0, Math.max(a.deg, p.deg));
		for (int i = 0; i <= a.deg; i++) {

			c.coef[i] += a.coef[i];
		}
		for (int i = 0; i <= p.deg; i++) {
			c.coef[i] += p.coef[i];
		}
		c.deg = c.degr();
		return c;

	}

	public Polynomial substract(Polynomial p) {
		Polynomial a = this;
		Polynomial c = new Polynomial(0, Math.max(a.deg, p.deg));
		for (int i = 0; i <= a.deg; i++) {

			c.coef[i] += a.coef[i];
		}
		for (int i = 0; i <= p.deg; i++) {
			c.coef[i] -= p.coef[i];
		}
		c.deg = c.degr();
		return c;

	}

	public Polynomial multiply(Polynomial p) {

		Polynomial a = this;
		Polynomial c = new Polynomial(0, a.deg + p.deg);
		for (int i = 0; i <= a.deg; i++)
			for (int j = 0; j <= p.deg; j++)
				c.coef[i + j] += (a.coef[i] * p.coef[j]);
		c.deg = c.degr();
		return c;

	}

	public Polynomial multiplyByConst(int x) {

		Polynomial a = this;
		Polynomial c = new Polynomial(0, a.deg);
		for (int i = 0; i <= a.deg; i++) {

			c.coef[i] += a.coef[i];
		}
		for (int i = 0; i <= a.deg; i++) {
			c.coef[i] *= x;
		}

		c.deg = c.degr();

		return c;
	}

	public int evaluate(int x) {
		int sum = 0;
		for (int i = deg; i >= 0; i--)
			sum = sum + x * (coef[i] * deg);

		return sum;
	}

	public String toString() {
		if (deg == 0)
			return "" + coef[0];
		if (deg == 1)
			return coef[1] + "x + " + coef[0];
		String s = coef[deg] + "x^" + deg;
		for (int i = deg - 1; i >= 0; i--) {
			if (coef[i] == 0)
				continue;
			else if (coef[i] > 0)
				s = s + " + " + (coef[i]);
			else if (coef[i] < 0)
				s = s + " - " + (-coef[i]);
			if (i == 1)
				s = s + "x";
			else if (i > 1)
				s = s + "x^" + i;
		}
		return s;
	}

}
