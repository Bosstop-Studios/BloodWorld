package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.races.BWGiant;

public class GiantFormat {
    
    List<BWGiant> giants;

    public GiantFormat(List<BWGiant> giants) {
        this.giants = giants;
    }

    public List<BWGiant> getGiants() {
        return giants;
    }

    public void setGiants(List<BWGiant> giants) {
        this.giants = giants;
    }
}
