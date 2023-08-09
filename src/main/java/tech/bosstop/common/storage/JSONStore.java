package tech.bosstop.common.storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tech.bosstop.bloodworld.BloodWorld;
import tech.bosstop.common.storage.formater.DarkElfFormat;
import tech.bosstop.common.storage.formater.DragonBornFormat;
import tech.bosstop.common.storage.formater.DwarfFormat;
import tech.bosstop.common.storage.formater.ElfFormat;
import tech.bosstop.common.storage.formater.GiantFormat;
import tech.bosstop.common.storage.formater.HumanFormat;
import tech.bosstop.common.storage.formater.MermaidFormat;
import tech.bosstop.common.storage.formater.SerpentineFormat;
import tech.bosstop.common.storage.formater.TrollFormat;
import tech.bosstop.common.storage.formater.VampireFormat;
import tech.bosstop.common.storage.formater.WerewolfFormat;
import tech.bosstop.common.structures.BWPlayer;
import tech.bosstop.common.structures.BWRace;
import tech.bosstop.common.structures.races.BWDwarf;
import tech.bosstop.common.structures.races.BWElf;
import tech.bosstop.common.structures.races.BWGiant;
import tech.bosstop.common.structures.races.BWMermaid;
import tech.bosstop.common.structures.races.BWSerpentine;
import tech.bosstop.common.structures.races.BWTroll;
import tech.bosstop.common.structures.races.BWVampire;
import tech.bosstop.common.structures.races.BWWerewolf;

public class JSONStore {

    private BloodWorld instance = BloodWorld.getInstance();

    private FileUtil fileUtil = new FileUtil();

    private Gson gson = new GsonBuilder()
    .setPrettyPrinting()
    .serializeNulls()
    .create();

    private void checkFolders() {
        if(!fileUtil.folderExists(instance.getDataFolder() + "/players")) fileUtil.createFolder(instance.getDataFolder() + "/players");
        if(!fileUtil.folderExists(instance.getDataFolder() + "/factions")) fileUtil.createFolder(instance.getDataFolder() + "/factions");
    }

    private void checkFiles() throws IOException {
        checkFolders();
        for(BWRace race : BWRace.values()) {
            if(!fileUtil.fileExists(instance.getDataFolder() + "/players/" + race.toString().toLowerCase() + ".json")) {
                fileUtil.writeFile(instance.getDataFolder() + "/players/" + race.toString().toLowerCase() + ".json", gson.toJson(new ArrayList<Object>()));
            }
        }
    }

    private List<BWPlayer> loadPlayerType(BWRace race, String content) {
        List<BWPlayer> players = new ArrayList<BWPlayer>();
        switch(race.toString().toLowerCase()) {
            case "human": {
                HumanFormat humanFormat = gson.fromJson(content, HumanFormat.class);
                for(BWPlayer player : humanFormat.getPlayers()) players.add(player);
                break;
            }
            case "vampire": {
                VampireFormat vampireFormat = gson.fromJson(content, VampireFormat.class);
                for(BWVampire vampire : vampireFormat.getVampires()) players.add(vampire);
                break;
            }
            case "werewolf": {
                WerewolfFormat werewolfFormat = gson.fromJson(content, WerewolfFormat.class);
                for(BWWerewolf werewolf : werewolfFormat.getWerewolves()) players.add(werewolf);
                break;
            }
            case "mermaid":{
                MermaidFormat mermaidFormat = gson.fromJson(content, MermaidFormat.class);
                for(BWMermaid player : mermaidFormat.getMermaids()) players.add(player);
                break;
            }
            case "serpentine": {
                SerpentineFormat serpentineFormat = gson.fromJson(content, SerpentineFormat.class);
                for(BWSerpentine player : serpentineFormat.getSerpentine()) players.add(player);
                break;
            }
            case "elf": {
                ElfFormat elfFormat = gson.fromJson(content, ElfFormat.class);
                for(BWElf player : elfFormat.getElves()) players.add(player);
                break;
            }
            case "troll": {
                TrollFormat trollFormat = gson.fromJson(content, TrollFormat.class);
                for(BWTroll player : trollFormat.getTrolls()) players.add(player);
                break;
            }
            case "giant": {
                GiantFormat giantFormat = gson.fromJson(content, GiantFormat.class);
                for(BWGiant giant : giantFormat.getGiants()) players.add(giant);
                break;
            }
            case "dwarf": {
                DwarfFormat dwarfFormat = gson.fromJson(content, DwarfFormat.class);
                for(BWDwarf player : dwarfFormat.getDwarves()) players.add(player);
                break;
            }
            case "darkelf": {
                DarkElfFormat darkElfFormat = gson.fromJson(content, DarkElfFormat.class);
                for(BWPlayer player : darkElfFormat.getDarkElves()) players.add(player);
                break;
            }
            case "dragonborn": {
                DragonBornFormat dragonBornFormat = gson.fromJson(content, DragonBornFormat.class);
                for(BWPlayer player : dragonBornFormat.getDragonBorn()) players.add(player);
                break;
            }
            default: {
                break;
            }
        }

        return players;
    }

    private void loadPlayers() {
        List<BWPlayer> players = new ArrayList<BWPlayer>();
        for(BWRace race : BWRace.values()) {
            try {
                players.addAll(loadPlayerType(race, fileUtil.readFile(instance.getDataFolder() + "/players/" + race.toString().toLowerCase() + ".json")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        instance.getPlayerManager().setPlayers(players);
    }

    public void enable() {
        try {
            checkFiles();
            loadPlayers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disable() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
