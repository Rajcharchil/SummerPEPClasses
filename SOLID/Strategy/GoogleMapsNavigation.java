

interface NavigationStrategy {
    void navigate(String start, String end);
}

//  Driving Strategy
class DrivingStrategy implements NavigationStrategy {
    public void navigate(String start, String end) {
        System.out.println("Driving from " + start + " to " + end);
    }
}

//  Walking Strategy
class WalkingStrategy implements NavigationStrategy {
    public void navigate(String start, String end) {
        System.out.println("Walking from " + start + " to " + end);
    }
}

//  Biking Strategy
class BikingStrategy implements NavigationStrategy {
    public void navigate(String start, String end) {
        System.out.println("Biking from " + start + " to " + end);
    }
}

//  Navigator Class
class Navigator {
    private NavigationStrategy strategy;

    public Navigator(NavigationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(NavigationStrategy strategy) {
        this.strategy = strategy;
    }

    public void navigate(String start, String end) {
        if (strategy == null) {
            System.out.println("No navigation strategy set.");
        } else {
            strategy.navigate(start, end);
        }
    }
}

//  Main Class to Test
public class GoogleMapsNavigation {
    public static void main(String[] args) {
        Navigator navigator = new Navigator(new DrivingStrategy());
        navigator.navigate("Delhi", "Agra");

        navigator.setStrategy(new WalkingStrategy());
        navigator.navigate("Park", "Library");

        navigator.setStrategy(new BikingStrategy());
        navigator.navigate("Home", "Gym");
    }
}


// Output:
// Driving from Delhi to Agra
// Walking from Park to Library
// Biking from Home to Gym
// This code demonstrates the Strategy pattern where different navigation strategies can be set dynamically at runtime.
// The Navigator class uses a NavigationStrategy interface to define the navigation behavior, allowing for flexibility and      
