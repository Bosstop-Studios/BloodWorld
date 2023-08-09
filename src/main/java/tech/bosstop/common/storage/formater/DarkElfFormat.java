package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.races.BWDarkElf;

public class DarkElfFormat {
    
    List<BWDarkElf> darkElves;

    public DarkElfFormat(List<BWDarkElf> darkElves) {
        this.darkElves = darkElves;
    }

    public List<BWDarkElf> getDarkElves() {
        return darkElves;
    }

    public void setDarkElves(List<BWDarkElf> darkElves) {
        this.darkElves = darkElves;
    }
    
}
