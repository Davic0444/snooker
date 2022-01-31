package snooker;

import java.util.ArrayList;
import java.util.List;

public class Tasks {
	
	List<Entity> snooker = new ArrayList<Entity>();
	FileManager fmObj = new FileManager();
	
	public void fileReader(String fileName) {
		snooker = fmObj.fileReader(fileName);
	}
	
	public Integer howManyRacer() {
		return snooker.size();
	}
	
	public Double avarageReward() {
		Integer piece = 0;
		Integer total = 0;
		for (Entity entity : snooker) {
			piece++;
			total += entity.getAward();
		}
		return (double) total/piece;
	}
	
	public void mostRewardChina() {
		Integer maxReward = -1;
		for (Entity entity : snooker) {
			if (entity.getAward()>maxReward && entity.getCountry().equalsIgnoreCase("kína")) {
				maxReward = entity.getAward();
			}
		}
		for (Entity entity : snooker) {
			if (entity.getAward().equals(maxReward)) {
				System.out.println("A legjobban kereső kínai versenyző:");
				System.out.println("Helyezés: "+entity.getPosition());
				System.out.println("Név: "+entity.getName());
				System.out.println("Ország: "+entity.getCountry());
				System.out.println("Nyeremény összege: "+entity.getAward()*380+" forint");
			}

		}
	}
	
	public void isThereNorwayPlayer() {
		Boolean isThereNorway = false;
		for (Entity entity : snooker) {
			if (entity.getCountry().equalsIgnoreCase("Norvégia")) {
				isThereNorway = true;
			}
		}
		if (isThereNorway==true) {
			System.out.println("Van norvég játékos.");
		}else {
			System.out.println("Nincs norvég játékos.");
		}
	}

	public void statistics() {
		Integer china = 0;
		Integer anglia = 0;
		Integer wales = 0;
		Integer scottish = 0;
		for (Entity entity : snooker) {
			if (entity.getCountry().equalsIgnoreCase("kína")) {
				china++;
			}
		}
		System.out.println("Kínai - "+china+" fő");
		for (Entity entity : snooker) {
			if (entity.getCountry().equalsIgnoreCase("anglia")) {
				anglia++;
			}
		}
		System.out.println("Anglia - "+anglia+" fő");
		for (Entity entity : snooker) {
			if (entity.getCountry().equalsIgnoreCase("wales")) {
				wales++;
			}
		}
		System.out.println("Wales - "+wales+" fő");
		for (Entity entity : snooker) {
			if (entity.getCountry().equalsIgnoreCase("skócia")) {
				scottish++;
			}
		}
		System.out.println("Skócia - "+scottish+" fő");
	}
	
}
