package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.races.BWDwarf;

public class DwarfFormat {
    
    List<BWDwarf> dwarves;

    public DwarfFormat(List<BWDwarf> dwarves) {
        this.dwarves = dwarves;
    }

    public List<BWDwarf> getDwarves() {
        return dwarves;
    }

    public void setDwarves(List<BWDwarf> dwarves) {
        this.dwarves = dwarves;
    }
    
}
