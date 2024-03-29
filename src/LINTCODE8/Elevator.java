package LINTCODE8;

import java.util.ArrayList;
import java.util.List;

enum Direction {
    UP, DOWN
}

enum Status {
    UP, DOWN, IDLE
}

class Request {
    private int level;

    public Request(int l)
    {
        level = l;
    }

    public int getLevel()
    {
        return level;
    }
}

class ElevatorButton {
    private int level;
    private Elevator elevator;

    public ElevatorButton(int level, Elevator e)
    {
        this.level = level;
        this.elevator = e;
    }

    public void pressButton()
    {
        InternalRequest request = new InternalRequest(level);
        elevator.handleInternalRequest(request);
    }
}

class ExternalRequest extends Request{

    private Direction direction;

    public ExternalRequest(int l, Direction d) {
        super(l);
        // TODO Auto-generated constructor stub
        this.direction = d;
    }

    public Direction getDirection()
    {
        return direction;
    }
}

class InternalRequest extends Request{

    public InternalRequest(int l) {
        super(l);
        // TODO Auto-generated constructor stub
    }
}

public class Elevator {

    private List<ElevatorButton> buttons;

    private List<Boolean> upStops;
    private List<Boolean> downStops;

    private int currLevel;
    private Status status;

    public Elevator(int n)
    {
        buttons = new ArrayList<ElevatorButton>();
        upStops = new ArrayList<Boolean>();
        downStops = new ArrayList<Boolean>();
        currLevel = 0;
        status = Status.IDLE;

        for(int i = 0; i < n; i++)
        {
            upStops.add(false);
            downStops.add(false);
        }
    }

    public void insertButton(ElevatorButton eb)
    {
        buttons.add(eb);
    }

    public void handleExternalRequest(ExternalRequest r) {
        if(r.getDirection() == Direction.UP) {
            upStops.set(r.getLevel() - 1, true);
            if(noRequests(downStops)) {
                status = Status.UP;
            }
        }
        else {
            downStops.set(r.getLevel() - 1, true);
            if(noRequests(upStops)) {
                status = Status.DOWN;
            }
        }
        // Write your code here
    }

    public void handleInternalRequest(InternalRequest r) {
        if(status == Status.UP) {
            if(r.getLevel() >= currLevel + 1) {
                upStops.set(r.getLevel() - 1, true);
            }
        }
        else if(status == Status.DOWN) {
            if(r.getLevel() <= currLevel + 1) {
                downStops.set(r.getLevel() - 1, true);
            }
        }
        // Write your code here
    }

    public void openGate() throws Exception {
        if(status == Status.UP) {
            for(int i = 0; i < upStops.size(); i++) {
                int cur = (currLevel + i) % upStops.size();
                if(upStops.get(cur)) {
                    currLevel = cur;
                    upStops.set(cur, false);
                    break;
                }
            }
        } else if(status == Status.DOWN) {
            for(int i = 0; i < downStops.size(); i++) {
                int cur = (currLevel - i+ downStops.size() ) % downStops.size();
                if(downStops.get(cur)) {
                    currLevel = cur;
                    downStops.set(cur, false);
                    break;
                }
            }
        }
        // Write your code here
    }

    public void closeGate()
    {
        if(status == Status.IDLE) {
            if(noRequests(downStops)) {
                status = Status.UP;
                return;
            }
            if(noRequests(upStops)) {
                status = Status.DOWN;
                return;
            }
        }
        else if(status == Status.UP) {
            if(noRequests(upStops)) {
                if(noRequests(downStops)) {
                    status = Status.IDLE;
                }
                else
                    status = Status.DOWN;
            }
        }
        else {
            if(noRequests(downStops)) {
                if(noRequests(upStops)) {
                    status = Status.IDLE;
                }
                else status = Status.UP;
            }
        }
        // Write your code here
    }

    private boolean noRequests(List<Boolean> stops)
    {
        for(int i = 0; i < stops.size(); i++)
        {
            if(stops.get(i))
            {
                return false;
            }
        }
        return true;
    }

    public String elevatorStatusDescription()
    {
        String description = "Currently elevator status is : " + status
                + ".\nCurrent level is at: " + (currLevel + 1)
                + ".\nup stop list looks like: " + upStops
                + ".\ndown stop list looks like:  " + downStops
                + ".\n*****************************************\n";
        return description;
    }
}