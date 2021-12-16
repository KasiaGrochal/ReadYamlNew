
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataBase {

    Logger logger = LoggerFactory.getLogger(DataBase.class);

    public DataBaseModel postgres;
    public DataBaseModel mySql;
    public DataBaseModel activeDataBase;

    public DataBaseModel getPostgres() {
        return postgres;
    }

    public DataBaseModel getDbMySql() {
        return mySql;
    }

    public DataBaseModel getActiveDataBase() {
        if (getPostgres().isActive()) {
            return activeDataBase = postgres;
        }
        else if(getDbMySql().isActive()){
            return activeDataBase = mySql;
        }
        else {
            return activeDataBase = postgres;
        }
    }
}
