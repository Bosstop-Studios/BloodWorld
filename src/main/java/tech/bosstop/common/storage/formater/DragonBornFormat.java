package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.races.BWDragonBorn;

public class DragonBornFormat {
    
    List<BWDragonBorn> dragonBorn;

    public DragonBornFormat(List<BWDragonBorn> dragonBorn) {
        this.dragonBorn = dragonBorn;
    }

    public List<BWDragonBorn> getDragonBorn() {
        return dragonBorn;
    }

    public void setDragonBorn(List<BWDragonBorn> dragonBorn) {
        this.dragonBorn = dragonBorn;
    }
    
}
