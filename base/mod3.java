import java.util.Random;

class mod3 {
    public static void main(String[] args) {
        Player bot = new Player();
        Player alex = new Player(Player.VARIANTS.SCISSORS, "Alex");

        System.out.println(bot.whoWins(bot, alex));
    }
}

class Player {
    enum VARIANTS {ROCK, PAPER, SCISSORS}

    private VARIANTS variant;
    private String name;

    public Player() {
        this.variant = getRandomVariant();
        this.name = "Bot";
    }

    public Player(VARIANTS variant, String name) {
        this.variant = variant;
        this.name = name;
    }

    private VARIANTS getRandomVariant() {
        VARIANTS[] values = VARIANTS.values();
        Random random = new Random();
        return values[random.nextInt(values.length)];
    }

    public String whoWins(Player p1, Player p2) {
        if (p1.variant == p2.variant) {
            return "Ничья";
        }

        if ((p1.variant == VARIANTS.ROCK && p2.variant == VARIANTS.SCISSORS) ||
            (p1.variant == VARIANTS.SCISSORS && p2.variant == VARIANTS.PAPER) ||
            (p1.variant == VARIANTS.PAPER && p2.variant == VARIANTS.ROCK)) {
            return "Победил игрок с именем: " + p1.name;
        } else {
            return "Победил игрок с именем: " + p2.name;
        }
    }
}

