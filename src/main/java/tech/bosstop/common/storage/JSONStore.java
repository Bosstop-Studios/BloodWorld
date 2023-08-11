package tech.bosstop.common.storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tech.bosstop.bloodworld.BloodWorld;
import tech.bosstop.common.storage.formater.FactionFormat;
import tech.bosstop.common.storage.formater.HumanFormat;
import tech.bosstop.common.storage.formater.VampireFormat;
import tech.bosstop.common.storage.typeadapter.FactionTypeAdapter;
import tech.bosstop.common.storage.typeadapter.HumanTypeAdapter;
import tech.bosstop.common.storage.typeadapter.VampireTypeAdapter;
import tech.bosstop.common.structures.BWFaction;
import tech.bosstop.common.structures.BWPlayer;
import tech.bosstop.common.structures.BWRace;
import tech.bosstop.common.structures.races.BWDarkElf;
import tech.bosstop.common.structures.races.BWDragonBorn;
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
    .registerTypeAdapter(HumanFormat.class, new HumanTypeAdapter())
    .registerTypeAdapter(VampireFormat.class, new VampireTypeAdapter())
    .registerTypeAdapter(FactionFormat.class, new FactionTypeAdapter())
    .serializeNulls()
    .create();

    private void checkFolders() {
        if(!instance.getDataFolder().exists()) instance.getDataFolder().mkdirs();
        if(!fileUtil.folderExists(instance.getDataFolder() + "/players/")) fileUtil.createFolder(instance.getDataFolder() + "/players/");
    }

    private void checkFiles() throws IOException {
        checkFolders();
        if(!fileUtil.fileExists(instance.getDataFolder() + "/factions.json")) fileUtil.writeFile(instance.getDataFolder() + "/factions.json", gson.toJson(new FactionFormat(new ArrayList<BWFaction>())));
        for(BWRace race : BWRace.values()) {
            if(!fileUtil.fileExists(instance.getDataFolder() + "/players/" + race.toString().toLowerCase() + ".json")) {
                fileUtil.writeFile(instance.getDataFolder() + "/players/" + race.toString().toLowerCase() + ".json", gson.toJson(new HumanFormat(new ArrayList<BWPlayer>())));
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
                HumanFormat humanFormat = gson.fromJson(content, HumanFormat.class);
                for(BWPlayer player : humanFormat.getPlayers()) {
                    players.add(new BWWerewolf(player.getUUID()));
                }
                break;
            }
            case "mermaid":{
                HumanFormat humanFormat = gson.fromJson(content, HumanFormat.class);
                for(BWPlayer player : humanFormat.getPlayers()) {
                    players.add(new BWMermaid(player.getUUID()));
                }
                break;
            }
            case "serpentine": {
                HumanFormat humanFormat = gson.fromJson(content, HumanFormat.class);
                for(BWPlayer player : humanFormat.getPlayers()) {
                    players.add(new BWSerpentine(player.getUUID()));
                }
                break;
            }
            case "elf": {
                HumanFormat humanFormat = gson.fromJson(content, HumanFormat.class);
                for(BWPlayer player : humanFormat.getPlayers()){
                    players.add(new BWElf(player.getUUID()));
                }
                break;
            }
            case "troll": {
                HumanFormat humanFormat = gson.fromJson(content, HumanFormat.class);
                for(BWPlayer player : humanFormat.getPlayers()) {
                    players.add(new BWTroll(player.getUUID()));
                }
                break;
            }
            case "giant": {
                HumanFormat humanFormat = gson.fromJson(content, HumanFormat.class);
                for(BWPlayer player : humanFormat.getPlayers()) {
                    players.add(new BWGiant(player.getUUID()));
                }
                break;
            }
            case "dwarf": {
                HumanFormat humanFormat = gson.fromJson(content, HumanFormat.class);
                for(BWPlayer player : humanFormat.getPlayers()) {
                    players.add(new BWDwarf(player.getUUID()));
                }
                break;
            }
            case "darkelf": {
                HumanFormat humanFormat = gson.fromJson(content, HumanFormat.class);
                for(BWPlayer player : humanFormat.getPlayers()) {
                    players.add(new BWDarkElf(player.getUUID()));
                }
                break;
            }
            case "dragonborn": {
                HumanFormat humanFormat = gson.fromJson(content, HumanFormat.class);
                for(BWPlayer player : humanFormat.getPlayers()) {
                    players.add(new BWDragonBorn(player.getUUID()));
                }
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

    private List<BWPlayer> sortPlayers(List<BWPlayer> players, BWRace race) {
        List<BWPlayer> sortedPlayers = new ArrayList<BWPlayer>();
        players.forEach((player) -> {
            if(player.getRace() == race) sortedPlayers.add(player);
        });
        return sortedPlayers;
    }

    private void savePlayers() {
        List<BWPlayer> players = instance.getPlayerManager().getPlayers();
        for(BWRace race : BWRace.values()) {
            switch(race.toString().toLowerCase()) {
                case "vampire": {
                    VampireFormat vampires = new VampireFormat(new ArrayList<BWVampire>());
                    sortPlayers(players, race).forEach((player) -> {
                        BWVampire vampire = (BWVampire) player;
                        vampires.getVampires().add(vampire);
                    });
                    String json = this.gson.toJson(vampires);
                    try {
                        fileUtil.writeFile(this.instance.getDataFolder() + "/players/" + race.toString().toLowerCase() + ".json", json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                default: {
                    HumanFormat humanFormat = new HumanFormat(sortPlayers(players, race));
                    String json = this.gson.toJson(humanFormat);
                    try {
                        fileUtil.writeFile(this.instance.getDataFolder() + "/players/" + race.toString().toLowerCase() + ".json", json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            } 
        }

    }

    private void loadFactions() {
        try {
            FactionFormat factionFormat = gson.fromJson(fileUtil.readFile(instance.getDataFolder() + "/factions.json"), FactionFormat.class);
            instance.getFactionManager().setFactions(factionFormat.getFactions());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFactions() {
        FactionFormat factionFormat = new FactionFormat(instance.getFactionManager().getFactions());
        String json = this.gson.toJson(factionFormat);
        try {
            fileUtil.writeFile(instance.getDataFolder() + "/factions.json", json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enable() {
        try {
            checkFiles();
            loadPlayers();
            loadFactions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disable() {
        try {
            savePlayers();
            saveFactions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
