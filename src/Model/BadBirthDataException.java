package Model;

public class BadBirthDataException extends Exception{
    String inputString;

    public BadBirthDataException( String inputString) {
        this.inputString = inputString;
    }

    @Override
   public String getMessage(){
        return "Ошибка при вводе даты '" + inputString + "', требуем формат 'дд.мм.гггг'.\n";
    }
}
