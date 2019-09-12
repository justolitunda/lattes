package ke.ac.egerton.quality.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "programmes")
public class Programmes {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prog_id")
    private int id;

    @NotNull(message=" code is compulsory")
    @Column(name = "prog_code")
    private String progCode;

    @NotNull(message="program name is compulsory")
    @Column(name = "prog_name")
    private String progName;


    public int getId() {
        return id;
    }

    public String getProgCode() {
        return progCode;
    }

    public String getProgName() {
        return progName;
    }

    @Override
    public String toString() {
        return "Programmes{" +
                "id=" + id +
                ", progCode='" + progCode + '\'' +
                ", progName='" + progName + '\'' +
                '}';
    }
}
