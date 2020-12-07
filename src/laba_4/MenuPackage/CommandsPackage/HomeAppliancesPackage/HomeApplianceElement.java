package laba_4.MenuPackage.CommandsPackage.HomeAppliancesPackage;

public abstract class HomeApplianceElement implements Comparable<HomeApplianceElement> {// інтерфейс Comparable. В ньому оголошено всього один метод, compareTo:

    protected String name;
    protected double weight;
    protected int power;
    protected int quality;
    protected int sortBy;
    protected boolean active=false;
    private long m=0;
    protected double time=0;

    public HomeApplianceElement(String name, double weight, int power, int quality) {
        this.name = name;
        this.power = power;
        this.weight = weight;
        this.quality = quality;
        sortBy = 1;
    }
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPower() {
        return power;
    }
    public double getTime() {
        return time;
    }

    public int getQuality() {
        return quality;
    }

    public int getSortPriority() {
        return sortBy;
    }

    public void setSortPriority(int sortBy) {
        this.sortBy = sortBy;
    }

    public void setActive(boolean active){
        this.active=active;
        m = System.currentTimeMillis();
    }
    public void Stop(){
        time +=(double)(System.currentTimeMillis()-m)/1000;
        active=false;
    }
    public boolean getActive(){return active;}

    @Override
    public int compareTo(HomeApplianceElement element) {
        switch (Math.abs(sortBy)) {
            case 1: {
                if(sortBy > 0) {
                    return name.compareTo(element.name);
                }
                else {
                    return name.compareTo(element.name) * -1;
                }

            }
            case 2: {
                if(sortBy > 0) {
                    return Double.compare(power, element.power);
                }
                else {
                    return Double.compare(power, element.power) * -1;
                }

            }
            case 3: {
                if(sortBy > 0) {
                    return Double.compare(weight, element.weight);
                }
                else {
                    return Double.compare(weight, element.weight) * -1;
                }

            }
            case 4: {
                if(sortBy > 0) {
                    return Integer.compare(quality, element.quality);
                }
                else {
                    return Integer.compare(quality, element.quality) * -1;
                }
            }
            default: {
                return 0;
            }
        }
    }//>0 якщо викликає об'єкт більше об'єкта, переданого в якості параметра;
    //<0, якщо викликає об'єкт менше об'єкта, переданого в якості параметра;
    //=0, якщо об'єкти рівні.
}
