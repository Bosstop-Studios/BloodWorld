package tech.bosstop.common.storage.typeadapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import tech.bosstop.common.storage.formater.FactionFormat;
import tech.bosstop.common.structures.BWFaction;

public class FactionTypeAdapter extends TypeAdapter<FactionFormat> {

    @Override
    public void write(JsonWriter out, FactionFormat value) throws IOException {
        out.beginObject();
        out.name("factions");
        out.beginArray();
        for(BWFaction faction : value.getFactions()) {
            out.beginObject();
            out.name("uuid").value(faction.getUUID().toString());
            out.name("name").value(faction.getName());
            out.name("prefix").value(faction.getPrefix());
            out.name("leader").value(faction.getLeader().toString());
            out.name("members");
            out.beginArray();
            for(UUID member : faction.getMembers()) {
                out.value(member.toString());
            }
            out.endArray();
            out.name("allies");
            out.beginArray();
            for(UUID ally : faction.getAllies()) {
                out.value(ally.toString());
            }
            out.endArray();
            out.name("enemies");
            out.beginArray();
            for(UUID enemy : faction.getEnemies()) {
                out.value(enemy.toString());
            }
            out.endArray();
            out.endObject();
        }
        out.endArray();
        out.endObject();
    }

    @Override
    public FactionFormat read(JsonReader in) throws IOException {
        FactionFormat format = new FactionFormat(new ArrayList<BWFaction>());
        in.beginObject();
        while(in.hasNext()) {
            switch(in.nextName()) {
                case "factions":
                    in.beginArray();
                    while(in.hasNext()) {
                        in.beginObject();
                        UUID uuid = null;
                        String name = null;
                        String prefix = null;
                        UUID leader = null;
                        List<UUID> members = new ArrayList<UUID>();
                        List<UUID> allies = new ArrayList<UUID>();
                        List<UUID> enemies = new ArrayList<UUID>();
                        while(in.hasNext()) {
                            switch(in.nextName()) {
                                case "uuid":
                                    uuid = UUID.fromString(in.nextString());
                                    break;
                                case "name":
                                    name = in.nextString();
                                    break;
                                case "prefix":
                                    prefix = in.nextString();
                                    break;
                                case "leader":
                                    leader = UUID.fromString(in.nextString());
                                    break;
                                case "members":
                                    in.beginArray();
                                    while(in.hasNext()) {
                                        members.add(UUID.fromString(in.nextString()));
                                    }
                                    in.endArray();
                                    break;
                                case "allies":
                                    in.beginArray();
                                    while(in.hasNext()) {
                                        allies.add(UUID.fromString(in.nextString()));
                                    }
                                    in.endArray();
                                    break;
                                case "enemies":
                                    in.beginArray();
                                    while(in.hasNext()) {
                                        enemies.add(UUID.fromString(in.nextString()));
                                    }
                                    in.endArray();
                                    break;
                            }
                        }
                        in.endObject();
                        BWFaction faction = new BWFaction(name, leader);
                        faction.setUUID(uuid);
                        faction.setPrefix(prefix);
                        faction.setMembers(members);
                        faction.setAllies(allies);
                        faction.setEnemies(enemies);
                        format.getFactions().add(faction);
                    }
                    in.endArray();
                    break;
            }
        }
        in.endObject();
        return format;
    }
    
}
