package com.example.demo.dao;

import com.example.demo.ApiCalls;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class CurrentWeatherData {
    private final String API_KEY ="4cb6c941e8a5430ea5aeeb0d5aea98b6" ;



    private String location="";
    private String city_name;
    private String country_code;
    private String datetime;
    private String temp;
    private String description;

    public String getLocation() {
        return location;
    }

    public boolean sendApiRequest(){
        if(location=="")
            return sendApiRequest("Vilnius,LT");
        return sendApiRequest(location);
    }
    public boolean sendApiRequest(String location ){
       this.location = location;

       String url = "https://api.weatherbit.io/v2.0/current?city="+location+"&key="+API_KEY;
       String json = ApiCalls.getJsonString(url);
       JSONObject obj = new JSONObject(json);
       System.out.println(json);
       JSONArray jsonArray =obj.getJSONArray("data");
       for (int i = 0; i < jsonArray.length(); i++) {
           country_code = jsonArray.getJSONObject(i).getString("country_code");
           city_name = jsonArray.getJSONObject(i).getString("city_name");
           description = jsonArray.getJSONObject(i).getJSONObject("weather").getString("description");
           datetime = jsonArray.getJSONObject(i).getString("datetime");
           temp = String.valueOf( jsonArray.getJSONObject(i).getInt("temp"));
       }
       city_name+=","+country_code;
        rewriteDate();
       return true;
    }
    private void rewriteDate()
    {
        List<String> months = List.of("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        String[] date = datetime.split("-");
        String years = date[0];
        String month = date[1];
        String day = date[2].split(":")[0];
        datetime="";
        datetime+=years+" "+months.get(Integer.parseInt(month) - 1) +" "+ day;
    }
    public String getCity_name() {
        return city_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getTemp() {
        return temp;
    }

    public String getDescription() {
        return description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CurrentWeatherData{" +
                "city_name='" + city_name + '\'' +
                ", country_code='" + country_code + '\'' +
                ", datetime='" + datetime + '\'' +
                ", temp='" + temp + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
