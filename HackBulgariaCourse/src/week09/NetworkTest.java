package week09;

public class NetworkTest {

	public static void main(String[] args) {
		PandaSocialNetworkWithDBImpl network = new PandaSocialNetworkWithDBImpl();

		PandaDB Jorko = new PandaDB("Jorko", "gosho@pandamail.com", "M");
		PandaDB Ceko = new PandaDB("Ceko", "ceko@pandamail.com", "M");
		PandaDB Pesho = new PandaDB("PEsho", "pesho@pandamail.com", "M");

//		network.deletePanda(Ceko);
//		network.deletePanda(Pesho);
		//network.makeFriends(Ceko, Jorko);
		network.showFriends(Ceko);
		network.showPandas();
		
	}

}
