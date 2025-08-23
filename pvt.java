public class pvt {

    private static pvt instance;

    private pvt(){}

    public static pvt getPvt(){
        if (instance==null) {
            instance= new pvt();
        }
        return instance;
    }
}
//use to create only one object with using a private constructor

//protected keyword is used to make sure only the class that extends the parent class is used