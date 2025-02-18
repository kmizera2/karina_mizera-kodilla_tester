public class Notebook {
    int weight;
    int price;
    int year;

    public Notebook (int weight, int price, int year){
        this.weight=weight;
        this.price=price;
        this.year=year;
    }

    public void checkPrice () {
        if (this.price < 600)
            System.out.println("This notebook is very cheap.");
        else if (this.price <= 1000)
            System.out.println("The price is good.");
        else
            System.out.println("This notebook is expensive.");
    }

    public void checkWeight () {
        if (this.weight < 1000)
            System.out.println("This machine is light.");
        else if (this.weight < 2000)
            System.out.println("This machine is not that heavy.");
        else
            System.out.println("This machine is very heavy.");
    }

    public void checkYearAndPrice () {
        if (this.price < 0)
            System.out.println("There is an incorrect price");
        else if (this.price==0)
            System.out.println("This machine is for free, year doesn't matter");
        else if (this.price < 600 && this.year<2000)
            System.out.println("This notebook is very cheap but very old");
        else if (this.price < 600 && this.year<2020)
            System.out.println("This notebook is very cheap and old");
        else if (this.price <= 1000 && this.year<=2020)
            System.out.println("The price is good but check machine parameters, can be not good enough for you.");
        else
            System.out.println("This notebook is not real.");
    }
}
