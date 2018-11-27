package src.sql.model;
import src.sql.tables.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherDatabaseModel extends DatabaseModel {

    public TeacherDatabaseModel() {}

    public String getTutor(String condition) {
        initConnection();
        initStatement();
        String results = "";
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT Tutor FROM Student " + condition);
                while (getResult().next()) {
                    results = getResult().getString(1);
                }

            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public String getDegreeName(String condition) {
        initConnection();
        initStatement();
        String results = "";
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT Degree_DegreeCode FROM  Student WHERE `Registration number` = '"
                    + condition + "';");
                while (getResult().next()) {
                    results = getResult().getString(1);
                }
                String query = "WHERE DegreeCode = '" + results + "';";
                openResultQuery("SELECT `Degree name` FROM Degree " + query);
                while (getResult().next()) {
                    results = getResult().getString(1);
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public String getCurrentGrade(String regNo, String moduleCode) {
        initConnection();
        initStatement();
        String results = "";
        try {
            try {
                openConnection();
                openStatement();
                String query = "WHERE `Student_Registration number` = '" + regNo + "';";
                String record = getRecordId(query);
                openConnection();
                openStatement();
                query = "WHERE `Record_Record ID` = '" + record +
                "' AND Module_ModuleCode = '" + moduleCode + "';";
                openResultQuery("SELECT `The mark` FROM Mark " + query);
                while (getResult().next()) {
                    results = getResult().getString(1);
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public String getRecordId(String cond) {
        initConnection();
        initStatement();
        String result = "";
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT `Record ID` FROM  Record " + cond);
                while (getResult().next()) {
                    result = getResult().getString(1);
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void insertGrade(String name, String module, String grade, boolean resit) {
        initConnection();
        initStatement();
        String theModule = module.substring(0, 7);
        try {
            try {
                openConnection();
                openStatement();
                String query = "WHERE `Student_Registration number` = '" + name + "';";
                String record = getRecordId(query);
                if(resit) {
                    query = "UPDATE Mark SET `The mark` = " + grade +
                        " WHERE `Record_Record ID` = " + record + " AND "
                        + "Module_ModuleCode = '" + theModule + "';";
                }else {
                    query = "UPDATE Mark SET `Resit mark` = " + grade +
                        " WHERE `Record_Record ID` = " + record + " AND "
                        + "Module_ModuleCode = '" + theModule + "';";
                }
                openConnection();
                openStatement();
                int count = getStatement().executeUpdate(query);
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Integer> getGradeList(String student) {
        initConnection();
        initStatement();
        String query = "WHERE `Student_Registration number` = '" + student + "';";
        ArrayList<Integer> results = new ArrayList<Integer>();
        try {
            try {
                String record = getRecordId(query);
                openConnection();
                openStatement();
                openResultQuery("SELECT `The mark` FROM Mark WHERE `Record_Record ID` = '" + record + "';");
                while (getResult().next()) {
                    results.add(Integer.parseInt(getResult().getString(1)));
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public int getLevelOfStudy(String student) {
        initConnection();
        initStatement();
        int result = 0;
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT `Level of study` FROM Student" +
                    " WHERE `Registration number` = '" + student + "';");
                while (getResult().next()) {
                    result = Integer.parseInt(getResult().getString(1));
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public int getDegreeType(String student) {
        initConnection();
        initStatement();
        int result = 0;
        try {
            try {
                openConnection();
                openStatement();
                String query = "SELECT Degree_DegreeCode FROM  Student " +
                    "WHERE `Registration number` = '" + student + "';";
                String degreeCode = "";
                openResultQuery(query);
                while (getResult().next()) {
                    degreeCode = getResult().getString(1);
                }
                query = "SELECT `Level of study` FROM Degree" +
                    "WHERE DegreeCode = '" + degreeCode + "';";
                openConnection();
                openStatement();
                openResultQuery(query);
                while (getResult().next()) {
                    result = getResult().getString(1).length();
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<String> getStudentModuleCode(String record) {
        initConnection();
        initStatement();
        ArrayList<String> theResults = new ArrayList<String>();
        try {
            try {
                openConnection();
                openStatement();
                String query = "SELECT Module_ModuleCode FROM Mark " +
                    "WHERE `Record_Record ID` = " + record + ";";
                openResultQuery(query);
                while (getResult().next()) {
                    theResults.add(getResult().getString(1));
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return theResults;
    }

    public int getCredits(String moduleCode) {
        initConnection();
        initStatement();
        int result = 0;
        try {
            try {
                openConnection();
                openStatement();
                String query = "SELECT credits FROM `Module degree (linking)` "
                    + "WHERE `Degree_DegreeCode` = '" + moduleCode + "';";
                openResultQuery(query);
                while (getResult().next()) {
                    result = Integer.parseInt(getResult().getString(1));
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<String> getDissertationModules() {
        initConnection();
        initStatement();
        ArrayList<String> modules = new ArrayList<String>();
        try {
            try {
                openConnection();
                openStatement();
                String query = "SELECT Module_ModuleCode FROM `Module degree (linking)` "
                    + "WHERE `credits` = '" + 60 + "';";
                openResultQuery(query);
                while (getResult().next()) {
                    modules.add(getResult().getString(1));
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return modules;
    }

    public ArrayList<String> getPeriodOfStudy(String query) {
        initConnection();
        initStatement();
        ArrayList<String> study = new ArrayList<String>();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery(query);
                while (getResult().next()) {
                    study.add(getResult().getString(1));
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return study;
    }

    public int getWeightedMean(String query) {
        initConnection();
        initStatement();
        int result = 0;
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery(query);
                while (getResult().next()) {
                    result = Integer.parseInt(getResult().getString(1));
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void updateQuery(String query) {
        initConnection();
        initStatement();
        try {
            try {
                openConnection();
                openStatement();
                int count = getStatement().executeUpdate(query);
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
