public class Robot implements JustDoIT{
    private static int MAX_STAMINA = 1000;
    private static final int STAMINA_DECREASE_RUN = 2;
    private static final int STAMINA_DECREASE_JUMP = 4;
    private static final int MAX_JUMP_HEIGHT = 10;

    private String name;
    private int stamina;

    public Robot(String name, int stamina) {
        this.name = name;
        this.stamina = stamina;
    }

    public void run() {
        System.out.println("Робот " + name + " пытается бежать");
    }

    public void jump() {
        System.out.println("Робот " + name + " пытается прыгнуть");
    }

    public void run(Road road) {
        int remDistance = road.getLength();
        for (int meter = 1; meter <= road.getLength() && stamina > 0; meter++) {
            stamina -= STAMINA_DECREASE_RUN;
            remDistance--;
        }

        if ((stamina > 0) && (remDistance == 0)) {
            System.out.println("Робот "+ name +" пробежал " + road.getLength() + " метров.");
        } else if ((stamina == 0) && (remDistance > 0)) {
            System.out.println("Робот " + name + " пробежал только " + (road.getLength() - remDistance) + " метров.");
            System.out.println("В аккумуляторах не осталось ни единой искорки.");
        } else if ((stamina == 0) && (remDistance == 0)) {
            System.out.println("Робот пробежал " + road.getLength() + " метров, полностью посадив аккумуляторы.");
        } else {
            System.out.println("Робот " + name + " выжал энергию даже из встроенных батареек вычислительных блоков.");
            System.out.println("TODO: Не забыть провести комплексное ТО.");
        }
        setStamina(stamina);
    }


    public void jump(Wall wall) {
        if (wall.getHeight() > MAX_JUMP_HEIGHT) {
            System.out.println("Несмотря на продуманную конструкцию сервоприводов, робот не сможет перепрыгнуть " + wall.getHeight() + " футов");
            System.out.println("На этом путь робота " + name + " заканчивается.");
            setStamina(0);
        } else if (wall.getHeight() <= MAX_JUMP_HEIGHT && stamina < STAMINA_DECREASE_JUMP * wall.getHeight()) {
            System.out.println("Роботу не хватит энергии, чтобы перепрыгнуть " + wall.getHeight() + " футов");
            System.out.println(name + " сходит с дистанции.");
            System.out.println("Досадно, но ничего не поделаешь");
            setStamina(0);
        } else {
            System.out.println("Робот " + name + " перепрыгнул " + wall.getHeight() + " футов");
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
