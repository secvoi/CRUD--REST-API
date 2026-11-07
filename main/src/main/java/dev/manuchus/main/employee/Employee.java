package dev.manuchus.main.employee;

public record Employee(String name , Position position , int id

    // @Min(value = 1 , message="ID must be positive")
    // int id,

    // @NotBlank(message="name must be not blank")
    // @Pattern(regexp="[А-ЯЁ][а-яё]* [А-ЯЁ][а-яё]*" , message="message must be format : first name  last name")
    // String name,

    // @NotNull(message="Position must be not empty")
    // Position position

    // Не будет выполняться ничего по причине того что через new вызывается , только если ручная проверка


)
{
    

    public Employee {

        //проверка поля id
        if(id <= 0 )
        {
            throw new IllegalArgumentException("ID must be positive");
        }

    }


}