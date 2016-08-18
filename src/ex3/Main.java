package ex3;

/**
 * Created by se4 on 16.08.16.
 */
public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        Player player = new Player();
        Ship ship = new Ship(4);
        field.init();

        field.setShip(ship);

        System.out.println("Game start");

        do {
            field.show();
            int shoot = player.getShoot();
            field.doShoot(shoot);
        }while(field.GameRun());

    }
}
