package dev.manuchus.main.employee;

public record Employee(String name , Position position , int id )
{
    
    //сделать проверки для валидации в name , Position , id
    public Employee {

        // проверка поля id

        if(id <= 0 )
        {
            throw new IllegalArgumentException("ID must be positive");
        }

        // проверка поля name
        
        if(name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Field must be not blank");
        }

        name = name.strip();


        if (!name.matches("[А-ЯЁ][а-яё]* [А-ЯЁ][а-яё]*")) {

            throw new IllegalArgumentException("Field must contains letters , not Integer");
        }

        //проверка поля Position
        if (position == null) {
            throw new IllegalArgumentException("Position is required");
        }





    }


}