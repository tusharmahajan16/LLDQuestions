package swiggy_zomato_design;

public class Partner {
    String name;
    Common.RATING rating;
    public Partner(String name) {
        this.name = name;
        this.rating = Common.RATING.UNASSIGNED;
    }
    public String getName() {
        return name;
    }

    //void performKyc()
}
