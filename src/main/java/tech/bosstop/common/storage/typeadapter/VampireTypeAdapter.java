package tech.bosstop.common.storage.typeadapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import tech.bosstop.common.storage.formater.VampireFormat;
import tech.bosstop.common.structures.races.BWVampire;

public class VampireTypeAdapter extends TypeAdapter<VampireFormat> {

    @Override
    public void write(JsonWriter out, VampireFormat value) throws IOException {
        out.beginObject();
        out.name("players");
        out.beginArray();
        for(BWVampire player : value.getVampires()) {
            out.beginObject();
            out.name("uuid").value(player.getUUID().toString());
            out.name("lives").value(player.getLives());
            out.endObject();
        }
        out.endArray();
        out.endObject();
    }

    @Override
    public VampireFormat read(JsonReader in) throws IOException {
        VampireFormat vampireFormat = new VampireFormat(new ArrayList<BWVampire>());
        in.beginObject();
        while(in.hasNext()) {
            switch(in.nextName()) {
                case "players": {
                    in.beginArray();
                    while(in.hasNext()) {
                        UUID uuid = null; 
                        int lives = 0;
                        in.beginObject();
                        while(in.hasNext()) {
                            switch(in.nextName()) {
                                case "uuid": {
                                    uuid = UUID.fromString(in.nextString());
                                    break;
                                }
                                case "lives": {
                                    lives = in.nextInt();
                                    break;
                                }
                            }
                        }
                        in.endObject();
                        BWVampire vampire = new BWVampire(uuid);
                        vampire.setLives(lives);
                        vampireFormat.getVampires().add(vampire);
                    }
                    in.endArray();
                    break;
                }
            }
        }
        in.endObject();
        return vampireFormat;
    }

}
