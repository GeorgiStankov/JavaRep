package week09;


public interface PandaSocialNetworkWithDB {
	public void addPanda(PandaDB panda);

	public void deletePanda(PandaDB panda);

	public boolean hasPanda(PandaDB panda);

	public void makeFriends(PandaDB panda1, PandaDB panda2);

	public void showFriends(PandaDB panda);

	public void showPandas();

}
