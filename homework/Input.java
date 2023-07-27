package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    private List<String> lastNameEnding = new ArrayList<>(Arrays.asList("ов",
            "ев","их","ко","ич","ук","ик","ки","ка"));
    public Entry parseLine(String userLine) {
        String[] userLineArr = userLine.split(" ");
        if (userLineArr.length < 6){
            System.out.println("Вы ввели недостаточно данных!");
            throw new InvalidInputFormat();
        }else if (userLineArr.length > 6){
            System.out.println("Вы ввели слишком много данных");
            throw new InvalidInputFormat();
        }
        return rightEntry(userLineArr);
    }
    private Entry rightEntry(String[] arr){
        if(phoneNumber(arr).equals("0")){
            System.out.println("Неверный формат номера телефона");
            throw new InvalidInputFormat();
        }
        if(gender(arr) == null){
            System.out.println("Пол указан неверно");
            throw new InvalidInputFormat();
        }
        if(birthday(arr).equals("dd.mm.yyyy")){
            System.out.println("Не верный формат даты рождения!");
            throw new InvalidInputFormat();
        }
        if(surName(arr) == null){
            System.out.println("Отчество не найдено!");
            throw new InvalidInputFormat();
        }
        if(lastName(arr) == null){
            System.out.println("Фамилия не найдена");
            throw new InvalidInputFormat();
        }

        return new Entry(firstName(arr),lastName(arr),surName(arr),
                birthday(arr),
                phoneNumber(arr),
                gender(arr));
    }
    private String phoneNumber(String[] arr){
        long number = 0L;
        for(String item:arr){
            try {
                number = Long.parseLong(item);
                return Long.toString(number);
            } catch(NumberFormatException e){

            }
        }
        return Long.toString(number);
    }
    private String gender(String[] arr){
        for(String item:arr) {
            if(item.length() == 1 && item.equals("m") || item.equals("f")){
                return item;
            }
        }
        return null;
    }
    private String birthday(String[] arr){
        String template = "dd.mm.yyyy";
        for(String item:arr){
            if(item.matches("\\d{2}.\\d{2}.\\d{4}")){
                return item;
            }
        }
        return template;
    }
    private String surName(String[] arr){
        for(String item:arr){
            if(item.contains("вич") || item.contains("вна")){
                return item;
            }
        }
        return null;
    }
    private String lastName(String[] arr){
        for(String item:arr){
            if(item.length() != 1) {
                String[] itemArr = item.split("");
                String ending =
                        itemArr[itemArr.length - 2] + itemArr[itemArr.length - 1];
                if (lastNameEnding.contains(ending)) {
                    return item;
                }
            }
        }
        return null;
    }
    private String firstName(String[] arr){
        List<String> array = new ArrayList<>(Arrays.asList(arr));
        array.remove(lastName(arr));
        array.remove(surName(arr));
        array.remove(birthday(arr));
        array.remove(phoneNumber(arr));
        array.remove(gender(arr));
        return array.get(0);
    }
}
