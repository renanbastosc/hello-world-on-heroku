package hello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.beans.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author viter
 */
public class MessageBean implements Serializable {
     
    private String lang;
        
    public MessageBean(String lang) {
        this.lang = lang;
    }

    public String getGreetings() {
        String msg = "";
        switch (this.lang){
            case "pt":
                msg = "Alô";
                break;
            case "en":
                msg = "Hello";
                break;
            case "de":
                msg = "Hallo";
                break;
            case "fr":
                msg = "Bonjour";
                break;
            case "it":
                msg = "Ciao";
                break;
            case "zh":
                msg = "你好";
                break;    
        }
        return msg;
    }

    public String getGreetings2 () {
        String msg = "";

        switch (checkGreetingByTime()) {
            case morning:
                msg = this.getMorningGreetings();
                break;
            case afternoon:
                msg = this.getAfternoonGreetings();
                break;
            default:
                msg = this.getNightGreetings();
            break;
        }

        return msg;
    }

    private Greeting checkGreetingByTime() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 6 && timeOfDay < 12) 
        {
            return Greeting.morning;
        } 
        else if (timeOfDay >= 12 && timeOfDay < 18) 
        {
            return Greeting.afternoon;
        } 
        else 
        {
            return Greeting.night;
        }
    }

    private String getMorningGreetings() {
        String msg = "";
        switch (this.lang){
            case "pt":
                msg = "Bom dia";
                break;
            case "en":
                msg = "Good morning";
                break;
            case "fr":
                msg = "Bonjour";
                break;
            case "de":
                msg = "Guten morgen";
                break;
            case "it":
                msg = "Buon giorno";
                break;
            case "zh":
                msg = "早上好";
                break;
        }
        return msg;
    }

    private String getAfternoonGreetings() {
        String msg = "";
        switch (this.lang){
            case "pt":
                msg = "Boa tarde";
                break;
            case "en":
                msg = "Good afternoon";
                break;
            case "fr":
                msg = "Bon après-midi";
                break;
            case "de":
                msg = "Guten tag";
                break;
            case "it":
                msg = "Buon pomeriggio";
                break;
            case "zh":
                msg = "下午好";
                break;
        }
        return msg;
    }

    private String getNightGreetings() {
        String msg = "";
        switch (this.lang){
            case "pt":
                msg = "Boa noite";
                break;
            case "en":
                msg = "Good evening";
                break;
            case "fr":
                msg = "Bonne nuit";
                break;
            case "de":
                msg = "Gute nacht";
                break;
            case "it":
                msg = "Buona notte";
                break;
            case "zh":
                msg = "晚安";
                break;
        }
        return msg;
    }

    public enum Greeting {
        morning, afternoon, night;
    }

    public String getPronoun(String pronoun) {
        String msg = "";
        if(pronoun.equals("Sr.")) {
            switch (this.lang){
                case "pt":
                    msg = "Sr.";
                    break;
                case "en":
                    msg = "Mr.";
                    break;
                case "fr":
                    msg = "M.";
                    break;
                case "de":
                    msg = "Herr.";
                    break;
                case "it":
                    msg = "Sig.";
                    break;
                case "zh":
                    msg = "先生";
                    break;
                default:
                    msg = pronoun;
            }
        } else if(pronoun.equals("Sra.")) {
            switch (this.lang){
                case "pt":
                    msg = "Sra.";
                    break;
                case "en":
                    msg = "Mrs.";
                    break;
                case "fr":
                    msg = "Mme.";
                    break;
                case "de":
                    msg = "Frau.";
                    break;
                case "it":
                    msg = "Sig.ra.";
                    break;
                case "zh":
                    msg = "萨";
                    break;
                default:
                    msg = pronoun;
            }
        } else {
            msg = pronoun;
        }
        
        return msg;
    }
}
