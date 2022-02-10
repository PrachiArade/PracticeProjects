package perscholas.database.form;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;


import javax.validation.constraints.NotEmpty;

@Getter
@Setter

public class RegisterFormBean {

    @NotEmpty (message = "You cant leave this field empty.")
    private  String email;

    @Length(min = 1, max = 50, message = "must be between 1 and 50 characters in length.")
    private String firstName;

    private String lastName;

    @NotEmpty (message = "You cant leave this field empty.")
    private String password;
    private String confirmPassword;

    @NotEmpty
    private String username;

    // this list is populated by the controller with all error messages
    // in the binding result.
    private List<String> errorMessages = new ArrayList<>();


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }



}
