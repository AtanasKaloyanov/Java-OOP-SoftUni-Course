package football.entities.field;

import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSupplements(Collection<Supplement> supplements) {
        this.supplements = supplements;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    @Override
    public int sumEnergy() {
        int energySum = supplements.stream().mapToInt(element -> element.getEnergy()).sum();
        return energySum;
    }

    @Override
    public void addPlayer(Player player) {
        if (capacity <= players.size()) {
            throw new IllegalStateException("Not enough capacity.");
        }

        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
         players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
     supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s (%s):", name, getClass().getSimpleName()));
        sb.append("\n");

        if (players.isEmpty()) {
            sb.append("Player: none");
        } else {
            sb.append(String.format("Player: %s", players.toString().replaceAll("[\\[\\],]", "")));
        }

        sb.append("\n");

        sb.append(String.format("Supplement: %d", supplements.size()));
        sb.append("\n");

        sb.append(String.format("Energy: %d", supplements.stream().mapToInt(element -> element.getEnergy()).sum()));

        return sb.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplement() {
        return supplements;
    }

    @Override
    public String getName() {
        return name;
    }
}
