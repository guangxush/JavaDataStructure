package knowledge;


public class TestPrivate {

    public TestPrivate(){

    }
    private String method(String args){
        System.out.println("This is a private method!, the param is "+ args);
        return "hello";
    }
}

