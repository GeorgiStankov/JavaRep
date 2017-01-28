package week07;

public class Test {

	public static void main(String[] args) {
		Panda Jorko=new Panda("Jorko", "gosho@pandamail.com", "male");
		Panda Ceko=new Panda("Ceko", "ceko@pandamail.com", "male");
		Panda Pesho=new Panda("PEsho", "ceko@pandamail.com", "male");
		PandaSocialNetwork net=new PandaSocialNetwork();
		net.addPanda(Jorko);
		net.addPanda(Ceko);
	System.out.println(net.hasPanda(Jorko));
	System.out.println(net.hasPanda(Ceko));
	net.makeFriends(Jorko, Pesho);
	net.makeFriends(Pesho, Ceko);
	net.makeFriends(Jorko,Ceko);
	System.out.println(net.areFriends(Jorko, Pesho));
	System.out.println(net.areFriends(Jorko, Ceko));
	System.out.println(net.connectionLevel(Jorko, Pesho));
	System.out.println(net.connectionLevel(Jorko, Ceko));
	System.out.println(net.howManyGender(2,Jorko,"male"));
	}

}
