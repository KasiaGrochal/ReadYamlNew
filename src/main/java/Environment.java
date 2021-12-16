public class Environment {
    public EnvironmentModel test1;
    public EnvironmentModel test2;
    public EnvironmentModel prod;
    public EnvironmentModel activeModel;


    public EnvironmentModel getTest1() {
        return test1;
    }

    public EnvironmentModel getTest2() {
        return test2;
    }

    public EnvironmentModel getProd() {
        return prod;
    }

    public EnvironmentModel getActiveEnvironment() {
        if (getTest1().isActive()) {
            return activeModel = test1;
        } else if (getTest2().isActive()) {
            return activeModel = test2;
        } else if (getProd().isActive()) {
            return activeModel = prod;
        }
        else {
            return activeModel = test1;
        }
    }
}