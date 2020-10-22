package ru.spaceaccordeonist.task12;

import java.util.regex.Pattern;

public class PhoneFormatter {
    private final Pattern pattern = Pattern.compile("\\d{10}\\d?");

    public String formatPhone(String rawPhone) throws PhoneFormatException{
        rawPhone = rawPhone.replaceAll("[ ()\\-+]","");
        if(pattern.matcher(rawPhone).matches()){
            if (rawPhone.length() == 10){
                rawPhone = "7" + rawPhone;
            } else if (rawPhone.length() == 11){
                if(rawPhone.charAt(0) == '8')
                    rawPhone = "7" + rawPhone.substring(1);
                else if(rawPhone.charAt(0) != '7') throw new PhoneFormatException();
            } else throw new PhoneFormatException();
        } else throw new PhoneFormatException();

        return decoratePhone(rawPhone);
    }

    private String decoratePhone(String rawPhone){
        return String.format("+7 (%3s) %3s-%2s-%2s",
                rawPhone.substring(1,4),
                rawPhone.substring(4,7),
                rawPhone.substring(7,9),
                rawPhone.substring(9));
    }
}

class PhoneFormatException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Неверный формат номера";
    }
}
