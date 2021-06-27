package LINTCODE8;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE709 {
    class NoTableException extends Exception{

        public NoTableException(Party p)
        {
            super("No table available for party size: " + p.getSize());
        }
    }

    class Meal {
        private float price;

        public Meal(float price)
        {
            this.price = price;
        }

        public float getPrice()
        {
            return this.price;
        }
    }

    class Order {
        private List<Meal> meals;

        public Order()
        {
            meals = new ArrayList<Meal>();
        }

        public List<Meal> getMeals()
        {
            return meals;
        }

        public void mergeOrder(Order order)
        {
            if(order != null)
            {
                for(Meal meal : order.getMeals())
                {
                    meals.add(meal);
                }
            }
        }

        public float getBill()
        {
            int bill = 0;
            for(Meal meal : meals)
            {
                bill += meal.getPrice();
            }
            return bill;
        }
    }

    class Party {
        private int size;

        public Party(int size)
        {
            this.size = size;
        }

        public int getSize()
        {
            return this.size;
        }
    }

    class Table implements Comparable<Table>{
        private int capacity;
        private boolean available;
        private Order order;

        public Table(int capacity)
        {
            this.capacity = capacity;
            available = true;
            order = null;
        }

        public int getCapacity()
        {
            return this.capacity;
        }

        public boolean isAvailable()
        {
            return this.available;
        }

        public void markAvailable()
        {
            this.available = true;
        }

        public void markUnavailable()
        {
            this.available = false;
        }

        public Order getCurrentOrder()
        {
            return this.order;
        }

        public void setOrder(Order o)
        {
            if(order == null)
            {
                this.order = o;
            }
            else
            {
                if(o != null)
                {
                    this.order.mergeOrder(o);
                } else {
                    this.order = o;
                }
            }
        }

        @Override
        public int compareTo(Table compareTable) {
            // TODO Auto-generated method stub
            return this.capacity - compareTable.getCapacity();
        }
    }

    public class Restaurant {
        private List<Table> tables;
        private List<Meal> menu;

        public Restaurant()
        {
            this.tables = new ArrayList<>();
            this.menu = new ArrayList<>();
            // Write your code here
        }

        public void findTable(Party p) throws NoTableException
        {
            int people = p.getSize();
            Table res = null;
            for(Table cur:tables){
                if(cur.isAvailable()&&cur.getCapacity()>=people&&
                        (res==null||res.getCapacity()>cur.getCapacity()))
                    res = cur;
            }
            if(res==null)
                throw new NoTableException(p);
            res.markUnavailable();
            restaurantDescription();
            // Write your code here
        }

        public void takeOrder(Table t, Order o)
        {
            t.setOrder(o);
            restaurantDescription();
            // Write your code here
        }

        public float checkOut(Table t)
        {
            t.markAvailable();
            float res = 0;
            if(t.getCurrentOrder()!=null)
                res=t.getCurrentOrder().getBill();
            t.setOrder(null);
            restaurantDescription();
            return res;
            // Write your code here
        }

        public List<Meal> getMenu()
        {
            return menu;
        }

        public void addTable(Table t)
        {
            this.tables.add(t);
            this.tables.sort((o1,o2)-> o1.getCapacity()-o2.getCapacity());
        }

        public String restaurantDescription()
        {
            // Keep them, don't modify.
            String description = "";
            for(int i = 0; i < tables.size(); i++)
            {
                Table table = tables.get(i);
                description += ("Table: " + i + ", table size: " + table.getCapacity() + ", isAvailable: " + table.isAvailable() + ".");
                if(table.getCurrentOrder() == null)
                    description += " No current order for this table";
                else
                    description +=  " Order price: " + table.getCurrentOrder().getBill();

                description += ".\n";
            }
            description += "*****************************************\n";
            return description;
        }
    }
}
