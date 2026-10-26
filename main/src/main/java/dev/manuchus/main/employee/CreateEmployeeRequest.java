package dev.manuchus.main.employee;


//добавить пару проверок на валидациюю данных
public record CreateEmployeeRequest(String name, Position position) {

    public CreateEmployeeRequest {

        // проверка поля id

     
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
