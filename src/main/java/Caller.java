import java.util.Stack;

public class Caller {

    private boolean isAssessed = false;
    private Operator assessedOperator;
    private Center wantedCenter;

    // is assessed to an operator --> TRUE
    // is not assessed to an operator --> FALSE

    public Caller(Center wantedCenter){
        wantedCenter.addCaller(this);
        assessedOperator=null;
    }

    public void setIsAssessed(boolean assess){
        isAssessed = assess;
    }

    public void assessToOp(Operator a){
        if(a.getStatus()){
            assessedOperator=a;
            //a.assessNewCaller(this);
            setIsAssessed(true);
        } else {
            assessedOperator=null;
        }
    }

    public String toString(){
        if (isAssessed) {
            return "Caller is assessed to " + assessedOperator.getName();
        } else {
            return "Caller is not assessed yet.";
        }
    }

}
