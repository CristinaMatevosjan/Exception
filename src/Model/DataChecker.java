package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DataChecker {
public static int dataCount=6;

private String firstName;
private String lastName;
private String patronymicName;
private LocalDate birthDate;
private Gender gender;
private Long phoneNumber;

public DataChecker(){

}

    public String getLastName() {
        return lastName;
    }

    public void checkData(String[] splitesString) throws ParsingDataStringException{
    if (splitesString==null){
        throw new ParsingDataStringException("нет данных!");
    }

    StringBuilder fullErrorsMessage=new StringBuilder();
    for (String str:splitesString){
        if (Character.isLetter(str.charAt(0))){
            if(str.length()==1){
                if(this.gender==null){
                    try {
                        this.gender=checkGender(str);
                    }catch (BadGenderException e){
                        fullErrorsMessage.append(e.getMessage());
                    }
                }else {
                    fullErrorsMessage.append("Пол указан больше 1 раза\n");
                }
            }else {
                if (this.lastName==null){
                    try {
                        this.lastName=checkFIO(str);
                    }catch (BadFIOException e){
                        fullErrorsMessage.append(e.getMessage());
                    }
                }else if (this.firstName==null){
                    try {
                        this.firstName=checkFIO(str);
                    }catch (BadFIOException e){
                        fullErrorsMessage.append(e.getMessage());
                    }
                }else if (this.patronymicName==null){
                    try {
                        this.patronymicName=checkFIO(str);
                    }catch (BadFIOException e){
                        fullErrorsMessage.append(e.getMessage());
                    }
                }else {
                    fullErrorsMessage.append("Слишком много элементов распознаны как ФИО\n");
                }
            }
        }else {
            if (str.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")){
                if (this.birthDate==null){
                    try {
                        this.birthDate=checkBirthDate(str);
                    }catch (BadBirthDataException e){
                        fullErrorsMessage.append(e.getMessage());
                    }
                }else {
                    fullErrorsMessage.append("Дата рождения должна быть только одна, а обнаружены две: '\"\0000000000000000000000n" +
                            "+ this.birthDate + \"','\" + string + \"'\\n");
                }
            }else {
                if (this.phoneNumber==null){
                    try {
                        this.phoneNumber=checkPhoneNumber(str);
                    }catch (BadPhoneException e){
                        fullErrorsMessage.append(e.getMessage());
                    }
                }else {
                    fullErrorsMessage.append("Должен быть только один телефонный норме, а не несколько: '\"\n" +
                            " + this.phoneNumber + \"','\" + string + \"'\\n");
                }
            }
        }
    } if(!fullErrorsMessage.isEmpty()){
        throw  new ParsingDataStringException(fullErrorsMessage.toString());
    }

}

private String checkFIO(String inputString) throws BadFIOException{
    if (inputString.toLowerCase().matches("^[a-zа-яё]*$")){
return inputString;
    }else {
        throw  new BadFIOException(inputString);
    }
    }

    private long checkPhoneNumber(String inputString) throws BadPhoneException{
    if (inputString.length()==10){
        try {
            return Long.parseLong(inputString);
        }catch (NumberFormatException e){
            throw new BadPhoneException(inputString);
        }
    }else {
        throw new BadPhoneException(inputString);
    }
    }

    private Gender checkGender(String inputString)throws BadGenderException{
    try {
        return Gender.valueOf(inputString);
    }catch (IllegalArgumentException e){
        throw new BadGenderException(inputString);
    }
    }

    private LocalDate checkBirthDate(String inputString) throws BadBirthDataException{
    try {
         return LocalDate.parse(inputString,DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }catch (DateTimeParseException e){
        throw new BadBirthDataException(inputString);
    }
    }

    @Override
    public String toString(){
    StringBuilder sb=new StringBuilder();
    sb.append("<").append(lastName).append(">")
            .append("<").append(firstName).append(">")
            .append("<").append(patronymicName).append(">")
            .append("<").append(birthDate).append(">")
            .append("<").append(phoneNumber).append(">")
            .append("<").append(gender).append(">");

    return sb.toString();
    }
}
