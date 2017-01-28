package week09;
import java.util.List;


public class PandaSocialNetworkWithDBImpl implements PandaSocialNetworkWithDB{

	private Dao dao=new Dao();
	
	@Override
	public void addPanda(PandaDB panda){
	 dao.addPanda(panda);
	}

	@Override
	public void deletePanda(PandaDB panda) {
		dao.deletePanda(panda);
	}
	public boolean hasPanda(PandaDB panda){
		
		return dao.hasPanda(panda);
	}
	@Override
	public void makeFriends(PandaDB panda1, PandaDB panda2)  {
		dao.makeFriends(panda1, panda2);
	}

	@Override
	public  void showPandas() {
		List<List<String>> list=dao.selectFrom();
		System.out.println("ID  NAME    EMAIL          GENDER");
		for(List<String> item: list){
			for(String Panda : item){
				System.out.print(Panda);
			}
			System.out.println();
		}
		
	}


	@Override
	public void showFriends(PandaDB panda) {
		dao.printFriends(panda);
		
	}

	
}
