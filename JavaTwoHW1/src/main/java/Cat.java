public class Cat implements JustDoIT{
    private static final int MAX_STAMINA = 400;
    private static final int STAMINA_DECREASE_RUN = 2;
    private static final int STAMINA_DECREASE_JUMP = 4;
    private static final int MAX_JUMP_HEIGHT = 9;

    private String name;
    private int stamina;

    public Cat(String name, int stamina) {
        this.name = name;
        this.stamina = stamina;
    }

    public void run() {
        System.out.println("Котэ " + name + " бежит");
    }

    public void jump() {
        System.out.println("Котэ " + name + " прыгает");
    }

    public void run(Road road) {
        int remDistance = road.getLength();
        for (int meter = 1; meter <= road.getLength() && stamina > 0; meter++) {
            stamina -= STAMINA_DECREASE_RUN;
            remDistance--;
        }

        if ((stamina > 0) && (remDistance == 0)) {
            System.out.println("Котэ "+ name +" пробежал " + road.getLength() + " метров.");
        } else if ((stamina == 0) && (remDistance > 0)) {
            System.out.println("Котэ " + name + " пробежал только " + (road.getLength() - remDistance) + " метров.");
            System.out.println("Больше сил у котэ не осталось.");
        } else if ((stamina == 0) && (remDistance == 0)) {
            System.out.println("Человек пробежал " + road.getLength() + " метров и полностью выдохся.");
        } else {
            System.out.println("Котэ " + name + " существенно перенапрягся.");
            System.out.println("Пожалуй, стоит отдать его тушку ветеринарам.");
            System.out.println("Вероятно, применение стаи гончих было не лучшей идеей.");
        }
        setStamina(stamina);
    }


    public void jump(Wall wall) {
        if (wall.getHeight() > MAX_JUMP_HEIGHT) {
            System.out.println("Усреднённо-рандомный котэ не сможет перепрыгнуть " + wall.getHeight() + " футов");
            System.out.println("На этом путь котэ " + name + " заканчивается.");
            setStamina(0);
        } else if (wall.getHeight() <= MAX_JUMP_HEIGHT && stamina < STAMINA_DECREASE_JUMP * wall.getHeight()) {
            System.out.println("Котэ не хватит сил, чтобы перепрыгнуть " + wall.getHeight() + " футов");
            System.out.println(name + " сходит с дистанции.");
            System.out.println("Досадно, но ничего не поделаешь");
            setStamina(0);
        } else {
            System.out.println("Котэ " + name + " перепрыгнул " + wall.getHeight() + " футов");
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
