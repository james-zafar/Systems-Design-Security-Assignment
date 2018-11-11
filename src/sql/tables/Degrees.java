package src.sql.tables;

public class Degrees extends Table{

    public Degrees() {
        super();
    }
    public void addRow(String code, String name, String yearInIndustry, String levelOfStudy) {
        super.addRow(new Object[] {code, name, yearInIndustry, levelOfStudy});
    }
}