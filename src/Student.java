import java.util.Date;

public class Student {
    private Integer id;
    private String fullName;
    private Date birthDate;
    private String group;
    private Boolean isActive;

    public Student(Integer id, String fullName, Date birthDate, String group, Boolean isActive) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.group = group;
        this.isActive = isActive;
    }
    public Integer getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
}
