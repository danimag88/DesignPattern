package builder;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBuilder<Building> implements Builder<Building> {
	
	protected Building building;
	private List<Materials> materialsList;

	public AbstractBuilder() {
		building = createBuilding();
		materialsList = new ArrayList<>();
	}
	
	public AbstractBuilder(Building building){
		this.building = building;
		materialsList = new ArrayList<>();
	}

	protected abstract Building createBuilding();
	
	protected void add(Materials materials){
		materialsList.add(materials);
	}

	@Override
	public Building build() {
		for(Materials materials:materialsList){
			materials.execute();
		}
		materialsList.clear();
		return building;
	}
	
	protected interface Materials{
		void execute();
	}

}
