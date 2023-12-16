package Tydek.billmanager.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Appointment {
    @Id
    private String idAppointment;
    private String tittle;
    private int durationInMinute;
    private Date startingDate;
}
