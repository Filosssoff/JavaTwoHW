public class JavaTwoHW1 {

    public static void main(String[] args) {
        
        int humansAmountMult = 10;
        int catsAmountMult = 10;
        int robotsAmountMult = 10;
         
        int humansAmount = (int) (Math.random() * humansAmountMult);
        int catsAmount = (int) (Math.random() * catsAmountMult);
        int robotsAmount = (int) (Math.random() * robotsAmountMult);
        
        JustDoIT testSubjects[] = new JustDoIT[humansAmount + catsAmount + robotsAmount];

        for (int ind = 0; ind < humansAmount; ind++) {
            int humanRandStamina = (int) (Math.random() * Human.getMaxStamina());
            testSubjects[ind] = new Human("testHuman " + (ind + 1), humanRandStamina);
        }
        for (int ind = humansAmount; ind < (humansAmount + catsAmount); ind++) {
            int catRandStamina = (int) (Math.random() * Cat.getMaxStamina());
            testSubjects[ind] = new Cat("testCat " + (ind + 1), catRandStamina);
        }
        for (int ind = (humansAmount + catsAmount); ind < (humansAmount + catsAmount + robotsAmount); ind++) {
            int robotRandStamina = (int) (Math.random() * Robot.getMaxStamina());
            testSubjects[ind] = new Robot("testRobot " + (ind + 1), robotRandStamina);
        }

        int wallsAmountMult = 5;
        int roadsAmountMult = 5;

        int wallsAmount = (int) (Math.random() * wallsAmountMult);
        int roadsAmount = (int) (Math.random() * roadsAmountMult);

        JustDoIT testRoute[] = new JustDoIT[wallsAmount + roadsAmount];
        for (int ind = 0; ind < wallsAmount; ind++) {
            int wallRandHeight = (int) ((Math.random() * Wall.getMaxHeight()) + 1);
            int roadRandLength = (int) ((Math.random() * Road.getMaxLength()) + 1);
            if (wallRandHeight > roadRandLength) {
                testRoute[ind] = new Wall("testWall " + (ind + 1), wallRandHeight);
            } else {
                testRoute[ind] = new Road("testWall " + (ind + 1), roadRandLength);
            }
        }

        for (int indSubj = 0; indSubj < testSubjects.length; indSubj++) {
            for (int indObst = 0; indObst < testRoute.length; indObst++) {
                if (testRoute[indObst] instanceof Road) {
                    if (testSubjects[indSubj] instanceof Human) {
                        testSubjects[indSubj].run((Road) testRoute[indObst]);
                        if (((Human) testSubjects[indSubj]).getStamina() <= 0) break;
                    } else if (testSubjects[indSubj] instanceof Cat) {
                        testSubjects[indSubj].run((Road) testRoute[indObst]);
                        if (((Cat) testSubjects[indSubj]).getStamina() <= 0) break;
                    } else if (testSubjects[indSubj] instanceof Robot) {
                        testSubjects[indSubj].run((Road) testRoute[indObst]);
                        if (((Robot) testSubjects[indSubj]).getStamina() <= 0) break;
                    }
                } else if (testRoute[indObst] instanceof Wall){
                    if (testSubjects[indSubj] instanceof Human) {
                        testSubjects[indSubj].jump((Wall) testRoute[indObst]);
                        if (((Human) testSubjects[indSubj]).getStamina() <= 0) break;
                    } else if (testSubjects[indSubj] instanceof Cat) {
                        testSubjects[indSubj].jump((Wall) testRoute[indObst]);
                        if (((Cat) testSubjects[indSubj]).getStamina() <= 0) break;
                    } else if (testSubjects[indSubj] instanceof Robot) {
                        testSubjects[indSubj].jump((Wall) testRoute[indObst]);
                        if (((Robot) testSubjects[indSubj]).getStamina() <= 0) break;
                    }
                }

            }
        }




    }
}
