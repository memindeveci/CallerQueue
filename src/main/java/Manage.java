public class Manage {

    public Manage(){
        Center a = new Center("Call Center 1");
        Center b= new Center("Call Center 2");
        Center c= new Center("Call Center 3");
        Center d = new Center("Call Center 4");
        Center e= new Center("Call Center 5");
        Operator op = new Operator(true, "John", a);
        Caller caller = new Caller(a);
        a.startSystem();
    }


}
