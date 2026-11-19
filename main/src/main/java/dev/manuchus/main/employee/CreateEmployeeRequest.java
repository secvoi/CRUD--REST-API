package dev.manuchus.main.employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


/** Принимает и проверяет данные нового сотрудника. */
public record CreateEmployeeRequest( 

        @NotBlank(message="Name must be not blank")

        @Pattern(regexp="[А-ЯЁ][а-яё]* [А-ЯЁ][а-яё]*",
            message="Name must be format : first name last name"
        )
        String name,

        @NotNull(message = "job title is must")
        Position position){

    public CreateEmployeeRequest {

        if(name != null)
        {
            name = name.strip();
        }
     
    }

    
}
