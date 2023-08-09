package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.races.BWVampire;

public class VampireFormat {
    
    List<BWVampire> vampires;

    public VampireFormat(List<BWVampire> vampires) {
        this.vampires = vampires;
    }

    public List<BWVampire> getVampires() {
        return vampires;
    }

    public void setVampires(List<BWVampire> vampires) {
        this.vampires = vampires;
    }
}
