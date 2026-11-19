package dev.manuchus.main.employee;

/** Представляет сотрудника с назначенным ID. */
public record Employee(String name , Position position , int id)
{
    

    public Employee {

        if(id <= 0 )
        {
            throw new IllegalArgumentException("ID must be positive");
        }

    }


}
