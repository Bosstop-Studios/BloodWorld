package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.races.BWTroll;

public class TrollFormat {
    
    List<BWTroll> trolls;

    public TrollFormat(List<BWTroll> trolls) {
        this.trolls = trolls;
    }

    public List<BWTroll> getTrolls() {
        return trolls;
    }

    public void setTrolls(List<BWTroll> trolls) {
        this.trolls = trolls;
    }

}
