import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Stack;

public class Center {
    public ArrayList <Operator> operators;
    public Stack<Caller> queueList;
    //the instances for callers on the queue and operators in the call center
    private String name;
    public Center(String name){
        this.name=name;
        operators = new ArrayList <Operator>();
        queueList = new Stack <Caller>();
    }

    public void addOperator(Operator a){
        operators.add(a);
    }

    public Operator getOperator(int a){
        return operators.get(a);
    }

    public Caller getCaller(int a){
        return queueList.get(a);
    }

    public Stack<Caller> getQueueList(){
        return queueList;
    }

    public void addCaller(Caller a){
        queueList.push(a);
    }

    public void startSystem(){
        int caller;
        while(!queueList.isEmpty()){
            caller=(int)(Math.random()* operators.size());
            operators.get(caller).assessNewCaller(queueList.get(0));
            queueList.get(0).assessToOp(operators.get(caller));
            System.out.println("Caller is assigned to " + operators.get(0).getName());
            queueList.remove(0);

            /*if (operators.get(caller).getStatus()){
                operators.get(caller).assessNewCaller(queueList.get(0));
                queueList.remove(0);
            }*/

            int notAvailable=0;
            for (int i = 0; i < operators.size(); i++) {
                if(!operators.get(i).getStatus()){
                    notAvailable++;
                }
            }

            if (notAvailable== operators.size()){
                System.out.println("There are no operators available in " + name);
                break;
            }
        }
        if (queueList.isEmpty()){
            System.out.println("There is no one in the queue right now in " + name);
        }
    }
}
