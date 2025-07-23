import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// 4. Personalized Meal Plan Generator

// Interface for Meal Plans
interface MealPlan {
    String getType();
    boolean isValid(); // Method to check if the meal plan is valid
}

// Subtypes of MealPlan
class VegetarianMeal implements MealPlan {
    @Override
    public String getType() {
        return "Vegetarian";
    }

    @Override
    public boolean isValid() {
        // Simple validation logic for demonstration
        return true;
    }

    @Override
    public String toString() {
        return "Vegetarian Meal Plan";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getType() {
        return "Vegan";
    }

    @Override
    public boolean isValid() {
        // Simple validation logic for demonstration
        return true;
    }

    @Override
    public String toString() {
        return "Vegan Meal Plan";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getType() {
        return "Keto";
    }

    @Override
    public boolean isValid() {
        // Simple validation logic for demonstration
        return true;
    }

    @Override
    public String toString() {
        return "Keto Meal Plan";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getType() {
        return "High-Protein";
    }

    @Override
    public boolean isValid() {
        // Simple validation logic for demonstration
        return true;
    }

    @Override
    public String toString() {
        return "High-Protein Meal Plan";
    }
}

// Generic class for Meal
class Meal<T extends MealPlan> {
    private T plan;
    private String description;

    public Meal(T plan, String description) {
        this.plan = plan;
        this.description = description;
    }

    public T getPlan() {
        return plan;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Meal: " + description + " (" + plan.getType() + ")";
    }
}

class MealPlanGenerator {

    // Generic method to validate and generate a personalized meal plan
    public static <T extends MealPlan> Meal<T> generateMealPlan(T userChoice, Predicate<T> validator, String description) {
        if (validator.test(userChoice)) {
            System.out.println("Generating valid " + userChoice.getType() + " meal plan...");
            return new Meal<>(userChoice, description);
        } else {
            System.out.println("Invalid " + userChoice.getType() + " meal plan. Cannot generate.");
            return null;
        }
    }

    public static void main(String[] args) {
        // User choices for meal plans
        VegetarianMeal myVegMeal = new VegetarianMeal();
        KetoMeal myKetoMeal = new KetoMeal();
        VeganMeal myVeganMeal = new VeganMeal();
        HighProteinMeal myHighProteinMeal = new HighProteinMeal();

        // Generate meal plans
        Meal<VegetarianMeal> dailyVegMeal = generateMealPlan(myVegMeal, MealPlan::isValid, "Daily Vegetarian Delight");
        if (dailyVegMeal != null) {
            System.out.println(dailyVegMeal);
        }

        Meal<KetoMeal> weeklyKetoMeal = generateMealPlan(myKetoMeal, MealPlan::isValid, "Weekly Keto Challenge");
        if (weeklyKetoMeal != null) {
            System.out.println(weeklyKetoMeal);
        }

        // Example of an invalid meal plan (if isValid() returned false for some reason)
        class InvalidMeal extends MealPlanGenerator implements MealPlan {
            @Override
            public String getType() { return "Invalid"; }
            @Override
            public boolean isValid() { return false; } // Simulating an invalid plan
            @Override
            public String toString() { return "Invalid Meal Plan"; }
        }
        Meal<InvalidMeal> badMeal = generateMealPlan(new InvalidMeal(), MealPlan::isValid, "This won't work");
        if (badMeal != null) {
            System.out.println(badMeal);
        }

        System.out.println("\n--- All Generated Meal Plans ---");
        List<Meal<? extends MealPlan>> allPlans = new ArrayList<>();
        if (dailyVegMeal != null) allPlans.add(dailyVegMeal);
        if (weeklyKetoMeal != null) allPlans.add(weeklyKetoMeal);
        if (badMeal != null) allPlans.add(badMeal);

        for (Meal<? extends MealPlan> plan : allPlans) {
            System.out.println(plan);
        }
    }
}

