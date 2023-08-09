package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.races.BWSerpentine;

public class SerpentineFormat {
    
    List<BWSerpentine> serpentine;

    public SerpentineFormat(List<BWSerpentine> serpentine) {
        this.serpentine = serpentine;
    }

    public List<BWSerpentine> getSerpentine() {
        return serpentine;
    }

    public void setSerpentine(List<BWSerpentine> serpentine) {
        this.serpentine = serpentine;
    }
}
