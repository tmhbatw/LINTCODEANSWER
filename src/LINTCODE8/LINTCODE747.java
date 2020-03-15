package LINTCODE8;

public class LINTCODE747 {
    /*Description
    * 设计一个自动咖啡机，加入一袋咖啡包，简单地煮一杯咖啡。
    * 每个咖啡包包含有咖啡的配方，如加入了多少牛奶，或加入了多少糖
    * 咖啡机可根据咖啡包提供的配方制作咖啡
    * 只考虑两种成分成分：糖（sugar）和牛奶（milk）
    * 普通咖啡的成本是2元。 加入一份牛奶或糖会使成本增加0.5元
    * 考虑使用Decorator Design Pattern
    * */

    public class CoffeeMaker {

        public Coffee makeCoffee(CoffeePack pack) {
            Coffee result=new SimpleCoffee();
            for(int i=0;i<pack.getNeededMilk();i++)
                result=new WithMilk(result);
            for(int i=0;i<pack.getNeededSugar();i++)
                result=new WithSugar(result);
            return result;
            // write your code here
        }
    }

    class CoffeePack {
        private int neededMilk;
        private int neededSugar;

        public CoffeePack(int neededMilk, int neededSugar) {
            this.neededMilk = neededMilk;
            this.neededSugar = neededSugar;
        }

        public int getNeededMilk() {
            return neededMilk;
        }

        public int getNeededSugar() {
            return neededSugar;
        }
    }

    interface Coffee {
        public double getCost();
        public String getIngredients();
    }

    class SimpleCoffee implements Coffee {

        @Override
        public double getCost() {
            // TODO Auto-generated method stub
            return 2;
        }

        @Override
        public String getIngredients() {
            // TODO Auto-generated method stub
            return "Plain Coffee";
        }

    }

    abstract class CoffeeDecorator implements Coffee {
        protected final Coffee decoratedCoffee;

        public CoffeeDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }

        public double getCost() {
            return decoratedCoffee.getCost();
        }

        public String getIngredients() {
            return decoratedCoffee.getIngredients();
        }
    }

    class WithMilk extends CoffeeDecorator {

        public WithMilk(Coffee coffee) {
            super(coffee);
        }

        public double getCost() {
            return super.getCost() + 0.5;
        }

        public String getIngredients() {
            return super.getIngredients() + ", Milk";
        }
    }

    class WithSugar extends CoffeeDecorator {

        public WithSugar(Coffee coffee) {
            super(coffee);
        }

        public double getCost() {
            return super.getCost() + 0.5;
        }

        public String getIngredients() {
            return super.getIngredients() + ", Sugar";
        }
    }
}
