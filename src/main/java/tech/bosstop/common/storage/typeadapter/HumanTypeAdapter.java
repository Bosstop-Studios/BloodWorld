package tech.bosstop.common.storage.typeadapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import tech.bosstop.common.storage.formater.HumanFormat;
import tech.bosstop.common.structures.BWPlayer;

public class HumanTypeAdapter extends TypeAdapter<HumanFormat> {

    @Override
    public void write(JsonWriter out, HumanFormat value) throws IOException {
        out.beginObject();
        out.name("players");
        out.beginArray();
        for(BWPlayer player : value.getPlayers()) {
            out.beginObject();
            out.name("uuid").value(player.getUUID().toString());
            out.endObject();
        }
        out.endArray();
        out.endObject();
    }

    @Override
    public HumanFormat read(JsonReader in) throws IOException {
        HumanFormat humanFormat = new HumanFormat(new ArrayList<BWPlayer>());
        in.beginObject();
        while(in.hasNext()) {
            switch(in.nextName()) {
                case "players": {
                    in.beginArray();
                    while(in.hasNext()) {
                        in.beginObject();
                        while(in.hasNext()) {
                            switch(in.nextName()) {
                                case "uuid": {
                                    humanFormat.getPlayers().add(new BWPlayer(UUID.fromString(in.nextString())));
                                    break;
                                }
                            }
                        }
                        in.endObject();
                    }
                    in.endArray();
                    break;
                }
            }
        }
        in.endObject();
        return humanFormat;
    }
    
}
