package com.mars.test.okHttp;

import com.google.gson.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by yangyuchi on 14/04/2017.
 * <p>
 * Open Sky api : https://opensky-network.org/apidoc/rest.html
 * <p>
 * OkHttpClient Https : https://github.com/square/okhttp/wiki/HTTPS
 * <p>
 * demo : http://www.vogella.com/tutorials/JavaLibrary-OkHttp/article.html
 */
@Slf4j
public class TestOkHttpClient {

    final OkHttpClient client = new OkHttpClient();
    final Gson gson = new GsonBuilder()
            .registerTypeAdapter(State.class, new StateDeserializer())
            .create();

    @Test
    public void testGet() {

        final String url = "https://opensky-network.org/api/states/all";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseString = response.body().string();
            log.info("responseString = " + responseString);
            StatesResponse stateResp = gson.fromJson(responseString, StatesResponse.class);
            Assert.assertNotNull(stateResp);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testPost() throws IOException {
        String postUrl = "";
        String requestJson = "";
        FormBody body = new FormBody.Builder()
                .add("data", requestJson)
                .build();
        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
    }

    @Data
    class StatesResponse {

        private int time;
        private List<State> states;

    }

    @Data
    class State {
        String icao24;
        String callsign;
        String originCountry;
        Double timePosition;
        Double timeVelocity;
        Double longitude;
        Double latitude;
        Double altitude;
        Boolean onGround;
        Double velocity;
        Double heading;
        Double verticalRate;
        List<Integer> sensors;

        public State(String icao24, String callsign, String originCountry, Double timePosition, Double timeVelocity, Double longitude, Double latitude, Double altitude, Boolean onGround, Double velocity, Double heading, Double verticalRate) {
            this.icao24 = icao24;
            this.callsign = callsign;
            this.originCountry = originCountry;
            this.timePosition = timePosition;
            this.timeVelocity = timeVelocity;
            this.longitude = longitude;
            this.latitude = latitude;
            this.altitude = altitude;
            this.onGround = onGround;
            this.velocity = velocity;
            this.heading = heading;
            this.verticalRate = verticalRate;
        }

        public State(String icao24, String originCountry, Double timePosition) {
            this.icao24 = icao24;
            this.originCountry = originCountry;
            this.timePosition = timePosition;
        }
    }

    class StateDeserializer implements JsonDeserializer<State> {
        @Override
        public State deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonArray jsonArray = json.getAsJsonArray();
            String icao24 = jsonArray.get(0).getAsString();
            String callsign = null;
//            if(!jsonArray.get(1).isJsonNull()){
//                callsign =  jsonArray.get(1).getAsString();
//            }
            String originCountry = jsonArray.get(2).getAsString();
            Double timePosition = null;
            if(!jsonArray.get(3).isJsonNull()){
                timePosition =  jsonArray.get(3).getAsDouble();
            }
//
//            Double timeVelocity = null;
//            if(!jsonArray.get(4).isJsonNull()){
//                timePosition = jsonArray.get(4).getAsDouble();
//            }
//
//            Double longitude =;
//            Double timeVelocity = null;
//            if(!jsonArray.get(4).isJsonNull()){
//                timePosition = jsonArray.get(4).getAsDouble();
//            }
//
//            Double latitude = jsonArray.get(6).getAsDouble();
//            Double altitude = jsonArray.get(7).getAsDouble();
//            Boolean onGround = jsonArray.get(8).getAsBoolean();
//            Double velocity = jsonArray.get(9).getAsDouble();
//            Double heading = jsonArray.get(10).getAsDouble();
//            Double verticalRate = jsonArray.get(11).getAsDouble();
//            State state = new State(icao24,callsign,originCountry,timePosition,timeVelocity,longitude,latitude,altitude,onGround,velocity,heading,verticalRate);
            return new State(icao24,originCountry,timePosition);
        }

    }

}
