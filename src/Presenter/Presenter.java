package Presenter;

import java.io.File;
import java.io.IOException;
import  java.io.FileWriter;

import Model.ParsingDataStringException;
import Model.DataChecker;
import View.View;


public class Presenter <V extends View>{
private DataChecker model;
private V view;

public Presenter(V v){
    view=v;
}

public void start() {
    boolean working = true;
    do {
        String input = view.getInput("Введите данные через пробел " +
                "(Фамилию Имя Отчество ДатуРождения НомерТелефона Пол), или Exit для прекращения программы:");
        if (input.equals("Exit")) {
            working = false;
            break;
        } else {
            String[] splitedInput = input.replaceAll("\\s+", " ").split(" ");
            int inputDataCount = checkInputDataCount(splitedInput.length);
            if (inputDataCount == -1) {

                view.printOutput("Слишком мало данных на вводе (должно быть " + DataChecker.dataCount +"\n" +
                        " разделённых пробелом ' ': Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");
            } else if (inputDataCount == 0) {
                view.printOutput("Слишком много данных на вводе (должно быть " + DataChecker.dataCount +"\n" +
                        " разделённых пробелом ' ': Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");

            } else {
                try {
                    model = new DataChecker();
                    model.checkData(splitedInput);
                    writePersonData(model);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParsingDataStringException e) {
                    view.printOutput(e.getMessage());
                }
            }

        }
    }
    while (working);
}


private int checkInputDataCount(int inputDataCount){
    if (inputDataCount<DataChecker.dataCount){
        return -1;
    } else if (inputDataCount>DataChecker.dataCount) {
        return 0;

    }else {
        return inputDataCount;
    }
}

private void writePersonData(DataChecker data)throws IOException{
    File filepath=new File(data.getLastName());
    try {
        FileWriter fw=new FileWriter(filepath,true);
        fw.append(data.toString()+"\n");
        }catch (IOException e){
        throw e;
    }

}

}

