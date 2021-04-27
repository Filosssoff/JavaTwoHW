public class Human implements JustDoIT {
    private static int MAX_STAMINA = 280;
    private static final int STAMINA_DECREASE_RUN = 2;
    private static final int STAMINA_DECREASE_JUMP = 7;
    private static final int MAX_JUMP_HEIGHT = 5;

    private String name;
    private int stamina;

    public Human(String name, int stamina) {
        this.name = name;
        this.stamina = stamina;
    }

    public void run() {
        System.out.println("Человек " + name + " бежит");
    }

    public void jump() {
        System.out.println("Человек " + name + " прыгает");
    }

    public void run(Road road) {
        int remDistance = road.getLength();
        for (int meter = 1; meter <= road.getLength() && stamina > 0; meter++) {
            stamina -= STAMINA_DECREASE_RUN;
            remDistance--;
        }

        if ((stamina > 0) && (remDistance == 0)) {
            System.out.println("Человек "+ name +" пробежал " + road.getLength() + " метров.");
        } else if ((stamina == 0) && (remDistance > 0)) {
            System.out.println("Человек " + name + " пробежал только " + (road.getLength() - remDistance) + " метров.");
            System.out.println("Больше сил у человека не осталось.");
        } else if ((stamina == 0) && (remDistance == 0)) {
            System.out.println("Человек пробежал " + road.getLength() + " метров и полностью выдохся.");
        } else {
            System.out.println("Человек " + name + " существенно перенапрягся.");
            System.out.println("Пожалуй, стоит отдать его тушку медикам.");
            System.out.println("Вероятно, применение электропогонялки было не лучшей идеей.");
        }
        setStamina(stamina);
    }


    public void jump(Wall wall) {
        if (wall.getHeight() > MAX_JUMP_HEIGHT) {
            System.out.println("Усреднённо-рандомный человек не сможет перепрыгнуть " + wall.getHeight() + " футов");
            System.out.println("На этом путь человека " + name + " заканчивается.");
            setStamina(0);
        } else if (wall.getHeight() <= MAX_JUMP_HEIGHT && stamina < STAMINA_DECREASE_JUMP * wall.getHeight()) {
            System.out.println("Человеку не хватит сил, чтобы перепрыгнуть " + wall.getHeight() + " футов");
            System.out.println(name + " сходит с дистанции.");
            System.out.println("Досадно, но ничего не поделаешь");
            setStamina(0);
        } else {
            System.out.println("Человек " + name + " перепрыгнул " + wall.getHeight() + " футов");
            stamina -= STAMINA_DECREASE_JUMP;
            setStamina(stamina);
        }
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public String getName() {
        return name;
    }

    public static int getMaxStamina() {
        return MAX_STAMINA;
    }

    public static int getStaminaDecreaseRun() {
        return STAMINA_DECREASE_RUN;
    }

    public static int getStaminaDecreaseJump() {
        return STAMINA_DECREASE_JUMP;
    }

    public static int getMaxJumpHeight() {
        return MAX_JUMP_HEIGHT;
    }
}
