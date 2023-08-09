package tech.bosstop.common.storage.formater;

import java.util.List;

import tech.bosstop.common.structures.races.BWMermaid;

public class MermaidFormat {

    List<BWMermaid> mermaids;

    public MermaidFormat(List<BWMermaid> mermaids) {
        this.mermaids = mermaids;
    }

    public List<BWMermaid> getMermaids() {
        return mermaids;
    }

    public void setMermaids(List<BWMermaid> mermaids) {
        this.mermaids = mermaids;
    }

}
