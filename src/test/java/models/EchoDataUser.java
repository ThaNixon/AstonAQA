package models;

import lombok.Data;
import lombok.Builder;


@Data
@Builder
public class EchoDataUser
{
    private String username;
    private String firstName;
    private String lastName;
}
