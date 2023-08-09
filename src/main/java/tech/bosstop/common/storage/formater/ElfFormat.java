package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.races.BWElf;

public class ElfFormat {
    
    List<BWElf> elves;

    public ElfFormat(List<BWElf> elves) {
        this.elves = elves;
    }

    public List<BWElf> getElves() {
        return elves;
    }

    public void setElves(List<BWElf> elves) {
        this.elves = elves;
    }

}
