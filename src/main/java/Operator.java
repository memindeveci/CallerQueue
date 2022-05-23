public class Operator {
    private boolean currentStatus;
    // FALSE == stands for operator not being available
    // TRUE == stands for operator being available
    private String name;
    private Caller currentCustomer;
    private Center callCenter;

    public Operator(boolean currentStatus, String name, Center callCenter){
        this.currentStatus=currentStatus;
        this.name=name;
        callCenter.addOperator(this);
    }

    public boolean getStatus(){
        return currentStatus;
    }

    public void setCurrentStatus(boolean currentStatus){
        this.currentStatus=currentStatus;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public Caller getCaller(){
        return currentCustomer;
    }

    public void setCaller(Caller currentCustomer){
        this.currentCustomer=currentCustomer;
    }

    public void assessNewCaller(Caller a){
        if (getStatus()){
            setCaller(a);
            //a.assessToOp(this);
            setCurrentStatus(false);
        } else {
            setCaller(null);
        }
    }

    public String toString(){
        if (currentStatus){
            return name + " is available.";
        } else {
            return name + " is not available";
        }
    }


}
