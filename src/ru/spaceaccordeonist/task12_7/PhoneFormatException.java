package ru.spaceaccordeonist.task12_7;

public class PhoneFormatException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Неверный формат номера";
    }
}
